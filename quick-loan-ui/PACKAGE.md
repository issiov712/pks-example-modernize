### Use Apache Maven to Create a Combined Application Jar

1. `mvn -f ../quick-loan/pom.xml clean install`
2. `mvn`, this runs a `mvn package`
3. `java -jar target/quick-loan-ui-0.0.5-SNAPSHOT.jar`

Browse to `http://localhost:8080/` to see the application.

Obviously you could run it and continue doing development with the front end at `http://localhost:3000`

There is obviously no Java source in this folder.  Apache Maven is using the `maven-shade-plugin` to grab all the dependencies and combine it with the React build output, and specify the correct `mainClass` to start things off.
