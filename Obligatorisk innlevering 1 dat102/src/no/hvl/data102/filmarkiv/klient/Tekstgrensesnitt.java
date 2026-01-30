package no.hvl.data102.filmarkiv.klient;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;
import no.hvl.data102.filmarkiv.impl.Film;
import no.hvl.data102.filmarkiv.impl.Sjanger;

import java.util.Scanner;

public class Tekstgrensesnitt {

    private final Scanner scanner = new Scanner(System.in);

    // Leser inn opplysninger om en film fra tastatur og returnerer et Film-objekt
    public Film lesFilm() {
        System.out.print("Filmnummer: ");
        int filmNr = Integer.parseInt(scanner.nextLine());

        System.out.print("Tittel: ");
        String tittel = scanner.nextLine();

        System.out.print("Produsent: ");
        String produsent = scanner.nextLine();

        System.out.print("Lanseringsaar: ");
        int lanseringsaar = Integer.parseInt(scanner.nextLine());

        System.out.println("Sjanger:");
        for (Sjanger s : Sjanger.values()) {
            System.out.println(s.ordinal() + " - " + s);
        }
        System.out.print("Velg sjanger (nummer): ");
        int valg = Integer.parseInt(scanner.nextLine());
        Sjanger sjanger = Sjanger.values()[valg];

        return new Film(filmNr, tittel, produsent, lanseringsaar, sjanger);
    }

    // Skriver ut en film med alle opplysninger
    public void skrivUtFilm(Film film) {
        if (film == null) {
            System.out.println("Ingen film å vise.");
            return;
        }

        System.out.println("Filmnummer: " + film.getFilmnr());
        System.out.println("Tittel: " + film.getTittel());
        System.out.println("Produsent: " + film.getProdusent());
        System.out.println("Lanseringsaar: " + film.getLanseringsaar());
        System.out.println("Sjanger: " + film.getSjanger());
        System.out.println("-------------------------");
    }

    // Skriver ut alle filmer med delstreng i tittelen
    public void skrivUtFilmDelstrengITittel(FilmarkivADT arkiv, String delstreng) {
        Film[] filmer = arkiv.soekTittel(delstreng);
        for (Film film : filmer) {
            skrivUtFilm(film);
        }
    }

    // Skriver ut alle filmer av en produsent (delstreng)
    public void skrivUtFilmProdusent(FilmarkivADT arkiv, String delstreng) {
        Film[] filmer = arkiv.soekProdusent(delstreng);
        for (Film film : filmer) {
            skrivUtFilm(film);
        }
    }

    // Skriver ut statistikk
    public void skrivUtStatistikk(FilmarkivADT arkiv) {
        System.out.println("Antall filmer totalt: " + arkiv.antall());

        for (Sjanger s : Sjanger.values()) {
            System.out.println(s + ": " + arkiv.antall(s));
        }
    }
}

