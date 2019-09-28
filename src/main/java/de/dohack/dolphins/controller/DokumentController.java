package de.dohack.dolphins.controller;

import de.dohack.dolphins.repo.DokumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class DokumentController {

  @Autowired private DokumentRepository repository;

  @RequestMapping("/dokument/finde/{id}")
  public String search(@PathVariable String id) {
    String dokument = "";
    dokument = repository.findById(id).toString();
    return dokument;
  }

  @PostMapping("/dokument/erstellen")
  public String create(@RequestBody String string) {

    // save a single Customer

    //    repository.save(new Customer(customer.getFirstName(), customer.getLastName()));

    System.out.println("MIAMIAMIA " + string);
    return "Customer is created";
  }

  @GetMapping("/dokument/hallo")
  public String dokument() {
    return "Hallo";
  }
}
