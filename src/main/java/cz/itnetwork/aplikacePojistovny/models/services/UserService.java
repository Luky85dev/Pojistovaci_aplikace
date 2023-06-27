package cz.itnetwork.aplikacePojistovny.models.services;

import cz.itnetwork.aplikacePojistovny.models.dto.UserDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    void create (UserDTO user, boolean isAdmin);
}
