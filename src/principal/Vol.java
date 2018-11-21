/*
 * Un vol es defineix pel seu codi, ruta, avio, un vector amb els seus tripulants 
 * (tripulació), data de sortida, data d’arribada, hora de sortida, hora d’arribada
 * i durada.
 */
package principal;

import components.Avio;
import components.RutaIntercontinental;
import components.RutaInternacional;
import components.RutaNacional;
import components.RutaTransoceanica;
import components.TCP;
import components.TripulantCabina;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author root
 */
public class Vol {

    private String codi;
    private Object ruta;
    private int tipusRuta;
    private Avio avio;
    private TripulantCabina[] tripulacioCabina;
    private int posicioTripulacioCabina;
    private TCP[] tcps;
    private int posicioTcps;
    private Date dataSortida;
    private Date dataArribada;
    private LocalTime horaSortida;
    private LocalTime horaArribada;
    private String durada;
    private static final Scanner DADES = new Scanner(System.in);

    /*
     CONSTRUCTOR
     Paràmetres: valors per tots els atributs de la classe menys ruta, avio,
     tripulacioCabina, posicioTripulacioCabina, tcp i posicioTCP.
     Accions:
     - Assignar als atributs els valors passats com a paràmetres.
     - Inicialitzar ruta i avio a null, ja que quan es crea un vol, encara no s'han
     assignat ni la ruta ni el vol.
     - Inicialitzarem l'atribut tipusRuta a 0, ja que com no s'ha assignat encara una ruta,
     no podem saber de quin tipus és.
     - Inicialitzar el vector tripulacioCabina com a buit i una longitud de 7.
     - Inicialitzar el vector tcps com a buit i una longitud de 25.
     - Inicialitzar els atributs posicioTripulacioCabina i posicioTcps a 0.
     - Inicialitzar l'atribut durada amb el mètode pertinent d'aquesta classe.
     */
    public Vol(String pCodi, LocalTime pHoraSortida, LocalTime pHoraArribada, Date pDataSortida, Date pDataArribada) {
        codi = pCodi;
        tipusRuta = 0;
        horaSortida = pHoraSortida;
        horaArribada = pHoraArribada;
        dataSortida = pDataSortida;
        dataArribada = pDataArribada;
        avio = null;
        ruta = null;
        tripulacioCabina = new TripulantCabina[7];
        tcps = new TCP[25];
        posicioTripulacioCabina = 0;
        posicioTcps = 0;
        calcularDurada();
    }

    /*
    Mètodes accessors
     */
    public void setCodi(String pCodi) {
        codi = pCodi;
    }

    public void setHoraSortida(LocalTime pHoraSortida) {
        horaSortida = pHoraSortida;
    }

    public void setHoraArribada(LocalTime pHoraArribada) {
        horaArribada = pHoraArribada;
    }

    public void setDataSortida(Date pDataSortida) {
        dataSortida = pDataSortida;
    }

    public void setDataArribada(Date pDataArribada) {
        dataArribada = pDataArribada;
    }

    public void setDurada(String pDurada) {
        durada = pDurada;
    }

    public void setTipusRuta(int pTipusRuta) {
        tipusRuta = pTipusRuta;
    }

    public void setRuta(Object pRuta) {
        ruta = pRuta;
    }

    public void setAvio(Avio pAvio) {
        avio = pAvio;
    }

    public void setTripulacioCabina(TripulantCabina[] pTripulacioCabina) {
        tripulacioCabina = pTripulacioCabina;
    }

    public void setTcps(TCP[] pTcps) {
        tcps = pTcps;
    }

    public void setPosicioTripulacioCabina(int pPosicioTripulacioCabina) {
        posicioTripulacioCabina = pPosicioTripulacioCabina;
    }

    public void setPosicioTcps(int pPosicioTcps) {
        posicioTcps = pPosicioTcps;
    }

    public String getCodi() {
        return codi;
    }

    public LocalTime getHoraSortida() {
        return horaSortida;
    }

    public LocalTime getHoraArribada() {
        return horaArribada;
    }

    public Date getDataSortida() {
        return dataSortida;
    }

    public Date getDataArribada() {
        return dataArribada;
    }

    public int getPosicioTcps() {
        return posicioTcps;
    }

    public int getPosicioTripulacioCabina() {
        return posicioTripulacioCabina;
    }

    public Object getRuta() {
        return ruta;
    }

    public Avio getAvio() {
        return avio;
    }

    public String getDurada() {
        return durada;
    }

    public int getTipusRuta() {
        return tipusRuta;
    }

    public TripulantCabina[] getTripulacioCabina() {
        return tripulacioCabina;
    }

    public TCP[] getTcps() {
        return tcps;
    }


    /*
    Paràmetres: cap
    Accions:
    - Demanar a l'usuari les dades per consola per crear un nou vol.
    Les dades a demanar són les que necessita el constructor.
    - En el cas de les dates, li hem de demanar a l'usuari que les introdueixi
    amb el format dd-mm-yyyy. Penseu que la data introduïda per l'usuari serà
    de tipus String i nosaltres l'hem de convertir a data.
    - En el cas de les hores només haurem de demanar l'hora i minuts, els segons
    i nanosegons no els tindrem en compte.
    Retorn: El nou vol.
     */
    public static Vol nouVol() throws ParseException {
        System.out.println("CREACIO DE VOL!");
        System.out.println("Introdueix el codi del vol: ");
        String codi = DADES.nextLine();

        System.out.println("Introdueix la hora de sortida del vol: ");
        int horaS = DADES.nextInt();
        System.out.println("Introdueix el minut de sortida del vol: ");
        int minutS = DADES.nextInt();

        LocalTime.of(horaS, minutS);

        System.out.println("Introdueix la hora d'arribada del vol: ");
        int horaA = DADES.nextInt();
        System.out.println("Introdueix el minut d'arribada del vol: ");
        int minutA = DADES.nextInt();

        LocalTime.of(horaA, minutA);

        System.out.println("Introdueix la data de sortida del vol:(dd-MM-yyyy)");
        Date dataSortida = new SimpleDateFormat("dd-MM-yyyy").parse(new Scanner(System.in).nextLine());

        System.out.println("Introdueix la data d'arribada del vol:(dd-MM-yyyy)");
        Date dataArribada = new SimpleDateFormat("dd-MM-yyyy").parse(new Scanner(System.in).nextLine());

        return new Vol(codi, LocalTime.of(horaS, minutS), LocalTime.of(horaA, minutA), dataSortida, dataArribada);
    }

    /*
     Paràmetres: cap
     Accions:
     - Demanar a l'usuari que introdueixi les noves dades de l'objecte actual
     i modificar els atributs corresponents d'aquest objecte, excepte ruta, avio,
     tripulacioCabina, tcps, posicioTripulacioCabina i posicioTcps.
     - Li heu de mostrar a l'usuari el valor actual dels atributs de l'objecte
     actual, abans de modificar-los. Les dates les heu de mostrar amb el format
     dd-mm-yyyy, i les hores amb el format hh:mm.
     - Per demanar els nous valors de les dates i les hores, farem el mateix que
     en el mètode anterior nouVol().
     - Si es modifiquen els atributs de data o d'hora, també s'haurà de modificar
     el valor de durada mitjançant el mètode adient d'aquesta classe.
     Retorn: cap
     */
    public void modificarVol() throws ParseException {
        System.out.println("Dades Actuals a modificar: ");
        mostrarVol();
        System.out.println("");
        System.out.println("MODIFICACIO DEL VOL\n");

        //____________________
        System.out.println("Introdueix el nou codi del vol: ");
        String codiP = DADES.nextLine();

        System.out.println("Introdueix la nova hora de sortida del vol: ");
        int horaS = DADES.nextInt();
        System.out.println("Introdueix el nou minut de sortida del vol: ");
        int minutS = DADES.nextInt();

        LocalTime.of(horaS, minutS);

        System.out.println("Introdueix lanova hora d'arribada del vol: ");
        int horaA = DADES.nextInt();
        System.out.println("Introdueix el nou minut d'arribada del vol: ");
        int minutA = DADES.nextInt();

        LocalTime.of(horaA, minutA);

        System.out.println("Introdueix la nova data de sortida del vol:(dd-MM-yyyy)");
        Date dataS = new SimpleDateFormat("dd-MM-yyyy").parse(new Scanner(System.in).nextLine());

        System.out.println("Introdueix la nova data d'arribada del vol:(dd-MM-yyyy)");
        Date dataA = new SimpleDateFormat("dd-MM-yyyy").parse(new Scanner(System.in).nextLine());

        codi = codiP;
        horaSortida = LocalTime.of(horaS, minutS);
        horaArribada = LocalTime.of(horaA, minutA);
        dataSortida = dataS;
        dataArribada = dataA;
        calcularDurada();

    }

    /*
     Paràmetres: cap
     Accions:
     - Se li assignarà a l'atribut durada el valor tenint en compte que la durada
     és la diferència de temps entre la data i hora de sortida, i la data i hora
     d'arribada.
     - La durada ha de tenir el format "X h - Y s", on X seran les hores de durada i Y els minuts
     Retorn: cap
     */
    private void calcularDurada() {
        long segA = dataArribada.getTime();
        long segS = dataSortida.getTime();
        int horSegS = horaSortida.getHour() * 3600;
        int minSegS = horaSortida.getMinute() * 60;
        int horSegA = horaArribada.getHour() * 3600;
        int minSegA = horaArribada.getMinute() * 60;
        float segundos = ((segA + horSegA + minSegA) - (segS + horSegS + minSegS));
        float horas = segundos / 3600;
        float module = segundos % 3600;
        float min = module * 60;

        durada = horas + " - " + min;
    }

    /*
     Paràmetres: tripulant de cabina
     Accions:
     - afegeix el tripulant de cabina passat per paràmetre al vector tripulacioCabina    
     en la primera posició buida del vector i actualitza la posició del vector tripulacioCabina.
     Retorn: cap
     */
    public void afegirTripulantCabina(TripulantCabina tripulantCabina) {
        tripulacioCabina[posicioTripulacioCabina] = tripulantCabina;
        posicioTripulacioCabina++;
    }

    /*
     Paràmetres: TCP
     Accions:
     - afegeix el TCP passat per paràmetre al vector tcps en la primera posició buida 
     del vector i actualitza la posició del vector tcps.
     Retorn: cap
     */
    public void afegirTCP(TCP tcp) {
        tcps[posicioTcps] = tcp;
        posicioTcps++;
    }

    public void mostrarVol() {
        System.out.println("\nLes dades del vol amb codi " + codi + " són:");

        System.out.println("\nRuta: ");
        switch (tipusRuta) {
            case 1:
                ((RutaNacional) ruta).mostrarRutaNacional();
                break;
            case 2:
                ((RutaInternacional) ruta).mostrarRutaInternacional();
                break;
            case 3:
                ((RutaIntercontinental) ruta).mostrarRutaIntercontinental();
                break;
            case 4:
                ((RutaTransoceanica) ruta).mostrarRutaTransoceanica();
                break;
        }

        System.out.println("\nAvio: ");
        avio.mostrarAvio();

        System.out.println("\nData de sortida: " + new SimpleDateFormat("dd-MM-yyyy").format(dataSortida));
        System.out.println("\nData d'arribada: " + new SimpleDateFormat("dd-MM-yyyy").format(dataArribada));
        System.out.println("\nHores de sortida: " + horaSortida.getHour() + ":" + horaSortida.getMinute());
        System.out.println("\nHores d'arribada: " + horaArribada.getHour() + ":" + horaArribada.getMinute());

        System.out.println("\nLa tripulació de cabina és:");
        for (int i = 0; i < posicioTripulacioCabina; i++) {
            tripulacioCabina[i].mostrarTripulantCabina();
        }

        System.out.println("\nLa tripulació de cabina de passatgers és:");
        for (int i = 0; i < posicioTcps; i++) {
            tcps[i].mostrarTCP();
        }

        System.out.println("\nDurada: " + durada);
    }

}
