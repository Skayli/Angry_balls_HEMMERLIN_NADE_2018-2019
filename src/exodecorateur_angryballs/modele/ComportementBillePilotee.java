package exodecorateur_angryballs.modele;

import java.util.Vector;

import exodecorateur_angryballs.projet.Souris;
import mesmaths.geometrie.base.Vecteur;

public class ComportementBillePilotee extends DecorateurBilleAcceleration
{
	Souris souris;
	public ComportementBillePilotee(Bille billeDecoree, Souris souris) 
	{
		super(billeDecoree);
		this.souris = souris;
	}


	@Override
	public void gestionAcceleration(Vector<Bille> billes) 
	{
		// TODO Auto-generated method stub
		this.billeDecoree.gestionAcceleration(billes);	
		double xSpeed = souris.position.x - this.getPosition().x;
		double ySpeed = souris.position.y - this.getPosition().y;
		this.getAcceleration().ajoute(new Vecteur(xSpeed/12000, ySpeed/6000));	//ajout des frottements
		this.getVitesse().multiplie(0.95);

		
	}
	
	
}
