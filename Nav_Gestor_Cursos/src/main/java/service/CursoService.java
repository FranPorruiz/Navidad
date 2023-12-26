package service;

import java.util.ArrayList;

import model.Curso;

public class CursoService {
	
	private ArrayList<Curso> cursos=new ArrayList<>();

	//2-Pide el precio maximo y muestra una lista de los cursos
		public  ArrayList<Curso> preciosCursoMax(double precioMax) {
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
