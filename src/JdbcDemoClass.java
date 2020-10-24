import java.sql.*;
public class JdbcDemoClass {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		String url="jdbc:mysql://localhost:3306/lch_marketplace";
		String username="root";
		String pass="J35u5Ch6!5T";
		String var2="JIJI";
		int var1=6;
		String query="select * from menuitem";
		//String query="insert into student values(?,?)";
   Class.forName("com.mysql.cj.jdbc.Driver");
   Connection con=DriverManager.getConnection(url,username,pass);
   Statement st= con.createStatement();
   //PreparedStatement st=con.prepareStatement(query);
//   st.setInt(1, var1);
//   st.setString(2, var2);
   //Statement st=con.createStatement();
 // int count =st.executeUpdate();
   ResultSet rs=st.executeQuery(query);
  while( rs.next()) {
 long name=rs.getLong(1);
   System.out.println(name);
   }
  // System.out.println(count);

   st.close();
   con.close();
	}

}
