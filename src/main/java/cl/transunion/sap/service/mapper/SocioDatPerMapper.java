package cl.transunion.sap.service.mapper;

import cl.transunion.sap.domain.*;
import cl.transunion.sap.service.dto.SocioDatPerDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity SocioDatPer and its DTO SocioDatPerDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface SocioDatPerMapper extends EntityMapper<SocioDatPerDTO, SocioDatPer> {



    default SocioDatPer fromId(Long id) {
        if (id == null) {
            return null;
        }
        SocioDatPer socioDatPer = new SocioDatPer();
        socioDatPer.setId(id);
        return socioDatPer;
    }
}
