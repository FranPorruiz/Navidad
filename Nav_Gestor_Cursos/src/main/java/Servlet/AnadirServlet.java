package Servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Curso;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/AnadirServlet")
public class AnadirServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//le pedimos la HPSession al servidor
		HttpSession session=request.getSession();
		List<Curso> listaCursos=new ArrayList<Curso>();
		if(session.getAttribute("listaCursos")!=null) {
			listaCursos=(List<Curso>)session.getAttribute("listaCursos");
		}
		
		String nombre=request.getParameter("nombre");
		Double precio=Double.parseDouble(request.getParameter("precio"));
		int duracion=Integer.parseInt(request.getParameter("duracion"));
		Curso nuevoCurso=new Curso(nombre, duracion, precio);
		listaCursos.add(nuevoCurso);
		session.setAttribute("listaCursos", listaCursos);
		request.getRequestDispatcher("ListadoCursos.jsp").forward(request, response);
		
	}

}
