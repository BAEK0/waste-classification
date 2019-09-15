

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import com.mysql.jdbc.Driver;


public class modify {
	
	@Test 
	public void updata() {
		Connection conn=null;
		Statement st=null;
		ResultSet rs=null;
		try {
//1.注册驱动
		Class.forName("com.mysql.jdbc.Driver");
//2.获取数据库连接
		String ur1="jdbc:mysql://localhost:3306/jt_fl";
		String user="root";//用户名
		String password="";//密码
		conn=DriverManager.getConnection(ur1, user, password);
//3.获取传输器
		 st=conn.createStatement();
//4.执行SQL
		 String sql="update laji set sort='湿垃圾'  where name='瓜子皮'";
		 st.executeUpdate(sql);
//5.遍历结果集
		 System.out.println(st);
	} catch (Exception e) {
		e.printStackTrace();
	}finally {               
//6.关闭资源
		//关闭结果集资源
		if(rs!=null) {//防止空指针异常
		try {
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//关闭传输器资源
		if(st!=null) {
			try {
				st.close();
				} catch (SQLException e) {
					e.printStackTrace();
					}
		//关闭数据库连接资源
		if(conn!=null) {
			try {
				conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		}
		}
	}
	}
}

