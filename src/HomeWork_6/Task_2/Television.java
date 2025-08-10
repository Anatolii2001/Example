package HomeWork_6.Task_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

class Television {
    private final String brand;
    private final int screenSize;
    private final boolean isSmart;
    private final int price;
    private int currentChannel;
    private final List<Channel> channels;

    public Television(String brand, int screenSize, boolean isSmart, int price) {
        this.brand = brand;
        this.screenSize = screenSize;
        this.isSmart = isSmart;
        this.price = price;
        this.currentChannel = 1;
        this.channels = new ArrayList<>();
    }

    public static Television createFromKeyboard() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите марку телевизора:");
        String brand = scanner.nextLine();
        System.out.println("Введите размер экрана (в дюймах):");
        int screenSize = scanner.nextInt();
        System.out.println("Является ли телевизор смарт (true/false):");
        boolean isSmart = scanner.nextBoolean();
        System.out.println("Введите цену:");
        int price = scanner.nextInt();
        return new Television(brand, screenSize, isSmart, price);
    }

    public static Television createRandom() {
        Random random = new Random();
        String[] brands = {"Samsung", "LG", "Sony", "Panasonic", "Xiaomi"};
        String brand = brands[random.nextInt(brands.length)];
        int screenSize = 20 + random.nextInt(60);
        boolean isSmart = random.nextBoolean();
        int price = 30000 + random.nextInt(50000);
        return new Television(brand, screenSize, isSmart, price);
    }

    public void addChannel(Channel channel) {
        channels.add(channel);
    }

    public void changeChannel(int newChannel) {
        if (newChannel > 0 && newChannel <= channels.size()) {
            currentChannel = newChannel;
            System.out.println("Канал изменён на " + channels.get(newChannel - 1).getTitle());
        } else {
            System.out.println("Некорректный номер канала");
        }
    }

    public void powerOn() {
        System.out.println("Телевизор " + brand + " включён. Текущий канал: " + channels.get(currentChannel - 1).getTitle());
    }

    public void powerOff() {
        System.out.println("Телевизор " + brand + " выключен");
    }

    @Override
    public String toString() {
        return "Телевизор {" +
                "марка = '" + brand + '\'' +
                ", размер экрана = " + screenSize +
                "\", смарт = " + isSmart +
                ", цена = " + price +
                ", каналы = " + channels +
                '}';
    }
}
