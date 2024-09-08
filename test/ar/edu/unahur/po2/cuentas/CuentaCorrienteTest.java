package ar.edu.unahur.po2.cuentas;

import static org.junit.Assert.*;

import org.junit.Test;

public class CuentaCorrienteTest {

	@Test
	public void queAlCerarLaCuentaSuSaldoEsCero() {
		CuentaCorriente cuenta = new CuentaCorriente(100.0);
		Double valorEsperado = 0.0;
		Double valorObtenido = cuenta.saldo();
		assertEquals(valorEsperado,valorObtenido);
	}
	
	@Test
	public void queSePuedaDepositarEIncrementeMiSaldo() {
		CuentaCorriente cuenta = new CuentaCorriente(100.0);
		Double valorADepositar = 100.0;
		Double valorEsperado = 100.0;
		cuenta.depositar(valorADepositar);
		Double valorObtenido = cuenta.saldo();
		assertEquals(valorEsperado,valorObtenido);
	}

	@Test
	public void queSePuedaExtraerSiTengoDineroSuficienteEnCuenta() {
		CuentaCorriente cuenta = new CuentaCorriente(100.0);
		Double valorADepositar = 100.0;
		Double valorAExtraer = 75.0;
		Double valorEsperado = 25.0;
		cuenta.depositar(valorADepositar);
		
		cuenta.extraer(valorAExtraer);		
		Double valorObtenido = cuenta.saldo();
		
		assertEquals(valorEsperado,valorObtenido);
		
	}

	@Test
	public void queNoSePuedanDepositarMontosNegativos() {
		CuentaCorriente cuenta = new CuentaCorriente(100.0);
		Double valorADepositar = -100.0;
		Double valorEsperado = 0.0;
		cuenta.depositar(valorADepositar);
		Double valorObtenido = cuenta.saldo();
		assertEquals(valorEsperado,valorObtenido);
	}
	
	@Test
	public void queNoSePuedaExtraerValoresNegativos() {
		CuentaCorriente cuenta = new CuentaCorriente(100.0);
		Double valorADepositar = 100.0;
		Double valorAExtraer = -75.0;
		Double valorEsperado = 100.0;
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
		assertEquals(cuenta.limiteCuenta(),valorEsperado);
	}
	
	@Test
	public void queAlExtraerConSaldoSuficienteNoModifiqueLaDeuda() {
		CuentaCorriente cuenta = new CuentaCorriente(200.0);
		Double valorADepositar = 300.0;
		Double valoerAExtraer = 250.0;
		Double valorEsperado = 0.0;
		cuenta.depositar(valorADepositar);
		cuenta.extraer(valoerAExtraer);
		assertEquals(cuenta.deuda(),valorEsperado);
	}
	
	@Test
	public void queAlDepositarConDeudaLaDeudaQuedeEn0() {
		CuentaCorriente cuenta = new CuentaCorriente(200.0);
		Double valoerAExtraer = 150.0;
		Double valorADepositar = 200.0;
		Double valorEsperado = 0.0;
		cuenta.extraer(valoerAExtraer);
		cuenta.depositar(valorADepositar);
		assertEquals(cuenta.deuda(),valorEsperado);
	}
	
	public void queAlDepositarConDeudaSeDescuenteLaDeudaCorrectaSobreElDeposito() {
		CuentaCorriente cuenta = new CuentaCorriente(200.0);
		Double primerDeposito = 200.0;
		Double valoerAExtraer = 300.0;
		Double segundoDeposito = 150.0;
		Double valorEsperado = 145.0;
		cuenta.depositar(primerDeposito);
		cuenta.extraer(valoerAExtraer);
		cuenta.depositar(segundoDeposito);
		assertEquals(cuenta.saldo(),valorEsperado);
	}
	
}
