import java.sql.SQLOutput;

public class Vector2D {
    float x;
    float y;

    Vector2D(float x, float y) {
        this.x = x;
        this.y = y;
    }

    Vector2D() {
        this(0, 0);
    }

    void addUp(float x, float y) {
        this.x += x;
        this.y += y;
    }

    void addUp(Vector2D other) {
        this.addUp(other.x, other.y);
    }

    Vector2D add(float x, float y) {
        return new Vector2D(this.x + x, this.y + y);
    }

    Vector2D add(Vector2D other) {
        return this.add(other.x, other.y);
    }

    void subtractBy(float x, float y) {
        this.x -= x;
        this.y -= y;
    }

    void subtractBy(Vector2D other) {
        this.subtractBy(other.x, other.y);
    }

    Vector2D subtract(float x, float y) {
        return new Vector2D(this.x + x, this.y + y);
    }

    Vector2D subtract(Vector2D other) {
        return this.subtract(other.x, other.y);
    }

    void scaleBy(float z) {
        this.x *= z;
        this.y *= z;
    }

    Vector2D scale(float z) {
        return new Vector2D(this.x * z, this.y * z);
    }

    float length() {
        return (float) Math.sqrt(this.x * this.x + this.y * this.y);
    }

    Vector2D normalize() {
        float len = this.length();
        return new Vector2D(this.x / len, this.y / len);
    }

    void print() {
        System.out.println("x = " + this.x + " ; " + "y = " + this.y);
    }

    public static void main(String[] args) {
        Vector2D v1 = new Vector2D(2, 3);
        Vector2D v2 = new Vector2D(1, 1);
        System.out.println("v2: ");
        v2.print();
        System.out.println("v1: ");
        v1.print();

        System.out.println("\nTest subtractBy:");
        v2.subtractBy(v1);
        v2.print();
        v1.print();

        System.out.println("\nTest subtract");
        Vector2D v3 = new Vector2D();
        v3 = v2.subtract(v1);
        v3.print();
        v2.print();
        v1.print();

        System.out.println("\nTest scaleBy:");
        v3.scaleBy(2);
        v3.print();

        System.out.println("\nTest scale:");
        Vector2D v4 = new Vector2D();
        v4 = v3.scale(3);
        v4.print();
        v3.print();

        System.out.println("\nTest length:");
        System.out.println("v1 length: " + v1.length());
        System.out.println("v2 length: " + v2.length());
        System.out.println("v3 length: " + v3.length());
        System.out.println("v4 length: " + v4.length());

        System.out.println("\nTest normalize:");
        Vector2D v5 = new Vector2D();
        v5 = v4.normalize();
        v5.print();
        v4.print();
    }
}