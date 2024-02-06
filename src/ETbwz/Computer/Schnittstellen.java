package ETbwz.Computer;

public class Schnittstellen {

    private String hdmi;
    private String lan;
    private String mikrofon;
    private String speaker;
    private String usba;
    private String usbc;

    public Schnittstellen() {

    }

    public Schnittstellen(String hdmi, String lan, String mikrofon, String speaker, String usba, String usbc) {

    }


    public String getHdmi() {
        return hdmi;
    }

    public void setHdmi(String hdmi) {
        this.hdmi = hdmi;
    }

    public String getLan() {
        return lan;
    }

    public void setLan(String lan) {
        this.lan = lan;
    }

    public String getMikrofon() {
        return mikrofon;
    }

    public void setMikrofon(String mikrofon) {
        this.mikrofon = mikrofon;
    }

    public String getSpeaker() {
        return speaker;
    }

    public void setSpeaker(String speaker) {
        this.speaker = speaker;
    }

    public String getUsba() {
        return usba;
    }

    public void setUsba(String usba) {
        this.usba = usba;
    }

    public String getUsbc() {
        return usbc;
    }

    public void setUsbc(String usbc) {
        this.usbc = usbc;
    }
}
