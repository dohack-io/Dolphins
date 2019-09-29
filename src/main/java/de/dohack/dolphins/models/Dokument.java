package de.dohack.dolphins.models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
public class Dokument implements Serializable {

  @Id @GeneratedValue private int drucksachennr;

  private String titel;

  private String beschreibung;

  private String dateipfad;

  @Temporal(value = TemporalType.TIMESTAMP)
  private Date erstellDatum;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "autor", referencedColumnName = "anzeigename")
  private Benutzer autor;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "gremium", referencedColumnName = "name")
  private Gremium gremium;

  public int getDrucksachennr() {
    return drucksachennr;
  }

  public void setDrucksachennr(int drucksachenNr) {
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

  public Gremium getGremium() {
    return gremium;
  }

  public void setGremium(Gremium gremium) {
    this.gremium = gremium;
  }
}
