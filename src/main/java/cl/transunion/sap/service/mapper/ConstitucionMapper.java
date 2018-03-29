package cl.transunion.sap.service.mapper;

import cl.transunion.sap.domain.*;
import cl.transunion.sap.service.dto.ConstitucionDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Constitucion and its DTO ConstitucionDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface ConstitucionMapper extends EntityMapper<ConstitucionDTO, Constitucion> {



    default Constitucion fromId(Long id) {
        if (id == null) {
            return null;
        }
        Constitucion constitucion = new Constitucion();
        constitucion.setId(id);
        return constitucion;
    }
}
