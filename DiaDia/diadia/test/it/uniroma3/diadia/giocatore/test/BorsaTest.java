package it.uniroma3.diadia.giocatore.test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import it.uniroma3.diadia.attrezzi.*;
import it.uniroma3.diadia.giocatore.*;

public class BorsaTest {
	
	private Borsa borsaPiena;
	private Borsa borsaVuota;
	private Attrezzo martello;
	private Attrezzo cassa;
	private Attrezzo pesante;
	
	@Before
	public void setUp() {
		this.borsaPiena = new Borsa(3);
		this.borsaVuota = new Borsa(3);
		this.martello = new Attrezzo("Martello", 1);
		this.cassa = new Attrezzo("Cassa", 1);
		this.pesante = new Attrezzo("Pesante", 10);
		this.borsaPiena.addAttrezzo(martello);
		this.borsaPiena.addAttrezzo(martello);
		this.borsaPiena.addAttrezzo(martello);
	}
	
/*Test removeAttrezzo*/
	
	/*
	 * Rimozione di un attrezzo da una borsa vuota.
	 * Return aspettato null.
	 */
	@Test
	public void testRimozioneBorsaVuota() {
		assertEquals("Errore ho rimosso qualcosa", null, this.borsaVuota.removeAttrezzo("Martello"));
	}
	
	/*
	 * Rimozione di un attrezzo dalla borsa piena non presente
	 * Return apettato null
	 */
	@Test
	public void testRimozioneAttrezzoNonPresente() 
	{
		assertEquals("Errore ho rimosso qualcosa", null, this.borsaPiena.removeAttrezzo("Cassa"));
	}
	/*
	 * Rimozione di un attrezzo "martello" dalla borsa piena
	 * Return aspettato martello
	 */
    @Test
    public void testRimozioneStandard() {
    	assertEquals("Errore non ho rimosso nulla", martello, this.borsaPiena.removeAttrezzo("Martello"));
    }
    /*
     * Rimozione di nulla dall borsa 
     * Return aspettato null
     */
    @Test
    public void testRimozioneAttrezzoNullo() {
    	assertEquals("Errore ho rimosso qualcosa", null, this.borsaPiena.removeAttrezzo(null));
    }
    
/*Test addAttrezzo*/
    /*
     * Aggiunta di un' attrezzo nella borsa vuota
     * Return aspettato..> true
     */
    @Test
    public void testAggiuntaStandard() {
    	assertEquals("Errore non ho aggiunto nulla", true, this.borsaVuota.addAttrezzo(cassa));
    }
    /*
     * Aggiunta di un attrezzo nullo  nella borsa piena
     * Return aspettato -->false
     */
    @Test
    public void testAggiuntaAttrezzoNullo() {
    	assertEquals("Errore ho aggiunto qualcosa", false, this.borsaVuota.addAttrezzo(null));
    }
    /*
     * Aggiunta di un attrezzo nella borsa piena
     * Return aspettato-->false
     */
    @Test
    public void testAggiuntaBorsaPiena() {
    	assertEquals("Errore ho aggiunto qualcosa", false, this.borsaPiena.addAttrezzo(martello));
    }
    
    /*
     * Aggiunta di un attrezzo oltre limite di peso nella borsa vuota
     * return aspettato--->false
     */
    @Test
    public void testAggiuntaBorsaPesante() 
    {
    	assertEquals("Errore ho aggiunto qualcosa", false, this.borsaVuota.addAttrezzo(pesante));
    }
}
