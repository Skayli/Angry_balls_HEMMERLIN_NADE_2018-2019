package exodecorateur_angryballs.projet;

import java.awt.Color;
import java.util.Vector;

import mesmaths.geometrie.base.Vecteur;
import exodecorateur_angryballs.controlerAnimation.ObserverArretAnimation;
import exodecorateur_angryballs.controlerAnimation.ObserverLancerAnimation;
import exodecorateur_angryballs.modele.*;
import exodecorateur_angryballs.vues.*;

/**
 * Gestion d'une liste de billes en mouvement ayant toutes un comportement diff�rent
 * 
 * Id�al pour mettre en place le DP decorator
 * */
public class TestAngryBalls
{

/**
 * @param args
 */
@SuppressWarnings("deprecation")
public static void main(String[] args)
{
//------------------- cr�ation de la liste (pour l'instant vide) des billes -----------------------

Vector<Bille> billes = new Vector<Bille>();

//------------ cr�ation des controleurs pour les boutons de lancer et arret d'animation -------------

//---------------- cr�ation de la vue responsable du dessin des billes -------------------------

CadreAngryBalls cadre = new CadreAngryBalls("Angry balls",
                                        "Animation de billes ayant des comportements diff�rents. Situation id�ale pour mettre en place le DP Decorator",
                                        billes);

cadre.montrer(); // on rend visible la vue

Souris souris = new Souris();
cadre.getBillard().addMouseListener(souris);
cadre.getBillard().addMouseMotionListener(souris);

//------------- remplissage de la liste avec 4 billes -------------------------------



double xMax, yMax;
double vMax = 0.1;
xMax = cadre.largeurBillard();      // abscisse maximal
yMax = cadre.hauteurBillard();      // ordonn�e maximale

double rayon = 0.05*Math.min(xMax, yMax); // rayon des billes : ici toutes les billes ont le m�me rayon, mais ce n'est pas obligatoire

Vecteur p0, p1, p2, p3, p4, p5, v0, v1, v2, v3, v4, v5;    // les positions des centres des billes et les vecteurs vitesse au d�marrage. 
                                                    // Elles vont �tre choisies al�atoirement

Vecteur pesanteur;			// repr�sente la pesanteur appliqu�e aux billes qui y sont sensibles

//------------------- cr�ation des vecteurs position des billes ---------------------------------

p0 = Vecteur.cr�ationAl�atoire(0, 0, xMax, yMax);
p1 = Vecteur.cr�ationAl�atoire(0, 0, xMax, yMax);
p2 = Vecteur.cr�ationAl�atoire(0, 0, xMax, yMax);
p3 = Vecteur.cr�ationAl�atoire(0, 0, xMax, yMax);
p4 = Vecteur.cr�ationAl�atoire(0, 0, xMax, yMax);
p5 = Vecteur.cr�ationAl�atoire(0, 0, xMax, yMax);


//------------------- cr�ation des vecteurs vitesse des billes ---------------------------------

v0 = Vecteur.cr�ationAl�atoire(-vMax, -vMax, vMax, vMax);
v1 = Vecteur.cr�ationAl�atoire(-vMax, -vMax, vMax, 0);
v2 = Vecteur.cr�ationAl�atoire(-vMax, -vMax, vMax, vMax);
v3 = Vecteur.cr�ationAl�atoire(-vMax, -vMax, vMax, vMax);
v4 = Vecteur.cr�ationAl�atoire(-vMax, -vMax, vMax, vMax);
v5 = Vecteur.cr�ationAl�atoire(-vMax, -vMax, vMax, vMax);


//------------------- Instanciation de la pesanteur --------------------------------------------

pesanteur = new Vecteur(0, 0.001);
ComportementPesanteur.setPesanteur(pesanteur);

//--------------- ici commence la partie � changer ---------------------------------
/*------------------ d�finition originale des billes ------------------------
billes.add(new BilleMvtRURebond(p0, rayon, v0, Color.red));
billes.add(new BilleMvtPesanteurFrottementRebond(p1, rayon, v1, new Vecteur(0,0.001), Color.yellow));
billes.add(new BilleMvtNewtonFrottementRebond(p2, rayon, v2, Color.green));
billes.add(new BilleMvtRUPasseMurailles(p3, rayon, v3, Color.cyan));
billes.add(new BilleMvtNewtonArret(p4, rayon, v4,  Color.black));
*/
//-------------------- Nouvelle d�finition utilisant le DP d�corateur -----------------
//billes.add(new BilleNormale(p0,rayon, v0, Color.red));	//cr�� une bille avec mouvement RU et rebond sur les parois
//billes.add(new ComportementPesanteur(new ComportementFrottements(new BilleNormale(p1, rayon, v1, Color.yellow))));	//cr�� une bille sensible � la pesanteur et aux frottements
//billes.add(new ComportementNewton(new ComportementFrottements(new BilleNormale(p2, rayon, v2, Color.green))));	// cr�� une bille sensible aux frottements et � l'attraction des autres
//billes.add(new ComportementPasseMurailles(new BilleNormale(p3, rayon, v3, Color.cyan))); // cr�� une bille passe murailles
//billes.add(new ComportementNewton(new ComportementArretSurLesBords(new BilleNormale(p4, rayon, v4, Color.black)))); // cr�� une bille attir�e par les autres et qui s'arr�te sur les murs

//billes.add(new ComportementBillePilotee(new BilleNormale(p5,rayon*2,v5,Color.gray),souris));
billes.add(new ComportementBillePilotee(new BilleNormale(p1,rayon,v1,Color.pink),souris));

//---------------------- ici finit la partie � changer ------------------------------------------------------------


System.out.println("billes = " + billes);


//-------------------- cr�ation de l'objet responsable de l'animation (c'est un thread s�par�) -----------------------

AnimationBilles animationBilles = new AnimationBilles(billes, cadre);
//
//cadre.ecouteurBoutonLancer.addObserver(animationBilles);
//cadre.ecouteurBoutonArreter.addObserver(animationBilles);
//cadre.ecl.addObserver(animationBilles);
//cadre.eca.addObserver(animationBilles);

ObserverLancerAnimation lancer = new ObserverLancerAnimation(animationBilles);
ObserverArretAnimation arret = new ObserverArretAnimation(animationBilles);

cadre.ecouteurBoutonLancer.addObserver(lancer);
cadre.ecouteurBoutonArreter.addObserver(arret);
cadre.ecl.addObserver(lancer);
cadre.eca.addObserver(arret);


//----------------------- mise en place des �couteurs de boutons qui permettent de contr�ler (un peu...) l'application -----------------

//EcouteurBoutonLancer �couteurBoutonLancer = new EcouteurBoutonLancer(animationBilles);
//EcouteurBoutonArreter �couteurBoutonArr�ter = new EcouteurBoutonArreter(animationBilles); 

//------------------------- activation des �couteurs des boutons et �a tourne tout seul ------------------------------

//cadre.lancerBilles.addActionListener(�couteurBoutonLancer);             // maladroit : � changer
//cadre.arr�terBilles.addActionListener(�couteurBoutonArr�ter);           // maladroit : � changer




}

}
