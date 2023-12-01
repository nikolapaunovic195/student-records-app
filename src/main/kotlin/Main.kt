import java.io.File

fun main() {
    // Creates a 'data' folder if it doesn't exist
    val dataFolder = File("data")
    if (!dataFolder.exists()) {
        dataFolder.mkdir()
    }

    // Starts console UI
    startConsoleUI()
}

/**
 * Converts a string to an activity level
 * @param activity string to convert
 * @return activity level
 */
fun stringToActivityLevel(activity: String): ActivityLevel {
    return when (activity) {
        "ABSENT" -> ActivityLevel.ABSENT
        "INATTENTIVE" -> ActivityLevel.INATTENTIVE
        "PASSIVE" -> ActivityLevel.PASSIVE
        "ACTIVE" -> ActivityLevel.ACTIVE
        "VERY_ACTIVE" -> ActivityLevel.VERY_ACTIVE
        else -> ActivityLevel.ABSENT
    }
}

/**
 * Loads a list of students from a file
 * @return list of students
 */
fun loadStudents(): MutableList<Student> {
    val studentsFile = File("data/students.txt")
    val students = mutableListOf<Student>()
    if (studentsFile.exists()) {
        studentsFile.forEachLine {
            val student = Student(it)
            students.add(student)
        }
    } else {
        studentsFile.createNewFile()
    }
    return students
}

/**
 * Saves a list of students to a file
 */
fun saveStudents(students: MutableList<Student>) {
    val studentsFile = File("data/students.txt")
    studentsFile.writeText("")
    students.forEach {
        studentsFile.appendText("${it.getName()}\n")
    }
}

/**
 * Converts a string to a Date
 * @param date string to convert
 * @return date
 */
fun stringToDate(date: String): Date {
    val dateSplit = date.split("/")
    val month = dateSplit[0].toInt()
    val day = dateSplit[1].toInt()
    val year = dateSplit[2].toInt()
    return Date(month, day, year)
}

/**
 * Converts a string to a boolean
 * @param string string to convert
 * @return boolean
 */
fun convertStringToBoolean(string: String): Boolean {
    return when (string) {
        "true" -> true
        "false" -> false
        else -> false
    }
}