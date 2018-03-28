package cl.transunion.sap.repository;

import cl.transunion.sap.domain.SocioDatPer;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the SocioDatPer entity.
 */
@SuppressWarnings("unused")
@Repository
public interface SocioDatPerRepository extends JpaRepository<SocioDatPer, Long> {

}
