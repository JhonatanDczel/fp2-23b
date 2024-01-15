class EspadachinReal extends Soldado{
  //private int numeroCuchillos;
  //private int nivelEvolucion;
  public EspadachinReal(String ejercito, int i){
    super(ejercito, i);
    super.setNivelVida(12);
    super.setVidaActual(super.getNivelVida());
    super.setNombre("EspadachinReal"+ejercito+i);
    super.setNombreCode("ER"+super.getvidaActual());
    super.setAtaque(10);
    super.setDefensa(8);
  }
  public void lanzarCuchillo(){
  }
  public void aumentarNivel(){
    //nivelEvolucion++;
    //numeroCuchillos++;
  }
}
