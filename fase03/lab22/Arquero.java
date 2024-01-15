class Arquero extends Soldado{
  private int flechas;

  public Arquero(String ejercito, int i){
    super(ejercito, i);
    Random random=new Random();
    this.flechas=random.nextInt(5)+1;
    super.setNivelVida(random.nextInt(2)+3);
    super.setVidaActual(super.getNivelVida());
    super.setNombre("Arquero"+ejercito+i);
    super.setNombreCode("A"+super.getvidaActual());
    super.setAtaque(7);
    super.setDefensa(3);
  }
  public Arquero(){
    Random random=new Random();
    super.setNivelVida(random.nextInt(2)+3);
    super.setVidaActual(super.getNivelVida());
    super.setNombre("Arquero");
    super.setNombreCode("A"+super.getvidaActual());
    super.setAtaque(7);
    super.setDefensa(3);
  }
  public void dispararFlechas(){
    if(this.flechas>0)
      this.flechas--;
  }
}
