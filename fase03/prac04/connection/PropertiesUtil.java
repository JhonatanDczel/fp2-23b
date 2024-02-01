package connection;

import java.io.InputStream;
import java.security.AuthProvider;
import java.util.Properties;

public class PropertiesUtil {
  // Metodo estatico que se encarga de cargar propiedades desde un archivo
  // Estatico porque no necesitamos crear instancias paara poder usarlo
  public static Properties loadProperty(String propertiesUrl){
    try {
      Properties properties = new Properties();
      /* OJITO:
       * PropertiesUtil.class devuelve el objeto class asociado a la clase PropertiesUtil, 
       * Con el metodo getClassLoader obtenemos el ClassLoader asociado a la clase PropertiesUtil
       * En este caso, el ClassLoader se utiliza para cargar un recurso específico, que es un archivo
       * de propiedades (propertiesURL).
       * getResourceAsStream(propertiesURL) Utiliza el ClassLoader para buscar el recurso con la ruta
       * especificada por propertiesURL en el classpath y devuelve un InputStream que representa ese recurso
      */

      InputStream inputStream = PropertiesUtil.class.getClassLoader().getResourceAsStream(propertiesUrl);
      properties.load(inputStream);
      return properties;
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }
}
