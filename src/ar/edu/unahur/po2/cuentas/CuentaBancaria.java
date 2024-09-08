package ar.edu.unahur.po2.cuentas;

public abstract class CuentaBancaria {

	private Double saldo = 0.0;
	
	public Double saldo() {
		return this.saldo;
	}
	
	public void depositar(Double valorADepositar) {
		if (valorADepositar > 0) {
			this.saldo = this.saldo + valorADepositar;
		}
	}
	
	public abstract void extraer(Double valorAExtraer);
	
	//Setter de Saldo para cambiarlo de protected a private
	protected void updateSaldo(Double valor){
		if(saldo > 0) {
			this.saldo = valor;
		}
	}
}
