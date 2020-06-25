import { async, ComponentFixture, TestBed } from "@angular/core/testing";
import { IonicModule } from "@ionic/angular";

import { ProfessorsOfficeHoursPage } from "./professors-office-hours.page";

describe("ProfessorsOfficeHoursPage", () => {
  let component: ProfessorsOfficeHoursPage;
  let fixture: ComponentFixture<ProfessorsOfficeHoursPage>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ProfessorsOfficeHoursPage],
      imports: [IonicModule.forRoot()],
    }).compileComponents();

    fixture = TestBed.createComponent(ProfessorsOfficeHoursPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it("should create", () => {
    expect(component).toBeTruthy();
  });
});
