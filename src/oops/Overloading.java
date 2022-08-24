package oops;

class Student {
    String name;
    int age;

    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void print() {
        System.out.println("Name : " + name + "\nage : " + age);
    }

    void print(String name, int age) {
        System.out.println("Name : " + name + "\nage : " + age);
    }
}

public class Overloading {
    public static void main(String[] args) {

        Student s1 = new Student("Rahul", 20);
        s1.print();
        s1.print("Rahul", 24);
    }
}
