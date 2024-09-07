package ar.edu.unahur.po2.cuentas;

public class CuentaSueldo extends CuentaBancaria {

	@Override
	public void extraer(Double valorAExtraer) {
		if (this.saldo >= valorAExtraer && valorAExtraer > 0) {
			this.saldo = this.saldo - valorAExtraer;
		}
	}
}
