package org.mycompany.servimark.core.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mycompany.servimark.core.dto.DepartamentDTO;
import org.mycompany.servimark.core.dto.MunicipalityDTO;
import org.mycompany.servimark.core.models.Departament;
import org.mycompany.servimark.core.models.Municipality;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CoreMapper {
    MunicipalityDTO municipalityToMunicipalityDTO(Municipality municipality);
    Municipality municipalityDTOToMunicipality(MunicipalityDTO municipalityDTO);
    DepartamentDTO departamentToDepartamentDTO(Departament departament);
    Departament departamentDTOToDepartament(DepartamentDTO departamentDTO);
}
