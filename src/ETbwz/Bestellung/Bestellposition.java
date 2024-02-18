package ETbwz.Bestellung;

public class Bestellposition {

    private double preis;
    private int pieces;

    public Bestellposition() {

    }

    public Bestellposition(double preis, int pieces) {
        this.preis = preis;
        this.pieces = pieces;
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
