
package io.github.andrewfitzy.day22

import getFileContentForDay
import kotlin.test.Test
import kotlin.test.assertEquals

class TestTask01 {
    @Test fun testSolveWithDemoData_01() {
        // Given
        val fileContent =
            listOf(
                "root@ebhq-gridcenter# df -h",
                "Filesystem              Size  Used  Avail  Use%",
                "/dev/grid/node-x0-y0     88T   66T    22T   75%",
                "/dev/grid/node-x0-y1     85T   65T    20T   76%",
                "/dev/grid/node-x0-y2     88T   67T    21T   76%",
                "/dev/grid/node-x1-y0     92T   68T    24T   73%",
                "/dev/grid/node-x1-y1     87T    0T    87T    0%",
                "/dev/grid/node-x1-y2     90T   64T    26T   71%",
                "/dev/grid/node-x2-y0     85T   64T    21T   75%",
                "/dev/grid/node-x2-y1     93T   66T    27T   70%",
                "/dev/grid/node-x2-y2     90T   69T    21T   76%",
            )
        val classUnderTest = Task01(fileContent)

        // When
        val result = classUnderTest.solve()

        // Then
        assertEquals(8, result)
    }

    // @Test
    fun testSolveWithRealDate_01() {
        // Given
        val fileContent = getFileContentForDay("22")
        val classUnderTest = Task01(fileContent)

        // When
        val result = classUnderTest.solve()

        // Then
        assertEquals(1034, result)
    }
}
