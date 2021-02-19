package it.uniroma3.diadia.ambienti;

/**
 * StanzaBuia
 * Estende stanza
 * E' una particolare stanza che risulta essere buia a meno che in essa non è presente un particolare attrezzo
 * @author Wissel
 *
 */


public class StanzaBuia extends Stanza
{
	String attrezzoLuminoso;
	
	//costruttorePrimario
	public StanzaBuia(String nome,String attrezzo)
	{
		super(nome);
		this.attrezzoLuminoso=attrezzo;
	}
	
	public String getAttrezzoLuminoso()
	{
		return this.attrezzoLuminoso;
	}
	
	/**
	 * Override del metodo getDescrizione ereditato da Stanza
	 * Stampa la descizione se nella stanza è presente l'attrezzo illuminante
	 * Stampa c'è buio pesto altrimenti
	 * @return String
	 */
	@Override
	public String getDescrizione()
	{
		if(this.hasAttrezzo(this.getAttrezzoLuminoso()))
		{
			return super.getDescrizione();
		}
		else
			return("Qui c'è buio pesto");
		
	}

}
