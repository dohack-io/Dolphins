package de.dohack.dolphins.models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
public class Dokument implements Serializable {

  @Id private String drucksachennr;

  private String titel;

  private String beschreibung;

  private String dateipfad;

  @Temporal(value = TemporalType.TIMESTAMP)
  private Date erstellDatum;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "autor", referencedColumnName = "anzeigename")
  private Benutzer autor;

  public String getDrucksachennr() {
    return drucksachennr;
  }

  public void setDrucksachennr(String drucksachenNr) {
    this.drucksachennr = drucksachenNr;
  }

  public String getTitel() {
    return titel;
  }

  public void setTitel(String titel) {
    this.titel = titel;
  }

  public String getBeschreibung() {
    return beschreibung;
  }

  public void setBeschreibung(String beschreibung) {
    this.beschreibung = beschreibung;
  }

  public String getDateipfad() {
    return dateipfad;
  }

  public void setDateipfad(String inhalt) {
    this.dateipfad = inhalt;
  }

  public Date getErstellDatum() {
    return erstellDatum;
  }

  public void setErstellDatum(Date erstellDatum) {
    this.erstellDatum = erstellDatum;
  }

  public Benutzer getAutor() {
    return autor;
  }

  public void setAutor(Benutzer autor) {
    this.autor = autor;
  }
}
