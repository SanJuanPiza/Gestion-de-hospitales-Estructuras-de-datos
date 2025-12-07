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
public class ListaAnt<T> implements Serializable
{

    private static final long serialVersionUID = 1L;

    private NodoML r;

    public ListaAnt()
    {
        r = null;
    }

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

    public void insertar(NodoML n)
    {
        if (n != null)
        {
            NodoML aux = getR();
            if (aux == null)
            {
                setR(n);
            } else
            {
                if (aux.getEtiqueta().compareTo(n.getEtiqueta()) > 0)
                {
                    n.setSig(aux);
                    aux.setAnt(n);
                    setR(n);
                } else
                {
                    boolean b = false;
                    while (aux.getSig() != null && !b)
                    {
                        if (aux.getSig().getEtiqueta().compareTo(n.getEtiqueta()) > 0)
                        {
                            n.setSig(aux.getSig());
                            n.setAnt(aux);
                            aux.setSig(n);
                            aux.getSig().getSig().setAnt(n);
                            b = true;
                        } else
                        {
                            aux = aux.getSig();
                        }
                    }
                    if (!b)
                    {
                        aux.setSig(n);
                        n.setAnt(aux);
                    }
                }
            }
        }
    }

    public NodoML eliminar(String et)
    {
        NodoML aux, nodoE = null;

        if (getR() == null)
        {
            System.out.println("Lista vacia");
        } else
        {
            if (getR().getEtiqueta().compareTo(et) > 0)
            {
                System.out.println("dato no encontrado");
            } else
            {
                aux = getR();
                if (getR().getEtiqueta().compareTo(et) == 0)
                {
                    nodoE = getR();
                    setR(aux.getSig());
                    if (getR() != null)
                    {
                        getR().setAnt(null);
                    }
                    nodoE.setSig(null);
                } else
                {
                    boolean b = false;
                    while (aux.getSig() != null && !b)
                    {
                        if (aux.getSig().getEtiqueta().compareTo(et) == 0)
                        {
                            nodoE = aux.getSig();
                            aux.setSig(nodoE.getSig());
                            if (nodoE.getSig() != null)
                            {
                                nodoE.getSig().setAnt(aux);
                            }
                            nodoE.setSig(null);
                            nodoE.setAnt(null);
                            b = true;
                        } else
                        {
                            if (aux.getSig().getEtiqueta().compareTo(et) > 0)
                            {
                                break;
                            } else
                            {
                                aux = aux.getSig();
                            }
                        }
                    }
                    if (!b)
                    {
                        System.out.println("dato no encontrado");
                    }
                }
            }
        }
        return nodoE;
    }

    public void recorrido()
    {
        NodoML aux = getR();
        while (aux != null)
        {
            System.out.println(aux.getEtiqueta());
            aux = aux.getSig();
        }
    }

    public void recorridoInverso()
    {
        NodoML aux = getR();
        if (aux != null)
        {
            while (aux.getSig() != null)
            {

                aux = aux.getSig();
            }
            while (aux != null)
            {
                System.out.println(aux.getEtiqueta());
                aux = aux.getAnt();

            }
        }
    }

}
