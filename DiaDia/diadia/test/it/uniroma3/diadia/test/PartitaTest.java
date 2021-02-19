package it.uniroma3.diadia.test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import it.uniroma3.diadia.*;

public class PartitaTest {
	
	private Partita partitaVinta;
	private Partita partita0Cfu;
	private Partita partitaFinita;
	
	@Before
	public void setUp() {
		this.partitaVinta = new Partita();
		this.partita0Cfu = new Partita();
		this.partitaFinita = new Partita();
		this.partitaVinta.setStanzaCorrente(this.partitaVinta.getStanzaVincente());
		this.partita0Cfu.getGiocatore().setCfu(0);
		this.partitaFinita.setFinita();
	}
	
	/*Test isFinita*/
	@Test
	public void testVinta() {
		assertEquals("Errore non hai vinto", true, partitaVinta.isFinita());
	}
	@Test
	public void testCfuFiniti() {
		assertEquals("Errore non hai finito i cfu", true, this.partita0Cfu.isFinita());
	}
	@Test
	public void testPartitaFinita() {
		assertEquals("Errore non è finita", true, this.partitaFinita.isFinita());
	}

}
