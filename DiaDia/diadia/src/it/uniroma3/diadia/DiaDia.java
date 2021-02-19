package it.uniroma3.diadia;


import it.uniroma3.diadia.comandi.*;

/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 *          
 * @version base
 */

public class DiaDia {

	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";
	

	private Partita partita;
	
	public DiaDia() {
		this.partita = new Partita();
	}

	public void gioca(IO io) {
		String istruzione;
        io.mostraMessaggio(MESSAGGIO_BENVENUTO);		
		do {
			io.mostraMessaggio("Inserisci comando: ");
			istruzione = io.leggiRiga();
		    
		}
		while (!processaIstruzione(istruzione, io));
	}   


	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione, IO io) {
		
		//creo la variabile che conterrà il comando
		Comando comandoDaEseguire;
		//creo la fabbrica di comandi
		FabbricaComando factory = new FabbricaComandoFisarmonica();
		//identifico il comando da eseguire
		comandoDaEseguire=factory.costruisciComando(istruzione);
		//eseguo il comando
		comandoDaEseguire.esegui(this.partita, io);
		if(this.partita.vinta())
		{
			io.mostraMessaggio("Congratulazioni, hai vinto!");
		}
		if(!this.partita.giocatoreVivo())
		{
			io.mostraMessaggio("Game Over (hai esaurito i CFU)");
		}
		return this.partita.isFinita();
		
	}   

	public Partita getPartita()
	{
		return this.partita;
	}
	
	
	public static void main(String[] argc) {
		DiaDia gioco = new DiaDia();
		IO io = new IOConsole();
		gioco.gioca(io);
	}
	
	

   
}