class Caballero extends Soldado{
  private boolean montado;
  private String armaActual;

  public Caballero(String ejercito, int i){
    super(ejercito, i);
    Random random=new Random();
    this.montado=false;
    this.armaActual="espada";
    super.setNivelVida(random.nextInt(2)+10);
    super.setVidaActual(super.getNivelVida());
    super.setNombre("Caballero"+ejercito+i);
    super.setNombreCode("C"+super.getvidaActual());
    super.setAtaque(13);
    super.setDefensa(7);
  }
  public void alternarArma(){
    if(armaActual.equals("espada"))
      armaActual="lanza";
    else
      armaActual="espada";
  }
  public void desmontar(){
    if(montado)
      montado=false;
      super.defender();
      armaActual="espada";
  }
  public void montar(){
    if(!montado)
      montado=true;
      armaActual="lanza";
      envestir();
  }
  public void envestir(){
    if(montado){
      for(int i=0; i<3; i++)
        super.atacar(null);
    }else
      for(int i=0; i<2; i++)
        super.atacar(null);
  }
}
