package cz.itnetwork.aplikacePojistovny.models.services;

import java.util.List;

import cz.itnetwork.aplikacePojistovny.models.dto.ClientDTO;

public interface ClientService {
    void create (ClientDTO client);
    List<ClientDTO> getAll();

    ClientDTO getById(long clientId);

    void edit (ClientDTO client);

    void remove(long clientId);



}
