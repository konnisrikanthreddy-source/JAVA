package firstproject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
public class DataBaseOperations extends Student {
	private Connection conn;
	void connectDataBase() 
	{
		try {
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sritw_db", "root", "root");
		System.out.println("DataBase Connected");
		}
		catch(SQLException e)
		{
			System.out.println("DataBase Not Connected");
			e.printStackTrace();
		}
	}
	public void insert() throws SQLException
	{
		String sql = "INSERT INTO student(htno, name, branch, address, mobile) VALUES (?, ?, ?, ?, ?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		for(int i=0;i<n;i++)
		{
			ps.setInt(1, s[i].getHtno());
			ps.setString(2,s[i].getName());
			ps.setString(3,s[i].getBranch());
			ps.setString(4,s[i].getAddress());
			ps.setString(5, s[i].getMobile());
			ps.executeUpdate();
		}
		System.out.println("Student Details inserted");
	}
	public void display() throws SQLException
	{
		String sql="SELECT * FROM student";
		PreparedStatement ps=conn.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		System.out.println("H.T.No\tName\t\tBranch\tAddress\tMobile");
		System.out.println("-----------------------------------------");
		while(rs.next())
		{
			System.out.println(
					rs.getInt("htno")+"\t"+
					rs.getString("name")+"\t\t"+
					rs.getString("branch")+"\t"+
					rs.getString("address")+"\t"+
					rs.getString("mobile")+"\t");
		}
	}
	public void delete(int ht) throws SQLException
	{
		String sql="DELETE FROM student WHERE htno=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setInt(1, ht);
		ps.executeUpdate();
		System.out.println("Student H.T.No. "+ht+" data deleted");
	}
	
}
