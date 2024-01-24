import java.awt.Color;
import java.awt.Graphics;

public class CeldaUnica {
  
  private static int x, y, size;
  private static CeldaUnica instance;

  private CeldaUnica(){
  }

  public static void dibujar(Graphics g) {
    g.setColor(Color.LIGHT_GRAY);
    g.fillRect(x, y, size, size);
    g.setColor(Color.GRAY);
    g.drawRect(x, y, size, size);
  }

  public static CeldaUnica createInstance(int x, int y, int size){
    if (instance == null) {
      instance = new CeldaUnica();
    }
    instance.x = x;
    instance.y = y;
    instance.size = size;
    return instance;
  }
}
