package ETbwz.Bestellung;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Bestellung {

    private int bestellnummer;
    private LocalDate bestelldatum;
    private Bestellposition bestellposition;

    private List<Bestellposition> bestellpositionen;


    public Bestellung() {
        this.bestellpositionen = new ArrayList<>();
    }


    public Bestellung(int bestellnummer, LocalDate bestelldatum, Bestellposition bestellposition) {
        this.bestellnummer = bestellnummer;
        this.bestelldatum = bestelldatum;
        this.bestellposition = bestellposition;
    }


    public int getBestellnummer() {
        return bestellnummer;
    }

    public void setBestellnummer(int bestellnummer) {
        this.bestellnummer = bestellnummer;
    }

    public LocalDate getBestelldatum() {
        return bestelldatum;
    }

    public void setBestelldatum(LocalDate bestelldatum) {
        this.bestelldatum = bestelldatum;
    }

    public double getTotal() {
        double total = 0;

        for (Bestellposition bestellposition:
             bestellpositionen) {
            double netto = bestellposition.getPreis() * bestellposition.getPieces();
            total += netto;
        }
        return total;
    }

    public Bestellposition getBestellposition() {
        return bestellposition;
    }

    public void setBestellposition(Bestellposition bestellposition) {
        this.bestellposition = bestellposition;
    }

    public List<Bestellposition> getBestellpositionen() {
        return bestellpositionen;
    }

    public void setBestellpositionen(List<Bestellposition> bestellpositionen) {
        this.bestellpositionen = bestellpositionen;
    }

}
