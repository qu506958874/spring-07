package qww;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Jdbc2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url="jdbc:mysql://192.168.2.188:3306/qww";
		String user="root";
		String password="123456";
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		try {
			//ѡ��ʹ�õ����ݿ�����
			Class.forName("com.mysql.jdbc.Driver");
			//�������� ����IP �˿ں� �û��� ����//ѡ�����ݿ�
			con = DriverManager.getConnection(url, user, password);
			
			
			//��������(дsql���)
			pst=con.prepareStatement("select * from student2");
			//����sql���  �������ɾ���򷵻���Ӱ�������  ����ǲ�ѯ�򷵻ص��ǲ�ѯ���
			//����ʱע��  �������ɾ�������executeUpdate ����int(��Ӱ�������) ����ǲ�ѯ�����executeQuery ����ResultSet
			rs=pst.executeQuery();
			while(rs.next()){
				System.out.println(rs.getInt("id")+"   "+rs.getString("name"));
			}
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			
				try {
					if(rs!=null)
						rs.close();
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
