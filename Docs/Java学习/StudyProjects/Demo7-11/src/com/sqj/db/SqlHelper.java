package com.sqj.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sql.entity.Country;

public class SqlHelper implements ISqlHelper {
	public Connection connection = null;
	public ResultSet resultSet = null;
	public PreparedStatement pStatement = null;
	public Statement statement=null;
	public static SqlHelper sqlHelper = null;

	public static SqlHelper getInstance() {
		if (sqlHelper == null)
			return new SqlHelper();
		else {
			return sqlHelper;
		}
	}

	@Override
	public void getDbConnect() {
		// ����������
		String driver = "com.mysql.jdbc.Driver";
		// URLָ��Ҫ���ʵ����ݿ���mydata
		String url = "jdbc:mysql://localhost:3306/world?characterEncoding=utf8&useSSL=false";
		// MySQL����ʱ���û���
		String user = "root";
		// MySQL����ʱ������
		String password = "hellosqj";
		// ������ѯ�����
		try {
			// ������������
			Class.forName(driver);
			// 1.getConnection()����������MySQL���ݿ⣡��
			connection = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
		}
	}

	@Override
	public List<Country> getList() {
		getDbConnect();
		// 2.����statement���������ִ��SQL��䣡��
		List<Country> list = new ArrayList<Country>();
		try {
			statement = connection.createStatement();
			// Ҫִ�е�SQL���
			String sql = "select * from country where region like '%asia%'";
			// 3.ResultSet�࣬������Ż�ȡ�Ľ��������
			resultSet = pStatement.executeQuery(sql);
			Country ct;
			while (resultSet.next()) {
				ct = new Country();
				ct.set_code(resultSet.getString("code"));
				ct.set_name(resultSet.getString("name"));
				ct.set_region(resultSet.getString("region"));
				ct.set_surfaceArea(resultSet.getFloat("surfaceArea"));
				list.add(ct);
			}
		} catch (Exception e) {
			return null;
		} finally {
			close();
		}

		return list;
	}

	@Override
	public int addNew(Object t) {
		int iRet = 0;
		// Ԥ����������ݣ���������������--������
		getDbConnect();
		Country ct = (Country) t;
		try {

			pStatement = connection
					.prepareStatement("insert into Country (code,name,region,surfacearea) "
							+ "values(?,?,?,?)");
			pStatement.setString(1, ct.get_code()); 
			pStatement.setString(2, ct.get_name());
			pStatement.setString(3, ct.get_region());
			pStatement.setFloat(4, ct.get_surfaceArea());
			iRet = pStatement.executeUpdate(); // ִ�и���
		} catch (Exception e) {

		} finally {
			close();
		}
		return iRet;
	}

	@Override
	public boolean modify(Object t) {
		int iRet = 0;
		Country ct = (Country) t;
		try {
			getDbConnect();
			String sqlString = "update country set name=?,surfacearea=?,region=? where code=?";
			pStatement = connection.prepareStatement(sqlString);
			pStatement.setString(1, ct.get_name());
			pStatement.setFloat(2, ct.get_surfaceArea());
			pStatement.setString(3, ct.get_region());
			pStatement.setString(4, ct.get_code());
			iRet = pStatement.executeUpdate();
		} catch (Exception e) {
			iRet = 0;
		} finally {
			close();
		}
		return iRet > 0;
	}

	@Override
	public boolean delete(String code) {		
		int iRet = 0;
		try {
			getDbConnect();
			pStatement = connection
					.prepareStatement("delete from country where code =?");
			pStatement.setString(1, code);
			iRet = pStatement.executeUpdate();
		} catch (Exception e) {

		} finally {
			close();
		}
		return iRet > 0;
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		try {
			if (resultSet != null)
				resultSet.close();
			if (pStatement != null)
				pStatement.close();
			if (connection != null)
				connection.close();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
