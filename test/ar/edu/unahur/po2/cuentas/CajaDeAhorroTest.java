package ar.edu.unahur.po2.cuentas;

import static org.junit.Assert.*;

import org.junit.Test;

public class CajaDeAhorroTest {

	@Test
	public void queAlCerarLaCuentaSuSaldoEsCero() {
		Double valorEsperado = 0.0;
		CajaDeAhorro cuenta = new CajaDeAhorro();
		Double valorObtenido = cuenta.saldo();
		assertEquals(valorEsperado,valorObtenido);
	}
	
	@Test
	public void queSePuedaDepositarEIncrementeMiSaldo() {
		Double valorADepositar = 100.0;
		Double valorEsperado = 100.0;
		CajaDeAhorro cuenta = new CajaDeAhorro();
		cuenta.depositar(valorADepositar);
		Double valorObtenido = cuenta.saldo();
		assertEquals(valorEsperado,valorObtenido);
	}

	@Test
	public void queSePuedaExtraerSiTengoDineroSuficienteEnCuenta() {
		Double valorADepositar = 100.0;
		Double valorAExtraer = 75.0;
		Double valorEsperado = 25.0;
		CajaDeAhorro cuenta = new CajaDeAhorro();
		cuenta.depositar(valorADepositar);
		cuenta.extraer(valorAExtraer);		
		Double valorObtenido = cuenta.saldo();
		assertEquals(valorEsperado,valorObtenido);
	}

	@Test
	public void queNoSePuedanDepositarMontosNegativos() {
		Double valorADepositar = -100.0;
		Double valorEsperado = 0.0;
		CajaDeAhorro cuenta = new CajaDeAhorro();
		cuenta.depositar(valorADepositar);
		Double valorObtenido = cuenta.saldo();
		assertEquals(valorEsperado,valorObtenido);
	}

	@Test
	public void queNoSePuedaExtraerSinDineroSuficienteEnCuenta() {
		Double valorADepositar = 100.0;
		Double valorAExtraer = 175.0;
		Double valorEsperado = 100.0;
		CajaDeAhorro cuenta = new CajaDeAhorro();
		cuenta.depositar(valorADepositar);
		cuenta.extraer(valorAExtraer);		
		Double valorObtenido = cuenta.saldo();
		assertEquals(valorEsperado,valorObtenido);
	}
	
	@Test
	public void queNoSePuedaExtraerValoresNegativos() {
		Double valorADepositar = 100.0;
		Double valorAExtraer = -75.0;
		Double valorEsperado = 100.0;
		CajaDeAhorro cuenta = new CajaDeAhorro();
		cuenta.depositar(valorADepositar);
		cuenta.extraer(valorAExtraer);		
		Double valorObtenido = cuenta.saldo();
		assertEquals(valorEsperado,valorObtenido);
	}

	@Test
	public void queSeCobreComisionDespuesDeLAQuintaExtraccion() {
		Double valorADepositar = 1_000.0;
		Double valorAExtraer = 100.0; // 6*100+6=606
		Double valorEsperado = 394.0;
		CajaDeAhorro cuenta = new CajaDeAhorro();
		cuenta.depositar(valorADepositar);
		for (int i=0;i<6;i++) {
			cuenta.extraer(valorAExtraer);
		}
		Double valorObtenido = cuenta.saldo();
		assertEquals(valorEsperado,valorObtenido);
	}
	
	@Test
	public void queNoSePuedaExtraerDespuesDeLaQuintaExtraccionSiNoSePuedeRealizarElDescuento() {
		Double valorADepositar = 6_000.0;
		Double valorAExtraer = 1_000.0; // 6*1_00+6=6006
		Double valorEsperado = 1_000.0;
		CajaDeAhorro cuenta = new CajaDeAhorro();
		cuenta.depositar(valorADepositar);
		for (int i=0;i<6;i++) {
			cuenta.extraer(valorAExtraer);
		}
		Double valorObtenido = cuenta.saldo();
		assertEquals(valorEsperado,valorObtenido);
	}
}
