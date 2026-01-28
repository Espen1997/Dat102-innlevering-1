package no.hvl.data102.filmarkiv;

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
                Sjanger.SCIFI,
                "Warner Bros"
        ));

        filmarkiv.leggTilFilm(new Film(
                2,
                "The Godfather",
                "Francis Ford Coppola",
                1972,
                Sjanger.DRAMA,
                "Paramount Pictures"
        ));

        filmarkiv.leggTilFilm(new Film(
                3,
                "Parasite",
                "Bong Joon-ho",
                2019,
                Sjanger.THILLER,
                "CJ Entertainment"
        ));
    }
}
