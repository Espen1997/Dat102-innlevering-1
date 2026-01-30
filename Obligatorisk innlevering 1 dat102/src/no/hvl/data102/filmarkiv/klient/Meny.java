package no.hvl.data102.filmarkiv.klient;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;
import no.hvl.data102.filmarkiv.impl.Film;
import no.hvl.data102.filmarkiv.impl.Sjanger;

public class Meny {
    private Tekstgrensesnitt tekstgr;
    private FilmarkivADT filmarkiv;
    public Meny(FilmarkivADT filmarkiv){
        tekstgr = new Tekstgrensesnitt();
        this.filmarkiv = filmarkiv;
    }
    public void start() {
        // Forhåndsdefinerte filmer (testdata)
        filmarkiv.leggTilFilm(new Film(
                1,
                "Inception",
                "Christopher Nolan",
                2010,
                Sjanger.SCI_FI
        ));

        filmarkiv.leggTilFilm(new Film(
                2,
                "The Godfather",
                "Francis Ford Coppola",
                1972,
                Sjanger.DRAMA
        ));

        filmarkiv.leggTilFilm(new Film(
                3,
                "Parasite",
                "Bong Joon-ho",
                2019,
                Sjanger.THRILLER
        ));
    }
}
