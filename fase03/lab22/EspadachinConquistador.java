class EspadachinConquistador extends Espadachin{
  /*private int numeroHachas;
  private int nivelEvolucion;*/
  public EspadachinConquistador(String ejercito, int i){
    super(ejercito, i);
    super.setNivelVida(14);
    super.setVidaActual(super.getNivelVida());
    super.setNombre("EspadachinConquista"+ejercito+i);
    super.setNombreCode("EC"+super.getvidaActual());
    super.setAtaque(10);
    super.setDefensa(8);
  }
  public void lanzarHacha(){
  }
  public void aumentarNivel(){
    /*nivelEvolucion++;
    numeroHachas++;*/
  }
}
