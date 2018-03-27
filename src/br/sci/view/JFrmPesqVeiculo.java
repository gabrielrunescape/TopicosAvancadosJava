/*
 * JFrmPesqCurso.java
 *
 * Created on 10 de Agosto de 2008, 21:22
 */

package br.sci.view;

import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
import br.sci.model.Veiculo;
import br.sci.utils.ExcecaoSCA;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import java.awt.event.KeyEvent;
import javax.swing.table.TableColumn;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import br.sci.controller.CtrCadastroVeiculo;
import javax.swing.table.DefaultTableCellRenderer;
/**
 *
 * @author  Administrador
 */
public class JFrmPesqVeiculo extends javax.swing.JPanel {
    private JFrame parent;
    List<Veiculo> veiculos;
    private Veiculo veiculo;
    private TableColumn cColuna = null;
    CtrCadastroVeiculo ctrCadastroVeiculo = CtrCadastroVeiculo.getInstance();
    
    public JFrmPesqVeiculo(JFrame parent) {
        try {
            initComponents();
            this.parent = parent;
            veiculos = ctrCadastroVeiculo.listarTodos();
            atualizarTabela(veiculos);
        } catch (ExcecaoSCA ex) {
             JOptionPane.showMessageDialog(null, ex.getMsg(),"Validação" ,JOptionPane.ERROR_MESSAGE);             
        }
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jToolBar1 = new javax.swing.JToolBar();
        jButtonConsultar = new javax.swing.JButton();
        jButtonNovo = new javax.swing.JButton();
        jButtonAlterar = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();
        jPanel = new javax.swing.JPanel();
        jLabel = new javax.swing.JLabel();
        cbFiltro = new javax.swing.JComboBox();
        jTextFieldPesquisa = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblVeiculo = new javax.swing.JTable();

        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                formKeyTyped(evt);
            }
        });

        jToolBar1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jToolBar1.setRollover(true);
        jToolBar1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jToolBar1KeyPressed(evt);
            }
        });

        jButtonConsultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/sci/recources/text_enriched.png"))); // NOI18N
        jButtonConsultar.setText("Consultar");
        jButtonConsultar.setFocusable(false);
        jButtonConsultar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonConsultar.setMargin(new java.awt.Insets(14, 14, 2, 14));
        jButtonConsultar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConsultarActionPerformed(evt);
            }
        });
        jToolBar1.add(jButtonConsultar);

        jButtonNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/sci/recources/document_new.png"))); // NOI18N
        jButtonNovo.setText("Novo");
        jButtonNovo.setFocusable(false);
        jButtonNovo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonNovo.setMargin(new java.awt.Insets(14, 14, 2, 14));
        jButtonNovo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovoActionPerformed(evt);
            }
        });
        jToolBar1.add(jButtonNovo);

        jButtonAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/sci/recources/textdocument.png"))); // NOI18N
        jButtonAlterar.setText("Alterar");
        jButtonAlterar.setFocusable(false);
        jButtonAlterar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonAlterar.setMargin(new java.awt.Insets(14, 14, 2, 14));
        jButtonAlterar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAlterarActionPerformed(evt);
            }
        });
        jToolBar1.add(jButtonAlterar);

        jButtonExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/sci/recources/entry_delete.png"))); // NOI18N
        jButtonExcluir.setText("Excluir");
        jButtonExcluir.setFocusable(false);
        jButtonExcluir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonExcluir.setMargin(new java.awt.Insets(14, 14, 2, 14));
        jButtonExcluir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });
        jToolBar1.add(jButtonExcluir);

        jLabel.setText("Pesquisar por:");

        cbFiltro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Matrícula", "Nome" }));

        jTextFieldPesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldPesquisaKeyPressed(evt);
            }
        });

        jLabel1.setText("Filtrar por:");

        org.jdesktop.layout.GroupLayout jPanelLayout = new org.jdesktop.layout.GroupLayout(jPanel);
        jPanel.setLayout(jPanelLayout);
        jPanelLayout.setHorizontalGroup(
            jPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanelLayout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jTextFieldPesquisa, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 263, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(jLabel1)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(cbFiltro, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 87, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelLayout.setVerticalGroup(
            jPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanelLayout.createSequentialGroup()
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(jPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(cbFiltro, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel)
                    .add(jTextFieldPesquisa, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel1))
                .add(73, 73, 73))
        );

        tblVeiculo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Modelo", "Fabricação", "Modelo", "Cor", "Chassi", "Cadastro"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblVeiculo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblVeiculoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblVeiculo);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(jToolBar1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 81, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 763, Short.MAX_VALUE))
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(jPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 42, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jToolBar1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 469, Short.MAX_VALUE)
                    .add(jScrollPane2)))
        );
    }// </editor-fold>//GEN-END:initComponents
private void Fechar() {
        int i;
        JTabbedPane j = (JTabbedPane) this.getParent();
        i = j.indexOfComponent(this);
        if (i != -1) {
            this.getParent().remove(i);
        }
    }

    private void configurarBotoes(){
        boolean ok = (tblVeiculo.getRowCount() > 0 );
        jButtonAlterar.setEnabled(ok);
        jButtonExcluir.setEnabled(ok);
        jButtonConsultar.setEnabled(ok);
    }


    private void atualizarTabela(List<Veiculo> veiculos) {
        //limpa campos jtable
        DefaultTableModel dtmLimpar;
        dtmLimpar = (DefaultTableModel) tblVeiculo.getModel();
        dtmLimpar.setNumRows(0);

        DefaultTableModel dtm;

        for (Veiculo v : veiculos){
            dtm = (DefaultTableModel) tblVeiculo.getModel();
            
            dtm.addRow(new Object[]{ 
                v.getID(), v.getModelo(),
                v.getAnoFabricacao(), v.getAnoModelo(),
                v.getCor().getNome(), v.getChassi(), v.getDataCadastroString()
            });
        }
        
        /*tblVeiculo.getColumnModel().getColumn(0).setPreferredWidth(80);
        tblVeiculo.getColumnModel().getColumn(1).setPreferredWidth(100);
        tblVeiculo.getColumnModel().getColumn(2).setPreferredWidth(100);*/
        
        cColuna = tblVeiculo.getColumnModel().getColumn(0);
        
        DefaultTableCellRenderer cAlign = new DefaultTableCellRenderer();
        cAlign.setHorizontalAlignment(JLabel.CENTER);
        cColuna.setCellRenderer(cAlign);
        cAlign = null;
        
        tblVeiculo.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        if (tblVeiculo.getRowCount() > 0 )
            tblVeiculo.setRowSelectionInterval(0, 0);
        
        configurarBotoes();
    }


private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained
    tblVeiculo.requestFocus();
}//GEN-LAST:event_formFocusGained

private void jToolBar1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jToolBar1KeyPressed
       if (evt.getKeyCode()== KeyEvent.VK_ESCAPE )
            Fechar() ;
}//GEN-LAST:event_jToolBar1KeyPressed

private void formKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyTyped
        if (evt.getKeyCode()== KeyEvent.VK_ESCAPE )
            Fechar() ;
}//GEN-LAST:event_formKeyTyped

    private void tblVeiculoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblVeiculoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblVeiculoMouseClicked

    private void jButtonNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovoActionPerformed
        JFrmVeiculo dialog;
        
        try{
            dialog = new JFrmVeiculo(parent, 1, null);
            dialog.setLocationRelativeTo(this);
            dialog.setVisible(true);
            
            if (dialog.isSucesso()) {
                try {
                    veiculos = ctrCadastroVeiculo.listarTodos();
                    atualizarTabela(veiculos);
                } catch (ExcecaoSCA ex) {
                    JOptionPane.showMessageDialog(null,ex.getMsg(), "Validação", JOptionPane.ERROR_MESSAGE);
                }
            }
         } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage(), "Validação", JOptionPane.ERROR_MESSAGE);
         }
    }//GEN-LAST:event_jButtonNovoActionPerformed

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
        if (JOptionPane.showConfirmDialog(null, "Deseja excluir o veiculo '"  + tblVeiculo.getValueAt(tblVeiculo.getSelectedRow(),1) + "'?", "Mensagem de confirmação", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION ) {
            try {
                veiculo = new Veiculo();
                veiculo.setID((Integer) tblVeiculo.getValueAt(tblVeiculo.getSelectedRow(),0));
                ctrCadastroVeiculo.apagar(veiculo);
                veiculos = ctrCadastroVeiculo.listarTodos();
                atualizarTabela(veiculos);
            } catch (ExcecaoSCA ex) {
                 JOptionPane.showMessageDialog(null, ex.getMsg(), "Validação", JOptionPane.ERROR_MESSAGE);             
            }
        }
    }//GEN-LAST:event_jButtonExcluirActionPerformed

    private void jButtonConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConsultarActionPerformed
        try {
            JFrmVeiculo dialog;
            veiculo = new Veiculo();

            veiculo.setID((Integer) tblVeiculo.getValueAt(tblVeiculo.getSelectedRow(), 0));
            ctrCadastroVeiculo.carregar(veiculo);
            
            dialog = new JFrmVeiculo(parent, 3, veiculo);
            dialog.setLocationRelativeTo(this);
            dialog.setVisible(true);
        } catch (ExcecaoSCA ex) {
            JOptionPane.showMessageDialog(null, ex.getMsg(), "Validação",JOptionPane.ERROR_MESSAGE);            
        }
    }//GEN-LAST:event_jButtonConsultarActionPerformed

    private void jButtonAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAlterarActionPerformed
        try {
            JFrmVeiculo dialog;  
            
            veiculo = new Veiculo();
            veiculo.setID((Integer) tblVeiculo.getValueAt(tblVeiculo.getSelectedRow(),0));
            ctrCadastroVeiculo.carregar(veiculo);
            
            dialog = new JFrmVeiculo(parent, 2, veiculo);
            dialog.setLocationRelativeTo(this);
            dialog.setVisible(true);
            
            if (dialog.isSucesso()) {
                veiculos = ctrCadastroVeiculo.listarTodos();
                atualizarTabela(veiculos);
            }
        } catch (ExcecaoSCA ex) {
            JOptionPane.showMessageDialog(null,ex.getMsg(),"Validação",JOptionPane.ERROR_MESSAGE);            
        }
    }//GEN-LAST:event_jButtonAlterarActionPerformed

    private void jTextFieldPesquisaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldPesquisaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                int column = cbFiltro.getSelectedIndex();
                String value = jTextFieldPesquisa.getText();

                veiculos = ctrCadastroVeiculo.listarVeiculos(column, value);
                atualizarTabela(veiculos);
            } catch (ExcecaoSCA ex) {
                JOptionPane.showMessageDialog(null, ex.getMsg(), "Validação", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jTextFieldPesquisaKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JComboBox cbFiltro;
    private javax.swing.JButton jButtonAlterar;
    private javax.swing.JButton jButtonConsultar;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonNovo;
    private javax.swing.JLabel jLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextFieldPesquisa;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTable tblVeiculo;
    // End of variables declaration//GEN-END:variables

}
