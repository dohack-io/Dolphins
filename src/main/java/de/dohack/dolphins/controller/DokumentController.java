package de.dohack.dolphins.controller;

import de.dohack.dolphins.repo.DokumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin()
@RestController
public class DokumentController {

  @Autowired private DokumentRepository repository;

  @RequestMapping("/dokument/finde/{drucksachenNr}")
  public String search(@PathVariable String drucksachenNr) {
    String dokument = "";
    dokument = repository.findById(drucksachenNr).toString();
    return dokument;
  }

  //  @PostMapping("/dokument/erstellen")
  @RequestMapping(
      value = "/dokument/erstellen",
      method = RequestMethod.POST,
      consumes = {"multipart/form-data"})
  public String create(@RequestParam("File") MultipartFile multipartFile) {

    //    repository.save(new Customer(customer.getFirstName(), customer.getLastName()));

    //    String titel = request.getParameter("Dokumententitel");
    //    System.out.println(titel);
    System.out.println(multipartFile);
    return "Customer is created";
  }
  //
  //  @PostMapping("/dokument/erstellen")
  //  public String create(@RequestBody String string) {
  //    //    repository.save(new Customer(customer.getFirstName(), customer.getLastName()));
  //
  //    System.out.println(string);
  //    return "Customer is created";
  //  }

  @GetMapping("/dokument/hallo")
  public String dokument() {
    return "Hallo";
  }
}
