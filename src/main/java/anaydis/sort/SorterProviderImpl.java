package anaydis.sort;
import org.jetbrains.annotations.NotNull;
import java.util.EnumMap;
import java.util.Map;

public class SorterProviderImpl implements SorterProvider{

    private final Map<SorterType, Sorter> sorters = new EnumMap<>(SorterType.class);

    public SorterProviderImpl(){
        final SelectionSorter selection = new SelectionSorter();
        sorters.put(selection.getType(),selection);
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
