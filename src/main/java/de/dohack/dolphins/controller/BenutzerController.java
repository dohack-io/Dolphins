package de.dohack.dolphins.controller;

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

  @PostMapping("/benutzer/erstellen")
  public String create(@RequestBody String string) {
    System.out.println(string);
    return "Benutzer wurde erstellt";
  }
}
