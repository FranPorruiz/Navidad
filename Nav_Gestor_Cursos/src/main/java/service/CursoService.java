package service;

import java.util.ArrayList;
import java.util.List;

import model.Curso;

public class CursoService {
	

	//2-Pide el precio maximo y muestra una lista de los cursos
		public  ArrayList<Curso> preciosCursoMax( List<Curso> cursos,double precioMax) {
			//creamos un Arraylist auxiliar con los cursos creado
			ArrayList<Curso> auxiliar=new ArrayList<>();
		
			//recorremos el arrailist principal, si el curso es inferios lo añadimos al auxiloiar
			for (Curso curso : cursos) {
				if(curso.getPrecio()<=precioMax) {
					auxiliar.add(curso);
				}	
			}
			//devolvemos el arraylistauxiliar
			return auxiliar;
		}
	

}
