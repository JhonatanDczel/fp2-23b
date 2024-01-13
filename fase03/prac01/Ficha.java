
import java.time.LocalDate;

public class Ficha {
    private String name, surname;
    private int id;
    private LocalDate startDate, returnDate;

    public Ficha(String name, String surname, int id) {
        this.name = name;
        this.surname = surname;
        this.id = id;
        startDate = LocalDate.now();
        returnDate = startDate.plusDays(7);
        System.out.println(startDate + ":" + returnDate);
    }

    public static void main(String[] args) {
        Ficha one = new Ficha("Jorge", "Mamani", 1829894);
    }
}
