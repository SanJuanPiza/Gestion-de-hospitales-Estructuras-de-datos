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
public class Hospital extends Datos implements Serializable
{

    private static final long serialVersionUID = 1L;
    private String cveH;
    private String dir;
    private int nivel;

    public Hospital()
    {
    }

    public Hospital(String cveH, String dir, int nivel, String nombre)
    {
        super(nombre);
        this.cveH = cveH;
        this.dir = dir;
        this.nivel = nivel;
    }

    /**
     * @return the cveH
     */
    public String getCveH()
    {
        return cveH;
    }

    /**
     * @param cveH the cveH to set
     */
    public void setCveH(String cveH)
    {
        this.cveH = cveH;
    }

    /**
     * @return the dir
     */
    public String getDir()
    {
        return dir;
    }

    /**
     * @param dir the dir to set
     */
    public void setDir(String dir)
    {
        this.dir = dir;
    }

    /**
     * @return the nivel
     */
    public int getNivel()
    {
        return nivel;
    }

    /**
     * @param nivel the nivel to set
     */
    public void setNivel(int nivel)
    {
        this.nivel = nivel;
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
