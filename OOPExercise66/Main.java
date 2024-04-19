package OOPExercise66;

public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat("Munchkin");
        cat.greets();

        Dog dog = new Dog("Alaska");
        dog.greets();

        Dog anotherDog = new Dog("Husky");
        dog.greets(anotherDog);

        BigDog bigDog = new BigDog(" PitBull");
        bigDog.greets();

        BigDog anotherBigDog = new BigDog("Doberman");
        bigDog.greets(anotherBigDog);
        bigDog.greets(anotherDog);
    }
}