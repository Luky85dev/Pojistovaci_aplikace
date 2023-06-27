package cz.itnetwork.aplikacePojistovny.models.services;

import cz.itnetwork.aplikacePojistovny.data.entities.InsuredEntity;
import cz.itnetwork.aplikacePojistovny.data.repositories.InsuredRepository;
import cz.itnetwork.aplikacePojistovny.models.dto.InsuredDTO;
import cz.itnetwork.aplikacePojistovny.models.dto.mappers.InsuredMapper;
import cz.itnetwork.aplikacePojistovny.models.exceptions.InsuredNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class InsuredServiceImpl implements InsuredService {

    @Autowired
    private InsuredRepository insuredRepository;                            //auto. předá repositář

    @Autowired
    private InsuredMapper insuredMapper;

    @Override
    public void create(InsuredDTO insured) {
        InsuredEntity newInsured = insuredMapper.toEntity(insured); //mapper

        insuredRepository.save(newInsured);
    }

    @Override
    public List<InsuredDTO> getAll() {
        return StreamSupport.stream(insuredRepository.findAll().spliterator(), false)
                .map(i -> insuredMapper.toDTO(i))
                .toList();
    }

    @Override
    public InsuredDTO getById(long insuredId) {
        InsuredEntity fetchedInsured = getInsuredOrThrow(insuredId);

        return insuredMapper.toDTO(fetchedInsured);
    }

    @Override
    public void edit(InsuredDTO insured) {
        InsuredEntity fetchedInsured = getInsuredOrThrow(insured.getInsuredId());

        insuredMapper.updateInsuredEntity(insured, fetchedInsured);
        insuredRepository.save(fetchedInsured);
    }

    @Override
    public void remove(long insuredId) {
        InsuredEntity fetchedEntity = getInsuredOrThrow(insuredId);
        insuredRepository.delete(fetchedEntity);
    }

    private InsuredEntity getInsuredOrThrow(long insuredId) {
        return insuredRepository
                .findById(insuredId)
                .orElseThrow(InsuredNotFoundException::new);
    }






}


