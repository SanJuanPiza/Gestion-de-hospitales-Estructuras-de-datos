/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codigo;

import java.io.Serializable;

/**
 *
 * @author LSE
 */
public class Bicola<T> implements Serializable
{

    private static final long serialVersionUID = 1L;

    private T arr[];
    private int a1 = -1;
    private int a2 = -1;

    public Bicola(T arr[])
    {
        this.arr = arr;
        a2 = arr.length;
    }

    /**
     * @return the arr
     */
    public T[] getArr()
    {
        return arr;
    }

    /**
     * @param arr the arr to set
     */
    public void setArr(T[] arr)
    {
        this.arr = arr;
    }

    public int getA1()
    {
        return a1;
    }

    public int getA2()
    {
        return a2;
    }

    public void setA1(int a1)
    {
        this.a1 = a1;
    }

    public void setA2(int a2)
    {
        this.a2 = a2;
    }

    public boolean vacia()
    {
        return this.a1 == -1 && this.a2 == this.arr.length;
    }

    public boolean llena()
    {
        return a1 + 1 == a2;
    }

    public int inserta(T obj, int a, int lim, int f)
    {
        if (a + f == lim)
        {
            System.out.println("Bicola llena");
        } else
        {
            arr[a + f] = obj;
        }
        return a + f;
    }

    public Object[] elimina(int a, int lim, int f)
    {
        Object de[] = new Object[2];

        if (a == lim)
        {
            System.out.println("Bicola vacia");
            de[1] = a;
        } else
        {
            de[0] = arr[lim + f];
            for (int i = lim + f; i != a; i += f)
            {
                arr[i] = arr[i + f];
            }
            de[1] = a - f;
        }
        return de;
    }

}
