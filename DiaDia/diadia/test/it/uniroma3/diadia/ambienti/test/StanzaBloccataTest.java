package it.uniroma3.diadia.ambienti.test;

import static org.junit.Assert.*;

import org.junit.Before;

import it.uniroma3.diadia.attrezzi.*;

import org.junit.Test;
import it.uniroma3.diadia.ambienti.*;
public class StanzaBloccataTest {

	private Stanza nonBloccata;		//stanza  NON bloccata
	private Stanza bloccata;		//stanza bloccata
	private Stanza est;				//stanza est
	private Stanza ovest;			//stanza ovest
	private Stanza nord;			//stanza nord
	private Stanza sud;				//stanza sud
	private Attrezzo chiave;		//attrezzo chiave che sblocca la porta
	private Attrezzo martello;      //attrezzo che non sblocca la porta
	private String direzioneBloccata;	//direzione bloccata

	
	@Before
	public void setUp()
	{
		this.chiave= new Attrezzo("chiave", 1);
		this.martello = new Attrezzo("martello", 1);
		this.direzioneBloccata="est";
		this.nonBloccata=new StanzaBloccata("nonBloccata",this.chiave.getNome(), this.direzioneBloccata);
		this.bloccata= new StanzaBloccata("bloccata", this.chiave.getNome(), this.direzioneBloccata);
		this.est= new Stanza("est");
		this.nord= new Stanza("nord");
		this.ovest= new Stanza("ovest");
		this.sud= new Stanza("sud");
		
		
		//sblocco la stanza
		this.nonBloccata.addAttrezzo(this.chiave);
		//poso l'attrezzo non sbloccante nella stanza bloccata
		this.bloccata.addAttrezzo(this.martello);
		//setto le stanze della stanza non bloccata
		this.nonBloccata.impostaStanzaAdiacente("nord", this.nord);
		this.nonBloccata.impostaStanzaAdiacente("sud", this.sud);
		this.nonBloccata.impostaStanzaAdiacente("ovest", this.ovest);
		this.nonBloccata.impostaStanzaAdiacente("est", this.est);
		//setto le stanze  della stanza bloccata

		this.bloccata.impostaStanzaAdiacente("nord", this.nord);
		this.bloccata.impostaStanzaAdiacente("sud", this.sud);
		this.bloccata.impostaStanzaAdiacente("ovest", this.ovest);
		this.bloccata.impostaStanzaAdiacente("est", this.est);
		
		
	}
	
	/*
	 * Test del metodo getStanzaAdeacente direzione bloccata EST
	 */
	
	
	/*SENZA CHIAVE
	 * provo ad andare nella direzione est senza chiave [Direzione Bloccata]
	 */
	@Test
	public void testStanzaBloccatadirezioneBloccata()
	{
		assertEquals("non sono uguali", this.bloccata, this.bloccata.getStanzaAdiacente(this.direzioneBloccata));
	}
	
	/*
	 * provo ad andare nella direzione ovest senza chiave
	 */
	@Test
	public void testStanzaBloccataDirezioneNonBloccataOvest()
	{
		assertEquals("Non sono uguali", this.ovest, this.bloccata.getStanzaAdiacente("ovest"));
	}
	/*
	 * povo ad andare nella direzione nord senza chiave
	 */
	@Test
	public void testStanzaBloccataDirezioneNonBloccataNord()
	{
		assertEquals("Non sono uguali", this.nord, this.bloccata.getStanzaAdiacente("nord"));
	}
	/*
	 * povo ad andare nella direzione sud senza chiave
	 */
	@Test
	public void testStanzaBloccataDirezioneNonBloccataSud()
	{
		assertEquals("Non sono uguali", this.sud, this.bloccata.getStanzaAdiacente("sud"));
	}
	
	/*
	 * provo ad andare nella direzione est (bloccata) con l'attrezzo non sbloccante
	 */
	@Test
	public void testDirezioneBloccataConAttrezzoNonSbloccante() {
		assertTrue(this.bloccata.getStanzaAdiacente(this.direzioneBloccata).equals(bloccata));
	}
	
	/*
	 * provo ad andare nella direzione non bloccata con l'attrezzo non sbloccante
	 */
	@Test 
	public void testDirezioneNonBloccataConAttrezzoNonSbloccante() {
		assertTrue(this.bloccata.getStanzaAdiacente("sud").equals(this.sud));
	}
	
	/*
	 * CON LA CHIAVE
	 */
	@Test
	public void testStanzaNONBloccatadirezioneBloccata()
	{
		assertEquals("non sono uguali", this.est, this.nonBloccata.getStanzaAdiacente(this.direzioneBloccata));
	}
	
	/*
	 * provo ad andare nella direzione ovest con la chiave
	 */
	@Test
	public void testStanzaNONBloccataDirezioneNonBloccataOvest()
	{
		assertEquals("Non sono uguali", this.ovest, this.nonBloccata.getStanzaAdiacente("ovest"));
	}
	/*
	 * povo ad andare nella direzione nord con chiave
	 */
	@Test
	public void testStanzaNONBloccataDirezioneNonBloccataNord()
	{
		assertEquals("Non sono uguali", this.nord, this.nonBloccata.getStanzaAdiacente("nord"));
	}
	/*
	 * povo ad andare nella direzione sud con la  chiave
	 */
	@Test
	public void testStanzaNONBloccataDirezioneNonBloccataSud()
	{
		assertEquals("Non sono uguali", this.sud, this.nonBloccata.getStanzaAdiacente("sud"));
	}
	

}
