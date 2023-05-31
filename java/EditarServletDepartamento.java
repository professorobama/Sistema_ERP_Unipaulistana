import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/EditarServletDepartamento")
public class EditarServletDepartamento extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        out.println("<h1>Editar Departamento</h1>");
        String sid=request.getParameter("iddepartamento");  
        int id=Integer.parseInt(sid);  
          
        Departamento e = DepartamentoDao.getDepartamentoById(id);  
          
        out.println("<form action='EditarServletDepartamento2' method='post'>");
        out.print("<input type='hidden' name='iddepartamento' value='"+e.getId()+"'/>"+"<br>");
        out.println("<label for='nome' class ='etiqueta'> Nome do Departamento :</label>"+"<br>");
        out.println("<input type='text' id='nome' name='nomedepartamento' placeholder='Digite o nome do departamento' required='required' value="+e.getNomedepartamento()+">"+"<br>");
        out.println("<label for='sigla' class='etiqueta'>Sigla:</label>"+"<br>");
        out.println("<input type='text' id='sigla' name='sigla' placeholder='Digite a sigla do departament' required='required' value="+e.getSigla()+">"+"<br>");
        out.println("<label for='descricao' class='etiqueta'>Descrição do Departamento:</label>"+"<br>");
        out.println("<textarea id='descricaodepartamento' name='descricao' rows='4' cols='68' placeholder='Descreva o departamento' required='required' value="+e.getDescricao()+"></textarea>"+"<br>");
        out.println("<input type='submit' value='Salvar Edição'");
        out.println("</form>");
      
 
        out.close();	
	}

}
