package exodecorateur_angryballs.dp_state;

import java.awt.event.MouseEvent;

import exodecorateur_angryballs.modele.Bille;
import exodecorateur_angryballs.modele.ComportementBillePilotee;
import exodecorateur_angryballs.projet.Souris;
import exodecorateur_angryballs.vues.CadreAngryBalls;
import mesmaths.geometrie.base.Vecteur;

public class EtatBillePiloteeAttrapée extends ControleurEtatBillePilotee {
	
	public EtatBillePiloteeAttrapée(ComportementBillePilotee bille, ControleurEtatBillePilotee suivant, ControleurEtatBillePilotee retour) {
		super(bille, suivant, retour);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void traiteMousePressed(Vecteur mousePosition) {
		// TODO Auto-generated method stub
		
		// Rien à faire quand on clique dans l'état "attrapée"
	}

	@Override
	protected void traiteMouseReleased() {
		// On relache une bille attrapée
		// Il suffit de changer l'état de la bille à "libre"
		bille.setEtatCourant(this.suivant);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "état attrapée";
	}
}
