public class Tablero{
  private String[][][] tablero;
  private Soldado[][] tableroS;
  private int len;

  public Tablero(int n) {
    this.tablero = new String[n][n][3];
    this.tableroS = new Soldado[n][n];
    this.len = n;
    startTablero();
    genTablero();
  }
  public void colocar(Soldado s, int x, int y) {
    this.tableroS[y][x] = s;
  }
  public Soldado obtener(int x, int y){
    return this.tableroS[y][x];
  }
  public void startTablero(){
    for(String[][] fila : this.tablero){
      for(String[] s : fila){
        s[0] = "      ";
        s[1] = "      ";
        s[2] = "      ";
      }
    }
  }
  private void genTablero(){
    int i = 0;
    int j = 0;
    for(Soldado[] fila: this.tableroS){
      for(Soldado s : fila){
        if(s == null){
          i++;
          continue;
        }

        this.tablero[j][i][0] = s.getEquipo();
        this.tablero[j][i][1] = s.getNombre();
        this.tablero[j][i][2] = String.valueOf(s.getVida());
        i++;
      }
      j++;
    }
  }
  public void print(){
    for(int i = 0; i < this.len; i++){
      for(int j = 0; j < this.len; j++){
        System.out.println("=======");
        System.out.println("=" + tablero[i][j][0]);
        System.out.println("=" + tablero[i][j][1]);
        System.out.println("=" + tablero[i][j][2]);
      }
    }
  }
}
