/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package staircase;

import org.junit.Test;
import java.util.*;
import static org.junit.Assert.*;

public class StairCaseTest {
    

    @Test public void test_CountWays() {
        StairCase stairCase = new StairCase();
        assertEquals(5, stairCase.countWays(4));
    }

    @Test public void test_GetWays() {
        StairCase stairCase = new StairCase();
        List<List<Integer>> ways = stairCase.getWays(4);
		assertEquals(5, ways.size());
    }
}
