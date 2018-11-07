package exodecorateur_angryballs.modele;

import java.awt.event.ActionListener;
import java.util.Vector;

public class ComportementBillePilotee extends DecorateurBilleAcceleration
{
	private ActionListener main;
	
	
	public ComportementBillePilotee(Bille billeDecoree, ActionListener main) 
	{
		super(billeDecoree);
		this.main = main;
	}


	@Override
	public void gestionAcceleration(Vector<Bille> billes) 
	{
		// TODO Auto-generated method stub
		
	}

	
	
}
