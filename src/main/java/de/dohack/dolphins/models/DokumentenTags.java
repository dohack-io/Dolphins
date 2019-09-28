package de.dohack.dolphins.models;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class DokumentenTags implements Serializable {

  @Id @GeneratedValue private int id;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Dokument getDokument() {
    return dokument;
  }

  public void setDokument(Dokument dokument) {
    this.dokument = dokument;
  }

  public Tag getTag() {
    return tag;
  }

  public void setTag(Tag tag) {
    this.tag = tag;
  }

  @ManyToOne
  @JoinColumn(referencedColumnName = "drucksachennr")
  private Dokument dokument;

  @ManyToOne
  @JoinColumn(referencedColumnName = "name")
  private Tag tag;
}
