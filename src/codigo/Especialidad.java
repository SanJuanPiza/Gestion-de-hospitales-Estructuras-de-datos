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
public class Especialidad extends Datos implements Serializable
{

    private static final long serialVersionUID = 1L;
    private String cveE;
    private int noCamas;
    private int noMedicos;

    public Especialidad()
    {
    }

    public Especialidad(String cveE, int noCamas, int noMedicos, String nombre)
    {
        super(nombre);
        this.cveE = cveE;
        this.noCamas = noCamas;
        this.noMedicos = noMedicos;
    }

    /**
     * @return the cveE
     */
    public String getCveE()
    {
        return cveE;
    }

    /**
     * @param cveE the cveE to set
     */
    public void setCveE(String cveE)
    {
        this.cveE = cveE;
    }

    /**
     * @return the noCamas
     */
    public int getNoCamas()
    {
        return noCamas;
    }

    /**
     * @param noCamas the noCamas to set
     */
    public void setNoCamas(int noCamas)
    {
        this.noCamas = noCamas;
    }

    /**
     * @return the noMedicos
     */
    public int getNoMedicos()
    {
        return noMedicos;
    }

    /**
     * @param noMedicos the noMedicos to set
     */
    public void setNoMedicos(int noMedicos)
    {
        this.noMedicos = noMedicos;
    }

    @Override
    public void setNombre(String nombre)
    {
        super.setNombre(nombre);
    }

    @Override
    public String getNombre()
    {
        return super.getNombre();
    }

}
