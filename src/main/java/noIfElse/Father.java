package noIfElse;

public class Father {

    static {
        System.out.println("super--->statical");

    }

    public static int n = 10;
    public int x = 100;

    public Father() {
        System.out.println("super's x=" + x);
        age();
    }

    public void age() {
        System.out.println("nothing");
    }

    public void printX() {
        System.out.println("x=" + x);
    }
}
