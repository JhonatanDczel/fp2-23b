package lab.lab20;

public class Caballero extends Soldado {
  private char armaActual = 'l';
  private char state = 'm';

  public Caballero(int nivelVida, String team) {
    super(nivelVida, team);
  }

  public void desmontar() {
    if(state != 'm') System.out.println("El caballero ya se encuentra desmontado");
    else {
      System.out.println("El caballero cambia de arma a espada y de desmonta");
      state = 'd';
      armaActual = 'e';
    }
  }

  public void emvestir() {
    if (state == 'm') {
      for(int i = 0; i < 3; i += 1) atacar();
    } else for(int i = 0; i < 2; i += 1) atacar();
  }

  public String getArmaActual() {
    if(armaActual == 'l') return "lanza";
    return "espada";
  }

  public String getState() {
    if(state == 'd') return "desmontado";
    return "montado";
  }

}
