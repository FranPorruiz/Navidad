package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/CheckCookies")

public class CheckCookies extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie[] cookies=request.getCookies();
		String nombre=null;
		if(cookies!=null) {
			for(Cookie ck: cookies) {
				if(ck.getName().equals("usuario")) {
					nombre=ck.getValue();
					break;
				}	
			}
		}	
		if(nombre==null) {
			request.getRequestDispatcher("Login.html").forward(request, response);			
		}
		else {
			request.getRequestDispatcher("correcto.jsp?usuario="+nombre).forward(request, response);			

		}
	}

}