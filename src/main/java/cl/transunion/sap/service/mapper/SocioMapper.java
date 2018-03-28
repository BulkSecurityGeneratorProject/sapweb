package cl.transunion.sap.service.mapper;

import cl.transunion.sap.domain.*;
import cl.transunion.sap.service.dto.SocioDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Socio and its DTO SocioDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface SocioMapper extends EntityMapper<SocioDTO, Socio> {



    default Socio fromId(Long id) {
        if (id == null) {
            return null;
        }
        Socio socio = new Socio();
        socio.setId(id);
        return socio;
    }
}
