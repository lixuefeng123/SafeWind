package bean;

import java.sql.SQLException;
import java.util.List;

import tool.DBTool;

/** 
 * CopyRright (c)2014-:   ����У���Ƽ����޹�˾ 
 * Project:                                         
 * Module ID: GradeDao
 * Comments:                                             
 * JDK version used:      JDK1.7                              
 * Author��       ��ѩ��                 
 * Create Date��  2014��11��26�� 
 * Modified By��                                           
 * Modified Date:                                      
 * Why & What is modified      
 * Version: 1.0                       
 */

public class GradeDao {
	private static DBTool dbtool=new DBTool();
	
	public static int add(Grade cou){
		String sql = "insert into grade(id,name,class1,class2,class3,class4) values(";
		StringBuffer strSql=new StringBuffer(sql);
		strSql.append("'"+cou.getId()+"'");
		strSql.append(",'"+cou.getName()+"'");
		strSql.append(",'"+cou.getClass1()+"'");
		strSql.append(",'"+cou.getClass2()+"'");	
		strSql.append(",'"+cou.getClass3()+"'");	
		strSql.append(",'"+cou.getClass4()+"')");
		//System.out.println(strSql.toString());
		return dbtool.executeUpdateFromSt(strSql.toString());
		
	}
	public static List<Grade> selectAll(){
		String sql = "select id,name,class1,class2,class3,class4 from grade order by id";
		List<Grade> list = dbtool.executeQueryFromST(sql);
		return list;
	}
	public static List<Grade> selectOne(String b2){
		String b = b2;
		//System.out.println(b);
		String sql = "select * from grade where id = '"+b+"'";
		List<Grade> list = dbtool.executeQueryFromST(sql);
		return list;
	}
}
