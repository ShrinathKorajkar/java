package oops;

class Pen {

    String type;
    String color;
    static int quantity;

    public static void changequantity(int no) {
        quantity = no;
    }

    Pen() {

    }

    Pen(String type, String color) {
        this.type = type;
        this.color = color;
    }

    Pen(Pen p) {
        this.type = p.type;
        this.color = p.color;
    }

    public void write() {
        System.out.println("writing with " + color + " " + type);
    }
}

class ClassesAndObjets {
    public static void main(String[] args) {

        Pen pen = new Pen();
        pen.type = "ball pen";
        pen.color = "blue";
        pen.write();

        Pen pen2 = new Pen("gel pen", "black");
        pen2.write();

        Pen pen3 = new Pen(pen2);
        pen3.write();

        Pen pen4 = new Pen(); // Pen pen4 = pen;
        pen4 = pen;
        pen4.write();

        // static keyword
        Pen.quantity = 10;
        System.out.println(Pen.quantity);
        Pen.changequantity(5);
        System.out.println(Pen.quantity);
    }
}