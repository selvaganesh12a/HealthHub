import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
 
 
import { LoginComponent } from './login/login.component';

 

import { PractitionerComponent } from './pages/practitioner/practitioner.component';
import { PractitionerdetailsComponent } from './pages/practitioner/practitionerdetails/practitionerdetails.component';
import { PatientComponent} from './pages/patient/patient.component';
import { PatientdetailsComponent } from './pages/patient/patientdetails/patientdetails.component';
import { AppointmentsComponent} from './pages/appointments/appointments.component';
import {  AppointmentsdetailsComponent } from './pages/appointments/appointmentsdetails/appointmentsdetails.component'; 
 
const routes: Routes = [
  { path: '', redirectTo: '/practitioner', pathMatch: 'full' },
  { path: 'login', component: LoginComponent },
    
       
  

  
  { path: 'practitioner', component: PractitionerComponent },
  { path: 'practitioner/practitionerdetails', component: PractitionerdetailsComponent },
  { path: 'patient', component: PatientComponent },
  { path: 'patient/patientdetails', component: PatientdetailsComponent },
  { path: 'appointments', component: AppointmentsComponent },
  { path: 'appointments/appointmentsdetails', component: AppointmentsdetailsComponent },
  
 
  ]; 

@NgModule({
  exports: [RouterModule],
  imports: [RouterModule.forRoot(routes, { useHash: true })]
})
export class AppRoutingModule { } 