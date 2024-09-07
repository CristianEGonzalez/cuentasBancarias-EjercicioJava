package ar.edu.unahur.po2.cuentas;

import static org.junit.Assert.*;

import org.junit.Test;

public class CuentaCorrienteTest {

	@Test
	public void queAlCerarLaCuentaSuSaldoEsCero() {
		Double valorEsperado = 0.0;
		CuentaCorriente cuenta = new CuentaCorriente(100.0);
		Double valorObtenido = cuenta.saldo();
		assertEquals(valorEsperado,valorObtenido);
	}
	
	@Test
	public void queSePuedaDepositarEIncrementeMiSaldo() {
		Double valorADepositar = 100.0;
		Double valorEsperado = 100.0;
		CuentaCorriente cuenta = new CuentaCorriente(100.0);
		cuenta.depositar(valorADepositar);
		Double valorObtenido = cuenta.saldo();
		assertEquals(valorEsperado,valorObtenido);
	}

	@Test
	public void queSePuedaExtraerSiTengoDineroSuficienteEnCuenta() {
		Double valorADepositar = 100.0;
		Double valorAExtraer = 75.0;
		Double valorEsperado = 25.0;
		CuentaCorriente cuenta = new CuentaCorriente(100.0);
		cuenta.depositar(valorADepositar);
		cuenta.extraer(valorAExtraer);		
		Double valorObtenido = cuenta.saldo();
		assertEquals(valorEsperado,valorObtenido);
	}

	@Test
	public void queNoSePuedanDepositarMontosNegativos() {
		Double valorADepositar = -100.0;
		Double valorEsperado = 0.0;
		CuentaCorriente cuenta = new CuentaCorriente(100.0);
		cuenta.depositar(valorADepositar);
		Double valorObtenido = cuenta.saldo();
		assertEquals(valorEsperado,valorObtenido);
	}
	
	@Test
	public void queNoSePuedaExtraerValoresNegativos() {
		Double valorADepositar = 100.0;
		Double valorAExtraer = -75.0;
		Double valorEsperado = 100.0;
		CuentaCorriente cuenta = new CuentaCorriente(100.0);
		cuenta.depositar(valorADepositar);
		cuenta.extraer(valorAExtraer);		
		Double valorObtenido = cuenta.saldo();
		assertEquals(valorEsperado,valorObtenido);
	}
	
	@Test
	public void queSePuedaExtraerMasDeMiSaldoActualSegunMiLimiteAdicional() {
		CuentaCorriente cuenta = new CuentaCorriente(200.0);
		Double valorADepositar = 100.0;
		Double valoerAExtraer = 250.0;
		Double valorEsperado = 50.0;
		cuenta.depositar(valorADepositar);
		cuenta.extraer(valoerAExtraer);
		assertEquals(cuenta.limiteTotal(),valorEsperado);
	}
	
}
