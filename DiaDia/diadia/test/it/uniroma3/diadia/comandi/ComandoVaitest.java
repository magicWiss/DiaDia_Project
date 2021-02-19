package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import it.uniroma3.diadia.*;
import it.uniroma3.diadia.ambienti.*;

public class ComandoVaitest {
	
	Comando vai;	//comando da testare
	Stanza senzaAdiacenze;
	Stanza corrente;	//stanza corrente
	Stanza prossimaNord;	//una qualsiasi stanza prossima a nord della corrente
	Stanza prossimaSud;		//una qualsiasi stanza prossima a sud della corrente
	Stanza prossimaEst;
	Stanza vincente;	//stanza vincente
	Partita partita;	//partita
	IO io;				//io console
	
	
	@Before
	public void setUp()
	{
		this.vai= new ComandoVai();
		
		this.corrente= new Stanza("corrente");
		this.prossimaNord = new Stanza("prossimaNord");
		this.prossimaSud= new Stanza("prossimaSud");
		this.prossimaEst= new Stanza("prossimaEst");
		this.vincente= new Stanza("vincente");
		this.senzaAdiacenze = new Stanza("cieca");
		
		//modello la partita
		this.partita= new Partita();
		this.partita.setStanzaCorrente(this.corrente);
		this.io= new IOConsole();
		
		//creazione collegamenti
		this.corrente.impostaStanzaAdiacente("nord", this.prossimaNord);	//a nord c'è una generica stanza
		this.corrente.impostaStanzaAdiacente("sud", this.prossimaSud);		//a sud c'è una generica stanza
		this.corrente.impostaStanzaAdiacente("est", this.prossimaEst);					//a est non c'è alcuna stanza
		this.corrente.impostaStanzaAdiacente("ovest", this.vincente);		//a ovest c'è la stanza vincente
	}
	 
	
	@Test
	public void test_ComandoVaiNord()
	{
		this.vai.setParametro("nord");
		this.vai.esegui(this.partita, this.io );
		assertEquals("Non sono uguali", this.prossimaNord, this.partita.getStanzaCorrente());
	}
	
	@Test
	public void test_ComandoVaiSud()
	{
		this.vai.setParametro("sud");
		this.vai.esegui(this.partita, this.io);
		assertEquals("Non sono uguali", this.prossimaSud, this.partita.getStanzaCorrente());
	}
	
	@Test 
	public void test_ComandoVaiEst()
	{
		this.vai.setParametro("est");
		this.vai.esegui(this.partita, this.io);
		assertEquals("Non sono uguali", this.prossimaEst, this.partita.getStanzaCorrente());
	}
	
	@Test
	public void test_ComandoVaiOvest()
	{
		this.vai.setParametro("ovest");
		this.vai.esegui(this.partita, this.io);
		assertEquals("Non sono uguali", this.vincente, this.partita.getStanzaCorrente());
	}
	
	@Test
	public void test_ComandoVaiInDirezioneInesistente() {
		this.vai.setParametro("sopra");
		this.vai.esegui(this.partita, this.io);
		assertTrue(this.partita.getStanzaCorrente().equals(corrente));
	}
	
	@Test
	public void test_ComandoVaiInDirezioneNulla() {
		this.vai.setParametro(null);
		this.vai.esegui(this.partita, this.io);
		assertTrue(this.partita.getStanzaCorrente().equals(corrente));
	}
	
	@Test
	public void test_ComandoVaiInUnaDirezioneEsistenteMaNonPresenteNellaStanza() {
		this.partita.setStanzaCorrente(senzaAdiacenze);
		this.vai.setParametro("nord");
		this.vai.esegui(this.partita, this.io);
		assertTrue(this.partita.getStanzaCorrente().equals(senzaAdiacenze));
	}

}
