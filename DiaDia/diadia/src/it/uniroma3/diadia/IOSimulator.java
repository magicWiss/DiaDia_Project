package it.uniroma3.diadia;

/**
 * IOSimulator implementa IO.
 * Gestione di test automatici di partite 
 * @author 
 *
 *Ipotizziamo che il massimo di mosse che sono possibili è 5.
 *Le variabili istanza sono il numero massimo di mosse inseribili all'interno dell'array di istuzioni.
 *Un array di istruzioni, voloto a memoriazzare stringhe che serviranno all'invocazione dei comandi al'interno del simulatore
 *l'indice relativo al comando corrente.
 */


public class IOSimulator implements IO
{
	private static final int NUMERO_MAX_ISTRUZIONI=5;
	private String[] istruzioni;
	private int indice;
	
	
	
	public IOSimulator(int x)
	{
		
		this.istruzioni=new String[x];
		this.indice=0;
		
	}
	
	public IOSimulator()
	{
		this(NUMERO_MAX_ISTRUZIONI);
	}
	
	public String leggiIesimoELemento(int i)
	{
		return this.istruzioni[i];
	}
	
	/**
	 * ritorna l'iesimo elemento dell'array di istruzioni
	 * @param istruzione
	 * @param i
	 */
	public void setIesimoElemento(String istruzione, int i)
	{
		this.istruzioni[i]=istruzione;
	}
	
	/**
	 * Override metodo leggiRiga
	 */
	@Override
	public String leggiRiga()
	{
		String out=this.istruzioni[this.indice];
		this.indice++;
		return out;
	}



	/**
	 * Override mostra messaggio, mostra la riga
	 */
	@Override
	public void  mostraMessaggio(String messaggio)
	{
		System.out.println(messaggio);
	}




}
