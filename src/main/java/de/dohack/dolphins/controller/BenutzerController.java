package de.dohack.dolphins.controller;

import de.dohack.dolphins.models.Benutzer;
import de.dohack.dolphins.repo.BenutzerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@Controller
public class BenutzerController {

  @Autowired BenutzerRepository repository;

  @RequestMapping("/benutzer/finde/{drucksachenNr}")
  public String search(@PathVariable String drucksachenNr) {
    String benutzer = "";
    benutzer = repository.findById(drucksachenNr).toString();
    return benutzer;
  }

  @RequestMapping(
      value = "/benutzer/erstellen",
      method = RequestMethod.POST,
      consumes = "application/x-www-form-urlencoded")
  public String create(
      @RequestParam("geschl") String geschlecht,
      @RequestParam("Vorname") String vorname,
      @RequestParam("Nachname") String nachname,
      @RequestParam("Strasse") String strasse,
      @RequestParam("PLZ") int plz,
      @RequestParam("Ort") String ort,
      @RequestParam("Benutzername") String anzeigename,
      @RequestParam("Email") String email,
      @RequestParam("Passwort") String passwort) {
    Benutzer benutzer = new Benutzer();
    benutzer.setAnzeigename(anzeigename);
    benutzer.setPasswort(passwort);
    benutzer.setVorname(vorname);
    benutzer.setNachname(nachname);
    benutzer.setEmail(email);
    benutzer.setAdminstrator(false);
    benutzer.setGeschlecht(geschlecht + "");
    benutzer.setStrasse(strasse);
    benutzer.setPlz(plz);
    benutzer.setOrt(ort);
    if (anzeigename != null) benutzer = repository.save(benutzer);

    return "Benutzer " + benutzer.getAnzeigename() + " wurde erstellt";
  }
}
