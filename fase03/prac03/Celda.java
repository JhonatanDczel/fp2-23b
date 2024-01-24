import java.awt.Color;
import java.awt.Graphics;

public class Celda {
    int x, y, size;

    public Celda(int x, int y, int size) {
        this.x = x;
        this.y = y;
        this.size = size;
    }

    public void dibujar(Graphics g) {
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(x, y, size, size);
        g.setColor(Color.GRAY);
        g.drawRect(x, y, size, size);
    }
}
