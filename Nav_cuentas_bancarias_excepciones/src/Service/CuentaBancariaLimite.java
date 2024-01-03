package Service;

import Excepctions.SaldoNegativoExcepcion;

public class CuentaBancariaLimite extends CuentaBancaria{
	private double limite;
	
	//con este constructor recibe la variable saldo de la clase padre
	public CuentaBancariaLimite(double saldo, double limite) {
		super(saldo);
		this.limite=limite;
	}
	
	//metodo para ajustar el saldo, podemos recibir el metodo getSaldo del CuentaBancaria
	public void  ajustarLimite() {
		limite=getSaldo()/2;		
	}
	
	//sobrescritura, boton derecho + source
	//tenemos que propagar la excepcion porque este metodo lo recibe de la clase padre
	@Override
	public void extraer(double cantidad) throws SaldoNegativoExcepcion {
		if(cantidad<=limite) {
			//si la cantidad es inferior al limite, llamamos al metodo padre(porque sino estarmiamos siendo recursivos) y le pedimos la cantidad
			super.extraer(cantidad);
		}else{
			//si la cantidad es superior al limite, llamamos al metodo padre y le pedimos el limite

			super.extraer(limite);
		};
	}

}
