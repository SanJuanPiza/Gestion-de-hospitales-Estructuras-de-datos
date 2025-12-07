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
public class ListaCircularAnt implements Serializable
{

    private static final long serialVersionUID = 1L;
    private NodoML r;

    public ListaCircularAnt()
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

            if (getR() == null)
            {
                setR(n);
                getR().setSig(n);
                getR().setAnt(n);
            } else
            {
                if (Integer.parseInt(getR().getEtiqueta()) < Integer.parseInt(n.getEtiqueta()) || Integer.parseInt(getR().getSig().getEtiqueta()) > Integer.parseInt(n.getEtiqueta()))
                {
                    n.setSig(getR().getSig());
                    n.setAnt(getR());

                    getR().getSig().setAnt(n);
                    getR().setSig(n);
                    if (Integer.parseInt(getR().getEtiqueta()) < Integer.parseInt(n.getEtiqueta()))
                    {
                        setR(n);
                    }

                } else
                {
                    NodoML aux = getR().getSig();
                    boolean b = false;
                    while (aux.getSig() != null && !b)
                    {
                        if (Integer.parseInt(aux.getSig().getEtiqueta()) > Integer.parseInt(n.getEtiqueta()))
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
            if (Integer.parseInt(getR().getEtiqueta()) < Integer.parseInt(et) || Integer.parseInt(getR().getSig().getEtiqueta()) > Integer.parseInt(et))
            {
                System.out.println("dato no encontrado");
            } else
            {

                if (Integer.parseInt(getR().getSig().getEtiqueta()) == Integer.parseInt(et))
                {
                    nodoE = getR().getSig();
                    getR().setSig(nodoE.getSig());
                    getR().getSig().setAnt(getR());

                    if (getR() == nodoE)
                    {
                        setR(null);
                    }
                    nodoE.setSig(null);
                    nodoE.setAnt(null);
                } else
                {
                    aux = getR().getSig();
                    boolean b = false;
                    while (aux != getR() && !b)
                    {
                        if (Integer.parseInt(aux.getSig().getEtiqueta()) == Integer.parseInt(et))
                        {
                            nodoE = aux.getSig();
                            aux.setSig(nodoE.getSig());
                            aux.getSig().setAnt(aux);
                            if (nodoE == getR())
                            {
                                setR(aux);
                            }
                            nodoE.setSig(null);
                            nodoE.setAnt(null);
                            b = true;
                        } else
                        {
                            if (Integer.parseInt(aux.getSig().getEtiqueta()) > Integer.parseInt(et))
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
        if (getR() == null)
        {
            System.out.println("No hay datos en la lista");
            return;
        }
        NodoML aux = getR().getSig();

        do
        {
            System.out.println(aux.getEtiqueta());
            aux = aux.getSig();

        } while (aux != getR().getSig());

    }

    public void recorridoInverso()
    {
        NodoML aux = getR().getSig();
        if (aux != null)
        {
            do
            {
                aux = aux.getSig();
            } while (aux != getR().getSig());

            do
            {
                System.out.println(aux.getAnt().getEtiqueta());
                aux = aux.getAnt();
            } while (aux != getR().getSig());
        }
    }

}
