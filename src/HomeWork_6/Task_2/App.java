package HomeWork_6.Task_2;

public class App {
    public static void main(String[] args) {
        Television tv1 = new Television("Samsung", 55, true, 95000);

        Television tv2 = Television.createFromKeyboard();
        tv2.addChannel(new Channel("Первый", 1, new Program("Новости", 5.0, 100000)));
        tv2.addChannel(new Channel("Второй", 2, new Program("Фильм", 4.5, 50000)));
        Television tv3 = Television.createRandom();

        System.out.println("\nИнформация о телевизорах:");
        System.out.println(tv1);
        System.out.println(tv2);
        System.out.println(tv3);

        System.out.println("\nДемонстрация работы телевизора 2:");
        tv2.powerOn();
        tv2.changeChannel(2);
        tv2.powerOff();
    }
}
