class EspadachinTeutonico extends Espadachin{
  /*private int numeroJabalina;
  private int nivelEvolucion;*/
  public EspadachinTeutonico(String ejercito, int i){
    super(ejercito, i);
    super.setNivelVida(13);
    super.setVidaActual(super.getNivelVida());
    super.setNombre("EspadachinTeutonico"+ejercito+i);
    super.setNombreCode("ET"+super.getvidaActual());
    super.setAtaque(10);
    super.setDefensa(8);
  }
  public void lanzarJabalina(){
  }
  public void aumentarNivel(){
    /*nivelEvolucion++;
    numeroJabalina++;*/
  }
}
