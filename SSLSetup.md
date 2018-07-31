# How to Setup 2-Way SSL Between Spring Boot/PostgreSQL and Apache Tomcat

## Spring Boot Application Setup
Create a Java project, then go to [Maven repo](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-dependencies) for Spring Boot dependencies.
Click on a version and copy and paste the dependency in the Maven *pom.xml* (we used the 2.0.3.RELEASE). Paul is really good for Spring Boot questions so hopefully
he is still around and kicking.

## Tomcat Installation + Configuration
[This](https://www.digitalocean.com/community/tutorials/how-to-install-apache-tomcat-8-on-ubuntu-16-04) is the link we used to install/configure our 
Tomcat instance. The Tomcat download link we used is [here](http://ftp.wayne.edu/apache/tomcat/tomcat-8/v8.5.32/bin/apache-tomcat-8.5.32.tar.gz) .
Follow from start to finish.

To run the Tomcat server, use 'systemctl start tomcat'. Use 'systemctl status tomcat' to check the status of the server.
To see the web application page, go to localhost:8080.

## PostgreSQL Installation + Configuration
[This](http://zetcode.com/springboot/postgresql/) is how we installed PostgreSQL, configured users, and linked dependencies to our Spring Boot application. 
Follow from "PostgreSQL" to the *application.properties* file part of "Spring Boot PostgreSQL example". Note: Instead of using an *application.properties* file
in our Spring Boot, we chose to use a YAML (.yml) format.

## Running Spring Boot Application Through Tomcat
Make sure that the Maven WAR dependency is specified in the Maven *pom.xml* as follows:
```<dependency>
     <groupId>org.apache.maven.plugins</groupId>
     <artifactId>maven-war-plugin</artifactId>
     <version>3.2.2</version>
     <type>maven-plugin</type>
</dependency>
```
In addition, the line '<packaging>war</packaging>' should be included. 

The WAR file must be generated and moved into the Tomcat webapps folder. To do so, run 'mvn clean install' within the project directory and then move the 
resulting WAR file in the *target/* folder to the root directory */opt/tomcat/webapps*. Restart the Tomcat server using 'systemctl restart tomcat'.

Test the REST API endpoint by going to 'localhost:8080/<PROJECT NAME>-1.0-SNAPSHOT/<endpoint-name>'.

## Generating Certificates
[This](https://www.opencodez.com/java/implement-2-way-authentication-using-ssl.htm) is the link we used to generate certificates for Tomcat and PostgreSQL. Follow
up until "Configure Tomcat for SSL".

