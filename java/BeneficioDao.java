import java.sql.*; 

public class BeneficioDao {
	  
	    public static Connection getConnection(){  
	        Connection con=null;  
	        try{  
	            Class.forName("com.mysql.cj.jdbc.Driver");  
	           con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rhunipaulistana","root","root"); 
	        }catch(Exception e){System.out.println(e);}  
	        return con;  
	    }  
	    public static int save(Beneficio e){  
	        int status = 0;
	        
	        try{  
	            Connection con=BeneficioDao.getConnection();  
	            PreparedStatement ps=con.prepareStatement(  
	                         "insert into beneficio(nomebeneficio,siglabeneficio,tipobeneficio,descricao) values (?,?,?,?)");  
	            
	            ps.setString(1,e.getNomebeneficio());  
	            ps.setString(2,e.getSigla());
	            ps.setString(3, e.getTipoBeneficio());
	            ps.setString(4,e.getDescricao());   
	              
	            status=ps.executeUpdate();  
	              
	            con.close();  
	        }catch(Exception ex){ex.printStackTrace();}  
	          
	        return status;  
	    }  
	
	    public static int update(Beneficio e){  
	    	
	        int status=0; 
	        
	        try{  
	            Connection con=BeneficioDao.getConnection();  
	            PreparedStatement ps=con.prepareStatement(  
	                         "update beneficio set nomebeneficio=?,siglabeneficio=?,tipobeneficio=?,descricao=? where idbeneficio=?");  
	            
	            ps.setString(1,e.getNomebeneficio());  
	            ps.setString(2,e.getSigla());  
	            ps.setString(3,e.getTipoBeneficio());  
	            ps.setString(4,e.getDescricao());  
	            ps.setInt(5,e.getIdbeneficio());  
	              
	            status=ps.executeUpdate();  
	              
	            con.close();  
	        }catch(Exception ex){ex.printStackTrace();}  
	          
	        return status;  
	    }  
}
