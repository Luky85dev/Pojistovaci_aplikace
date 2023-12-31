package cz.itnetwork.aplikacePojistovny.data.repositories;

import cz.itnetwork.aplikacePojistovny.data.entities.UserEntity;
import org.springframework.data.repository.CrudRepository;
import java.util.Optional;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
    Optional<UserEntity> findByEmail(String email);


}