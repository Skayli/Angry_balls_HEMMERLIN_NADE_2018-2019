package exodecorateur_angryballs.vues;

import java.awt.*;
import java.util.Vector;

import exodecorateur_angryballs.modele.Bille;
import exodecorateur_angryballs.projet.EcouteurBoutonArreter;
import exodecorateur_angryballs.projet.EcouteurBoutonLancer;
import exodecorateur_angryballs.projet.EcouteurClavierArreter;
import exodecorateur_angryballs.projet.EcouteurClavierLancer;
import exodecorateur_angryballs.visitor.DessinateurAWT;
import outilsvues.EcouteurTerminaison;
import outilsvues.Outils;

/**
 * Vue dessinant les billes et contenant les 3 boutons de contr�le (arr�t du programme, lancer les billes, arr�ter les billes) 
 * 
 *  ICI : IL N'Y A RIEN A CHANGER 
 *  
 * 
 * */
@SuppressWarnings("serial")
public class CadreAngryBalls extends Frame implements VueBillard
{
TextField pr�sentation;
Billard billard;
public Button lancerBilles, arr�terBilles;
Panel haut, bas, centre;
public EcouteurBoutonLancer ecouteurBoutonLancer;
public EcouteurBoutonArreter ecouteurBoutonArreter;
public EcouteurClavierLancer ecl;
public EcouteurClavierArreter eca;

EcouteurTerminaison ecouteurTerminaison;


public CadreAngryBalls(String titre, String message, Vector<Bille> billes) throws HeadlessException
{
super(titre);
Outils.place(this, 0.33, 0.33, 0.5, 0.5);
this.ecouteurTerminaison = new EcouteurTerminaison(this);

this.haut = new Panel(); this.haut.setBackground(Color.LIGHT_GRAY);
this.add(this.haut,BorderLayout.NORTH);

this.bas = new Panel(); this.bas.setBackground(Color.LIGHT_GRAY);
this.add(this.bas,BorderLayout.SOUTH);

this.centre = new Panel();
this.add(this.centre,BorderLayout.CENTER);

this.pr�sentation = new TextField(message, 100); this.pr�sentation.setEditable(false);
this.pr�sentation.setFocusable(false);
this.haut.add(this.pr�sentation);

this.billard = new Billard(billes);
this.add(this.billard);

this.lancerBilles = new Button("lancer les billes"); this.bas.add(this.lancerBilles);
ecouteurBoutonLancer = new EcouteurBoutonLancer();
this.lancerBilles.addActionListener(ecouteurBoutonLancer);
this.lancerBilles.setFocusable(false);

this.arr�terBilles = new Button("arr�ter les billes"); this.bas.add(this.arr�terBilles);
ecouteurBoutonArreter = new EcouteurBoutonArreter();
this.arr�terBilles.addActionListener(ecouteurBoutonArreter);
this.arr�terBilles.setFocusable(false);

this.ecl = new EcouteurClavierLancer();
this.eca = new EcouteurClavierArreter();

addKeyListener(ecl);
addKeyListener(eca);

setFocusable(true);
setAlwaysOnTop(true);

}

public double largeurBillard() 
{
return this.billard.getWidth();
}

public double hauteurBillard()
{
return this.billard.getHeight();
}

@Override
public void miseAJour()
{
this.billard.repaint();
}



/* (non-Javadoc)
 * @see exodecorateur.vues.VueBillard#montrer()
 */
@Override
public void montrer()
{
this.setVisible(true);
}

public Billard getBillard() {
	return this.billard;
}



}