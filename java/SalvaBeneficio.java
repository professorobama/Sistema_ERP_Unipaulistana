import java.io.IOException;  
import java.io.PrintWriter;  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse; 

@WebServlet("/SalvaBeneficio")  

public class SalvaBeneficio extends HttpServlet {  

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)   
         throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
          
        String nomebeneficio=request.getParameter("nomebeneficio");  
        String sigla=request.getParameter("siglabeneficio");
        String tipo=request.getParameter("tipobeneficio");
        String descricao=request.getParameter("descricaobeneficio");  
       
          
        Beneficio  e = new Beneficio();  
        e.setNomebeneficio(nomebeneficio);  
        e.setSigla(sigla); 
        e.setTipoBeneficio(tipo);
        e.setDescricao(descricao);  
            
        int status = BeneficioDao.save(e);  
         
     //   if((nomebeneficio!="")&&(sigla!="")&&(tipo!="")&&(descricao!="")&&(status>0)){  
      	if(status>0 && (nomebeneficio!="")&&(sigla!="")&&(tipo!="")&&(descricao!="") ){
            out.print("<p>Registro salvo com sucesso!</p>");  
            request.getRequestDispatcher("cadastrodebeneficios.html").include(request, response);  
        }else{  
            out.println("Desculpe!Seu registro não pode ser salvo");  
            request.getRequestDispatcher("cadastrodebeneficios.html").include(request, response);  
        }
          
        out.close();  
    }  
  
}  