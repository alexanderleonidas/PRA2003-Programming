/**
 * PRA2003 2021 Week 2, Task 1: Animal kingdom example.
 * @author Alexander Leonidas
 */

/** 
 * Abstract animal base class.
 */
abstract class Animal 
{
    private final String name; 
    private final double age;
	
    public Animal(final String name, final double age) 
    {
        this.name = name; 
        this.age = age;
    }

    @Override	
    public String toString() 
    {   
        if (isOld(age) == true) {
            return name + " goes " + makeNoise() + " and is old.";
        } else {
            return name + " goes " + makeNoise() + ".";
        }
        
    }
	
    public abstract String makeNoise();
    
    public abstract Boolean isOld(double age);
}

//-----------------------------------------------------------------------------

/**
 * Concrete cat class based on Animal.
 */
class Cat extends Animal 
{
    public Cat(final String name, final double age) 
    {
        super(name, age);
    }
	
    public String makeNoise() 
    { 
        return "Meow"; 
    }

    public Boolean isOld(final double age){
        return age>=10;
    }
}

//-----------------------------------------------------------------------------

/**
 * Concrete bird class based on Animal.
 */
class Bird extends Animal 
{
    public Bird(final String name, final double age) 
    {
        super(name, age);
    }
	
    public String makeNoise() 
    { 
        return "Caw"; 
    }

    public Boolean isOld(double age){
        return age >= 0.8;
    }
}

//-----------------------------------------------------------------------------

/**
 * Concrete robin class based on Bird.
 */
class Robin extends Bird 
{
    public Robin(final String name, final double age) 
    {
    	super(name, age);
    }
}

//-----------------------------------------------------------------------------

// Dog class based on Animal
class Dog extends Animal{
    public Dog(final String name, final double age) {
        super(name, age);
    }
    public String makeNoise(){
        return "Woof";
    }
    public Boolean isOld(double age){
        return age >= 12;
    }
}

//-----------------------------------------------------------------------------

// Labrador class based on Dog
class Labrador extends Dog{
    public Labrador(final String name, final double age){
        super(name, age);
    }
}

//-----------------------------------------------------------------------------
/**
 * Main test class.
 */
public class Animals 
{
    public static void main(final String[] args) 
    {
        // Can't instantiate Animal directly because it's an abstract class:
        // Animal a = new Animal("Generic Animal");
		
        final Cat    cat1 = new Cat("Fluffy",8);
        final Animal cat2 = new Cat("Furry",11);
		
        final Animal bird1 = new Bird("A Bird",0.3);
        final Animal bird2 = new Robin("Rob", 0.9);

        final Animal dog1 = new Dog("A Dog",0.7);
        final Animal dog2 = new Labrador("Red", 12.1);
		
        System.out.println(cat1);
        System.out.println(cat2);
        System.out.println(bird1);
        System.out.println(bird2);
        System.out.println(dog1);
        System.out.println(dog2);

    }
}
