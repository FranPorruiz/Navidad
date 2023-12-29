package Servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Curso;
import service.CursoService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/PrecioMax")
public class PrecioMax extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		CursoService sc=new CursoService();
		double maxPrecio=(double) session.getAttribute("precioMax");
		
		List<Curso> listaCursos=sc.preciosCursoMax((List<Curso>)session.getAttribute("listaCursos"),(double) session.getAttribute("precioMax"));
		session.setAttribute("listaCursos", listaCursos);
		request.getRequestDispatcher("ListadoCursos.jsp").forward(request, response);
	
	}

}
