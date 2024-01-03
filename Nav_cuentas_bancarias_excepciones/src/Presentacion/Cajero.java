package Presentacion;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import Excepctions.SaldoNegativoExcepcion;
import Model.Movimiento;
import Service.CuentaBancariaLimite;
import Service.CuentaBancariaMovimientos;

/*
Aplicación cajero

Al iniciar el programa, se solicita un saldo inicial y un límite. A partir de ahí, se mostrará
el menú:

1.- Ingresar
2.- Extraer
3.- Saldo y movimientos
4.- Salir 
 */
public class Cajero {
	static CuentaBancariaMovimientos service;//creamos el objeto sin inicializarlo, luego lo inicializamos más abajo

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int opcion;
		double saldo, limite;
		System.out.println("***Bienvenido al cajero de Fran***");
		//prueba de try catch, lo incluimos desde aquí porque queremos asegurarnos que la entrada de saldo sea un integer
		try {
		System.out.println("Ingresa el saldo");
		saldo=sc.nextDouble();
		System.out.println("Ingresa el limite");
		limite=sc.nextDouble();
		service=new CuentaBancariaMovimientos(saldo, limite);
		do {
			//try catch dentro de try cacth
			try {
				mostrarMenu();//llamada a opcion
				opcion=sc.nextInt();
				switch (opcion) {
				//llamamos a funciones independientes por la opcion introducida
				case 1: 
					ingresar();
					break;
				case 2:
					extraer();
					break;
				case 3:
					saldoYMovimiento();
					break;
				case 4:
					System.out.println("¡Hasta luego");
				}
				}catch(InputMismatchException ex) {
					System.out.println("Opcion incorrecta o dato erróneo");
					sc=new Scanner(System.in);//esta reconstruccion del scanner se de que a que si no lo ejecutamos la lectura de la linea 41 se vuelve loco
					opcion=0;//al darle la opcion 0 nos reiniciarla el menu
					
				}
		}while(opcion!=4);
		}
		catch(InputMismatchException ex) {
			System.out.println("Solo valores numericos");
		}

	}

	//metodo extraer 
	//como aqui es donde se ejecuta el metodo extraccion, aqui
	//es donde tenemos que poner try catch
	static void extraer() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Por favor introduce la cantidad a extraer");
		double extraccion=sc.nextDouble();
		try {
			service.extraer(extraccion);
		} catch (SaldoNegativoExcepcion e) {
			System.out.println(e.getMessage());
			
		} ;
	}
	//metodo ingresar
	static void ingresar() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Por favor introduce la cantidad a ingresar");
		double ingreso=sc.nextDouble();
		service.ingresar(ingreso);
	}

	//impresión de métodos
	 static void saldoYMovimiento() {
		 System.out.println("Saldo actual: "+service.getSaldo());
		 ArrayList<Movimiento> movimientosBanco=service.obtenerMovimientos();
		 for (Movimiento movimiento : movimientosBanco) {
			 System.out.println(movimiento.getCantidad()+" - "+movimiento.getFechaHora()+" - "+movimiento.getTipo());
		}	 
	 }

	static void mostrarMenu() {
		System.out.println("***Menú cajero***");
		System.out.println("1.-Ingresar");
		System.out.println("2.-Extraer");
		System.out.println("3.-Saldo y movimiento");
		System.out.println("4.-Salir");

	}
}
