package de.dohack.dolphins.controller;

import de.dohack.dolphins.models.Dokument;
import de.dohack.dolphins.models.Gremium;
import de.dohack.dolphins.repo.DokumentRepository;
import de.dohack.dolphins.repo.GremiumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.Optional;

@CrossOrigin()
@RestController
public class DokumentController {

  private static final String localPath = "/home/river/Dokumente/Arbeit/Dolphins/Dokumente/";

  @Autowired private DokumentRepository repository;
  @Autowired private GremiumRepository gremiumRepository;

//  @RequestMapping(
//      value = "/dokument/finde/{drucksachenNr}",
//      method = RequestMethod.GET,
//      produces = "multipart/form-data")
//  public MultipartFile search(@PathVariable int drucksachenNr) {
//    Optional<Dokument> dokument = repository.findById(drucksachenNr);
//    File file = new File("src/test/resources/input.txt");
//    FileInputStream input = null;
//    try {
//      input = new FileInputStream(file);
//    } catch (FileNotFoundException e) {
//      e.printStackTrace();
//    }
//    MultipartFile multipartFile = new MockMultipartFile("file",
//            file.getName(), "text/plain", IOUtils.toByteArray(input));
//    return repository.findById(drucksachenNr).get();
//  }

  @RequestMapping(
      value = "/dokument/erstellen",
      method = RequestMethod.POST,
      consumes = {"multipart/form-data"})
  public String create(
      @RequestParam("File") MultipartFile multipartFile,
      @RequestParam("Dokumenttitel") String titel,
      @RequestParam("Gremium") String gremienName,
      @RequestParam("Kurzbeschreibung") String kurzBeschr,
      @RequestParam("Tags") String tags) {
    String dateipfad = localPath + titel.trim();
    Dokument dokument = new Dokument();
    Optional<Gremium> optGremium = gremiumRepository.findById(gremienName);
    Gremium gremium;
    if (optGremium.isPresent()) {
      gremium = optGremium.get();
    } else {
      gremium = gremiumRepository.save(new Gremium(gremienName));
    }
    dokument.setTitel(titel);
    dokument.setAutor(null);
    dokument.setBeschreibung(kurzBeschr);
    dokument.setErstellDatum(Calendar.getInstance().getTime());
    dokument.setGremium(gremium);
    try {
      multipartFile.transferTo(Paths.get(dateipfad));
      System.out.println(multipartFile.getContentType());
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
