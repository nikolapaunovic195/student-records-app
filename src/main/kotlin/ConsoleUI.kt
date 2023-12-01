fun startConsoleUI() {
    val students = loadStudents()
    println("Welcome to the Student Record System! (v0.1.0)\nThis program is currently console-only.\n")
    val language = chooseLanguage()
    printMenu(language)
    var input = readln()
    while (input != "0") {
        when (input) {
            "1" -> {
                val newStudent = doAddStudent(language)
                students.add(newStudent)
            }

            "2" -> {
                doDisplayStudentRecord(students, language)
            }

            "3" -> {
                doAddClassDay(students, language)
            }

            else -> {
                println("Invalid input. Please try again.")
            }
        }
        printMenu(language)
        input = readln()
    }
    // Saving the students' class days to files
    println("Saving list of students...")
    saveStudents(students)
    println("Saving students' class days...")
    students.forEach {
        it.saveClassDays()
    }
    println("Goodbye!")
}

/**
 * Prompts the user to choose a language
 * @return language
 */
private fun chooseLanguage(): String {
    println("Choose a language:")
    println("1. English")
    // Check for valid input
    var input = readln()
    while (input != "1") {
        println("Invalid input. Please try again.")
        input = readln()
    }
    return when (input) {
        "1" -> "en"
        else -> "xx"
    }
}

/**
 * Prints the main menu
 * @param language language to print the menu in
 */
private fun printMenu(language: String) {
    when (language) {
        "en" -> {
            println("Choose an option:")
            println("1. Add a student")
            println("2. View a student's record")
            println("3. Add a class day to a student's record")
            println("0. Exit")
        }

        else -> {
            println("Invalid language")
        }
    }
}

/**
 * Prompts the user to add a student
 * @param language language to print the menu in
 */
private fun doAddStudent(language: String): Student {
    val student: Student
    when (language) {
        "en" -> {
            println("Enter the student's name:")
            val name = readln()
            student = Student(name)
            println("Student added!")
        }

        else -> {
            println("Invalid language")
            student = Student("X X")
        }
    }
    return student
}

/**
 * Prompts the user to display a student's record
 * @param students list of students
 * @param language language to print the menu in
 */
private fun doDisplayStudentRecord(students: MutableList<Student>, language: String) {
    when (language) {
        "en" -> {
            println("Enter the student's name:")
            val name = readln()
            val student = students.find { it.getName() == name }
            if (student != null) {
                println("Student found!")
                println("Name: ${student.getName()}")
                println("Class days:")
                println(student.getFormattedClassDays())
            } else {
                println("Student not found.")
            }
        }

        else -> {
            println("Invalid language")
        }
    }
}

/**
 * Prompts the user to add a class day to a student's record
 * @param students list of students
 * @param language language to print the menu in
 */
private fun doAddClassDay(students: MutableList<Student>, language: String) {
    when (language) {
        "en" -> {
            println("Enter the student's name:")
            val name = readln()
            val student = students.find { it.getName() == name }
            if (student != null) {
                println("Student found!")
                println("Enter the date of the class day (DD/MM/YYYY):")
                val date = readln()
                println("Enter a note for the class day:")
                val note = readln()
                println("Enter the activity level of the student on the class day:")
                println("ABSENT")
                println("INATTENTIVE")
                println("PASSIVE")
                println("ACTIVE")
                println("VERY_ACTIVE")
                val activity = readln()
                println("Did the student have homework on the class day? (true/false)")
                val hasHomework = readln()
                println("Did the student interrupt the class on the class day? (true/false)")
                val interruptsClass = readln()
                // Convert the strings to their respective types
                val dateObj = stringToDate(date)
                val activityLevel = stringToActivityLevel(activity)
                val hasHomeworkBool = convertStringToBoolean(hasHomework)
                val interruptsClassBool = convertStringToBoolean(interruptsClass)
                // Create a ClassDay object and add it to the list
                val classDay = ClassDay(dateObj, note, activityLevel, hasHomeworkBool, interruptsClassBool)
                student.addClassDay(classDay)
                println("Class day added!")
            } else {
                println("Student not found.")
            }
        }

        else -> {
            println("Invalid language")
        }
    }
}