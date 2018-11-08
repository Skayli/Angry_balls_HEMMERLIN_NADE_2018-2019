package exodecorateur_angryballs.projet;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import exodecorateur_angryballs.dp_state.ControleurEtat;
import exodecorateur_angryballs.dp_state.EtatCollisionable;
import exodecorateur_angryballs.dp_state.EtatNormal;
import exodecorateur_angryballs.modele.Bille;
import mesmaths.geometrie.base.Vecteur;

public class Souris implements MouseListener, MouseMotionListener {
	
	ControleurEtat etatCourant;
	EtatCollisionable etatCollisionable;
	EtatNormal etatNormal;
	public Vecteur position;
	
	public Souris() {
		position = new Vecteur();
		initEtats();
	}
	
	/***
	 * Initialise les etats de la souris 
	 * (cliquée = collisionable avec les billes pilotées, sinon pas d'interaction)
	 */
	private void initEtats() {
		etatCollisionable = new EtatCollisionable(this, null, null);
		etatNormal = new EtatNormal(this, null, null);
		
		etatCollisionable.suivant = etatNormal;
		etatCollisionable.retour = etatNormal;
		
		etatNormal.suivant = etatCollisionable;
		etatNormal.retour = etatCollisionable;
		
		etatCourant = etatNormal;
	}
	
	public void setEtatCourant(ControleurEtat nouvelEtat) {
		this.etatCourant = nouvelEtat;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		etatCourant.traiteMousePressed();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		etatCourant.traiteMouseReleased();
		
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		position.x = arg0.getX();
		position.y = arg0.getY();
	}
	
}
