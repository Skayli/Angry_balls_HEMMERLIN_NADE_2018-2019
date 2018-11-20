package exodecorateur_angryballs.projet;

import java.awt.Color;
import java.util.Vector;

import mesmaths.geometrie.base.Vecteur;
import exodecorateur_angryballs.controlerAnimation.ObserverArretAnimation;
import exodecorateur_angryballs.controlerAnimation.ObserverLancerAnimation;
import exodecorateur_angryballs.modele.*;
import exodecorateur_angryballs.vues.*;

/**
 * Gestion d'une liste de billes en mouvement ayant toutes un comportement différent
 * 
 * Idéal pour mettre en place le DP decorator
 * */
public class TestAngryBalls
{

/**
 * @param args
 */
@SuppressWarnings("deprecation")
public static void main(String[] args)
{
//------------------- création de la liste (pour l'instant vide) des billes -----------------------

Vector<Bille> billes = new Vector<Bille>();

//------------ création des controleurs pour les boutons de lancer et arret d'animation -------------

//---------------- création de la vue responsable du dessin des billes -------------------------

CadreAngryBalls cadre = new CadreAngryBalls("Angry balls",
                                        "Animation de billes ayant des comportements différents. Situation idéale pour mettre en place le DP Decorator",
                                        billes);

cadre.montrer(); // on rend visible la vue

Souris souris = new Souris();
cadre.getBillard().addMouseListener(souris);
cadre.getBillard().addMouseMotionListener(souris);

//------------- remplissage de la liste avec 4 billes -------------------------------



double xMax, yMax;
double vMax = 0.1;
xMax = cadre.largeurBillard();      // abscisse maximal
yMax = cadre.hauteurBillard();      // ordonnée maximale

double rayon = 0.05*Math.min(xMax, yMax); // rayon des billes : ici toutes les billes ont le même rayon, mais ce n'est pas obligatoire

Vecteur p0, p1, p2, p3, p4, p5, v0, v1, v2, v3, v4, v5;    // les positions des centres des billes et les vecteurs vitesse au démarrage. 
                                                    // Elles vont être choisies aléatoirement

Vecteur pesanteur;			// représente la pesanteur appliquée aux billes qui y sont sensibles

//------------------- création des vecteurs position des billes ---------------------------------

p0 = Vecteur.créationAléatoire(0, 0, xMax, yMax);
p1 = Vecteur.créationAléatoire(0, 0, xMax, yMax);
p2 = Vecteur.créationAléatoire(0, 0, xMax, yMax);
p3 = Vecteur.créationAléatoire(0, 0, xMax, yMax);
p4 = Vecteur.créationAléatoire(0, 0, xMax, yMax);
p5 = Vecteur.créationAléatoire(0, 0, xMax, yMax);


//------------------- création des vecteurs vitesse des billes ---------------------------------

v0 = Vecteur.créationAléatoire(-vMax, -vMax, vMax, vMax);
v1 = Vecteur.créationAléatoire(-vMax, -vMax, vMax, 0);
v2 = Vecteur.créationAléatoire(-vMax, -vMax, vMax, vMax);
v3 = Vecteur.créationAléatoire(-vMax, -vMax, vMax, vMax);
v4 = Vecteur.créationAléatoire(-vMax, -vMax, vMax, vMax);
v5 = Vecteur.créationAléatoire(-vMax, -vMax, vMax, vMax);


//------------------- Instanciation de la pesanteur --------------------------------------------

pesanteur = new Vecteur(0, 0.001);
ComportementPesanteur.setPesanteur(pesanteur);

//--------------- ici commence la partie à changer ---------------------------------
/*------------------ définition originale des billes ------------------------
billes.add(new BilleMvtRURebond(p0, rayon, v0, Color.red));
billes.add(new BilleMvtPesanteurFrottementRebond(p1, rayon, v1, new Vecteur(0,0.001), Color.yellow));
billes.add(new BilleMvtNewtonFrottementRebond(p2, rayon, v2, Color.green));
billes.add(new BilleMvtRUPasseMurailles(p3, rayon, v3, Color.cyan));
billes.add(new BilleMvtNewtonArret(p4, rayon, v4,  Color.black));
*/
//-------------------- Nouvelle définition utilisant le DP décorateur -----------------
//billes.add(new BilleNormale(p0,rayon, v0, Color.red));	//créé une bille avec mouvement RU et rebond sur les parois
//billes.add(new ComportementPesanteur(new ComportementFrottements(new BilleNormale(p1, rayon, v1, Color.yellow))));	//créé une bille sensible à la pesanteur et aux frottements
//billes.add(new ComportementNewton(new ComportementFrottements(new BilleNormale(p2, rayon, v2, Color.green))));	// créé une bille sensible aux frottements et à l'attraction des autres
//billes.add(new ComportementPasseMurailles(new BilleNormale(p3, rayon, v3, Color.cyan))); // créé une bille passe murailles
//billes.add(new ComportementNewton(new ComportementArretSurLesBords(new BilleNormale(p4, rayon, v4, Color.black)))); // créé une bille attirée par les autres et qui s'arrête sur les murs

//billes.add(new ComportementBillePilotee(new BilleNormale(p5,rayon*2,v5,Color.gray),souris));
billes.add(new ComportementBillePilotee(new BilleNormale(p1,rayon,v1,Color.pink),souris));

//---------------------- ici finit la partie à changer ------------------------------------------------------------


System.out.println("billes = " + billes);


//-------------------- création de l'objet responsable de l'animation (c'est un thread séparé) -----------------------

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


//----------------------- mise en place des écouteurs de boutons qui permettent de contrôler (un peu...) l'application -----------------

//EcouteurBoutonLancer écouteurBoutonLancer = new EcouteurBoutonLancer(animationBilles);
//EcouteurBoutonArreter écouteurBoutonArrêter = new EcouteurBoutonArreter(animationBilles); 

//------------------------- activation des écouteurs des boutons et ça tourne tout seul ------------------------------

//cadre.lancerBilles.addActionListener(écouteurBoutonLancer);             // maladroit : à changer
//cadre.arrêterBilles.addActionListener(écouteurBoutonArrêter);           // maladroit : à changer




}

}
