package it.uniroma3.diadia.ambienti.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.*;
import it.uniroma3.diadia.attrezzi.*;

public class StanzaBuiatest {
	
	private Stanza buia;
	private Stanza illuminata;
	private Attrezzo pugnale;
	private Attrezzo candela;
	private String avvisoStanzaBuia;

	@Before
	public void setUp()
	{
		this.candela=new Attrezzo("candela", 3);
		this.pugnale = new Attrezzo("pugnale", 1);
		this.buia=new StanzaBuia("buia",this.candela.getNome());
		this.illuminata= new StanzaBuia("nonBuia", this.candela.getNome());
		this.avvisoStanzaBuia="Qui c'è buio pesto";
		
		//rendo illuminata la stanza illuminata
		this.illuminata.addAttrezzo(this.candela);
	}
	
	/*
	 * GetDescrizione
	 */
	@Test
	public void testStanzaBuiaSenzaAttrezzi() {
		assertTrue(buia.getDescrizione().equals(this.avvisoStanzaBuia));
	}
	
	@Test
	public void testStanzaBuiaConAttrezzoNonCandela() {
		buia.addAttrezzo(pugnale);
		assertTrue(buia.getDescrizione().equals(this.avvisoStanzaBuia));
	}
	
	@Test
	public void testStanzaIlluminataConAttrezzoCandela() {
		buia.addAttrezzo(candela);
		assertFalse(buia.getDescrizione().equals(this.avvisoStanzaBuia));
	}
	
	/*
	 * La stanza è buia
	 */
	@Test
	public void testStanzaBuia()
	{
		assertEquals("non sono uguali",this.avvisoStanzaBuia,this.buia.getDescrizione());
	}
	@Test 
	public void testStanzaNonBuia()
	{
		assertNotEquals("sono uguali", this.avvisoStanzaBuia, this.illuminata.getDescrizione());
	}
	@Test
	public void testStanzaBuiaConAttrezzoPugnale() {
		buia.addAttrezzo(pugnale);
		assertTrue(this.avvisoStanzaBuia.equals(this.buia.getDescrizione()));
	}
	
	/*
	 * rimuovo l'elemento illuminante dalla stanza illuminata
	 */
	@Test
	public void testStanzaIlluminataAStanzaBuia()
	{
		this.illuminata.removeAttrezzo(this.candela.getNome());
		assertEquals("Non è buia", this.avvisoStanzaBuia, this.illuminata.getDescrizione());
	}
	

}
