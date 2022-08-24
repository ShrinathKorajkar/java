package collectionframwk;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
// import java.util.HashSet;
import java.util.List;
// import java.util.Set;

public class studentHashSet {
    public static void main(String[] args) {

        // Set<Students> studentsSet = new HashSet<Students>();
        List<Students> studentsSet = new ArrayList<Students>();

        studentsSet.add(new Students("Shri", 21));
        studentsSet.add(new Students("Prc", 22));
        studentsSet.add(new Students("Teju", 23));
        studentsSet.add(new Students("Ruthika", 24));
        studentsSet.add(new Students("Ruthika", 24));
        studentsSet.add(new Students("Ruthika", 14));

        System.out.println(studentsSet);

        Students s1 = studentsSet.iterator().next();
        Students s2 = studentsSet.iterator().next();

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s1.equals(s2));

        Collections.sort(studentsSet, new Comparator<Students>() { // work with list only

            @Override
            public int compare(Students o1, Students o2) {

                return o1.compareTo(o2);
            }

        });

        System.out.println(studentsSet);

    }

}
