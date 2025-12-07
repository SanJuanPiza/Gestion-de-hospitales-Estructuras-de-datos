package codigo;

import java.io.Serializable;

/**
 *
 * @author Cristo
 */
public class Dependencia extends Datos implements Serializable
{

    private static final long serialVersionUID = 1L;
    private String cveD;
    private char tipo;

    public Dependencia()
    {
    }

    public Dependencia(String cveD, char tipo, String nombre)
    {
        super(nombre);
        this.cveD = cveD;
        this.tipo = tipo;
    }

    /**
     * @return the cveD
     */
    public String getCveD()
    {
        return cveD;
    }

    /**
     * @param cveD the cveD to set
     */
    public void setCveD(String cveD)
    {
        this.cveD = cveD;
    }

    /**
     * @return the tipo
     */
    public char getTipo()
    {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(char tipo)
    {
        this.tipo = tipo;
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
