public class Human {
        public int birthDate;
        public String name;
        public String town;
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
