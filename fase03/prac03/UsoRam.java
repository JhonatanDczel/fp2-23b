public class UsoRam {
  public static void main(String[] args) {
    Runtime runtime = Runtime.getRuntime();
    long mTotalAntes = runtime.totalMemory();
    long mLibreAntes = runtime.freeMemory();
    long mUsadaAntes = mTotalAntes - mLibreAntes;
    System.out.println("Memoria uasda antes:\t" + mUsadaAntes);
    for (int i = 0; i < 1000; i++) {
      for (int j = 0; j < 1000; j++) {
        CeldaUnica cellUnica = CeldaUnica.getInstance(2423, 234, 234);
      }
    }
    long mTotal = runtime.totalMemory();
    long mLibre = runtime.freeMemory();
    long mUsada = mTotal - mLibre;
    long totalUsado = mUsada - mUsadaAntes;
    System.out.println("Total usado:\t " + totalUsado);
  }
}
