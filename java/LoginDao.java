import java.sql.*;

public class LoginDao {

public static boolean validate (String usuario, String senha) {
	
	boolean status = false;
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rhunipaulistana","root","root"); 		
		PreparedStatement ps = con.prepareStatement("select * from  login where usuario = ? and senha = ?");
		
		ps.setString(1, usuario);
		ps.setString(2, senha);
		
		ResultSet rs = ps.executeQuery();
		status = rs.next();
		
	} catch (Exception e) {
			
	}
	return status;
}

}
