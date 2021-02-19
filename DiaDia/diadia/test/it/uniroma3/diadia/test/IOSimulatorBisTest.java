package it.uniroma3.diadia.test;
import it.uniroma3.diadia.attrezzi.*;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.*;
import it.uniroma3.diadia.ambienti.*;
import it.uniroma3.diadia.comandi.*;

public class IOSimulatorBisTest {
/*	private IOSimulatorBis io;
	private DiaDia test;

	private String rispostaFinale = "Grazie di aver giocato";
	private String rispostaIniziale = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";
	private String comando = "Inserisci comando: ";
	private String[] elencoComandi = {"vai", "aiuto", "fine", "prendi", "posa", "guarda"};
	private String rispostaVaiComandoNullo = "Dove vuoi andare? Devi specificare una direzione";
	private String rispostaVaiDirezioneInesistente = "Direzione inesistente";
	private Stanza stanzaVuota;
	private Attrezzo martello;
	
	@Before
	public void setUp() {
		io = new IOSimulatorBis();
		test = new DiaDia(io);
		stanzaVuota = new Stanza("Stanza");
		martello = new Attrezzo("martello", 1);
	}
	
	/**
	 * test semplice che dà in input il solo comando fine
	 */
	/*@Test
	public void testFine() {
		String output[] = {rispostaIniziale, comando, rispostaFinale};
		io.setComandi("fine");
		test.gioca();
		for (int i = 0; i<output.length; i++) {
			assertTrue(output[i].contentEquals(io.getRisposte()[i]));
		}
	}
	
	/**
	 * costruisce la stringa in risposta al comando aiuto
	 * @return stringa aiuto
	 */
	/*public String outputAiuto() {
		StringBuilder s= new StringBuilder();
		s.append("COMANDI:  ");
		
		for(int i=0; i< elencoComandi.length; i++) 
		{
			s.append(elencoComandi[i]+"\t\t ");
		}
		
		s.append("\nPOSIZIONE: \n");
		s.append("Stanza corrente " + " ");
		s.append(test.getPartita().getStanzaCorrente().getDescrizione());
		return s.toString();
	}
	
	/**
	 * test che manda in input i comandi di aiuto e di fine
	 */
	//@Test
	/*public void testAiutoFine() {
		String output[] =  {rispostaIniziale, comando, this.outputAiuto(), comando,
				rispostaFinale};
		String input[] = {"aiuto", "fine"};
		io.setComandi(input);
		test.gioca();
		for (int i = 0; i<output.length; i++) {
			assertTrue(output[i].equals(io.getRisposte()[i]));
		}
	}
	
	/**
	 * costruisce la stringa in risposta al comando vai in una direzione esistente
	 * @return stringa
	 */
	/*public String outputVaiRiuscito() {
		return this.test.getPartita().getStanzaCorrente().getDescrizione();
	}
	
	/**
	 * test che manda in input il comando aiuto,
	 * un vai in una direzione inesistente e poi il comando fine
	 */
	//@Test
	/*public void testAiutoVaiDirezioneInesistenteFine() {
		String output[] =  {rispostaIniziale, comando, this.outputAiuto(), comando,
				rispostaVaiDirezioneInesistente, comando, rispostaFinale};
		String input[] = {"aiuto", "vai giù", "fine"};
		io.setComandi(input);
		test.gioca();
		for (int i = 0; i<output.length; i++) {
			assertTrue(output[i].equals(io.getRisposte()[i]));
		}
	}
	
	/**
	 * test che manda in input il comando aiuto, un vai in una direzione nulla
	 * e il comando fine
	 */
	//@Test
	/*public void testAiutoVaiDirezioneNullaFine() {
		String output[] =  {rispostaIniziale, comando, this.outputAiuto(), comando,
				rispostaVaiComandoNullo, comando, rispostaFinale};
		String input[] = {"aiuto", "vai  ", "fine"};
		io.setComandi(input);
		test.gioca();
		for (int i = 0; i<output.length; i++) {
			assertTrue(output[i].equals(io.getRisposte()[i]));
		}
	}
	
	/**
	 * test che manda in input il comando di prendere un attrezzo 
	 * presente nella stanza
	 */
	//@Test
	/*public void testPrendiAttrezzoEsistente() {
		this.test.getPartita().setStanzaCorrente(stanzaVuota);
		this.test.getPartita().getStanzaCorrente().addAttrezzo(martello);
		String input[] = {"prendi martello", "fine"};
		io.setComandi(input);
		test.gioca();
		String rispostaPresa = "Hai inserito in borsa " + martello.getNome() + " (" + martello.getPeso() + " kg)"+"\n"+this.test.getPartita().getGiocatore().getBorsa().toString();
		String output[] =  {rispostaIniziale, comando, rispostaPresa, comando, rispostaFinale};
		for (int i = 0; i<output.length; i++) {
			assertTrue(output[i].equals(io.getRisposte()[i]));
		}
	}
	
	/**
	 * test che manda in input il comando di prendere un attrezzo
	 * inesistente nella stanza
	 */
	//@Test
	/*public void testPrendiAttrezzoInesistente() {
		this.test.getPartita().setStanzaCorrente(stanzaVuota);
		this.test.getPartita().getStanzaCorrente().addAttrezzo(martello);
		String input[] = {"prendi chiodo", "fine"};
		String rispostaPrendiAttrezzoInesistente = "Oggetto non presente in stanza."+"\nPrego scegliere tra"+"\n"+this.test.getPartita().getStanzaCorrente().stampaAttrezziStanza();
		io.setComandi(input);
		test.gioca();
		String output[] =  {rispostaIniziale, comando, rispostaPrendiAttrezzoInesistente, comando, rispostaFinale};
		for (int i = 0; i<output.length; i++) {
			assertTrue(output[i].equals(io.getRisposte()[i]));
		}
	}
	
	/**
	 * test che manda in input il comando di posare un attrezzo
	 * esistente nella borsa
	 */
	//@Test
	/*public void testPosaAttrezzoEsistente() {
		this.test.getPartita().setStanzaCorrente(stanzaVuota);
		this.test.getPartita().getGiocatore().getBorsa().addAttrezzo(martello);
		String input[] = {"posa martello", "fine"};
		io.setComandi(input);
		test.gioca();
		String rispostaPosa = "Hai rilasciato dalla borsa " + martello.getNome() + " (" + martello.getPeso() + " kg)"+"\n"+this.test.getPartita().getGiocatore().getBorsa().toString();
        String output[] = {rispostaIniziale, comando, rispostaPosa, comando, rispostaFinale};
        for (int i = 0; i<output.length; i++) {
			assertTrue(output[i].equals(io.getRisposte()[i]));
		}
	}
	
	/**
	 * test che manda in input il comando di posare un attrezzo 
	 * avendo la borsa vuota
	 */
	/*@Test
	public void testPosaAttrezzoBorsaVuota() {
		this.test.getPartita().setStanzaCorrente(stanzaVuota);
		String input[] = {"posa chiodi", "fine"};
		String rispostaPosaAttrezzoBorsaVuota = "Borsa vuota\n==================";
		io.setComandi(input);
		test.gioca();
        String output[] = {rispostaIniziale, comando, rispostaPosaAttrezzoBorsaVuota, comando, rispostaFinale};
        for (int i = 0; i<output.length; i++) {
			assertTrue(output[i].equals(io.getRisposte()[i]));
		}
	}
	
	/**
	 * test che manda in input il comando di posare dalla borsa
	 * un attrezzo non presente nella borsa
	 */
	/*@Test
	public void testPosaAttrezzoInesistente() {
		this.test.getPartita().setStanzaCorrente(stanzaVuota);
		this.test.getPartita().getGiocatore().getBorsa().addAttrezzo(martello);
		String input[] = {"posa chiodi", "fine"};
		io.setComandi(input);
		test.gioca();
		String rispostaPosaAttrezzoInesistente = "Oggetto non presente in borsa.\nPrego scegliere tra"+"\n"+this.test.getPartita().getGiocatore().getBorsa().toString();
        String output[] = {rispostaIniziale, comando, rispostaPosaAttrezzoInesistente, comando, rispostaFinale};
        for (int i = 0; i<output.length; i++) {
			assertTrue(output[i].equals(io.getRisposte()[i]));
		}
	}
	
	//fallisce
	@Test
	public void testAiutoVaiFine() {
		String input[] = {"aiuto", "vai est", "fine"};
		io.setComandi(input);
		test.gioca();
		String output[] =  {rispostaIniziale, comando, this.outputAiuto(), comando,
				this.outputVaiRiuscito(), comando, rispostaFinale};
		for (int i = 0; i<output.length; i++) {
			assertTrue(io.getRisposte()[i].equals(output[i]));
		}
	}
	 */
}
