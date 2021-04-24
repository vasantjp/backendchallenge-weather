# backendchallenge-weather

# Getting Started

### pre-requirement 
    * java 11
    * maven
	* add weather.apikey=xxxxxxx in /backendchallenge-weather/src/main/resources/application.properties cureent key is for just testing
 
### Reference Documentation
For further reference, please consider the following sections:

    * Clone repo from git (https://github.com/vasantjp/backendchallenge-weather.git)OR unzip file if already exist.
    * cd backendchallenge-weather
    * for test case run provide cmd=> [mvn clean test]
    * for building application=> [ mvn clean install]
    * To run application cd backendchallenge-weather\target 
        * run java -jar backendchallenge-0.0.1-SNAPSHOT.jar
    
### Testing App
    once application started please open swagger url.
*http://localhost:8090/swagger-ui.html#

### Testing using CRUL
    curl -X GET --header 'Accept: application/json' 'http://localhost:8090/weather/api/v1/current?location=Berlin'
    response: 
             {
  "data": {
    "umbrella": false,
    "temp": 285.39,
    "pressure": 1024
  },
  "message": "SUCCESS",
  "status": 200
}


