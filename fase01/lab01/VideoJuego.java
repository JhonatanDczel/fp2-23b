public class VideoJuego{
  public static void main(String[] args){
    Soldado rambo = new Soldado("Rambo");
    Soldado goomp = new Soldado("Goomp");
    Soldado joel = new Soldado("Joel");
    Soldado mauricio = new Soldado("Mauricio");
    Soldado rogelio = new Soldado("Rogelio");
    
    System.out.println("Escuadron Sistemas:\n" + rambo.getName() + "\n" + goomp.getName() + "\n" + joel.getName() + "\n" + mauricio.getName() + "\n" + rogelio.getName() + "\n");
  }

}
