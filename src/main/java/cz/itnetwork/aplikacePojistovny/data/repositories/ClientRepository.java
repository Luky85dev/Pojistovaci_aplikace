package cz.itnetwork.aplikacePojistovny.data.repositories;

import cz.itnetwork.aplikacePojistovny.data.entities.ClientEntity;
import org.springframework.data.repository.CrudRepository;
public interface ClientRepository extends CrudRepository<ClientEntity, Long> {
//automatická komunikace se MySQLpřes CrudRepository
}
