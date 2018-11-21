package exodecorateur_angryballs.modele;

import java.awt.Graphics;

import exodecorateur_angryballs.visitor.Dessinateur;
import mesmaths.geometrie.base.Vecteur;

public abstract class DecorateurBille extends Bille
{
	protected Bille billeDecoree;
	
	public DecorateurBille(Bille billeDecoree)
	{
		this.billeDecoree = billeDecoree;
	}
	
	@Override
	public Vecteur getAcceleration() 
	{
		return this.billeDecoree.getAcceleration();
	}
	
	@Override
	public Vecteur getPosition() 
	{
		return this.billeDecoree.getPosition();
	}

	@Override
	public double masse() 
	{
		return this.billeDecoree.masse();
	}

	@Override
	public double getRayon() 
	{
		return this.billeDecoree.getRayon();
	}

	@Override
	public Vecteur getVitesse() 
	{
		return this.billeDecoree.getVitesse();
	}

	@Override
	public int getClef() 
	{
		return this.billeDecoree.getClef();
	}
	
//	public void dessine(Graphics g)
//	{
//		this.billeDecoree.dessine(g);
//	}
	
	public void dessine(Dessinateur d) {
		d.dessine(this);
	}
	
	public void deplacer(double deltaT)
	{
		this.billeDecoree.deplacer(deltaT);
	}
	
	public String toString() 
	{
	    return this.billeDecoree.toString();
	}
	
	public Couleur getColor() {
		return this.billeDecoree.getColor();
	}
	
}