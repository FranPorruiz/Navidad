package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Producto;
import service.ServiceProductos;

import java.io.IOException;
import java.util.List;

@WebServlet("/BuscadorServlet")
public class BuscadorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String busqueda=request.getParameter("categoria");
		ServiceProductos sp=new ServiceProductos();
		List<Producto> resultado=sp.buscarProducto(busqueda);//recogemos la lista de la busqueda por la busqueda
		request.setAttribute("resultados", resultado);//pasamos la lista de resultados
		request.getRequestDispatcher("Resultados.jsp").forward(request, response);

		}
	
}	
	
	
	
