package Oops.ClassObject;

class Stu{
    String name;
    int age;
    void display(){
        System.out.println("name : " + name + " , " + "age : "+ age);
    }
}
public class Main {
    public static void main(String[] args) {
        Stu a1= new Stu();
        a1.name = "Prabhat";
        a1.age = 21;
        a1.display();

    }
}
