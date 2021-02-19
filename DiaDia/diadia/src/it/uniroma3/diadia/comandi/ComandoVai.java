package it.uniroma3.diadia.comandi;
/*
 * comandoVai è una classe che gestisce quindi l'implementazione dell'istruzione vai. 
 * E' un sottotito dell'interface Comando e quindi implementa i metodi override
 * 		-esegui
 * 		-setParametro
 */


import it.uniroma3.diadia.*;
import it.uniroma3.diadia.ambienti.*;
/**
 * ComandoVai
 * Implementa Comando
 * Permetto di spostarsi da un stanza ad un altra del labirinto
 * La variabile istanza messaggio permette di memorizzare la stampa a video del comando
 * @author Wissel
 *
 */
public class ComandoVai implements Comando {
	
	private String parametro;
	private String nome;
	private String messaggio;

	public ComandoVai()
	{
		this.nome="vai";
	}
	
	/**
	 * Implementazione del metodo esegui.
	 * @param Partita, IO
	 * @return 
	 */
	@Override
	public void esegui(Partita partita, IO io)
	{	
		StringBuilder s= new StringBuilder();
		Stanza stanzaCorrente=partita.getStanzaCorrente();
		
		Stanza prossimaStanza=null;
		if(this.parametro==null)
		{
			this.setMessaggio("Non hai inserito una direzione\n");
			io.mostraMessaggio(this.getMessaggio());
			return;
		}
		
		prossimaStanza=stanzaCorrente.getStanzaAdiacente(this.parametro);
		
		if(prossimaStanza==null)
		{
			this.setMessaggio("Stanza insesistente!\n");
			io.mostraMessaggio(this.getMessaggio());
			return;
		}
		if(prossimaStanza.equals(stanzaCorrente))
		{
			s.append("Stanza bloccata\n");
			StanzaBloccata that= (StanzaBloccata)partita.getStanzaCorrente();
			s.append("Devi avere " + " '" + that.getAttrezzoSbloccante()+ " ' "+ " per aprire la porta\n");
			this.setMessaggio(s.toString());
			io.mostraMessaggio(this.getMessaggio());
			return;
		}
		
		partita.setStanzaCorrente(prossimaStanza);
		s.append("Ti trovi in : "+ partita.getStanzaCorrente().getNome());
		partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1);
		
		this.setMessaggio(s.toString());
		io.mostraMessaggio(this.getMessaggio());
		
	}
	
	/**
	 * Setta il parametro del istruzione.
	 * @param String
	 * @return 
	 */
	@Override
	public void setParametro(String istruzione)
	{
		this.parametro=istruzione;
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
		ComandoVai that;
		that=(ComandoVai)o;
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
