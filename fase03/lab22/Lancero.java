
class Lancero extends Soldado{
  private int longitudDeLanza=0;
  public Lancero(String ejercito, int i){
    super(ejercito, i);
    Random random=new Random();
    longitudDeLanza=longitudDeLanza+1;
    this.longitudDeLanza=random.nextInt(5)+1;
    super.setNivelVida(random.nextInt(3)+5);
    super.setVidaActual(super.getNivelVida());
    super.setNombre("Lancero"+ejercito+i);
    super.setNombreCode("L"+super.getvidaActual());
    super.setAtaque(5);
    super.setDefensa(10);
  }
  public void schiltrom(){
    super.actualizarDefensa(1);
  }
}
