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

@WebServlet("/BorrarServlet")
public class BorrarServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String nombre=request.getParameter("nombre");
		List<Curso> listaCurso=(List<Curso>)session.getAttribute("listaCursos");
		listaCurso.removeIf(p->(p.getNombre().equals(nombre)));
		request.getRequestDispatcher("ListadoCursos.jsp").forward(request, response);

	
	}

}
