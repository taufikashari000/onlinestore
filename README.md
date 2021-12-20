# onlinestore

Based on situation, I think you run into this problem because there is no mechanism to track products quantity. Therefore, you're going to need a system which does the job and don't worry, I'll provide it.

All you need to do is sit down an relax and, hopefully, java and maven already installed in your computer.
If so, you have to clone this project then run it on your local machine by typing in terminal:
mvn clean install spring-boot:run or mvn clean install spring-boot:run -Dmaven.test.skip=true

Before that, make sure to execute these SQL commands:

CREATE DATABASE onlinestore;

CREATE TABLE products(id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT, name VARCHAR(255) NOT NULL, price INT  NOT NULL, quantity INT NOT NULL, PRIMARY KEY(id));

