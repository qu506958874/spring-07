package qww;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Jdbc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//格式   jdbc:mysql://主机IP:端口号/数据库名
		String url="jdbc:mysql://192.168.2.188:3306/qww";
		String user="root";
		String password="123456";
		ResultSet rs=null;
		PreparedStatement pst=null;
		Connection con=null;
		try {
			//选择要操作的数据库种类--加载驱动(反射)
			Class.forName("com.mysql.jdbc.Driver");
			//创建连接  主机IP  端口号  用户名  密码//选择要操作的数据库
			con= DriverManager.getConnection(url, user, password);
			
			
			//创建命令窗口(写sal语句)
			pst = con.prepareStatement("select * from student2");
			//运行sql语句并查看结果  如果是增删改  则返回的是受影响的行数   如果是查询  则返回的是查询结果
			//运行的时候注意  如果是增删改则调用executeUpdate 返回int(受影响的行数)  如果是查询则调用executeQuery 返回ResultSet
			rs = pst.executeQuery();
			//查看结果集
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
