package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.Before;

import it.uniroma3.diadia.*;
import it.uniroma3.diadia.ambienti.*;
import it.uniroma3.diadia.attrezzi.*;

import org.junit.Test;

public class ComandoPosaTest {
	
	Comando posa;
	Partita partita;
	IO io;
	Attrezzo raro;
	Attrezzo comune;
	Stanza stanzaPiena;
	Stanza stanzaVuota;
	
	@Before 
	public void setUp()
	{
		this.posa=new ComandoPosa();
		this.partita=new Partita();
		this.io=new IOConsole();
		this.stanzaPiena= new Stanza("piena");
		this.stanzaVuota= new Stanza("vuota");
		this.raro= new Attrezzo("raro", 10);
		this.comune = new Attrezzo("comune", 2);
		
		//imposto la stanza 
		this.stanzaPiena.addAttrezzo(this.comune); //1
		this.stanzaPiena.addAttrezzo(this.comune);  //2
		this.stanzaPiena.addAttrezzo(this.comune);//3
		this.stanzaPiena.addAttrezzo(this.comune);//4
		this.stanzaPiena.addAttrezzo(this.comune);//5
		this.stanzaPiena.addAttrezzo(this.comune);//6
		this.stanzaPiena.addAttrezzo(this.comune);//7
		this.stanzaPiena.addAttrezzo(this.comune);//8
		this.stanzaPiena.addAttrezzo(this.comune);//9
		this.stanzaPiena.addAttrezzo(this.comune);//10
		
	}
	/*
	 * LATO STANZA
	 */
	
	/*
	 * posa attrezzo in stanza vuota
	 */
	
	public void settaTest_Comando_posa_in_stanza_vuota()
	{
		this.partita.setStanzaCorrente(this.stanzaVuota);
		this.partita.getGiocatore().getBorsa().addAttrezzo(this.raro);
		//invocazione comando posa
		this.posa.setParametro("raro");
		this.posa.esegui(this.partita, this.io);
	}
	
	@Test
	public void Comando_posa_in_stanza_vuota()
	{	
		settaTest_Comando_posa_in_stanza_vuota();
		assertEquals("raro NON è presente in stanza", true, this.partita.getStanzaCorrente().hasAttrezzo(this.raro.getNome()));
	}
	/*
	 * Posa attrezzo raro in stanza piena di attrezzi comuni
	 */
	
	public void setta_Comando_posa_in_stanza_piena()
	{
		this.partita.setStanzaCorrente(this.stanzaPiena);
		this.partita.getGiocatore().getBorsa().addAttrezzo(this.raro);
		//invocazione comando posa che fallsice in quanto la stanza è piena
		this.posa.setParametro("raro");
		this.posa.esegui(this.partita, this.io);	
	}
	@Test
	public void Comando_posa_in_stanza_piena()
	{
		setta_Comando_posa_in_stanza_piena();
		assertEquals("raro NON è presente in stanza", false, this.partita.getStanzaCorrente().hasAttrezzo(this.raro.getNome()));
	}
	
	//LATO BORSA
	
	/*
	 * Verifica se comando posa rimuove l'elemento dalla borsa piena in stanza vuota
	 */
	public void setta_Comando_posa_in_stanza_vuota_borsa_piena()
	{
		this.partita.setStanzaCorrente(this.stanzaVuota);
		this.partita.getGiocatore().getBorsa().addAttrezzo(this.raro);
		this.posa.setParametro("raro");
		this.posa.esegui(this.partita, this.io);
	}
	
	@Test
	public void Comando_posa_in_stanza_vuota_borsa_piena()
	{
		setta_Comando_posa_in_stanza_vuota_borsa_piena();
		assertEquals("E' presente in borsa", false, this.partita.getGiocatore().getBorsa().hasAttrezzo(this.raro.getNome()));
	}
	
	
	/*
	 * Rimozione attrezzo da una borsa vuota
	 */
	public void setta_Comando_posa_in_stanza_vuota_borsa_vuota()
	{
		this.partita.setStanzaCorrente(this.stanzaVuota);
		this.posa.setParametro("raro");
		this.posa.esegui(this.partita, this.io);
	}
	
	@Test 
	public void Comando_posa_in_stanza_vuota_borsa_vuota()
	{
		setta_Comando_posa_in_stanza_vuota_borsa_vuota();
		assertEquals("La borsa NON è vuota", true, this.partita.getGiocatore().getBorsa().isEmpty());
	}
	
	
	

	

}
