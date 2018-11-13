package version_maladroite.vues;

import java.awt.Frame;
import java.util.Vector;

import version_maladroite.modele.Bille;


public class TestCadreAngryBallsSeul
{

/**
 * @param args
 */
public static void main(String[] args)
{
Vector<Bille> billes = new Vector<Bille>();
CadreAngryBalls cadre =new CadreAngryBalls("angry balls", "animation de billes marrantes", billes);
cadre.montrer();
}

}
