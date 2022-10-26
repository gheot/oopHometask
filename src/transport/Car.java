package transport;
import java.time.LocalDate;
public class Car {
    private final String brand;
    private final String model;
    private float engineVolume;
    private String color;
    private final int productionYear;
    private final String productionCountry;
    private String typeOfTransmission;
    private final String typeOfBody;
    private String regNumber;
    private final int numberOfSeats;
    private boolean summerTires;
    private Key key;
    private Insurance insurance;

    public Car (String brand, String model, float engineVolume, String color, int productionYear, String productionCountry) {
        this.brand = ValidationUtils.validOrDefault(brand, "default");
        this.model = ValidationUtils.validOrDefault(model, "default");
        this.productionCountry = ValidationUtils.validOrDefault(productionCountry, "default");
        this.color = ValidationUtils.validOrDefault(color, "белый");
        this.typeOfTransmission = "механическая";
        this.regNumber = "null";
        this.typeOfBody = "хэтчбэк";
        this.numberOfSeats = 5;
        this.summerTires = true;
        this.key = new Key();
        this.insurance = new Insurance();

        if (engineVolume > 0.0f) {
            this.engineVolume = engineVolume;
        } else {
            this.engineVolume = 1.5f;
        }
        if (productionYear >= 0) {
            this.productionYear = productionYear;
        } else {
            this.productionYear = 2000;
        }
    }
    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public String getProductionCountry() {
        return productionCountry;
    }

    public String getTypeOfBody() {
        return typeOfBody;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public float getEngineVolume() {
        return engineVolume;
    }

    public void setEngineVolume(float engineVolume) {
        if (engineVolume > 0.0f) {
            this.engineVolume = engineVolume;
        } else {
            this.engineVolume = 1.5f;
        }
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = ValidationUtils.validOrDefault(color,"белый");
    }

    public String getTypeOfTransmission() {
        return typeOfTransmission;
    }

    public void setTypeOfTransmission(String typeOfTransmission) {
        this.typeOfTransmission = ValidationUtils.validOrDefault(typeOfTransmission,"механическая");
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = ValidationUtils.validOrDefault(regNumber,"null");
    }

    public boolean isSummerTires() {
        return summerTires;
    }

    public void setSummerTires(boolean summerTires) {
        this.summerTires = summerTires;
    }

    public Key getKey() {
        return key;
    }
    public void setKey(Key key) {
        if (key == null) {
            this.key = new Key();
        } else {
            this.key = key;
        }
    }
    public Insurance getInsurance() {
        return insurance;
    }
    public void setInsurance(Insurance insurance) {
        if (insurance == null) {
            this.insurance = new Insurance();
        } else {
            this.insurance = insurance;
        }
    }

    // смена резины
    public void changTire () {
        summerTires = !summerTires;
    }
    // проверка номера x000xx000
    public boolean isCorrectRegNumber () {
        if (regNumber.length() != 9) {
            return false;
        }
        char [] chars = regNumber.toCharArray();
        if (!Character.isAlphabetic(chars[0]) || !Character.isAlphabetic(chars[4]) || !Character.isAlphabetic(chars[5])) {
            return false;          // если не буква, то возвращаем false
        }
        else if (!Character.isDigit(chars[1]) || !Character.isDigit(chars[2]) || !Character.isDigit(chars[3]) ||
                !Character.isDigit(chars[6]) || !Character.isDigit(chars[7]) || !Character.isDigit(chars[8])) {
            return false;
        }        // если не цифра, то false
        return true;

    }

    @Override
    public String toString() {
        return brand + ' ' + model +
                ", объём двигателя - " + engineVolume +
                " л, цвет кузова - " + color + ", " + productionYear +
                " года выпуска, " +
                " страна сборки - " + productionCountry + ", коробка передач: " + typeOfTransmission + ", тип кузова:  " +
                typeOfBody + ", регистрационный номер: "+ regNumber + ", количество мест:  "+ numberOfSeats +
                ", " + (isSummerTires()?"летняя":"зимняя") + " резина, " + (getKey().isKeylessAccess()? "безключевой доступ, ":"ключевой доступ, ") +
                (getKey().isRemoteEngineStart()? "удаленный запуск, " : "обычный запуск, ") + "номер страховки: " +
                getInsurance().getNumber() + ", стоимость страховки - " + getInsurance().getCost() +
                ", срок действия страховки - " + getInsurance().getValidityPeriod() + ".";
    }
    // вложенный класс Ключ
    public static class Key {
        private final boolean remoteEngineStart;
        private final boolean keylessAccess;

        public Key(boolean remoteEngineStart, boolean keylessAccess) {
            this.remoteEngineStart = remoteEngineStart;
            this.keylessAccess = keylessAccess;
        }

        public Key() {
            this(false, false);
        }

        public boolean isRemoteEngineStart() {
            return remoteEngineStart;
        }

        public boolean isKeylessAccess() {
            return keylessAccess;
        }
    }
    //вложенный класс «Страховка»
    public static class Insurance {
        private final LocalDate validityPeriod;
        private final double cost;
        private final String number;

        public Insurance(LocalDate validityPeriod, double cost, String number) {
            if (validityPeriod == null) {
                this.validityPeriod = LocalDate.now().plusDays(365);
            } else {
                this.validityPeriod = validityPeriod;
            }
            this.cost = cost;

            if (number == null) {
                this.number = "123456789";
            } else {
                this.number = number;
            }
        }

        public Insurance() {
            this(null, 10000,null);
        }

        public LocalDate getValidityPeriod() {
            return validityPeriod;
        }

        public double getCost() {
            return cost;
        }

        public String getNumber() {
            return number;
        }
        // метод проверки срока годности страховки
        public void checkValidityPeriod() {
            if (validityPeriod.isBefore(LocalDate.now()) || validityPeriod.isEqual(LocalDate.now())){
                System.out.println("Нужно срочно ехать оформлять новую страховку.");
            }
        }
        public void checkNumber () {
            if (number.length()!=9) {
                System.out.println("Номер страховки некорректный!");
            }
        }
    }

}


