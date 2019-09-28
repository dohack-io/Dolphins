package de.dohack.dolphins.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {

  @Id private String anzeigeName;

  private String realName;

  private String passwort;

  private String eMail;

  private Boolean admin;

  public String getAnzeigeName() {
    return anzeigeName;
  }

  public void setAnzeigeName(String anzeigeName) {
    this.anzeigeName = anzeigeName;
  }

  public String getRealName() {
    return realName;
  }

  public void setRealName(String realName) {
    this.realName = realName;
  }

  public String getPasswort() {
    return passwort;
  }

  public void setPasswort(String passwort) {
    this.passwort = passwort;
  }

  public String geteMail() {
    return eMail;
  }

  public void seteMail(String eMail) {
    this.eMail = eMail;
  }

  public Boolean getAdmin() {
    return admin;
  }

  public void setAdmin(Boolean admin) {
    this.admin = admin;
  }
}
