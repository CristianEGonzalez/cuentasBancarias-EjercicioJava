package ar.edu.unahur.po2.cuentas;

public class CuentaCorriente extends CuentaBancaria{
	private Double limiteAdicional = 150.0;
	
	public CuentaCorriente(Double limiteAdicional) {
		this.limiteAdicional = limiteAdicional;
	}
	
	public Double limiteTotal() {
		return this.limiteAdicional + this.saldo();
	}
	
	@Override
	public void extraer(Double valorAExtraer) {
		if (this.saldo >= valorAExtraer && valorAExtraer > 0) {
			this.saldo = this.saldo - valorAExtraer;
		}else if (this.limiteTotal()>= valorAExtraer && valorAExtraer > 0) {
			this.limiteAdicional -= valorAExtraer - this.saldo();
			this.saldo = 0.0;
		}
	}

}
