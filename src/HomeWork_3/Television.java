package HomeWork_3;

import java.util.Scanner;
import java.util.Random;

/*
Реализовать класс Телевизор. У класса есть поля, свойства и методы.
Проверить работу в классе App, методе main.
 */
public class Television {
    private String brand;
    private int screenSize;
    private boolean isSmart;
    private int price;
    private int currentChannel;

    public Television(String brand, int screenSize, boolean isSmart, int price) {
        this.brand = brand;
        this.screenSize = screenSize;
        this.isSmart = isSmart;
        this.price = price;
        this.currentChannel = 1;
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
        String[] brands = {"Sumsung", "LG", "Sony", "Panasonic", "Xiaomi"};
        String brand = brands[random.nextInt(brands.length)];
        int screenSize = 20 + random.nextInt(60);
        boolean isSmart = random.nextBoolean();
        int price = 30000 + random.nextInt(50000);
        return new Television(brand, screenSize, isSmart, price);
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(int screenSize) {
        this.screenSize = screenSize;
    }

    public boolean isSmart() {
        return isSmart;
    }

    public void setSmart(boolean smart) {
        isSmart = smart;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCurrentChannel() {
        return currentChannel;
    }

    public void changeChannel(int newChannel) {
        if (newChannel > 0) {
            currentChannel = newChannel;
            System.out.println("Канал изменён на " + newChannel);
        } else {
            System.out.println("Некорректный номер канала");
        }
    }

    public void powerOn() {
        System.out.println("Телевизор " + brand + " включён. Текущий канал: " + currentChannel);
    }

    public void powerOff() {
        System.out.println("Телевизор " + brand + " выключен");
    }

    @Override
    public String toString() {
        return "Телевизор {" +
                "марка='" + brand + '\'' +
                ", размер экрана=" + screenSize +
                "\", смарт=" + isSmart +
                ", цена=" + price +
                '}';
    }
}
