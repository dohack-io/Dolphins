package de.dohack.dolphins;

import de.dohack.dolphins.controller.DatabaseController;
import de.dohack.dolphins.models.Benutzer;

public class Main {

  public static void main(String[] args) {
    DatabaseController dbController = new DatabaseController();
    dbController.find(Benutzer.class, "DolphinAdmin");
    dbController.shutdown();
  }
}
