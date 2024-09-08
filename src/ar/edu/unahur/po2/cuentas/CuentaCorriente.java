package ar.edu.unahur.po2.cuentas;

public class CuentaCorriente extends CuentaBancaria{
	private Double limiteAdicional = 150.0;
	
	public CuentaCorriente(Double limiteAdicional) {
		this.limiteAdicional = limiteAdicional;
	}
	
	public Double limiteCuenta() {
		return this.limiteAdicional + this.saldo();
	}
	
	@Override
	public void extraer(Double valorAExtraer) {
		if (this.saldo() >= valorAExtraer && valorAExtraer > 0) {
			this.updateSaldo(this.saldo() - valorAExtraer);
		}else if (this.limiteCuenta()>= valorAExtraer && valorAExtraer > 0) {
			this.limiteAdicional -= valorAExtraer - this.saldo();
			this.updateSaldo(0.0);
		}
	}

}
