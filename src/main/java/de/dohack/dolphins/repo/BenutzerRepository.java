package de.dohack.dolphins.repo;

import de.dohack.dolphins.models.Benutzer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BenutzerRepository extends CrudRepository<Benutzer, String> {}
