# Student Records App (v0.1.0)

#### Author: Nikola Paunovic

---

## Project Description

The purpose of this project is to create a simple record keeping application for instructors to keep track of students.

The application is currently in a very early stage of development and only supports a console UI in English.
The goal is to support a full GUI in multiple languages.

None of the features are currently fully implemented and will be expanded upon in future versions.
The project currently does not have any unit tests, but they will be added in the future.
The project also includes methods that are not currently used, but might be used in the future.

### Features as of v0.1.0

- Allows the user to create a list of students
- Allows the user to create specific records for each student for a given day
- Allows the user to view the records for each student


## How to Run
This project is written in Kotlin and uses IntelliJ IDEA as the IDE and build tool.
As of the current version, the project is only intended to be run from within the IDE.

The project could either be cloned or downloaded as a zip file and then opened in IntelliJ IDEA.
You may also choose to copy the source code into a new project.
This can be done bu copying all files in the "src/main/kotlin" directory into a new project's source directory.

The program automatically creates a file called "students.txt" in "<project_root_directory>/data".
The data folder is created if it does not exist.