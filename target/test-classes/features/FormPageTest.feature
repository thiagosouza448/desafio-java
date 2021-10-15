 #language: en
 #charset: UTF-8


 @fillTabs
 Feature: Send tabs
   I as a user would like fill fields in tabs


   Scenario Outline: CT001 - Enter Vehicle Data
     Given access page
     And select the make "<make>"
     When select  "<model>" and fill "<CylinderCapacity>" "<EnginePerformance>"
     And fill date "<date>"
     And select "<NumberOfSeats>"
     And select RightHandDrive "<RightHandDrive>"
     And select number of seats and fuel type "<NumberOfSeats>" and "<FuelType>"
     And I fill in the other information  "<Payload>"  "<TotalWeight>"  "<ListPrice>"  "<LicensePlateNumber>"  "<AnnualMileage>"
     Then click in the next "<step>"
     Examples:
       | make  | model   | CylinderCapacity | EnginePerformance | date       | NumberOfSeats | RightHandDrive | FuelType | Payload | TotalWeight | ListPrice | LicensePlateNumber | AnnualMileage | step                    |
       | Ford  | Scooter | 19               | 21                | 08/12/1992 | 1             | Yes            | Diesel    | 322     | 2323        | 2333      | 22                 | 222          | nextenterinsurantdata   |


   Scenario Outline: CT002 - Enter Insurant Data
     Given access insurant data form
     And fill "<first>" name and "<last>" name
     When fill "<dateBirth>"
     And select "<gender>" valid
     And fill address "<street>" "<country>" "<zipCode>" "<city>"
     And fill "<occupation>"  "<hobbie>"
     And fill website "<webSite>"
     And make upload file
     Then click in the next "<step>"
     Examples:
       | first   | last     | dateBirth   | gender   | street      | country | zipCode    | city       | occupation  | hobbie        | webSite    | step                   |
       | Thiago  |  Souza   | 04/10/2000  | Male     | Rua Miller  | Brazil  | 03011011   | Sao Paulo  |  Farmer     |  Skydiving    | thiagoS    | nextenterproductdata   |


   Scenario Outline: CT003 - Enter Product Data
     Given access product data form
     And fill start date
     And select "<insurance>" "<merit>" "<damage>"
     And select "<optional>" product
     When select "<courtesy>" car
     Then click in the next "<step>"
     Examples:
       | insurance          |  merit     |  damage           | optional          |  courtesy     | step                   |
       |  35.000.000,00     |   Bonus 1  | Partial Coverage  |  Euro Protection  |   No          |nextselectpriceoption   |

   Scenario Outline: CT004 - Enter
     Given access page
     And fill in the data on the first form
     And fill in the data on the second form
     And fill product data
     And select "<price>" form
     When send quote with data "<username>" "<password>" "<confirmPassowrd>" "<comments>"
     Then then send successfully
     Examples:
    | price      |  username  | password      |  confirmPassowrd      |  comments       |
    | Gold       |   Thiago   |  Thiago@1     |   Thiago@1            |     Teste       |