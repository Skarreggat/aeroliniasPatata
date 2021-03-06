/*
 * Un avió es defineix pel seu codi, fabricant, model, capacitat i un vector amb 
 * les seves classes.
 */
package components;

import java.util.Scanner;

/**
 *
 * @author root
 */
public class Avio {

    private String codi;
    private String fabricant;
    private String model;
    private int capacitat;
    private Classe[] classes;
    private int posicioClasses; //Atribut que controla la primera posició vuida del vector
    private static final Scanner DADES = new Scanner(System.in);

    /*
     CONSTRUCTOR
     Paràmetres: valors per tots els atributs de la classe menys classes i posicioClasses.
     Accions:
     - Assignar als atributs els valors passats com a paràmetres.
     - Inicialitzar el vector classes com a buit i una longitud de 4.
     - Inicialitzar l'atribut possicioClasses a 0.
     */
    public Avio(String pCodi, String pFabricant, String pModel, int pCapacitat) {

        codi = pCodi;
        fabricant = pFabricant;
        model = pModel;
        capacitat = pCapacitat;
        classes = new Classe[4];
        posicioClasses = 0;
    }


    /*
    Mètodes accessors
     */
    public void setCodi(String pCodi) {
        codi = pCodi;
    }

    public void setFabricant(String pFabricant) {
        fabricant = pFabricant;
    }

    public void setModel(String pModel) {
        model = pModel;
    }

    public void setCapacitat(int pCapacitat) {
        capacitat = pCapacitat;
    }
    
    public void setClasses(Classe[] pClasses) {
        classes = pClasses;
    }
    
    public void setPosicioClasses(int pPosicioClasses) {
        posicioClasses = pPosicioClasses;
    }

    public String getCodi() {
        return codi;
    }

    public String getFabricant() {
        return fabricant;
    }

    public String getModel() {
        return model;
    }

    public int getCapacitat() {
        return capacitat;
    }
    
    public Classe[] getClasses() {
        return classes;
    }
    
    public int getPosicioClasses() {
        return posicioClasses;
    }

    /*
    Paràmetres: cap
    Accions:
    - Demanar a l'usuari les dades per consola per crear un nou avió.
    Les dades a demanar són les que necessita el constructor.
    - També heu de tenir en compte que el fabricant o model, no tenen perquè estar 
    formats per una única paraula, per exemple, Airbus Company o Boing 777
    Retorn: El nou avió.
     */
    public static Avio nouAvio() {
        System.out.println("CREACIO DE L'AVIO!");
        System.out.println("Introdueix el codi per crear l'avió.");
        String codi = DADES.nextLine();
        System.out.println("Introdueix el fabricant per crear l'avió.");
        String fabricant = DADES.nextLine();
        System.out.println("Introdueix el model per crear l'avió.");
        String model = DADES.nextLine();
        System.out.println("Introdueix la capacitat per crear l'avió.");
        int capacitat = DADES.nextInt();

        return new Avio(codi, fabricant, model, capacitat);

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
    public void modificarAvio() {
        System.out.println("Dades Actuals a modificar: ");
        mostrarAvio();
        System.out.println("");
        System.out.println("MODIFICACIO DE L'AVIO\n");
        System.out.println("Introdueix el nou codi de l'avió.");
        codi = DADES.nextLine();
        System.out.println("Introdueix el nou fabricant de l'avió.");
        fabricant = DADES.nextLine();
        System.out.println("Introdueix el nou model de l'avió.");
        model = DADES.nextLine();
        System.out.println("Introdueix la nova capacitat de l'avió.");
        capacitat = DADES.nextInt();
        
        
    }

    public void mostrarAvio() {
        System.out.println("\nLes dades de l'avió amb codi " + codi + " són:");
        System.out.println("\nFabricant: " + fabricant);
        System.out.println("\nModel: " + model);
        System.out.println("\nCapacitat: " + capacitat);
    }

    /*
     Paràmetres: cap
     Accions:
     - Afegeix una nova classe al vector de classes de l'avió actual si aquesta encara 
     no s'ha afegit. S'ha de comprovar si s'ha afegit fent servir el mètode pertinent 
     d'aquesta classe, i actualitzar la posició del vector de classes.
     - Abans d'afegir la classe, també heu de comprovar que la seva capacitat sumada
     a la capacitat de les altres classes de l'avió, no superi la capacitat total
     de l'avió.
     - Si l'ingredient ja s'havia afegit o bé la seva capacitat sumada a les capacitats 
     de les altres classes supera la capacitat total de l'avió, no s'afegirà de nou i 
     li mostrarem a l'usuari el missatge "\nLa classe no s'ha pogut afegir".
     Retorn: cap
     */
    public void afegirClasse() {
        Classe algo = Classe.novaClasse();
        int suma = algo.getCapacitat();
        if (seleccionarClasse(algo.getNom()) == -1) {
            for (int i = 0; i < posicioClasses; i++) {
                suma += classes[i].getCapacitat();
            }
            if (suma <= capacitat) {
                classes[posicioClasses] = algo;
                posicioClasses++;
            }
        } else {
            System.out.println("La clase no s'ha afegit");
        }

    }

    public int seleccionarClasse(String nom) {

        boolean trobat = false;
        int pos = -1;

        for (int i = 0; i < posicioClasses && !trobat; i++) {
            if (classes[i].getNom().equals(nom)) {
                pos = i;
                trobat = true;
            }
        }

        return pos;
    }

}
