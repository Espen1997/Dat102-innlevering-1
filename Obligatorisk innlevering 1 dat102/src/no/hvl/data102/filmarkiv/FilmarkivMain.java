package no.hvl.data102.filmarkiv;

public class FilmarkivMain {
    public static <FilmarkivADT> void main(String[] args) {
        FilmarkivADT film;
        film = new FilmarkivADT(100);
        Meny meny = new Meny(film);
        meny.start();
    }
}
