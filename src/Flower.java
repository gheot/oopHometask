public class Flower {
    private String flowerColor;
    private String country;
    private double cost;
    public int lifeSpan;

    public Flower(String flowerColor, String country, double cost, int lifeSpan) {
        this.flowerColor = validOrDefault(flowerColor,"белый");
        this.country = validOrDefault(country, "Россия");
        if (cost <= 0) {
            this.cost = 1;
        } else {
            this.cost = cost;
        }
        if (lifeSpan <=0) {
            this.lifeSpan = 3;
        } else {
            this.lifeSpan = lifeSpan;}

    }
    public Flower(String flowerColor, String country, double cost) {
        this (flowerColor,country,cost,3);
    }
    public String getFlowerColor() {
        return flowerColor;
    }
    public void setFlowerColor(String flowerColor) {
        this.flowerColor = validOrDefault(flowerColor,"белый");
    }
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = validOrDefault(country, "Россия");
    }
    public double getCost() {
        return cost;
    }
    public void setCost(double cost) {
        if (cost <= 0) {
            this.cost = 1;
        } else {
            this.cost = cost;
        }
    }

    @Override
    public String toString() {
        return "Цвет: " + flowerColor +
                ". Страна происхождения: " + country +
                ". Стоимость за штуку: " + cost +
                ". Срок стояния цветка: " + lifeSpan + ".";
    }


    private String validOrDefault (String value, String defaultValue) {
        if (value == null || value.isBlank()) {
            return defaultValue;
        }
        else {
            return value;
        }
    }
}