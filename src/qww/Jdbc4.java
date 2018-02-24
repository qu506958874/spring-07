package qww;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Jdbc4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url="jdbc:mysql://192.168.2.188:3306/qww?useUnicode=true&characterEncoding=utf8";
		String user="root";
		String password="123456";
		Connection con=null;
		PreparedStatement pst=null;
		try {
			//ѡ�����ݿ������
			Class.forName("com.mysql.jdbc.Driver");
			//�������� ����IP �˿ں�  �û���  ����//ѡ�����ݿ�
			con =DriverManager.getConnection(url,user,password);
			
			//��������(дsql���)
			pst =con.prepareStatement("insert into student2(name,b_id) values(?,?)");
			//ע�����
			pst.setString(1, "��ͩ");
			pst.setInt(2, 8);
			
			//ִ�����
			int i=pst.executeUpdate();
			System.out.println(i);
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try {
				if(pst!=null)
					pst.close();
				if(con!=null)
					con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
