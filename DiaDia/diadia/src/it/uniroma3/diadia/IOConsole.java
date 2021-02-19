package it.uniroma3.diadia;

import java.util.Scanner;

public class IOConsole  implements IO{
	
	/**
	 * Stampa una stringa su schermo
	 * @param msg
	 */
    public void mostraMessaggio(String msg) {
    System.out.println(msg);
    }
    
    /**
     * Permette di inserire un stringa all'utente su schermo
     * @return	String
     */
    public String leggiRiga() {
    Scanner scannerDiLinee = new Scanner(System.in);
    String riga = scannerDiLinee.nextLine();
    //scannerDiLinee.close();
    return riga;
    }
}