package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.*;

/**
 * Classe Stanza - una stanza in un gioco di ruolo.
 * Una stanza e' un luogo fisico nel gioco.
 * E' collegata ad altre stanze attraverso delle uscite.
 * Ogni uscita e' associata ad una direzione.
 * 
 * @author Wissel
 * @see Attrezzo
 * @version base
 */

public class Stanza {

	static final private int NUMERO_MASSIMO_DIREZIONI = 4;
	static final private int NUMERO_MASSIMO_ATTREZZI = 10;

	private String nome;
	private Attrezzo[] attrezzi;
	private int numeroAttrezzi;
	private Stanza[] stanzeAdiacenti;
	private int numeroStanzeAdiacenti;
	private String[] direzioni;

	/**
	 * Crea una stanza. Non ci sono stanze adiacenti, non ci sono attrezzi.
	 * @param nome il nome della stanza
	 */
	public Stanza(String nome) {
		this.nome = nome;
		this.numeroStanzeAdiacenti = 0;
		this.numeroAttrezzi = 0;
		this.direzioni = new String[NUMERO_MASSIMO_DIREZIONI];
		this.stanzeAdiacenti = new Stanza[NUMERO_MASSIMO_DIREZIONI];
		this.attrezzi = new Attrezzo[NUMERO_MASSIMO_ATTREZZI];
	}

	/**
	 * Imposta una stanza adiacente.
	 *
	 * @param direzione direzione in cui sara' posta la stanza adiacente.
	 * @param stanza stanza adiacente nella direzione indicata dal primo parametro.
	 */
	public void impostaStanzaAdiacente(String direzione, Stanza stanza) {
		boolean aggiornato = false;
		if(direzione!=null)
		{
			for(int i=0; i<this.direzioni.length; i++)
				if (direzione.equals(this.direzioni[i]))
				{
					this.stanzeAdiacenti[i] = stanza;
					aggiornato = true;
				}
			if (!aggiornato)
				if (this.numeroStanzeAdiacenti < NUMERO_MASSIMO_DIREZIONI) {
					this.direzioni[numeroStanzeAdiacenti] = direzione;
					this.stanzeAdiacenti[numeroStanzeAdiacenti] = stanza;
					this.numeroStanzeAdiacenti++;
				}
		}
	}

	/**
	 * Restituisce la stanza adiacente nella direzione specificata
	 * @param direzione
	 */
	public Stanza getStanzaAdiacente(String direzione) {
		Stanza stanza = null;
		for(int i=0; i<this.numeroStanzeAdiacenti; i++)
			if (this.direzioni[i].equals(direzione) && direzione!=null)
				stanza = this.stanzeAdiacenti[i];
		return stanza;
	}
	
	
	
	public Stanza[] getArrayStanze()
	{
		return this.stanzeAdiacenti;
	}

	/**
	 * Restituisce la nome della stanza.
	 * @return il nome della stanza
	 */
	public String getNome() {
		return this.nome;
	}

	/**
	 * Restituisce la descrizione della stanza.
	 * @return la descrizione della stanza
	 */
	public String getDescrizione() {
		return this.toString();
	}

	/**
	 * Restituisce la collezione di attrezzi presenti nella stanza.
	 * @return la collezione di attrezzi nella stanza.
	 */
	public Attrezzo[] getAttrezzi() {
		return this.attrezzi;
	}

	/**
	 * Restituisce il numero di attrezzi presente nella stanza
	 * @return il numero di attrezzi presente nella stanza
	 */
	public int getNumeroAttrezzi() {
		return this.numeroAttrezzi;
	}

	/**
	 * Mette un attrezzo nella stanza.
	 * @param attrezzo l'attrezzo da mettere nella stanza.
	 * @return true se riesce ad aggiungere l'attrezzo, false atrimenti.
	 */
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (this.numeroAttrezzi < NUMERO_MASSIMO_ATTREZZI && attrezzo != null) {
			this.attrezzi[numeroAttrezzi] = attrezzo;
			this.numeroAttrezzi++;
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Restituisce una rappresentazione stringa di questa stanza,
	 * stampadone la descrizione, le uscite e gli eventuali attrezzi contenuti
	 * @return la rappresentazione stringa
	 */
	public String toString() {
		StringBuilder risultato = new StringBuilder();
		risultato.append(this.nome);
		risultato.append("\nUscite: ");
		for (String direzione : this.direzioni)
			if (direzione!=null)
				risultato.append(" " + direzione);
		risultato.append("\nAttrezzi nella stanza: ");
		for (Attrezzo attrezzo : this.attrezzi) {
			if (attrezzo != null) 
				risultato.append(attrezzo.toString()+" ");
		}
		return risultato.toString();
	}

	/**
	 * Restituisce una rappresentazione stringa dei soli attrezzi
	 * contenuti nella stanza
	 * @return rappresentazione stringa
	 */
	public String stampaAttrezziStanza() {
		StringBuilder risultato = new StringBuilder();
		risultato.append("\nAttrezzi nella stanza: ");
		for (Attrezzo attrezzo : this.attrezzi) {
			if (attrezzo != null) 
				risultato.append(attrezzo.toString()+" ");
		}
		return risultato.toString();
	}

	/**
	 * Controlla se un attrezzo esiste nella stanza (uguaglianza sul nome).
	 * @return true se l'attrezzo esiste nella stanza, false altrimenti.
	 */
	public boolean hasAttrezzo(String nomeAttrezzo) {
		if (numeroAttrezzi > 0) {
			for (Attrezzo attrezzo : this.attrezzi) {
				if (attrezzo != null) {
					if (attrezzo.getNome().equals(nomeAttrezzo))
						return true;	
				}
			}
		}
		return false;
	}

	/**
	 * Controlla che la stanza non contenga gi� il numero massimo di attrezzi
	 * @return true se il numero di attrezzi nella stanza � minore del numero
	 * massimo di attrezzi
	 */
	public boolean isNotFull() {
		return this.numeroAttrezzi < NUMERO_MASSIMO_ATTREZZI; 
	}

	/**
	 * Restituisce l'attrezzo nomeAttrezzo se presente nella stanza.
	 * @param nomeAttrezzo
	 * @return l'attrezzo presente nella stanza.
	 * 		   null se l'attrezzo non e' presente.
	 */
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo attrezzoCercato;
		attrezzoCercato = null;
		for (Attrezzo attrezzo : this.attrezzi) {
			if (attrezzo != null)
				if (attrezzo.getNome().equals(nomeAttrezzo))
					attrezzoCercato = attrezzo;
		}
		return attrezzoCercato;	
	}

	/**
	 * Rimuove un attrezzo dalla stanza (ricerca in base al nome).
	 * @param nomeAttrezzo
	 * @return true se l'attrezzo e' stato rimosso, false altrimenti
	 */
	public boolean removeAttrezzo(String  nomeAttrezzo) {
		if (this.numeroAttrezzi > 0 && this.hasAttrezzo(nomeAttrezzo)) {
			for (int i = 0; i < numeroAttrezzi; i++) {
				if (attrezzi[i] != null) {
					if (attrezzi[i].getNome().equals(nomeAttrezzo)) {
						for (int j = i; j < numeroAttrezzi-1; j++) {
							attrezzi[j] = attrezzi[j+1];
						}
						this.numeroAttrezzi--;
						this.attrezzi[numeroAttrezzi] = null;
						return true;
					}
				}

			}
		}
		return false;
	}

	/**
	 * Restituisce la stringa rappresentante le direzioni che consentono do uscire dalla stanza
	 * @return la stringa
	 */
	public String[] getDirezioni() {
		String[] direzioni = new String[this.numeroStanzeAdiacenti];
		for(int i=0; i<this.numeroStanzeAdiacenti; i++)
			direzioni[i] = this.direzioni[i];
		return direzioni;
	}
	
	/**
	 * restituisce l'attrezzo corrente in base all'indice
	 * @param int
	 * @return Attrezzo
	 */
	
	public Attrezzo getAttrezzoIndice(int j)
	{
		return this.attrezzi[j];
	}
	
	/**
	 * Metodo che restituisce il numero di stanze adeacenti [0,4]
	 * @return int 
	 */
	public int getNumeroStanzeAdeacenti()
	{
		return this.numeroStanzeAdiacenti;
	}
	
	public String getNomeStanzaAdeacentePosiesima(int i)
	{
		return this.stanzeAdiacenti[i].getNome();
	}
	
	
	
	@Override
	public boolean equals(Object o)
	{
		Stanza that;
		that=(Stanza)o;
		if(that==null)
		{
			return false;
		}
		 
		//i nomi delle stanze sono univoci
		return (this.getNome().equals(that.getNome()));
		 
	}
	
	public String getDirezioneIesima(int i)
	{
		return this.direzioni[i];
	}
	
	public boolean hasDirezione(String direzione)
	{
		for(int i=0;i<this.direzioni.length;i++)
		{
			if(direzione.equals(this.direzioni[i]))
			{
				return true;
			}
		}
		return false;
	}
	

}