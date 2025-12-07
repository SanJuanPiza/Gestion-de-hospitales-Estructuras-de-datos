package codigo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ManipulaArchivos
{

//    public static void guardaFolio(int[] contNumFolio, String nombreArchivo)
//    {
//        try (FileOutputStream fos = new FileOutputStream("datos/" + nombreArchivo); ObjectOutputStream oos = new ObjectOutputStream(fos))
//        {
//            oos.writeObject(contNumFolio); // Serializa el arreglo y lo escribe
//            System.out.println("Folio guardado correctamente en " + nombreArchivo);
//        } catch (IOException e)
//        {
//            System.out.println("Error al guardar el folio en el archivo: " + nombreArchivo);
//            e.printStackTrace();
//        }
//    }

    public static void guarda(Object obj[], String cad)
    {
        try
        {
            FileOutputStream fos = new FileOutputStream("datos/" + cad);
            try
            {
                ObjectOutputStream arch = new ObjectOutputStream(fos);
                arch.writeObject(obj);
                arch.close();
            } catch (IOException ex)
            {
                System.out.println("no se pudo escribir en el archivo");
            }
        } catch (FileNotFoundException ex)
        {
            System.out.println("no encontro el archivo");
        }

    }

    public static void guarda(ListaCircularAnt obj, String cad)
    {
        try
        {
            FileOutputStream fos = new FileOutputStream("datos/" + cad);
            try
            {
                ObjectOutputStream arch = new ObjectOutputStream(fos);
                arch.writeObject(obj);
                arch.close();
            } catch (IOException ex)
            {
                System.out.println("no se pudo escribir en el archivo");
            }
        } catch (FileNotFoundException ex)
        {
            System.out.println("no encontro el archivo");
        }

    }
    
    public static void guardaMultilista(Multilista obj, String cad)
    {
        try
        {
            FileOutputStream fos = new FileOutputStream("datos/" + cad);
            try
            {
                ObjectOutputStream arch = new ObjectOutputStream(fos);
                arch.writeObject(obj);
                arch.close();
            } catch (IOException ex)
            {
                System.out.println("no se pudo escribir en el archivo");
            }
        } catch (FileNotFoundException ex)
        {
            System.out.println("no encontro el archivo");
        }

    }
    
    public static void guardaListaAnt(ListaAnt obj, String cad)
    {
        try
        {
            FileOutputStream fos = new FileOutputStream("datos/" + cad);
            try
            {
                ObjectOutputStream arch = new ObjectOutputStream(fos);
                arch.writeObject(obj);
                arch.close();
            } catch (IOException ex)
            {
                System.out.println("no se pudo escribir en el archivo");
            }
        } catch (FileNotFoundException ex)
        {
            System.out.println("no encontro el archivo");
        }

    }
    
    public static void guardaBicola(Bicola<NodoML> obj, String cad)
    {
        try
        {
            FileOutputStream fos = new FileOutputStream("datos/" + cad);
            try
            {
                ObjectOutputStream arch = new ObjectOutputStream(fos);
                arch.writeObject(obj);
                arch.close();
            } catch (IOException ex)
            {
                System.out.println("no se pudo escribir en el archivo");
            }
        } catch (FileNotFoundException ex)
        {
            System.out.println("no encontro el archivo");
        }

    }
    
    public static void guardaFolio(int[] obj, String cad)
    {
        try
        {
            FileOutputStream fos = new FileOutputStream("datos/" + cad);
            try
            {
                ObjectOutputStream arch = new ObjectOutputStream(fos);
                arch.writeObject(obj);
                arch.close();
            } catch (IOException ex)
            {
                System.out.println("no se pudo escribir en el archivo");
            }
        } catch (FileNotFoundException ex)
        {
            System.out.println("no encontro el archivo");
        }

    }

    public static void guarda(Object obj[][], String cad)
    {
        try
        {
            FileOutputStream fos = new FileOutputStream("datos/" + cad);
            try
            {
                ObjectOutputStream arch = new ObjectOutputStream(fos);
                arch.writeObject(obj);
                arch.close();
            } catch (IOException ex)
            {
                System.out.println("no se pudo escribir en el archivo");
            }
        } catch (FileNotFoundException ex)
        {
            System.out.println("no encontro el archivo");
        }

    }
    
    public static void guardaAint(int obj[], String cad)
    {
        try
        {
            FileOutputStream fos = new FileOutputStream("datos/" + cad);
            try
            {
                ObjectOutputStream arch = new ObjectOutputStream(fos);
                arch.writeObject(obj);
                arch.close();
            } catch (IOException ex)
            {
                System.out.println("no se pudo escribir en el archivo");
            }
        } catch (FileNotFoundException ex)
        {
            System.out.println("no encontro el archivo");
        }

    }

    public static Object[] cargaA(String cad)
    {
        Object obj[] = null;
        try
        {
            FileInputStream fis = new FileInputStream("datos/" + cad);
            try
            {
                ObjectInputStream arch = new ObjectInputStream(fis);
                try
                {
                    obj = (Object[]) arch.readObject();
                } catch (ClassNotFoundException ex)
                {
                    Logger.getLogger(ManipulaArchivos.class.getName()).log(Level.SEVERE, null, ex);
                }
                arch.close();
            } catch (IOException ex)
            {
                System.out.println("no se pudo leer el arhivo");
            }
        } catch (FileNotFoundException ex)
        {
            System.out.println("no encontro archivo");
        }
        return obj;

    }
    
    public static int[] cargaAint(String cad)
    {
        int obj[] = MnpHDEP.cveArr;
        try
        {
            FileInputStream fis = new FileInputStream("datos/" + cad);
            try
            {
                ObjectInputStream arch = new ObjectInputStream(fis);
                try
                {
                    obj = (int[]) arch.readObject();
                } catch (ClassNotFoundException ex)
                {
                    Logger.getLogger(ManipulaArchivos.class.getName()).log(Level.SEVERE, null, ex);
                }
                arch.close();
            } catch (IOException ex)
            {
                System.out.println("no se pudo leer el arhivo");
            }
        } catch (FileNotFoundException ex)
        {
            System.out.println("no encontro archivo");
        }
        return obj;

    }
    
    public static ListaCircularAnt cargaLista(String cad)
    {
        ListaCircularAnt obj = new ListaCircularAnt();
        try
        {
            FileInputStream fis = new FileInputStream("datos/" + cad);
            try
            {
                ObjectInputStream arch = new ObjectInputStream(fis);
                try
                {
                    obj = (ListaCircularAnt) arch.readObject();
                } catch (ClassNotFoundException ex)
                {
                    Logger.getLogger(ManipulaArchivos.class.getName()).log(Level.SEVERE, null, ex);
                }
                arch.close();
            } catch (IOException ex)
            {
                System.out.println("no se pudo leer el arhivo");
            }
        } catch (FileNotFoundException ex)
        {
            System.out.println("no encontro archivo");
        }
        return obj;

    }
    
    public static ListaAnt cargaListaAnt(String cad)
    {
        ListaAnt obj = new ListaAnt();
        try
        {
            FileInputStream fis = new FileInputStream("datos/" + cad);
            try
            {
                ObjectInputStream arch = new ObjectInputStream(fis);
                try
                {
                    obj = (ListaAnt) arch.readObject();
                } catch (ClassNotFoundException ex)
                {
                    Logger.getLogger(ManipulaArchivos.class.getName()).log(Level.SEVERE, null, ex);
                }
                arch.close();
            } catch (IOException ex)
            {
                System.out.println("no se pudo leer el arhivo");
            }
        } catch (FileNotFoundException ex)
        {
            System.out.println("no encontro archivo");
        }
        return obj;

    }
    
    public static Bicola<NodoML> cargaBicola(String cad)
    {
        NodoML arr[] = new NodoML[100];
        Bicola<NodoML> obj = new Bicola<>(arr);
        try
        {
            FileInputStream fis = new FileInputStream("datos/" + cad);
            try
            {
                ObjectInputStream arch = new ObjectInputStream(fis);
                try
                {
                    obj = (Bicola<NodoML>) arch.readObject();
                } catch (ClassNotFoundException ex)
                {
                    Logger.getLogger(ManipulaArchivos.class.getName()).log(Level.SEVERE, null, ex);
                }
                arch.close();
            } catch (IOException ex)
            {
                System.out.println("no se pudo leer el arhivo");
            }
        } catch (FileNotFoundException ex)
        {
            System.out.println("no encontro archivo");
        }
        return obj;

    }
    
    public static Multilista cargaMultiLista(String cad)
    {
        Multilista obj = new Multilista();
        try
        {
            FileInputStream fis = new FileInputStream("datos/" + cad);
            try
            {
                ObjectInputStream arch = new ObjectInputStream(fis);
                try
                {
                    obj = (Multilista) arch.readObject();
                } catch (ClassNotFoundException ex)
                {
                    Logger.getLogger(ManipulaArchivos.class.getName()).log(Level.SEVERE, null, ex);
                }
                arch.close();
            } catch (IOException ex)
            {
                System.out.println("no se pudo leer el arhivo");
            }
        } catch (FileNotFoundException ex)
        {
            System.out.println("no encontro archivo");
        }
        return obj;

    }

    public static Object[][] cargaAm(String cad)
    {
        Object obj[][] = null;
        try
        {
            FileInputStream fis = new FileInputStream("datos/" + cad);
            try
            {
                ObjectInputStream arch = new ObjectInputStream(fis);
                try
                {
                    obj = (Object[][]) arch.readObject();
                } catch (ClassNotFoundException ex)
                {
                    Logger.getLogger(ManipulaArchivos.class.getName()).log(Level.SEVERE, null, ex);
                }
                arch.close();
            } catch (IOException ex)
            {
                System.out.println("no se pudo leer el arhivo");
            }
        } catch (FileNotFoundException ex)
        {
            System.out.println("no encontro archivo");
        }
        return obj;

    }

    public static void guarda(Object obj, String cad) //HACER LOS TRY-CATCH
    {
        try
        {
            FileOutputStream fos = new FileOutputStream("datos/" + cad); //.. = es regresarse a una carpeta anterior (explicacion captura whsp); /datos/ es para ir a la carpeta generada del archivo de Neatbeans
            try
            {
                ObjectOutputStream arch = new ObjectOutputStream(fos);
                arch.writeObject(obj);
                arch.close();
            } catch (IOException ex)
            {
                System.out.println("NO SE PUEDE ESCRIBIR EL ARCHIVO...");
            }
        } catch (FileNotFoundException ex)
        {
            System.out.println("NO ENCONTRE EL ARCHIVO...");
        }
    }

    public static void guardaInt(int i, String cad) //HACER LOS TRY-CATCH
    {
        try
        {
            FileOutputStream fos = new FileOutputStream("datos/" + cad); //.. = es regresarse a una carpeta anterior (explicacion captura whsp); /datos/ es para ir a la carpeta generada del archivo de Neatbeans
            try
            {
                ObjectOutputStream arch = new ObjectOutputStream(fos);
                arch.writeObject(i);
                arch.close();
            } catch (IOException ex)
            {
                System.out.println("NO SE PUEDE ESCRIBIR EL ARCHIVO...");
            }
        } catch (FileNotFoundException ex)
        {
            System.out.println("NO ENCONTRE EL ARCHIVO...");
        }
    }

    public static Object carga(String cad)
    {
        Object obj = null;
        try
        {
            FileInputStream fis = new FileInputStream("datos/" + cad);
            try
            {
                ObjectInputStream arch = new ObjectInputStream(fis);
                try
                {
                    obj = arch.readObject();
                } catch (ClassNotFoundException ex)
                {
                    System.out.println("NO CORRESPONDEN LAS CLASES...");
                }
                arch.close();
            } catch (IOException ex)
            {
                System.out.println("NO SE PUEDE ESCRIBIR EL ARCHIVO...");
            }
        } catch (FileNotFoundException ex)
        {
            System.out.println("ARCHIVO NO ENCONTRADO...");
        }
        return obj;
    }

//    public static int[] cargaAInt(String cad)
//    {
//        try (FileInputStream fis = new FileInputStream("datos/" + cad); ObjectInputStream arch = new ObjectInputStream(fis))
//        {
//            return (int[]) arch.readObject();
//        } catch (FileNotFoundException e)
//        {
//            System.out.println("Archivo no encontrado: " + cad);
//        } catch (IOException | ClassNotFoundException e)
//        {
//            System.out.println("Error al leer el archivo: " + cad);
//        }
//        return null;
//    }

    public static Object[] carga(String cad, boolean b)
    {
        Object obj[] = null;
        try
        {
            FileInputStream fis = new FileInputStream("datos/" + cad);
            try
            {
                ObjectInputStream arch = new ObjectInputStream(fis);
                try
                {
                    obj = (Object[]) arch.readObject();
                } catch (ClassNotFoundException ex)
                {
                    System.out.println("NO CORRESPONDEN LAS CLASES...");
                }
                arch.close();
            } catch (IOException ex)
            {
                System.out.println("NO SE PUEDE ESCRIBIR EL ARCHIVO...");
            }
        } catch (FileNotFoundException ex)
        {
            System.out.println("ARCHIVO NO ENCONTRADO...");
        }
        return obj;
    }

    public static Object[][] carga(String cad, boolean b, boolean c)
    {
        Object obj[][] = null;
        try
        {
            FileInputStream fis = new FileInputStream("datos/" + cad);
            try
            {
                ObjectInputStream arch = new ObjectInputStream(fis);
                try
                {
                    obj = (Object[][]) arch.readObject();
                } catch (ClassNotFoundException ex)
                {
                    System.out.println("NO CORRESPONDEN LAS CLASES...");
                }
                arch.close();
            } catch (IOException ex)
            {
                System.out.println("NO SE PUEDE ESCRIBIR EL ARCHIVO...");
            }
        } catch (FileNotFoundException ex)
        {
            System.out.println("ARCHIVO NO ENCONTRADO...");
        }
        return obj;
    }
}
