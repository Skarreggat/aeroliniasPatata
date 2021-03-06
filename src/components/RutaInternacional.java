/*
 * Una ruta internacional es defineix pel seu codi, aeroport d’origen, aeroport 
 * de destí, distància, país d’origen i país de destí
 */
package components;

import java.util.Scanner;

/**
 *
 * @author root
 */
public class RutaInternacional {

    private String codi;
    private String aeroportOri;
    private String aeroportDes;
    private String paisOri;
    private String paisDes;
    private double distancia;
    private static final Scanner DADES = new Scanner(System.in);

    /*
     CONSTRUCTOR
     Paràmetres: valors per tots els atributs de la classe.
     Accions:
     - Assignar als atributs els valors passats com a paràmetres.
     */
    public RutaInternacional(String pCodi, String pAeroportOri, String pAeroportDes, String pPaisOri, String pPaisDes, double pDistancia) {
        codi = pCodi;
        aeroportOri = pAeroportOri;
        aeroportDes = pAeroportDes;
        paisOri = pPaisOri;
        paisDes = pPaisDes;
        distancia = pDistancia;

    }

    /*
    Mètodes accessors
     */
    public void setCodi(String pCodi) {
        codi = pCodi;
    }

    public void setAeroportOri(String pAeroportOri) {
        codi = pAeroportOri;
    }

    public void setAeroportDes(String pAeroportDes) {
        codi = pAeroportDes;
    }

    public void setPaisOri(String pPaisOri) {
        codi = pPaisOri;
    }

    public void setPaisDes(String pPaisDes) {
        codi = pPaisDes;
    }

    public void setDistancia(String pDistancia) {
        codi = pDistancia;
    }

    public String getCodi() {
        return codi;
    }

    public String getAeroportOri() {
        return aeroportOri;
    }

    public String getAeroportDes() {
        return aeroportDes;
    }

    public String getPaisOri() {
        return paisOri;
    }

    public String getPaisDes() {
        return paisDes;
    }

    public double getDistancia() {
        return distancia;
    }

    /*
    Paràmetres: cap
    Accions:
    - Demanar a l'usuari les dades per consola per crear una nova ruta internacional.
    Les dades a demanar són les que necessita el constructor.
    - Heu de tenir en compte que els aeroports països no tene per què estar formats per una única 
    paraula, per exemple, El Prat o Regne Unit.
     */
    public static RutaInternacional novaRutaInternacional() {
        System.out.println("CREACIO DE LA RUTA INTERNACIONAL!");
        System.out.println("Digam el codi de la ruta Internacional: ");
        String nom = DADES.nextLine();
        System.out.println("Digam el Aeroport d'origen: ");
        String aeroO = DADES.nextLine();
        System.out.println("Digam el Aeroport de Desti: ");
        String aeroD = DADES.nextLine();
        System.out.println("Digam el Pais d'Origen: ");
        String paisO = DADES.nextLine();
        System.out.println("Digam el Pais de Desti: ");
        String paisD = DADES.nextLine();
        System.out.println("Digam la Distancia: ");
        double dis = DADES.nextDouble();

        return new RutaInternacional(nom, aeroO, aeroD, paisO, paisD,dis);
    }

    /*
     Paràmetres: cap
     Accions:
     - Demanar a l'usuari que introdueixi les noves dades de l'objecte actual
     i modificar els atributs corresponents d'aquest objecte.
     - Li heu de mostrar a l'usuari el valor actual dels atributs de l'objecte
     actual, abans de modificar-los.
    
     Retorn: cap
     */
    public void modificarRutaInternacional() {
        System.out.println("Dades Actuals a modificar: ");
        mostrarRutaInternacional();
        System.out.println("");
        System.out.println("MODIFICACIO DE LA RUTA INTERNACIONAL\n");
        System.out.println("Digam el codi de la ruta Internacional: ");
        codi = DADES.nextLine();
        System.out.println("Digam el Aeroport d'origen: ");
        aeroportOri = DADES.nextLine();
        System.out.println("Digam el Aeroport de Desti: ");
        aeroportDes = DADES.nextLine();
        System.out.println("Digam el Pais d'Origen: ");
        paisOri = DADES.nextLine();
        System.out.println("Digam el Pais de Desti: ");
        paisDes = DADES.nextLine();
        System.out.println("Digam la Distancia: ");
        distancia = DADES.nextDouble();

    }

    public void mostrarRutaInternacional() {
        System.out.println("\nLes dades de la ruta internacional amb codi " + codi + " són:");
        System.out.println("\nAeroport d'origen: " + aeroportOri);
        System.out.println("\nAeroport de destí: " + aeroportDes);
        System.out.println("\nPaís d'origen: " + paisOri);
        System.out.println("\nPaís de destí: " + paisDes);
        System.out.println("\nDistància: " + distancia);
    }
}
