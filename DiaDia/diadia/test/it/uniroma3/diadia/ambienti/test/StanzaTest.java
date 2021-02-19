package it.uniroma3.diadia.ambienti.test;


import it.uniroma3.diadia.ambienti.*;
import it.uniroma3.diadia.attrezzi.*;


import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class StanzaTest {
	private Stanza vuota;
	private Stanza stanzaNord;
	private Stanza stanzaSud;
	private Stanza stanzaEst;
	private Stanza stanzaOvest;
	private Stanza piena;
	public Stanza nullaAd;
	private Attrezzo martello;
	private Attrezzo chiodi;
	private Attrezzo legno;
	private Attrezzo tastiera;
	private Attrezzo mouse;
	private Attrezzo attrezzoNullo;
	
	@Before
	public void setUp() {
		
		this.vuota = new Stanza("Vuota");
		this.stanzaNord = new Stanza("Nord");
		this.stanzaSud = new Stanza("Sud");
		this.stanzaEst = new Stanza("Est");
		this.stanzaOvest = new Stanza("Ovest");
		this.piena = new Stanza("Piena");
		this.nullaAd = new Stanza("Nulla Adiacente");
		this.vuota.impostaStanzaAdiacente("nord", stanzaNord);
		this.vuota.impostaStanzaAdiacente("sud", stanzaSud);
		this.vuota.impostaStanzaAdiacente("est", stanzaEst);
		this.vuota.impostaStanzaAdiacente("ovest", stanzaOvest);
		this.martello = new Attrezzo("Martello", 1);
		this.chiodi = new Attrezzo("Chiodi", 2);
		this.legno = new Attrezzo("Legno", 5);
		this.tastiera = new Attrezzo("Tastiera", 1);
		this.mouse = new Attrezzo("Mouse", 1);
		this.attrezzoNullo = new Attrezzo(null, 0);
		this.piena.addAttrezzo(martello);
		this.piena.addAttrezzo(chiodi);
		this.piena.addAttrezzo(legno);
		this.piena.addAttrezzo(tastiera);
		this.piena.addAttrezzo(mouse);
		this.piena.addAttrezzo(mouse);
		this.piena.addAttrezzo(mouse);
		this.piena.addAttrezzo(mouse);
		this.piena.addAttrezzo(mouse);
		this.piena.addAttrezzo(mouse);
		
	}

	/*Test getStanzaAdiacente*/
	
	/*
	 * STANZA NORD della stanza corrente
	 * return aspettato-->StanzaNord
	 */
	@Test
	public void testAdiacenzeNord() {
		assertEquals("Errore adiacenza nord", stanzaNord, this.vuota.getStanzaAdiacente("nord"));
	}
	@Test
	public void testAdiacenzeSud() {
		assertEquals("Errore adiacenza sud", stanzaSud, this.vuota.getStanzaAdiacente("sud"));
	}
	@Test
	public void testAdiacenzeEst() {
		assertEquals("Errore adiacenza est", stanzaEst, this.vuota.getStanzaAdiacente("est"));
	}
	@Test
	public void testAdiacenzeOvest() {
		assertEquals("Errore adiacenza ovest", stanzaOvest, this.vuota.getStanzaAdiacente("ovest"));
	}
	
	/*
	 * Test che verifica che non si possa andare in una stanza non esistenze
	 * return aspettato-->null
	 */
	@Test
	public void testAdiacenzaNull()
	{
		assertEquals("E' stata presa una stanza", null, this.stanzaNord.getStanzaAdiacente("nord"));
	}
	/*====================================================================*/
	
	/*Test impostaStanzaAdiacente*/
	
	/*
	 * Imposta una stanza in una direzione null
	 * return aspettato-->null
	 */
	@Test
	public void testImpostaDirezioneNulla() {
		this.nullaAd.impostaStanzaAdiacente(null, stanzaEst);
		assertEquals("Errore direzione nulla", null, this.nullaAd.getStanzaAdiacente(null));
	}
	
	/*
	 * imposta una stanza nulla nella direzione sud
	 * return aspettato-->null
	 */
	@Test
	public void testImpostaAdiacenteNulla() {
		this.nullaAd.impostaStanzaAdiacente("sud", null);
		assertEquals("Errore stanza adiacente nulla", null, this.nullaAd.getStanzaAdiacente("sud"));
	}

	/*
	 * imposta una stanza nulla e una direzione nulla 
	 */
	@Test
	public void testTuttoNullo() {
		this.nullaAd.impostaStanzaAdiacente(null, null);
		assertEquals("Errore è tutto nullo", null, this.nullaAd.getStanzaAdiacente(null));
	}

	
	
	/*========================================================================*/
	
	
	/*Test hasAttrezzo*/
	/*
	 * Verifica che nella stanza vi sia il martello
	 * return aspettato-->true
	 */
	@Test
	public void testHasMartello() {
		assertEquals("Non trovo il martello", true, this.piena.hasAttrezzo("Martello"));
	}
	/*
	 * Verifica che nella stanza vi sia un oggetto non presente
	 * return aspettato-->false
	 */
	@Test
	public void testAttrezzoNonPresente() {
		assertEquals("Errore ho trovato qualcosa", false, this.piena.hasAttrezzo("Corda"));
	}
	
	/*
	 * Verifica che nella stanza vi sia un attrezzo nullo
	 * return aspettato-->false
	 */
	@Test
	public void testAttrezzoNullo() {
		assertEquals("Errore ho trovato qualcosa", false, this.piena.hasAttrezzo(attrezzoNullo.getNome()));
	}
	
	/*Test addAttrezzo*/
	
	@Test
	public void testAggiuntaClassica() {
		assertEquals("Non ho aggiunto il martello", true, this.vuota.addAttrezzo(martello));
	}
	
		
	/*
	 * Aggiunta di un attrezzo in una stanza piena
	 * return aspettato-->false
	 */
	@Test
	public void testTroppiAttrezzi() {
		this.piena.addAttrezzo(mouse);
		assertEquals("Errore ho aggiunto il mouse", false, this.piena.addAttrezzo(mouse));
	}
	/*
	 * Aggiunta di un attrezzo null
	 * return aspettato--->false
	 */
	@Test
	public void testAggiuntaNulla() {
		assertEquals("Errore ho restituito true", false, this.piena.addAttrezzo(null));
	}
	
	/*==============================================*/
	
	
	/*Test removeAttrezzo*/
	@Test
	public void testRimozioneClassica() {
		assertEquals("Errore non ho rimosso nulla", true, this.piena.removeAttrezzo("Chiodi"));
	}
	
	/*
	 * Rimozione di un attrezzo nullo
	 * return aspettato-->false
	 */
	@Test
	public void testRimozioneAttrezzoNullo() {
		assertEquals("Errore ho rimosso qualcosa", false, this.piena.removeAttrezzo(null));
	}
	
	/*
	 * Rimozione di un attrezzo non presente in staza
	 * return aspettato--->false
	 */
	@Test
	public void testRimozioneAttrezzoInesistente() {
		assertEquals("Errore ho rimosso qualcosa", false, this.vuota.removeAttrezzo("Chiodi"));
	}
	

}
