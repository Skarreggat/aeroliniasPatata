/*
 * Una ruta transoceànica es defineix pel seu codi, aeroport d’origen, aeroport 
 * de destí, distància, país d’origen, país de destí, continent d’origen, continent 
 * de destí i oceà que sobrevola.
 */
package components;

import java.util.Scanner;

/**
 *
 * @author root
 */
public class RutaTransoceanica {

    private String codi;
    private String aeroportOri;
    private String aeroportDes;
    private String paisOri;
    private String paisDes;
    private String continentOri;
    private String continentDes;
    private String ocea;
    private double distancia;
    private static final Scanner DADES = new Scanner(System.in);

    /*
     CONSTRUCTOR
     Paràmetres: valors per tots els atributs de la classe.
     Accions:
     - Assignar als atributs els valors passats com a paràmetres.
     */
    public RutaTransoceanica(String pCodi, String pAeroportOri, String pAeroportDes, String pPaisOri, String pPaisDes, String pContinentOri, String pContinentDes, String pOcea, double pDistancia) {
        codi = pCodi;
        aeroportOri = pAeroportOri;
        aeroportDes = pAeroportDes;
        paisOri = pPaisOri;
        paisDes = pPaisDes;
        continentOri = pContinentOri;
        continentDes = pContinentDes;
        ocea = pOcea;
        distancia = pDistancia;

    }

    /*
    Mètodes accessors
     */
    public void setCodi(String pCodi) {
        codi = pCodi;
    }

    public void setAeroportOri(String pAeroportOri) {
        aeroportOri = pAeroportOri;
    }

    public void setAeroportDes(String pAeroportDes) {
        aeroportDes = pAeroportDes;
    }

    public void setPaisOri(String pPaisOri) {
        paisOri = pPaisOri;
    }

    public void setPaisDes(String pPaisDes) {
        paisDes = pPaisDes;
    }

    public void setContinentOri(String pContinentOri) {
        continentOri = pContinentOri;
    }

    public void setContinentDes(String pContinentDes) {
        continentDes = pContinentDes;
    }

    public void setOcea(String pOcea) {
        ocea = pOcea;
    }

    public void setDistancia(double pDistancia) {
        distancia = pDistancia;
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

    public String getContinentOri() {
        return continentOri;
    }

    public String getContinentDes() {
        return continentDes;
    }

    public double getDistancia() {
        return distancia;
    }

    public String getOcea() {
        return ocea;
    }

    /*
    Paràmetres: cap
    Accions:
    - Demanar a l'usuari les dades per consola per crear una nova ruta transcoceanica.
    Les dades a demanar són les que necessita el constructor.
    - Heu de tenir en compte que els aeroports i països no tene per què estar formats
    per una única paraula, per exemple, El Prat i Regne Unit.
     */
    public static RutaTransoceanica novaRutaTransoceanica() {

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
        System.out.println("Digam el Continent de Origen: ");
        String contO = DADES.nextLine();
        System.out.println("Digam el Continent de Desti: ");
        String contD = DADES.nextLine();
        System.out.println("Digam L'ocea: ");
        String pOcea = DADES.nextLine();
        System.out.println("Digam la Distancia: ");
        double dis = DADES.nextDouble();

        return new RutaTransoceanica(nom, aeroO, aeroD, paisO, paisD, contO, contD, pOcea, dis);
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
    public void modificarRutaTransoceanica() {

        System.out.println("DADES ACTUALS A MODIFICAR: \n");
        mostrarRutaTransoceanica();
        System.out.println("");
        System.out.println("CREACIO DE LA RUTA INTERNACIONAL!");

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
        System.out.println("Digam el Continent de Origen: ");
        continentOri = DADES.nextLine();
        System.out.println("Digam el Continent de Desti: ");
        continentDes = DADES.nextLine();
        System.out.println("Digam L'ocea: ");
        ocea = DADES.nextLine();
        System.out.println("Digam la Distancia: ");
        distancia = DADES.nextDouble();



    }

    public void mostrarRutaTransoceanica() {
        System.out.println("\nLes dades de la ruta transoceànica amb codi " + codi + " són:");
        System.out.println("\nAeroport d'origen: " + aeroportOri);
        System.out.println("\nAeroport de destí: " + aeroportDes);
        System.out.println("\nPaís d'origen: " + paisOri);
        System.out.println("\nPaís de destí: " + paisDes);
        System.out.println("\nContinent d'origen: " + continentOri);
        System.out.println("\nContinent de destí: " + continentDes);
        System.out.println("\nOceà que sobrevola: " + ocea);
        System.out.println("\nDistància: " + distancia);
    }
}
