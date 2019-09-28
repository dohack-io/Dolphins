package de.dohack.dolphins.repo;

import de.dohack.dolphins.models.Dokument;
import de.dohack.dolphins.models.Kommentar;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

@Repository
public interface KommentarRepository extends CrudRepository<Kommentar, String> {

  @Nullable
  List<Kommentar> findByDokument(@Nullable Dokument dokument);
}
