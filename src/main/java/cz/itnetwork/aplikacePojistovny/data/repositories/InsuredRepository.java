package cz.itnetwork.aplikacePojistovny.data.repositories;

import cz.itnetwork.aplikacePojistovny.data.entities.InsuredEntity;
import org.springframework.data.repository.CrudRepository;

public interface InsuredRepository extends CrudRepository<InsuredEntity, Long> {
}
