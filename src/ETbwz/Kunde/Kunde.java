package ETbwz.Kunde;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Kunde {
    private String gender;
    private String nachname;
    private String vorname;
    private String telefon;
    private String email;
    private String sprache;
    private LocalDate geburtsdatum;
    private Adresse adresse;


    public Kunde() {

    }


    public Kunde(String gender, String nachname, String vorname, String telefon, String email, String sprache, LocalDate geburtsdatum, Adresse adresse) {
        this.gender = gender;
        this.nachname = nachname;
        this.vorname = vorname;
        this.telefon = telefon;
        this.email = email;
        this.sprache = sprache;
        this.geburtsdatum = geburtsdatum;
        this.adresse = adresse;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSprache() {
        return sprache;
    }

    public void setSprache(String sprache) {
        this.sprache = sprache;
    }

    public LocalDate getGeburtsdatum() {
        return geburtsdatum;
    }

    public void setGeburtsdatum(String geburtsdatum) {
        this.geburtsdatum = LocalDate.parse(geburtsdatum, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }
}
