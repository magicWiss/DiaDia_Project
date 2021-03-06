package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Estensione della classe Stanza.
 * E' una particolare stanza che dopo n volte che un attrezzo generico viene posato si comporta in modo particolare
 * All'n posa attrezzo gli attrezzi posati vengono caricati nella stanza con: peso doppio
 * 																			  nome inverso
 * Prima dell' n-esimo posa attrezzo, si comporta in modo normale 
 * @author Wissel
 *
 */
public class StanzaMagica  extends Stanza
{

	final static private int SOGLIA_MAGICA_DEFAULT=3;
	private int contatoreAttrezziPosati;
	private int sogliaMax;
	
	//costruttore primario
	public StanzaMagica(String nome,int soglia)
	{
		super(nome);
		this.contatoreAttrezziPosati=0;
		this.sogliaMax=soglia;
	}
	
	//costruttore secondario
	public StanzaMagica(String nome)
	{
		this(nome, SOGLIA_MAGICA_DEFAULT);
	}
	
	/**
	 * Metodo modificaAttrezzo.
	 * Raddoppia il peso di un attrezzo e ne inverte il nome.
	 * @param Attrezzo
	 * @return Attrezzo
	 */
	public Attrezzo modificaAttrezzo(Attrezzo attrezzo)
	{
		
		StringBuilder nomeInvertito;
		int peso=attrezzo.getPeso()*2;			//raddoppio il peso
		nomeInvertito = new StringBuilder(attrezzo.getNome());
		nomeInvertito= nomeInvertito.reverse();		//inverto il nome
		attrezzo = new Attrezzo(nomeInvertito.toString(), peso);
		return attrezzo;
		
		
	}
	
	@Override
	public boolean addAttrezzo(Attrezzo attrezzo)
	{
		
		this.contatoreAttrezziPosati++;		//incremento il contatore
		
		if(this.getContatoreAttrezzi()>this.getSogliaMax())	//verifico se la stanzaMagica � in magicMode
		{
			attrezzo=this.modificaAttrezzo(attrezzo);		//in magic Mode la stanza modifica l'attrezzo
		}
		
		
		return super.addAttrezzo(attrezzo);			//chiamata alla restante parte di addAttrezzo della superclasse Stanza
			
		
	}
	
	/**
	 * getter del contatore attrezzi posati
	 * @return int
	 */
	public int getContatoreAttrezzi()
	{
		return this.contatoreAttrezziPosati;
	}
	/**
	 * getter della soglia massima
	 * @return int
	 */
	public int getSogliaMax()
	{
		return this.sogliaMax;
	}
	
	/**
	 * set contaAttrezzoPosati
	 */
	public void setContatoreAttrezzi(int x)
	{
		this.contatoreAttrezziPosati=x;
	}

}
