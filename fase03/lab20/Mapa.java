package lab.lab20;

public class Mapa {
  final private String[] TERRENOS = {"bosque", "campo", "montaña", "desierto", "playa"};
  private Ejercito[][] table = new Ejercito[10][10];
  private String terreno = TERRENOS[random(5)];

  public Ejercito[][] getTable() {
    return table;
  }
  public String getTerreno() {
    return terreno;
  }

  private int random(int n) {
    return (int) (Math.random() * n);
  }
}
