package chapter4;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class LambdasLesson {
    static void print(List<Animal> animals, Predicate<Animal> checkTrait){
        for(Animal animal: animals){
            if(checkTrait.test(animal)){
                System.out.print(animal+" ,");
            }

        }
        System.out.println();
    }
    public static void main(String[] arhs){
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("Fish",false,true,6));
        animals.add(new Animal("Kangaroo",true,false,14));
        animals.add(new Animal("Rabbit",true,false,1));
        animals.add(new Animal("Turtle",false,true,34));
        animals.add(new Animal("Sloth",false,false,5));
        animals.add(new Animal("Frog",true,true,1));
        System.out.println("All animal that can Hop");
        // print(animals, a->a.canHop());
        // print(animals, a->{ return a.canHop();});
        // print(animals, (Animal a)->{ return a.canHop();});
        print(animals, (Animal a)->a.canHop());
        System.out.println("All animal that can Swim");
        print(animals, a->a.canSwim());
        System.out.println("All animal that can Swim and hop");
        print(animals, a->a.canSwim()&& a.canHop());
        System.out.println("All animal that cannot Swim and hop");
        print(animals, a->!a.canSwim()&& !a.canHop());
        System.out.println("All animal that age is older than 5");
        print(animals, a->a.getAge()>5);
        // AopsB sumAopsB = (a,b)-> a+b;
        AopsB sumAopsB = (int a,int b, boolean c)-> a+b;
        AopsB prodAopsB = (y,z,x)-> y*z;
        System.out.println(sumAopsB.go(13, 11,true));
        System.out.println(prodAopsB.go(10, 5,true));
        Discount tenPercent = a->a-(a*0.10);
        Discount twentyPercent = a->a-(a*0.20);
        Discount fiftyPercent = a->a-(a*0.50);
        int price = 1000;
        System.out.println("Ten Percent Discount="+tenPercent.applyDC(price));
        System.out.println("Twenty Percent Discount="+twentyPercent.applyDC(price));
        System.out.println("50 Percent Discount="+fiftyPercent.applyDC(price));

    }
}

class Animal{
    private String species;
    private boolean canHop;
    private boolean canSwim;
    private int age;
    public Animal(String species,boolean canHop,boolean canSwim,int age){
        this.species = species;
        this.canHop = canHop;
        this.canSwim = canSwim;
        this.age = age;
    }
    public boolean canHop(){
        return canHop;
    }
    public boolean canSwim(){
        return canSwim;
    }

    public int getAge() {
        return age;
    }
    @Override 
    public String toString(){
        return species;
    }
}
// interface CheckTrait{
//     boolean test(Animal a);
// }
// class CheckIfHopper implements CheckTrait{
//     public boolean test(Animal a){
//         return a.canHop();
//     }
// }
// class CheckIfSwimmer implements CheckTrait{
//     public boolean test(Animal a){
//         return a.canSwim();
//     }
// }
interface AopsB{
    int go(int a, int b,boolean c);
}
interface Discount{
    double applyDC(double d);
}