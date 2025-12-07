/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package InterfacesAltas;

import cjb.ci.CtrlInterfaz;
import cjb.ci.Validaciones;
import codigo.Especialidad;
import codigo.Hospital;
import codigo.MnpHDEP;
import codigo.NodoML;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

/**
 *
 * @author ErIcK
 */
public class VntAltaPaciente extends javax.swing.JFrame
{

    private Timer timerError;

    /**
     * Creates new form VntAltaDependencia
     */
    public VntAltaPaciente()
    {
        initComponents();
        try
        {
            jcDependencia.setModel(new javax.swing.DefaultComboBoxModel<>(codigo.MnpHDEP.mostrarDependenciasStCmbox()));
            jcHospital.setModel(new javax.swing.DefaultComboBoxModel<>(codigo.MnpHDEP.mostrarHospitalesOrigenCmbox(jcDependencia.getSelectedItem().toString())));
            jcEspecialidad.setModel(new javax.swing.DefaultComboBoxModel<>(codigo.MnpHDEP.mostrarEspecialidadesCmbox(jcDependencia.getSelectedItem().toString(), jcHospital.getSelectedItem().toString())));

            jcDependencia.addActionListener(new java.awt.event.ActionListener()
            {
                @Override
                public void actionPerformed(java.awt.event.ActionEvent evt)
                {
                    String dependenciaSeleccionada = jcDependencia.getSelectedItem().toString();
                    jcHospital.setModel(new javax.swing.DefaultComboBoxModel<>(
                            codigo.MnpHDEP.mostrarHospitalesOrigenCmbox(dependenciaSeleccionada)
                    ));
                    String hospSelec = jcHospital.getSelectedItem().toString();
                    jcEspecialidad.setModel(new javax.swing.DefaultComboBoxModel<>(
                            codigo.MnpHDEP.mostrarEspecialidadesCmbox(dependenciaSeleccionada, hospSelec)
                    ));
                }
            });

            jcHospital.addActionListener(new java.awt.event.ActionListener()
            {
                @Override
                public void actionPerformed(java.awt.event.ActionEvent evt)
                {
                    String dependenciaSeleccionada = jcDependencia.getSelectedItem().toString();
                    String hospSelec = jcHospital.getSelectedItem().toString();
                    jcEspecialidad.setModel(new javax.swing.DefaultComboBoxModel<>(
                            codigo.MnpHDEP.mostrarEspecialidadesCmbox(dependenciaSeleccionada, hospSelec)
                    ));
                }
            });
//            try
//            {
//                String dependencia = jcDependencia.getSelectedItem().toString();
//                String hospital = jcHospital.getSelectedItem().toString();
//                String especialidad = jcEspecialidad.getSelectedItem().toString();
//
//                NodoML<Especialidad> n = MnpHDEP.encontrarEspecialidad(dependencia, hospital, especialidad);
//                int noPacientes = MnpHDEP.calcularPacientes(dependencia, hospital, especialidad);
//                if (noPacientes == n.getObj().getNoCamas())
//                {
//                    JOptionPane.showMessageDialog(this, "Ningun paciente " + " puede ser ingresado en esta especialidad porque ya no hay camas disponibles, intente mas tarde ", "Ingreso paciente", JOptionPane.WARNING_MESSAGE);
//
//                }
//
//                jcEspecialidad.addActionListener(new java.awt.event.ActionListener()
//                {
//                    @Override
//                    public void actionPerformed(java.awt.event.ActionEvent evt)
//                    {
//                        String dependencia = jcDependencia.getSelectedItem().toString();
//                        String hospital = jcHospital.getSelectedItem().toString();
//                        String especialidad = jcEspecialidad.getSelectedItem().toString();
//
//                        NodoML<Especialidad> n = MnpHDEP.encontrarEspecialidad(dependencia, hospital, especialidad);
//                        int noPacientes = MnpHDEP.calcularPacientes(dependencia, hospital, especialidad);
//                        if (noPacientes == n.getObj().getNoCamas())
//                        {
//                            JOptionPane.showMessageDialog(null, "Ningun paciente " + " puede ser ingresado en esta especialidad porque ya no hay camas disponibles, intente mas tarde ", "Ingreso paciente", JOptionPane.WARNING_MESSAGE);
//
//                        }
//                    }
//                });
//            } catch (Exception e)
//            {
//
//            }
        } catch (Exception e)
        {
            JOptionPane.showMessageDialog(this, "Error inesperado", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtNombre = new javax.swing.JTextField();
        btnAceptar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jcDependencia = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jcHospital = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jcEspecialidad = new javax.swing.JComboBox<>();
        jcSexo = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jcStatus = new javax.swing.JComboBox<>();
        jtVigencia = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Alta paciente");
        setType(java.awt.Window.Type.UTILITY);

        jLabel1.setText("Ingresa el nombre del paciente:");

        jLabel2.setText("Ingresa la vigencia del paciente");

        jtNombre.setEnabled(false);
        jtNombre.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                jtNombreKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt)
            {
                jtNombreKeyTyped(evt);
            }
        });

        btnAceptar.setText("Aceptar");
        btnAceptar.setEnabled(false);
        btnAceptar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnAceptarActionPerformed(evt);
            }
        });
        btnAceptar.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                btnAceptarKeyPressed(evt);
            }
        });

        jLabel3.setText("Ingresa el sexo del paciente");

        jLabel4.setText("Selecciona la dependencia a la que pertenece el paciente");

        jcDependencia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcDependencia.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                jcDependenciaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt)
            {
                jcDependenciaKeyReleased(evt);
            }
        });

        jLabel5.setText("Selecciona el hospital al que pertenece el paciente");

        jcHospital.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcHospital.setEnabled(false);
        jcHospital.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                jcHospitalKeyPressed(evt);
            }
        });

        jLabel6.setText("Selecciona la especialidad a la que pertenece el paciente");

        jcEspecialidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcEspecialidad.setEnabled(false);
        jcEspecialidad.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                jcEspecialidadKeyPressed(evt);
            }
        });

        jcSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "m", "f" }));
        jcSexo.setEnabled(false);
        jcSexo.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                jcSexoKeyPressed(evt);
            }
        });

        jLabel7.setText("Ingresa el status del paciente");

        jcStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));
        jcStatus.setEnabled(false);
        jcStatus.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jcStatusActionPerformed(evt);
            }
        });
        jcStatus.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                jcStatusKeyPressed(evt);
            }
        });

        jtVigencia.setEnabled(false);
        jtVigencia.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jtVigenciaActionPerformed(evt);
            }
        });
        jtVigencia.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                jtVigenciaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt)
            {
                jtVigenciaKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jLabel4)
                        .addGap(70, 70, 70)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(141, 141, 141)
                                .addComponent(jcDependencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(149, 149, 149)
                                .addComponent(jcHospital, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jtVigencia, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(104, 104, 104)
                                .addComponent(jcSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(0, 108, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(303, 303, 303)
                        .addComponent(btnAceptar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(151, 151, 151)
                        .addComponent(jcEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jcStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(156, 156, 156))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4))
                        .addGap(29, 29, 29)
                        .addComponent(jtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jcDependencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jcHospital, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(jcEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jtVigencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jcSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(jcStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(102, Short.MAX_VALUE))))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jcStatusActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jcStatusActionPerformed
    {//GEN-HEADEREND:event_jcStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcStatusActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnAceptarActionPerformed
    {//GEN-HEADEREND:event_btnAceptarActionPerformed

        if (jtNombre.getText().trim().length() == 0 || jtVigencia.getText().length() == 0 || jtVigencia.getText().length() != 8 || jcDependencia.getSelectedItem().toString().equals("Sin dependencias registradas") || jcHospital.getSelectedItem().toString().equals("Sin hospitales registrados") || jcEspecialidad.getSelectedItem().toString().equals("Sin especialidades registradas"))
        {
            JOptionPane.showMessageDialog(this, "Ningun campo puede estar vacio, y la fecha completa, para poder llevar a cabo esta acción", "Alta paciente", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if ( MnpHDEP.verificarNoDuplicadosDePaciente(jcDependencia.getSelectedItem().toString(), jcHospital.getSelectedItem().toString(), jcEspecialidad.getSelectedItem().toString(), jtNombre.getText().toLowerCase().trim()))
        {

            JOptionPane.showMessageDialog(this, "No puedes ingresar un paciente con el mismo nombre en esta especialidad ", "Dato no valido", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String nombre = jtNombre.getText().trim();
        String vigencia = jtVigencia.getText();
        String statrus = jcStatus.getSelectedItem().toString();
        char status = statrus.charAt(0);
        String sexos = jcSexo.getSelectedItem().toString();
        char sexo = sexos.charAt(0);

        String dependencia = jcDependencia.getSelectedItem().toString();
        String hospital = jcHospital.getSelectedItem().toString();
        String especialidad = jcEspecialidad.getSelectedItem().toString();
        
        NodoML<Hospital> tm = MnpHDEP.verificarTemporales(dependencia, hospital);
        if (tm != null)
        {
            hospital = tm.getObj().getNombre();
        }

        NodoML<Especialidad> n = MnpHDEP.encontrarEspecialidad(dependencia, hospital, especialidad);
        if (n != null)
        {

            int noPacientes = MnpHDEP.calcularPacientes(dependencia, hospital, especialidad);
            if (noPacientes == n.getObj().getNoCamas())
            {
                JOptionPane.showMessageDialog(this, "El paciente: " + nombre + " no puede ser ingresado porque ya no hay camas disponibles, intente mas tarde ", "Ingreso paciente", JOptionPane.WARNING_MESSAGE);
                return;
            }
        }
        codigo.MnpHDEP.altaPaciente(nombre, vigencia, status, sexo, dependencia, hospital, especialidad);
//        NodoML aux = MnpHDEP.verificarTemporales(dependencia, hospital);

        if (tm != null)
        {
            JOptionPane.showMessageDialog(this, "HOSPITAL EN REMODELACIÓN, CAMBIOS HECHOS EN HOSPITAL TEMPORAL: " + tm.getEtiqueta() + "\n" + "El paciente " + nombre + " fue registrado correctamente", "Ingreso paciente", JOptionPane.INFORMATION_MESSAGE);
        } else
        {
            JOptionPane.showMessageDialog(this, "El paciente " + nombre + " fue registrado correctamente", "Ingreso paciente", JOptionPane.INFORMATION_MESSAGE);
        }

        CtrlInterfaz.limpia(jtNombre, jtVigencia);
        CtrlInterfaz.habilita(false, jtVigencia, jcSexo, jcStatus, btnAceptar, jcHospital, jcEspecialidad, jtNombre);
        CtrlInterfaz.cambia(jcDependencia);
        jcDependencia.setModel(new javax.swing.DefaultComboBoxModel<>(codigo.MnpHDEP.mostrarDependenciasStCmbox()));
        jcHospital.setModel(new javax.swing.DefaultComboBoxModel<>(codigo.MnpHDEP.mostrarHospitalesOrigenCmbox(jcDependencia.getSelectedItem().toString())));
        jcEspecialidad.setModel(new javax.swing.DefaultComboBoxModel<>(codigo.MnpHDEP.mostrarEspecialidadesCmbox(jcDependencia.getSelectedItem().toString(), jcHospital.getSelectedItem().toString())));
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void jtNombreKeyPressed(java.awt.event.KeyEvent evt)//GEN-FIRST:event_jtNombreKeyPressed
    {//GEN-HEADEREND:event_jtNombreKeyPressed
        if (evt.getKeyChar() == '\n' && MnpHDEP.verificarNoDuplicadosDePaciente(jcDependencia.getSelectedItem().toString(), jcHospital.getSelectedItem().toString(), jcEspecialidad.getSelectedItem().toString(), jtNombre.getText().toLowerCase().trim()))
        {

            JOptionPane.showMessageDialog(this, "No puedes ingresar un paciente con el mismo nombre en esta especialidad ", "Dato no valido", JOptionPane.WARNING_MESSAGE);
            return;
        }
        Validaciones.enterCadenaNoVacia(this, evt, jtNombre, jtVigencia);
    }//GEN-LAST:event_jtNombreKeyPressed

    private void jcSexoKeyPressed(java.awt.event.KeyEvent evt)//GEN-FIRST:event_jcSexoKeyPressed
    {//GEN-HEADEREND:event_jcSexoKeyPressed
        if (evt.getKeyChar() == '\n')
        {
            jcStatus.setEnabled(true);
            jcStatus.requestFocus();
        }
    }//GEN-LAST:event_jcSexoKeyPressed

    private void jcStatusKeyPressed(java.awt.event.KeyEvent evt)//GEN-FIRST:event_jcStatusKeyPressed
    {//GEN-HEADEREND:event_jcStatusKeyPressed
        if (evt.getKeyChar() == '\n')
        {
            btnAceptar.setEnabled(true);
            btnAceptar.requestFocus();
        }
    }//GEN-LAST:event_jcStatusKeyPressed

    private void btnAceptarKeyPressed(java.awt.event.KeyEvent evt)//GEN-FIRST:event_btnAceptarKeyPressed
    {//GEN-HEADEREND:event_btnAceptarKeyPressed
        if (evt.getKeyChar() == '\n')
        {
            btnAceptarActionPerformed(null);

        }
    }//GEN-LAST:event_btnAceptarKeyPressed

    private void jcDependenciaKeyPressed(java.awt.event.KeyEvent evt)//GEN-FIRST:event_jcDependenciaKeyPressed
    {//GEN-HEADEREND:event_jcDependenciaKeyPressed
        if (evt.getKeyChar() == '\n' && jcDependencia.getSelectedItem().toString().equals("Sin dependencias registradas"))
        {

            JOptionPane.showMessageDialog(this, "Ingresa este dato para pasar a la siguiente accion ", "Sin datos", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (evt.getKeyChar() == '\n')
        {
            jcHospital.setEnabled(true);
            jcHospital.requestFocus();
        }
    }//GEN-LAST:event_jcDependenciaKeyPressed

    private void jcHospitalKeyPressed(java.awt.event.KeyEvent evt)//GEN-FIRST:event_jcHospitalKeyPressed
    {//GEN-HEADEREND:event_jcHospitalKeyPressed
        if (jcHospital.getSelectedItem().toString().equals("Sin hospitales registrados") && evt.getKeyChar() == '\n')
        {

            JOptionPane.showMessageDialog(this, "Ingresa este dato para pasar a la siguiente accion ", "Sin datos", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (evt.getKeyChar() == '\n')
        {
            jcEspecialidad.setEnabled(true);
            jcEspecialidad.requestFocus();
        }
    }//GEN-LAST:event_jcHospitalKeyPressed

    private void jcEspecialidadKeyPressed(java.awt.event.KeyEvent evt)//GEN-FIRST:event_jcEspecialidadKeyPressed
    {//GEN-HEADEREND:event_jcEspecialidadKeyPressed
        if (evt.getKeyChar() == '\n' && jcEspecialidad.getSelectedItem().toString().equals("Sin especialidades registradas"))
        {

            JOptionPane.showMessageDialog(this, "Ingresa este dato para pasar a la siguiente accion ", "Sin datos", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String dependencia = jcDependencia.getSelectedItem().toString();
        String hospital = jcHospital.getSelectedItem().toString();
        String especialidad = jcEspecialidad.getSelectedItem().toString();

        NodoML<Especialidad> n = MnpHDEP.encontrarEspecialidad(dependencia, hospital, especialidad);
        if (n != null)
        {

            int noPacientes = MnpHDEP.calcularPacientes(dependencia, hospital, especialidad);
            if (evt.getKeyChar() == '\n' && noPacientes == n.getObj().getNoCamas())
            {
                JOptionPane.showMessageDialog(this, "Ningun paciente " + " puede ser ingresado en esta especialidad porque ya no hay camas disponibles, intente mas tarde ", "Ingreso paciente", JOptionPane.WARNING_MESSAGE);
                return;
            }
        }
        if (evt.getKeyChar() == '\n')
        {
            jtNombre.setEnabled(true);
            jtNombre.requestFocus();
        }
    }//GEN-LAST:event_jcEspecialidadKeyPressed

    private void jtNombreKeyTyped(java.awt.event.KeyEvent evt)//GEN-FIRST:event_jtNombreKeyTyped
    {//GEN-HEADEREND:event_jtNombreKeyTyped
        Validaciones.validaAlfabeticos(evt, 40, jtNombre.getText());
    }//GEN-LAST:event_jtNombreKeyTyped

    private void jtVigenciaActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jtVigenciaActionPerformed
    {//GEN-HEADEREND:event_jtVigenciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtVigenciaActionPerformed

    private void jtVigenciaKeyTyped(java.awt.event.KeyEvent evt)//GEN-FIRST:event_jtVigenciaKeyTyped
    {//GEN-HEADEREND:event_jtVigenciaKeyTyped
        char c = evt.getKeyChar();
        String textoActual = jtVigencia.getText().trim();

        // Permitir backspace y delete
        if (c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE)
        {
            return;
        }

        // Limitar a 8 caracteres máximo
        if (textoActual.length() >= 8)
        {
            evt.consume();
            return;
        }

        // Solo permitir números y '/'
        if (!Character.isDigit(c) && c != '/')
        {
            mostrarError("Solo se permiten números y el carácter '/'");
            evt.consume();
            return;
        }

        if (Character.isDigit(c) && (textoActual.length() == 2 || textoActual.length() == 5))
        {
            // Usar SwingUtilities.invokeLater para evitar problemas de concurrencia
            SwingUtilities.invokeLater(() ->
            {
                String textoConBarra = jtVigencia.getText() + "/" + c;
                jtVigencia.setText(textoConBarra);
                jtVigencia.setCaretPosition(textoConBarra.length());
            });
            evt.consume();
            return;
        }

        // Validar posiciones específicas donde debe ir '/'
        if (textoActual.length() == 2 || textoActual.length() == 5)
        {
            if (c != '/')
            {
                mostrarError("Debe ingresar '/' en esta posición. Formato: dd/mm/aa");
                evt.consume();
                return;
            }
        }

        // No permitir '/' en posiciones incorrectas
        if (c == '/' && textoActual.length() != 2 && textoActual.length() != 5)
        {
            mostrarError("El carácter '/' solo va en las posiciones 3 y 6. Formato: dd/mm/aa");
            evt.consume();
            return;
        }

        // Validación en tiempo real según la posición
        validarPorPosicion(textoActual, c, evt);

    }//GEN-LAST:event_jtVigenciaKeyTyped

    private void jtVigenciaKeyPressed(java.awt.event.KeyEvent evt)//GEN-FIRST:event_jtVigenciaKeyPressed
    {//GEN-HEADEREND:event_jtVigenciaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
            String fecha = jtVigencia.getText().trim();

            if (fecha.length() == 8)
            {
                if (validarFechaCompleta(fecha))
                {
                    jcSexo.setEnabled(true);
                    jcSexo.requestFocus();
                }
            } else
            {
                mostrarError("La fecha debe tener el formato dd/mm/aa\nEJEMPLO: 01/07/25");
            }
        }
    }//GEN-LAST:event_jtVigenciaKeyPressed

    private void jcDependenciaKeyReleased(java.awt.event.KeyEvent evt)//GEN-FIRST:event_jcDependenciaKeyReleased
    {//GEN-HEADEREND:event_jcDependenciaKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jcDependenciaKeyReleased

    private void validarPorPosicion(String textoActual, char c, java.awt.event.KeyEvent evt)
    {
        int longitud = textoActual.length();

        switch (longitud)
        {
            case 0: // Primera cifra del día
                if (c < '0' || c > '3')
                {
                    mostrarError("El día debe comenzar con 0, 1, 2 o 3");
                    evt.consume();
                }
                break;

            case 1: // Segunda cifra del día
                char primerDigito = textoActual.charAt(0);
                if (primerDigito == '3' && c > '1')
                {
                    mostrarError("El día no puede ser mayor a 31");
                    evt.consume();
                } else if (primerDigito == '0' && c == '0')
                {
                    mostrarError("El día no puede ser 00");
                    evt.consume();
                }
                break;

            case 3: // Primera cifra del mes
                if (c < '0' || c > '1')
                {
                    mostrarError("El mes debe comenzar con 0 o 1");
                    evt.consume();
                }
                break;

            case 4: // Segunda cifra del mes
                char primerDigitoMes = textoActual.charAt(3);
                if (primerDigitoMes == '1' && c > '2')
                {
                    mostrarError("El mes no puede ser mayor a 12");
                    evt.consume();
                } else if (primerDigitoMes == '0' && c == '0')
                {
                    mostrarError("El mes no puede ser 00");
                    evt.consume();
                }
                break;

            case 6: // Primera cifra del año
            case 7: // Segunda cifra del año
                if (!Character.isDigit(c))
                {
                    mostrarError("Ingrese un número para el año");
                    evt.consume();
                }
                break;
        }
    }

    private boolean validarFechaCompleta(String fecha)
    {
        // Validar formato con regex
        String regex = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{2}$";

        if (!fecha.matches(regex))
        {
            mostrarError("Formato de fecha inválido. Use dd/mm/aa\nEl día debe comenzar con 0, 1, 2 o 3\nEl día no puede ser mayor a 31\nEl día no puede ser 00\nEl mes debe comenzar con 0 o 1\nEl mes no puede ser mayor a 12\nEl mes no puede ser 00");
            return false;
        }

        try
        {
            // Extraer partes de la fecha
            String[] partes = fecha.split("/");
            int dia = Integer.parseInt(partes[0]);
            int mes = Integer.parseInt(partes[1]);
            int anio = Integer.parseInt(partes[2]);

            // Validar días según el mes
            if (!validarDiasPorMes(dia, mes, anio))
            {
                return false;
            }

            return true;

        } catch (NumberFormatException e)
        {
            mostrarError("Error en el formato de la fecha");
            return false;
        }
    }

    private void mostrarError(String mensaje)
    {
        // Usar un timer para no saturar con mensajes
        if (timerError != null && timerError.isRunning())
        {
            return;
        }

        timerError = new Timer(1500, e ->
        {
            // El timer se detiene solo
        });
        timerError.setRepeats(false);
        timerError.start();

        JOptionPane.showMessageDialog(this, mensaje, "Formato de fecha", JOptionPane.WARNING_MESSAGE);
    }

    private boolean validarDiasPorMes(int dia, int mes, int anio)
    {
        // Meses con 30 días
        if ((mes == 4 || mes == 6 || mes == 9 || mes == 11) && dia > 30)
        {
            mostrarError("El mes " + mes + " solo tiene 30 días");
            return false;
        }

        // Febrero
        if (mes == 2)
        {
            // Calcular año completo (asumiendo 20xx para años 00-30, 19xx para 31-99)
            int anioCompleto = (anio <= 30) ? 2000 + anio : 1900 + anio;
            boolean esBisiesto = (anioCompleto % 4 == 0 && anioCompleto % 100 != 0) || (anioCompleto % 400 == 0);

            int maxDiasFebrero = esBisiesto ? 29 : 28;
            if (dia > maxDiasFebrero)
            {
                mostrarError("Febrero del año " + anioCompleto + " solo tiene " + maxDiasFebrero + " días");
                return false;
            }
        }

        return true;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(VntAltaPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(VntAltaPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(VntAltaPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(VntAltaPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new VntAltaPaciente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JComboBox<String> jcDependencia;
    private javax.swing.JComboBox<String> jcEspecialidad;
    private javax.swing.JComboBox<String> jcHospital;
    private javax.swing.JComboBox<String> jcSexo;
    private javax.swing.JComboBox<String> jcStatus;
    private javax.swing.JTextField jtNombre;
    private javax.swing.JTextField jtVigencia;
    // End of variables declaration//GEN-END:variables
}
