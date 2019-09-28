package de.dohack.dolphins.models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
public class Kommentar implements Serializable {

  @Id private int kommentarID;

  private String inhalt;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "dokument", referencedColumnName = "drucksachenNr")
  private Dokument dokument;

  @Temporal(value = TemporalType.TIMESTAMP)
  private Date datum;

  @ManyToOne
  @JoinColumn(referencedColumnName = "anzeigeName")
  private Benutzer verfasser;

  public Dokument getDokument() {
    return dokument;
  }

  public void setDokument(Dokument dokument) {
    this.dokument = dokument;
  }

  public int getKommentarID() {
    return kommentarID;
  }

  public void setKommentarID(int kommentarID) {
    this.kommentarID = kommentarID;
  }

  public String getInhalt() {
    return inhalt;
  }

  public void setInhalt(String inhalt) {
    this.inhalt = inhalt;
  }

  public Date getDatum() {
    return datum;
  }

  public void setDatum(Date datum) {
    this.datum = datum;
  }

  public Benutzer getVerfasser() {
    return verfasser;
  }

  public void setVerfasser(Benutzer verfasser) {
    this.verfasser = verfasser;
  }
}
