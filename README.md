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


Using the example above, the code will run on the data file, `data.txt` which sits at the projects resources directory. You will get the following output:

```
user@Puget-128857:~/workspace/cosc600-hw2$ java -jar target/hw2.jar src/main/resources/data.txt 
Name	SSN	account number	phone number	open balance	close balance
Carla	233-98-3831	74329832	555-9812	$230.00	$235.75
Cliff	811-12-9811	38737737	555-9171	$6,700.00	$7,035.00
Diane	212-11-0091	63672822	555-9232	$2,300.00	$2,392.00
Norm	918-22-0911	27873773	555-2932	$1,400.00	$1,435.00
Sam	123-45-6789	78192222	555-0498	$4,500.00	$4,500.00
Tom	235-09-9282	72932331	555-9283	$7,800.00	$7,995.00
Woody	823-23-0911	72872911	555-9281	$5,700.00	$5,985.00

```
