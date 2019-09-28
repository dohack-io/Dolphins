package de.dohack.dolphins.controller;

import de.dohack.dolphins.models.Benutzer;
import de.dohack.dolphins.repo.BenutzerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

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
      consumes = {"multipart/form-data"})
  public String create(
      @RequestParam("File") MultipartFile multipartFile,
      @RequestParam("Dokumenttitel") String titel,
      @RequestParam("Realname") String realname,
      @RequestParam("Anzeigename") String anzeigename,
      @RequestParam("Email") String email,
      @RequestParam("Passwort") String passwort, 
      @RequestParam("Administrator") String adminstrator){
    String dateipfad = localPath + titel.trim();
    Benutzer benutzer = new Benutzer();
    benutzer.setPasswort(passwort);
    benutzer.setAnzeigename(anzeigename);
    benutzer.setEmail(email);
    benutzer.setAdministrator(adminstrator);
    benutzer.setRealname(realname);
    try {
      multipartFile.transferTo(Paths.get(dateipfad));
      benutzer.setDateipfad(dateipfad);
    } catch (IOException e) {
      e.printStackTrace();
    }
    benutzer = repository.save(benutzer);

    // TODO Tags hinzufügen

    return "Benutzer " + benutzer.getDrucksachennr() + " wurde erstellt";
  }

  @GetMapping("/benutzer/hallo")
  public String benutzer() {
    return "Hallo";
  }
}
