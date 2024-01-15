class CaballeroFranco extends Caballero{
  /*private int numLanzas;
  private int nivelEvolucion;*/
  public CaballeroFranco(String ejercito, int i){
    super(ejercito, i);
    super.setNivelVida(15);
    super.setVidaActual(super.getNivelVida());
    super.setNombre("CaballeroFranco"+ejercito+i);
    super.setNombreCode("CF"+super.getvidaActual());
    super.setAtaque(13);
    super.setDefensa(7);
  }
  public void lanzarLanzas(){
  }
  public void aumentarNivel(){
    /*numLanzas++;
    nivelEvolucion++;*/
  }
}
