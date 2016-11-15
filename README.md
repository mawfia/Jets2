# Jets2 Project
2nd Individual Project in Quad 2 created 4 November 2016

GENERAL USAGE NOTES:
--------------------
This was my first Spring/MVC CRUD project designed, built, and deployed to cloud services from scratch and in five days.
It is a revist of of my original Jets project, but in concept only.  All design and logic were independent of the original project.

-The purpose of Jets2 is to provide a user the ability to store aircraft information through creation, reading, updating and 
removal of aircraft in their inventory.

-A user is able to click next and previous buttons to scroll through the aircraft inventory ordered by tail number each with a picture.

-The user is also able to jump to a specific aircraft in the inventory by entering in or selecting the aircraft's tail number.

-Currently only a photo and tail number is displed on the main hanger page (will be revised). On the "update" page the user can view each aircraft's 
tail number, manufacturer, model, speed, range, price, fuel capacity, and a single photo.

-On the main page the user may view the inventory sorted in alphabetical/reverse alphabetical order, by tail number, and assigned pilot.

-The user will also have the ability to search for a specific aircraft or pilot by entering a keyword, whereby they can narrow the search to tail number, manufactuer, model, speed, price range, fuel capacity or pilot.

-The user is also able to add and remove aircraft from the inventory as well as update aircraft currently in the inventory.  Aircraft that are added will assigned a tail number if one is not provided as well as a default photo.

-Finally, the user can return to the original list of aircaft by clicking the home button.

****I plan to continue to upate and revise this application due to my personal interest in aviation.  I will add user accounts and logins, the ability for the user to add photos to their account for the wallpaper and aircraft, as well as pick a geographic location for their hanger.

TECHNOLOGY USED:
-----------------
1.  All back-end logic and data storage was executed using Java.

2.  Search and sort features were implemented using Java8 Lambda Expressions.

3.  Maven was used to manage the libries for XML dependencies.

4.  Front-end operations such as regular expressions for exception prevention and dynamically populated fields and drop-down lists were implemented using HTML5 and CSS.

5.  Apache Tomcat is used as the server for execution and JSP and JSPTL handle client requets.

6.  Spring/MVC is the framework used for dyanmic managment of objects.

7.  The application is deployed on a AWS account for cloud services.

This web application may be viewed at: http://mawfia.com:8080/Jets2

Current maintainers:
 * Michael Williams (SD7)

This project has been sponsored by:
Skill Distillery, a Division of Batky-Howell, LLC
http://skilldistillery.com/