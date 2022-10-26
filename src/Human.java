public class Human {
    private int birthDate;
    public String name;
    private String town;
    public String job;
    public Human (int birthDate, String name, String town, String job) {
        this.name = validOrDefault(name,"Информация не указана");
        this.town = validOrDefault(town,"Информация не указана");
        this.job = validOrDefault(job,"Информация не указана");
        if (birthDate < 0) {
            this.birthDate = 0;
        } else {
            this.birthDate = birthDate;
        }
    }
    public int getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(int birthDate) {
        if (birthDate < 0) {
            this.birthDate = 0;
        } else {
            this.birthDate = birthDate;
        }
    }
    public String getTown() {
        return town;
    }
    public void setTown(String town) {
        this.town = validOrDefault(town,"Информация не указана");
    }
    public void humanInfo () {
        System.out.println("Привет! Меня зовут " + name + ". Я из города " + town + ". Я родился в " +
                birthDate + " году. Я работаю на должности " + job + ". Будем знакомы!");
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
