package no.hvl.data102.filmarkiv.no.hvl.data102.filmarkiv.test;

import static org.junit.jupiter.api.Assertions.*;
import no.hvl.data102.filmarkiv.impl.Film;
import no.hvl.data102.filmarkiv.impl.Filmarkiv2;
import no.hvl.data102.filmarkiv.impl.Sjanger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Filmarkiv2Test {

    private Filmarkiv2 arkiv;
    private Film film1;
    private Film film2;
    private Film film3;

    @BeforeEach
    public void setup() {
        arkiv = new Filmarkiv2(2);

        film1 = new Film(1, "Inception", "Nolan", 2010, Sjanger.ACTION);
        film2 = new Film(2, "Interstellar", "Nolan", 2014, Sjanger.SCI_FI);
        film3 = new Film(3, "Titanic", "Cameron", 1997, Sjanger.DRAMA);
    }

    @Test
    public void testTomtArkiv() {
        assertEquals(0, arkiv.antall());
    }

    @Test
    public void testLeggTilFilm() {
        assertEquals(0, arkiv.antall());
    }

    @Test
    public void testUtvidelseAvTabell() {
        arkiv.leggTilFilm(film1);
        arkiv.leggTilFilm(film2);

        // Denne skal tvinge utvidelse
        arkiv.leggTilFilm(film3);

        assertEquals(3, arkiv.antall());
        assertNotNull(arkiv.finnFilm(3));
    }

    @Test
    public void testFinnFilm() {
        arkiv.leggTilFilm(film1);
        arkiv.leggTilFilm(film2);

        Film funnet = arkiv.finnFilm(2);
        assertNotNull(funnet);
        assertEquals("Nolan", funnet.getTittel());
    }

    @Test
    public void testFinnFilmSomIkkeFinnes() {
        assertNull(arkiv.finnFilm(99));
    }

    @Test
    public void testSlettFilm() {
        arkiv.leggTilFilm(film1);
        arkiv.leggTilFilm(film2);

        assertTrue(arkiv.slettFilm(1));
        assertEquals(1, arkiv.antall());
        assertNull(arkiv.finnFilm(1));
    }

    @Test
    public void testSlettFilmSomIkkeFinnes() {
        assertFalse(arkiv.slettFilm(42));
    }

    @Test
    public void testSoekTittel() {
        arkiv.leggTilFilm(film1);
        arkiv.leggTilFilm(film2);
        arkiv.leggTilFilm(film3);

        Film[] resultat = arkiv.soekTittel("Nolan");

        assertEquals("Nolan", resultat[1].getTittel());
    }

    @Test
    public void testSoekProdusent() {
        arkiv.leggTilFilm(film1);
        arkiv.leggTilFilm(film2);
        arkiv.leggTilFilm(film3);

        Film[] resultat = arkiv.soekProdusent("nolan");

        assertEquals(0, resultat.length);
    }

    @Test
    public void testTrimmetTabell() {
        arkiv.leggTilFilm(film1);
        arkiv.leggTilFilm(film2);

        Film[] resultat = arkiv.soekProdusent("nolan");

        // Ingen null-verdier tillatt
        for (Film f : resultat) {
            assertNotNull(f);
        }
    }
}
