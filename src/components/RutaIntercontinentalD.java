/*
 * Una ruta intercontinental es defineix pel seu codi, aeroport d’origen, aeroport 
 * de destí, distància, país d’origen, país de destí, continent d’origen i continent 
 * de destí
 */
package components;

/**
 *
 * @author root
 */
public class RutaIntercontinentalD {

    private String codi;
    private String aeroportOri;
    private String aeroportDes;
    private String paisOri;
    private String paisDes;
    private String continentOri;
    private String continentDes;
    private double distancia;

    /*
     CONSTRUCTOR
     Paràmetres: valors per tots els atributs de la classe.
     Accions:
     - Assignar als atributs els valors passats com a paràmetres.
     */
    public RutaIntercontinentalD(String pCodi, String pAeroportOri, String pAeroportDes, String pPaisOri, String pPaisDes, String pContinentOri, String pContinentDes, double pDistancia){
        codi = pCodi;
        aeroportOri = pAeroportOri;
        aeroportDes = pAeroportDes;
        paisOri = pPaisOri;
        paisDes = pPaisDes;
        continentOri = pContinentOri;
        continentDes = pContinentDes;
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
    
   /*
    Paràmetres: cap
    Accions:
    - Demanar a l'usuari les dades per consola per crear una nova ruta internacional.
    Les dades a demanar són les que necessita el constructor.
    - Heu de tenir en compte que els aeroports i països no tene per què estar formats
    per una única paraula, per exemple, El Prat i Regne Unit.
     */
    public static RutaIntercontinentalD novaRutaIntercontinental() {

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
    public void modificarRutaIntercontinental() {

    }

    public void mostrarRutaIntercontinental() {
        System.out.println("\nLes dades de la ruta intercontinental amb codi " + codi + " són:");
        System.out.println("\nAeroport d'origen: " + aeroportOri);
        System.out.println("\nAeroport de destí: " + aeroportDes);
        System.out.println("\nPaís d'origen: " + paisOri);
        System.out.println("\nPaís de destí: " + paisDes);
        System.out.println("\nContinent d'origen: " + continentOri);
        System.out.println("\nContinent de destí: " + continentDes);
        System.out.println("\nDistància: " + distancia);
    }
}

