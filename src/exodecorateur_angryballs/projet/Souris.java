package exodecorateur_angryballs.projet;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Observable;

import exodecorateur_angryballs.dp_state.ControleurEtatBillePilotee;
import exodecorateur_angryballs.dp_state.EtatBillePiloteeAttrapée;
import exodecorateur_angryballs.dp_state.EtatBillePiloteeLibre;
import exodecorateur_angryballs.modele.Bille;
import mesmaths.geometrie.base.Vecteur;

public class Souris extends Observable implements MouseListener, MouseMotionListener {
	
	public Vecteur position;
	
	public Souris() {
		position = new Vecteur();
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
		updateCurrentPosition(e);
		this.setChanged();
		this.notifyObservers(e);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		updateCurrentPosition(e);
		this.setChanged();
		this.notifyObservers(e);
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		updateCurrentPosition(arg0);
	}

	@Override
	/**
	 * ATTENTION : ne fonctionne pas si le bouton de la souris est enfoncé (utilisé mouseDragged à la place)
	 */
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}
	
	private void updateCurrentPosition(MouseEvent cursor) {
		position.x = cursor.getX();
		position.y = cursor.getY();
	}
	
}
