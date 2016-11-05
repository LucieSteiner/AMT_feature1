# AMT Bootcamp/Lab01 #

You can find Rest API documentation [here](/doc/RestAPI.md).

## How to launch the application
1. `cd topology-amt`
2. `docker-compose up --build`
3. go to [http://192.168.99.100:8080/bootcamp2-1.0-SNAPSHOT](http://192.168.99.100:8080/bootcamp2-1.0-SNAPSHOT)

If you change the code and build it again, you will need to replace /images/glassfish/bootcamp2-1.0-SNAPSHOT.war by the new .war hat will be created in the /src/bootcamp2/target file.

## About the "User Accounts" page ##

You will probably get an error on the first time you try to access this page. Just reload it. The same problem might happen with the first request you will send to the Rest API, just send it again. Hopefully, this will be fixed soon! 