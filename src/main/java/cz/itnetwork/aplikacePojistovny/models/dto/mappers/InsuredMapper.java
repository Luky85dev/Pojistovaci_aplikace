package cz.itnetwork.aplikacePojistovny.models.dto.mappers;

import cz.itnetwork.aplikacePojistovny.data.entities.InsuredEntity;
import cz.itnetwork.aplikacePojistovny.models.dto.InsuredDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface InsuredMapper {


    InsuredEntity toEntity(InsuredDTO source);
    @Mapping(target = "clientId", source = "clientId")
    InsuredDTO toDTO(InsuredEntity source);

    void updateInsuredDTO(InsuredDTO source, @MappingTarget InsuredDTO target);

    void updateInsuredEntity(InsuredDTO source, @MappingTarget InsuredEntity target);

}
