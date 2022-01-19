package reseau_Partie_1;


public class Bus extends Thread {
	public static int capacite = 15;
	
	private Arret arret ;
	private int nb;
	
	public Bus(Arret arret,int nb) {
		this.arret = arret ;
		setDaemon(true);
		this.nb = nb;
	 	}
	
	@Override
	public String toString() {
		this.nb = this.nb + 1;
		return "Bus N° "+nb;
	}
	/***
	 * permet de dire que le bus stationne à l'arret ou patiente que l'arret soit libre
	 */
	public void arriver() {
		arret.arriveeBus();
	}	
	/**
	 * permet de dire que le bus quitte l'arret apres s'etre stationné
	 */
	public void depart() {
		try { sleep(100); } catch (InterruptedException e) { e.printStackTrace();}
		arret.depardBus();
	}
	/**
	 * permet au bus de voyager pendant 12ms
	 */
	public void voyager() {
		try { sleep(12); } catch (InterruptedException e) { e.printStackTrace();}
		
	}
	
	@Override
	public void run(){
		while(true) {
			arriver();
			depart();
			voyager();
		}	
	}
}
