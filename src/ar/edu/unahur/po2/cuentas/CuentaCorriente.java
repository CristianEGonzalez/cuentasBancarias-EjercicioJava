package ar.edu.unahur.po2.cuentas;

public class CuentaCorriente extends CuentaBancaria{
	
	private Double limiteAdicional = 0.0;
	private Double adicionalActual;
	private Double deuda = 0.0;
	
	public CuentaCorriente(Double limiteAdicional) {
		this.limiteAdicional = limiteAdicional;
		this.adicionalActual = this.limiteAdicional;
		//Igualé el adicional actual al límite después de crear la cuenta
	}
	
	public Double limiteCuenta() {
		return this.adicionalActual + this.saldo();
	}
	
	@Override
	public void extraer(Double valorAExtraer) {
		if (this.saldo() >= valorAExtraer && valorAExtraer > 0) {
			this.updateSaldo(this.saldo() - valorAExtraer);
		}else if (this.limiteCuenta() >= valorAExtraer && valorAExtraer > 0) {
			this.adicionalActual -= valorAExtraer - this.saldo();
			this.deuda = this.limiteAdicional - this.adicionalActual;
			this.updateSaldo(0.0);
		}
	}
	
	public Double deuda() {
		return this.deuda * 1.05;
	}
	
	@Override //ARREGLAR, ROMPE TODO
	public void depositar(Double valorADepositar) {
		if (valorADepositar > 0 && this.deuda() == 0) {
			this.updateSaldo(this.saldo() + valorADepositar);
		}else if(valorADepositar > this.deuda()) {
			this.updateSaldo(valorADepositar - this.saldo());
			this.deuda = 0.0;
		}
	}

}
