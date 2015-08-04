package tool;

/** 
 * CopyRright (c)2014-:   大连校联科技有限公司 
 * Project:                                         
 * Module ID: DBTool
 * Comments:                                             
 * JDK version used:      JDK1.7                              
 * Author：       李雪峰                 
 * Create Date：  2014年11月26日 
 * Modified By：                                           
 * Modified Date:                                      
 * Why & What is modified      
 * Version: 1.0                       
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import bean.Grade;
public class DBTool {
	static int x =0;
	private Connection conn = null;

	//private String databaseName = "student_db";
	private String url = "jdbc:mysql://localhost:3306/safewind" ;
	//private String url = "jdbc:mysql://r.rdc.sae.sina.com.cn:3307/app_lxf001";
	private String userName = "root";
	private String pass = "root";
	private PreparedStatement ps = null;
	private Statement st = null;
	private ResultSet rs = null;

	// 加载驱动
	static {
		// 静态语句块
		try {
		 
			Class.forName("com.mysql.jdbc.Driver");
			//Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.err.println("加载驱动出现异常");
		}

	}

	// 创建连接
	public Connection getConn() {
		try {
			conn = DriverManager.getConnection(url, userName, pass);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return conn;

	}
	
	// 更新的方法
	
	public int executeUpdateFromSt(String sql) {
		int temp = -1;
		 
			
	 
		try {
			if (conn == null||conn.isClosed()) {
				getConn();
			}
			st = conn.createStatement();

			temp = st.executeUpdate(sql);

		} catch (SQLException e) {
			System.err.println(e);
		} finally {
			release();
		}

		return temp;

	}

	// 预处理更新方法

	public int executeUpdateFromPS(String sql, String[] params) {
		int temp = -1;
	 
		try {
			if (conn == null||conn.isClosed()) {
				getConn();
			}
			ps = conn.prepareStatement(sql);
			ParameterMetaData pmd = ps.getParameterMetaData();
			int parameterCount = pmd.getParameterCount();
			for (int i = 1; i <= parameterCount; i++) {
				ps.setString(i, params[i - 1]);
			}

			temp = ps.executeUpdate();

		} catch (SQLException e) {
			System.err.println("预处理执行更新出现异常");
		} finally {
			release();
		}

		return temp;

	}

	//预处理 查询
	public List<Map<String, Object>> executeQueryFromPS(String sql,
			String[] params) {
		List<Map<String, Object>> resultsList = new ArrayList<Map<String, Object>>();

	 
		try {
			if (conn == null||conn.isClosed()) {
				getConn();
			}
			ps = conn.prepareStatement(sql);
			ParameterMetaData pmd = ps.getParameterMetaData();
			int parameterCount = pmd.getParameterCount();
			for (int i = 1; i <= parameterCount; i++) {
				ps.setString(i, params[i - 1]);
			}
			rs = ps.executeQuery();

			ResultSetMetaData rsmd = rs.getMetaData();

			int columnCount = rsmd.getColumnCount();

			while (rs.next()) {
				Map<String, Object> map = new HashMap<String, Object>();
				for (int i = 1; i <= columnCount; i++) {

					Object value = rs.getObject(i);
					String key = rsmd.getColumnName(i);
					map.put(key, value);

				}

				resultsList.add(map);
			}

		} catch (SQLException e) {
			System.err.println("预处理查询出现异常");
		} finally {
			release();
		}

		return resultsList;
	}
	
	
	
	//普通 查询
	public List<Grade> executeQueryFromST(String sql) {
		List<Grade> resultsList = new ArrayList<Grade>();

		 
		try {
			if (conn == null||conn.isClosed()) {
				getConn();
			}
			st=conn.createStatement();
				 
			 
			rs = st.executeQuery(sql);


			while (rs.next()) {
				Grade cou = new Grade();
				cou.setId(rs.getString(1));
				cou.setName(rs.getString(2));
				cou.setClass1(Integer.parseInt(rs.getString(3)));
				cou.setClass2(Integer.parseInt(rs.getString(4)));
				cou.setClass3(Integer.parseInt(rs.getString(5)));
				cou.setClass4(Integer.parseInt(rs.getString(6)));
				resultsList.add(cou);
			}

		} catch (SQLException e) {
			System.err.println("普通查询出现异常");
			System.out.println( e);
		} finally {
			release();
		}

		return resultsList;
	}
	public void release() {

		try {
			if (rs != null) {
				rs.close();
			}

			if (ps != null) {
				ps.close();
			}
			if (st != null) {
				st.close();
			}
			if (conn != null) {
				conn.close();
			}

		} catch (SQLException e) {
			System.err.println("关闭资源出现异常");
		}

	}
}
