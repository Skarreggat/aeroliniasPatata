/*
 * Un tripulant de cabina es defineix pel seu passaport, nom, edat, data d’alta 
 * en la companyia, hores que porta de vol, rang i barres
 */
package components;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author root
 */
public class TripulantCabina {

    private final static Scanner DADES = new Scanner(System.in);

    private String passaport;
    private String nom;
    private int edat;
    private Date dataAlta;
    private LocalTime horesVol;
    private String rang;
    private int barres;


    /*
     CONSTRUCTOR
     Paràmetres: valors per tots els atributs de la classe menys dataAlta i barres.
     Accions:
     - Assignar als atributs els valors passats com a paràmetres.
     - Inicialitzar l'atribut dataAlta amb l'hora actual del sistema.
     - Inicialitzar l'atribut barres mitjançant el mètode pertinent d'aquesta classe.
     */
    public TripulantCabina(String pPassaport, String pNom, int pEdat, LocalTime pHoresVol, String pRang) {
        passaport = pPassaport;
        nom = pNom;
        edat = pEdat;
        dataAlta = new Date();
        horesVol = pHoresVol;
        rang = pRang;
        assignarBarres(rang);

    }


    /*
    Mètodes accessors
     */
    public void setPassaport(String pPassaport) {
        passaport = pPassaport;
    }

    public void setNom(String pNom) {
        nom = pNom;
    }

    public void setEdat(int pEdat) {
        edat = pEdat;
    }

    public void setDataAlta(LocalTime pHoresVol) {
        horesVol = pHoresVol;
    }

    public void setHoresVol() {
        dataAlta = new Date();
    }

    public void setBarres(int pBarres) {
        barres = pBarres;
    }

    public void setRang(String pRang) {
        rang = pRang;
    }

    public String getPassaport() {
        return passaport;
    }

    public String getNom() {
        return nom;
    }

    public int getEdat() {
        return edat;
    }

    public Date getDataAlta() {
        return dataAlta;
    }

    public LocalTime getHoresVol() {
        return horesVol;
    }

    public String getRang() {
        return rang;
    }

    public int getBarres() {
        return barres;
    }

    /*
    Paràmetres: cap
    Accions:
    - Demanar a l'usuari les dades per consola per crear un nou tripulant de cabina.
    Les dades a demanar són les que necessita el constructor.
    - Heu de tenir en compte que el nom no té per què estar format per una única 
    paraula, per exemple, Pep Gómez.
    - També heu de tenir en compte que les hores de vol són de tipus LocalTime, per
    tant heu de demanar a l'usuari les hores i minuts per crear el LocalTime. En aquest
    cas es considerarà que els segons i nanosegons, sempre són  0.
    -  Li demanarà a l'usuari el rang del tripulant de cabina tenint en compte que
    "C" serà el que ha d'introduir l'usuari si el rang és comandant, "CP" si és
    copilot i "EV" si és enginyer de vol.
    - Si no introdueix cap dels tres rangs, no se li assignarà cap valor al rang i se 
    li mostrarà a l'usuari el missatge "\nEl rang introduït no és correcte".
    - Si el rang introduït és correcte, se li assignarà a l'atribut rang "Comandant"
    en cas que el valor introduït sigui "C", "Copilot" en cas que el valor introduït
    sigui "CP" i "Enginyer de vol" en cas que el valor introduït sigui "EV".
    Retorn: El nou tripulant de cabina.
     */
    public static TripulantCabina nouTripulantCabina() {

        System.out.println("CREACIO DE NOU TRIPULANT\n");
        System.out.println("Introdueix el nou Passaport: ");
        String pass = DADES.nextLine();
        System.out.println("Introdueix el nou nom: ");
        String pNom = DADES.nextLine();
        System.out.println("Introdueix la nova edat: ");
        int pedat = DADES.nextInt();

        System.out.println("Introdueix les noves Hores de vol: ");
        int hores = DADES.nextInt();
        System.out.println("Introdueix els nous minuts de vol: ");
        int minuts = DADES.nextInt();
        

        DADES.nextLine();

        System.out.println("Introdueix el nou rang(CP/C/EV): ");
        String Rang = DADES.next();
        String pRang = "";
        switch (Rang) {
            case "C":
                pRang = "Comandant";
                break;
            case "CP":
                pRang = "Copilot";
                break;
            case "EV":
                pRang = "Enginyer de vol";
                break;

            default:
                System.out.println("El rang introduït no és correcte");

        }

        return new TripulantCabina(pass, pNom, pedat, LocalTime.of(hores, minuts), pRang);

    }

    /*
     Paràmetres: cap
     Accions:
     - Demanar a l'usuari que introdueixi les noves dades de l'objecte actual
     i modificar els atributs corresponents d'aquest objecte menys data d'alta.
     - Li heu de mostrar a l'usuari el valor actual dels atributs de l'objecte
     actual, abans de modificar-los. En el cas de les hores de vol, només se li han
     de mostrar les hores i minuts.
     - Si es vol modificar el rang, a l'hora de demanar-li el nou rang a l'usuari
     haurem de fer el mateix que en el mètode nouTripulantCabina, però en aquest 
     cas, si no s'introdueix un rang correcte, en lloc de no assignar-li res a 
     l'atribut rang, el que farem és no modificar el seu valor actual.
     - Abans de modificar el valor del rang, hem de comprovar que el nou valor 
     compleix els requisits especificats en l'enunciat de la pràctica de la UF1 
     del mòdul 5, és a dir, un Enginyer de cabina pot passar a ser còpilot si té 5
     o més anys d'antiguetat, i un copilot pot passar a ser comandant, si té 15 
     o més anys d'antiguetat.
     - Si modifiquem el valor del rang, també haurem de modificar el valor de les
     barres amb el mètode adient d'aquesta classe.
    
     NOTA: 5 anys són 157788000 segons.
    
     Retorn: cap
     */
    public void modificarTripulantCabina() {

        System.out.println("DADES ACTUALS A MODIFICAR: \n");
        mostrarTripulantCabina();
        System.out.println("");
        System.out.println("CREACIO DE NOU TRIPULANT\n");

        System.out.println("Introdueix el Passaport: ");
        passaport = DADES.nextLine();
        System.out.println("Introdueix el nom: ");
        nom = DADES.nextLine();
        System.out.println("Introdueix l'edat: ");
        edat = DADES.nextInt();

        System.out.println("Introdueix les Hores de vol: ");
        int hores = DADES.nextInt();
        System.out.println("Introdueix els minuts de vol: ");
        int minuts = DADES.nextInt();

        horesVol = LocalTime.of(hores, minuts);

        System.out.println("Introdueix el rang(CP/C/EV): ");
        String Rang = DADES.next();

        switch (Rang) {
            case "C":
                if (this.rang.equals("Copilot")) {
                    if ((((hores * 3600) + (minuts * 60)) * 3) < (157788000 * 3)) {
                        rang = "Comandant";
                        assignarBarres(rang);
                    }
                }
                break;
            case "CP":
                if (this.rang.equals("Enginyer de vol")) {
                    if (((hores * 3600) + (minuts * 60)) < 157788000) {
                        rang = "Copilot";
                        assignarBarres(rang);
                    }
                }
                break;
            case "EV":

                rang = "Enginyer de vol";
                assignarBarres(rang);

                break;

            default:
                System.out.println("El rang introduït no és correcte");

        }

    }

    public void mostrarTripulantCabina() {
        System.out.println("\nLes dades del tripulant de cabina amb passaport " + passaport + " són:");
        System.out.println("\nNom: " + nom);
        System.out.println("\nEdat: " + edat);
        System.out.println("\nData d'alta: " + new SimpleDateFormat("dd-MM-yyyy").format(dataAlta));
        System.out.println("\nHores de vol: " + horesVol.getHour() + ":" + horesVol.getMinute());
        System.out.println("\nRang: " + rang);
        System.out.println("\nBarres: " + barres);
    }

    /*
     Paràmetres: rang
     Accions:
     - Se li assignarà a l'atribut barres el valor corresponent segons el rang introduït
     per paràmetre i les especificacions de l'enunciat de la UF1 del mòdul 5, és a dir, 
     en el cas del copilot, 2 barres si té menys de 1500 hores de vol i 3 si té 1500 o més, 
     en el cas del comandant sempre 4 i en el cas de l'enginyer de vol sempre 1.
     Retorn: número de barres
     */
    public void assignarBarres(String pRang) {

        switch (pRang) {
            case "Comandant":
                barres = 4;
                break;
            case "Copilot":
                if (horesVol.getHour() < 1500) {
                    barres = 2;
                } else {
                    barres = 3;
                }
                break;
            case "Enginyer de vol":
                barres = 1;
                break;
            default:
                barres = 0;
        }

    }

}
