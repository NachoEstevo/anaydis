package anaydis.sort;
import org.jetbrains.annotations.NotNull;
import java.util.EnumMap;
import java.util.Map;

public class SorterProviderImpl implements SorterProvider{

    private final Map<SorterType, Sorter> sorters = new EnumMap<>(SorterType.class);

    public SorterProviderImpl(){ //Fix this using the methods implemented below
        final SelectionSorter selection = new SelectionSorter();
        sorters.put(selection.getType(),selection);
        final BubbleSorter bubble = new BubbleSorter();
        sorters.put(bubble.getType(),bubble);
        final InsertionSorter insertion = new InsertionSorter();
        sorters.put(insertion.getType(),insertion);
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
