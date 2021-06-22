package singleton;

/*枚举单例*/
public enum EnumSingleton {
    INSTANCE();

    public void tellEveryone() {
        System.out.println("This is an EnumSingleton " + this.hashCode());
    }

}
