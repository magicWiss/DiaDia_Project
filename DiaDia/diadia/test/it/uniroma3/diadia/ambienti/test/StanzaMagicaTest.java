package it.uniroma3.diadia.ambienti.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import it.uniroma3.diadia.ambienti.*;
import it.uniroma3.diadia.attrezzi.*;



public class StanzaMagicaTest 
{
	StanzaMagica magica;
	StanzaMagica nonMagica;
	Attrezzo spada;
	Attrezzo spadaInversa;
	Attrezzo piuma;
	
	@Before
	public void setUp()
	{
		this.magica=new StanzaMagica("magica", 3);
		this.nonMagica= new StanzaMagica("nonMagica", 3);
		this.spada= new Attrezzo("spada", 4);
		this.spadaInversa= new Attrezzo("adaps", 8);
		this.piuma= new Attrezzo("piuma", 1);
		
		//rendo magica la stanza magica
		
		this.magica.addAttrezzo(spada);
		this.magica.addAttrezzo(spada);
		this.magica.addAttrezzo(spada);
		
	}
	
	/*
	 * 
	 * MODIFICA ATTREZZO
	 */
	
	@Test
	public void testModificaAttrezzoSpada()
	{
		this.magica.addAttrezzo(spada);
		assertEquals("Non sono uguali", this.spadaInversa, this.magica.modificaAttrezzo(this.spada));
	}
	@Test
	public void testModificaAttrezzoSpadaInverso()
	{
		this.magica.addAttrezzo(spadaInversa);
		assertEquals("Non sono uguali", new Attrezzo(this.spada.getNome(),this.spadaInversa.getPeso()*2), this.magica.modificaAttrezzo(this.spadaInversa));
	}
	
	/*
	 *ADDATTREZZO() 
	 */
	
	/*
	 * addAttrezzo in stanza vuota
	 */
	@Test
	public void testaddAttrezzoInStanzaVuota()
	{
		int x=this.nonMagica.getContatoreAttrezzi();
		this.nonMagica.addAttrezzo(this.spada);
		assertNotEquals("Non ci sono elementi nella stanza", x,this.nonMagica.getContatoreAttrezzi());
	}
	
	/*
	 * Aggiunta di un attrezzo in magic mode nella stanza vuota
	 * Rende la stanza vuota magica aggiungendot tutti elementi spada
	 * Aggiunge poi un altra spada e controlla se è presente l'attrezzo spadaInverso
	 * 
	 */
	public void settaMagico()
	{
		this.nonMagica.addAttrezzo(this.spada);
		this.nonMagica.addAttrezzo(this.spada);
		this.nonMagica.addAttrezzo(this.spada);
	}
	@Test
	public void testaddAttrezzoMagico()
	{
		settaMagico();		//setta la stanza in modalità magic
		this.nonMagica.addAttrezzo(this.spada);
		assertEquals("Non è presente la spadaInversa", true, this.nonMagica.hasAttrezzo(this.spadaInversa.getNome()));
	}
	
	/*
	 * Aggiunta di un elemento in una stanza piena
	 */
	private void riempiStanza() 
	{
		for(int i=0; i<this.nonMagica.getAttrezzi().length;i++)
		{
			this.nonMagica.addAttrezzo(this.spada);
		}
		
	}
	@Test
	public void testaddAttrezzoStanzaPiena()
	{
		riempiStanza();
		this.nonMagica.addAttrezzo(this.piuma);
		assertEquals("Piuma è presente nella stanza",false, this.nonMagica.hasAttrezzo(this.piuma.getNome()));
		
	}

	
	
	
	

}
