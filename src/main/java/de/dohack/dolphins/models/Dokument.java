package de.dohack.dolphins.models;

import java.util.Date;
import java.util.Set;
import javax.persistence.*;

@Entity
public class Dokument {

  @Id private String drucksachenNr;

  private String titel;

  private String beschreibung;

  private Set<Tag> tags;

  private String inhalt;

  @Temporal(value = TemporalType.TIMESTAMP)
  private Date erstellDatum;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "anzeigeName")
  private User autor;

  public String getDrucksachenNr() {
    return drucksachenNr;
  }

  public void setDrucksachenNr(String drucksachenNr) {
    this.drucksachenNr = drucksachenNr;
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

  public Set<Tag> getTags() {
    return tags;
  }

  public void setTags(Set<Tag> tags) {
    this.tags = tags;
  }

  public String getInhalt() {
    return inhalt;
  }

  public void setInhalt(String inhalt) {
    this.inhalt = inhalt;
  }

  public Date getErstellDatum() {
    return erstellDatum;
  }

  public void setErstellDatum(Date erstellDatum) {
    this.erstellDatum = erstellDatum;
  }

  public User getAutor() {
    return autor;
  }

  public void setAutor(User autor) {
    this.autor = autor;
  }
}
