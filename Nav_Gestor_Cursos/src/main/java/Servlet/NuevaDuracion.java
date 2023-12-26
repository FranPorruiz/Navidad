package Servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/NuevaDuracion")
public class NuevaDuracion extends HttpServlet {
	

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//pedimos HHpSession al servidor de aplicaciones
		HttpSession session=request.getSession();
		int nuevaDuracion=0;
		if(session.getAttribute("nuevaDuracion")!=null){
			nuevaDuracion=(Integer)session.getAttribute("nuevaDuracion");	
		}
		session.setAttribute("duracion", nuevaDuracion);//con esto añadimos 1 a la variable
		request.getRequestDispatcher("ListadoCursos.jsp").forward(request, response);

		
	}

}
