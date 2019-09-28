package de.dohack.dolphins.controller;

import de.dohack.dolphins.repo.BenutzerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@Controller
public class BenutzerController {

  @Autowired BenutzerRepository repository;
}
