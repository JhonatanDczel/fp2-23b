package lab.lab20;

public class Arquero extends Soldado {
  private int numFlechas = random(20);

  public Arquero(int nivelVida, String team) {
    super(nivelVida, team);
  }

  public void disparar() {
    System.out.print("Disparo un flecha quedan: ");
    numFlechas -= 1;
    System.out.println(numFlechas);
  }
}
