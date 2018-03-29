/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async, inject, fakeAsync, tick } from '@angular/core/testing';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Observable } from 'rxjs/Observable';
import { JhiEventManager } from 'ng-jhipster';

import { SapwebTestModule } from '../../../test.module';
import { SocioSapwebDeleteDialogComponent } from '../../../../../../main/webapp/app/entities/socio-sapweb/socio-sapweb-delete-dialog.component';
import { SocioSapwebService } from '../../../../../../main/webapp/app/entities/socio-sapweb/socio-sapweb.service';

describe('Component Tests', () => {

    describe('SocioSapweb Management Delete Component', () => {
        let comp: SocioSapwebDeleteDialogComponent;
        let fixture: ComponentFixture<SocioSapwebDeleteDialogComponent>;
        let service: SocioSapwebService;
        let mockEventManager: any;
        let mockActiveModal: any;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [SapwebTestModule],
                declarations: [SocioSapwebDeleteDialogComponent],
                providers: [
                    SocioSapwebService
                ]
            })
            .overrideTemplate(SocioSapwebDeleteDialogComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(SocioSapwebDeleteDialogComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(SocioSapwebService);
            mockEventManager = fixture.debugElement.injector.get(JhiEventManager);
            mockActiveModal = fixture.debugElement.injector.get(NgbActiveModal);
        });

        describe('confirmDelete', () => {
            it('Should call delete service on confirmDelete',
                inject([],
                    fakeAsync(() => {
                        // GIVEN
                        spyOn(service, 'delete').and.returnValue(Observable.of({}));

                        // WHEN
                        comp.confirmDelete(123);
                        tick();

                        // THEN
                        expect(service.delete).toHaveBeenCalledWith(123);
                        expect(mockActiveModal.dismissSpy).toHaveBeenCalled();
                        expect(mockEventManager.broadcastSpy).toHaveBeenCalled();
                    })
                )
            );
        });
    });

});
