import java.io.File

/**
 * This class represents a student
 * @property name name of the student
 * @property classDays list of class days for the student
 */
class Student(private val name: String) {
    private val classDays: MutableList<ClassDay> = mutableListOf()

    init {
        this.loadClassDays()
    }

    /**
     * Getter for name
     * @return name of the student
     */
    fun getName(): String {
        return name
    }

    /**
     * Loads a student's class days from a file
     */
    private fun loadClassDays() {
        val studentRecord = File("data/${this.name}.txt")

        // If the file exists, load the data from it
        if (studentRecord.exists()) {
            println("Loading record for ${this.name}...")
            // Read the file line by line
            studentRecord.forEachLine {
                val daySplit = it.split("<<<>>>")
                val date = daySplit[0]
                val note = daySplit[1]
                val activity = daySplit[2]
                val hasHomework = daySplit[3]
                val interruptsClass = daySplit[4]

                // Convert the strings to their respective types
                val dateObj = stringToDate(date)
                val activityLevel = stringToActivityLevel(activity)
                val hasHomeworkBool = convertStringToBoolean(hasHomework)
                val interruptsClassBool = convertStringToBoolean(interruptsClass)

                // Create a ClassDay object and add it to the list
                val classDay = ClassDay(dateObj, note, activityLevel, hasHomeworkBool, interruptsClassBool)
                classDays.add(classDay)
            }
        } else { // Otherwise, create a new file
            println("No record found for ${this.name}. Creating new file...")
            studentRecord.createNewFile()
        }
    }

    /**
     * Saves a student's class days to a file
     */
    fun saveClassDays() {
        val studentRecord = File("data/${this.name}.txt")
        studentRecord.writeText("")
        // Write each class day to the file
        classDays.forEach {
            studentRecord.appendText(it.toString() + "\n")
        }
    }

    /**
     * Adds a class day to the student's record
     * @param classDay class day to add
     */
    fun addClassDay(classDay: ClassDay) {
        classDays.add(classDay)
    }

    /**
     * Returns a ClassDay object for a given date
     * @param date date to search for as a string
     * @return ClassDay object
     */
    fun getClassByDate(date: String): ClassDay? {
        val classDay = classDays.find { it.getDate().toString().equals(date) }
        return classDay
    }

    /**
     * Returns a string of all the student's class days
     */
    fun getFormattedClassDays(): String {
        var formattedClassDays = ""
        classDays.forEach {
            formattedClassDays += "${it.getFormattedClassDay()}\n\n"
        }
        return formattedClassDays
    }
}