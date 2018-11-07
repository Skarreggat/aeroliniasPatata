/*
 * Defineix una classe d’un avió. Una classe d’un avió es defineix pel seu nom 
 * (no pot haver-hi un avió amb dues classes amb el mateix nom) i capacitat.
 * 
 */
package components;

import java.util.Scanner;

public class Classe {

    private String nom;
    private int capacitat;
    private static final Scanner DADES = new Scanner(System.in);

    /*
     CONSTRUCTOR
     Paràmetres: valors per tots els atributs de la classe.
     Accions:
     - Assignar als atributs els valors passats com a paràmetres.
     */
    public Classe(String pNom, int pCapacitat) {
        nom = pNom;
        capacitat = pCapacitat;
    }

    /*
    Mètodes accessors    
     */
    public void setNom(String pNom) {
        nom = pNom;
    }

    public String getNom() {
        return nom;
    }

    public void setCapacitat(int pCapacitat) {
        capacitat = pCapacitat;
    }

    public int getCapacitat() {

        return capacitat;
    }

    /*
    Paràmetres: cap
    Accions:
    - Demanar a l'usuari les dades per consola per crear una nova classe d'avió. 
      Les dades a demanar són les que necessita el constructor.
    - També heu de tenir en compte que el nom, no té perquè estar formt per una única
    paraula, per exemple, Turista Preferent.
    Retorn: La nova classe.
     */
    public static Classe novaClasse() {

        System.out.println("Digam el nom de la classe:");
        String clas = DADES.nextLine();
        System.out.println("Digam la seva capacitat");
        int capacitat = DADES.nextInt();

        return new Classe(clas, capacitat);
    }

    /*
     Paràmetres: cap
     Accions:
     - Demanar a l'usuari que introdueixi les noves dades de l'objecte actual
     i modificar els atributs corresponents d'aquest objecte.
     - Li heu de mostrar a l'usuari el valor actual dels atributs de l'objecte
     actual, abans de modificar-los
     Retorn: cap
     */
    public void modificarClasse() {
        
        mostrarClasse();
        System.out.println("Digam el nou nom: ");
        nom = DADES.nextLine();
        System.out.println("Digam la nova capacitat: ");
        capacitat = DADES.nextInt();
        
    }

    public void mostrarClasse() {
        System.out.println("\nLa classe " + nom + " té una capacitat de " + capacitat);
        
    }

}
