package anaydis.search;

import org.jetbrains.annotations.NotNull;

public class BinaryTrieMapTest extends AbstractMapTest{

    @NotNull
    @Override
    Map<String, String> getNewInstance() {
        return new BinaryTrieMap<>();
    }
}