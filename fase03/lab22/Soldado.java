import java.util.*;
public abstract class Soldado{
  private String nombre;
  private String nombreCode;
  private int nivelAtaque;
  private int nivelDefensa;
  private int nivelVida;
  private int vidaActual;
  private int velocidad;
  private String actitud;
  private boolean vive;
  private int fila;
  private int columna;

  public Soldado(String ejercito, int i){
    /*Random random=new Random();
    this.nombre="Soldado"+ejercito+i;
    this.nivelAtaque=random.nextInt(5)+1;
    this.nivelDefensa=random.nextInt(5)+1; 
    this.nivelVida=random.nextInt(5)+1;
    this.vidaActual=this.nivelVida;*/
    this.velocidad=0;
    this.actitud="ofensiva";//Actitud por default
    this.vive=true;
  }
  //Soldado generico
  public Soldado() {
    Random random=new Random();
    this.nombre="Soldado";
    this.nivelAtaque=random.nextInt(5)+1;
    this.nivelDefensa=random.nextInt(5)+1; 
    this.nivelVida=random.nextInt(5)+1;
    this.vidaActual=this.nivelVida;
    this.velocidad=0;
    this.actitud="ofensiva";
    this.vive=true;
  }
  public void setNombre(String n){
    this.nombre=n;
  }
  public void setNombreCode(String n){
    this.nombreCode=n;
  }
  public void setAtaque(int a){
    nivelAtaque=a;
  }
  public void setDefensa(int d){
    nivelDefensa=d;
  }
  public void setVidaActual(int v){
    vidaActual=v;
  }
  public void setNivelVida(int v){
    this.nivelVida=v;
  }
  public void setFila(int f){
    fila = f;
  }
  public void setColumna(int c){
    columna = c;
  }
  public String getNombre(){
    return nombre;  
  }
  public String getNombreCode(){
    return this.nombreCode;
  }
  public int getNivelAtaque(){
    return nivelAtaque;
  }
  public int getNivelDefensa(){
    return nivelDefensa;
  }
  public int getNivelVida(){
    return nivelVida;
  }
  public int getvidaActual(){
    return vidaActual;
  }
  public int getVelocidad(){
    return velocidad;
  }
  public String getActitud(){
    return actitud;
  }
  public boolean getVive(){
    return vive;
  }
  public int getFila(){
    return fila;
  }
  public int getColumna(){
    return columna;
  }
  public void actualizarVida(int v){
    this.vidaActual+=v;
  }
  public void actualizarDefensa(int d){
    this.nivelDefensa+=d;
  }
  public void atacar(Soldado enemigo) {
    enemigo.serAtacado(this.nivelAtaque);
    this.avanzar();
  }
  public void defender() {
    this.actitud="defensiva";
    this.velocidad=0;
  }
  public void avanzar() {
    this.velocidad+=1;
  }
  public void retroceder() {
    if (this.velocidad>0) {
      this.velocidad=0;
      this.actitud="defensiva";
    } else {
      this.velocidad-=1;
    }
  }
  public void serAtacado(int dano) {
    if (this.vidaActual>dano) {
      this.vidaActual-=dano;
    } else {
      this.vidaActual=0;
      this.morir();
    }
  }
  public void huir() {
    this.actitud="fuga";
    this.velocidad+=2;
  }
  public void morir() {
    this.vive=false;
  }
}
