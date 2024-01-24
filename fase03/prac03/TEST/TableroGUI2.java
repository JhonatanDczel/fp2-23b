import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;

public class TableroGUI2 extends JFrame {

    public TableroGUI2() {
        setTitle("Tablero");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel tableroPanel = new TableroPanel();
        add(tableroPanel);

        setVisible(true);
    }

    private static void medirMemoria() {
        Runtime runtime = Runtime.getRuntime();

        long memoriaTotal = runtime.totalMemory();
        long memoriaLibre = runtime.freeMemory();
        long memoriaUsada = memoriaTotal - memoriaLibre;

        System.out.println("Memoria Total: " + (memoriaTotal / (1024 * 1024)) + " MB");
        System.out.println("Memoria Libre: " + (memoriaLibre / (1024 * 1024)) + " MB");
        System.out.println("Memoria Usada: " + (memoriaUsada / (1024 * 1024)) + " MB");
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
                    Celda celda = new Celda(columna * celdaSize, fila * celdaSize, celdaSize);
                    celda.dibujar(g);
                }
            }
        }
    }

    public static void main(String[] args) {
        new TableroGUI();
        medirMemoria();
    }
}
