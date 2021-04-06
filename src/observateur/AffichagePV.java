package observateur;

public class AffichagePV implements Observateur {
	
	private String name;
	private int pv;
	private Sujet character;
	
	
	public AffichagePV(Sujet character) {
		this.character = character;
		character.enregistrerObservateur(this);
	}
	
	public void actualiser(String name, int pv) {
		this.name = name;
		this.pv = pv;
		afficher();
	}
	
	public void afficher() {
		System.out.println(name + " a " + pv +" PV");
	}

}
