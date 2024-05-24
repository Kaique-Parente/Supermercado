/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.supermercado.views;

import com.mycompany.supermercado.JCustoms.EventSwitchSelected;
import com.mycompany.supermercado.dao.ProdutoDAO;
import com.mycompany.supermercado.models.Produto;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Produtos extends javax.swing.JFrame {

    /**
     * Creates new form Produtos
     */
    boolean status = false;
    Produto produtoAlterar = null;

    public Produtos() {
        initComponents();
        this.setIconImage(new javax.swing.ImageIcon(getClass().getResource("/images/logo.png")).getImage());
        btnStatus.addEventSelected(new EventSwitchSelected() {
            @Override
            public void onSelected(boolean selected) {
                status = selected;
                txtStatus.setText(status == true ? "Em estoque" : "Sem estoque");
            }
        });
    }

    public Produtos(Produto obj) {
        initComponents();
        this.setIconImage(new javax.swing.ImageIcon(getClass().getResource("/images/logo.png")).getImage());

        produtoAlterar = obj;
        txtTituloProduto.setText("Editar Produto");

        DateTimeFormatter fm2 = DateTimeFormatter.ofPattern("ddMMuuuu");

        txtCodBarras.setCod(String.valueOf(produtoAlterar.getCodigo()));
        txtNomeProduto.setText(produtoAlterar.getNome());
        txtMarcaProduto.setText(produtoAlterar.getMarca());
        cbCategoriaProduto.getModel().setSelectedItem(produtoAlterar.getCategoria());
        txtValorProduto.setText(String.valueOf(produtoAlterar.getValor()));
        txtDataValidade.setDate(fm2.format(produtoAlterar.getValidade()));
        txtQuantidadeProduto.setText(String.valueOf(produtoAlterar.getQuantidade()));
        btnStatus.activeButton(produtoAlterar.getStatus());
        txtStatus.setText(produtoAlterar.getStatus() ? "Em estoque" : "Sem estoque");

        btnStatus.addEventSelected(new EventSwitchSelected() {
            @Override
            public void onSelected(boolean selected) {
                status = selected;
                txtStatus.setText(status == true ? "Em estoque" : "Sem estoque");
            }
        });
    }

    public Produtos(Produto obj, boolean t) {
        initComponents();
        this.setIconImage(new javax.swing.ImageIcon(getClass().getResource("/images/logo.png")).getImage());

        produtoAlterar = obj;
        txtTituloProduto.setText("Visualizar Produto");

        DateTimeFormatter fm2 = DateTimeFormatter.ofPattern("ddMMuuuu");

        txtCodBarras.setCod(String.valueOf(produtoAlterar.getCodigo()));
        txtNomeProduto.setText(produtoAlterar.getNome());
        txtMarcaProduto.setText(produtoAlterar.getMarca());
        cbCategoriaProduto.getModel().setSelectedItem(produtoAlterar.getCategoria());
        txtValorProduto.setText(String.valueOf(produtoAlterar.getValor()));
        txtDataValidade.setDate(fm2.format(produtoAlterar.getValidade()));
        txtQuantidadeProduto.setText(String.valueOf(produtoAlterar.getQuantidade()));
        txtStatus.setText(produtoAlterar.getStatus() ? "Em estoque" : "Sem estoque");

        btnConfirmarProduto.setVisible(!t);
        btnCancelarProduto.setText("Voltar");
        btnCancelarProduto.setFont(new Font("Arial", 0, 18));
        btnCancelarProduto.setBackground(new Color(255,80,80));
        btnCancelarProduto.setColor(new Color(255,80,80));
        btnCancelarProduto.setForeground(Color.WHITE);
       
        
        txtCodBarras.setEditableCod(!t);
        txtNomeProduto.setEditable(!t);
        txtMarcaProduto.setEditable(!t);
        cbCategoriaProduto.setEnabled(!t);
        txtValorProduto.setEditable(!t);
        txtDataValidade.setEditableDate(!t);
        txtQuantidadeProduto.setEditable(!t);
        
        btnStatus.activeButton(produtoAlterar.getStatus());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnConfirmar = new com.mycompany.supermercado.JCustoms.ButtonCustom();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        txtTituloProduto = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cbCategoriaProduto = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        lbValor = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtNomeProduto = new com.mycompany.supermercado.JCustoms.TextFiledCustom();
        txtMarcaProduto = new com.mycompany.supermercado.JCustoms.TextFiledCustom();
        txtValorProduto = new com.mycompany.supermercado.JCustoms.TextFiledCustom();
        jPanel5 = new javax.swing.JPanel();
        txtCodBarras = new com.mycompany.supermercado.JCustoms.FormatterCodBarras();
        txtDataValidade = new com.mycompany.supermercado.JCustoms.MyFormatterDate();
        txtStatus = new javax.swing.JLabel();
        btnCancelarProduto = new com.mycompany.supermercado.JCustoms.ButtonCustom();
        btnConfirmarProduto = new com.mycompany.supermercado.JCustoms.ButtonCustom();
        txtQuantidadeProduto = new com.mycompany.supermercado.JCustoms.TextFiledCustom();
        btnStatus = new com.mycompany.supermercado.JCustoms.SwitchButton();

        btnConfirmar.setForeground(new java.awt.Color(0, 0, 0));
        btnConfirmar.setText("Confirmar");
        btnConfirmar.setBorderColor(java.awt.Color.blue);
        btnConfirmar.setBorderPainted(false);
        btnConfirmar.setColorClick(new java.awt.Color(101, 101, 252));
        btnConfirmar.setColorOver(new java.awt.Color(101, 101, 252));
        btnConfirmar.setFocusPainted(false);
        btnConfirmar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnConfirmar.setRadius(15);
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(134, 83, 83));

        txtTituloProduto.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        txtTituloProduto.setForeground(new java.awt.Color(255, 255, 255));
        txtTituloProduto.setText("Novo Produto");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(txtTituloProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(152, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(txtTituloProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jLabel8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Código de Barras");

        jLabel9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Nome do Produto");

        jLabel10.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Marca");

        cbCategoriaProduto.setBackground(new java.awt.Color(255, 255, 255));
        cbCategoriaProduto.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cbCategoriaProduto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "----------", "Açougue", "Aliimentos", "Padaria", "Horti-Fruti", "Higiente Pessoal", "Produtos de Limpeza", "Bebidas", "Pet  Shop" }));
        cbCategoriaProduto.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        cbCategoriaProduto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cbCategoriaProdutoFocusLost(evt);
            }
        });
        cbCategoriaProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCategoriaProdutoActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Categoria");

        lbValor.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbValor.setForeground(new java.awt.Color(0, 0, 0));
        lbValor.setText("Valor");

        jLabel13.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("Quantidade");

        jLabel14.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("Data de Validade");

        jPanel5.setLayout(new java.awt.GridBagLayout());

        txtCodBarras.setBackground(new java.awt.Color(255, 255, 255));
        txtCodBarras.setForeground(new java.awt.Color(0, 0, 0));

        txtDataValidade.setBackground(new java.awt.Color(255, 255, 255));
        txtDataValidade.setForeground(new java.awt.Color(0, 0, 0));

        txtStatus.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtStatus.setForeground(new java.awt.Color(0, 0, 0));
        txtStatus.setText("Sem estoque");

        btnCancelarProduto.setForeground(new java.awt.Color(0, 0, 0));
        btnCancelarProduto.setText("Cancelar");
        btnCancelarProduto.setBorderColor(java.awt.Color.red);
        btnCancelarProduto.setBorderPainted(false);
        btnCancelarProduto.setColorClick(new java.awt.Color(255, 100, 100));
        btnCancelarProduto.setColorOver(new java.awt.Color(255, 80, 80));
        btnCancelarProduto.setFocusPainted(false);
        btnCancelarProduto.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnCancelarProduto.setRadius(15);
        btnCancelarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarProdutoActionPerformed(evt);
            }
        });

        btnConfirmarProduto.setForeground(new java.awt.Color(0, 0, 0));
        btnConfirmarProduto.setText("Confirmar");
        btnConfirmarProduto.setBorderColor(java.awt.Color.blue);
        btnConfirmarProduto.setBorderPainted(false);
        btnConfirmarProduto.setColorClick(new java.awt.Color(101, 101, 252));
        btnConfirmarProduto.setColorOver(new java.awt.Color(101, 101, 252));
        btnConfirmarProduto.setFocusPainted(false);
        btnConfirmarProduto.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnConfirmarProduto.setRadius(15);
        btnConfirmarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarProdutoActionPerformed(evt);
            }
        });

        txtQuantidadeProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQuantidadeProdutoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(281, 281, 281)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(103, 103, 103))
                            .addComponent(txtMarcaProduto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCodBarras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtStatus)
                                    .addComponent(btnStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(105, 105, 105)
                                .addComponent(btnCancelarProduto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(28, 28, 28)
                                .addComponent(btnConfirmarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(cbCategoriaProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtValorProduto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbValor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8)
                                    .addComponent(txtNomeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtDataValidade, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel14))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                                            .addComponent(txtQuantidadeProduto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtCodBarras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(17, 17, 17)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel10))
                                .addGap(3, 3, 3)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtNomeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMarcaProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbCategoriaProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(lbValor)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtValorProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDataValidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtQuantidadeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(txtStatus)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCancelarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnConfirmarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 573, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtValorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtValorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtValorActionPerformed

    private void buttonCustom2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCustom2ActionPerformed
        dispose();
    }//GEN-LAST:event_buttonCustom2ActionPerformed

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed

    }//GEN-LAST:event_btnConfirmarActionPerformed

    private void btnConfirmarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarProdutoActionPerformed

        if (produtoAlterar == null) {
            //Validar Código de Barras
            long codBarras = 0;
            if (txtCodBarras.getCod().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Digite o Código de Barras!", "Erro!", JOptionPane.WARNING_MESSAGE);
            } else {
                codBarras = Long.parseLong(txtCodBarras.getCod());
            }

            //Validar Nome
            String nome = "";
            if (txtNomeProduto.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Digite o Nome do Produto!", "Erro!", JOptionPane.WARNING_MESSAGE);
            } else {
                nome = txtNomeProduto.getText();
            }

            //Marca
            String marca = txtMarcaProduto.getText();

            //Validar Categoria
            String categoria = "";
            if (cbCategoriaProduto.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(rootPane, "Selecione a Categoria!", "Erro!", JOptionPane.WARNING_MESSAGE);
            } else {
                categoria = cbCategoriaProduto.getSelectedItem().toString();
            }

            //Validar Valor
            double valor = 0.0;
            String aux = "";
            if (txtValorProduto.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Digite o valor do Produto!", "Erro!", JOptionPane.WARNING_MESSAGE);
            } else {
                try {
                    aux = txtValorProduto.getText().replace(",", ".");
                    valor = Double.parseDouble(aux);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(rootPane, "Digite o valor corretamente!", "Erro!", JOptionPane.WARNING_MESSAGE);
                }
            }

            //Validade
            DateTimeFormatter fm2 = DateTimeFormatter.ofPattern("ddMMuuuu");
            LocalDate validade = null;
            if (txtDataValidade.getDate().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Digite a validade do Produto!", "Erro!", JOptionPane.WARNING_MESSAGE);
            } else {
                try {
                    validade = LocalDate.parse(txtDataValidade.getDate(), fm2);
                } catch (DateTimeParseException e) {
                    JOptionPane.showMessageDialog(rootPane, "Digite uma data válida!", "Erro!", JOptionPane.WARNING_MESSAGE);
                }
            }

            //Quantidade
            int quantidade = 0;
            if (txtQuantidadeProduto.getText().equals("")) {
                quantidade = 0;
            } else {
                try {
                    quantidade = Integer.parseInt(txtQuantidadeProduto.getText());
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(rootPane, "Digite a quantidade corretamente!", "Erro!", JOptionPane.WARNING_MESSAGE);
                    quantidade = -1;
                }

            }

            //Lista de Produtos
            List<Produto> produtos = new ArrayList<>();

            produtos.add(new Produto(codBarras, nome, marca, categoria, valor, validade, quantidade, status));

            //Tabela
            String codigoS = "";

            for (Produto p : produtos) {
                codigoS = Long.toString(p.getCodigo());

                if (!codigoS.equals("0") && !p.getNome().equals("") && !p.getCategoria().equals("") && p.getValor() != 0.0 && p.getValidade() != null && p.getQuantidade() != -1 && p.getQuantidade() >= 0) {

                    boolean retorno = ProdutoDAO.salvar(p);

                    ImageIcon icon = new ImageIcon("C:\\Supermercado\\src\\main\\resources\\images\\logo.png");
                    Image image = icon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
 
                    if (retorno) {
                        JOptionPane.showMessageDialog(rootPane, "Produto Cadastrado!", "Sucesso!", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(image));
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Erro!");
                    }

                    TelaPrincipal.atualizarTabelaProdutos();
                    status = false;
                    this.dispose();
                }
            }
        } 
        else { //Modo de Alteração
            DateTimeFormatter fm2 = DateTimeFormatter.ofPattern("ddMMuuuu");
            
            long codigo = Long.parseLong(txtCodBarras.getCod());
            String nome = txtNomeProduto.getText();
            String marca = txtMarcaProduto.getText();
            String categoria = cbCategoriaProduto.getSelectedItem().toString();
            double valor = Double.parseDouble(txtValorProduto.getText());
            LocalDate validade = LocalDate.parse(txtDataValidade.getDate(), fm2);
            int quantidade = Integer.parseInt(txtQuantidadeProduto.getText());
            
            String tStatus = txtStatus.getText();
            boolean status = tStatus.equals("Em estoque");
            
            produtoAlterar.setCodigo(codigo);
            produtoAlterar.setNome(nome);
            produtoAlterar.setMarca(marca);
            produtoAlterar.setCategoria(categoria);
            produtoAlterar.setValor(valor);
            produtoAlterar.setValidade(validade);
            produtoAlterar.setQuantidade(quantidade);
            produtoAlterar.setStatus(status);
            
            boolean retorno = ProdutoDAO.alterar(produtoAlterar);
            
            if(retorno) {
                JOptionPane.showMessageDialog(rootPane, "Sucesso!", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
                TelaPrincipal.atualizarTabelaProdutos();
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(rootPane, "Erro!", "Erro!", JOptionPane.WARNING_MESSAGE);
            }
        }

    }//GEN-LAST:event_btnConfirmarProdutoActionPerformed

    private void btnCancelarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarProdutoActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarProdutoActionPerformed

    private void cbCategoriaProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCategoriaProdutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbCategoriaProdutoActionPerformed

    private void cbCategoriaProdutoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cbCategoriaProdutoFocusLost

        String categoria = cbCategoriaProduto.getSelectedItem().toString();

        if (categoria.equals("Açougue") || categoria.equals("Padaria") || categoria.equals("Horti-Fruti")) {
            lbValor.setText("Valor por KG:");
        } else {
            lbValor.setText("Valor por Unidade:");
        }
    }//GEN-LAST:event_cbCategoriaProdutoFocusLost

    private void txtQuantidadeProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQuantidadeProdutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQuantidadeProdutoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Produtos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Produtos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Produtos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Produtos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Produtos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.mycompany.supermercado.JCustoms.ButtonCustom btnCancelarProduto;
    private com.mycompany.supermercado.JCustoms.ButtonCustom btnConfirmar;
    private com.mycompany.supermercado.JCustoms.ButtonCustom btnConfirmarProduto;
    public static com.mycompany.supermercado.JCustoms.SwitchButton btnStatus;
    private javax.swing.JComboBox<String> cbCategoriaProduto;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel lbValor;
    private com.mycompany.supermercado.JCustoms.FormatterCodBarras txtCodBarras;
    private com.mycompany.supermercado.JCustoms.MyFormatterDate txtDataValidade;
    private com.mycompany.supermercado.JCustoms.TextFiledCustom txtMarcaProduto;
    private com.mycompany.supermercado.JCustoms.TextFiledCustom txtNomeProduto;
    private com.mycompany.supermercado.JCustoms.TextFiledCustom txtQuantidadeProduto;
    private javax.swing.JLabel txtStatus;
    private javax.swing.JLabel txtTituloProduto;
    private com.mycompany.supermercado.JCustoms.TextFiledCustom txtValorProduto;
    // End of variables declaration//GEN-END:variables
}
