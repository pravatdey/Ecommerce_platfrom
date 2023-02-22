# Ecommerce_platfrom
Online Shop is a web solution to manage and sell online Product. It is user-friendly web platform that will be run on any web browser and there will be multiple users that will operate the application as per requirements. Technology Key-  Servlet, JSP ,Html, CSS, JavaScript, boostrap, Hibernate, MySQL. 
Software-Eclipse IDE, Tomcat 9,MySql Workbench



Creating the maven first set your Maven-war-plugin otherwise not working 
Show this error :
maven-war-plugin:2.3:war (default-war) @ Ecommerce_Project --- Error injecting: org.apache.maven.plugin.war.WarMojo com.google.inject.ProvisionException: Unable to provision, see the following errors:

Before:

<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-war-plugin</artifactId>
    <version>2.3</version>
</plugin>
After:

<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-war-plugin</artifactId>
    <version>3.3.1</version>
</plugin>
