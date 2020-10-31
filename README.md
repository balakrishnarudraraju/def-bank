# def-bank
Sample to create APIs for mobile only bank


1. Import the project onto eclipse/STS as Import Gradle project.
2. Run the server from Boot Dashboard
3. By default h2 database is configured to C:\\data\\demo file.

How to test the API:

use Postman/soap ui to test the following urls.

List Accounts : http://localhost:8080/accounts/
Create an Account: http://localhost:8080/accounts/ 
                   http method: POST
                   body json: 
                   {
                    "customerId": "1234",
                    "currency": "INR",
                    "type": "C"
                  }


Swagger URL: http://localhost:8080/swagger-ui
