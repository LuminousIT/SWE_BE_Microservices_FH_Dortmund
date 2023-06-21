RoadRash - Road Side Assistance Application

RoadRash is a road side assistance application that provides support and services to drivers who experience issues while driving. The application consists of the following microservices:

    UserManagementService
    VehicleService
    WarningService
    InsuranceManagement
    Frontend Service (React)

To Startup,
* Start services in this order;
  * Configuration Service
  * Start Discovery Service
  * Start UserManagement Service
  * Start Vehicle Service
  * Start Warning Service
* Clone and start Frontend Service
  * To start,
    * run git clone [repo] 
    * ```npm install``` 
    * ```npm run start```
    * Service starts on Port 3000

### Service Description
1. UserManagement Service: Handles user management. Exposed on Port 8081.
    * Here, you can create and update user info
    * You can create and update Vehicle Info.
    * Log Vehicle Errors
    * Communicates with the Vehicle Service to get Defect Component Details and supply that info to user.
    * Exposed on Port 8081.
      - Created by: Samuel Oluwole
2.  Vehicle Service: Handles Defect Component Details. Record of Defect component with Error Code and Info about Component Availability is stored here.
      - Created by: Samuel Oluwole
      -   * Exposed on Port 8085.
3.  Warning Service: Gets Weather Forecast Report and Supply info to Frontend Service
      - Created by: Mahmud, Samuel Oluwole
      -  * Exposed on Port 8086.
4.  Frontend Service: Dashboard to view Information. 
     * User signs on by creating an account and logging in with details.
     * Displays current Weather info to user.
     * Simulate Breakdown.
     * Display Error and Support Information.
     * Charts of Weather forecast to warn user.
      - Created by: Samuel Oluwole
      -  * Exposed on Port 3000.

**Note: Communication happen within the localhost environment. Endpoints therefore communicate via http://localhost:[port]/{address}**

Each of these microservices provides a specific function to help drivers in need. 
