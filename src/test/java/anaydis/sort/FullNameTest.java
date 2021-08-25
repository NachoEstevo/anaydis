package anaydis.sort;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FullNameTest {

    @Test
    public void firstNameInsertionSort(){
        InsertionSorter sorter = new InsertionSorter();
        FullName test = new FullName("LEO","MESSI");
        Comparator<FullName> comparator = test.lastNameComparator;

        FullName name1 = new FullName("AMY", "ALEXANDER");
        FullName name2 = new FullName("AMANDA", "ALEXANDER");
        FullName name3 = new FullName("ALICE", "ADAMS");

       List<FullName> descendingTest = new ArrayList<>();

       descendingTest.add(name1);
       descendingTest.add(name2);
       descendingTest.add(name3);

       List<FullName> sorted = new ArrayList<>();
       sorted.add(new FullName("ALICE", "ADAMS"));
       sorted.add(new FullName("AMANDA", "ALEXANDER"));
       sorted.add(new FullName("AMY", "ALEXANDER"));

        sorter.sort(comparator,descendingTest);
        Assert.assertEquals(sorted,descendingTest);

    }
    @Test
    public void firstNameBubbleSort(){
        BubbleSorter sorter = new BubbleSorter();
        FullName test = new FullName("LEO","MESSI");
        Comparator<FullName> comparator = test.lastNameComparator;

        FullName name1 = new FullName("AMY", "ALEXANDER");
        FullName name2 = new FullName("AMANDA", "ALEXANDER");
        FullName name3 = new FullName("ALICE", "ADAMS");

        List<FullName> descendingTest = new ArrayList<>();

        descendingTest.add(name1);
        descendingTest.add(name2);
        descendingTest.add(name3);

        List<FullName> sorted = List.of(new FullName("ALICE", "ADAMS"),new FullName("AMANDA", "ALEXANDER"),new FullName("AMY", "ALEXANDER"));

        sorter.sort(comparator,descendingTest);
        Assert.assertEquals(sorted,descendingTest);

    }
    @Test
    public void firstNameSelectionSort(){
        SelectionSorter sorter = new SelectionSorter();
        FullName test = new FullName("LEO","MESSI");
        Comparator<FullName> comparator = test.lastNameComparator;

        FullName name1 = new FullName("AMY", "ALEXANDER");
        FullName name2 = new FullName("AMANDA", "ALEXANDER");
        FullName name3 = new FullName("ALICE", "ADAMS");

        List<FullName> descendingTest = new ArrayList<>();

        descendingTest.add(name1);
        descendingTest.add(name2);
        descendingTest.add(name3);

        List<FullName> sorted = List.of(new FullName("ALICE", "ADAMS"),new FullName("AMANDA", "ALEXANDER"),new FullName("AMY", "ALEXANDER"));

        sorter.sort(comparator,descendingTest);
        Assert.assertEquals(sorted,descendingTest);

    }

    @Test
    public void generatorTest(){
        FullNameGenerator generator = new FullNameGenerator();

        //Generator test. Ascending, and descending
        FullName[] ascendingTest = new FullName[]{new FullName("ALICE", "ADAMS"), new FullName("AMANDA", "ALEXANDER"), new FullName("AMY", "ALLEN")};
        FullName[] descendingTest = new FullName[]{new FullName("AMY", "ALLEN"), new FullName("AMANDA", "ALEXANDER"),new FullName("ALICE", "ADAMS") };

        FullName[] ascendingGenerated = generator.createAscending(3).toArray(new FullName[0]);
        FullName[] descendingGenerated = generator.createDescending(3).toArray(new FullName[0]);

        Assert.assertArrayEquals(ascendingTest,ascendingGenerated);
        Assert.assertArrayEquals(descendingGenerated,descendingTest);
    }
}
