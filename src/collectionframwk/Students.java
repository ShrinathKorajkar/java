package collectionframwk;

import java.util.Objects;

public class Students implements Comparable<Students> {

    String name;
    int rollno;

    public Students(String name, int rollno) {
        this.name = name;
        this.rollno = rollno;
    }

    @Override
    public String toString() {
        return "Student(" + "name : " + name + ", rollno : " + rollno + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Students other = (Students) obj;
        return rollno == other.rollno;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rollno);
    }

    @Override
    public int compareTo(Students o) {
        return this.rollno - o.rollno;
    }
}
