package anaydis.sort;
import org.jetbrains.annotations.NotNull;
import java.util.EnumMap;
import java.util.Map;

public class SorterProviderImpl implements SorterProvider{

    private final Map<SorterType, Sorter> sorters = new EnumMap<>(SorterType.class);

    public SorterProviderImpl(){ //Fix this using the methods implemented below

        sorters.put(SorterType.SELECTION, new SelectionSorter());
        sorters.put(SorterType.BUBBLE,new BubbleSorter());
        sorters.put(SorterType.INSERTION,new InsertionSorter());
        sorters.put(SorterType.QUICK,new QuickSorter());
        sorters.put(SorterType.SHELL,new ShellSorter());
        sorters.put(SorterType.H,new HSorter());
        sorters.put(SorterType.QUICK_NON_RECURSIVE,new QuickSorterNonRecursive());
        sorters.put(SorterType.QUICK_CUT,new QuickSorterCut());
        sorters.put(SorterType.MERGE_BOTTOM_UP,new MergeSorterBottomUp());
        sorters.put(SorterType.MERGE_TOP_DOWN,new MergeSorterTopDown());
    }
    @Override
    public @NotNull Iterable<Sorter> getAllSorters(){
        return sorters.values();
    }
    @Override
    public @NotNull Sorter getSorterForType(@NotNull SorterType type){
        return sorters.get(type);
    }
}
