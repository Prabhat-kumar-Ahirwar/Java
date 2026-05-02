package Oops;
// Parent Class (Grandparent)
class Animal {
    String name;

    // Constructor
    Animal(String name) {
        this.name = name;
        System.out.println("Animal constructor called");
    }

    void eat() {
        System.out.println(name + " is eating");
    }

    void sound() {
        System.out.println("Animal makes a sound");
    }
}

// Child Class (Parent)
class Dog extends Animal {

    // Constructor using super
    Dog(String name) {
        super(name); // calling parent constructor
        System.out.println("Dog constructor called");
    }

    void bark() {
        System.out.println(name + " is barking");
    }

    // Method Overriding
    @Override
    void sound() {
        System.out.println(name + " says: Woof Woof");
    }
}

// Grandchild Class (Multilevel Inheritance)
class Puppy extends Dog {

    Puppy(String name) {
        super(name);
        System.out.println("Puppy constructor called");
    }

    void weep() {
        System.out.println(name + " is weeping");
    }
}

// Main Class
public class InheritanceDemo {
    public static void main(String[] args) {

        System.out.println("---- Creating Dog Object ----");
        Dog d = new Dog("Tommy");

        d.eat();      // inherited from Animal
        d.bark();     // own method
        d.sound();    // overridden method

        System.out.println("\n---- Creating Puppy Object ----");
        Puppy p = new Puppy("Bruno");

        p.eat();      // from Animal
        p.bark();     // from Dog
        p.weep();     // own method
        p.sound();    // overridden method
    }
}