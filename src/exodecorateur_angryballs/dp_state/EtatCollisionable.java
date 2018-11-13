package exodecorateur_angryballs.dp_state;

import exodecorateur_angryballs.projet.Souris;
import exodecorateur_angryballs.vues.CadreAngryBalls;

public class EtatCollisionable extends ControleurEtat {

	public EtatCollisionable(Souris souris, ControleurEtat suivant, ControleurEtat retour) {
		super(souris, suivant, retour);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void traiteMousePressed() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void traiteMouseReleased() {
		System.out.println("Etat collision: mouse relased. Passage a l'état normal");
		souris.setEtatCourant(this.suivant);
	}
}
