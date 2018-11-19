/*
 * Un tripulant de cabina de passatgers (TCP) es defineix pel seu passaport, nom
 * , edat, data d’alta en la companyia, hores que porta de vol i rang
 */
package components;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author root
 */
public class TCP {

    private String passaport;
    private String nom;
    private int edat;
    private Date dataAlta;
    private LocalTime horesVol;
    private String rang;
    private static final Scanner DADES = new Scanner(System.in);

    /*
     CONSTRUCTOR
     Paràmetres: valors per tots els atributs de la classe menys dataAlta rang.
     Accions:
     - Assignar als atributs els valors passats com a paràmetres.
     - Inicialitzar l'atribut dataAlta amb l'hora actual del sistema.
     - Inicialitzar l'atribut rang a null, ja que quan es crea un TCP, mai té rang.
     */
    public TCP(String pPassaport, String pNom, int pEdat, LocalTime pHoresVol) {
        passaport = pPassaport;
        nom = pNom;
        edat = pEdat;
        dataAlta = new Date();
        horesVol = pHoresVol;
        rang = null;
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

    public void setDataAlta() {
        dataAlta = new Date();
    }

    public void setHoresVol(LocalTime pHoresVol) {
        horesVol = pHoresVol;
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

    /*
    Paràmetres: cap
    Accions:
    - Demanar a l'usuari les dades per consola per crear un nou TCP.
    Les dades a demanar són les que necessita el constructor.
    - Heu de tenir en compte que el nom no té per què estar format per una única 
    paraula, per exemple, Pep Gómez.
    - També heu de tenir en compte que les hores de vol són de tipus LocalTime, per
    tant heu de demanar a l'usuari les hores i minuts per crear el LocalTime. En aquest
    cas es considerarà que els segons i nanosegons, sempre són  0.
     */
    public static TCP nouTCP(){
        System.out.println("CREACIO DE TCP!");
        System.out.println("Introdueix el passaport del TCP: ");
        String pass = DADES.nextLine();
        System.out.println("Introdueix el nom del TCP: ");
        String nom = DADES.nextLine();
        System.out.println("Introdueix l'edat del TCP: ");
        int ed = DADES.nextInt();
        System.out.println("Introdueix les hores de vol del TCP: ");
        int hores = DADES.nextInt();
        System.out.println("Introdueix els minuts de vol del TCP: ");
        int minuts = DADES.nextInt();
        
        
        LocalTime.of(hores, minuts);
        
        return new TCP(pass, nom, ed, LocalTime.of(hores, minuts));
    }

    /*
     Paràmetres: cap
     Accions:
     - Demanar a l'usuari que introdueixi les noves dades de l'objecte actual
     i modificar els atributs corresponents d'aquest objecte menys data d'alta i
     rang.
     - Li heu de mostrar a l'usuari el valor actual dels atributs de l'objecte
     actual, abans de modificar-los. En el cas de les hores de vol, només se li han
     de mostrar les hores i minuts.
    
     Retorn: cap
     */
    public void modificarTCP()throws ParseException {
        System.out.println("Dades Actuals a modificar: ");
        mostrarTCP();
        System.out.println("");
        System.out.println("MODIFICACIO DEL TCP\n");
        System.out.println("Introdueix el nou passaport del TCP: ");
        String pass = DADES.nextLine();
        System.out.println("Introdueix el nom del TCP: ");
        String nomP = DADES.nextLine();
        System.out.println("Introdueix l'edat del TCP: ");
        int ed = DADES.nextInt();
        System.out.println("Introdueix les hores de vol del TCP: ");
        int hores = DADES.nextInt();
        System.out.println("Introdueix els minuts de vol del TCP: ");
        int minuts = DADES.nextInt();
        System.out.println("Introdueix la data d'alta del TCP:(dd-MM-yyyy)");
        Date daataAlta = new SimpleDateFormat("hh:mm:ss a dd-MM-yyyy").parse(new Scanner(System.in).nextLine());
        
        passaport = pass;
        nom = nomP;
        edat = ed;
        horesVol = LocalTime.of(hores, minuts);
        dataAlta = daataAlta;
    }

    public void mostrarTCP() {
        System.out.println("\nLes dades del tripulant de cabina amb passaport " + passaport + " són:");
        System.out.println("\nNom: " + nom);
        System.out.println("\nEdat: " + edat);
        System.out.println("\nData d'alta: " + new SimpleDateFormat("dd-MM-yyyy").format(dataAlta));
        System.out.println("\nHores de vol: " + horesVol.getHour() + ":" + horesVol.getMinute());
        System.out.println("\nRang: " + rang);
    }

}
