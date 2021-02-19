package it.uniroma3.diadia.comandi;
/*
 * E' un sottotipo che implementa il super tipo Fabbrica di comandi con un codice a fisarmonica
 * Ricco di if
 * Il metodo costruisci comando si basa sullo scann dell'istruzione inserita dall'utente.
 * Ad ogni inserimento di una nuova istruzione il codice si arricchisce di un else if.
 * 
 * scanParola--->scann dell'istruzione di input dell'utente
 * nomeComando--->Stringa che salva il comando
 * parametro---->String ache salva il parametro dell'istruzione(se presente)
 * comando--->riferimento e output dell'oggetto Comando da invocare e restituire
 */




import java.util.Scanner;

/**
 * FabbricaComandoFisarmonica
 * Implementa FabbricaComando
 * Permette di costruire un oggetto comando a partire dalla stringa inserita dall'utente
 * Utilizza un codice a fisarmonica per formulare il comando
 * @author Wissel
 *
 */
public class FabbricaComandoFisarmonica implements FabbricaComando{
	
	
	
	@Override
	public Comando costruisciComando(String istruzione)
	{
		Scanner scanParola=new Scanner(istruzione);
		String nomeComando=null;
		String parametro=null;
		Comando comando=null;
		
		if(scanParola.hasNext())
		{
			nomeComando=scanParola.next();
		}
		if(scanParola.hasNext())
		{
			parametro=scanParola.next();
		}
		
		//inizia la fisarmonica per assoviare a comando l'oggetto Comando relativo all'istruzione inserita
		
		if(nomeComando==null)
		{
			comando=new ComandoNonValido();
		}
		else if(nomeComando.equals("vai"))
		{
			comando= new ComandoVai();
		}
		else if(nomeComando.equals("aiuto"))
		{
			comando=new ComandoAiuto();
		}
		else if(nomeComando.equals("vai"))
		{
			comando=new ComandoVai();
		}
		else if(nomeComando.equals("prendi"))
		{
			comando=new ComandoPrendi();
		}
		else if(nomeComando.equals("posa"))
		{
			comando= new ComandoPosa();
		}
		else if(nomeComando.equals("guarda"))
		{
			comando=new ComandoGuarda();
		}
		else if(nomeComando.contentEquals("fine"))
		{
			comando= new ComandoFine();
		}
		else
		{
			comando=new ComandoNonValido();
		}
		comando.setParametro(parametro);
		scanParola.close();
		return comando;
		
	}

}
