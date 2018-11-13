package exodecorateur_angryballs.modele;

import java.awt.AWTEvent;
import java.awt.event.MouseEvent;
import java.util.Observable;
import java.util.Observer;
import java.util.Vector;

/**
 * Le comportement de la bille pilot�e est induite par celui de la souris.
 * Ainsi, cette classe utilise le design pattern "Observer" afin d'observer les modifications de la souris
 * ce qui lui permet de mettre � jour son �tat (attrap�e | libre)
 */

import exodecorateur_angryballs.dp_state.ControleurEtatBillePilotee;
import exodecorateur_angryballs.dp_state.EtatBillePiloteeAttrap�e;
import exodecorateur_angryballs.dp_state.EtatBillePiloteeLibre;
import exodecorateur_angryballs.projet.Souris;
import mesmaths.geometrie.base.Vecteur;

public class ComportementBillePilotee extends DecorateurBilleAcceleration implements Observer
{
	Souris souris;
	ControleurEtatBillePilotee etatCourant;
	EtatBillePiloteeAttrap�e etatAttrap�e;
	EtatBillePiloteeLibre etatLibre;
	
	public ComportementBillePilotee(Bille billeDecoree, Souris souris) 
	{
		super(billeDecoree);
		this.souris = souris;
		souris.addObserver(this);
		initEtats();
	}
	
	private void initEtats() {
		etatAttrap�e = new EtatBillePiloteeAttrap�e(this, null, null);
		etatLibre = new EtatBillePiloteeLibre(this, null, null);
		
		etatAttrap�e.setSuivant(etatLibre);
		etatAttrap�e.setRetour(etatLibre);
		
		etatLibre.setSuivant(etatAttrap�e);
		etatLibre.setRetour(etatAttrap�e);
		
		etatCourant = etatLibre;
		
	}


	@Override
	public void gestionAcceleration(Vector<Bille> billes) 
	{
		// TODO Auto-generated method stub
		this.billeDecoree.gestionAcceleration(billes);	
		
		if(etatCourant == etatAttrap�e) {
			System.out.println("Position de la souris : [" + souris.position.x + " - " +  souris.position.y+"]");
			double xSpeed = souris.position.x - this.getPosition().x;
			double ySpeed = souris.position.y - this.getPosition().y;
			this.getAcceleration().multiplie(0);
			this.getAcceleration().ajoute(new Vecteur(xSpeed/12000, ySpeed/6000));	//ajout des frottements
			this.getVitesse().multiplie(0.95);
		}
			

		
	}

	@Override
	/**
	 * Met � jour l'�tat actuelle de la bille en fonction de l'action de la souris
	 * @params mouseEvent: L'�v�nement pass� par la Classe souris observ�e
	 */
	public void update(Observable arg0, Object mouseEvent) {
		int eventId = ((MouseEvent) mouseEvent).getID();
		
		if(eventId == MouseEvent.MOUSE_PRESSED) {
			etatCourant.traiteMousePressed();
		} else if(eventId == MouseEvent.MOUSE_RELEASED) {
			etatCourant.traiteMouseReleased();
		}
		
	}
	
	public void setEtatCourant(ControleurEtatBillePilotee nouvelEtat) {
		this.etatCourant = nouvelEtat;
	}
	
}
