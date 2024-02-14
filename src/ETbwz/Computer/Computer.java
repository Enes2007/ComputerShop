package ETbwz.Computer;

public class Computer {

    private String hersteller;
    private String modell;
    private double arbeitsspeicher;
    private String cpu;
    private double massenspeicher;
    private String typ;
    private double einzelpreis;

    private String altModell;

    public Computer() {

    }

    public Computer(String hersteller, String modell, double arbeitsspeicher, String cpu, double massenspeicher, String typ, double einzelpreis) {
        this.hersteller = hersteller;
        this.modell = modell;
        this.arbeitsspeicher = arbeitsspeicher;
        this.cpu = cpu;
        this.massenspeicher = massenspeicher;
        this.typ = typ;
        this.einzelpreis = einzelpreis;
    }


    public String getHersteller() {
        return hersteller;
    }

    public void setHersteller(String hersteller) {
        this.hersteller = hersteller;
    }

    public String getModell() {
        return modell;
    }

    public void setModell(String modell) {
        this.modell = modell;
    }

    public double getArbeitsspeicher() {
        return arbeitsspeicher;
    }

    public void setArbeitsspeicher(double arbeitsspeicher) {
        this.arbeitsspeicher = arbeitsspeicher;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public double getMassenspeicher() {
        return massenspeicher;
    }

    public void setMassenspeicher(double massenspeicher) {
        this.massenspeicher = massenspeicher;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public double getEinzelpreis() {
        return einzelpreis;
    }

    public void setEinzelpreis(double einzelpreis) {
        this.einzelpreis = einzelpreis;
    }

    public String getAltModell() { return altModell; }
    public void setAltModell(String altModell) {
        this.altModell = altModell;
    }

}
