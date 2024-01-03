package Service;

import Excepctions.SaldoNegativoExcepcion;

public class CuentaBancaria {
	private double saldo;

	//boton derecho source+crear constructor
	public CuentaBancaria(double saldo) {
		this.saldo = saldo;
	}
	public void ingresar(double cantidad) {
		saldo+=cantidad;
	}
	//la declaracion de throws sirve para propagar la excecpion
	public void extraer(double cantidad) throws SaldoNegativoExcepcion {
		//excepcion par saldo negativo
		if(cantidad>saldo) {
			//la provocamos con throw
			throw new SaldoNegativoExcepcion();
			
		}
		saldo-=cantidad;
		
	}
	
	//getters and setters
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	
	

}
