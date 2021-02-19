package it.uniroma3.diadia.test;

import static org.junit.Assert.*;
import it.uniroma3.diadia.ambienti.*;
import it.uniroma3.diadia.attrezzi.*;
import it.uniroma3.diadia.comandi.*;
import it.uniroma3.diadia.giocatore.*;
import it.uniroma3.diadia.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Simulaotre di partite.
 * Poichè ogni comando in tutti i casi stampa una stringa specifica, il test si basa sul confronto tra la stringa
 * stampata a video di un comando e una stringa creata standard all'interno del test case.
 * Iterativamente si va a prendere un istruzione dall'array di istruzioni di IOSimulator, si invoca il comando e lo si 
 * confornta con la stampa aspettata.
 * Per fare ciò ho modificato leggermente le classi comando inserendo una variabile istanza Messaggio, che permette di 
 * memorizzare il messaggio stampato a video dal comando e stamparlo tramite IOConsole.
 * IL LAVORO NON E' ANCORA TERMINATO.
 * @author Wissel
 *
 */


public class IOSimulatortest {

	private DiaDia diadia;
	private IOSimulator simulatore;
	private Partita partita2;
	private Stanza stanzaIniziale;
	private Stanza stanza1;
	private Stanza stanza2;
	private Stanza stanza3;
	private Stanza stanzaVincente;
	private Attrezzo attrezzoStanza;
	private IO console;


	//Stringhe di messaggio
	private String messaggioFine;
	private String messaggioAiuto;
	private String messaggioNonValido;
	private String messaggioVaiNordValido;
	private String messaggioPrendiValido;
	//String BUilder
	










	@Before
	public void setUp()
	{

		this.diadia=new DiaDia();
		this.simulatore=new IOSimulator();
		this.partita2=this.diadia.getPartita();
		this.stanzaIniziale=new Stanza("inizio");
		this.stanza1=new Stanza("stanza1");
		this.stanza2=new Stanza("stanza2");
		this.stanza3=new Stanza("stanza3");
		this.stanzaVincente=new Stanza("fine");
		//creazione labirinto
		this.partita2.getLab().setVincente(stanzaVincente);
		this.partita2.getLab().setIniziale(stanzaIniziale);
		this.stanzaIniziale.impostaStanzaAdiacente("nord",stanza1);
		this.stanza1.impostaStanzaAdiacente("sud", stanzaIniziale);
		this.stanza1.impostaStanzaAdiacente("nord",stanza2);
		this.stanza2.impostaStanzaAdiacente("sud", stanza1);
		this.stanza2.impostaStanzaAdiacente("nord", stanza3);
		this.stanza3.impostaStanzaAdiacente("sud", stanza2);
		this.stanza3.impostaStanzaAdiacente("nord", stanzaVincente);
		this.stanzaVincente.impostaStanzaAdiacente("sud", stanza3);

		//attrezzi
		this.attrezzoStanza=new Attrezzo("attrezzo",2);
		this.stanzaIniziale.addAttrezzo(this.attrezzoStanza);
		this.stanza1.addAttrezzo(this.attrezzoStanza);
		this.stanza3.addAttrezzo(this.attrezzoStanza);
		this.stanza2.addAttrezzo(this.attrezzoStanza);


		//StringBuilder
		this.console=new IOConsole();


		//messaggiOutput
		this.messaggioFine="GAME-OVER\n";
		this.messaggioAiuto="COMANDI: vai\t\t aiuto\t\t fine\t\t prendi\t\t posa\t\t guarda\t\t ";
		this.messaggioNonValido="Il comando inserito non è valido.";
		

		
		
		
		
		




		this.simulatore.setIesimoElemento("aiuto", 0);
		this.simulatore.setIesimoElemento("fine", 1);
		this.simulatore.setIesimoElemento("non valdio", 2);
		this.simulatore.setIesimoElemento("vai nord", 3);
		this.simulatore.setIesimoElemento("prendi attrezzo", 4);


	}

	

	//partita1
	public Comando fabbricacomando(int i) 
	{
		FabbricaComando factory= new FabbricaComandoFisarmonica();
		Comando out=factory.costruisciComando(this.simulatore.leggiIesimoELemento(i));
		return out;

	}

	@Test
	public void testIstruzione1()
	{
		Comando corrente=fabbricacomando(1);
		corrente.esegui(partita2,this.console);
		assertEquals("Le stinghe non sono uguali",this.messaggioFine,corrente.getMessaggio());
	}

	@Test 
	public void  testIstruzione2()
	{
		Comando corrente2=fabbricacomando(0);
		corrente2.esegui(partita2,this.console );
		assertEquals("Le stinghe non sono uguali",this.messaggioAiuto,corrente2.getMessaggio());
	}

	@Test
	public void testIstruzione3()
	{
		Comando corrente2=fabbricacomando(2);
		corrente2.esegui(partita2,this.console );
		assertEquals("Le stinghe non sono uguali",this.messaggioNonValido,corrente2.getMessaggio());
	}
	
	
	
	public void setUpVaiNord(Comando corrente)
	{
		this.messaggioVaiNordValido="Ti trovi in : "+ this.partita2.getStanzaCorrente().getStanzaAdiacente("nord").getNome();
		
		corrente.esegui(partita2,this.console);
	}
	
	@Test
	public void testComandoVaiNord()
	{
		Comando corrente=fabbricacomando(3);
		setUpVaiNord(corrente);
		
		assertEquals("Le stringhe non sono uguali", this.messaggioVaiNordValido, corrente.getMessaggio());
	}
	
	/*
	@Test 
	public void testComandoPrendiValido()
	{
		Comando corrente=fabbricacomando(4);
		setUpComandoPrendi();
		corrente.esegui(this.partita2, this.console);
		assertEquals("Le stringhe inserite non sono uguali", this.messaggioPrendiValido, corrente.getMessaggio());
	}



	public void setUpComandoPrendi() {
		StringBuilder x= new StringBuilder();
		x.append("Hai inserito in borsa ");
		x.append(this.partita2.getStanzaCorrente().getAttrezzo(this.attrezzoStanza.getNome()).getNome());
		x.append( " (" +this.partita2.getStanzaCorrente().getAttrezzo(this.attrezzoStanza.getNome()).getPeso() + " kg)\n");
		x.append(this.partita2.getGiocatore().getBorsa().toString());
		x.append("\n=====\n");
		this.messaggioPrendiValido=x.toString();
		
	}*/
	
	
	
		
	
	
	



}
