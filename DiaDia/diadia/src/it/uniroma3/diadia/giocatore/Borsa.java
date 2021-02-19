package it.uniroma3.diadia.giocatore;

import it.uniroma3.diadia.attrezzi.*;

/**
 * Classe Borsa - rappresenta la borsa del giocatore
 * si occupa di gestire gli attrezzi che il giocatore
 * può collezionare durante il gioco
 * 
 * @author docente di POO
 * @see Attrezzo
 * @see Stanza
 * @version base
 */

public class Borsa {
	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	private Attrezzo[] attrezzi;
	private int numeroAttrezzi;
	private int pesoMax;

	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);
	}

	/**
	 * metodo che si occupa di creare la borsa
	 * non contiene nessun attrezzo
	 * @param pesoMax
	 */
	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new Attrezzo[10]; // speriamo che bastino...
		this.numeroAttrezzi = 0;
	}

	/**
	 * aggiunge un attrezzo alla borsa
	 * @param attrezzo
	 * @return true se l'attrezzo è stato aggiunto con successo, false altrimenti
	 */
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if(attrezzo==null)
			return false;
		if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
			return false;
		if (this.numeroAttrezzi==10)
			return false;
		this.attrezzi[this.numeroAttrezzi] = attrezzo;
		this.numeroAttrezzi++;

		return true;
	}

	/**
	 * restituisce l'intero rappresentante il peso massimo della borsa
	 * @return int pesoMax
	 */
	public int getPesoMax() {
		return pesoMax;
	}

	/**
	 * controlla se la borsa contiene già il numero massimo di attrezzi o ha raggiunto
	 * il peso massimo
	 * @return true se la borsa è piena o ha raggiunto il peso massimo, false altrimenti
	 */
	public boolean isFull() {
		return ((this.getPeso() == this.getPesoMax()) || this.numeroAttrezzi == this.attrezzi.length);
	}

	/**
	 * restituisce un attrezzo cercato in base al nome
	 * @param String nomeAttrezzo
	 * @return Attrezzo cercato
	 */
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;
		for (int i= 0; i<this.numeroAttrezzi; i++) {
			if (this.attrezzi[i] != null) {
				if (this.attrezzi[i].getNome().equals(nomeAttrezzo))
					a = attrezzi[i];
			}
		}
		return a;
	}

	/**
	 * restituisce il peso corrente della borsa
	 * @return int rappresentante il peso
	 */
	public int getPeso() {
		int peso = 0;
		for (int i= 0; i<this.numeroAttrezzi; i++)
			peso += this.attrezzi[i].getPeso();
		return peso;
	}

	/**
	 * controlla se la borsa è vuota
	 * @return true se il numero di attrezzi è uguale a 0, false altrimenti
	 */
	public boolean isEmpty() {
		return this.numeroAttrezzi == 0;
	}

	/**
	 * controlla che l'attrezzo cercato sia presente nella borsa (ricerca in base al nome)
	 * @param nomeAttrezzo
	 * @return true se l'attrezzo è contenuto nella borsa, false altrimenti
	 */
	public boolean hasAttrezzo(String nomeAttrezzo) {
		boolean trovato = false;
		if (numeroAttrezzi > 0 && nomeAttrezzo != null) {
			trovato = (this.getAttrezzo(nomeAttrezzo) != null);
			return trovato;
		}
		else
			return trovato;
	}

	/**
	 * rimuove un attrezzo dalla borsa
	 * @param nomeAttrezzo
	 * @return Attrezzo rimosso
	 */
	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		Attrezzo out=null;
		if (nomeAttrezzo == null || this.numeroAttrezzi == 0 || !this.hasAttrezzo(nomeAttrezzo))
			return out;
		else 
		{
			for (int i = 0; i < this.numeroAttrezzi; i++) 
			{
				if (this.attrezzi[i] != null) {
					if (this.attrezzi[i].getNome().equals(nomeAttrezzo)) 
					{
						out=this.attrezzi[i];
						for (int j = i; j < this.numeroAttrezzi-1; j++) 
						{
							this.attrezzi[j] = this.attrezzi[j+1];
						}
						this.numeroAttrezzi--;
						this.attrezzi[numeroAttrezzi] = null;

					}
				}
			}
		}
		return out;
	}

	/**
	 * restituisce una rappresentazione stringa degli oggetti contenuti nella borsa,
	 * fornendo il nome il peso di ognuno
	 * @return la rappresentazione stringa
	 */
	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		if (!this.isEmpty()) 
		{
			s.append("Contenuto borsa: \n" );
			s.append(this.descrizioneZaino());
			s.append("Peso totale ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
		}
		else
			s.append("Borsa vuota");
		return s.toString();
	}


	/**
	 * metodo che descrive in un formato differente gli attrezzi dello zaino
	 */
	public String descrizioneZaino()
	{
		StringBuilder out=new StringBuilder();
		if(!this.isEmpty())
		{
			for (int i= 0; i<this.numeroAttrezzi; i++)
			{
				out.append(attrezzi[i].toString()+" \n");
			}
		}
		else
		{
			out.append("Borsa vuota");
		}

		return out.toString();
	}

}
