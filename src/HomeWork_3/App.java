package HomeWork_3;

public class App {
    public static void main(String[] args) {

        Television tv1 = new Television("Samsung", 55, true, 95000);
        Television tv2 = Television.createFromKeyboard();
        Television tv3 = Television.createRandom();

        System.out.println("\nИнформация о телевизорах:");
        System.out.println(tv1);
        System.out.println(tv2);
        System.out.println(tv3);

        System.out.println("\nДемонстрация работы телевизора 2:");
        tv2.powerOn();
        tv2.changeChannel(5);
        tv2.powerOff();
    }
}
