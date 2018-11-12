/*
 * Una ruta nacional es defineix pel seu codi, aeroport d’origen, aeroport de 
 * destí, distància i país
 */
package components;

import java.util.Scanner;

/**
 *
 * @author root
 */
public class RutaNacionalD {

    private String codi;
    private String aeroportOri;
    private String aeroportDes;
    private double distancia;
    private String pais;
    private static final Scanner DADES = new Scanner(System.in);

    /*
     CONSTRUCTOR
     Paràmetres: valors per tots els atributs de la classe.
     Accions:
     - Assignar als atributs els valors passats com a paràmetres.
     */
    public RutaNacionalD(String pCodi, String pAeroportOri, String pAeroportDes, double pDistancia, String pPais) {

        codi = pCodi;
        aeroportOri = pAeroportOri;
        aeroportDes = pAeroportDes;
        distancia = pDistancia;
        pais = pPais;
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

    public void setDistancia(double pDistancia) {
        distancia = pDistancia;
    }

    public void setPais(String pPais) {
        pais = pPais;
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

    public double getDistancia() {
        return distancia;
    }

    public String getPais() {
        return pais;
    }

    /*
    Paràmetres: cap
    Accions:
    - Demanar a l'usuari les dades per consola per crear una nova ruta nacional.
    Les dades a demanar són les que necessita el constructor.
    - Heu de tenir en compte que els aeroports no tene per què estar formats per una única 
    paraula, per exemple, El Prat.
     */
    public static RutaNacionalD novaRutaNacional() {
        System.out.println("CREACIO DE LA RUTA NACIONAL!");
        System.out.println("Digam el codi de la ruta Nacional: ");
        String nom = DADES.nextLine();
        System.out.println("Digam el Aeroport d'origen: ");
        String aeroO = DADES.nextLine();
        System.out.println("Digam el Aeroport de Desti: ");
        String aeroD = DADES.nextLine();
        System.out.println("Digam la Distancia: ");
        double dis = DADES.nextDouble();
        System.out.println("Digam el Pais: ");
        String paisP = DADES.nextLine();

        return new RutaNacionalD(nom, aeroO, aeroD, dis, paisP);
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
    public void modificarRutaNacional() {
        System.out.println("MODIFICACIO DE LA RUTA NACIONAL\n");
        System.out.println("Digam el codi de la ruta Nacional: ");
        String nom = DADES.nextLine();
        System.out.println("Digam el Aeroport d'origen: ");
        String aeroO = DADES.nextLine();
        System.out.println("Digam el Aeroport de Desti: ");
        String aeroD = DADES.nextLine();
        System.out.println("Digam la Distancia: ");
        double dis = DADES.nextDouble();
        System.out.println("Digam el Pai: ");
        String paisP = DADES.nextLine();
        
        codi = nom;
        aeroportOri = aeroO;
        aeroportDes = aeroD;
        distancia = dis;
        pais = paisP;
    }

    public void mostrarRutaNacional() {
        System.out.println("\nLes dades de la ruta nacional amb codi " + codi + " són:");
        System.out.println("\nAeroport d'origen: " + aeroportOri);
        System.out.println("\nAeroport de destí: " + aeroportDes);
        System.out.println("\nDistància: " + distancia);
    }
}
