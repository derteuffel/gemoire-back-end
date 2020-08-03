import { BrowserModule } from '@angular/platform-browser';
// import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http'
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FiliereService } from './services/filiere.service';
import { FormsModule } from '@angular/forms';
import { MemoiresService } from './services/memoires.service';

@NgModule({
  declarations: [
    AppComponent,
  
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    HttpClientModule,
    AppRoutingModule,
    FormsModule,
  ],
  providers: [
    FiliereService,
    MemoiresService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
