package cl.transunion.sap.web.rest;

import com.codahale.metrics.annotation.Timed;
import cl.transunion.sap.service.SocioService;
import cl.transunion.sap.web.rest.errors.BadRequestAlertException;
import cl.transunion.sap.web.rest.util.HeaderUtil;
import cl.transunion.sap.web.rest.util.PaginationUtil;
import cl.transunion.sap.service.dto.SocioDTO;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing Socio.
 */
@RestController
@RequestMapping("/api")
public class SocioResource {

    private final Logger log = LoggerFactory.getLogger(SocioResource.class);

    private static final String ENTITY_NAME = "socio";

    private final SocioService socioService;

    public SocioResource(SocioService socioService) {
        this.socioService = socioService;
    }

    /**
     * POST  /socios : Create a new socio.
     *
     * @param socioDTO the socioDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new socioDTO, or with status 400 (Bad Request) if the socio has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/socios")
    @Timed
    public ResponseEntity<SocioDTO> createSocio(@RequestBody SocioDTO socioDTO) throws URISyntaxException {
        log.debug("REST request to save Socio : {}", socioDTO);
        if (socioDTO.getId() != null) {
            throw new BadRequestAlertException("A new socio cannot already have an ID", ENTITY_NAME, "idexists");
        }
        SocioDTO result = socioService.save(socioDTO);
        return ResponseEntity.created(new URI("/api/socios/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /socios : Updates an existing socio.
     *
     * @param socioDTO the socioDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated socioDTO,
     * or with status 400 (Bad Request) if the socioDTO is not valid,
     * or with status 500 (Internal Server Error) if the socioDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/socios")
    @Timed
    public ResponseEntity<SocioDTO> updateSocio(@RequestBody SocioDTO socioDTO) throws URISyntaxException {
        log.debug("REST request to update Socio : {}", socioDTO);
        if (socioDTO.getId() == null) {
            return createSocio(socioDTO);
        }
        SocioDTO result = socioService.save(socioDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, socioDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /socios : get all the socios.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of socios in body
     */
    @GetMapping("/socios")
    @Timed
    public ResponseEntity<List<SocioDTO>> getAllSocios(Pageable pageable) {
        log.debug("REST request to get a page of Socios");
        Page<SocioDTO> page = socioService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/socios");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /socios/:id : get the "id" socio.
     *
     * @param id the id of the socioDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the socioDTO, or with status 404 (Not Found)
     */
    @GetMapping("/socios/{id}")
    @Timed
    public ResponseEntity<SocioDTO> getSocio(@PathVariable Long id) {
        log.debug("REST request to get Socio : {}", id);
        SocioDTO socioDTO = socioService.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(socioDTO));
    }

    /**
     * DELETE  /socios/:id : delete the "id" socio.
     *
     * @param id the id of the socioDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/socios/{id}")
    @Timed
    public ResponseEntity<Void> deleteSocio(@PathVariable Long id) {
        log.debug("REST request to delete Socio : {}", id);
        socioService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
