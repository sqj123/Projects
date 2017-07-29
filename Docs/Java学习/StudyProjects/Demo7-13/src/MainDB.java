import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class MainDB {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
		  String dbURL="jdbc:sqlserver://localhost:1433;DatabaseName=Student";
		  String userName="sa";
		  String userPwd="sqj";
		  try
		  {
		   Class.forName(driverName);
		   Connection dbConn=DriverManager.getConnection(dbURL,userName,userPwd);
		   
		   PreparedStatement pStatement=dbConn.prepareStatement("select count(1) from stu_info");
		   ResultSet rSet = pStatement.executeQuery();
		   if(rSet.next())
			   System.out.println(rSet.getInt(1));
		    System.out.println("连接数据库成功");
		  }
		  catch(Exception e)
		  {
		   e.printStackTrace();
		   System.out.print("连接失败");
		  }    
	}

}
