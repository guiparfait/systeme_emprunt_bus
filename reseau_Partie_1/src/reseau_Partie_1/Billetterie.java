package reseau_Partie_1;

public class Billetterie {

	private long billetVendu = 0;
	/**
	 * vendreBillet() permet d'incrementer le nombre de billet vendu
	 */
	public synchronized void vendreBillet() {
		billetVendu++;
		System.out.println("billet acheter "+billetVendu);
	}
	/** 
	 * 
	 * @return le nombre total de billet vendu
	 */
	public long getBilletVendu() {
		return billetVendu;
	}
}
