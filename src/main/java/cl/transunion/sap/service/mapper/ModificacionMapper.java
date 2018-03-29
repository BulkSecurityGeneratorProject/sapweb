package cl.transunion.sap.service.mapper;

import cl.transunion.sap.domain.*;
import cl.transunion.sap.service.dto.ModificacionDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Modificacion and its DTO ModificacionDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface ModificacionMapper extends EntityMapper<ModificacionDTO, Modificacion> {



    default Modificacion fromId(Long id) {
        if (id == null) {
            return null;
        }
        Modificacion modificacion = new Modificacion();
        modificacion.setId(id);
        return modificacion;
    }
}
