package de.dohack.dolphins.repo;

import de.dohack.dolphins.models.Tag;
import org.springframework.data.repository.CrudRepository;

public interface TagRepository extends CrudRepository<Tag, String> {}
