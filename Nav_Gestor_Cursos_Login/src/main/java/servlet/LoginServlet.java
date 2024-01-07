package servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.UsuariosService;

import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Creamos una istancia del usuario service
		UsuariosService service=new UsuariosService();
		RequestDispatcher dispatcher;	
		//recibimos y verificamos el usuario
		if(service.autenticar(request.getParameter("usuario"), request.getParameter("password"))){
			//si es correcto transferimos la petición a correcto.jsp
			 generarCookis(response, request);
			dispatcher=request.getRequestDispatcher("Home.html");	 
			 /*
			 if(request.getParameter("recordar")!=null){
			 generarCookis(response, request);
			dispatcher=request.getRequestDispatcher("correcto.jsp");	 
			 	 
			 }
			 */
		}else {
			//en caso contrario lo pasamos a erroneo.jsp
			dispatcher=request.getRequestDispatcher("erroneo.jsp");
		}
		dispatcher.forward(request, response);	

	}

	private void generarCookis(HttpServletResponse response, HttpServletRequest request) {
		Cookie ck=new Cookie("usuario", request.getParameter("usuario"));
		ck.setMaxAge(200_000);
		response.addCookie(ck);
		
	}

}
