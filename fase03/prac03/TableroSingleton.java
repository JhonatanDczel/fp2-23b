import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;

public class TableroSingleton extends JFrame {

    public TableroSingleton() {
        setTitle("Tablero con Singleton");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel tableroPanel = new TableroPanel();
        add(tableroPanel);

        setVisible(true);
    }


    private class TableroPanel extends JPanel {

        public TableroPanel() {
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            int celdaSize = getWidth() / 10;

            for (int fila = 0; fila < 10; fila++) {
                for (int columna = 0; columna < 10; columna++) {
                    CeldaUnica celda = CeldaUnica.getInstance(columna * celdaSize, fila * celdaSize, celdaSize);
                    celda.dibujar(g);
                }
            }
        }
    }

    public static void main(String[] args) {
        new TableroGUI();
    }
}