package strategie.celebrationVictoire;

public class NePasCelebrer implements CelebrationVictoire {

	@Override
	public void celebrer() {
		System.out.println("ce personnage ne c�l�bre en aucune fa�on sa victoire");
		
	}

}
