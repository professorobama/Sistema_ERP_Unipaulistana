import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/VisualizarDepartamento")
public class VisualizarDepartamento extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		   response.setContentType("text/html");  
	        PrintWriter out = response.getWriter(); 
	        out.println("<h1>Relatório de Departamentos</h1>");  
	          
	        List<Departamento> list=DepartamentoDao.getAllDepartamento();
	          
	        out.print("<table border='1' width='100%'");  
	        out.print("<tr><th>Id</th><th>Nome do Departamento</th><th>Sigla</th><th>Descrição do Departamento</th><th>Editar</th><th>Excluir</th></tr>");  
	        for(Departamento e:list){  
	         out.print("<tr><td>"+e.getId()+"</td><td>"+e.getNomedepartamento()+"</td><td>"+e.getSigla()+"</td><td>"+e.getDescricao()+"</td><td><a href='EditarServletDepartamento?iddepartamento="+e.getId()+"'>Editar</a></td><td><a href='ExcluirServletDepartamento?iddepartamento="+e.getId()+"'>Excluir</a></td></tr>");  
	        }  
	        out.print("</table>");  
	          
	        out.close(); 
		
	}

}
