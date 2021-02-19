package it.uniroma3.diadia.comandi;


import it.uniroma3.diadia.*;
import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * ComandoPosa
 * Implementa Comando
 * Permette di posare un attrezzo dalla borsa nella stanza corrente
 * La variabile istanza messaggio permette di memorizzare la stampa a video del comando
 * @author Wissel
 *
 */
public class ComandoPosa implements Comando {

	private String parametro;
	private String nome;
	private String messaggio;

	public ComandoPosa()
	{
		this.nome="posa";
	}
	/**
	 * Implemetazione del metodo SetParametro dell'interface Comando.
	 * Setta il nome dell'attrezzo da posare dalla borsa
	 * @param String
	 */
	@Override
	public void setParametro(String parametro)
	{
		this.parametro=parametro;
	}

	/**
	 * Implementazione del metodo esegui dell'interface Comando.
	 * Permette di posare un attrezzo dalla borsa nella stanza.
	 * @param Partita, IO
	 * @return 
	 */
	@Override
	public void esegui(Partita partita, IO io)
	{
		StringBuilder s= new StringBuilder();
		
		if(this.parametro==null)
		{
			s.append("Cosa vuoi posare?\n");
			s.append("Prego scegliere tra: \n");
			
			s.append(partita.getGiocatore().getBorsa().toString());
			s.append("\n");
			this.setMessaggio(s.toString());
			io.mostraMessaggio(this.getMessaggio());
			
			
			return;
		}
		if(partita.getGiocatore().getBorsa().isEmpty())
		{
			s.append("Borsa vuota\n");
			s.append("=====\n");
			this.setMessaggio(s.toString());
			io.mostraMessaggio(this.getMessaggio());
			return;
		}

		//se si vuole posare un attrezzo non presente in borsa
		if(!partita.getGiocatore().getBorsa().hasAttrezzo(this.parametro))
		{
			s.append("Oggetto non presente in borsa.\n");
			s.append("Prego scegliere tra: \n");
			
			s.append(partita.getGiocatore().getBorsa().toString());
			this.setMessaggio(s.toString());
			io.mostraMessaggio(this.getMessaggio());
			
			return;
		}

		//se la stanza non contiene già il numero massimo di attrezzi
		if(partita.getStanzaCorrente().isNotFull())
		{
			//rimuovo l'attrezzo dalla borsa
			Attrezzo attrezzoPosato= partita.getGiocatore().getBorsa().removeAttrezzo(this.parametro);
			s.append("Hai rilasciato dalla borsa " + attrezzoPosato.getNome() + " (" + attrezzoPosato.getPeso() + " kg)\n");
			//lo aggiungo alla stanza
			partita.getStanzaCorrente().addAttrezzo(attrezzoPosato);
			s.append(partita.getGiocatore().getBorsa().toString());
		}
		else
		{
			s.append("Non c'è posto nella stanza. Impossibile posare l'oggetto\n");
		}
		s.append("\n=====");
		this.setMessaggio(s.toString());
		io.mostraMessaggio(this.getMessaggio());
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
		ComandoPosa that;
		that=(ComandoPosa)o;
		return (this.getNome().equals(that.getNome()) && this.getParametro().equals(that.getParametro()));
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
