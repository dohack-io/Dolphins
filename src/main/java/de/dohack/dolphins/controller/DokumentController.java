package de.dohack.dolphins.controller;

import de.dohack.dolphins.repo.DokumentRepository;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

  @PostMapping("/dokument/erstellen")
  public String create(@RequestBody HttpServletRequest request) {
    //    repository.save(new Customer(customer.getFirstName(), customer.getLastName()));

    String titel = request.getParameter("Dokumententitel");
    System.out.println(titel);
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
