package functionalPrograming;

import org.junit.Test;

import static functionalPrograming.ListModule.*;
import static org.junit.Assert.assertEquals;

/**
 * Created by hoons on 2014-10-21.
 */
public class ListTest {
    List<String> EMPTYLS = emptyList(); // 문자열 파라미터는 추론되었다!
    List<Long> EMPTYLL = emptyList();

    @Test(expected = EmptyListHasNoHead.class) // Test01
    public void callingHeadOnAnEmptyListRaises() {
        EMPTYLS.head();
    }

    @Test(expected = ListModule.EmptyListHasNoTail.class) // Test02
    public void callingTailOnAnEmptyListRaises() {
        EMPTYLS.tail();
    }

    @Test // Test03
    public void callingTailOnAListWithMultiplElementsReturnsANonEmptyList() {
        List<String> tail = list("one", list("two", EMPTYLS)).tail();
        assertEquals(list("two", EMPTYLS), tail);
    }

    @Test // Test04
    public void callingHeadOnANonEmptyListReturnsTheHead() {
        String head = list("one", EMPTYLS).head();
        assertEquals("one", head);
    }

    @Test // Test05
    public void AllEmptyListsAreEqual() {
        assertEquals(EMPTYLS, EMPTYLL);
    }

    @Test // Test06
    public void ListsAreRecursiveStructures() {
        List<String> list1 = list("one", list("two", list("three", EMPTYLS)));
        assertEquals("(one, (two, (three, ())))", list1.toString());
    }
}
