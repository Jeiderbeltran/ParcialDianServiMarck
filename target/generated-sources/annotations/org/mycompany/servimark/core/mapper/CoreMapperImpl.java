package org.mycompany.servimark.core.mapper;

import javax.annotation.processing.Generated;
import org.mycompany.servimark.core.dto.DepartamentDTO;
import org.mycompany.servimark.core.dto.MunicipalityDTO;
import org.mycompany.servimark.core.models.Departament;
import org.mycompany.servimark.core.models.Municipality;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-29T20:08:06-0500",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.38.0.v20240417-1011, environment: Java 17.0.10 (Eclipse Adoptium)"
)
@Component
public class CoreMapperImpl implements CoreMapper {

    @Override
    public MunicipalityDTO municipalityToMunicipalityDTO(Municipality municipality) {
        if ( municipality == null ) {
            return null;
        }

        MunicipalityDTO municipalityDTO = new MunicipalityDTO();

        return municipalityDTO;
    }

    @Override
    public Municipality municipalityDTOToMunicipality(MunicipalityDTO municipalityDTO) {
        if ( municipalityDTO == null ) {
            return null;
        }

        Municipality municipality = new Municipality();

        return municipality;
    }

    @Override
    public DepartamentDTO departamentToDepartamentDTO(Departament departament) {
        if ( departament == null ) {
            return null;
        }

        Short id = null;
        String name = null;

        id = departament.getId();
        name = departament.getName();

        DepartamentDTO departamentDTO = new DepartamentDTO( id, name );

        return departamentDTO;
    }

    @Override
    public Departament departamentDTOToDepartament(DepartamentDTO departamentDTO) {
        if ( departamentDTO == null ) {
            return null;
        }

        Departament departament = new Departament();

        departament.setId( departamentDTO.id() );
        departament.setName( departamentDTO.name() );

        return departament;
    }
}
