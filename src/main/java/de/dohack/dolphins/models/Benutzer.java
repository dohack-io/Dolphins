package de.dohack.dolphins.models;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Benutzer implements Serializable {

  @Id private String anzeigename;

  private String realname;

  private String passwort;

  private String email;

  private Boolean adminstrator;

  public String getAnzeigeName() {
    return anzeigename;
  }

  public void setAnzeigeName(String anzeigeName) {
    this.anzeigename = anzeigeName;
  }

  public String getRealname() {
    return realname;
  }

  public void setRealname(String realName) {
    this.realname = realName;
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

  public void setAdminstrator(Boolean admin) {
    this.adminstrator = admin;
  }
}
