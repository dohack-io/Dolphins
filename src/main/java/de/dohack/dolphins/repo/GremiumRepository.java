package de.dohack.dolphins.repo;

import de.dohack.dolphins.models.Gremium;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GremiumRepository extends CrudRepository<Gremium, String> {}
