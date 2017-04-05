## Abstract
Book Track Applicaiton 

## Technology Stack
- [x] JAVA language is being used.
- [x] Latest spring boot libraries. (1.3.x+)
- [x] MAVEN for build system
- [x] Use your own favourite IDE (vim, eclipse, intellij, notepad

## How to run it
- Clone (or fork, then clone) this project to your local environment.
- Like any other spring boot app

### Command line commands
#### Initial setup
```
git clone https://github.com/aakash7864/CS487.git

cd CS487/BookTrackApp/
mvn clean compile
mvn package

```
#### Run
**if you have configured properties file in output already**
```
mvn spring-boot:run
```
### Metrics?
As we get time, add better metrics than already available default ones.
http://localhost:8080/metrics
http://localhost:8080/health
