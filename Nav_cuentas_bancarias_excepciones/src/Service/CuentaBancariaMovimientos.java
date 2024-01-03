package Service;

import java.time.LocalDateTime;
import java.util.ArrayList;

import Excepctions.SaldoNegativoExcepcion;
import Model.Movimiento;

public class CuentaBancariaMovimientos extends CuentaBancariaLimite {
	/*método obtenerMovimientos
	que devolverá un ArraList con los movimientos realizados
	en la cuenta
	*/
	private ArrayList<Movimiento> movimientosBanco=new ArrayList<>();
	
	public CuentaBancariaMovimientos(double saldo, double limite) {
		super(saldo, limite);
	}
	
	public ArrayList<Movimiento> obtenerMovimientos() {
		return movimientosBanco;
		
	}
	
	//para rellenar los movimientos tenemos que sobreescribir los 
	//metodos ingresar y extraer
	//tenemos que indicar la propagacion de la excepcion, porque la hemos declarado en la clse padre
	@Override
	public void extraer(double cantidad) throws SaldoNegativoExcepcion {
		//añadimos directamente al araylist sin necesidad de generar la variable
		//LocalDateTime.now coge la fecha del momento
		movimientosBanco.add(new Movimiento(cantidad, LocalDateTime.now(), TipoMovimiento.EXTRACCION));
		super.extraer(cantidad);	//este super al no ser un constructor sino un metodo da igual que este detrás	
		
	}

	@Override
	public void ingresar(double cantidad) {
		movimientosBanco.add(new Movimiento(cantidad, LocalDateTime.now(), TipoMovimiento.INGRESO));
		super.ingresar(cantidad);
	}

	
	

}
