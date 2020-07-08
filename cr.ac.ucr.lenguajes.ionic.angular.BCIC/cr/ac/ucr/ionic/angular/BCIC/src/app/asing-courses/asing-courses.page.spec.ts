import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { IonicModule } from '@ionic/angular';

import { AsingCoursesPage } from './asing-courses.page';

describe('AsingCoursesPage', () => {
  let component: AsingCoursesPage;
  let fixture: ComponentFixture<AsingCoursesPage>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AsingCoursesPage ],
      imports: [IonicModule.forRoot()]
    }).compileComponents();

    fixture = TestBed.createComponent(AsingCoursesPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
