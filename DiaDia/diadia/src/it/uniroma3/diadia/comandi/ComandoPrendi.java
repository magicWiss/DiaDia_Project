package it.uniroma3.diadia.comandi;


import it.uniroma3.diadia.*;
import it.uniroma3.diadia.attrezzi.Attrezzo;
/**
 * ComandoPrendi
 * Implementa Comando
 * Permette di prendere un attrezzo dalla stanza corrente ed inserirlo nella borsa.
 * La variabile istanza messaggio permette di memorizzare la stampa a video del comando
 * @author Wissel
 *
 */
public class ComandoPrendi implements Comando{
	
	private String parametro;
	private String nome;
	private String messaggio;
	
	public ComandoPrendi()
	{
		this.nome= "prendi";
	}
	/**
	 * Implementazione metodo esegui dell'nterface Comando
	 * Permette al giocatore di prendere oggetti nella stanza e inserirli in borsa
	 * @param Partita, IO
	 */
	@Override
	public void esegui(Partita partita, IO io)
	{
		StringBuilder s= new StringBuilder();
		//se  non c'è nulla da prendere in stanza
				if(partita.getStanzaCorrente().getNumeroAttrezzi()==0)
				{
					this.setMessaggio("Nella stanza non sono prensenti attrezzi");
					io.mostraMessaggio(this.getMessaggio());
					return;
				}
				
				//se è stato inserito il comando prendi senza parametro
				if(this.parametro==null)
				{
					s.append("Cosa vuoi prendere?\n");
					s.append("Prego scegliere tra: \n");
					s.append(partita.getStanzaCorrente().stampaAttrezziStanza());
				}
				
				//se si vuole prendere un attrezzo non presente in stanza
				if(!partita.getStanzaCorrente().hasAttrezzo(this.parametro)) {
					s.append("Oggetto non presente in stanza.\n");
					s.append("Prego scegliere tra: \n");
					s.append(partita.getStanzaCorrente().stampaAttrezziStanza());
				}
				
				Attrezzo attrezzoPreso=partita.getStanzaCorrente().getAttrezzo(this.parametro);
				if(partita.getGiocatore().getBorsa().addAttrezzo(attrezzoPreso))
				{
					s.append("Hai inserito in borsa " + attrezzoPreso.getNome() + " (" + attrezzoPreso.getPeso() + " kg)\n");
					partita.getStanzaCorrente().removeAttrezzo(this.parametro);
					s.append(partita.getGiocatore().getBorsa().toString());
					
				}
				else if(partita.getGiocatore().getBorsa().isFull())
				{
					s.append("Hai troppi oggetti in borsa");
				}
				s.append("\n=====\n");
				this.setMessaggio(s.toString());
				io.mostraMessaggio(this.getMessaggio());
	}
	
	/**
	 * Set del parametro.
	 * Stabilisce il nome dell'attrezzo da inserire in borsa
	 * @param String
	 * @return 
	 */
	@Override 
	public void setParametro(String parametro)
	{
		this.parametro=parametro;
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
		ComandoPrendi that;
		that=(ComandoPrendi)o;
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
