import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EditarServletDepartamento2")
public class EditarServletDepartamento2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
          
        String sid=request.getParameter("iddepartamento");  
        int id=Integer.parseInt(sid);  
        String name=request.getParameter("nomedepartamento");  
        String sigla=request.getParameter("sigla");  
        String descricao=request.getParameter("descricao");
          
        Departamento e = new Departamento();  
        e.setId(id);  
        e.setNomedepartamento(name);  
        e.setSigla(sigla);  
        e.setDescricao(descricao);  
       
        int status = DepartamentoDao.update(e);  
        if(status>0){  
            response.sendRedirect("VisualizarDepartamento");  
        }else{  
            out.println("Desculpe! Não foi possível editar o registro");  
        }  
          
        out.close();
		
	}

}
