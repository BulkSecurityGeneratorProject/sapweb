package cl.transunion.sap.repository;

import cl.transunion.sap.domain.CargaSocvig;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the CargaSocvig entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CargaSocvigRepository extends JpaRepository<CargaSocvig, Long> {

}
