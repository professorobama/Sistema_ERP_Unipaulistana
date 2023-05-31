import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");  
        PrintWriter out = response.getWriter();
          
        String usuario = request.getParameter("usuario");  
        String senha = request.getParameter("senha");  
          
       
        if(LoginDao.validate(usuario,senha)){ 
            RequestDispatcher rd = request.getRequestDispatcher("servlet2");
			rd.forward(request, response);
                
        }else{
            out.print("<h1>Desculpe, seu usuário e/ou senha está inválido!</h1>");  
            request.getRequestDispatcher("index02.html").include(request, response);  
        }  
          
        out.close();  
	}

}
