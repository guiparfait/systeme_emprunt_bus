package reseau_Partie_1;

public class Arret {
	private boolean isbus;
	private int client;
	
	public Arret(){
		isbus = false;
		client = 0;
	}
	/**
	 * permet de savoir s'il y a un bus à l'arret si non le bus stationne à l'arret
	 */
	public synchronized void arriveeBus() {
		
		while(isbus) {
			try {
				System.out.println("il y a deja un bus a l'arret");
				this.wait();
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}
		client = 0;
		isbus = true ;
		System.out.println(Thread.currentThread().toString()+" est arrivé");
		notifyAll();
	}
	/**
	 * permet de dire aux autre bus que l'arret est maiintenant disponible
	 */
	public synchronized void depardBus() {
		//System.out.println(Thread.currentThread().toString()+" est partie");
		isbus = false ;
		notifyAll();
	}
	
	/**
	 * permet aux voyageurs de monter dans le bus
	 */
	public synchronized void monterBus(){
		while(!isbus || client == Bus.capacite) {
			try {
				System.out.println(Thread.currentThread().toString()+" attend le bus");
				wait();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		client++;		
		System.out.print(Thread.currentThread().toString()+" monte dans le bus \n");
	}
}
