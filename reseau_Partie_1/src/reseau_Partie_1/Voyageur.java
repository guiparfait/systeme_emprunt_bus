package reseau_Partie_1;

public class Voyageur extends Thread  {
	
	private Billetterie billetterie;
	private Arret arret;
	private int client;
	
	public Voyageur(Billetterie billetterie, Arret arret, int client) {
		this.billetterie = billetterie;
		this.arret = arret;
		this.client = client;
	}
	/**
	 * permet au voyageur d'acheter un billet
	 */
	public void AcheterBillet() {
		billetterie.vendreBillet();
	}
	
	
	@Override
	public String toString() {
		this.client = this.client + 1;
		return "Voyageur "+client ;
	}
	/**
	 * permet au voyageur de se rendre a l'arret de bus
	 */
	public void SeRendreArret(){
		try { 
			System.out.println("le voyageur se rend à l'arret");
			sleep(1); 
			} catch (InterruptedException e) { e.printStackTrace();}
		}
	/**
	 * permet au voyageur de monter dans le bus
	 */
	public void MonterBus() {
		arret.monterBus();
	}
	
	@Override
	public void run() {
		AcheterBillet();
		SeRendreArret();
		MonterBus();
	}
}
