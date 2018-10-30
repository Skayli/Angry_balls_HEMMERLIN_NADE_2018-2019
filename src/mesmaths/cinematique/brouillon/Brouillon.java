package mesmaths.cinematique.brouillon;

import mesmaths.cinematique.Collisions;
import mesmaths.geometrie.base.Geop;
import mesmaths.geometrie.base.Vecteur;

public class Brouillon
{
/**
 * gestion de la collision dynamique (avec rebond) ou statique  de la bille d�finie par (position, rayon, vitesse, acc�l�ration) avec le segment orient� [P0P1]
 * 
 * @return l'intensit� du choc. Si la valeur retourn�e est > 0 alors il y a choc, si la valeur retourn�e est <= 0 alors il n'y a pas de choc. 
 * Plus la valeur retourn�e (lorsqu'elle est > 0) est grande, plus le choc est violent 
 * 
 *  si la valeur retourn�e est <= 0, vitesse et acc�l�ration sont laiss�s intacts
 * 
 * si la valeur retourn�e est > 0 alors vitesse et acc�l�ration sont modifi�s
 * 
 * 
 * c-�-d que en entr�e on consid�re que (position,vitesse, acc�l�ration) sont le vecteur position, le vecteur vitesse et le vecteur acc�l�ration de la bille 
 * imm�diatement avant le choc
 * et en sortie (position,vitesse, acc�l�ration) sont le vecteur position, le vecteur vitesse et le vecteur acc�l�ration de la bille imm�diatement apr�s le choc
 * 
 * si le choc est parfaitement dynamique, le vecteur vitesse est modifi� par la collision (comme une boule de billard l'est par une bande)
 * si le choc est parfaitement statique, le vecteur acc�l�ration est modifi� (on consid�re que le choc est �lastique et une force de rappel est appliqu�e � la bille)
 * Dans toutes les situations interm�diaires, le vecteur vitesse et le vecteur acc�l�ration sont modifi�s suivant une pond�ration qui cherche un compromis entre
 * situation dynamique et situation statique
 * 
 * Dans tous les cas, le vecteur position est laiss� intact par la collision,
 * 
 * @param position : vecteur position de la bille imm�diatement avant la collision avec le segment [P0P1]
 * @param rayon : rayon de la bille
 * @param vitesse : vecteur vitesse de la bille imm�diatement avant la collision avec le segment [P0P1]
 * @param acc�l�ration : vecteur vitesse de la bille imm�diatement avant la collision avec le segment [P0P1]
 * @param P0 : le d�but du segment
 * @param P1 : la fin du segment
 * 
 * */
static double actionReactionBilleSegmentAvecRebond( Vecteur position, double rayon, Vecteur vitesse, Vecteur acc�l�ration, double masse, Vecteur P0, Vecteur P1)
{
Vecteur[] base = Geop.base( P0,  P1);
Vecteur I = base[0];
Vecteur J = base[1];

double vJ = vitesse.produitScalaire(J);

if (vJ>=0) return -vJ; // la bille revient vers le bord depuis l'ext�rieur ou bien s'�loigne du bord depuis l'int�rieur: il n'y a pas de collision

// � pr�sent, on a forc�ment vJ < 0

double d = position.difference(P0).produitScalaire(J);  // d est la distance sign�e entre le segment et la bille

if (d >= rayon) return vJ; // il n'y a pas de collision

// � pr�sent, on a forc�ment : vJ < 0 et d < rayon

// d'abord calcul du vecteur vitesse r�fl�chi

Vecteur deltaV = J.produit(-2*vJ);      // deltaV = vecteur vitesse r�fl�chi - vecteur vitesse incident

// calcul de la force de rappel

double e = rayon - d;                    // profondeur de la pr�n�tration de la bille dans le mur, on a e > 0

double forceRappel = Collisions.COEFF_ELASTICITE_PAROI*e;

Vecteur a = J.produit(forceRappel/masse);

double v = -vJ; // on a forc�ment v > 0

double alfa = v/(v+e); 
double alfabar = 1-alfa;

Vecteur vS = Vecteur.combinaisonLin�aire(1, vitesse, alfa, deltaV);
vitesse.set(vS);
                                                 //System.err.println("choc mou avec la paroi" );
acc�l�ration.ajoute(a.produit(alfabar));
      
return v;
}                           // actionReactionBilleSegmentAvecRebond




/**
 * gestion de la collision dynamique (avec rebond) ou statique  de la bille d�finie par (position,rayon,vitesse,acc�l�ration) avec un contour rectangulaire de l'�cran.
 * 
 *  Ce rectangle est d�fini par (abscisseCoinHautGauche, Ordonn�eCoinHautGauche,largeur,hauteur)
 * 
 * @return une valeur <= 0 si il n'y a pas de collision
 * 
 * @return une valeur > 0 si il y a collision et dans ce cas modifie vitesse et acc�l�ration. Dans ce cas aussi, la valeur retourn�e mesure l'intensit� du choc
 * 
 * c-�-d que en entr�e on consid�re que (position,vitesse,acc�l�ration) sont le vecteur position, le vecteur vitesse et le vecteur acc�l�ration de la bille imm�diatement avant le choc
 * et en sortie (position,vitesse,acc�l�ration) sont le vecteur position, le vecteur vitesse et le vecteur acc�l�ration de la bille imm�diatement apr�s le choc
 * 
 * si le choc est parfaitement dynamique, le vecteur vitesse est modifi� par la collision (comme une boule de billard l'est par une bande)
 * si le choc est parfaitement statique, le vecteur acc�l�ration est modifi� (on consid�re que le choc est �lastique et une force de rappel est appliqu�e � la bille)
 * Dans toutes les situations interm�diaires, le vecteur vitesse et le vecteur acc�l�ration sont modifi�s suivant une pond�ration qui cherche un compromis entre
 * situation dynamique et situation statique
 * 
 * @param position : vecteur position de la bille imm�diatement avant la collision avec le contour
 * @param rayon : rayon de la bille
 * @param vitesse : vecteur vitesse de la bille imm�diatement avant la collision avec le contour
 * @param acc�l�ration : vecteur acc�l�ration de la bille imm�diatement avant la collision avec le contour
 * @param abscisseCoinHautGauche : abscisse minimale du contour rectangulaire
 * @param ordonn�eCoinHautGauche : ordonn�e minimale du contour rectangulaire
 * @param largeur : largeur du contour rectangulaire
 * @param hauteur : hauteur du contour rectangulaire
 * 
 * 
 * */
public static double actionReactionBilleContourAvecRebond( Vecteur position, double rayon, Vecteur vitesse, Vecteur acc�l�ration, double masse, 
        double abscisseCoinHautGauche, double ordonn�eCoinHautGauche, double largeur, double hauteur)
{
Vecteur min = new Vecteur(abscisseCoinHautGauche,ordonn�eCoinHautGauche);
Vecteur diago = new Vecteur(largeur, hauteur);
Vecteur max = min.somme(diago); 


Vecteur coins[] = new Vecteur[5];

coins[0] = min;         // le coin haut gauche du rectangle d�fini par le composant
coins[1] = new Vecteur(max.x,min.y);
coins[2] = max;
coins[3] = new Vecteur(min.x, max.y);
coins[4] = coins[0];                    // pour refermer le contour !

int i;

double intensit�Choc;

for ( i = 1; i < coins.length; ++i)
    if ( (intensit�Choc = Collisions.actionReactionBilleSegmentAvecRebond(position, rayon, vitesse, acc�l�ration, masse, coins[i-1], coins[i])) > 0) 
       return intensit�Choc;
    
return intensit�Choc;
}                   // actionReactionBilleContourAvecRebond


/**
 * g�re la collision dynamique ou statique des 2 billes d�finies respectivement par 
 * ( position1, rayon1, vitesse1, acc�l�ration1, masse1 ) et par ( position2, rayon2, vitesse2, acc�l�ration1, masse2)
 * 
 * si il n'y a pas de collision
 * renvoie une valeur < = 0 et ne modifie rien
 * 
 * si il y a collision dynamique :
 * renvoie une valeur > 0 repr�sentant l'intensit� du choc  et modifie  vitesse1 et vitesse2.
 * 
 * si il y a collision statique :
 * renvoie ? et modifie  acc�l�ration1 et acc�l�ration2. (une force de rappel �lastique est appliqu�e aux deux billes)
 * 
 * Les nouvelles acc�l�rations ou les nouveaux vecteurs vitesses sont calcul�s pour repr�senter l'�tat des billes imm�diatement apr�s le choc  
 * 
 * 
 * 
 * */

public static double actionReactionBilleBille2( Vecteur position1, double rayon1, Vecteur vitesse1, Vecteur acc�l�ration1, double masse1, 
        Vecteur position2, double rayon2, Vecteur vitesse2, Vecteur acc�l�ration2, double masse2)   
//modifie b1 et b2
//donn�es : b1 et b2 avant le choc
//r�sultats : b1 et b2 apr�s le choc
{
Vecteur G1G2;
double nG1G2, nG1G2_2;
G1G2 = Vecteur.difference(position2, position1);
nG1G2_2 = G1G2.normeCarr�e();

double r = rayon1+rayon2;

double r2 = r*r;

if (nG1G2_2 >= r2) return -1;           // on a donc nG1G2 >= rayon1 + rayon2, il n'y a donc pas de choc

// � pr�sent nG1G2_2 < r2

nG1G2 = Math.sqrt(nG1G2_2);

// on a donc nG1G2 < r

Vecteur u = G1G2.produit(1 / nG1G2);

Vecteur v1 = vitesse1;
Vecteur v2 = vitesse2;

Vecteur v1_v2 = Vecteur.difference(v1, v2);
double a = Vecteur.produitScalaire(u, v1_v2);


if (a <= 0) return a;       // il n'y a pas de collision, les billes s'�loignent l'une de l'autre ou ont des trajectoires parall�les

// � pr�sent, a > 0 et nG1G2 < r
 
double m1 = masse1;
double m2 = masse2;
double masseTotale = m1+m2;

double t;

t = 2 * (m1 / masseTotale) * a;

Vecteur  vs1, vs2;

vs1 = Vecteur.combinaisonLin�aire(1, v1, -(m2 / m1) * t, u);
vs2 = Vecteur.combinaisonLin�aire(1, v2, t, u); 

vitesse1.set(vs1);                  // vecteur vitesse de la bille 1 apr�s le choc
vitesse2.set(vs2);                  // vecteur vitesse de la bille 2 apr�s le choc

return a;


   
  /* double l = r + Collisions.EPSILON;

   if ( a < Collisions.EPSILON_CHOC_BILLE )
      {
            if (a > - Collisions.EPSILON_CHOC_BILLE)
                {                                           // choc sans vitesse

                double d = r - nG1G2;

                double forceRappel = Collisions.COEFF_ELASTICITE_BILLE * d;
                Vecteur a12, a21;
                a12 = u.produit(forceRappel / masse2);
                a21 = u.produit(-forceRappel / masse1);

                acc�l�ration1.ajoute(a21);
                acc�l�ration2.ajoute(a12);

                                                        //System.err.println("choc mou entre deux billes");
                return true;
                
                }
            else                                        // les 2 billes s'�loignent l'une de l'autre
                {                                       //System.err.println("fin de collision bille-bille");
                return false;
                }
        }
   else        a >= 0           // il y a choc �lastique entre les 2 billes
        {
        //d'abord calcul des vitesses apr�s le choc
        
        
        
        // � pr�sent calcul des positions apr�s le choc qui n'est plus utilis�e
        
        double v1_v2_2 = v1_v2.normeCarr�e();
        
        double delta1 = a*a - v1_v2_2*(nG1G2_2 - l*l );
        
        
        double dT = ( -a + Math.sqrt(delta1) ) / v1_v2_2;
        
        
        //position1.ajoute(vs1.produit(dT));
        //position2.ajoute(vs2.produit(dT));
        
                                                //System.err.println("choc rapide entre deux billes");
            
        return true;
        }
   }*/
} // actionReactionBilleBille2


public static double actionReactionBilleBille( Vecteur position1, double rayon1, Vecteur vitesse1, Vecteur acc�l�ration1, double masse1, 
        Vecteur position2, double rayon2, Vecteur vitesse2, Vecteur acc�l�ration2, double masse2)   
//modifie b1 et b2
//donn�es : b1 et b2 avant le choc
//r�sultats : b1 et b2 apr�s le choc
{
Vecteur G1G2;
double nG1G2, nG1G2_2;
G1G2 = Vecteur.difference(position2, position1);
nG1G2_2 = G1G2.normeCarr�e();

double r = rayon1+rayon2;

double r2 = r*r;

if (nG1G2_2 >= r2) return -1;           // on a donc nG1G2 >= rayon1 + rayon2, il n'y a donc pas de choc

// � pr�sent nG1G2_2 < r2

nG1G2 = Math.sqrt(nG1G2_2);

// on a donc nG1G2 < r

Vecteur u = G1G2.produit(1 / nG1G2);

Vecteur v1 = vitesse1;
Vecteur v2 = vitesse2;

Vecteur v1_v2 = Vecteur.difference(v1, v2);
double a = Vecteur.produitScalaire(u, v1_v2); // a est l'intensit� du choc

double e = r - nG1G2;       // e est la profondeur de la p�n�tration d'une bille dans l'autre

double forceRappel = Collisions.COEFF_ELASTICITE_BILLE * e*e;

Vecteur a12, a21;
a12 = u.produit(forceRappel / masse2);
a21 = u.produit(-forceRappel / masse1);

acc�l�ration1.ajoute(a21);
acc�l�ration2.ajoute(a12);

return a;

} // actionReactionBilleBille

