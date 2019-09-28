package de.dohack.dolphins.controller;

import de.dohack.dolphins.models.Dokument;
import de.dohack.dolphins.repo.DokumentRepository;
import java.io.IOException;
import java.nio.file.Paths;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin()
@RestController
public class DokumentController {

  private static final String localPath = "/home/river/Dokumente/Arbeit/Dolphins/Dokumente/";

  @Autowired private DokumentRepository repository;

  @RequestMapping("/dokument/finde/{drucksachenNr}")
  public String search(@PathVariable String drucksachenNr) {
    String dokument = "";
    dokument = repository.findById(drucksachenNr).toString();
    return dokument;
  }

  @RequestMapping(
      value = "/dokument/erstellen",
      method = RequestMethod.POST,
      consumes = {"multipart/form-data"})
  public String create(
      @RequestParam("File") MultipartFile multipartFile,
      @RequestParam("Dokumenttitel") String titel,
      @RequestParam("Gremium") String gremium,
      @RequestParam("Kurzbeschreibung") String kurzBeschr,
      @RequestParam("Tags") String tags) {
    String dateipfad = localPath + titel.trim();
    Dokument dokument = new Dokument();
    dokument.setAutor(null);
    dokument.setBeschreibung(kurzBeschr);
    try {
      multipartFile.transferTo(Paths.get(dateipfad));
      dokument.setDateipfad(dateipfad);
    } catch (IOException e) {
      e.printStackTrace();
    }
    dokument = repository.save(dokument);

    // TODO Tags hinzufügen

    return "Dokument " + dokument.getDrucksachennr() + " wurde erstellt";
  }

  @GetMapping("/dokument/hallo")
  public String dokument() {
    return "Hallo";
  }
}
