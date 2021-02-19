package it.uniroma3.diadia;




	public class IOSimulatorBis implements IO {
		private static final int NUMERO_MAX_COMANDI = 100;
		private String[] comandi;
		private String[] risposte;
		private int numeroRisposte;
		private int numeroComandi;
		
		public IOSimulatorBis() {
			this.numeroComandi = 0;
			this.numeroRisposte = 0;
			this.risposte = new String[NUMERO_MAX_COMANDI];
			this.comandi = new String[NUMERO_MAX_COMANDI];
		}
		
		/**
		 * salva nell'array delle risposte i messaggi che vengono 
		 * stampati dalla partita
		 */
	    public void mostraMessaggio(String messaggio) {
	    	this.risposte[numeroRisposte++] = messaggio;
	    };
		
	    /**
	     * ritorna una stringa rappresentante l'ultimo comando inserito
	     */
		public String leggiRiga() {
			return this.comandi[numeroComandi++];
		};
		
		/**
		 * imposta l'array o la stringa di input
		 * @param input
		 */
		public void setComandi(String... input) {
			this.comandi = input;
		}
		
		/**
		 * restituisce l'array dei comandi
		 * @return array di stringhe
		 */
		public String[] getComandi() {
			return this.comandi;
		}
		
		/**
		 * restituisce l'array delle risposte
		 * @return array di stringhe
		 */
		public String[] getRisposte() {
			return this.risposte;
		}
		
	}


