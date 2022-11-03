import java.util.Comparator;



public enum Options {
   TITLE("title", Comparator.comparing(Movie::getTitle)),
    YEAR("year", Comparator.comparing(Movie::getYear)),
    RATING("rating", Comparator.comparing(Movie::getRating));

   private final String criteria;
   private final Comparator<Movie> comparator;

    Options(String criteria, Comparator<Movie> comparator) {
        this.criteria = criteria;
        this.comparator = comparator;
    }


    public String getCriteria() {
        return criteria;
    }

    public Comparator<Movie> getComparator() {
        return comparator;
    }


    public static Options convert(String criteria) {
        Options[] values = Options.values();
        for (Options value : values) {
            if(value.getCriteria().toLowerCase().equals(criteria.toLowerCase()))
                return value;
        }
        throw new IllegalArgumentException("Nieprawidˆowe kryterium sortowania " + criteria);
    }
}
