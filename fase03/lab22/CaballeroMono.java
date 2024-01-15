class CaballeroMoro extends Caballero{
  /*private int numeroFlechas;
  private int nivelEvolucion;*/
  public CaballeroMoro(String ejercito, int i){
    super(ejercito, i);
    super.setNivelVida(13);
    super.setVidaActual(super.getNivelVida());
    super.setNombre("CaballeroMoro"+ejercito+i);
    super.setNombreCode("CM"+super.getvidaActual());
    super.setAtaque(10);
    super.setDefensa(8);
  }
  public void lanzarFechas(){
  }
  public void aumentarNivel(){
    /*nivelEvolucion++;
    numeroFlechas++;*/
  }
}
