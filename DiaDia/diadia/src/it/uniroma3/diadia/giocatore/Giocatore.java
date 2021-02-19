package it.uniroma3.diadia.giocatore;

/**
 * Classe Giocatore - la classe modella il giocatore
 * il giocatore si occupa di gestire la borsa e i CFU
 * @author docente di POO
 * @see Borsa
 * @version base
 */

public class Giocatore {
	static final private int CFU_INIZIALI = 20;
	private int cfu;
	private Borsa borsa;
	
	public Giocatore() {
		this.cfu = CFU_INIZIALI;
		this.borsa = new Borsa();
	}
	
	/*Gestione Cfu*/
	
	/**
	 * restituisce il numero di CFU
	 * @return numero intero di CFU
	 */
	public int getCfu() {
		return this.cfu;
	}
	
	/**
	 * Imposta il numero di CFU
	 * @param cfu
	 */
	public void setCfu(int cfu) {
		this.cfu = cfu;
	}
	
	/*Gestione borsa*/
	
	/**
	 * restituisce la borsa del giocatore
	 * @return Borsa del giocatore
	 */
	public Borsa getBorsa() {
		return this.borsa;
	}
	public int getCFUINIZIALI()
	{
		return CFU_INIZIALI;
	}
	
}
