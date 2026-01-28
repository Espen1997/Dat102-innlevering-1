package no.hvl.data102.filmarkiv;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FilmarkivTest {

    private Filmarkiv arkiv;
    private Film film1;
    private Film film2;
    private Film film3;

    @BeforeEach
    public void setup() {
        arkiv = new Filmarkiv(2);

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
        assertTrue(arkiv.leggTilFilm(film1));
        assertEquals(1, arkiv.antall());
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
        assertEquals("Interstellar", funnet.getTittel());
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
    public void testSokTittel() {
        arkiv.leggTilFilm(film1);
        arkiv.leggTilFilm(film2);
        arkiv.leggTilFilm(film3);

        Film[] resultat = arkiv.sokTittel("inter");

        assertEquals(1, resultat.length);
        assertEquals("Interstellar", resultat[0].getTittel());
    }

    @Test
    public void testSokProdusent() {
        arkiv.leggTilFilm(film1);
        arkiv.leggTilFilm(film2);
        arkiv.leggTilFilm(film3);

        Film[] resultat = arkiv.sokProdusent("nolan");

        assertEquals(2, resultat.length);
    }

    @Test
    public void testTrimmetTabell() {
        arkiv.leggTilFilm(film1);
        arkiv.leggTilFilm(film2);

        Film[] resultat = arkiv.sokProdusent("nolan");

        // Ingen null-verdier tillatt
        for (Film f : resultat) {
            assertNotNull(f);
        }
    }
}
