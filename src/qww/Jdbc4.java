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
			//选择数据库的种类
			Class.forName("com.mysql.jdbc.Driver");
			//建立连接 主机IP 端口号  用户名  密码//选择数据库
			con =DriverManager.getConnection(url,user,password);
			
			//建立窗口(写sql语句)
			pst =con.prepareStatement("insert into student2(name,b_id) values(?,?)");
			//注入参数
			pst.setString(1, "张桐");
			pst.setInt(2, 8);
			
			//执行语句
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
