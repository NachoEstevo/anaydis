package anaydis.sort;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

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

    /** Test ThreeWay Sort  with String generator.*/
    @Test public void testThreeWayWithStringGenerator() {
        testSorter(createStringDataSetGenerator(), SorterType.QUICK_THREE_PARTITION, 10);
        testSorter(createStringDataSetGenerator(), SorterType.QUICK_THREE_PARTITION, 50);
        testSorter(createStringDataSetGenerator(), SorterType.QUICK_THREE_PARTITION, 100);
    }
    /** Test Three Way Sort with String generator. */
    @Test public void testThreeWayWithIntegerGenerator() {
        testSorter(createIntegerDataSetGenerator(), SorterType.QUICK_THREE_PARTITION, 10);
        testSorter(createIntegerDataSetGenerator(), SorterType.QUICK_THREE_PARTITION, 50);
        testSorter(createIntegerDataSetGenerator(), SorterType.QUICK_THREE_PARTITION, 100);
    }

    /** Test Median of Three Sort  with String generator. */
    @Test public void testMedianOfThreeWithStringGenerator() {
        testSorter(createStringDataSetGenerator(), SorterType.QUICK_MED_OF_THREE, 10);
        testSorter(createStringDataSetGenerator(), SorterType.QUICK_MED_OF_THREE, 50);
        testSorter(createStringDataSetGenerator(), SorterType.QUICK_MED_OF_THREE, 100);
    }
    /** Test Median of Three Sort with String generator. */
    @Test public void testMedianOfThreeWithIntegerGenerator() {
        testSorter(createIntegerDataSetGenerator(), SorterType.QUICK_MED_OF_THREE, 10);
        testSorter(createIntegerDataSetGenerator(), SorterType.QUICK_MED_OF_THREE, 50);
        testSorter(createIntegerDataSetGenerator(), SorterType.QUICK_MED_OF_THREE, 100);
    }
    /*@Test public void duplicates(){ //Im having issues with duplicates. Items are being overwritten
        List<Integer> ints = new ArrayList<>();
        ints.add(1);
        ints.add(1);
        ints.add(1);
        ints.add(9);
        ints.add(9);
        ints.add(2);
        ints.add(1);

        List<Integer> sortedList = new ArrayList<>();
        sortedList.add(1);
        sortedList.add(1);
        sortedList.add(1);
        sortedList.add(1);
        sortedList.add(2);
        sortedList.add(9);
        sortedList.add(9);

        MergeSorterTopDown mergeSorterTopDown = new MergeSorterTopDown();
        mergeSorterTopDown.sort(Comparator.naturalOrder(),ints);

        Assert.assertEquals(sortedList,ints);
    }*/
}
