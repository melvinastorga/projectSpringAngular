import { NgModule } from '@angular/core';
import { PreloadAllModules, RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {
    path: 'home',
    loadChildren: () => import('./home/home.module').then( m => m.HomePageModule)
  },
  {
    path: '',
    redirectTo: 'home',
    pathMatch: 'full'
  },
  {
    path: 'home-login',
    loadChildren: () => import('./home-login/home-login.module').then( m => m.HomeLoginPageModule)
  },
  {
    path: 'professors',
    loadChildren: () => import('./professors/professors.module').then( m => m.ProfessorsPageModule)
  },
  {
    path: 'courses',
    loadChildren: () => import('./courses/courses.module').then( m => m.CoursesPageModule)
  },
  {
    path: 'students',
    loadChildren: () => import('./students/students.module').then( m => m.StudentsPageModule)
  },
  {
    path: 'my-courses',
    loadChildren: () => import('./my-courses/my-courses.module').then( m => m.MyCoursesPageModule)
  },
  {
    path: 'home-register',
    loadChildren: () => import('./home-register/home-register.module').then( m => m.HomeRegisterPageModule)
  },
  
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes, { preloadingStrategy: PreloadAllModules })
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
