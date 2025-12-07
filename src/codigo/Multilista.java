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
public class Multilista<T> implements Serializable
{

    private static final long serialVersionUID = 1L;

    private NodoML r = null;
    public boolean b = false;

    /**
     * @return the r
     */
    public NodoML getR()
    {
        return r;
    }

    /**
     * @param r the r to set
     */
    public void setR(NodoML r)
    {
        this.r = r;
    }

    public boolean getB()
    {
        return b;
    }

    public void setB(boolean b)
    {
        this.b = b;
    }

    public NodoML inserta(NodoML obj, NodoML r, String[] s, int nivel)
    {

        if (nivel == s.length - 1)
        {
            ListaAnt l = new ListaAnt();
            l.setR(r);
            l.insertar(obj);
            b = true;
            return l.getR();
        } else
        {
            NodoML aux = busca(r, s[nivel]);
            if (aux != null)
            {
                aux.setAbj(inserta(obj, aux.getAbj(), s, nivel + 1));
                if (b)
                {
                    obj.setArb(aux);
                    b = false;
                }
            }
//            if (b)
//            {
//                obj.setArb(aux);
//                b = false;
//            }
            return r;
        }

    }

    public void elimina(NodoML r, String[] s, int nivel, NodoML[] arr)
    {

        if (nivel == s.length - 1)
        {
            ListaAnt l = new ListaAnt();
            l.setR(r);
            arr[1] = l.eliminar(s[nivel]);
            arr[1].setArb(null);

            arr[0] = l.getR();
        } else
        {
            NodoML aux = busca(r, s[nivel]);
            if (aux != null)
            {
                elimina(aux.getAbj(), s, nivel + 1, arr);
                aux.setAbj(arr[0]);
            }
            arr[0] = r;
        }
    }

    public NodoML busca(NodoML r, String s)
    {
        while (r != null)
        {
            if (r.getEtiqueta().equals(s))
            {
                return r;
            }
            r = r.getSig();
        }
        return null;
    }

    public String desp(NodoML r, String t)
    {
        String s = "";
        while (r != null)//==
        {
            s += t + r.getEtiqueta() + "\n" + desp(r.getAbj(), t + "\t");//recursion
            r = r.getSig();
        }//else{
        //s+=r.getEt + r.getArr.getEt + "\n" + recursion
        return s;
    }
}
