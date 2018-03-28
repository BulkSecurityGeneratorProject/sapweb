package cl.transunion.sap.repository;

import cl.transunion.sap.domain.Modificacion;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the Modificacion entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ModificacionRepository extends JpaRepository<Modificacion, Long> {

}
