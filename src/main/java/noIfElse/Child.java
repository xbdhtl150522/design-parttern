package noIfElse;

public class Child extends Father {
    static {
        System.out.println("child-->static");
    }

    private int n = 20;

    {
        n = 30;
    }

    public Child() {
        this("The other contructor");
        System.out.println("child contructor body :" + n);
    }

    public Child(String s) {
        System.out.println(s);
    }

    public void age() {
        System.out.println("age=" + n);
    }

    public void printX() {
        System.out.println("x=" + x);
    }

    public static void main(String[] args) {
        new Child().printX();
    }

}
