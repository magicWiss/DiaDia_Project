package it.uniroma3.diadia.comandi;


import it.uniroma3.diadia.*;
/**
 * ComandoNonValido
 * Stampa un messaggio di error nel caso di inserimento di un comando non offerto
 * Implementa Comando
 * La variabile istanza messaggio permette di memorizzare la stampa a video del comando
 * @author Wissel
 *
 */

public class ComandoNonValido implements Comando {

	private String nome;
	private String parametro;
	private String messaggio;
	
	public ComandoNonValido()
	{
		this.nome="nonValido";
	}
	/**
	 * Implemetazione del comando esegui dell'interface Comando.
	 * Stampa un messaggio di error se un comando inserito non è riconosciuto
	 * @param Partita, IO
	 */
	@Override
	public void esegui(Partita partita, IO io) {
		
		this.setMessaggio("Il comando inserito non è valido.");
		io.mostraMessaggio(this.getMessaggio());

	}

	/**
	 * Implementa il metodo esegui dell' interface Comando.
	 * Non setta parametro
	 * @param String
	 */

	@Override
	public void setParametro(String Parametro) {
		return;

	}
	/**
	 * Implementa il metodo getNome dell'interface comando
	 */
	@Override
	public String getNome()
	{
		return this.nome;
	}
	/**
	 * Implementa il metodo getParametro dell'interface comando
	 */
	@Override
	public String getParametro()
	{
		return this.parametro;
	}

	@Override
	public boolean equals(Object o)
	{
		ComandoNonValido that;
		that=(ComandoNonValido)o;
		return (this.getNome().equals(that.getNome()));
	}
	@Override
	public String getMessaggio() {
		return this.messaggio;
	}
	@Override
	public void setMessaggio(String x) {
		this.messaggio=x;
		
	}


}
