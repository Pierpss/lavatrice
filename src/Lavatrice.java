public class Lavatrice {

    private boolean sportelloChiuso;
    private Stato stato;
    private boolean detersivoPresente;
    private int temperatura;

    public Lavatrice() {
        sportelloChiuso = true;
        stato = Stato.SPENTO;
        detersivoPresente = false;
        temperatura = 20;
    }

    public void accendi() {
        if (stato != Stato.SPENTO)
            System.out.println("Lavatrice già accesa");
        else
            stato = Stato.STANDBY;
    }

    public void spegni() {
        if (stato == Stato.SPENTO)
            System.out.println("Lavatrice già spenta");
        else
            stato = Stato.SPENTO;
    }

    public void apriSportello() {
        if (sportelloChiuso == false)
            System.out.println("Sportello già aperto");
        else if (stato == Stato.LAVAGGIO_IN_CORSO)
            System.out.println("Impossibile aprire lo sportello. Lavaggio in corso");
        else
            sportelloChiuso = false;
    }

    public void chiudiSportello() {
        if (sportelloChiuso == true)
            System.out.println("Sportello già chiuso");
        else
            sportelloChiuso = true;
    }

    public void aggiungiDetersivo() {
        if (detersivoPresente == true)
            System.out.println("Detersivo già presente");
        else
            detersivoPresente = true;
    }

    public void impostaTemperatura(int temperatura) {

        if (stato == Stato.STANDBY) {
            if (temperatura >= 20 && temperatura <= 90)
                this.temperatura = temperatura;
            else
                System.out.println("Temperatura non valida");
        } else
            System.out.println("Impossibile impostare la temperatura");
    }

    public void avviaLavaggio() {
        if (stato == Stato.STANDBY)
            if (detersivoPresente)
                if (sportelloChiuso) {

                } else
                    System.out.println("Impossibile avviare il lavaggio: Sportello aperto");
            else
                System.out.println("Impossibile avviare il lavaggio: Detersivo non presente");
    }

    public boolean isSportelloChiuso() {
        return sportelloChiuso;
    }

    public Stato getStato() {
        return stato;
    }

    public boolean isDetersivoPresente() {
        return detersivoPresente;
    }

    public int getTemperatura() {
        return temperatura;
    }

    @Override
    public String toString() {
        return "Sportello: " + (sportelloChiuso ? "Chiuso" : "Aperto") + ", stato: " + stato
                + ", detersivo: " + (detersivoPresente ? "Inserito" : "Non inserito") + ", temperatura: " + temperatura;
    }

}
