package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Producto;
import service.ServiceProductos;

import java.io.IOException;

@WebServlet("/AnadirServlet")
public class AnadirServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombreNew=request.getParameter("nombre");
		int precioNew=Integer.parseInt(request.getParameter("precio"));
		String categoria=request.getParameter("categoria");
		Producto nuevoProducto=new Producto(nombreNew, precioNew, categoria);
		ServiceProductos sp=new ServiceProductos();
		sp.anadirProducto(nuevoProducto);
		request.getRequestDispatcher("Home.html").forward(request, response);
	}
}
