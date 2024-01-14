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
  } 

  public String getUser(){
    return this.userName;
  }

  public String getBookID(){
    return this.bookID;
  }

  public String getStart(){
    return startDate.toString();
  }

  public String getEnd(){
    return returnDate.toString();
  }
}
