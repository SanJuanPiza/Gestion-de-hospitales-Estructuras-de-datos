/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codigo;

import java.io.Serializable;

/**
 *
 * @author Cristo
 */
public class Datos implements Serializable
{

    private static final long serialVersionUID = 1L;
    private static int cve;
    private String nombre;

    public Datos()
    {
    }

    public Datos(int cve, String nombre)
    {
        this.cve = cve;
        this.nombre = nombre;
    }
    
    public Datos(String nombre)
    {
        this.nombre = nombre;
    }

    /**
     * @return the cve
     */
    public int getCve()
    {
        return cve;
    }

    /**
     * @param cve the cve to set
     */
    public void setCve(int cve)
    {
        this.cve = cve;
    }
    
    /**
     * @return the nombre
     */
    public String getNombre()
    {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public static String generarCve(char c, int arr[])
    {
        String cve = "";
        for (int i = 0; i < arr.length; i++)
        {
            cve += String.valueOf(arr[i]);
        }
        
        aumentarCve(arr);
        
        return c + cve;
    }
    
    public static int[] aumentarCve(int arr[]){
        cve++;
        for (int i = arr.length-1; i >= 0; i--)
        {
            if (arr[i] < 9)
            {
                arr[i]++;
                return arr;
            }
            arr[i] = 0;
        }
        arr = new int[arr.length + 1];
        arr[0] = 1;
        return arr;
        
    }

}
