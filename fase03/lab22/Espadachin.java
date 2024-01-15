import java.util.*;
class Espadachin extends Soldado{
  private int longitudEspada;

  public Espadachin(String ejercito, int i){
    super(ejercito, i);
    Random random=new Random();
    this.longitudEspada=random.nextInt(5)+1;
    super.setNivelVida(random.nextInt(2)+8);
    super.setVidaActual(super.getNivelVida());
    super.setNombre("Espadachin"+ejercito+i);
    super.setNombreCode("E"+super.getvidaActual());
    super.setAtaque(10);
    super.setDefensa(8);
  }
  public void crearMuroEscudo(){
    super.actualizarDefensa(1);
  }
  public int getLongitudEspada(){
    return this.longitudEspada;
  }
}
