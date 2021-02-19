package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.*;
/**
 * ComandoFine
 * Implementa Comando
 * perfette al giocatore di terminare la partita
 * La variabile istanza messaggio permette di memorizzare la stampa a video del comando
 * @author Wissel
 *
 */
public class ComandoFine  implements Comando{
	
	private String nome;
	private String parametro;
	private String messaggio;
	
	public ComandoFine()
	{
		this.nome="fine";
	}
	
	/**
	 * Implentazione comando esegui interface Comando
	 * Setta la partita finita
	 * @param Partita, IO
	 * @return 
	 */
	@Override 
	public void esegui(Partita partita, IO io)
	{
		this.setMessaggio("GAME-OVER\n");
		io.mostraMessaggio(this.getMessaggio());
		partita.setFinita();
	}

	/**
	 * Implementa il metodo esegui dell' interface Comando.
	 * Non setta parametro
	 * @param String
	 */
	@Override
	public void setParametro(String parametro)
	{
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
		ComandoFine that;
		that=(ComandoFine)o;
		return (this.getNome().equals(that.getNome()));
	}
	
	@Override
	public String getMessaggio()
	{
		return this.messaggio;
	}
	@Override
	public void setMessaggio(String x)
	{
		this.messaggio=x;
	}


}
