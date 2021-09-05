package anaydis.sort;

import org.junit.Test;

public class TestPractice04 extends SorterTest{


    /** Test MergeSorter TopDown with String generator. */
    @Test
    public void testMergeTopDownWithStringGenerator() {
        testSorter(createStringDataSetGenerator(), SorterType.MERGE_TOP_DOWN, 10);
        testSorter(createStringDataSetGenerator(), SorterType.MERGE_TOP_DOWN, 50);
        testSorter(createStringDataSetGenerator(), SorterType.MERGE_TOP_DOWN, 100);
    }
    /** Test MergeSorter TopDown with String generator. */
    @Test public void testMergeTopDownWithIntegerGenerator() {
        testSorter(createIntegerDataSetGenerator(), SorterType.MERGE_TOP_DOWN, 10);
        testSorter(createIntegerDataSetGenerator(), SorterType.MERGE_TOP_DOWN, 50);
        testSorter(createIntegerDataSetGenerator(), SorterType.MERGE_TOP_DOWN, 100);
    }
    /** Test MergeSorter TopDown with String generator. */
    @Test public void testMergeBottomUpWithStringGenerator() {
        testSorter(createStringDataSetGenerator(), SorterType.MERGE_BOTTOM_UP, 10);
        testSorter(createStringDataSetGenerator(), SorterType.MERGE_BOTTOM_UP, 50);
        testSorter(createStringDataSetGenerator(), SorterType.MERGE_BOTTOM_UP, 100);
    }
    /** Test MergeSorter TopDown with String generator. */
    @Test public void testMergeBottomUpWithIntegerGenerator() {
        testSorter(createIntegerDataSetGenerator(), SorterType.MERGE_BOTTOM_UP, 10);
        testSorter(createIntegerDataSetGenerator(), SorterType.MERGE_BOTTOM_UP, 50);
        testSorter(createIntegerDataSetGenerator(), SorterType.MERGE_BOTTOM_UP, 100);
    }
}
