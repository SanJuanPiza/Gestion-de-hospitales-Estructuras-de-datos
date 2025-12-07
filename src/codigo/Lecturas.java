package codigo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author usuario
 */
public class Lecturas
{

    private static InputStreamReader isr = new InputStreamReader(System.in);
    private static BufferedReader br = new BufferedReader(isr);

//    public int leerEntero() throws IOException, NumberFormatException //Exception atrapa todas las excepciones
//    {
//        return Integer.parseInt(br.readLine());
//    }
    public static int leerEntero(boolean b)
    {
        do
        {
            try
            {
                return Integer.parseInt(br.readLine());
            } catch (IOException ex)
            {
                System.out.println("Error... problema de entrada de datos");
                Logger.getLogger(Lecturas.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NumberFormatException ex)
            {
                System.out.println("Se esperaba un entero");
            } catch (Exception ex)
            {
                System.out.println("Error..." + ex.getMessage());
//                return 0;
            }//finally
//        {
//            return 0;
//        }
            System.out.println("Favor de reintentar");

        } while (b);

        return 0;
    }

    public static double leerDouble(boolean b)
    {
        do
        {
            try
            {
                return Double.parseDouble(br.readLine());
            } catch (IOException ex)
            {
                System.out.println("Error... problema de entrada de datos");
                Logger.getLogger(Lecturas.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NumberFormatException ex)
            {
                System.out.println("Se esperaba un double");
            } catch (Exception ex)
            {
                System.out.println("Error..." + ex.getMessage());
//                return 0;
            }//finally
//        {
//            return 0;
//        }
            System.out.println("Favor de reintentar");

        } while (b);

        return 0;
    }

    public static float leerFloat(boolean b)
    {
        do
        {
            try
            {
                return Float.parseFloat(br.readLine());
            } catch (IOException ex)
            {
                System.out.println("Error... problema de entrada de datos");
                Logger.getLogger(Lecturas.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NumberFormatException ex)
            {
                System.out.println("Se esperaba un flotante");
            } catch (Exception ex)
            {
                System.out.println("Error..." + ex.getMessage());
//                return 0;
            }//finally
//        {
//            return 0;
//        }
            System.out.println("Favor de reintentar");

        } while (b);

        return 0;
    }

    public static long leerLong(boolean b)
    {
        do
        {
            try
            {
                return Long.parseLong(br.readLine());
            } catch (IOException ex)
            {
                System.out.println("Error... problema de entrada de datos");
                Logger.getLogger(Lecturas.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NumberFormatException ex)
            {
                System.out.println("Se esperaba un Long");
            } catch (Exception ex)
            {
                System.out.println("Error..." + ex.getMessage());
//                return 0;
            }//finally
//        {
//            return 0;
//        }
            System.out.println("Favor de reintentar");

        } while (b);

        return 0;
    }

    public static String leerCadena()
    {
        try
        {
            return br.readLine();

        } catch (Exception err)
        {
            System.out.println("Error..." + err.toString());

        }
        return null;
    }

    public static Boolean leerBoolean()
    {
        try
        {
            String input = br.readLine().trim().toLowerCase();

            if (input.equals("true"))
            {
                return true;
            } else if (input.equals("false"))
            {
                return false;
            } else
            {
                System.out.println("Entrada invalida. Por favor, ingresa 'true' o 'false'.");
                return leerBoolean(); 
            }

        } catch (Exception err)
        {
            System.out.println("Error..." + err.toString());
        }
        return null;
    }

    public static char leercaracter()
    {
        char c = ' ';
        try
        {
            c = (char) br.read();
            String s = br.readLine();

        } catch (Exception err)
        {
            System.out.println("Error..." + err.toString());

        }
        return c;
    }
}
