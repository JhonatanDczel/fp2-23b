public class Soldado{
  public String name;
  public int life;
  public int row;
  public int column;
  public boolean negro = false;

  public Soldado(String name){
    this.name = name;
  }

  //SECCION DE SETERS

  public void setNegro(boolean n){
    this.negro = n;
  }
  public void setLife(int life){
    this.life = life;
  }
  public void setColumn(int x){
    this.column = x;
  }
  public void setRow(int y){
    this.row = y;
  }

  //SECCION DE GETERS

  public boolean getNegro(){
    return this.negro;
  }
  public String getName(){
    return this.name;
  }

  public int getLife(){
    return this.life;
  }
  
  public int getColumn(){
    return this.column;
  }

  public int getRow(){
    return this.row;
  }
}
