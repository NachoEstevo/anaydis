package anaydis.sort;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class FullNameGenerator  {//implements DataSetGenerator<FullName>

    private final List<FullName> fullNames;

    public FullNameGenerator() {
        fullNames = new ArrayList<>();
        List<String> firstNames =  firstNames();
        List<String> lastNames = lastNames();

        for (int i = 0; i < lastNames.size(); i++) {
            fullNames.add(new FullName(firstNames.get(i),lastNames.get(i)));
        }
    }

    @NotNull
    public List<FullName> createAscending(final int length) {
        if (length > fullNames.size())
            throw new IllegalArgumentException("Watch out! FullNameGenerator can generate up to " + fullNames.size() + " values only.");

        return new ArrayList<>(fullNames.subList(0, length));
    }


    @NotNull
    public List<FullName> createDescending(int length) {
        final List<FullName> copy = createAscending(length);
        Collections.reverse(copy);
        return copy;
    }

    @NotNull
    public List<FullName> createRandom(int length) {
        final List<FullName> copy = createAscending(length);
        Collections.shuffle(copy);
        return copy;
    }
/*
    public @NotNull Comparator<FullName> getComparator() {
        return FullNameCompare();
    }

    private Comparator<FullName> FullNameCompare() {

    }*/



    public int compareFirstName(FullName f1, FullName f2) {
        return f1.getFirstname().compareTo(f2.getFirstname());
    }
    public int compareLastName(FullName f1, FullName f2) {
        return f1.getLastname().compareTo(f2.getLastname());
    }


    private List<String> firstNames() {
        return Arrays.asList("ALICE", "AMANDA",
                "AMY", "ANDREA", "ANGELA", "ANN", "ANNA", "ANNE", "ANNIE",
                "ASHLEY", "BARBARA", "BETTY", "BEVERLY", "BONNIE", "BRENDA",
                "CARMEN", "CAROL", "CAROLYN", "CATHERINE", "CHERYL",
                "CHRISTINA", "CHRISTINE", "CINDY", "CONNIE", "CRYSTAL",
                "CYNTHIA", "DAWN", "DEBORAH", "DEBRA", "DENISE", "DIANA",
                "DIANE", "DONNA", "DORIS", "DOROTHY", "EDITH", "EDNA",
                "ELIZABETH", "EMILY", "EVELYN", "FLORENCE", "FRANCES",
                "GLADYS", "GLORIA", "GRACE", "HEATHER", "HELEN", "IRENE",
                "JACQUELINE", "JANE", "JANET", "JANICE", "JEAN", "JENNIFER",
                "JESSICA", "JOAN", "JOYCE", "JUDITH", "JUDY", "JULIA", "JULIE",
                "KAREN", "KATHERINE", "KATHLEEN", "KATHRYN", "KATHY", "KELLY",
                "KIM", "KIMBERLY", "LAURA", "LILLIAN", "LINDA", "LISA", "LOIS",
                "LORI", "LOUISE", "MARGARET", "MARIA", "MARIE", "MARILYN",
                "MARTHA", "MARY", "MELISSA", "MICHELLE", "MILDRED", "NANCY",
                "NICOLE", "NORMA", "PABLIUS", "PAMELA", "PATRICIA", "PAULA", "PEDRO",
                "PEGGY", "PHYLLIS", "RACHEL", "REBECCA", "RITA", "ROBIN", "ROSA",
                "ROSE", "RUBY", "RUTH", "SANDRA", "SARA", "SARAH", "SHARON", "SHIRLEY",
                "STEPHANIE", "SUSAN", "TAMMY", "TERESA", "THERESA", "TIFFANY",
                "TINA", "TRACY", "VICTORIA", "VIRGINIA", "WANDA", "WENDY");
    }

    private List<String> lastNames() {
        return  Arrays.asList("ADAMS", "ALEXANDER", "ALLEN", "ANDERSON", "BAILEY", "BAKER", "BARNES", "BELL", "BENNETT", "BROOKS", "BROWN", "BRYANT",
                "BUTLER", "CAMPBELL", "CARTER", "CLARK", "COLEMAN", "COLLINS", "COOK", "COOPER", "COX", "DAVIS", "DIAZ", "EDWARDS",
                "EVANS", "FLORES", "FOSTER", "GARCIA", "GONZALES", "GONZALEZ", "GRAY", "GREEN", "GRIFFIN", "HALL", "HARRIS",
                "HAYES", "HENDERSON", "HERNANDEZ", "HILL", "HOWARD", "HUGHES", "JACKSON", "JAMES", "JENKINS", "JOHNSON",
                "JONES", "KELLY", "KING", "LEE", "LEWIS", "LONG", "LOPEZ", "MARTIN", "MARTINEZ", "MILLER", "MITCHELL", "MOORE",
                "MORGAN", "MORRIS", "MURPHY", "NELSON", "PARKER", "PATTERSON", "PEREZ", "PERRY", "PETERSON", "PHILLIPS",
                "POWELL", "PRICE", "RAMIREZ", "REED", "RICHARDSON", "RIVERA", "ROBERTS", "ROBINSON", "RODRIGUEZ",
                "ROGERS", "ROSS", "RUSSELL", "SANCHEZ", "SANDERS", "SCOTT", "SIMMONS", "SMITH", "STEWART",
                "TAYLOR", "THOMAS", "THOMPSON", "TORRES", "TURNER", "WALKER", "WARD", "WASHINGTON", "WATSON",
                "WHITE", "WILLIAMS", "WILSON", "WOOD", "WRIGHT", "YOUNG");
    }
}
