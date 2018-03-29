import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';

import { SapwebCargaSocvigSapwebModule } from './carga-socvig-sapweb/carga-socvig-sapweb.module';
import { SapwebControlCambioRazonSapwebModule } from './control-cambio-razon-sapweb/control-cambio-razon-sapweb.module';
import { SapwebSocioSapwebModule } from './socio-sapweb/socio-sapweb.module';
import { SapwebSocioDatPerSapwebModule } from './socio-dat-per-sapweb/socio-dat-per-sapweb.module';
import { SapwebConstitucionSapwebModule } from './constitucion-sapweb/constitucion-sapweb.module';
import { SapwebModificacionSapwebModule } from './modificacion-sapweb/modificacion-sapweb.module';
import { SapwebDisolucionSapwebModule } from './disolucion-sapweb/disolucion-sapweb.module';
/* jhipster-needle-add-entity-module-import - JHipster will add entity modules imports here */

@NgModule({
    imports: [
        SapwebCargaSocvigSapwebModule,
        SapwebControlCambioRazonSapwebModule,
        SapwebSocioSapwebModule,
        SapwebSocioDatPerSapwebModule,
        SapwebConstitucionSapwebModule,
        SapwebModificacionSapwebModule,
        SapwebDisolucionSapwebModule,
        /* jhipster-needle-add-entity-module - JHipster will add entity modules here */
    ],
    declarations: [],
    entryComponents: [],
    providers: [],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class SapwebEntityModule {}
