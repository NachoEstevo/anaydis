package anaydis.sort;

/**
 * Sorter tests should subclass this abstract implementation
 */
abstract class SorterTest extends AbstractSorterTest {

    private final SorterProviderImpl provider = new SorterProviderImpl();

    @Override protected DataSetGenerator<String> createStringDataSetGenerator() {
        return new StringDataSetGenerator();
    }
    //protected DataSetGenerator<FullName> createFullNameDataSetGenerator() {return  new FullNameGenerator();}

    @Override protected DataSetGenerator<Integer> createIntegerDataSetGenerator() {
        return new IntegerDataSetGenerator();
    }
    @Override protected SorterProvider getSorterProvider() {
        return provider;
    }
}
