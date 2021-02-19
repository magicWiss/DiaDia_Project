package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FabbricaComandoFisarmonicaTest 
{
	FabbricaComando factory;
	
	@Before
	public void setUp()
	{
		this.factory=new FabbricaComandoFisarmonica();
	}
	
	/*
	 * test comando aiuto
	 */
	@Test
	public void test_positivo_comando_aiuto()
	{
		Comando aiuto;
		aiuto= new ComandoAiuto();
		aiuto.setParametro(null);
		assertEquals("NON sono uguali", aiuto, this.factory.costruisciComando("aiuto"));
	}
	
	/*
	 * test  positivo comando vai
	 */
	@Test
	public void test_positivo_comando_vai()
	{
		Comando vaiNord;
		vaiNord= new ComandoVai();
		vaiNord.setParametro("nord");
		assertEquals("NON sono uguali", vaiNord, this.factory.costruisciComando("vai nord"));
	}
	/*
	 * test negativo comando vai
	 */
	@Test
	public void test_negativo_comando_vai()
	{
		Comando vaiNord;
		vaiNord= new ComandoVai();
		vaiNord.setParametro("nord");
		assertNotEquals("NON sono uguali", vaiNord, this.factory.costruisciComando("vai sud"));
	}
	/*
	 * test positivo posa osso
	 */
	@Test
	public void test_posa_osso_positivo()
	{
		Comando posaOsso;
		posaOsso= new ComandoPosa();
		posaOsso.setParametro("osso");
		assertEquals("NON sono uguali", posaOsso, this.factory.costruisciComando("posa osso"));
	}
	/*
	 * test negativo posa osso
	 */
	@Test
	public void test_negativo_posa_osso()
	{
		Comando posaOsso;
		posaOsso= new ComandoPosa();
		posaOsso.setParametro("osso");
		assertNotEquals("NON sono uguali", posaOsso, this.factory.costruisciComando("posa spada"));
	}
	
	/*
	 * test comando guarda
	 */
	@Test
	public void test_comando_guarda()
	{
		Comando guarda;
		guarda=new ComandoGuarda();
		guarda.setParametro(null);
		assertEquals("NON sono uguali", guarda, this.factory.costruisciComando("guarda"));
	}
	/*
	 * test comando fine
	 */
	@Test
	public void test_comando_fine()
	{
		Comando fine;
		fine= new ComandoFine();
		fine.setParametro(null);
		assertEquals("NON sono uguali", fine, this.factory.costruisciComando("fine"));
	}
	/*
	 * test comando Non valido
	 */
	@Test
	public void test_comando_non_valido()
	{
		Comando nonValido;
		nonValido= new ComandoNonValido();
		nonValido.setParametro(null);
		assertEquals("NON sono uguali", nonValido, this.factory.costruisciComando(""));
	}
	@Test
	public void test_comando_prendiOsso_positivo()
	{
		Comando prendiOsso=new ComandoPrendi();
		prendiOsso.setParametro("osso");
		assertEquals("NON sono uguali", prendiOsso, this.factory.costruisciComando("prendi osso"));
	}
	@Test
	public void test_comando_prendiOsso_negativo()
	{
		Comando prendiOsso=new ComandoPrendi();
		prendiOsso.setParametro("spada");
		assertNotEquals("NON sono uguali", prendiOsso, this.factory.costruisciComando("prendi osso"));
	}
	
	
	

}
