package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.ambienti.*;

import it.uniroma3.diadia.attrezzi.*;
import it.uniroma3.diadia.*;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ComandoPrenditest {

	Partita partita;
	IO io;


	Stanza stanzaVuota;
	Stanza stanzaPiena;

	Attrezzo spada;
	Attrezzo leggero;

	Comando prendi;

	@Before
	public void setUp()
	{
		this.prendi= new ComandoPrendi();
		this.partita= new Partita();
		this.io= new IOConsole();



		//creazione Attrezzi
		this.spada= new Attrezzo("spada", 10);
		this.leggero= new Attrezzo("piuma", 1);


		//creo stanze
		this.stanzaVuota= new Stanza("senza attrezzi");
		this.stanzaPiena = new Stanza("tanti attrezzi");

		//riempio la stanzaPiena
		this.stanzaPiena.addAttrezzo(this.spada);
		this.stanzaPiena.addAttrezzo(this.leggero);

	}
	/*
	 * comando prendi relativo a una stanza vuota con borsa vuota
	 * Confronto il numero di attrezzi in borsa e quello che mi aspetto
	 * return aspettato true
	 */


	/*
	 * RAGIONAMENTO SULLA BORSA
	 */

	/*
	 * test su comando prendi da una borsa vuota in una stanza vuota
	 */

	public void setta_Comando_Prendi_Attrezzo_Stanza_Vuota_In_Borsa_Vuota()
	{
		this.partita.setStanzaCorrente(this.stanzaVuota);

		this.prendi.setParametro("spada");
		this.prendi.esegui(this.partita, this.io);
	}
	@Test
	public void Comando_Prendi_Attrezzo_Stanza_Vuota_In_Borsa_Vuota()
	{
		
		setta_Comando_Prendi_Attrezzo_Stanza_Vuota_In_Borsa_Vuota();
		assertEquals("E' presente un attrezzo in borsa", true, this.partita.getGiocatore().getBorsa().isEmpty());
	}
	/*
	 * Test-->prendo da stanza Piena una spada e verifico se dopo l'inserimento in borsa sia prensente
	 */

	public void setta_Comando_Prendi_da_stanza_piena_una_spada()
	{
		this.partita.setStanzaCorrente(this.stanzaPiena);
		//verifico che la borsa sia vuota

		//chiamata a comando prendi
		this.prendi.setParametro("spada");
		this.prendi.esegui(this.partita, this.io);
	}
	@Test
	public void Comando_Prendi_da_stanza_piena_una_spada()
	{
		setta_Comando_Prendi_da_stanza_piena_una_spada();
		//verifico che in borsa sia presente spada
		assertEquals("NON è presente", true, this.partita.getGiocatore().getBorsa().hasAttrezzo(this.spada.getNome()));
	}

	/*
	 * test comando prendi da stanza piena una attrezzo piuma
	 */
	public void setta_Comando_prendi_da_stanza_piena_una_piuma()
	{
		this.partita.setStanzaCorrente(this.stanzaPiena);
		//verifico nella borsa non sia presente la piuma
	
		//chiamata al comando prendi
		this.prendi.setParametro("piuma");
		this.prendi.esegui(this.partita, this.io);
	}
	@Test
	public void Comando_prendi_da_stanza_piena_una_piuma()
	{
		setta_Comando_prendi_da_stanza_piena_una_piuma();
		//verifico che la piuma sia presente in borsa
		assertEquals("NON è presente la piuma in borsa", true ,this.partita.getGiocatore().getBorsa().hasAttrezzo(this.leggero.getNome()));

	}

	/*
	 * Invocazione comando prendi con una borsa piena.
	 */

	public void setta_Comando_prendi_fallisce_borsa_piena()
	{
		this.partita.setStanzaCorrente(this.stanzaPiena);
		//riempio la borsa
		this.prendi.setParametro("spada");
		this.prendi.esegui(this.partita, this.io);
		this.prendi.setParametro("piuma");
		this.prendi.esegui(this.partita, this.io);
	}
	@Test
	public void Comando_prendi_fallisce_borsa_piena()
	{
		setta_Comando_prendi_fallisce_borsa_piena();
		//borsa piena
		assertEquals("è presente la piuma", false, this.partita.getGiocatore().getBorsa().hasAttrezzo(this.leggero.getNome()));


	}





	/*
	 * RAGIONAMENTO SULLA STANZA
	 *
	 */
	/*
	 * verifico che una volta preso l'oggeto non è piu presente in stanza
	 */
	public void sett_Comando_prendi_da_stanza_piena_e_verifico_che_l_elemento_viene_tolto_dalla_stanza()
	{
		this.partita.setStanzaCorrente(this.stanzaPiena);
		//invoco il comando
		this.prendi.setParametro("spada");
		this.prendi.esegui(this.partita, this.io);
	}
	@Test 
	public void Comando_prendi_da_stanza_piena_e_verifico_che_l_elemento_viene_tolto_dalla_stanza()
	{
		sett_Comando_prendi_da_stanza_piena_e_verifico_che_l_elemento_viene_tolto_dalla_stanza();

		assertEquals("è presente la spada", false, this.partita.getStanzaCorrente().hasAttrezzo(this.spada.getNome()));
	}

	/*
	 * verifico che se prendi fallisce, non vengono tolti gli attrezzi dalla stanza
	 * 
	 */
	public void sett_Comando_prendi_fallisce_in_stanza_piena_NON_DEVE_TOGLIERE_ELEMENTI()
	{
		this.partita.setStanzaCorrente(this.stanzaPiena);
		//riempio la borsa
		this.prendi.setParametro("spada");
		this.prendi.esegui(this.partita, this.io);
		//borsa piena
		assertEquals("è presente la piuma", true, this.partita.getStanzaCorrente().hasAttrezzo(this.leggero.getNome()));
		//prendi piuma fallisce
		this.prendi.setParametro("piuma");
		this.prendi.esegui(this.partita, this.io);
	}
	@Test
	public void Comando_prendi_fallisce_in_stanza_piena_NON_DEVE_TOGLIERE_ELEMENTI()
	{
		sett_Comando_prendi_fallisce_in_stanza_piena_NON_DEVE_TOGLIERE_ELEMENTI();
		//borsa piena
		assertEquals("è presente la piuma", true, this.partita.getStanzaCorrente().hasAttrezzo(this.leggero.getNome()));
	}





}
