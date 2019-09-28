package de.dohack.dolphins.repo;

import de.dohack.dolphins.models.Dokument;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DokumentRepository extends CrudRepository<Dokument, String> {}
