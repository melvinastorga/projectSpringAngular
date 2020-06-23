import { NgModule } from "@angular/core";
import { BrowserModule } from "@angular/platform-browser";
import { RouteReuseStrategy } from "@angular/router";
import { IonicModule, IonicRouteStrategy } from "@ionic/angular";
import { SplashScreen } from "@ionic-native/splash-screen/ngx";
import { StatusBar } from "@ionic-native/status-bar/ngx";
import { CarouselModule, WavesModule } from "angular-bootstrap-md";
import {MDBBootstrapModulesPro,AnimatedCardsModule,} from "ng-uikit-pro-standard";
import { AppComponent } from "./app.component";
import { AppRoutingModule } from "./app-routing.module";
import { BrowserAnimationsModule } from "@angular/platform-browser/animations";
import { MaterialModule } from "./material.module";
import { NgbModule } from "@ng-bootstrap/ng-bootstrap";
import { MDBSpinningPreloader } from "ng-uikit-pro-standard";

import {
  ButtonsModule,
  IconsModule,
  CardsModule,
  ModalModule,
  ChartsModule,
  BadgeModule,
  MDBRootModule,
  CollapseModule,
  DropdownModule,
  NavbarModule,
  InputsModule,
  PopoverModule,
  TooltipModule,
  CheckboxModule,
  InputUtilitiesModule,
  TableModule,
  StickyHeaderModule,
  BreadcrumbModule,
} from "angular-bootstrap-md";

@NgModule({
  declarations: [AppComponent],
  entryComponents: [],
  imports: [
    BrowserModule,
    IonicModule.forRoot(),
    AppRoutingModule,
    BrowserAnimationsModule,
    MaterialModule,
    MDBBootstrapModulesPro.forRoot(),
    CarouselModule,
    WavesModule,
    NgbModule,
    AnimatedCardsModule,
    ButtonsModule,
    IconsModule,
    ModalModule,
    ChartsModule,
    BadgeModule,
    MDBRootModule,
    CollapseModule,
    DropdownModule,
    NavbarModule,
    InputsModule,
    PopoverModule,
    TooltipModule,
    CheckboxModule,
    InputUtilitiesModule,
    TableModule,
    StickyHeaderModule,
    BreadcrumbModule,
    CardsModule,
  ],
  providers: [
    StatusBar,
    SplashScreen,
    MDBSpinningPreloader,
    { provide: RouteReuseStrategy, useClass: IonicRouteStrategy },
  ],
  bootstrap: [AppComponent],
})
export class AppModule {}
