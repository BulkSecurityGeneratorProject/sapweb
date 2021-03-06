/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async } from '@angular/core/testing';
import { Observable } from 'rxjs/Observable';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { SapwebTestModule } from '../../../test.module';
import { CargaSocvigSapwebComponent } from '../../../../../../main/webapp/app/entities/carga-socvig-sapweb/carga-socvig-sapweb.component';
import { CargaSocvigSapwebService } from '../../../../../../main/webapp/app/entities/carga-socvig-sapweb/carga-socvig-sapweb.service';
import { CargaSocvigSapweb } from '../../../../../../main/webapp/app/entities/carga-socvig-sapweb/carga-socvig-sapweb.model';

describe('Component Tests', () => {

    describe('CargaSocvigSapweb Management Component', () => {
        let comp: CargaSocvigSapwebComponent;
        let fixture: ComponentFixture<CargaSocvigSapwebComponent>;
        let service: CargaSocvigSapwebService;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [SapwebTestModule],
                declarations: [CargaSocvigSapwebComponent],
                providers: [
                    CargaSocvigSapwebService
                ]
            })
            .overrideTemplate(CargaSocvigSapwebComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(CargaSocvigSapwebComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(CargaSocvigSapwebService);
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN
                const headers = new HttpHeaders().append('link', 'link;link');
                spyOn(service, 'query').and.returnValue(Observable.of(new HttpResponse({
                    body: [new CargaSocvigSapweb(123)],
                    headers
                })));

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(service.query).toHaveBeenCalled();
                expect(comp.cargaSocvigs[0]).toEqual(jasmine.objectContaining({id: 123}));
            });
        });
    });

});
