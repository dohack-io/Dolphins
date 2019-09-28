package de.dohack.dolphins.controller;

import de.dohack.dolphins.models.Dokument;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin
public class DokumentController {

    private DatabaseController dbController = new DatabaseController();

    @PostMapping("/dokument-senden")
    public HttpStatus empfangeDokument(@RequestBody Dokument dokument){
        return dbController.persist(dokument) ? HttpStatus.OK : HttpStatus.NOT_ACCEPTABLE;
    }

}
