package qww;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Jdbc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//��ʽ   jdbc:mysql://����IP:�˿ں�/���ݿ���
		String url="jdbc:mysql://192.168.2.188:3306/qww";
		String user="root";
		String password="123456";
		ResultSet rs=null;
		PreparedStatement pst=null;
		Connection con=null;
		try {
			//ѡ��Ҫ���������ݿ�����--��������(����)
			Class.forName("com.mysql.jdbc.Driver");
			//��������  ����IP  �˿ں�  �û���  ����//ѡ��Ҫ���������ݿ�
			con= DriverManager.getConnection(url, user, password);
			
			
			//���������(дsal���)
			pst = con.prepareStatement("select * from student2");
			//����sql��䲢�鿴���  �������ɾ��  �򷵻ص�����Ӱ�������   ����ǲ�ѯ  �򷵻ص��ǲ�ѯ���
			//���е�ʱ��ע��  �������ɾ�������executeUpdate ����int(��Ӱ�������)  ����ǲ�ѯ�����executeQuery ����ResultSet
			rs = pst.executeQuery();
			//�鿴�����
			while(rs.next()){
				System.out.println(rs.getInt("id")+"  "+rs.getString("name"));
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
