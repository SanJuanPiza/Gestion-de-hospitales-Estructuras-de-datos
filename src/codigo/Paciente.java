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
public class Paciente extends Datos implements Serializable
{

    private static final long serialVersionUID = 1L;
    private String cveP;
    private char status;
    private String vigencia;
    private char sexo;

    public Paciente()
    {
    }

    public Paciente(String cveP, char status, String vigencia, char sexo, String nombre)
    {
        super(nombre);
        this.cveP = cveP;
        this.status = status;
        this.vigencia = vigencia;
        this.sexo = sexo;
    }

    /**
     * @return the cveP
     */
    public String getCveP()
    {
        return cveP;
    }

    /**
     * @param cveP the cveP to set
     */
    public void setCveP(String cveP)
    {
        this.cveP = cveP;
    }

    /**
     * @return the status
     */
    public char getStatus()
    {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(char status)
    {
        this.status = status;
    }

    /**
     * @return the vigencia
     */
    public String getVigencia()
    {
        return vigencia;
    }

    /**
     * @param vigencia the vigencia to set
     */
    public void setVigencia(String vigencia)
    {
        this.vigencia = vigencia;
    }

    /**
     * @return the sexo
     */
    public char getSexo()
    {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(char sexo)
    {
        this.sexo = sexo;
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
