/**
 * The Date class represents a date. It contains the day, month and year.
 * @property day The day of the date.
 * @property month The month of the date.
 * @property year The year of the date.
 * @constructor Creates a date with the given day, month and year.
 */
class Date(private val day: Int, private val month: Int, private val year: Int) {
    init {
        // Check if the date is valid.
        require(day in 1..31) { "Invalid day: $day" }
        require(month in 1..12) { "Invalid month: $month" }
        require(year >= 0) { "Invalid year: $year" }
        if (day == 31 && month in setOf(2, 4, 6, 9, 11)) {
            throw IllegalArgumentException("Invalid day $day for month $month")
        } else if (day == 30 && month == 2) {
            throw IllegalArgumentException("Invalid day $day for month $month")
        } else if (day == 29 && month == 2 && !isLeapYear(year)) {
            throw IllegalArgumentException("Invalid day $day for month $month")
        }
    }

    /**
     * Returns a string representation of the date.
     * @return A string representation of the date.
     */
    override fun toString(): String {
        return "$day/$month/$year"
    }

    /**
     * Returns whether the given year is a leap year.
     * @param year The year to check.
     * @return Whether the given year is a leap year.
     */
    private fun isLeapYear(year: Int): Boolean {
        return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)
    }
}