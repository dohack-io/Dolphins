package de.dohack.dolphins.controller;

import de.dohack.dolphins.models.Dokument;
import de.dohack.dolphins.repo.KommentarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class KommentarController {

  @Autowired private KommentarRepository repository;

  @RequestMapping("/kommentar/finde/{drucksachenNr}")
  public String search(@PathVariable int drucksachenNr) {
    Dokument dokument = new Dokument();
    dokument.setDrucksachennr(drucksachenNr);

    String kommentar = repository.findByDokument(dokument).toString();
    return kommentar;
  }

  @PostMapping("/kommentar/erstellen")
  public String create(@RequestBody String string) {

    System.out.println(string);
    return "Kommentar is created";
  }
}
