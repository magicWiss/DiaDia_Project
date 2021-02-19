package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.*;
import it.uniroma3.diadia.giocatore.*;

/**
 * Questa classe modella una partita del gioco
 *
 * @author  docente di POO
 * @see Stanza
 * @see Giocatore
 * @see Labirinto
 * @version base
 */

public class Partita {

	private Stanza stanzaVincente;
	private Stanza stanzaCorrente;
	private Giocatore giocatore;
	private Labirinto labirinto;
	private boolean finita;
	
	public Partita(){
		labirinto = new Labirinto();
		giocatore = new Giocatore();
		labirinto.creaLabirinto();
		this.stanzaVincente = labirinto.getStanzaVincente();
		this.stanzaCorrente = labirinto.getStanzaIngresso();
		this.finita = false;
	}
	
    /**
     * imposta la stanza corrente della partita
     * @param Stanza stanzaCorrente
     */
	public void setStanzaCorrente(Stanza stanzaCorrente) {
		this.stanzaCorrente = stanzaCorrente;
	}
	
	/**
	 * restituisce la stanza corrente della partita
	 * @return Stanza stanzaCorrente
	 */
	public Stanza getStanzaCorrente() {
		return stanzaCorrente;
	}
	
	/**
	 * restituisce la stanza vincente
	 * @return Stanza stanzaVincente
	 */
	public Stanza getStanzaVincente() {
		return stanzaVincente;
	}
	
	/**
	 * restituisce il giocatore
	 * @return Giocatore
	 */
	public Giocatore getGiocatore() {
		return this.giocatore;
	}
	
	/**
	 * Restituisce vero se e solo se la partita e' stata vinta
	 * @return vero se partita vinta
	 */
	public boolean vinta() {
		return this.getStanzaCorrente()== this.getStanzaVincente();
	}

	/**
	 * Restituisce vero se e solo se la partita e' finita
	 * @return vero se partita finita
	 */
	public boolean isFinita() {
		return finita || vinta() || (this.getGiocatore().getCfu() == 0);
	}

	/**
	 * Imposta la partita come finita
	 *
	 */
	public void setFinita() {
		this.finita = true;
	}

	/**
	 * Verifica se il giocatore non ha finito i cfu
	 * @return boolean
	 * 
	 */
	public boolean giocatoreVivo() {
		
		
		return (this.getGiocatore().getCfu()>0);
	}
	/**
	 * getter del labirinto
	 */
	public Labirinto getLab()
	{
		return this.labirinto;
	}
	
}
