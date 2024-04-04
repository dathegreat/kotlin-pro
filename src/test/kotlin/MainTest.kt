import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class MainTest {

    @Test
    fun getRandomFactReceivesAString() {
        return assert(getRandomFact().text.isNotEmpty())
    }

    @Test
    fun iGetHiredForThisJob() {
        return assert(true)
    }
}