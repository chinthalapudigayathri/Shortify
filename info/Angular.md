Angular Notes

1. go to project root directory execute C:\Users\Gayathri\Projects>ng new shortify-ui
2. got to cd shortify-ui and execute ng serve
3. Local:   http://localhost:4200/
4. execute the following command to creare api service : ng generate service services/api
5. To run and test Angular execute: ng serve shortify-ui
6. First in index.html add the following:
<body>
  <app-root></app-root>
</body>
7. Angular starts here <app-root> is our root component, this will automatically be generated with our previous commands
8. next thing is main.ts, it will also be automatically generated
bootstrapApplication(AppComponent, appConfig);
means angular starts the app and loads Appcomponent and app config
Appcomponent:UI root and appConfig:providers like HttpClient
9. Next we go to src/app, this is the most important part of our application. This is the brain of our application
10. app.ts is like controller + component logic. It holds Data. Calls API and handles button clicks
11. This is like a UI template similar to JSP but it is reactive. It displays data, collects user input and calls component methods
12. Next app.routes.ts handles page navigation like /home, /login, /analytics
13. app.config.ts is like a file where we provide all configurations, settings and bootstrapping logic
14. It handles http clients and route configuration
15. src/app/service is an API communication layer. It calls backend api, it does not have any ui logic. We can reuse these components in code again
16. logic:
index.html
   ↓
main.ts
   ↓
app.config.ts  (global setup)
   ↓
app.ts         (logic)
   ↓
app.html       (UI)
   ↓
api.service.ts → Spring Boot
17. Similarities between Angular an Springboot

Spring Boot	                  Angular
Controller	                 Component
Service	                     Service
DTO	                         Interface / Object
application.yml	             app.config.ts
@Autowired	                 constructor injection
18. In app.component.html or ap.html remove everything and add <router-outlet></router-outlet>
19. To create pages execute the following command ng generate component pages/home
20. Next we need to configure routing. open app.routes.ts and in routes add path { path: '', component: HomeComponent }
21. go to home.html and add basic html structure
22. To generate angulat service for springboot api execute the following ng generate service services/url
