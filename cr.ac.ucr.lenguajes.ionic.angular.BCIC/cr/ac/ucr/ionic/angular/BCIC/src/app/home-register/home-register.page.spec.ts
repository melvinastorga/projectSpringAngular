import { async, ComponentFixture, TestBed } from "@angular/core/testing";
import { IonicModule } from "@ionic/angular";

import { HomeRegisterPage } from "./home-register.page";

describe("HomeRegisterPage", () => {
  let component: HomeRegisterPage;
  let fixture: ComponentFixture<HomeRegisterPage>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [HomeRegisterPage],
      imports: [IonicModule.forRoot()],
    }).compileComponents();

    fixture = TestBed.createComponent(HomeRegisterPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it("should create", () => {
    expect(component).toBeTruthy();
  });
});
