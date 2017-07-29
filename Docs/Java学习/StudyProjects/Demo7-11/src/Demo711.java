
import java.util.List;

import com.sqj.db.SqlHelper;
import com.sql.*;
import com.sql.entity.Country;


public class Demo711 {
    static SqlHelper sqlHelper=SqlHelper.getInstance();
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Country ct=new Country();
		ct.set_code("TWN");
		ct.set_name("Taiwan11");
		ct.set_surfaceArea(36188.88f);
		ct.set_region("Eastern Asia");
		sqlHelper.modify(ct);*/
		sqlHelper.delete("TWN");
		query();
	}

	private static void query() {
		System.out.println("编号\t\t国家名称\t\t地域面积\t\t所在区域 ");
		
		List<Country> list=sqlHelper.getList();
		if(list!=null)
		{
			for (Country country : list) {
				System.out.println(country.get_code()+"\t"+country.get_name()+"\t"+country.get_surfaceArea()+"\t"+country.get_region());
			}
			
		}
	}

}
