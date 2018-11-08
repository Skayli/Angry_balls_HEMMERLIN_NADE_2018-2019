package exodecorateur_angryballs.dp_state;

import exodecorateur_angryballs.projet.Souris;
import exodecorateur_angryballs.vues.CadreAngryBalls;

public class EtatNormal extends ControleurEtat {

	public EtatNormal(Souris souris, ControleurEtat suivant, ControleurEtat retour) {
		super(souris, suivant, retour);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void traiteMousePressed() {
		System.out.println("Etat normal : mouse Pressed. Passage etat collision");
		souris.setEtatCourant(this.suivant);
		
	}

	@Override
	public void traiteMouseReleased() {
		// TODO Auto-generated method stub
		
	}

}
