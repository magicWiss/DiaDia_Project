package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * StanzaBloccata
 * Estende Stanza
 * Blocca una direzione della stanza se non è presente un determinato attrezzo.
 * @author Wissel
 *
 */
public class StanzaBloccata extends Stanza 
{
	String direzioneBloccata;		//la direzione bloccate
	String attrezzo;				//l'attrezzo che sblocca la direzione
	
	
	//costruttore
	public StanzaBloccata(String nomeStanza,String nomeAttrezzo, String nomeDirezione)
	{
		super(nomeStanza);
		this.direzioneBloccata=nomeDirezione;
		this.attrezzo=nomeAttrezzo;
	}
	
	public String getAttrezzoSbloccante()
	{
		return this.attrezzo;
	}
	public String getDirezioneBloccata()
	{
		return this.direzioneBloccata;
	}
	
	
	@Override
	public Stanza getStanzaAdiacente(String direzione)
	{
		if(this.hasDirezione(direzione))
		{
		
			if(this.getDirezioneBloccata().equals(direzione) && !this.hasAttrezzo(this.attrezzo))
			{
				return this;
			}
			
			return super.getStanzaAdiacente(direzione);
		}
		else
		{
			return null;
		}
		
		
	}
	
	@Override
	public String getDescrizione()
	{
		if(this.hasAttrezzo(this.getAttrezzoSbloccante()))
		{
			return super.getDescrizione();
		}
		StringBuilder risultato = new StringBuilder();
		risultato.append(this.getNome());
		risultato.append("\nUscite: ");
		for(int i=0;i<this.getNumeroStanzeAdeacenti();i++)
		{
			
			if(this.getDirezioneBloccata().equals(this.getDirezioneIesima(i)) && !this.hasAttrezzo(this.attrezzo))
			{
				risultato.append(this.getDirezioneBloccata());
				
			}
			else
			{
			
			risultato.append(" " +this.getDirezioneIesima(i) + " ");
			}
		}
			for (Attrezzo attrezzo : this.getAttrezzi()) 
			{
				if (attrezzo != null) 
					risultato.append(attrezzo.toString()+" ");
			}
			
		
		return risultato.toString();
	}
}
