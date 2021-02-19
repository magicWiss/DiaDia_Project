package it.uniroma3.diadia.comandi;

/*
 * Interface di tipo comando.
 * Utilizzata per gestire i diversi comandi che sono presneti nel gioco, esonerando la classe
 * diadia all' esecuzione e interpretazione dei comandi.
 */
/**
 * Interface di tipo comando
 * Super tipo di ogni classe comando
 * @author Wissel
 */
import it.uniroma3.diadia.*;

public interface Comando {
	
	/**
	 * esegue l'istruzione
	 */
	public void esegui(Partita partia, IO io);
	
	/**
	 * setta il parametro del comando
	 * 
	 */
	public void setParametro(String parametro);
	
	/**
	 * getter nome
	 */
	public String getNome();
	
	/**
	 * getter parametro
	 */
	public String getParametro();
	
	/**
	 * getter del messaggio stampato a video
	 */
	public String getMessaggio();
	
	/**
	 * setter del messaggio stampato a video
	 * 
	 */
	public void setMessaggio(String x);
}
