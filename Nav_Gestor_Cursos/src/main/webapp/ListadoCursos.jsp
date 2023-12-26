<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"   
     import="model.Curso, java.util.List, java.util.ArrayList"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<th>Nombre</th>
			<th>Duracion</th>
			<th>Precio</th>
			<th></th>
			<th></th>
			<th></th>			
		</tr>
		<%
		List<Curso> listaCurso=new ArrayList<Curso>(); 
		if(session.getAttribute("listaCursos")!=null){
			listaCurso=(List<Curso>)session.getAttribute("listaCursos");	
		}
		for(Curso curso: listaCurso){
		%>
		<tr>
			<td><%=curso.getNombre() %></td>
			<td><%=curso.getDuracion()%></td>
			<td><%=curso.getPrecio()%></td>
			<form action="NuevaDuracion" method="GET">	
				<td> <input type="text"  name="nuevaDuracion" placeholder="Nueva duracion"></td>
				<td><input type="submit" value="Cambiar"></td>			
			</form>
			<td>
			<!-- con esta linea le decimos que le pasa el parametro nombre al Servlet y le decimos a que corresponda -->
			<a href="BorrarServlet?nombre=<%=curso.getNombre()%>">Eliminar</a></td>	
		<%}%>
			
		</tr>
		<tr>
		<form action="AnadirServlet" method="GET">
			 <td><input type="text" name="nombre" > </td>
			<td><input type="text" name="duracion" ></td> 
			<td><input type="text" name="precio" ></td> 
		<td><input type="submit" value="Guardar Producto"></td>
		
		</form>
		</tr>
		
	</table>

</body>
</html>