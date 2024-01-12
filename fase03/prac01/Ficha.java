import java.time.*;

public class Ficha {
  private String name, surname;
  private int id;
  private LocalDate startDate, returnDate; 
  
  public Ficha(int id, String name) {
    this.name = name;
    this.id = id;
    startDate = LocalDate.now();
    returnDate = startDate.plusDays(7);
    System.out.println(startDate + ":" + returnDate);
  } 

  public static void main(String[] args) {
    Ficha one = new Ficha("Jorge", "Mamani", 1829894);
  }
}
