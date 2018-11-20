package exodecorateur_angryballs.modele;

import java.awt.event.MouseEvent;
import java.util.Observable;
import java.util.Observer;
import java.util.Vector;

/**
 * Le comportement de la bille pilotée est induite par celui de la souris.
 * Ainsi, cette classe utilise le design pattern "Observer" afin d'observer les modifications de la souris
 * ce qui lui permet de mettre à jour son état (attrapée | libre)
 */

import exodecorateur_angryballs.dp_state.ControleurEtatBillePilotee;
import exodecorateur_angryballs.dp_state.EtatBillePiloteeAttrapée;
import exodecorateur_angryballs.dp_state.EtatBillePiloteeLibre;
import exodecorateur_angryballs.projet.Souris;
import mesmaths.geometrie.base.Vecteur;

@SuppressWarnings("deprecation")
public class ComportementBillePilotee extends DecorateurBilleAcceleration implements Observer
{
	private static final double COEFF = 10;
	Souris souris;
	ControleurEtatBillePilotee etatCourant;
	EtatBillePiloteeAttrapée etatAttrapée;
	EtatBillePiloteeLibre etatLibre;
	
	public ComportementBillePilotee(Bille billeDecoree, Souris souris) 
	{
		super(billeDecoree);
		this.souris = souris;
		souris.addObserver(this);
		initEtats();
	}
	
	private void initEtats() {
		etatAttrapée = new EtatBillePiloteeAttrapée(this, null, null);
		etatLibre = new EtatBillePiloteeLibre(this, null, null);
		
		etatAttrapée.setSuivant(etatLibre);
		etatAttrapée.setRetour(etatLibre);
		
		etatLibre.setSuivant(etatAttrapée);
		etatLibre.setRetour(etatAttrapée);
		
		etatCourant = etatLibre;
		
	}


	@Override
	public void gestionAcceleration(Vector<Bille> billes) 
	{
		// TODO Auto-generated method stub
		this.billeDecoree.gestionAcceleration(billes);	
		
		if(etatCourant == etatAttrapée) {
			Vecteur desiredDirection = Vecteur.difference(souris.position, this.getPosition());
			desiredDirection.multiplie(COEFF);
			this.getAcceleration().ajoute(desiredDirection.produit(1/this.masse()));	
			
			this.getVitesse().multiplie(0.9);
		}
			

		
	}

	@Override
	/**
	 * Met à jour l'état actuelle de la bille en fonction de l'action de la souris
	 * @params mouseEvent: L'évènement passé par la Classe souris observée
	 */
	public void update(Observable arg0, Object mouseEvent) {
		etatCourant.traiteMouseEvent((MouseEvent) mouseEvent);
	}
	
	public void setEtatCourant(ControleurEtatBillePilotee nouvelEtat) {
		this.etatCourant = nouvelEtat;
	}
	
}
