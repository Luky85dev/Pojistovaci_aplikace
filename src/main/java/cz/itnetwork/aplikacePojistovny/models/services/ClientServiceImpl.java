package cz.itnetwork.aplikacePojistovny.models.services;

import java.util.List;
import java.util.stream.StreamSupport;

import cz.itnetwork.aplikacePojistovny.data.entities.ClientEntity;
import cz.itnetwork.aplikacePojistovny.models.dto.ClientDTO;
import cz.itnetwork.aplikacePojistovny.models.exceptions.ClientNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cz.itnetwork.aplikacePojistovny.data.repositories.ClientRepository;
import cz.itnetwork.aplikacePojistovny.models.dto.mappers.ClientMapper;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;                            //auto. předá repositář

    @Autowired
    private ClientMapper clientMapper;

    @Override
    public void create(ClientDTO client) {
        ClientEntity newClient = clientMapper.toEntity(client); //mapper

        clientRepository.save(newClient);
    }

    @Override
    public List<ClientDTO> getAll() {
        return StreamSupport.stream(clientRepository.findAll().spliterator(), false)
                    .map(i -> clientMapper.toDTO(i))
                    .toList();
        }

        @Override
        public ClientDTO getById(long clientId) {
            ClientEntity fetchedClient = getClientOrThrow(clientId);

            return clientMapper.toDTO(fetchedClient);
        }

        @Override
        public void edit(ClientDTO client) {
            ClientEntity fetchedClient = getClientOrThrow(client.getClientId());

            clientMapper.updateClientEntity(client, fetchedClient);
            clientRepository.save(fetchedClient);
        }

        @Override
        public void remove(long clientId) {
            ClientEntity fetchedEntity = getClientOrThrow(clientId);
            clientRepository.delete(fetchedEntity);
        }

        private ClientEntity getClientOrThrow(long clientId) {
            return clientRepository
                    .findById(clientId)
                    .orElseThrow(ClientNotFoundException::new);
    }






}
