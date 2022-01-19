package reseau_Partie_1;


public class Reseau {
	static final int NB =100;
	static final int NB_BUS =5;
	private Billetterie billet;
	private Arret arret;
	//private Bus bus[] = new Bus[4];
	private Voyageur voyageur[]= new Voyageur[NB];
	private Bus bus[] = new Bus[NB_BUS];

	public Reseau() {
		arret = new Arret();
		billet = new Billetterie();
		
		for(int i=0;i< NB_BUS;i++) {
			bus[i] = new Bus(arret,i);
		}
		
		
		for (int i=0; i < NB; i++) {
			voyageur[i] = new Voyageur(billet, arret, i);
		}	
		
		for(int i=0;i< NB_BUS;i++) {
			bus[i].start();
		}
		
		for (int i=0; i < NB; i++) {
			try {
				voyageur[i].start();
				voyageur[i].join();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		

	}
	
	public static void main(String[] args) {
		
		new Reseau();
		System.out.println("Tous les clients sont montés dans un bus! Bravo!");
		
	}
}
