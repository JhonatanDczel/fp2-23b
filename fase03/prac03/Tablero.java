import javax.swing.SwingUtilities;

public class Tablero {
  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
      new TableroGUI();
    });
  }
}
