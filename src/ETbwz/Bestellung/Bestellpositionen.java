package ETbwz.Bestellung;

public class Bestellpositionen {

    private double preis;
    private int pieces;


    public Bestellpositionen() {

    }

    public Bestellpositionen(double preis, int pieces) {

    }

    public double getPreis() {
        return preis;
    }

    public void setPreis(double preis) {
        this.preis = preis;
    }

    public int getPieces() {
        return pieces;
    }

    public void setPieces(int pieces) {
        this.pieces = pieces;
    }
}
