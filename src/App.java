import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String scelta;
        Lavatrice lav = new Lavatrice();

        System.out.println("Benvenuto nella lavatrice virtuale!");

        do {
            System.out.println("\n\n\n\n\n\n\n\n\n*** GESTIONE LAVATRICE ***");
            System.out.println(lav.toString());

            System.out.println("1 - accendi");
            System.out.println("2 - spegni");
            System.out.println("3 - apri sportello");
            System.out.println("4 - chiudi sportello");
            System.out.println("5 - aggiungi detersivo");
            System.out.println("6 - imposta temperatura");
            System.out.println("7 - avvia lavaggio");
            System.out.println("8 - esci\n");
            System.out.print("Inserisci la tua scelta: ");
            scelta = sc.nextLine();

            switch (scelta) {
                case "1":
                    lav.accendi();
                    break;
                case "2":
                    lav.spegni();
                    break;
                case "3":
                    lav.apriSportello();
                    break;
                case "4":
                    lav.chiudiSportello();
                    break;
                case "5":
                    lav.aggiungiDetersivo();
                    break;
                case "6":
                    System.out.print("Inserisci la temperatura: ");
                    int temperatura = sc.nextInt();
                    sc.nextLine();
                    lav.impostaTemperatura(temperatura);
                    break;
                case "7":
                    temperatura = lav.getTemperatura();

                    lav.avviaLavaggio();

                    try {
                        System.out.println("Lavaggio in corso a " + temperatura + "°C");
                        Thread.sleep(3000);
                        lav.avviaLavaggio();
                        System.out.println("\nLavaggio terminato!");

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
                case "8":
                    System.out.println("Grazie per aver usato la lavatrice virtuale,arrivederci e buona giornata!");
                    break;
                default:
                    System.out.println("Scelta non valida");
                    break;
            }

        } while (!scelta.equals("8"));

        sc.close();
    }
}
