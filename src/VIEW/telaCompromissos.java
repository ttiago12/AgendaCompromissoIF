/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package VIEW;

import CONTROLLER.CompromissoController;
import MODEL.Compromisso;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 
 */
public class telaCompromissos extends javax.swing.JInternalFrame {

    //ajuda fazer pesquisa
    
    private int idUsuario;
    DefaultTableModel tbCompromissos;
    ArrayList<Compromisso> compromissos;
    telaPrincipal telaPrincipal;
    
    /**
     * Creates new form telaCompromissos
     */
    public telaCompromissos(int idUsuario , telaPrincipal tela) {
        initComponents();
        
        this.idUsuario = idUsuario;
        this.telaPrincipal = tela;
        
        tbCompromissos =  (DefaultTableModel) jtbCompromissos.getModel();
        
        this.listarCompromissos(idUsuario,"","","");
    }
    
    //metodo responsavel por listar todos os compromissos do usuario
    // Metodo responsavel por listar todos os compromisso do usuario
     public void listarCompromissos(int idUsuario, String titulo, String  dataInicio, String dataTermino){     
         CompromissoController controller = new CompromissoController();
         
         compromissos = controller.buscarCompromisso(idUsuario);
         
         this.removerLinhas();
         
         if(jrbTodos.isSelected()){
           compromissos = controller.buscarCompromisso(idUsuario);   
           
         }else if(jrbTitulo.isSelected()){
           compromissos = controller.buscarCompromisso(idUsuario, titulo);  
         }else if(jrbData.isSelected()){
             compromissos = controller.buscarCompromisso(idUsuario, dataInicio, dataTermino);
         }
         
         for(Compromisso temp : compromissos){
           tbCompromissos.addRow(new Object[]{temp.getCodigo(), temp.getTitulo(), temp.getDataInicio(), temp.getHoraInicio()});         
        }
     }
    
    public void removerLinhas(){
         int linhas = tbCompromissos.getRowCount();
         for (int i = linhas - 1; i >= 0; i--){
             tbCompromissos.removeRow(i);
         }
     }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jrbTitulo = new javax.swing.JRadioButton();
        jrbData = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jtfTitulo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtfDataInicial = new javax.swing.JFormattedTextField();
        jtfDataFinal = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbCompromissos = new javax.swing.JTable();
        jbCancelar = new javax.swing.JButton();
        jbDeletar = new javax.swing.JButton();
        jbAlterar = new javax.swing.JButton();
        jrbTodos = new javax.swing.JRadioButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Compromissos");

        jLabel1.setText("Pesquisar por :");

        buttonGroup1.add(jrbTitulo);
        jrbTitulo.setText("Titulo");
        jrbTitulo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jrbTituloItemStateChanged(evt);
            }
        });

        buttonGroup1.add(jrbData);
        jrbData.setText("Data");
        jrbData.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jrbDataItemStateChanged(evt);
            }
        });
        jrbData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbDataActionPerformed(evt);
            }
        });

        jLabel2.setText("Titulo: ");

        jtfTitulo.setEnabled(false);
        jtfTitulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfTituloActionPerformed(evt);
            }
        });

        jLabel3.setText("Data:");

        try {
            jtfDataInicial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jtfDataInicial.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtfDataInicial.setEnabled(false);
        jtfDataInicial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfDataInicialActionPerformed(evt);
            }
        });

        try {
            jtfDataFinal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jtfDataFinal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtfDataFinal.setEnabled(false);
        jtfDataFinal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfDataFinalActionPerformed(evt);
            }
        });

        jLabel4.setText("Até");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/Pesquisar.png"))); // NOI18N
        jButton1.setText("Pesquisar Compromisso");

        jtbCompromissos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Titulo", "Data", "Hora"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jtbCompromissos);

        jbCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/cancelar.png"))); // NOI18N
        jbCancelar.setText("Cancelar");
        jbCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCancelarActionPerformed(evt);
            }
        });

        jbDeletar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/excluir.png"))); // NOI18N
        jbDeletar.setText("Deletar");
        jbDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbDeletarActionPerformed(evt);
            }
        });

        jbAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/alterar.png"))); // NOI18N
        jbAlterar.setText("Alterar");
        jbAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAlterarActionPerformed(evt);
            }
        });

        buttonGroup1.add(jrbTodos);
        jrbTodos.setSelected(true);
        jrbTodos.setText("Todos");
        jrbTodos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jrbTodosItemStateChanged(evt);
            }
        });
        jrbTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbTodosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbCancelar)
                        .addGap(29, 29, 29)
                        .addComponent(jbDeletar)
                        .addGap(29, 29, 29)
                        .addComponent(jbAlterar))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(6, 6, 6)
                            .addComponent(jrbTodos)
                            .addGap(18, 18, 18)
                            .addComponent(jrbTitulo)
                            .addGap(15, 15, 15)
                            .addComponent(jrbData))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jtfDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(27, 27, 27)
                                    .addComponent(jLabel4)
                                    .addGap(33, 33, 33)
                                    .addComponent(jtfDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jtfTitulo)))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 545, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton1))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jrbTitulo)
                    .addComponent(jrbData)
                    .addComponent(jrbTodos))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtfTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtfDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jtfDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbCancelar)
                    .addComponent(jbDeletar)
                    .addComponent(jbAlterar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jrbDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbDataActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jrbDataActionPerformed

    private void jtfDataInicialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfDataInicialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfDataInicialActionPerformed

    private void jtfDataFinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfDataFinalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfDataFinalActionPerformed

    private void jtfTituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfTituloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfTituloActionPerformed

    private void jbAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAlterarActionPerformed
        // TODO add your handling code here:
        int idCompromisso = Integer.parseInt(jtbCompromissos.getValueAt(jtbCompromissos.getSelectedRow(), 0).toString());
        
        telaCadCompromisso tela = new telaCadCompromisso(0, this.idUsuario, idCompromisso);
        tela.setVisible(true);
        this.telaPrincipal.jdpPrincipal.add(tela);
        this.dispose();
    }//GEN-LAST:event_jbAlterarActionPerformed

    private void jbCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jbCancelarActionPerformed

    private void jrbTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbTodosActionPerformed
        
    }//GEN-LAST:event_jrbTodosActionPerformed

    private void jrbTodosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jrbTodosItemStateChanged
        if(jrbTodos.isSelected()){
            jtfTitulo.setEnabled(false);
            jtfDataFinal.setEnabled(false);
            jtfDataInicial.setEnabled(false);
            jtfTitulo.setText("");
            jtfDataInicial.setText("");
            jtfDataFinal.setText("");
            
        }
    }//GEN-LAST:event_jrbTodosItemStateChanged

    private void jrbTituloItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jrbTituloItemStateChanged
        // desativando campos caso o titulo estiver selecionado
        if(jrbTitulo.isSelected()){
            jtfTitulo.setEnabled(true);
            jtfDataFinal.setEnabled(false);
            jtfDataInicial.setEnabled(false);
            jtfTitulo.setText("");
            jtfDataInicial.setText("");
            jtfDataFinal.setText("");
        }
    }//GEN-LAST:event_jrbTituloItemStateChanged

    private void jrbDataItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jrbDataItemStateChanged
        // TODO add your handling code here:
        if(jrbData.isSelected()){
            jtfTitulo.setEnabled(false);
            jtfDataFinal.setEnabled(true);
            jtfDataInicial.setEnabled(true);
            jtfTitulo.setText("");
            jtfDataInicial.setText("");
            jtfDataFinal.setText("");
        }
    }//GEN-LAST:event_jrbDataItemStateChanged

    private void jbDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbDeletarActionPerformed
        // TODO add your handling code here:
         int opcao = JOptionPane.showConfirmDialog(null,"Deseja realmente excluir este compromisso?", 
                "Mensagem do sistema", JOptionPane.INFORMATION_MESSAGE);
        if(opcao == 0) {
            CompromissoController controller = new CompromissoController();
            controller.apagar(idUsuario);
            tbCompromissos.removeRow(jtbCompromissos.getSelectedRow());
        }
    }//GEN-LAST:event_jbDeletarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbAlterar;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JButton jbDeletar;
    private javax.swing.JRadioButton jrbData;
    private javax.swing.JRadioButton jrbTitulo;
    private javax.swing.JRadioButton jrbTodos;
    private javax.swing.JTable jtbCompromissos;
    private javax.swing.JFormattedTextField jtfDataFinal;
    private javax.swing.JFormattedTextField jtfDataInicial;
    private javax.swing.JTextField jtfTitulo;
    // End of variables declaration//GEN-END:variables
}
