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
//1.ע������com.mysql.jdbc.Driver
			DriverManager.registerDriver(new Driver());
//2.��ȡ���ݿ�����java.sql.Connection
			String ur1="jdbc:mysql://localhost:3306/jt_fl";
			String user="root";
			String password="";
			conn1=DriverManager.getConnection(ur1, user, password);
//3.��ȡ������java.sql.Statement
			st1=conn1.createStatement();
//4.ִ��SQL
			String sql="select sort from laji where name=\""+ name + "\"";
			rs1=st1.executeQuery(sql);//executeQuery����ִ�в�ѯ��SQL
//5.���������
			while(rs1.next()) {
			//next �ж��Ƿ������ݣ�������ָ�������ƶ�������true
				String sort = rs1.getString("sort");
				return sort;
				
			}
			return "";//û�в�ѯ������
	} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}finally {               //��֤��Դһ���ᱻ�ͷ�
//6.�ر���Դ
		//�رս������Դ
		if(rs1!=null) {//��ֹ��ָ���쳣
		try {
			rs1.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//�رմ�������Դ
		if(st1!=null) {
		try {
			st1.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//�ر����ݿ�������Դ
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
return "���ݿ��ѯ�쳣";
	}
	
	
	
	public String addGarbageType(String name,String sort){
		Connection conn2=null;
		Statement st2=null;
		ResultSet rs2=null;
		try {
//1.ע������com.mysql.jdbc.Driver
			DriverManager.registerDriver(new Driver());
//2.��ȡ���ݿ�����java.sql.Connection
			String ur1="jdbc:mysql://localhost:3306/jt_fl";
			String user="root";
			String password="";
			conn2=DriverManager.getConnection(ur1, user, password);
//3.��ȡ������java.sql.Statement
			st2=conn2.createStatement();
			//4.ִ��SQL
			 String sql="insert into laji values('"+name+"','"+sort+"')";
			 int rows=st2.executeUpdate(sql);
	//5.���������
			 System.out.println(rows);
		} catch (Exception e) {
			e.printStackTrace();
	
	}finally {               //��֤��Դһ���ᱻ�ͷ�
//6.�ر���Դ
		//�رս������Դ
		if(rs2!=null) {//��ֹ��ָ���쳣
		try {
			rs2.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//�رմ�������Դ
		if(st2!=null) {
		try {
			st2.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//�ر����ݿ�������Դ
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
return "���ݿ��쳣";
	}
}
	
	
	
	
	
