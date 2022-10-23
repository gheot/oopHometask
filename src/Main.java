public class Main {
    public static void main(String[] args) {
        Human maksim = new Human(1987,"Максим", "Минск", " бренд-менеджер");
        Human anna = new Human(1993,"Аня", "Москва", "методист образовательных программ");
        Human katya = new Human(1994,"Катя", "Калининград", "продакт-менеджер");
        Human artem = new Human(1995,"Артём", "Москва", "директор по развитию бизнеса");
        maksim.humanInfo();
        anna.humanInfo();
        katya.humanInfo();
        artem.humanInfo();
        System.out.println();
    }
}



