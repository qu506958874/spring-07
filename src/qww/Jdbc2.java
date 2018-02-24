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
			//选择使用的数据库种类
			Class.forName("com.mysql.jdbc.Driver");
			//建立连接 主机IP 端口号 用户名 密码//选择数据库
			con = DriverManager.getConnection(url, user, password);
			
			
			//创建窗口(写sql语句)
			pst=con.prepareStatement("select * from student2");
			//运行sql语句  如果是增删改则返回受影响的行数  如果是查询则返回的是查询结果
			//运行时注意  如果是增删改则调用executeUpdate 返回int(受影响的行数) 如果是查询则调用executeQuery 返回ResultSet
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
