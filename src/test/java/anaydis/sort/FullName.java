package anaydis.sort;

import java.util.Comparator;

public class FullName {
    private final String firstname;
    private final String lastname;


    public FullName(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }


    public Comparator<FullName> lastNameComparator = new Comparator<FullName>() {
        @Override
        public int compare(FullName n1, FullName n2) {
            if (n1.getLastname().equals(n2.getLastname())) {
                return n1.getFirstname().compareTo(n2.getFirstname());
            }
            return n1.getLastname().compareTo(n2.getLastname());
        }
    };

    @Override
    public boolean equals(Object obj) {
        final FullName toCompare = (FullName) obj;
        if (obj == null) {
            return false;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }
        return toCompare.lastname.equals(this.lastname) && toCompare.firstname.equals(this.firstname);
    }
}