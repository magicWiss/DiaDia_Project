package it.uniroma3.diadia.comandi;


import it.uniroma3.diadia.*;

/**
 * Comando aiuto.
 * Implementa Comando
 * Permette al giocatore di visualizzare tutte i possibili comando offerti dal gioco
 * La variabile istanza messaggio permette di memorizzare la stampa a video del comando
 * @author Wissel
 *
 */
public class ComandoAiuto implements Comando
{
	private static final String[] elencoComandi= {"vai", "aiuto", "fine", "prendi", "posa", "guarda"};
	private String nome;
	private String parametro;
	private String messggio;
	
	public ComandoAiuto()
	{
		this.nome= "aiuto";
	}
	
	@Override
	public void esegui(Partita partita, IO io)
	{
		StringBuilder s= new StringBuilder();
		s.append("COMANDI: ");
		
		for(int i=0; i< elencoComandi.length; i++) 
		{
			s.append(elencoComandi[i]+"\t\t ");
		}
		this.setMessaggio(s.toString());
		s.append("\n=====");
		
		io.mostraMessaggio(this.getMessaggio());
		
	}
	/**
	 * Implementa il metodo setParametro dell' interface Comando.
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
		ComandoAiuto that;
		that=(ComandoAiuto)o;
		return (this.getNome().equals(that.getNome()));
	}
	
	@Override
	/**
	 * set messaggio
	 */
	public void setMessaggio(String x)
	{
		this.messggio=x;
	}
	
	@Override
	/**
	 * Getter messaggio
	 */
	public String getMessaggio()
	{
		return this.messggio;
	}
	


}
