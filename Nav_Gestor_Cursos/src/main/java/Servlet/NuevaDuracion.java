package Servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Curso;

import java.io.IOException;
import java.util.List;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

@WebServlet("/NuevaDuracion")
public class NuevaDuracion extends HttpServlet {
	

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//pedimos HHpSession al servidor de aplicaciones
		HttpSession session=request.getSession();
		List<Curso> listaCurso=(List<Curso>)session.getAttribute("listaCursos");
		String nombre=request.getParameter("nombre");
		int nuevaDuracion=0;
		if(session.getAttribute("nuevaDuracion")!=null){
			nuevaDuracion=(Integer)session.getAttribute("nuevaDuracion");
			for (Curso curso : listaCurso) {
				if (curso.getNombre().equals(nombre)) {
					curso.setDuracion(nuevaDuracion);
					break;
				}
				
			}
		}
		request.getRequestDispatcher("ListadoCursos.jsp").forward(request, response);

		
	}

}
