package de.dohack.dolphins.models;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Benutzer implements Serializable {

  @Id private String anzeigename;

  private String vorname;

  private String nachname;

  private String geschlecht;

  private String strasse;

  private String ort;

  private int plz;

  private String passwort;

  private String email;

  private Boolean adminstrator;

  public String getAnzeigename() {
    return anzeigename;
  }

  public void setAnzeigename(String anzeigename) {
    this.anzeigename = anzeigename;
  }

  public String getVorname() {
    return vorname;
  }

  public void setVorname(String vorname) {
    this.vorname = vorname;
  }

  public String getNachname() {
    return nachname;
  }

  public void setNachname(String nachname) {
    this.nachname = nachname;
  }

  public String getGeschlecht() {
    return geschlecht;
  }

  public void setGeschlecht(String geschlecht) {
    this.geschlecht = geschlecht;
  }

  public String getStrasse() {
    return strasse;
  }

  public void setStrasse(String strasse) {
    this.strasse = strasse;
  }

  public String getOrt() {
    return ort;
  }

  public void setOrt(String ort) {
    this.ort = ort;
  }

  public int getPlz() {
    return plz;
  }

  public void setPlz(int plz) {
    this.plz = plz;
  }

  public String getPasswort() {
    return passwort;
  }

  public void setPasswort(String passwort) {
    this.passwort = passwort;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Boolean getAdminstrator() {
    return adminstrator;
  }

  public void setAdminstrator(Boolean adminstrator) {
    this.adminstrator = adminstrator;
  }
}
