package cl.transunion.sap.repository;

import cl.transunion.sap.domain.Constitucion;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the Constitucion entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ConstitucionRepository extends JpaRepository<Constitucion, Long> {

}
