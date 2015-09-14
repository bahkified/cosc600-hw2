# cosc600-hw2
I used Maven to build this project. It uses the maven-assembly-plugin to create an executable JAR, which can be run on the command line.

Using Maven, to build the project, you must be at the project root directory. Run the command:

`mvn package`

This will place the JAR at location 'target/hw2.jar' The JAR can be run using the command:

```
java -jar <location_of_jar> <location_of_data>

EX:
java -jar target/hw2.jar src/main/resources/data.txt
```
