public class Soldado{
  public String name;
  public int life;

  public Soldado(String name){
    this.name = name;
  }

  //SECCION DE SETERS

  public void setLife(int life){
    this.life = life;
  }

  //SECCION DE GETERS

  public String getName(){
    return this.name;
  }

  public int getLife(){
    return this.life;
  }
}
