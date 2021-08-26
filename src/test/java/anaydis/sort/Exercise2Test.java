package anaydis.sort;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class Exercise2Test {

    /** Bubble Sorter
     * Average & Worst: O(n^2)
     * Best:  O(N) & O(1) swaps (On Sorted input)
     *
     * Graphed in Python (Jupyter NoteBook) Link:
     * Report  in Juptyter NoteBook
     * **/


    @Test
    public void bubbleSorterWorstTest(){ //For simplicity I'm gonna sort ints
        BubbleSorter bubbleSorter = new BubbleSorter();

        IntegerDataSetGenerator intGenerator = new IntegerDataSetGenerator();
        /** 10 Integers **/
        List<Integer> desc10 = intGenerator.createDescending(10);
        long start = System.nanoTime();
        bubbleSorter.sort(intGenerator.getComparator(),desc10);
        long finish = System.nanoTime();

        long timeTaken = finish - start;
        //Assert.assertTrue(timeTaken < ); How can I compare the O(n^2) with the time taken

        /** 50 Integers **/
        List<Integer> desc50 = intGenerator.createDescending(50);
        start = System.nanoTime();
        bubbleSorter.sort(intGenerator.getComparator(),desc50);
        finish = System.nanoTime();

        timeTaken = finish - start;

        /** 500 Integers **/
        List<Integer> desc500 = intGenerator.createDescending(100);
        start = System.nanoTime();
        bubbleSorter.sort(intGenerator.getComparator(),desc500);
        finish = System.nanoTime();

        timeTaken = finish - start;

        /** 1000 Integers **/
        List<Integer> desc1000 = intGenerator.createDescending(1000);
        start = System.nanoTime();
        bubbleSorter.sort(intGenerator.getComparator(),desc1000);
        finish = System.nanoTime();

        timeTaken = finish - start;

        /** 5000 Integers **/
        List<Integer> desc5000 = intGenerator.createDescending(5000);
        start = System.nanoTime();
        bubbleSorter.sort(intGenerator.getComparator(),desc5000);
        finish = System.nanoTime();

        timeTaken = finish - start;
    }
    @Test
    public void bubbleSorterAverageTest(){ //For simplicity I'm gonna sort ints
        BubbleSorter bubbleSorter = new BubbleSorter();

        IntegerDataSetGenerator intGenerator = new IntegerDataSetGenerator();
        /** 10 Integers **/
        List<Integer> rand10 = intGenerator.createRandom(10);
        long start = System.nanoTime();
        bubbleSorter.sort(intGenerator.getComparator(),rand10);
        long finish = System.nanoTime();

        long timeTaken = finish - start;
        //Assert.assertTrue(timeTaken < ); How can I compare the O(n^2) with the time taken

        /** 50 Integers **/
        List<Integer> rand50 = intGenerator.createRandom(50);
        start = System.nanoTime();
        bubbleSorter.sort(intGenerator.getComparator(),rand50);
        finish = System.nanoTime();

        timeTaken = finish - start;

        /** 500 Integers **/
        List<Integer> rand500 = intGenerator.createRandom(100);
        start = System.nanoTime();
        bubbleSorter.sort(intGenerator.getComparator(),rand500);
        finish = System.nanoTime();

        timeTaken = finish - start;

        /** 1000 Integers **/
        List<Integer> rand1000 = intGenerator.createRandom(1000);
        start = System.nanoTime();
        bubbleSorter.sort(intGenerator.getComparator(),rand1000);
        finish = System.nanoTime();

        timeTaken = finish - start;

        /** 5000 Integers **/
        List<Integer> rand5000 = intGenerator.createRandom(5000);
        start = System.nanoTime();
        bubbleSorter.sort(intGenerator.getComparator(),rand5000);
        finish = System.nanoTime();

        timeTaken = finish - start;

    }
    @Test
    public void bubbleSorterBestTest(){ //For simplicity I'm gonna sort ints
        BubbleSorter bubbleSorter = new BubbleSorter();

        IntegerDataSetGenerator intGenerator = new IntegerDataSetGenerator();
        /** 10 Integers **/
        List<Integer> asc10 = intGenerator.createAscending(10);
        long start = System.nanoTime();
        bubbleSorter.sort(intGenerator.getComparator(),asc10);
        long finish = System.nanoTime();

        long timeTaken = finish - start;
        //Assert.assertTrue(timeTaken < ); How can I compare the O(n^2) with the time taken

        /** 50 Integers **/
        List<Integer> asc50 = intGenerator.createAscending(50);
        start = System.nanoTime();
        bubbleSorter.sort(intGenerator.getComparator(),asc50);
        finish = System.nanoTime();

        timeTaken = finish - start;

        /** 500 Integers **/
        List<Integer> asc500 = intGenerator.createAscending(100);
        start = System.nanoTime();
        bubbleSorter.sort(intGenerator.getComparator(),asc500);
        finish = System.nanoTime();

        timeTaken = finish - start;

        /** 1000 Integers **/
        List<Integer> asc1000 = intGenerator.createAscending(1000);
        start = System.nanoTime();
        bubbleSorter.sort(intGenerator.getComparator(),asc1000);
        finish = System.nanoTime();

        timeTaken = finish - start;

        /** 5000 Integers **/
        List<Integer> asc5000 = intGenerator.createAscending(5000);
        start = System.nanoTime();
        bubbleSorter.sort(intGenerator.getComparator(),asc5000);
        finish = System.nanoTime();

        timeTaken = finish - start;
    }

    /** Insertion Sorter
     * Best Case:    O(N) & O(1) swaps
     * Worst Case:   O(N2) & O(N2) swaps
     * Average Case: O(N2) & O(N2) swaps **/

    @Test
    public void insertionSorterBestTest(){ //For simplicity I'm gonna sort ints
        InsertionSorter insertionSorter = new InsertionSorter();

        IntegerDataSetGenerator intGenerator = new IntegerDataSetGenerator();
        /** 10 Integers **/
        List<Integer> asc10 = intGenerator.createAscending(10);
        long start = System.nanoTime();
        insertionSorter.sort(intGenerator.getComparator(),asc10);
        long finish = System.nanoTime();

        long timeTaken = finish - start;
        //Assert.assertTrue(timeTaken < ); How can I compare the O(n^2) with the time taken

        /** 50 Integers **/
        List<Integer> asc50 = intGenerator.createAscending(50);
        start = System.nanoTime();
        insertionSorter.sort(intGenerator.getComparator(),asc50);
        finish = System.nanoTime();

        timeTaken = finish - start;

        /** 500 Integers **/
        List<Integer> asc500 = intGenerator.createAscending(100);
        start = System.nanoTime();
        insertionSorter.sort(intGenerator.getComparator(),asc500);
        finish = System.nanoTime();

        timeTaken = finish - start;

        /** 1000 Integers **/
        List<Integer> asc1000 = intGenerator.createAscending(1000);
        start = System.nanoTime();
        insertionSorter.sort(intGenerator.getComparator(),asc1000);
        finish = System.nanoTime();

        timeTaken = finish - start;

        /** 5000 Integers **/
        List<Integer> asc5000 = intGenerator.createAscending(5000);
        start = System.nanoTime();
        insertionSorter.sort(intGenerator.getComparator(),asc5000);
        finish = System.nanoTime();

        timeTaken = finish - start;

    }
    @Test
    public void insertionSorterWorstTest(){ //For simplicity I'm gonna sort ints
       InsertionSorter insertionSorter = new InsertionSorter();

        IntegerDataSetGenerator intGenerator = new IntegerDataSetGenerator();

        /** 10 Integers **/
        List<Integer> desc10 = intGenerator.createDescending(10);
        long start = System.nanoTime();
        insertionSorter.sort(intGenerator.getComparator(),desc10);
        long finish = System.nanoTime();

        long timeTaken = finish - start;
        //Assert.assertTrue(timeTaken < ); How can I compare the O(n^2) with the time taken

        /** 50 Integers **/
        List<Integer> desc50 = intGenerator.createDescending(50);
        start = System.nanoTime();
        insertionSorter.sort(intGenerator.getComparator(),desc50);
        finish = System.nanoTime();

        timeTaken = finish - start;

        /** 500 Integers **/
        List<Integer> desc500 = intGenerator.createDescending(100);
        start = System.nanoTime();
        insertionSorter.sort(intGenerator.getComparator(),desc500);
        finish = System.nanoTime();

        timeTaken = finish - start;

        /** 1000 Integers **/
        List<Integer> desc1000 = intGenerator.createDescending(1000);
        start = System.nanoTime();
        insertionSorter.sort(intGenerator.getComparator(),desc1000);
        finish = System.nanoTime();

        timeTaken = finish - start;

        /** 5000 Integers **/
        List<Integer> desc5000 = intGenerator.createDescending(5000);
        start = System.nanoTime();
        insertionSorter.sort(intGenerator.getComparator(),desc5000);
        finish = System.nanoTime();

        timeTaken = finish - start;

    }
    @Test
    public void insertionSorterAverageTest(){ //For simplicity I'm gonna sort ints
        InsertionSorter insertionSorter = new InsertionSorter();
        IntegerDataSetGenerator intGenerator = new IntegerDataSetGenerator();
        /** 10 Integers **/
        List<Integer> rand10 = intGenerator.createRandom(10);
        long start = System.nanoTime();
        insertionSorter.sort(intGenerator.getComparator(),rand10);
        long finish = System.nanoTime();

        long timeTaken = finish - start;
        //Assert.assertTrue(timeTaken < ); How can I compare the O(n^2) with the time taken

        /** 50 Integers **/
        List<Integer> rand50 = intGenerator.createRandom(50);
        start = System.nanoTime();
        insertionSorter.sort(intGenerator.getComparator(),rand50);
        finish = System.nanoTime();

        timeTaken = finish - start;

        /** 500 Integers **/
        List<Integer> rand500 = intGenerator.createRandom(100);
        start = System.nanoTime();
        insertionSorter.sort(intGenerator.getComparator(),rand500);
        finish = System.nanoTime();

        timeTaken = finish - start;

        /** 1000 Integers **/
        List<Integer> rand1000 = intGenerator.createRandom(1000);
        start = System.nanoTime();
        insertionSorter.sort(intGenerator.getComparator(),rand1000);
        finish = System.nanoTime();

        timeTaken = finish - start;

        /** 5000 Integers **/
        List<Integer> rand5000 = intGenerator.createRandom(5000);
        start = System.nanoTime();
        insertionSorter.sort(intGenerator.getComparator(),rand5000);
        finish = System.nanoTime();

        timeTaken = finish - start;

    }
    /** Selection Sorter
     * Best Case     O(N2) & O(1) swaps
     * Worst Case    O(N2) & O(N) swaps
     * Average Case  O(N2) & O(N) swaps**/

    @Test
    public void selectionSorterBestTest(){ //For simplicity I'm gonna sort ints
        SelectionSorter selectionSorter = new SelectionSorter();

        IntegerDataSetGenerator intGenerator = new IntegerDataSetGenerator();
        /** 10 Integers **/
        List<Integer> asc10 = intGenerator.createAscending(10);
        long start = System.nanoTime();
        selectionSorter.sort(intGenerator.getComparator(),asc10);
        long finish = System.nanoTime();

        long timeTaken = finish - start;
        //Assert.assertTrue(timeTaken < ); How can I compare the O(n^2) with the time taken

        /** 50 Integers **/
        List<Integer> asc50 = intGenerator.createAscending(50);
        start = System.nanoTime();
        selectionSorter.sort(intGenerator.getComparator(),asc50);
        finish = System.nanoTime();

        timeTaken = finish - start;

        /** 500 Integers **/
        List<Integer> asc500 = intGenerator.createAscending(100);
        start = System.nanoTime();
        selectionSorter.sort(intGenerator.getComparator(),asc500);
        finish = System.nanoTime();

        timeTaken = finish - start;

        /** 1000 Integers **/
        List<Integer> asc1000 = intGenerator.createAscending(1000);
        start = System.nanoTime();
        selectionSorter.sort(intGenerator.getComparator(),asc1000);
        finish = System.nanoTime();

        timeTaken = finish - start;

        /** 5000 Integers **/
        List<Integer> asc5000 = intGenerator.createAscending(5000);
        start = System.nanoTime();
        selectionSorter.sort(intGenerator.getComparator(),asc5000);
        finish = System.nanoTime();

        timeTaken = finish - start;


    }
    @Test
    public void selectionSorterWorstTest(){ //For simplicity I'm gonna sort ints
        SelectionSorter selectionSorter = new SelectionSorter();

        IntegerDataSetGenerator intGenerator = new IntegerDataSetGenerator();
        /** 10 Integers **/
        List<Integer> desc10 = intGenerator.createDescending(10);
        long start = System.nanoTime();
        selectionSorter.sort(intGenerator.getComparator(),desc10);
        long finish = System.nanoTime();

        long timeTaken = finish - start;
        //Assert.assertTrue(timeTaken < ); How can I compare the O(n^2) with the time taken

        /** 50 Integers **/
        List<Integer> desc50 = intGenerator.createDescending(50);
        start = System.nanoTime();
        selectionSorter.sort(intGenerator.getComparator(),desc50);
        finish = System.nanoTime();

        timeTaken = finish - start;

        /** 500 Integers **/
        List<Integer> desc500 = intGenerator.createDescending(100);
        start = System.nanoTime();
        selectionSorter.sort(intGenerator.getComparator(),desc500);
        finish = System.nanoTime();

        timeTaken = finish - start;

        /** 1000 Integers **/
        List<Integer> desc1000 = intGenerator.createDescending(1000);
        start = System.nanoTime();
        selectionSorter.sort(intGenerator.getComparator(),desc1000);
        finish = System.nanoTime();

        timeTaken = finish - start;

        /** 5000 Integers **/
        List<Integer> desc5000 = intGenerator.createDescending(5000);
        start = System.nanoTime();
        selectionSorter.sort(intGenerator.getComparator(),desc5000);
        finish = System.nanoTime();

        timeTaken = finish - start;


    }
    @Test
    public void selectionSorterAverageTest(){ //For simplicity I'm gonna sort ints
        SelectionSorter selectionSorter = new SelectionSorter();
        IntegerDataSetGenerator intGenerator = new IntegerDataSetGenerator();
        /** 10 Integers **/
        List<Integer> rand10 = intGenerator.createRandom(10);
        long start = System.nanoTime();
        selectionSorter.sort(intGenerator.getComparator(),rand10);
        long finish = System.nanoTime();

        long timeTaken = finish - start;
        //Assert.assertTrue(timeTaken < ); How can I compare the O(n^2) with the time taken

        /** 50 Integers **/
        List<Integer> rand50 = intGenerator.createRandom(50);
        start = System.nanoTime();
        selectionSorter.sort(intGenerator.getComparator(),rand50);
        finish = System.nanoTime();

        timeTaken = finish - start;

        /** 500 Integers **/
        List<Integer> rand500 = intGenerator.createRandom(100);
        start = System.nanoTime();
        selectionSorter.sort(intGenerator.getComparator(),rand500);
        finish = System.nanoTime();

        timeTaken = finish - start;

        /** 1000 Integers **/
        List<Integer> rand1000 = intGenerator.createRandom(1000);
        start = System.nanoTime();
        selectionSorter.sort(intGenerator.getComparator(),rand1000);
        finish = System.nanoTime();

        timeTaken = finish - start;

        /** 5000 Integers **/
        List<Integer> rand5000 = intGenerator.createRandom(5000);
        start = System.nanoTime();
        selectionSorter.sort(intGenerator.getComparator(),rand5000);
        finish = System.nanoTime();

        timeTaken = finish - start;

    }
}
