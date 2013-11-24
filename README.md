SoftwareEngineeringAssignment1
==============================

Integrated with DHIS2 - Create a client and push file to a server through url

Notice
------
In order to use with database:
Please change the password in the Spring-Datasource.xml file into your real password

For those who want to integrate with the database
Make sure that your maven home does have mysql directory
If do not, download the mysql-connector-java-version.jar and but it into the maven home by using:
	mvn install:install-file -Dfile=C:\Libraries\mysql-connector-java-5.1.15-bin\mysql-connector-java-5.1.15-bin.jar 
		-DgroupId=mysql -DartifactId=mysql-connector-java -Dversion=5.1.15-bin -Dpackaging=jar
Moreover, dependency should be added in the pom.xml file too
	<dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <version>5.1.15-bin</version>
    </dependency> 

For JSON library.
Download the following links and add it in your maven home.


