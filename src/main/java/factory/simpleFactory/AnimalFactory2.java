package factory.simpleFactory;

//该简单工厂，也称为静态方法工厂
public class AnimalFactory2 {

	public static Dog createDog(){
		return new Dog();
	}
	
	public static Cat createCat(){
		return new Cat();
	}
}
