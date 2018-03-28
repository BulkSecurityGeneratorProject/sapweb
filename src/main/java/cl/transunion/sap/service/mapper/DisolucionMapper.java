package cl.transunion.sap.service.mapper;

import cl.transunion.sap.domain.*;
import cl.transunion.sap.service.dto.DisolucionDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Disolucion and its DTO DisolucionDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface DisolucionMapper extends EntityMapper<DisolucionDTO, Disolucion> {



    default Disolucion fromId(Long id) {
        if (id == null) {
            return null;
        }
        Disolucion disolucion = new Disolucion();
        disolucion.setId(id);
        return disolucion;
    }
}
