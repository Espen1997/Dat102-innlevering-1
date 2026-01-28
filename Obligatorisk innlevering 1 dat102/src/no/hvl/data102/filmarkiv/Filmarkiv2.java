package no.hvl.data102.filmarkiv;

public class LinearNode<T> {
        public T data;
        public LinearNode<T> neste;

        public LinearNode(T data) {
            this.data = data;
            this.neste = null;
        }
    }
public class Filmarkiv2 implements FilmarkivADT {

    private int antall;
    private LinearNode<Film> start;

    public Filmarkiv2() {
        antall = 0;
        start = null;
    }

    @Override
    public void leggTilFilm(Film film) {
        LinearNode<Film> ny = new LinearNode<>(film);
        ny.neste = start;
        start = ny;
        antall++;
    }

    @Override
    public Film finnFilm(int filmnr) {
        LinearNode<Film> current = start;

        while (current != null) {
            if (current.data.getFilmnr() == filmnr) {
                return current.data;
            }
            current = current.neste;
        }
        return null;
    }

    @Override
    public boolean slettFilm(int filmnr) {
        LinearNode<Film> current = start;
        LinearNode<Film> previous = null;

        while (current != null) {
            if (current.data.getFilmnr() == filmnr) {
                if (previous == null) {
                    // sletter første node
                    start = current.neste;
                } else {
                    previous.neste = current.neste;
                }
                antall--;
                return true;
            }
            previous = current;
            current = current.neste;
        }
        return false;
    }

    @Override
    public Film[] soekTittel(String delstreng) {
        Film[] treff = new Film[antall];
        int count = 0;

        LinearNode<Film> current = start;
        while (current != null) {
            if (current.data.getTittel().toLowerCase()
                    .contains(delstreng.toLowerCase())) {
                treff[count++] = current.data;
            }
            current = current.neste;
        }

        return java.util.Arrays.copyOf(treff, count);
    }

    @Override
    public Film[] soekProdusent(String produsent) {
        Film[] treff = new Film[antall];
        int count = 0;

        LinearNode<Film> current = start;
        while (current != null) {
            if (current.data.getProdusent()
                    .equalsIgnoreCase(produsent)) {
                treff[count++] = current.data;
            }
            current = current.neste;
        }

        return java.util.Arrays.copyOf(treff, count);
    }

    @Override
    public int antall() {
        return antall;
    }
}

