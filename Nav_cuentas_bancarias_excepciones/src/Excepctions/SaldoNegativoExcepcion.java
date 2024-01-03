package Excepctions;
//esta clase extiende exception
public class SaldoNegativoExcepcion extends Exception {
	public SaldoNegativoExcepcion() {
		//esto es una metodo  heredado de la clase padre, asi nos lo lanzara el mensaje 
		//en el constructor
		super("El saldo no puede estar en negativo");
	}
}
