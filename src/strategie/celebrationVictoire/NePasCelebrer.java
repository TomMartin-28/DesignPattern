package strategie.celebrationVictoire;

public class NePasCelebrer implements CelebrationVictoire {

	@Override
	public void celebrer() {
		System.out.println("ce personnage ne célèbre en aucune façon sa victoire");
		
	}

}
