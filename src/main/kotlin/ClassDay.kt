/**
 * ClassDay class
 * This class represents a single day of class for a student
 * Every student has a list of ClassDay objects
 * @see Student
 */
class ClassDay(private val date: Date) {
    private var note: String = ""
    private var activity: ActivityLevel? = null
    private var hasHomework: Boolean? = null
    private var interruptsClass: Boolean? = null

    /**
     * Secondary constructor for ClassDay
     *
     * @param date date of the class day
     * @param note note for the student on the class day
     * @param activity activity level of the student on the class day
     * @param hasHomework whether the student has homework on the class day
     * @param interruptsClass whether the student interrupts the class on the class day
     */
    constructor(
        date: Date,
        note: String,
        activity: ActivityLevel,
        hasHomework: Boolean,
        interruptsClass: Boolean
    ) : this(date) {
        this.note = note
        this.activity = activity
        this.hasHomework = hasHomework
        this.interruptsClass = interruptsClass
    }

    /**
     * Getter for date
     *
     * @return date of the class day
     */
    fun getDate(): Date {
        return date
    }

    /**
     * Getter for note
     *
     * @return note for the student on the class day
     */
    fun getNote(): String {
        return note
    }

    /**
     * Setter for note
     *
     * @param note note for the student on the class day
     */
    fun setNote(note: String) {
        this.note = note
    }

    /**
     * Getter for activity
     *
     * @return activity level of the student on the class day
     */
    fun getActivity(): ActivityLevel? {
        return activity
    }

    /**
     * Setter for activity
     *
     * @param activity activity level of the student on the class day
     */
    fun setActivity(activity: ActivityLevel) {
        this.activity = activity
    }

    /**
     * Getter for hasHomework
     *
     * @return whether the student has homework on the class day
     */
    fun getHasHomework(): Boolean? {
        return hasHomework
    }

    /**
     * Setter for hasHomework
     *
     * @param hasHomework whether the student has homework on the class day
     */
    fun setHasHomework(hasHomework: Boolean) {
        this.hasHomework = hasHomework
    }

    /**
     * Getter for interruptsClass
     *
     * @return whether the student interrupts the class on the class day
     */
    fun getInterruptsClass(): Boolean? {
        return interruptsClass
    }

    /**
     * Setter for interruptsClass
     *
     * @param interruptsClass whether the student interrupts the class on the class day
     */
    fun setInterruptsClass(interruptsClass: Boolean) {
        this.interruptsClass = interruptsClass
    }

    fun getFormattedClassDay(): String {
        var toReturn = date.toString()
        toReturn += "\nNote: $note"
        toReturn += "\nActivity: $activity"
        toReturn += "\nHas Homework: $hasHomework"
        toReturn += "\nInterrupts Class: $interruptsClass"
        return toReturn
    }

    /**
     * Returns a string representation of the ClassDay object
     *
     * @return string representation of the ClassDay object
     */
    override fun toString(): String {
        return "$date<<<>>>$note<<<>>>$activity<<<>>>$hasHomework<<<>>>$interruptsClass"
    }

}