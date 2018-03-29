package cl.transunion.sap.repository;

import cl.transunion.sap.domain.Disolucion;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the Disolucion entity.
 */
@SuppressWarnings("unused")
@Repository
public interface DisolucionRepository extends JpaRepository<Disolucion, Long> {

}
