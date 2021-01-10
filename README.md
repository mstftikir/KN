# Contact List Web Application

This project is a web based contact listing application that allows listing contacts, searching by name, paging. Its data is taken from a file on application statup. Please find details below.

## Table of Contents

1. [Build and Run](#build-run)
2. [Technology Stack](#technology-stack)
3. [Test](#test)
4. [Architecture](#architecture)

## <a name="build-run"></a>Build and Run

This is a spring boot application, maven used as a build system.

There are 2 quick alternative ways to run the app in a Windows PC. The things to do to run the application on other operating systems such as Unix, MacOs etc. are similar.

1. CLI
    - Open a terminal in a suitable directory.
    - Clone the repository.
        - ```git clone https://github.com/mstftikir/contactlist.git```
    - Go inside of the directory
        - ```cd contactlist```
    - Run the app (make sure JAVA_HOME eviroment variable is being set.)
        - ```mvnw spring-boot:run```
2. IntelliJ
    - Open IntelliJ startup page
        - ![](readme-resources/IntelliJStartUpPage.PNG)
    - Clone repository
        - ![](readme-resources/IntelliJClone.PNG)
    - Run the main class
        - ![](readme-resources/IntelliJRunApp.PNG)

## <a name="test"></a>Test

1. After the application run, it is going to be avaliable in:
    - ```http://localhost:8080/```
        - ![](readme-resources/ContactListPageTop.PNG)
        - ![](readme-resources/ContactListPageBottom.PNG)
2. Rest address which gets all contacts:
    - ```http://localhost:8080/api/v1/contacts```
3. h2-console is a web app that H2 db records is availeble to be queried. T_CONTACT table is created at start up and filled out with data in people.csv
    - ``` http://localhost:8080/h2-console ```

## <a name="technology-stack"></a>Technology Stack

The application developed in a Windows 10 PC via IntelliJ Ultimate 2019.3 IDE.

1. Front End

    - [JQuery 3.5.1](https://jquery.com/)
    - [Datatables for JQuery](https://datatables.net/)
    - [MDBootstrap JQuery](https://mdbootstrap.com/docs/b4/jquery/)
    - [Bootstrap 4.5.0](https://getbootstrap.com/)
    - [Fontawsome 5.15.1](https://fontawesome.com/)
    - [Popper 1.14.7](https://popper.js.org/)
    - [HTML5](https://www.w3schools.com/html/)
    - [CSS3](https://www.w3schools.com/css/)

2. Back End
    - [Spring Boot 2.4.1](https://spring.io/projects/spring-boot)
    - Spring Web
    - Spring Thymeleaf
    - Spring Tomcat
    - Spring JPA
    - Spring Cache
    - Spring Securiry
    - Spring Test
    - JUnit 4/5
    - Mockito

3. Database
    - H2 In Memory DB
    - Hibernate
    - Oracle DB
        - <b>Switchable from h2 to Oracle via spring profile in application.properties.</b>

## <a name="architecture"></a>Architecture

tbd

