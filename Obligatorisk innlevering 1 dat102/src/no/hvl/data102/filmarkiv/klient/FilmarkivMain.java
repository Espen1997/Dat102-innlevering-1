package no.hvl.data102.filmarkiv.klient;

import no.hvl.data102.filmarkiv.impl.Filmarkiv;

public class FilmarkivMain {
    public static <FilmarkivADT> void main(String[] args) {
        Filmarkiv filmarkiv = new Filmarkiv(100);
        Meny meny = new Meny(filmarkiv);
        meny.start();
    }
}
