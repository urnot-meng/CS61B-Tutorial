package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
    // YOUR TESTS HERE
    @Test
    public void testThreeAddThreeRemove() {
        AListNoResizing<Integer> aTest = new AListNoResizing<>();
        BuggyAList<Integer> bTest = new BuggyAList<>();
        aTest.addLast(4);
        aTest.addLast(5);
        aTest.addLast(6);
        bTest.addLast(4);
        bTest.addLast(5);
        bTest.addLast(6);
        assertEquals(aTest.removeLast(), bTest.removeLast());
        assertEquals(aTest.removeLast(), bTest.removeLast());
        assertEquals(aTest.removeLast(), bTest.removeLast());
    }

    @Test
    public void randomizedTest() {
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> B = new BuggyAList<>();

        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                B.addLast(randVal);
            } else if (operationNumber == 1) {
                // size
                assertEquals(L.size(), B.size());
            } else if (operationNumber == 2 && L.size() > 0) {
                // getLast
                assertEquals(L.getLast(), B.getLast());
            } else if (operationNumber == 3 && L.size() > 0) {
                // removeLast
                assertEquals(L.removeLast(), B.removeLast());
            }
        }
    }
}
