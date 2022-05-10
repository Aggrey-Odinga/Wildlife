## WILDLIFE TRACKER APP

## Author's Information


<p>Authors name: Aggrey Odinga.</p>

Github link to my site [Aggrey Odinga](https://github.com/Aggrey-Odinga).


## Project Description

<p>Wildlife Tracker is an application that enables rangers to record sightings in an area.</p>

<p>The application was created for Forest Service, a company that is considering to clear a nearby forest.</p>

<p>It enables a user to record details of the ranger, spotted animal and location.</p>

<p>The records are saved in a database.</p>

## Project Set Up Instructions

To set up this project:
- Clone the repository link. 
- Navigate into the wildlife-tracker directory - `cd wildlife-tracker`
- Run `gradle build` to build the project.

## Database Set Up Instructions

To set up the database:
- Run `psql` in the project terminal.
- Type the command: `CREATE DATABASE wildlife_tracker;`
- Navigate into the database by typing the command: `\c wildlife_tracker;`
- Create the required tables by running the following commands:
    - `CREATE TABLE rangers (id serial PRIMARY KEY, name VARCHAR, badge_number INT,phone_number int,email VARCHAR);`
  - `CREATE TABLE regular_animals(id serial PRIMARY KEY,type VARCHAR, name varchar, age VARCHAR);`
  - `CREATE TABLE endangered_animals(id serial PRIMARY KEY,type VARCHAR, name varchar, age VARCHAR, health VARCHAR);`
  - `CREATE TABLE sightings (id serial PRIMARY KEY,ranger_id INT, animal_id INT, location_id INT,time TIMESTAMP);`
- Create a test database by typing the command: `CREATE DATABASE wildlife_tracker_test WITH TEMPLATE wildlife_tracker;`

## Technologies Used:

- Java.
- Spark.
- Gradle.
- CSS.
- Bootstrap.

## Contact Information

- Email me at: aggreyodinga@gmail.com

## [License](https://github.com/Aggrey-Odinga/Hero/blob/master/LICENSE)