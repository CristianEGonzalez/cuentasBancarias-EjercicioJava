package ar.edu.unahur.po2.cuentas;

public class CajaDeAhorro extends CuentaBancaria {

	private Integer contador = 0;

	@Override
	public void extraer(Double valorAExtraer) {
		if (this.saldo() >= valorAExtraer && valorAExtraer > 0 && this.contador < 5) {
			this.updateSaldo(this.saldo() - valorAExtraer);
			this.contador = this.contador + 1;
		} else if (this.saldo() >= valorAExtraer + 6 && valorAExtraer > 0 && this.contador >= 5) {
			this.updateSaldo(this.saldo() - valorAExtraer - 6);
			this.contador = this.contador + 1;
		}
	}
}
