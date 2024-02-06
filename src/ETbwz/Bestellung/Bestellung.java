package ETbwz.Bestellung;

import java.time.LocalDate;

public class Bestellung {

    private int bestellnummer;
    private LocalDate bestelldatum;
    private double total;


    public Bestellung() {

    }

    public Bestellung(int bestellnummer, LocalDate bestelldatum, double total) {

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
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
