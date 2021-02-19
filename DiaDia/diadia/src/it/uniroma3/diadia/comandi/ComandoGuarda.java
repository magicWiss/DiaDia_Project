package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.*;

/**
 * ComandoGuarda
 * Implementa Comando
 * permette al giocatore di vedere: la descrizione della stanza corrente
 * 									lo stato della borsa
 * 									lo stato della partita
 * La variabile istanza messaggio permette di memorizzare la stampa a video del comando
 * @author Wissel
 *
 */
public class ComandoGuarda implements Comando{

	private StringBuilder s;
	private String nome;
	private String parametro;
	private String messaggio;
	
	public ComandoGuarda()
	{
		this.s=new StringBuilder();
		this.nome="guarda";
	}
	
	/**
	 * Implementa il metodo esegui dell'interface Comando
	 * Permette al giocatore di: 1)vedere in che stanza si trova, le uscite a disposizone, gli attrezzi presenti
	 * 							2)vedere lo stato della sua borsa
	 * 							3)lo stato dei cfu
	 * @param Partita, IO
	 * @return
	 */
	@Override
	public void esegui(Partita partita, IO io) 
	{
		
		
		//info sulla stanza e sugli oggetti in stanza
		this.s.append("\nPOSIZIONE: \n");
		this.s.append("Stanza corrente " + " ");
		this.s.append(partita.getStanzaCorrente().getDescrizione());
		this.s.append("\n-----------");
		this.s.append("\nBORSA");
		this.s.append("\n"+ partita.getGiocatore().getBorsa().descrizioneZaino());
		this.s.append("\n-----------");
		this.s.append("\nMOSSE");
		this.s.append("\nHai " + partita.getGiocatore().getCfu() + "/" +partita.getGiocatore().getCFUINIZIALI());
		this.s.append("\n=====");
		this.setMessaggio(this.s.toString());
		io.mostraMessaggio(this.getMessaggio());
			
		
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
		ComandoGuarda that;
		that=(ComandoGuarda)o;
		return (this.getNome().equals(that.getNome()));
	}

	@Override
	public String getMessaggio() {
		return this.messaggio;
	}

	@Override
	public void setMessaggio(String x) 
	{
		this.messaggio=x;
		
	}

	

}
