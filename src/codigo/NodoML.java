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
public class NodoML<T> implements Serializable
{

    private static final long serialVersionUID = 1L;

    private T obj;
    private String etiqueta;
    private NodoML sig;
    private NodoML ant;
    private NodoML arb;
    private NodoML abj;

    public NodoML(T obj, String etiqueta)
    {
        this.obj = obj;
        this.etiqueta = etiqueta;
    }

    /**
     * @return the obj
     */
    public T getObj()
    {
        return obj;
    }

    /**
     * @param obj the obj to set
     */
    public void setObj(T obj)
    {
        this.obj = obj;
    }

    /**
     * @return the etiqueta
     */
    public String getEtiqueta()
    {
        return etiqueta;
    }

    /**
     * @param etiqueta the etiqueta to set
     */
    public void setEtiqueta(String etiqueta)
    {
        this.etiqueta = etiqueta;
    }

    /**
     * @return the sig
     */
    public NodoML getSig()
    {
        return sig;
    }

    /**
     * @param sig the sig to set
     */
    public void setSig(NodoML sig)
    {
        this.sig = sig;
    }

    /**
     * @return the ant
     */
    public NodoML getAnt()
    {
        return ant;
    }

    /**
     * @param ant the ant to set
     */
    public void setAnt(NodoML ant)
    {
        this.ant = ant;
    }

    /**
     * @return the arb
     */
    public NodoML getArb()
    {
        return arb;
    }

    /**
     * @param arb the arb to set
     */
    public void setArb(NodoML arb)
    {
        this.arb = arb;
    }

    /**
     * @return the abj
     */
    public NodoML getAbj()
    {
        return abj;
    }

    /**
     * @param abj the abj to set
     */
    public void setAbj(NodoML abj)
    {
        this.abj = abj;
    }

}
