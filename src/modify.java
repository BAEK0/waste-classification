

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
//1.ע������
		Class.forName("com.mysql.jdbc.Driver");
//2.��ȡ���ݿ�����
		String ur1="jdbc:mysql://localhost:3306/jt_fl";
		String user="root";//�û���
		String password="";//����
		conn=DriverManager.getConnection(ur1, user, password);
//3.��ȡ������
		 st=conn.createStatement();
//4.ִ��SQL
		 String sql="update laji set sort='ʪ����'  where name='����Ƥ'";
		 st.executeUpdate(sql);
//5.���������
		 System.out.println(st);
	} catch (Exception e) {
		e.printStackTrace();
	}finally {               
//6.�ر���Դ
		//�رս������Դ
		if(rs!=null) {//��ֹ��ָ���쳣
		try {
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//�رմ�������Դ
		if(st!=null) {
			try {
				st.close();
				} catch (SQLException e) {
					e.printStackTrace();
					}
		//�ر����ݿ�������Դ
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

