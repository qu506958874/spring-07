package qww;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Jdbc3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url="jdbc:mysql://192.168.2.188:3306/qww?useUnicode=true&characterEncoding=utf8";
		String user="root";
		String password="123456";
		Connection con=null;
		PreparedStatement pst=null;
		String name="input";
		try {
			//选择数据库的种类
			Class.forName("com.mysql.jdbc.Driver");
			//建立连接 主机IP 端口号  用户名 密码//选择数据库
			con =DriverManager.getConnection(url, user, password);
			
			
			//创建窗口(写sql语句)
			pst =con.prepareStatement("insert into student2(name,b_id) values(?,?)");
			
			//注入参数(给问号赋值)
			pst.setString(1, "志超");
			pst.setInt(2, 7);
			
			
			//执行sql语句  如果是增删改则返回受影响的行数  如果是查询则返回查询结果
			//运行的时候注意  如果是增删改则调用executeUpdate 返回int(受影响的行数)  如果是查询则调用executeQuery 返回ResultSet
			int i =pst.executeUpdate();
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
