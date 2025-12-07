package codigo;

import java.awt.event.KeyEvent;
import java.io.IOException;

/**
 *
 * @author Cristo
 */
public class MnpHDEP
{

    public static Multilista mList = new Multilista();
    public static int cveArr[] =
    {
        0, 0, 1
    };
    public static ListaAnt listaRef;
    public static Bicola<NodoML> bicola; // = new Bicola<>(new NodoML[100]);

    public static void altaDependencia(String nombre, char tipo)
    {

        String cveD = Datos.generarCve('D', cveArr);

        Dependencia dependencia = new Dependencia(cveD, tipo, nombre);
        NodoML nodo = new NodoML(dependencia, nombre);
        if (mList.getR() == null)
        {
            String pNivel[] =
            {
                nombre
            };

            mList.setR(mList.inserta(nodo, mList.getR(), pNivel, 0));

        } else
        {
            String pNivel[] =
            {
                mList.getR().getEtiqueta()
            };

            mList.setR(mList.inserta(nodo, mList.getR(), pNivel, 0));

        }

        System.out.println("Dependencia creada con exito");
        System.out.println("Clave: " + dependencia.getCveD());

    }

    public static void altaHospital(String nombre, String dir, int nivel, String dependencia)
    {
        if (mList.getR() == null)
        {
            System.out.println("Da de alta una dependencia para poder dar de alta un hospital");
        } else
        {

            String cveH = Datos.generarCve('H', cveArr);

            Hospital hospital = new Hospital(cveH, dir, nivel, nombre);

            String hNivel[] = new String[2];
            hNivel[0] = dependencia;

            NodoML nodo = new NodoML(hospital, nombre);
            mList.setR(mList.inserta(nodo, mList.getR(), hNivel, 0));

            System.out.println("Hospital dado de alta con éxito con clave " + hospital.getCveH());
        }
    }

    public static void altaEspecialidad(String nombre, int noCamas, int noMedicos, String dependencia, String hospital)
    {
        if (mList.getR() == null)
        {
            System.out.println("Da de alta una dependencia para poder dar de alta una especialidad");
        } else
        {
            if (!verificarExistenciaHospital())
            {
                System.out.println("Da de alta un hospital en una dependencia para poder dar de alta una especialidad");
            } else
            {

//                NodoML<Hospital> n = verificarTemporales(dependencia, hospital);
//                if (n != null)
//                {
//                    hospital = n.getEtiqueta();
//                }

                String cveE = Datos.generarCve('E', cveArr);

                Especialidad especialidad = new Especialidad(cveE, noCamas, noMedicos, nombre);

                NodoML nodo = new NodoML(especialidad, nombre);

                String eNivel[] = new String[3];

                eNivel[0] = dependencia;
                eNivel[1] = hospital;

                mList.setR(mList.inserta(nodo, mList.getR(), eNivel, 0));

                System.out.println("Especialidad creada con éxito");
                System.out.println("Clave: " + especialidad.getCveE());

            }
        }
    }

    public static void altaPaciente(String nombre, String vigencia, char status, char sexo, String dependencia, String hospital, String especialidad)
    {
        if (mList.getR() == null)
        {
            System.out.println("Da de alta una dependencia para poder dar de alta una especialidad");
        } else
        {
            if (!verificarExistenciaHospital())
            {
                System.out.println("Da de alta un hospital en una dependencia para poder dar de alta una especialidad y despues un paciente");
            } else
            {
                if (verificarExistenciaEspecialidad())
                {

//                    NodoML<Hospital> n = verificarTemporales(dependencia, hospital);
//                    if (n != null)
//                    {
//                        hospital = n.getEtiqueta();
//                    }

                    String cveP = Datos.generarCve('P', cveArr);

                    Paciente paciente = new Paciente(cveP, status, vigencia, sexo, nombre);

                    NodoML nodo = new NodoML(paciente, nombre);

                    String eNivel[] = new String[4];

                    eNivel[0] = dependencia;
                    eNivel[1] = hospital;
                    eNivel[2] = especialidad;

                    mList.setR(mList.inserta(nodo, mList.getR(), eNivel, 0));

                    System.out.println("Paciente dado de alta con éxito");
                    System.out.println("Clave: " + paciente.getCveP());
                } else
                {
                    System.out.println("Da de alta una especialidad para poder dar de alta un paciente");
                }
            }
        }
    }

    public static NodoML bajaDependencia(String dependencia)
    {
        String s[] =
        {
            dependencia
        };
        NodoML arr[] = new NodoML[2];
        mList.elimina(mList.getR(), s, 0, arr);
        mList.setR(arr[0]);
        return arr[1];
    }

    public static NodoML bajaHospital(String dependencia, String hospital)
    {
//        NodoML<Hospital> n = verificarTemporales(hospital);
//        if (n != null)
//        {
//            String nHospital = n.getEtiqueta();
//
//            String s[] =
//            {
//                dependencia, nHospital
//            };
//            NodoML arr[] = new NodoML[2];
//            mList.elimina(mList.getR(), s, 0, arr);
//            mList.setR(arr[0]);
//        }

        String s[] =
        {
            dependencia, hospital
        };
        NodoML arr[] = new NodoML[2];
        mList.elimina(mList.getR(), s, 0, arr);
        mList.setR(arr[0]);
        return arr[1];
    }

    public static NodoML bajaEspecialidad(String dependencia, String hospital, String especialidad)
    {
//        NodoML<Hospital> n = verificarTemporales(dependencia, hospital);
//        if (n != null)
//        {
//            hospital = n.getEtiqueta();
//        }
        String s[] =
        {
            dependencia, hospital, especialidad
        };
        NodoML arr[] = new NodoML[2];
        mList.elimina(mList.getR(), s, 0, arr);
        mList.setR(arr[0]);
        return arr[1];
    }

    public static NodoML bajaPaciente(String dependencia, String hospital, String especialidad, String paciente)
    {
//        NodoML<Hospital> n = verificarTemporales(dependencia, hospital);
//        if (n != null)
//        {
//            hospital = n.getEtiqueta();
//        }
        String s[] =
        {
            dependencia, hospital, especialidad, paciente
        };
        NodoML arr[] = new NodoML[2];
        mList.elimina(mList.getR(), s, 0, arr);
        mList.setR(arr[0]);
        return arr[1];
    }

    public static String consultaGeneral(NodoML r, String t)
    {
        String s = "";
        if (r != null)
        {
            while (r != null)
            {
                if (r.getArb() != null)
                {
                    s += t + r.getEtiqueta() + "==>" + r.getArb().getEtiqueta() + "\n" + consultaGeneral(r.getAbj(), t + "\t");
                } else
                {
                    s += t + r.getEtiqueta() + "\n" + consultaGeneral(r.getAbj(), t + "\t");
                }
                r = r.getSig();
            }
        }
        return s;
    }

    public static String consultaParticular(String dependencia)
    {

        if (mList.getR() != null)
        {
            NodoML dep = encontrarDependencia(dependencia);
            if (dep != null)
            {
                return dependencia.toUpperCase() + "\n" + consultaGeneral(dep.getAbj(), "");
            }

        }
        return "No se encontro la dependencia";
    }

    public static String consultaSemiParticular(String dependencia)
    {

        if (mList.getR() != null)
        {

            NodoML dep = encontrarDependencia(dependencia);
            if (dep != null)
            {
                String s = dependencia.toUpperCase() + "\n";
                if (dep.getAbj() != null)
                {
                    NodoML hp = dep.getAbj();
                    while (hp != null)
                    {
                        s += "---" + hp.getEtiqueta() + "\n";
                        hp = hp.getSig();
                    }
                    return s;
                } else
                {
                    s += "-- Sin hospitales registrados" + "\n";
                    return s;
                }
            } else
            {
                return "No se encontro la dependencia";
            }

        }
        return "Sin datos";
    }

    public static void modificarDependencia(NodoML<Dependencia> dep, String nombre, char tipo)
    {
        dep.getObj().setNombre(nombre);
        dep.getObj().setTipo(tipo);
    }

    public static void modificarHospital(NodoML<Hospital> hp, String nombre, String dir, int nivel)
    {

        hp.getObj().setNombre(nombre);
        hp.getObj().setDir(dir);
        hp.getObj().setNivel(nivel);
    }

    public static void modificarEspecialidad(NodoML<Especialidad> ep, String nombre, int noCamas, int noMedicos)
    {
        ep.getObj().setNombre(nombre);
        ep.getObj().setNoCamas(noCamas);
        ep.getObj().setNoMedicos(noMedicos);
    }

    public static void modificarPaciente(NodoML<Paciente> pte, String nombre, String vigencia, char sexo, char status)
    {
        pte.getObj().setNombre(nombre);
        pte.getObj().setVigencia(vigencia);
        pte.getObj().setSexo(sexo);
        pte.getObj().setStatus(status);
    }

    public static void mostrarDependencias()
    {
        NodoML tmp = mList.getR();
        if (tmp != null)
        {
            System.out.println("DEPENDENCIAS DISPONIBLES: ");
            while (tmp != null)
            {
                System.out.println("--" + tmp.getEtiqueta());
                tmp = tmp.getSig();
            }
        } else
        {
            System.out.println("Sin dependencias registradas");
        }
        System.out.println("");
    }

    public static String mostrarDependencias(boolean b)
    {

        String r = "";
        if (mList.getR() != null)
        {
            NodoML<Dependencia> tmp = mList.getR();
            r += "DEPENDENCIAS REGISTRADAS: " + "\n";
            while (tmp != null)
            {
                r += "--" + " Nombre: " + tmp.getEtiqueta() + "\n";
                r += "\t" + "Clave: " + tmp.getObj().getCveD() + "\n";
                r += "\t" + "Tipo: " + tmp.getObj().getTipo() + "\n";
                r += "\n";
                tmp = tmp.getSig();
            }
        } else
        {
            r = "Sin dependencias registradas";
        }
        return r;
    }

    public static String[] mostrarDependenciasStCmbox()
    {
        NodoML tmp = mList.getR();
        String[] s = null;
        if (tmp != null)
        {

            while (tmp != null)
            {
                if (s == null)
                {
                    s = new String[1];
                    s[0] = tmp.getEtiqueta();
                } else
                {
                    String[] tmps = new String[s.length + 1];
                    System.arraycopy(s, 0, tmps, 0, s.length);
                    tmps[s.length] = tmp.getEtiqueta();
                    s = tmps;
                }

                tmp = tmp.getSig();
            }
        } else
        {
            s = new String[1];
            s[0] = "Sin dependencias registradas";
        }
        return s;
    }

    public static void mostrarHospitales(String dependencia)
    {
        try
        {
            NodoML tmp = encontrarDependencia(dependencia).getAbj();
            System.out.println("***" + dependencia.toUpperCase() + "***");
            while (tmp != null)
            {
                System.out.println("--" + tmp.getEtiqueta());
                tmp = tmp.getSig();
            }
        } catch (Exception ex)
        {
            System.out.println("");
        }

    }

    public static String[] mostrarHospitalesCmbox(String dependencia)
    {

        try
        {
            NodoML tmp = encontrarDependencia(dependencia).getAbj();
            String[] s = null;

            if (tmp != null)
            {

                while (tmp != null)
                {
                    if (s == null)
                    {
                        s = new String[1];
                        s[0] = tmp.getEtiqueta();
                    } else
                    {
                        String[] tmps = new String[s.length + 1];
                        System.arraycopy(s, 0, tmps, 0, s.length);
                        tmps[s.length] = tmp.getEtiqueta();
                        s = tmps;
                    }

                    tmp = tmp.getSig();
                }
            } else
            {
                s = new String[1];
                s[0] = "Sin hospitales registrados";
            }
            return s;
        } catch (Exception ex)
        {
            String[] s =
            {
                "Sin hospitales registrados"
            };
            return s;
        }

    }

    public static String[] mostrarHospitalesSinRemoCmbox(String dependencia)
    {
        try
        {
            NodoML tmp = encontrarDependencia(dependencia).getAbj();
            String[] s = null;
            boolean b = true;
            if (tmp != null)
            {

                while (tmp != null)
                {

                    if (verificarRemoNodo(dependencia, tmp.getEtiqueta()))
                    {
                        tmp = tmp.getSig();
                        continue;
                    } else
                    {
                        b = false;
                    }

                    if (s == null)
                    {
                        s = new String[1];
                        s[0] = tmp.getEtiqueta();
                    } else
                    {
                        String[] tmps = new String[s.length + 1];
                        System.arraycopy(s, 0, tmps, 0, s.length);
                        tmps[s.length] = tmp.getEtiqueta();
                        s = tmps;
                    }

                    tmp = tmp.getSig();
                }
            } else
            {
                s = new String[1];
                s[0] = "Sin hospitales registrados";
            }
            if (b)
            {
                s = new String[1];
                s[0] = "Sin hospitales registrados";
            }
            return s;
        } catch (Exception e)
        {
            String[] s =
            {
                "Sin hospitales registrados"
            };
            return s;
        }

    }

    public static String[] mostrarHospitalesOrigenCmbox(String dependencia)
    {
        try
        {
            NodoML tmp = encontrarDependencia(dependencia).getAbj();
            String[] s = null;
            boolean b = true;
            if (tmp != null)
            {

                while (tmp != null)
                {

                    if (s == null)
                    {
                        if (verificarRemoOrigen(dependencia, tmp.getEtiqueta()))
                        {
                            b = false;
                            s = new String[1];
                            s[0] = tmp.getEtiqueta();
                        }

                    } else
                    {
                        if (verificarRemoOrigen(dependencia, tmp.getEtiqueta()))
                        {

                            String[] tmps = new String[s.length + 1];
                            System.arraycopy(s, 0, tmps, 0, s.length);
                            tmps[s.length] = tmp.getEtiqueta();
                            s = tmps;
                        }
                    }

                    tmp = tmp.getSig();
                }
            } else
            {
                s = new String[1];
                s[0] = "Sin hospitales registrados";
            }
            if (b)
            {
                s = new String[1];
                s[0] = "Sin hospitales registrados";
            }
            return s;
        } catch (Exception ex)
        {
            String[] s =
            {
                "Sin hospitales registrados"
            };
            return s;
        }

    }

    public static boolean verificarRemo(String hp)
    {
        if (listaRef.getR() != null)
        {
            NodoML<NodoML[]> n = listaRef.getR();
            while (n != null)
            {
                if (n.getObj()[0].getEtiqueta().equals(hp) || n.getObj()[1].getEtiqueta().equals(hp))
                {
                    return true;
                }
                n = n.getSig();
            }

        }
        return false;
    }

    public static boolean verificarRemoNodo(String dep, String hp)
    {
        if (listaRef.getR() != null)
        {
            NodoML<NodoML[]> n = listaRef.getR();
            while (n != null)
            {
                if ((n.getObj()[0].getEtiqueta().equals(hp) || n.getObj()[1].getEtiqueta().equals(hp)) && n.getObj()[0].getArb().getEtiqueta().equals(dep))
                {
                    return true;
                }
                n = n.getSig();
            }

        }
        return false;
    }

    public static boolean verificarRemoOrigen(String dep, String hp)
    {
        if (listaRef.getR() != null)
        {
            NodoML<NodoML[]> n = listaRef.getR();
            while (n != null)
            {
                if (n.getObj()[1].getEtiqueta().equals(hp) && n.getObj()[1].getArb().getEtiqueta().equals(dep))
                {
                    return false;
                }
                n = n.getSig();
            }

        }
        return true;
    }

    public static NodoML verificarTemporales(String dep, String hp)
    {
        if (listaRef.getR() != null)
        {
            NodoML<NodoML[]> n = listaRef.getR();
            while (n != null)
            {
                if (n.getObj()[0].getEtiqueta().equals(hp) && n.getObj()[0].getArb().getEtiqueta().equals(dep))
                {
                    return n.getObj()[1];
                }
                n = n.getSig();
            }

        }
        return null;
    }

    public static String[] mostrarHospitalesSinTercerNivel(String dependencia)
    {
        try
        {
            NodoML<Hospital> tmp = encontrarDependencia(dependencia).getAbj();
            String[] s = null;
            boolean b = true;
            if (tmp != null)
            {

                while (tmp != null)
                {
                    if (tmp.getObj().getNivel() < 3 && verificarRemoOrigen(dependencia, tmp.getObj().getNombre()))
                    {
                        b = false;
                        if (s == null)
                        {
                            s = new String[1];
                            s[0] = tmp.getEtiqueta();
                        } else
                        {
                            String[] tmps = new String[s.length + 1];
                            System.arraycopy(s, 0, tmps, 0, s.length);
                            tmps[s.length] = tmp.getEtiqueta();
                            s = tmps;
                        }
                    }
                    tmp = tmp.getSig();
                }
                if (b)
                {
                    s = new String[1];
                    s[0] = "Sin hospitales registrados con nivel menor a 3";
                }
            } else
            {
                s = new String[1];
                s[0] = "Sin hospitales registrados con nivel menor a 3";
            }
            return s;
        } catch (Exception e)
        {
            String[] s =
            {
                "Sin hospitales registrados con nivel menor a 3"
            };
            return s;
        }

    }

    public static String[] mostrarHospitalesConTercerNivel(String dependencia)
    {
        try
        {
            NodoML<Hospital> tmp = encontrarDependencia(dependencia).getAbj();
            String[] s = null;
            boolean b = true;
            if (tmp != null)
            {

                while (tmp != null)
                {

                    if (tmp.getObj().getNivel() == 3 && verificarRemoOrigen(dependencia, tmp.getObj().getNombre()))
                    {
                        b = false;
                        if (s == null)
                        {
                            s = new String[1];
                            s[0] = tmp.getEtiqueta();
                        } else
                        {
                            String[] tmps = new String[s.length + 1];
                            System.arraycopy(s, 0, tmps, 0, s.length);
                            tmps[s.length] = tmp.getEtiqueta();
                            s = tmps;
                        }
                    }
                    tmp = tmp.getSig();
                }

            } else
            {
                s = new String[1];
                s[0] = "Sin hospitales registrados con nivel 3";
            }
            if (b)
            {
                s = new String[1];
                s[0] = "Sin hospitales registrados con nivel 3";
            }
            return s;
        } catch (Exception e)
        {
            String[] s =
            {
                "Sin hospitales registrados con nivel 3"
            };
            return s;
        }
    }

    public static void mostrarHospitalesCdep()
    {
        NodoML tmp = mList.getR();
        if (tmp != null)
        {
            System.out.println("DATOS DE HOSPITALES REGISTRADOS: ");
            while (tmp != null)
            {
                System.out.println("***" + tmp.getEtiqueta().toUpperCase() + "***");
                if (tmp.getAbj() != null)
                {
                    NodoML aux = tmp.getAbj();
                    while (aux != null)
                    {
                        System.out.println("--" + aux.getEtiqueta());
                        aux = aux.getSig();
                    }
                } else
                {
                    System.out.println("-- Sin hospital registrado");
                }

                tmp = tmp.getSig();
            }
        } else
        {
            System.out.println("Sin dependencias registradas");
        }
        System.out.println("");
    }

    public static String mostrarHospitalesCdep(boolean b)
    {
        NodoML tmp = mList.getR();
        String s = "";
        if (tmp != null)
        {
            s += "DATOS DE HOSPITALES REGISTRADOS: " + "\n";
            while (tmp != null)
            {
                s += "---" + "DEPENDENCIA: " + tmp.getEtiqueta().toUpperCase() + "\n";
                if (tmp.getAbj() != null)
                {
                    NodoML<Hospital> aux = tmp.getAbj();
                    while (aux != null)
                    {
                        s += "--" + "HOSPITAL: " + aux.getEtiqueta() + "\n";
                        s += "\t" + "Clave: " + aux.getObj().getCveH() + "\n";
                        s += "\t" + "Dirección: " + aux.getObj().getDir() + "\n";
                        s += "\t" + "Nivel: " + aux.getObj().getNivel() + "\n";
                        s += "\n";
                        aux = aux.getSig();
                    }
                } else
                {
                    s += "-- Sin hospital registrado" + "\n";
                }

                tmp = tmp.getSig();
            }
        } else
        {
            s += "Sin datos";
        }
        return s;
    }

    public static void mostrarEspecialidadChdep()
    {
        NodoML dep = mList.getR();

        if (dep != null)
        {
            System.out.println("DEPENDENCIAS CON HOSPITALES Y ESPECIALIDADES: ");
            while (dep != null)
            {
                System.out.println("---" + dep.getEtiqueta().toUpperCase() + "***");

                if (dep.getAbj() != null)
                {
                    NodoML hp = dep.getAbj();
                    while (hp != null)
                    {
                        System.out.println("-- HOSPITAL: " + hp.getEtiqueta().toUpperCase());
                        if (hp.getAbj() != null)
                        {
                            NodoML ep = hp.getAbj();
                            while (ep != null)
                            {
                                System.out.println("ESPECIALIDAD: " + ep.getEtiqueta().toUpperCase());
                                ep = ep.getSig();
                            }
                        } else
                        {
                            System.out.println("-- Sin especialidades registradas");
                        }
                        hp = hp.getSig();
                    }
                } else
                {
                    System.out.println("-- Sin hospitales registrados");
                }

                dep = dep.getSig();
            }
        } else
        {
            System.out.println("Sin dependencias registradas");
        }
        System.out.println("");
    }

    public static String mostrarEspecialidadChdep(boolean b)
    {
        NodoML dep = mList.getR();
        String s = "";
        if (dep != null)
        {
            s += "DATOS DE ESPECIALIDADES REGISTRADAS: " + "\n";
            while (dep != null)
            {
                s += "---" + "DEPENDENCIA: " + dep.getEtiqueta().toUpperCase() + "\n";

                if (dep.getAbj() != null)
                {
                    NodoML hp = dep.getAbj();
                    while (hp != null)
                    {
                        s += "-- HOSPITAL: " + hp.getEtiqueta().toUpperCase() + "\n";
                        if (hp.getAbj() != null)
                        {
                            NodoML<Especialidad> ep = hp.getAbj();
                            while (ep != null)
                            {
                                s += "ESPECIALIDAD: " + ep.getEtiqueta() + "\n";
                                s += "\t" + "Clave: " + ep.getObj().getCveE() + "\n";
                                s += "\t" + "Numero de medicos: " + ep.getObj().getNoMedicos() + "\n";
                                s += "\t" + "Numero de camas: " + ep.getObj().getNoCamas() + "\n";
                                s += "\n";
                                ep = ep.getSig();
                            }
                        } else
                        {
                            s += "-- Sin especialidades registradas" + "\n";
                        }
                        hp = hp.getSig();
                    }
                } else
                {
                    s += "-- Sin hospitales registrados" + "\n";
                }

                dep = dep.getSig();
            }
        } else
        {
            s += "Sin dependencias registradas" + "\n";
        }
        return s;
    }

    public static String mostrarPacienteChdep(boolean b)
    {
        NodoML dep = mList.getR();
        String s = "";
        if (dep != null)
        {
            s += "DATOS DE PACIENTES REGISTRADOS: " + "\n";
            while (dep != null)
            {
                s += "---" + "DEPENDENCIA: " + dep.getEtiqueta().toUpperCase() + "\n";

                if (dep.getAbj() != null)
                {
                    NodoML hp = dep.getAbj();
                    while (hp != null)
                    {
                        s += "-- HOSPITAL: " + hp.getEtiqueta().toUpperCase() + "\n";
                        if (hp.getAbj() != null)
                        {
                            NodoML ep = hp.getAbj();
                            while (ep != null)
                            {
                                s += "-ESPECIALIDAD: " + ep.getEtiqueta() + "\n";

                                if (ep.getAbj() != null)
                                {
                                    NodoML<Paciente> pa = ep.getAbj();
                                    while (pa != null)
                                    {
                                        s += "Paciente: " + pa.getEtiqueta() + "\n";
                                        s += "\t" + "Clave: " + pa.getObj().getCveP() + "\n";
                                        s += "\t" + "Vigencia: " + pa.getObj().getVigencia() + "\n";
                                        s += "\t" + "Sexo: " + pa.getObj().getSexo() + "\n";
                                        s += "\t" + "Status: " + pa.getObj().getStatus() + "\n";
                                        s += "\n";
                                        pa = pa.getSig();
                                    }
                                } else
                                {
                                    s += "-- Sin pacientes registradas" + "\n";
                                }

                                ep = ep.getSig();
                            }
                        } else
                        {
                            s += "-- Sin especialidades registradas" + "\n";
                        }
                        hp = hp.getSig();
                    }
                } else
                {
                    s += "-- Sin hospitales registrados" + "\n";
                }

                dep = dep.getSig();
            }
        } else
        {
            s += "Sin dependencias registradas" + "\n";
        }
        return s;
    }

    public static boolean verificarDependencia(String s)
    {
        String p;
        s = s.toLowerCase();
        NodoML tmp = mList.getR();
        if (tmp != null)
        {

            while (tmp != null)
            {
                p = tmp.getEtiqueta().toLowerCase();
                if (p.equals(s))
                {
                    return true;
                }
                tmp = tmp.getSig();
            }
        } else
        {
//            System.out.println("Sin dependencias registradas");
            return false;
        }
        return false;
    }

    public static boolean verificarHospital(String dep, String hospital)
    {
        try
        {
            NodoML tmp = encontrarDependencia(dep).getAbj();
            String p;
            hospital = hospital.toLowerCase();
            while (tmp != null)
            {
                p = tmp.getEtiqueta().toLowerCase();
                if (p.equals(hospital))
                {
                    return true;
                }
                tmp = tmp.getSig();
            }
            return false;
        } catch (Exception e)
        {
            return false;
        }
    }

    public static NodoML encontrarHospital(String dep, String hospital)
    {
        try
        {
            NodoML tmp = encontrarDependencia(dep).getAbj();
            String p;
//            NodoML<Hospital> n = verificarTemporales(dep, hospital);
//            if (n != null)
//            {
//                hospital = n.getEtiqueta();
//            }
            hospital = hospital.toLowerCase();
            while (tmp != null)
            {
                p = tmp.getEtiqueta().toLowerCase();
                if (p.equals(hospital))
                {
                    return tmp;
                }
                tmp = tmp.getSig();
            }
            return null;
        } catch (Exception e)
        {
            return null;
        }
    }

    public static NodoML encontrarEspecialidad(String dep, String hospital, String especialidad)
    {
        try
        {
//            NodoML<Hospital> n = verificarTemporales(dep, hospital);
//            if (n != null)
//            {
//                hospital = n.getEtiqueta();
//            }
            NodoML tmp = encontrarHospital(dep, hospital).getAbj();
            String p;
            especialidad = especialidad.toLowerCase();
            while (tmp != null)
            {
                p = tmp.getEtiqueta().toLowerCase();
                if (p.equals(especialidad))
                {
                    return tmp;
                }
                tmp = tmp.getSig();
            }
            return null;
        } catch (Exception e)
        {
            return null;
        }
    }

    public static boolean verificarEspecialidad(String dep, String hospital, String especialidad)
    {
        try
        {
            NodoML ep = encontrarHospital(dep, hospital).getAbj();
            String p;
            especialidad = especialidad.toLowerCase();
            while (ep != null)
            {
                p = ep.getEtiqueta().toLowerCase();
                if (p.equals(especialidad))
                {
                    return true;
                }
                ep = ep.getSig();
            }
            return false;
        } catch (Exception e)
        {
            return false;
        }
    }

    public static void mostrarEspecialidades(String dep, String hospital)
    {
        NodoML ep = encontrarHospital(dep, hospital).getAbj();
        if (ep != null)
        {
            System.out.println("ESPECIALIDADES REGISTRADAS: ");
            while (ep != null)
            {
                System.out.println("--" + ep.getEtiqueta().toUpperCase());
                ep = ep.getSig();
            }
        } else
        {
            System.out.println("Sin especialidades registradas");
        }

    }

    public static String[] mostrarEspecialidadesCmbox(String dep, String hospital)
    {
        try
        {
            NodoML tmp = null;
            NodoML<Hospital> n = verificarTemporales(dep, hospital);
            if (n != null)
            {
//                hospital = n.getEtiqueta();
                tmp = n.getAbj();

            } else
            {
                tmp = encontrarHospital(dep, hospital).getAbj();

            }
            String[] s = null;
            if (tmp != null)
            {

                while (tmp != null)
                {
                    if (s == null)
                    {
                        s = new String[1];
                        s[0] = tmp.getEtiqueta();
                    } else
                    {
                        String[] tmps = new String[s.length + 1];
                        System.arraycopy(s, 0, tmps, 0, s.length);
                        tmps[s.length] = tmp.getEtiqueta();
                        s = tmps;
                    }

                    tmp = tmp.getSig();
                }
            } else
            {
                s = new String[1];
                s[0] = "Sin especialidades registradas";
            }
            return s;
        } catch (Exception ex)
        {
            String[] s = null;
            s = new String[1];
            s[0] = "Sin especialidades registradas";
            return s;
        }

    }

    public static String[] mostrarPacientesCmbox(String dep, String hospital, String dependencia)
    {
        try
        {

            NodoML<Hospital> n = verificarTemporales(dep, hospital);
            if (n != null)
            {
                hospital = n.getEtiqueta();
            }

            NodoML tmp = encontrarEspecialidad(dep, hospital, dependencia).getAbj();
            String[] s = null;
            if (tmp != null)
            {

                while (tmp != null)
                {
                    if (s == null)
                    {
                        s = new String[1];
                        s[0] = tmp.getEtiqueta();
                    } else
                    {
                        String[] tmps = new String[s.length + 1];
                        System.arraycopy(s, 0, tmps, 0, s.length);
                        tmps[s.length] = tmp.getEtiqueta();
                        s = tmps;
                    }

                    tmp = tmp.getSig();
                }
            } else
            {
                s = new String[1];
                s[0] = "Sin pacientes registrados";
            }
            return s;
        } catch (Exception e)
        {
            String[] s =
            {
                "Sin pacientes registrados"
            };
            return s;
        }

    }

    public static boolean verificarExistenciaHospital()
    {
        NodoML tmp = mList.getR();

        while (tmp != null)
        {
            if (tmp.getAbj() != null)
            {
                return true;
            } else
            {
                tmp = tmp.getSig();
            }
        }
        return false;
    }

    public static boolean verificarExistenciaEspecialidad()
    {
        if (mList.getR() != null)
        {
            NodoML dep = mList.getR();
            while (dep != null)
            {
                if (dep.getAbj() != null)
                {
                    NodoML hp = dep.getAbj();
                    while (hp != null)
                    {
                        if (hp.getAbj() != null)
                        {
                            return true;
                        }
                        hp = hp.getSig();
                    }
                }
                dep = dep.getSig();
            }
        }
        return false;
    }

    public static NodoML encontrarDependencia(String s)
    {
        String p;
        s = s.toLowerCase();
        NodoML tmp = mList.getR();
        if (tmp != null)
        {

            while (tmp != null)
            {
                p = tmp.getEtiqueta().toLowerCase();
                if (p.equals(s))
                {
                    return tmp;
                }
                tmp = tmp.getSig();
            }
        } else
        {
//            System.out.println("Sin dependencias registradas");
            return null;
        }
        return null;
    }

    public static int pintaMenu(String mnu[], String tit)
    {
        System.out.println("===== " + tit + " ======");
        for (int i = 0; i < mnu.length; i++)
        {
            System.out.println((i + 1) + ".-" + mnu[i]);
        }
        System.out.println("Elige una opción:");
        return Lecturas.leerEntero(true);
    }

    public static NodoML buscarPaciente(String dependencia, String hospital, String especialidad, String paciente)
    {
        try
        {
//            NodoML<Hospital> n = verificarTemporales(dependencia, hospital);
//            if (n != null)
//            {
//                hospital = n.getEtiqueta();
//            }
            NodoML tmp = encontrarEspecialidad(dependencia, hospital, especialidad).getAbj();
            String p;
            paciente = paciente.toLowerCase();
            while (tmp != null)
            {
                p = tmp.getEtiqueta().toLowerCase();
                if (p.equals(paciente))
                {
                    return tmp;
                }
                tmp = tmp.getSig();
            }
            return null;
        } catch (Exception e)
        {
            return null;
        }
    }

    public static void iniciarRemodelacion(String nombre, String dir, String dep, String hp)
    {
        try
        {
            NodoML<Hospital> n = encontrarHospital(dep, hp);
            int nivel = n.getObj().getNivel();
            altaHospital(nombre, dir, nivel, dep);
            NodoML tmp;

            while (n.getAbj() != null)
            {

                tmp = bajaEspecialidad(dep, hp, n.getAbj().getEtiqueta());
                String s[] = new String[3];
                s[0] = dep;
                s[1] = nombre;
                mList.setR(mList.inserta(tmp, mList.getR(), s, 0));
            }

            NodoML<Hospital> arr[] = new NodoML[2];
            arr[0] = encontrarHospital(dep, hp);
            arr[1] = encontrarHospital(dep, nombre);
            NodoML ref = new NodoML(arr, arr[1].getObj().getCveH()); // poner clave

            listaRef.insertar(ref);
        } catch (Exception e)
        {

        }
    }

    public static void terminarRemodelacion(String dep, String hp)
    {
        try
        {
            NodoML<Hospital> hpTmp = buscarHospitalEnRemodelacion(1, dep, hp);
            NodoML ep;

            while (hpTmp.getAbj() != null)
            {
                ep = bajaEspecialidad(dep, hpTmp.getEtiqueta(), hpTmp.getAbj().getEtiqueta());
                String s[] = new String[3];
                s[0] = dep;
                s[1] = hp;
                mList.setR(mList.inserta(ep, mList.getR(), s, 0));

            }

            listaRef.eliminar(hpTmp.getObj().getCveH()); //poner clave
            bajaHospital(dep, hpTmp.getEtiqueta());
        } catch (Exception e)
        {

        }
    }

    public static NodoML buscarHospitalEnRemodelacion(int n, String dep, String hp)
    {
        NodoML<NodoML[]> r = listaRef.getR();
        while (r != null)
        {
            if (r.getObj()[0].getEtiqueta().equals(hp))
            {

                if (n == 0 && r.getObj()[0].getArb().getEtiqueta().equals(dep))
                {
                    NodoML[] t = r.getObj();
                    return t[0];
                } else if (n == 1 && r.getObj()[1].getArb().getEtiqueta().equals(dep))
                {
                    NodoML[] t = r.getObj();
                    return t[1];
                }

            }
            r = r.getSig();
        }
        return null;
    }

    public static void subirTercerNivel(String dep, String hp)
    {
        try
        {
            NodoML<Hospital> n = encontrarHospital(dep, hp);
            n.getObj().setNivel(3);
//            NodoML<Hospital> aux = verificarTemporales(dep, hp);
//            if (aux != null)
//            {
//                hp = aux.getEtiqueta();
//                aux.getObj().setNivel(3);
//            }

            altaEspecialidad("Neurocirugía", 10, 3, dep, hp); // probar
            altaEspecialidad("Oncología", 10, 3, dep, hp);
        } catch (Exception e)
        {

        }

    }

    public static void bajarTercerNivel(String dep, String hp)
    {
//        try
//        {
        NodoML<Hospital> n = encontrarHospital(dep, hp);
        n.getObj().setNivel(2);
//            NodoML<Hospital> aux = verificarTemporales(dep, hp);
//            if (aux != null)
//            {
//
//                hp = aux.getEtiqueta();
//                aux.getObj().setNivel(2);
//            }
        NodoML onco = encontrarEspecialidad(dep, hp, "Oncología");
        NodoML neuro = encontrarEspecialidad(dep, hp, "Neurocirugía");

        boolean a = onco.getAbj() == null;
        boolean b = neuro.getAbj() == null;

        if (a && b)
        {
            bajaEspecialidad(dep, hp, "Oncología");
            bajaEspecialidad(dep, hp, "Neurocirugía");

        } else
        {
            if (!a)
            {
                NodoML<Especialidad> nEsp = encontrarHospitalConOncologia(dep, hp);
                while (nEsp != null && !a)
                {
//                        while (calcularPacientes(dep, hp, nEsp.getEtiqueta()) < nEsp.getObj().getNoCamas())
//                        {
                    NodoML<Paciente> paciente = bajaPaciente(dep, hp, "Oncología", onco.getAbj().getEtiqueta());
                    String[] s = new String[4];
                    s[0] = dep;
                    s[1] = nEsp.getArb().getEtiqueta();
                    s[2] = "Oncología";
                    mList.setR(mList.inserta(paciente, mList.getR(), s, 0));
//                        }

                    a = onco.getAbj() == null;
                    nEsp = encontrarHospitalConOncologia(dep, hp);
                }

                while (onco.getAbj() != null && !bicola.llena())
                {
                    NodoML<Paciente> paciente = bajaPaciente(dep, hp, "Oncología", onco.getAbj().getEtiqueta());
                    bicola.setA1(bicola.inserta(paciente, bicola.getA1(), bicola.getA2(), 1));
                }
            }

            if (!b)
            {
                NodoML<Especialidad> nEsp = encontrarHospitalConNeuro(dep, hp);
                while (nEsp != null && !b)
                {
//                        while (calcularPacientes(dep, hp, nEsp.getEtiqueta()) < nEsp.getObj().getNoCamas())
//                        {
                    NodoML<Paciente> paciente = bajaPaciente(dep, hp, "Neurocirugía", neuro.getAbj().getEtiqueta());
                    String[] s = new String[4];
                    s[0] = dep;
                    s[1] = nEsp.getArb().getEtiqueta();
                    s[2] = "Neurocirugía";
                    mList.setR(mList.inserta(paciente, mList.getR(), s, 0));
//                        }

                    b = neuro.getAbj() == null;
                    nEsp = encontrarHospitalConNeuro(dep, hp);
                }

                while (neuro.getAbj() != null && !bicola.llena())
                {
                    NodoML<Paciente> paciente = bajaPaciente(dep, hp, "Neurocirugía", neuro.getAbj().getEtiqueta());
                    bicola.setA2(bicola.inserta(paciente, bicola.getA2(), bicola.getA1(), -1));
                }
            }
            bajaEspecialidad(dep, hp, "Oncología");
            bajaEspecialidad(dep, hp, "Neurocirugía");

        }

//        } catch (Exception e)
//        {
//            NodoML<Hospital> n = encontrarHospital(dep, hp);
//            n.getObj().setNivel(2);
//            bajaEspecialidad(dep, hp, "Oncología");
//            bajaEspecialidad(dep, hp, "Neurocirugía");
//        }
    }

    public static NodoML encontrarHospitalConOncologia(String dep, String hp)
    {
        try
        {
            NodoML<Hospital> h = encontrarHospital(dep, hp);
            NodoML<Hospital> izq = h.getAnt();
            NodoML<Hospital> der = h.getSig();
            while (izq != null || der != null)
            {
                if (izq != null)
                {
                    NodoML<Especialidad> oncoIzq = encontrarEspecialidad(dep, izq.getObj().getNombre(), "Oncología");

                    if (oncoIzq != null && calcularPacientes(dep, oncoIzq.getArb().getEtiqueta(), oncoIzq.getEtiqueta()) < oncoIzq.getObj().getNoCamas())
                    {
                        return oncoIzq;
                    }
                    izq = izq.getAnt();
                }

                if (der != null)
                {

                    NodoML<Especialidad> oncoDer = encontrarEspecialidad(dep, der.getObj().getNombre(), "Oncología");

                    if (oncoDer != null && calcularPacientes(dep, oncoDer.getArb().getEtiqueta(), oncoDer.getEtiqueta()) < oncoDer.getObj().getNoCamas())
                    {
                        return oncoDer;
                    }
                    der = der.getSig();
                }

            }
            return null;
        } catch (Exception e)
        {
            return null;
        }

    }

    public static NodoML encontrarHospitalConNeuro(String dep, String hp)
    {
        try
        {
            NodoML<Hospital> h = encontrarHospital(dep, hp);
            NodoML<Hospital> izq = h.getAnt();
            NodoML<Hospital> der = h.getSig();
            while (izq != null || der != null)
            {
                if (izq != null)
                {
                    NodoML<Especialidad> neuroIzq = encontrarEspecialidad(dep, izq.getObj().getNombre(), "Neurocirugía");

                    if (neuroIzq != null && calcularPacientes(dep, neuroIzq.getArb().getEtiqueta(), neuroIzq.getEtiqueta()) < neuroIzq.getObj().getNoCamas())
                    {
                        return neuroIzq;
                    }
                    izq = izq.getAnt();
                }

                if (der != null)
                {

                    NodoML<Especialidad> neuroDer = encontrarEspecialidad(dep, der.getObj().getNombre(), "Neurocirugía");

                    if (neuroDer != null && calcularPacientes(dep, neuroDer.getArb().getEtiqueta(), neuroDer.getEtiqueta()) < neuroDer.getObj().getNoCamas())
                    {
                        return neuroDer;
                    }
                    der = der.getSig();
                }

            }
            return null;
        } catch (Exception e)
        {
            return null;
        }
    }

    public static int calcularPacientes(String dep, String hp, String esp)
    {
        try
        {
//            NodoML<Hospital> aux = verificarTemporales(dep, hp);
//            if (aux != null)
//            {
//                hp = aux.getEtiqueta();
//            }
            NodoML e = encontrarEspecialidad(dep, hp, esp).getAbj();
            int cont = 0;
            while (e != null)
            {
                cont += 1;
                e = e.getSig();
            }
            return cont;
        } catch (Exception e)
        {
            return 0;
        }
    }

    public static NodoML darAltaPaciente(String dep, String hp, String esp, String pnt)
    {
        try
        {
            boolean b;
//            NodoML<Hospital> aux = verificarTemporales(dep, hp);
//            if (aux != null)
//            {
//                hp = aux.getEtiqueta();
//            }

            bajaPaciente(dep, hp, esp, pnt);

            if ("Oncología".equals(esp))
            {
                if (!bicola.vacia())
                {
                    if (bicola.getA1() != -1)
                    {
                        Object[] de = bicola.elimina(bicola.getA1(), -1, 1);
                        NodoML<Paciente> np = (NodoML<Paciente>) de[0];
                        bicola.setA1((int) de[1]);

                        altaPaciente(np.getObj().getNombre(), np.getObj().getVigencia(),
                                np.getObj().getStatus(), np.getObj().getSexo(),
                                dep, hp, esp);
                        return np;
                    }
                }
            } else if ("Neurocirugía".equals(esp))
            {
                if (!bicola.vacia())
                {
                    if (bicola.getA2() != bicola.getArr().length)
                    {
                        Object[] de = bicola.elimina(bicola.getA2(), bicola.getArr().length, -1);
                        NodoML<Paciente> np = (NodoML<Paciente>) de[0];
                        bicola.setA2((int) de[1]);

                        altaPaciente(np.getObj().getNombre(), np.getObj().getVigencia(),
                                np.getObj().getStatus(), np.getObj().getSexo(),
                                dep, hp, esp);
                        return np;
                    }
                }
            }
        } catch (Exception e)
        {
            try
            {
                NodoML<Hospital> aux = verificarTemporales(dep, hp);
                if (aux != null)
                {
                    hp = aux.getEtiqueta();
                }
                bajaPaciente(dep, hp, esp, pnt);
                return null;
            } catch (Exception ex)
            {

                bajaPaciente(dep, hp, esp, pnt);
                return null;
            }
        }
        return null;
    }

    public static String[] buscarHospitalesEnRemodelacion()
    {
        String[] s = null;
        if (listaRef.getR() != null)
        {
            NodoML<NodoML[]> r = listaRef.getR();
            while (r != null)
            {
                if (s == null)
                {
                    s = new String[1];
                    s[0] = r.getEtiqueta();
                } else
                {
                    String[] tmp = new String[s.length + 1];
                    System.arraycopy(s, 0, tmp, 0, s.length);
                    tmp[s.length] = r.getEtiqueta();
                    s = tmp;
                }
                r = r.getSig();
            }

        } else
        {
            s = new String[1];
            s[0] = "Sin hospitales en remodelación";
        }
        return s;
    }

    public static String[] buscarHospitalesEnRemodelacionVn(String dep)
    {
        String[] s = null;
        boolean b = true;
        if (listaRef.getR() != null)
        {
            NodoML<NodoML[]> r = listaRef.getR();
            while (r != null)
            {
                if (r.getObj()[0].getArb().getEtiqueta().equals(dep))
                {
                    b = false;
                    if (s == null)
                    {
                        s = new String[1];
                        s[0] = r.getObj()[0].getEtiqueta();
                    } else
                    {
                        String[] tmp = new String[s.length + 1];
                        System.arraycopy(s, 0, tmp, 0, s.length);
                        tmp[s.length] = r.getObj()[0].getEtiqueta();
                        s = tmp;
                    }
                }
                r = r.getSig();
            }
            if (b)
            {
                s = new String[1];
                s[0] = "Sin hospitales en remodelación";
            }

        } else
        {
            s = new String[1];
            s[0] = "Sin hospitales en remodelación";
        }
        return s;
    }

    public static String[] buscarDependenciasConHenRemodelacion()
    {
        String[] s = null;
        if (listaRef.getR() != null)
        {
            NodoML<NodoML[]> r = listaRef.getR();
            while (r != null)
            {
                String et = r.getObj()[0].getArb().getEtiqueta();
                if (verificarDuplicadosCmboxDepHenRem(s, et))
                {

                    if (s == null)
                    {
                        s = new String[1];
                        s[0] = et;
                    } else
                    {
                        String[] tmp = new String[s.length + 1];
                        System.arraycopy(s, 0, tmp, 0, s.length);
                        tmp[s.length] = et;
                        s = tmp;
                    }
                }
                r = r.getSig();
            }

        } else
        {
            s = new String[1];
            s[0] = "Sin dependencias con hospitales en remodelación";
        }
        return s;
    }

    public static boolean verificarDuplicadosCmboxDepHenRem(String[] s, String cad)
    {
        if (s == null)
        {
            return true;
        } else
        {
            for (int i = 0; i < s.length; i++)
            {
                if (s[i].equals(cad))
                {
                    return false;
                }
            }
        }
        return true;
    }

//    public static void cambiaNombreRemo(String hp, String nombre)
//    {
//        NodoML n = listaRef.getR();
//        while (n != null)
//        {
//            if (hp.equals(n.getEtiqueta()))
//            {
//                n.setEtiqueta(nombre);
//                return;
//            }
//            n = n.getSig();
//        }
//    }
    public static void validaFecha(KeyEvent ke, int len, String s)
    {
        char c = ke.getKeyChar();

        if (s.length() >= len)
        {
            ke.consume();
            return;
        }

        if (!Character.isDigit(c) && c != '/')
        {
            ke.consume();
            return;
        }

        int pos = s.length();

        if ((pos == 2 || pos == 5) && c != '/')
        {

            ke.consume();
        } else if ((pos != 2 && pos != 5) && c == '/')
        {

            ke.consume();
        }
    }

    public static boolean verificarDuplicadosDependencias(String dependencia)
    {
        dependencia = dependencia.toLowerCase();
        String p;

        NodoML tmp = mList.getR();
        if (tmp != null)
        {

            while (tmp != null)
            {
                p = tmp.getEtiqueta().toLowerCase();
                if (p.equals(dependencia))
                {
                    return true;
                }
                tmp = tmp.getSig();
            }
        } else
        {
//            System.out.println("Sin dependencias registradas");
            return false;
        }
        return false;
    }

//    public static String mostrarDependenciaDeHpRm(String hp)
//    {
//        if (listaRef.getR() != null)
//        {
//            NodoML n = verificarTemporales(hp);
//            if (n != null)
//            {
//                return "Dependencia a la que pertenece el hospital temporal: " + n.getArb().getEtiqueta();
//            } else
//            {
//                return "Sin hospitales en remodelación";
//            }
//        } else
//        {
//            return "Sin hospitales en remodelación";
//        }
//    }
    public static boolean verificarNoDuplicadosDeHospital(String dep, String hp)
    {
        if (mList.getR() != null)
        {
            NodoML d = encontrarDependencia(dep);
            hp = hp.toLowerCase().trim();
            if (d != null)
            {
                NodoML<Hospital> ro = d.getAbj();
                while (ro != null)
                {
                    if (ro.getObj().getNombre().toLowerCase().equals(hp))
                    {
                        return true;
                    }
                    ro = ro.getSig();

                }
            }
        }
        return false;
    }

    public static boolean verificarNoDuplicadosDeEspecialidad(String dep, String hp, String esp)
    {
        if (mList.getR() != null)
        {
            NodoML<Hospital> ver = verificarTemporales(dep, hp);
            if (ver != null)
            {
                hp = ver.getObj().getNombre();
            }
            NodoML d = encontrarHospital(dep, hp);
            esp = esp.toLowerCase().trim();
            if (d != null)
            {
                NodoML<Especialidad> ro = d.getAbj();
                while (ro != null)
                {
                    if (ro.getObj().getNombre().toLowerCase().equals(esp))
                    {
                        return true;
                    }
                    ro = ro.getSig();

                }
            }
        }
        return false;
    }

    public static boolean verificarNoDuplicadosDePaciente(String dep, String hp, String esp, String pa)
    {
        if (mList.getR() != null)
        {
            NodoML<Hospital> ver = verificarTemporales(dep, hp);
            if (ver != null)
            {
                hp = ver.getObj().getNombre();
            }
            NodoML d = encontrarEspecialidad(dep, hp, esp);
            pa = pa.toLowerCase().trim();
            if (d != null)
            {
                NodoML<Paciente> ro = d.getAbj();
                while (ro != null)
                {
                    if (ro.getObj().getNombre().toLowerCase().equals(pa))
                    {
                        return true;
                    }
                    ro = ro.getSig();

                }
            }
        }
        return false;
    }
}
