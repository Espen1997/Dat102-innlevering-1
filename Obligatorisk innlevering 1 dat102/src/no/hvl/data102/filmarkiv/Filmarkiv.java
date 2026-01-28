package no.hvl.data102.filmarkiv;

public class Filmarkiv implements FilmarkivADT {

    private Film[] filmer;
    private int antall;

    // Konstruktør
    public Filmarkiv(int kapasitet) {
        filmer = new Film[kapasitet];
        antall = 0;
    }

    // Legger til en film
    @Override
    public boolean leggTilFilm(Film film) {
        if (film == null) {
            return false;
        }

        if (antall == filmer.length) {
            utvid();
        }

        filmer[antall] = film;
        antall++;
        return true;
    }

    // Finner film basert på filmnummer
    @Override
    public Film finnFilm(int filmnr) {
        for (int i = 0; i < antall; i++) {
            if (filmer[i].getFilmnr() == filmnr) {
                return filmer[i];
            }
        }
        return null;
    }

    // Sletter film
    @Override
    public boolean slettFilm(int filmnr) {
        for (int i = 0; i < antall; i++) {
            if (filmer[i].getFilmnr() == filmnr) {

                // Flytt elementene mot venstre
                for (int j = i; j < antall - 1; j++) {
                    filmer[j] = filmer[j + 1];
                }

                filmer[antall - 1] = null;
                antall--;
                return true;
            }
        }
        return false;
    }

    // Søker etter filmer med tittel
    @Override
    public Film[] sokTittel(String delstreng) {
        Film[] temp = new Film[antall];
        int treff = 0;

        for (int i = 0; i < antall; i++) {
            if (filmer[i].getTittel().toLowerCase()
                    .contains(delstreng.toLowerCase())) {
                temp[treff++] = filmer[i];
            }
        }

        return trimTabell(temp, treff);
    }

    // Søker etter filmer med produsent
    @Override
    public Film[] sokProdusent(String delstreng) {
        Film[] temp = new Film[antall];
        int treff = 0;

        for (int i = 0; i < antall; i++) {
            if (filmer[i].getProdusent().toLowerCase()
                    .contains(delstreng.toLowerCase())) {
                temp[treff++] = filmer[i];
            }
        }

        return trimTabell(temp, treff);
    }

    // Returnerer antall filmer
    @Override
    public int antall() {
        return antall;
    }

    // ===== Private hjelpemetoder =====

    // Dobler størrelsen på tabellen
    private void utvid() {
        Film[] ny = new Film[filmer.length * 2];
        for (int i = 0; i < antall; i++) {
            ny[i] = filmer[i];
        }
        filmer = ny;
    }

    // Trimmer tabell til riktig størrelse
    private Film[] trimTabell(Film[] tabell, int lengde) {
        Film[] ny = new Film[lengde];
        for (int i = 0; i < lengde; i++) {
            ny[i] = tabell[i];
        }
        return ny;
    }
}
