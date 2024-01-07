package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.ServiceProductos;

import java.io.IOException;

@WebServlet("/BorrarServlet")
public class BorrarServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String borrar=request.getParameter("nombre");
		ServiceProductos sp=new ServiceProductos();
		sp.borrarProducto(borrar);
		request.getRequestDispatcher("Home.html").forward(request, response);

	}

}
