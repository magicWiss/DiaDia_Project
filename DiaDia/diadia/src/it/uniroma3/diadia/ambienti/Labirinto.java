package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.*;

/**
 * Classe che si occupa di modellare il labirinto di
 * stanze e di posizionare all'interno delle stanze 
 * gli attrezzi
 * @author  docente di POO
 * @see Stanza
 * @see Attrezzo
 * @version base
 */

public class Labirinto {
    private Stanza stanzaIngresso;
	private Stanza stanzaVincente;
	
	public void creaLabirinto() {
		init();
	}
	
	/**
	 * Metodo che si occupa di inizializzare il labirinto 
	 * posizionando anche i vari attrezzi all'interno 
	 * delle stanze
	 */
	public void init() {
		/* crea gli attrezzi*/
    	Attrezzo lanterna = new Attrezzo("lanterna",3);
		Attrezzo osso = new Attrezzo("osso",1);
		Attrezzo chiave = new Attrezzo("chiave", 3);
		
	   
	    /* crea stanze del labirinto */
	    Stanza atrio = new Stanza("Atrio");
	    Stanza aulaN11 = new Stanza("Aula N11");
	    Stanza aulaN10 = new Stanza("Aula N10");
	    Stanza laboratorio = new Stanza("Laboratorio Campus");
	    Stanza biblioteca = new Stanza("Biblioteca");
	    Stanza bloccata = new StanzaBloccata("BLOCCATA", "chiave", "est");
	    Stanza nonBloccata = new StanzaBloccata("NON BLOCCATA", "chiave", "nord");
	    Stanza magica= new StanzaMagica("MAAGICA", 2);
	    Stanza buia=new StanzaBuia("BUIA", "candela");
	    Stanza illuminata= new StanzaBuia("Illuminata","lanterna");
	
	    /* collega le stanze */
	    atrio.impostaStanzaAdiacente("nord", biblioteca);
	    atrio.impostaStanzaAdiacente("est", nonBloccata);
	    atrio.impostaStanzaAdiacente("sud", bloccata);
	    atrio.impostaStanzaAdiacente("ovest", magica);
	    
	    //bloccata
	    bloccata.impostaStanzaAdiacente("nord", atrio);
	    bloccata.impostaStanzaAdiacente("est",biblioteca);
	    
	    //non bloccata
	    nonBloccata.impostaStanzaAdiacente("ovest", atrio);
	    nonBloccata.impostaStanzaAdiacente("nord", aulaN11);
	    
	    //magica
	    
	    magica.impostaStanzaAdiacente("nord", laboratorio);
	    magica.impostaStanzaAdiacente("sud", illuminata);
	    magica.impostaStanzaAdiacente("est", atrio);
	    
	    //illuminata
	    illuminata.impostaStanzaAdiacente("nord", magica);
	    
	    //alula n11
	    aulaN11.impostaStanzaAdiacente("est", laboratorio);
	    aulaN11.impostaStanzaAdiacente("ovest", buia);
	   
	    aulaN11.impostaStanzaAdiacente("sud", nonBloccata);
	    // buia
	    buia.impostaStanzaAdiacente("est", aulaN11);
	    buia.impostaStanzaAdiacente("ovest", aulaN10);
	    
	    //N10
	    aulaN10.impostaStanzaAdiacente("nord", atrio);
	    aulaN10.impostaStanzaAdiacente("est", buia);
	    aulaN10.impostaStanzaAdiacente("ovest", laboratorio);
	    //lab
	    laboratorio.impostaStanzaAdiacente("est", aulaN10);
	    laboratorio.impostaStanzaAdiacente("ovest", aulaN11);
	    laboratorio.impostaStanzaAdiacente("sud",magica);
	    
	    biblioteca.impostaStanzaAdiacente("sud", atrio);
	    
        /* pone gli attrezzi nelle stanze*/ 
		aulaN10.addAttrezzo(lanterna);
		atrio.addAttrezzo(osso);
		illuminata.addAttrezzo(lanterna);
		nonBloccata.addAttrezzo(chiave);
		magica.addAttrezzo(osso);
		
		stanzaIngresso = atrio;
		stanzaVincente = biblioteca;
	
	}
	
	/**
	 * Metodo che restituisce la stanza vincente
	 * @return la stanza vincente
	 */
	public Stanza getStanzaVincente() {
		return stanzaVincente;
	}
	
	/**
	 * Metodo che restituisce la stanza di partenza
	 * @return la stanza d'ingresso
	 */
	public Stanza getStanzaIngresso() {
		return stanzaIngresso;
	}
	
	/**
	 * Metodo per il test
	 * 
	 */
	public void setVincente(Stanza x)
	{
		this.stanzaVincente=x;
	}
	/**
	 * Setter della stanza iniziale
	 * metodo per il test di simulazione partita
	 */
	public void setIniziale(Stanza x)
	{
		this.stanzaIngresso=x;
	}
	

}
