package ar.edu.unahur.po2.cuentas;

import static org.junit.Assert.*;

import org.junit.Test;

public class CuentaSueldoTest {

	@Test
	public void queAlCerarLaCuentaSuSaldoEsCero() {
		Double valorEsperado = 0.0;
		CuentaSueldo cuenta = new CuentaSueldo();
		Double valorObtenido = cuenta.saldo();
		assertEquals(valorEsperado, valorObtenido);
	}

	@Test
	public void queSePuedaDepositarEIncrementeMiSaldo() {
		Double valorADepositar = 100.0;
		Double valorEsperado = 100.0;
		CuentaSueldo cuenta = new CuentaSueldo();
		cuenta.depositar(valorADepositar);
		Double valorObtenido = cuenta.saldo();
		assertEquals(valorEsperado, valorObtenido);
	}

	@Test
	public void queSePuedaExtraerSiTengoDineroSuficienteEnCuenta() {
		Double valorADepositar = 100.0;
		Double valorAExtraer = 75.0;
		Double valorEsperado = 25.0;
		CuentaSueldo cuenta = new CuentaSueldo();
		cuenta.depositar(valorADepositar);
		cuenta.extraer(valorAExtraer);
		Double valorObtenido = cuenta.saldo();
		assertEquals(valorEsperado, valorObtenido);
	}

	@Test
	public void queNoSePuedanDepositarMontosNegativos() {
		Double valorADepositar = -100.0;
		Double valorEsperado = 0.0;
		CuentaSueldo cuenta = new CuentaSueldo();
		cuenta.depositar(valorADepositar);
		Double valorObtenido = cuenta.saldo();
		assertEquals(valorEsperado, valorObtenido);
	}

	@Test
	public void queNoSePuedaExtraerSinDineroSuficienteEnCuenta() {
		Double valorADepositar = 100.0;
		Double valorAExtraer = 175.0;
		Double valorEsperado = 100.0;
		CuentaSueldo cuenta = new CuentaSueldo();
		cuenta.depositar(valorADepositar);
		cuenta.extraer(valorAExtraer);
		Double valorObtenido = cuenta.saldo();
		assertEquals(valorEsperado, valorObtenido);
	}

	@Test
	public void queNoSePuedaExtraerValoresNegativos() {
		Double valorADepositar = 100.0;
		Double valorAExtraer = -75.0;
		Double valorEsperado = 100.0;
		CuentaSueldo cuenta = new CuentaSueldo();
		cuenta.depositar(valorADepositar);
		cuenta.extraer(valorAExtraer);
		Double valorObtenido = cuenta.saldo();
		assertEquals(valorEsperado, valorObtenido);
	}

}
