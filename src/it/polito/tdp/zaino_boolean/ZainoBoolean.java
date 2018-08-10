package it.polito.tdp.zaino_boolean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import it.polito.tdp.zaino_boolean.Pezzo;

public class ZainoBoolean {
	private int capienza;
	private List<Pezzo> pezzi;

	public ZainoBoolean(int capienza) {
		super();
		this.capienza = capienza;
		pezzi = new ArrayList<Pezzo>();
	}

	/**
	 * aggiunge un nuovo pezzo {@link Pezzo} al problema
	 * 
	 * @param p
	 * @return true se l'inserimento a buon fine, false altrimenti
	 */
	public boolean add(Pezzo p) {
		return pezzi.add(p);
	}

	/**
	 * inizializza il problema zaino e lancia ricorsione zero del problema e stampa
	 * della soluzione
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		ZainoBoolean z = new ZainoBoolean(15); // zaino con capacità 15 kg.
		z.add(new Pezzo(12, 4, "Verde"));
		z.add(new Pezzo(2, 2, "Azzurro"));
		z.add(new Pezzo(1, 1, "Salmone"));
		z.add(new Pezzo(4, 10, "Giallo"));
		z.add(new Pezzo(1, 2, "Grigio"));

		boolean[] soluzione = z.risolvi();

		// Stampa della soluzione
		for (int i = 0; i < soluzione.length; i++) {
			if (soluzione[i]) {
				System.out.println(z.getPezzi().get(i).toString());
			}
		}

	}

	private List<Pezzo> getPezzi() {
		// TODO Auto-generated method stub
		return this.pezzi;
	}

	private boolean[] risolvi() {
		boolean[] parziale = new boolean[pezzi.size()];
		Arrays.fill(parziale, Boolean.FALSE);
		boolean[] best = new boolean[pezzi.size()];
		Arrays.fill(best, Boolean.FALSE);
		scegliPezzo(parziale, 0, best);
		return best;
	}

	/**
	 * calcola il costo/valore del contenuto corrente dello zaino
	 * 
	 * @param parziale contenuto attuale dello zaino
	 * @return costo/valore del contenuto
	 */
	private int costo(boolean[] parziale) {
		int result = 0;
		for (int i = 0; i < pezzi.size(); i++) {
			if (parziale[i]) {
				Pezzo p = pezzi.get(i);
				result += p.getCosto();
			}
		}
		return result;
	}

	private int peso(boolean[] parziale) {
		int result = 0;
		for (int i = 0; i < pezzi.size(); i++) {
			if (parziale[i]) {
				Pezzo p = pezzi.get(i);
				result += p.getPeso();
			}
		}
		return result;
	}

	private void scegliPezzo(boolean[] parziale, int level, boolean[] best) {
		// E -- sequenza di istruzioni che vengone eseguite sempre
		// da usare solo in casi rari
		
		/** //A
		 * if(condizione di terminazione){
		 * doSomething();
		 * return;
		 * 
		 * for()/while() {
		 * 	//B
		 *  genera nuova soluzione parziale
		 *  
		 *  if(filtro){//C
		 *  	scegliPezzo(..., level+1, ...);
		 *  }
		 *  
		 *  // D
		 *  backtraking;
		 *  }
		 */
		
		if(costo(parziale) > costo(best)) {
			System.arraycopy(parziale, 0, best, 0, parziale.length);
		}

		while(level < pezzi.size()) {
			
			if(peso(parziale) + pezzi.get(level).getPeso() <= capienza) {
				parziale[level] = true;
				scegliPezzo(parziale, level + 1, best );
			}
			parziale[level] = false;
			level++;
		}

	}

}
