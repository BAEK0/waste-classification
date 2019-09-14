import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.mysql.jdbc.Driver;

public class DatabaseManager {
	public String getGarbageType(String name){
		Connection conn1=null;
		Statement st1=null;
		ResultSet rs1=null;
		try {
//1.注册驱动com.mysql.jdbc.Driver
			DriverManager.registerDriver(new Driver());
//2.获取数据库连接java.sql.Connection
			String ur1="jdbc:mysql://localhost:3306/jt_fl";
			String user="root";
			String password="";
			conn1=DriverManager.getConnection(ur1, user, password);
//3.获取传输器java.sql.Statement
			st1=conn1.createStatement();
//4.执行SQL
			String sql="select sort from laji where name=\""+ name + "\"";
			rs1=st1.executeQuery(sql);//executeQuery用来执行查询的SQL
//5.遍历结果集
			while(rs1.next()) {
			//next 判断是否有数据，有数据指针向下移动，返回true
				String sort = rs1.getString("sort");
				return sort;
				
			}
			return "";//没有查询到数据
	} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}finally {               //保证资源一定会被释放
//6.关闭资源
		//关闭结果集资源
		if(rs1!=null) {//防止空指针异常
		try {
			rs1.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//关闭传输器资源
		if(st1!=null) {
		try {
			st1.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//关闭数据库连接资源
		if(conn1!=null) {
		try {
			conn1.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		}
		}
	}
return "数据库查询异常";
	}
	
	
	
	public String addGarbageType(String name,String sort){
		Connection conn2=null;
		Statement st2=null;
		ResultSet rs2=null;
		try {
//1.注册驱动com.mysql.jdbc.Driver
			DriverManager.registerDriver(new Driver());
//2.获取数据库连接java.sql.Connection
			String ur1="jdbc:mysql://localhost:3306/jt_fl";
			String user="root";
			String password="";
			conn2=DriverManager.getConnection(ur1, user, password);
//3.获取传输器java.sql.Statement
			st2=conn2.createStatement();
			//4.执行SQL
			 String sql="insert into laji values('"+name+"','"+sort+"')";
			 int rows=st2.executeUpdate(sql);
	//5.遍历结果集
			 System.out.println(rows);
		} catch (Exception e) {
			e.printStackTrace();
	
	}finally {               //保证资源一定会被释放
//6.关闭资源
		//关闭结果集资源
		if(rs2!=null) {//防止空指针异常
		try {
			rs2.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//关闭传输器资源
		if(st2!=null) {
		try {
			st2.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//关闭数据库连接资源
		if(conn2!=null) {
		try {
			conn2.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		}
		}
	}
return "数据库异常";
	}
}
	
	
	
	
	
