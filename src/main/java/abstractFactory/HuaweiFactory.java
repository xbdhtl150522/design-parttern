package abstractFactory;

public class HuaweiFactory extends PhoneAbstractFactory {
    @Override
    public Screen createScreen() {
        return new HuaweiScreen();
    }

    @Override
    public Shell createShell() {
        return new HuweiShell();
    }
}
