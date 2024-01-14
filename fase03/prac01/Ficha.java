package prac01;

import java.time.*;

public class Ficha {
  private String userName;
  private String bookID;

  private LocalDate startDate; 
  private LocalDate returnDate; 
  
  public Ficha(String userName, String bookID) {
    this.userName = userName;
    this.bookID = bookID;

    startDate = LocalDate.now();
    returnDate = startDate.plusDays(7);
    System.out.println("starts in: " + startDate + "\n" + "returns in: " + returnDate);
  } 
}
