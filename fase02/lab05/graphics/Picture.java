package graphics;

import java.util.Arrays;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;

/**
 * This class represents an image with an array of Strings.
 * You can see an String array as a two dimensional array of chars. 
 *
 */
public class Picture implements Iterable<String>{
	private String[] img;
	private int width = 0;
	public final int length;
	
	/**
	 * It's only allowed create Pictures with static methods.
	 * @param img, Character image.
	 */
	private Picture(String[] img){
		this.img = img;
		length = this.img.length;
		for(String s: img)
			width = Math.max(width, s.length());
	}
	
  /**
   * This must be used to invert the color of an image
   * @param c A character to be inverted (in color way)
   */
    private byte invColor(byte c){
      byte ic;
      switch (c) {
        case '_': ic = '='; break;
		case '=': ic = '_'; break;
		case '.': ic = '@'; break;
		case '@': ic = '.'; break;
		default: ic = c; break;
	  }

      return ic;
	}
	/*Pendiente de correccion del metodo invColor
	
    private String invColorS(String s){
      String is = "";

      Map<String, String> map = new HashMap<String, String>();
      map.put("_", "=");
      map.put("=", "_");
      map.put(".", "@");
      map.put("@", ".");
      
      if(!map.containsKey(s)){
        return s;
      }

      is = map.get(s);

      return is;
    }
	*/
  /**
   * used to overlay a the character c2 over the character c1
   * @param c1 the character over
   * @param c2 the character under
   */
	private byte overlay(byte c1, byte c2){
		if(c1 == ' ') return c2;
		return c1;
	}
	
  /**
   * The width of the array, it must be the 
   * most large row
   */
	public int getWidth() {
		return width;
	}

  /**
   * The height of the array, it must be the
   * lenght of the base array
   */
	public int getHeight() {
		return length;
	}

	/**
	 * Vertical Mirror Image 
	 * @return a new Picture, the vertical mirror.
	 */
	public Picture voltearV(){
        String[] imgOriginal = this.img;
		String[] imgVolteada = new String[imgOriginal.length];

        for(int i = 0; i < imgOriginal.length; i++){
            String filaVolteada = "";
            for(int j = 0; j < imgOriginal[i].length(); j++){
                filaVolteada = imgOriginal[i].charAt(j) + filaVolteada;
            }
            imgVolteada[i] = filaVolteada;
        }

		return new Picture(imgVolteada);
	}
	
	/**
	 * Horizontal Mirror Image
	 * @return a new Picture, the horizontal mirror.
	 */
	public Picture voltearH(){
		String[] imgReflejada = new String[img.length];
		String[] imgOriginal = this.img;
	
		for (int i = 0; i < imgOriginal.length; i++) {
			imgReflejada[imgOriginal.length - 1 - i] = imgOriginal[i];
		}
		return new Picture(imgReflejada);
	}
	

	/**
	 * Negative Color
	 * @return a new Picture, the negative color.
	 */
	public Picture invertir(){
		/* COMENTAMOS EL CODIGO A OPTIMIZAR
        int j = 0;
        for(String fila : this.img){
			for(int i = 0 ; i < fila.length() ; i++){
            	char actual = (fila.charAt(i));
				char actualInvertido = (char) invColor((byte) actual);
				fila = fila.substring(0, i) + actualInvertido + fila.substring(i + 1);
			}
			img[j] = fila;
			j++;
        }*/
		String[] imgOriginal = this.img;
		String[] imgResultado = new String[this.img.length];

		for(int i = 0; i < imgOriginal.length; i++){
			byte[] filaOriginal = this.img[i].getBytes();
			byte[] filaInvertida = new byte[this.img[0].length()];

			for(int j = 0; j < filaOriginal.length; j++){
				filaInvertida[j] = invColor(filaOriginal[j]);
			}
			
			imgResultado[i] = new String(filaInvertida);
		}

		return new Picture(imgResultado);
	}
	
	/**
	 * Put the image p next to the right of the current image.
	 * @param p, the neighbor image
	 * @return a new image
	 */
	public Picture alLado(Picture p){
		String[] imgResultado = new String[this.img.length];
		String[] imgOriginal = this.img;

		for(int i = 0; i < imgOriginal.length; i++){
			imgResultado[i] = imgOriginal[i] + p.img[i];
		}

		return new Picture(imgResultado);
	}
	
	/**
	 * Put the image p next to down of the current image.
	 * @param p, the neighbor image
	 * @return a new image
	 */
	public Picture encima(Picture p){
		String[] imgResultado = new String[this.img.length + p.img.length];
		String[] imgOriginal = this.img;

		for(int i = 0; i < imgResultado.length; i++){
			if(i < imgOriginal.length){
				imgResultado[i] = imgOriginal[i];
			}else{
				imgResultado[i] = p.img[i - imgOriginal.length];
			}
		}

		return new Picture(imgResultado);
	}
	
	/**
	 * Merge the current picture over the picture p. 
	 * @param p, the picture that will be on the behind.
	 * @return a new picture
	 */
	public Picture superponer(Picture p){
		String[] imgOriginal = this.img;
		String[] imgResultado = new String[this.img.length];
		
		for(int i = 0; i < imgResultado.length; i++){
			byte[] filaAdelante = imgOriginal[i].getBytes();
			byte[] filaAtras = p.img[i].getBytes();
			byte[] filaResultado = new byte[p.img[0].length()];

			for(int j = 0; j < filaResultado.length; j++){
				byte superponer = overlay(filaAdelante[j], filaAtras[j]);
				filaResultado[j] = superponer;
			}

			imgResultado[i] = new String(filaResultado);
		}
		return new Picture(imgResultado);
	}
	
	/**
	 * Repeat horizontally the current picture n times (to right).
	 * @param n, a positive integer greater than 0.
	 * @return a new picture.
	 */
	public Picture repetirH(int n){
		String[] imgResultado = new String[this.img.length];
        String[] imgOriginal = this.img;

        for(int i = 0; i < imgOriginal.length; i++){
            imgResultado[i] = "";
            for(int j = 0; j < n; j++){
                imgResultado[i] = imgResultado[i] + imgOriginal[i];
            }
        }

		return new Picture(imgResultado);
	}
	
	/**
	 * Repeat vertically the current picture n times (to down).
	 * @param n, a positive integer greater than 0.
	 * @return a new picture.
	 */
	public Picture repetirV(int n){
		String[] img = new String[this.img.length * n];
        int len = this.img.length;
        for(int k = 0; k < n; k++){
          for(int i = 0; i < len; i++){
            img[len * k + i] = this.img[i];
          }
        }

		return new Picture(img);
	}
	
	public static Picture casilleroBlanco(){
		String [] img = new String[58];
		for(int i = 0; i < img.length; i++){
			char[] line = new char[58];
			for(int j = 0; j < img.length; j++)
				line[j] = '_';
			img[i] = new String(line);
		}
		return new Picture(img);
	}
	
  /**
   * returns a new Picture object that represents a bishop
   */
	public static Picture alfil(){
		String [] img = {
			      "                                                          ",
				  "                                                          ",
				  "                                                          ",
				  "                                                          ",
				  "                            ##                            ",
				  "                          ######                          ",
				  "                         ###..###                         ",
				  "                         ##....##                         ",
				  "                         ##....##                         ",
				  "                         ###..###                         ",
				  "                          ######                          ",
				  "                           ####                           ",
				  "                         ########                         ",
				  "                        ###....###                        ",
				  "                      ####......####                      ",
				  "                    ####..........####                    ",
				  "                   ###..............###                   ",
				  "                  ###................###                  ",
				  "                 ###..................###                 ",
				  "                ###.........##.........###                ",
				  "                ##..........##..........##                ",
				  "               ###..........##..........###               ",
				  "               ##...........##...........##               ",
				  "               ##.......##########.......##               ",
				  "               ##.......##########.......##               ",
				  "               ##...........##...........##               ",
				  "               ##...........##...........##               ",
				  "               ##...........##...........##               ",
				  "               ###..........##..........###               ",
				  "                ##..........##..........##                ",
				  "                ###....................###                ",
				  "                 ##....................###                ",
				  "                 ###..................###                 ",
				  "                  ###................###                  ",
				  "                   ####################                   ",
				  "                   ####################                   ",
				  "                   ##................##                   ",
				  "                  ###................###                  ",
				  "                  ##..................##                  ",
				  "                  ######################                  ",
				  "                 ########################                 ",
				  "                 ###..................###                 ",
				  "                 #####..............#####                 ",
				  "                 ########################                 ",
				  "                      ##############                      ",
				  "                          ######                          ",
				  "                        ####..####                        ",
				  "        ##################......##################        ",
				  "      ##################..........##################      ",
				  "    ####..........................................####    ",
				  "    ###.....................##.....................###    ",
				  "     ##...................######...................##     ",
				  "     ###.########.......####  ####.......########.###     ",
				  "      ####################      ####################      ",
				  "       ##        #######          #######        ##       ",
				  "                                                          ",
				  "                                                          ",
				  "                                                          "				
		};
		return new Picture(img);
	}
	
  /**
   * returns a new Picture object that represents a king
   */
	public static Picture rey(){
		String [] img = {"                                                          ",
				  "                                                          ",
				  "                                                          ",
				  "                                                          ",
				  "                           ####                           ",
				  "                           #..#                           ",
				  "                           #..#                           ",
				  "                         ###..###                         ",
				  "                         #......#                         ",
				  "                         ###..###                         ",
				  "                           #..#                           ",
				  "                           #..#                           ",
				  "                           #..#                           ",
				  "                           #..#                           ",
				  "                           #..#                           ",
				  "                          ######                          ",
				  "                         ###..###                         ",
				  "                         ##....##                         ",
				  "                        ###....###                        ",
				  "           #######      ##......##      #######           ",
				  "         ###########    ##......##    ###########         ",
				  "       ####.......####  ##......##  ####.......####       ",
				  "      ###...........######......######...........###      ",
				  "     ###..............####......####..............###     ",
				  "     ##................####....####................##     ",
				  "    ###.................###....###.................###    ",
				  "    ##...................###..###...................##    ",
				  "    ##...................###..###...................##    ",
				  "    ##....................######....................##    ",
				  "    ##....................######....................##    ",
				  "    ##.....................####.....................##    ",
				  "    ###....................####....................###    ",
				  "     ##.....................##....................###     ",
				  "     ###....................##....................##      ",
				  "      ###...................##...................###      ",
				  "       ###..................##..................###       ",
				  "        ###...........##############...........###        ",
				  "         ###.....########################.....###         ",
				  "          ############..............############          ",
				  "           ######........................######           ",
				  "            ##..............................##            ",
				  "            ##..............................##            ",
				  "            ##........##############........##            ",
				  "            ##...########################...##            ",
				  "            ##########..............##########            ",
				  "            #####........................#####            ",
				  "            ##.........############.........##            ",
				  "            ##....######################....##            ",
				  "            ##.########............########.##            ",
				  "            ######......................######            ",
				  "            ######......................######            ",
				  "               ########............########               ",
				  "                  ######################                  ",
				  "                       ############                       ",
				  "                                                          ",
				  "                                                          ",
				  "                                                          ",
				  "                                                          "
		};
		return new Picture(img);
	}

  /**
   * returns a new Picture object that represents a knight
   */
	public static Picture caballo(){
		String [] img = {"                                                          ",
				  "                                                          ",
				  "                                                          ",
				  "                                                          ",
				  "                                                          ",
				  "               #         ##                               ",
				  "              ###       ####                              ",
				  "              #####     ####                              ",
				  "               #####   ######                             ",
				  "               ##.### ###..##                             ",
				  "               ##..#####...######                         ",
				  "               ##...####...#########                      ",
				  "               ##..#####...##...######                    ",
				  "              ###.###.......#.....######                  ",
				  "             ###..#.................#####                 ",
				  "            ###.......................####                ",
				  "            ##.........................####               ",
				  "           ###..####....................####              ",
				  "           ##..####......................####             ",
				  "           ##..####......................#####            ",
				  "           ##..###........................####            ",
				  "          ###..#..............##...........####           ",
				  "          ##..................##...........####           ",
				  "          ##..................##............####          ",
				  "         ###..................##............####          ",
				  "         ##...................##.............####         ",
				  "        ###..................###.............####         ",
				  "       ###..................###..............####         ",
				  "      ###...................###...............####        ",
				  "      ##...................####...............####        ",
				  "     ###.................######...............####        ",
				  "     ##................####  ##................####       ",
				  "    ###.##...........####    ##................####       ",
				  "    ##.###.........####     ###................####       ",
				  "    ##.###........###       ##.................####       ",
				  "    ##.##........###       ###.................#####      ",
				  "    ##......##..###        ##...................####      ",
				  "    ##.....###.###        ###...................####      ",
				  "    ###...#######        ###....................####      ",
				  "     ########.##        ###.....................####      ",
				  "       #########       ###......................####      ",
				  "            ###       ###.......................#####     ",
				  "                     ###........................#####     ",
				  "                    ###..........................####     ",
				  "                    ##...........................####     ",
				  "                   ###...........................####     ",
				  "                  ###............................####     ",
				  "                  ##.............................####     ",
				  "                 ###.............................####     ",
				  "                 ##..............................####     ",
				  "                 ##..............................####     ",
				  "                 ####################################     ",
				  "                 ####################################     ",
				  "                                                          ",
				  "                                                          ",
				  "                                                          ",
				  "                                                          ",
				  "                                                          "
		};
		return new Picture(img);
	}

  /**
   * returns a new Picture object that represents a pawn
   */
	public static Picture peon(){
		String [] img = {"                                                          ",
		                  "                                                          ",
		                  "                                                          ",
		                  "                                                          ",
		                  "                                                          ",
		                  "                                                          ",
		                  "                                                          ",
		                  "                                                          ",
		                  "                           ####                           ",
		                  "                         ########                         ",
		                  "                        ###....###                        ",
		                  "                       ###......###                       ",
		                  "                       ##........##                       ",
		                  "                       ##........##                       ",
		                  "                       ##........##                       ",
		                  "                       ##........##                       ",
		                  "                       ###......###                       ",
		                  "                        ###....###                        ",
		                  "                      #####....#####                      ",
		                  "                     ###..........###                     ",
		                  "                    ###............###                    ",
		                  "                    ##..............##                    ",
		                  "                   ###..............###                   ",
		                  "                   ##................##                   ",
		                  "                   ##................##                   ",
		                  "                   ##................##                   ",
		                  "                   ##................##                   ",
		                  "                   ##................##                   ",
		                  "                   ##................##                   ",
		                  "                   ###..............###                   ",
		                  "                    ##..............##                    ",
		                  "                    ###............###                    ",
		                  "                     ####........####                     ",
		                  "                     ####........####                     ",
		                  "                   ####............####                   ",
		                  "                  ###................###                  ",
		                  "                 ###..................###                 ",
		                  "                ###....................###                ",
		                  "               ###......................###               ",
		                  "               ##........................##               ",
		                  "              ###........................###              ",
		                  "              ##..........................##              ",
		                  "             ###..........................###             ",
		                  "             ##............................##             ",
		                  "             ##............................##             ",
		                  "            ###............................###            ",
		                  "            ##..............................##            ",
		                  "            ##..............................##            ",
		                  "            ##..............................##            ",
		                  "            ##..............................##            ",
		                  "            ##################################            ",
		                  "            ##################################            ",
		                  "                                                          ",
		                  "                                                          ",
		                  "                                                          ",
		                  "                                                          ",
		                  "                                                          ",
		                  "                                                          "
		};
		return new Picture(img);
	}
	
  /**
   * returns a new Picture object that represents a queen
   */
	public static Picture dama(){
		String [] img = {"                                                          ",
				  "                                                          ",
				  "                                                          ",
				  "                                                          ",
				  "                            ##                            ",
				  "                          ######                          ",
				  "              #####      ###..###      #####              ",
				  "             #######     ##....##     #######             ",
				  "             ##...##     ##....##     ##...##             ",
				  "             ##...##     ########     ##...##             ",
				  "    ##       ##...##      ######      ##...##       ##    ",
				  "  ######     #######        ##        #######     ######  ",
				  " ###..###     #####        ####        #####     ###..### ",
				  " ##....##       ###        ####        ###       ##....## ",
				  " ###...##       ###        ####        ###       ##...### ",
				  "  #######       ###        ####        ###       #######  ",
				  "   #####        ####      ######      ####        #####   ",
				  "     ###        ####      ##..##      ####        ###     ",
				  "     ####       ####      ##..##      ####       ####     ",
				  "     ####       #####     ##..##     #####       ####     ",
				  "     #####      ##.##     ##..##     ##.##      #####     ",
				  "      #####     ##.##    ###..###    ##.##     #####      ",
				  "      ##.##    ###.###   ##....##   ###.###    ##.##      ",
				  "      ##.###   ##...##   ##....##   ##...##   ###.##      ",
				  "      ##..##   ##...###  ##....##  ###...##   ##..##      ",
				  "      ##..###  ##....## ###....### ##....##  ###..##      ",
				  "      ###..##  ##....## ##......## ##....##  ##..###      ",
				  "       ##..### ##....#####......#####....## ###..##       ",
				  "       ##...#####.....####......####.....#####...##       ",
				  "       ##....####.....####......####.....####....##       ",
				  "       ##....####..#..###..####..###..#..####....##       ",
				  "       ###....###.######################.###....###       ",
				  "        ##.################....################.##        ",
				  "        ##########......................##########        ",
				  "        ###....................................###        ",
				  "         ##....................................##         ",
				  "         ###..................................###         ",
				  "          ###.......##################.......###          ",
				  "           ####################################           ",
				  "            ########..................########            ",
				  "            ###............................###            ",
				  "             ##............................##             ",
				  "             ##......################......##             ",
				  "             ################################             ",
				  "             ########................########             ",
				  "             ##............................##             ",
				  "            ###.....##################.....###            ",
				  "            ##################################            ",
				  "           #########..................#########           ",
				  "           ##................................##           ",
				  "           ##................................##           ",
				  "           #########..................#########           ",
				  "             ################################             ",
				  "                    ##################                    ",
				  "                                                          ",
				  "                                                          ",
				  "                                                          ",
				  "                                                          "
		};
		return new Picture(img);
	}

  /**
   * returns a new Picture object that represents a rook
   */
	public static Picture torre(){
		String [] img = {"                                                          ",
		                  "                                                          ",
		                  "                                                          ",
		                  "                                                          ",
		                  "                                                          ",
		                  "                                                          ",
		                  "                                                          ",
		                  "           #########     ########     #########           ",
		                  "           #########     ########     #########           ",
		                  "           ##.....##     ##....##     ##.....##           ",
		                  "           ##.....##     ##....##     ##.....##           ",
		                  "           ##.....#########....#########.....##           ",
		                  "           ##.....#########....#########.....##           ",
		                  "           ##................................##           ",
		                  "           ####################################           ",
		                  "           ####################################           ",
		                  "            ###............................###            ",
		                  "             ####........................####             ",
		                  "               ############################               ",
		                  "                ##########################                ",
		                  "                ##......................##                ",
		                  "                ##......................##                ",
		                  "                ##......................##                ",
		                  "                ##......................##                ",
		                  "                ##......................##                ",
		                  "                ##......................##                ",
		                  "                ##......................##                ",
		                  "                ##......................##                ",
		                  "                ##......................##                ",
		                  "                ##......................##                ",
		                  "                ##......................##                ",
		                  "                ##......................##                ",
		                  "                ##......................##                ",
		                  "                ##......................##                ",
		                  "                ##......................##                ",
		                  "                ##......................##                ",
		                  "                ##......................##                ",
		                  "                ##......................##                ",
		                  "                ##########################                ",
		                  "               ############################               ",
		                  "              ###........................###              ",
		                  "            ##################################            ",
		                  "            ##################################            ",
		                  "            ##..............................##            ",
		                  "            ##..............................##            ",
		                  "            ##..............................##            ",
		                  "            ##..............................##            ",
		                  "        ##########################################        ",
		                  "        ##########################################        ",
		                  "        ##......................................##        ",
		                  "        ##########################################        ",
		                  "        ##########################################        ",
		                  "                                                          ",
		                  "                                                          ",
		                  "                                                          ",
		                  "                                                          ",
		                  "                                                          ",
		                  "                                                          "
		};
		return new Picture(img);
	}

  /**
   * Returns an iterator over the pixels in the image. The iteration is over columns and rows.
   */
	private class PIterator implements Iterator<String>{
		private int index = 0;
		@Override
		public boolean hasNext() {
			return index < img.length;
		}

		@Override
		public String next() {
			assert index < img.length: "index="+index+"\timg.length="+img.length;
			String s = img[index];
			index++;
			return s;
		}

		@Override
		public void remove() {
      throw new UnsupportedOperationException("Not modification allowed");
		}
		
	}
	@Override
	public Iterator<String> iterator() {
		return new PIterator();
	}
	

}
