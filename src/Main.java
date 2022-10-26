
import  transport.Car;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        int currentYear = 2022;
        Human maksim = new Human(currentYear - 35,"Максим", "Минск", " бренд-менеджер");
        Human anna = new Human(currentYear - 29,"Аня", "Москва", "методист образовательных программ");
        Human katya = new Human(currentYear - 28,"Катя", "Калининград", "продакт-менеджер");
        Human artem = new Human(currentYear - 27,"Артём", "Москва", "директор по развитию бизнеса");
        Human vladimir = new Human(currentYear - 21, "Владимир", "Казань", null);
        maksim.humanInfo();
        anna.humanInfo();
        katya.humanInfo();
        artem.humanInfo();
        vladimir.humanInfo();
        System.out.println();


        System.out.println();
        Flower roza = new Flower(null, "Голландия", 35.59);
        System.out.println(roza);
        Flower hrizantema = new Flower(null," ", 15);
        hrizantema.lifeSpan = 5;
        System.out.println(hrizantema);
        Flower pion = new Flower(null,"Англия", 69.9);
        pion.lifeSpan = 1;
        System.out.println(pion);

        Flower gipsofila = new Flower(null,"Турция", 19.5);
        gipsofila.lifeSpan = 10;
        System.out.println(gipsofila);
        System.out.println();


        Flower [] flowers = new Flower[9];
        flowers [0] = roza;
        flowers [1] = roza;
        flowers [2] = roza;
        flowers [3] = hrizantema;
        flowers [4] = hrizantema;
        flowers [5] = hrizantema;
        flowers [6] = hrizantema;
        flowers [7] = hrizantema;
        flowers [8] = gipsofila;

    printCostOfBouquet(flowers);

  for (int i = 0; i < flowers.length; i++) {
        System.out.println(flowers[i]);

    }
        Car lada = new Car("Lada", "Granta", 1.7f, "жёлтый", 2015, "Россия");
        lada.setTypeOfTransmission("автомат");
        lada.setRegNumber("d125hj235");
        lada.setSummerTires(false);
        System.out.println(lada.isCorrectRegNumber());
        lada.setSummerTires(false);
        lada.setKey(new Car.Key(true,true));
        lada.setInsurance(new Car.Insurance(LocalDate.now(), 20000, "152563478"));
        lada.getInsurance().checkNumber();
        lada.getInsurance().checkValidityPeriod();

        System.out.println(lada);
        Car audi = new Car("Audi", "A8 50 L TDI quattro", 3.0f, "черный", 2020, "Германия");
        System.out.println(audi);
        Car bmw = new Car("BMW", "Z8", 3.0f, "чёрный", 2021, "Германия");
        System.out.println(bmw);
        Car kia = new Car("Kia", "Sportage 4-го поколения", 2.4f, "красный", 2018, "Южная Корея");
        System.out.println(kia);
        Car hyundai = new Car("Hyundai", "Avante", 1.6f, "оранжевый", 2016, "Южная Корея");
        System.out.println(hyundai);
    }



    private static void printCostOfBouquet (Flower[] flowers) {

        double totalCost = 0;
        int minLifeSpan = Integer.MAX_VALUE;
        for (Flower flower : flowers) {
            if (flower.lifeSpan < minLifeSpan) {
                minLifeSpan = flower.lifeSpan;
            }
            totalCost = totalCost + flower.getCost();

        }
        totalCost = totalCost*1.1;
        System.out.printf("Стоимсоть букета: %.2f ", totalCost);
        System.out.println("Срок стояния букета: " + minLifeSpan);
    }
    public  static void printInfo (Flower flower) {
        System.out.println( "Цвет: " + flower.getFlowerColor() +
                ". Страна происхождения: " + flower.getFlowerColor() +
                ". Стоимость за штуку: " + flower.getFlowerColor() +
                ". Срок стояния цветка: " + flower.lifeSpan + ".");
    }



}







