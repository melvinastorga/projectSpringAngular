import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { IonicModule } from '@ionic/angular';

import { RemoveProfessorCoursesPage } from './remove-professor-courses.page';

describe('RemoveProfessorCoursesPage', () => {
  let component: RemoveProfessorCoursesPage;
  let fixture: ComponentFixture<RemoveProfessorCoursesPage>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RemoveProfessorCoursesPage ],
      imports: [IonicModule.forRoot()]
    }).compileComponents();

    fixture = TestBed.createComponent(RemoveProfessorCoursesPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
