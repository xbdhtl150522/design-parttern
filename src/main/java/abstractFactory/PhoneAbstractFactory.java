package abstractFactory;

public abstract class PhoneAbstractFactory {
    /*屏幕*/
    public abstract Screen createScreen();

    /*外壳*/
    public abstract Shell createShell();
}
