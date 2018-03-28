package cl.transunion.sap.repository;

import cl.transunion.sap.domain.Socio;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the Socio entity.
 */
@SuppressWarnings("unused")
@Repository
public interface SocioRepository extends JpaRepository<Socio, Long> {

}
