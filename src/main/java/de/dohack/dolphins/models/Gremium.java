package de.dohack.dolphins.models;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Entity
public class Gremium {

  @Enumerated(EnumType.STRING)
  private GremienKategorie kategorie;

  @Id private String name;

  public GremienKategorie getKategorie() {
    return kategorie;
  }

  public void setKategorie(GremienKategorie kategorie) {
    this.kategorie = kategorie;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
