/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senactech.MCadastroPessoa.view;

import br.com.senactech.MCadastroPessoa.model.Pessoa;
import javax.swing.JOptionPane;

import br.com.senactech.MCadastroPessoa.util.ValidaCPF;
import java.util.regex.PatternSyntaxException;
import javax.swing.JButton;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import static mcadastropessoaJF.MCadastroPessoaJF.cadPessoas;

/**
 *
 * @author jairb
 */
public class pessoaCadastro extends javax.swing.JFrame {

    JButton btnClick = null;

    /**
     * Creates new form pessoaCadastro
     */
    public pessoaCadastro() {
        initComponents();
        this.setLocationRelativeTo(null);
//        cadPessoas.mokPessoas();
        addRowToTable();
    }

    public void addRowToTable() {
        //Cria obj model e recebe a modelagem da tabela JtPessoa do JFrame
        DefaultTableModel model = (DefaultTableModel) jtPessoas.getModel();
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        Object rowData[] = new Object[4]; //cria vetor para as colunas da tabela
        for (Pessoa p : cadPessoas.getAll()) {
            rowData[0] = p.getNomePessoa();
            rowData[1] = p.getCpf();
            rowData[2] = p.getTelefone();
            if (p.isStatus()) {
                rowData[3] = "Ativo";
            } else {
                rowData[3] = "Inativo";
            }
            model.addRow(rowData);
        }
    }

    public void jTableFilterClear() {
        DefaultTableModel model = (DefaultTableModel) jtPessoas.getModel();
        final TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);
        jtPessoas.setRowSorter(sorter);
        sorter.setRowFilter(null);
    }

    public Boolean validaImputs() {
        String telefone = jtfTelefone.getText();
        if (jtfNome.getText().isBlank()
                || jtfCPF.getText().isBlank()
                || jtfEndereco.getText().isBlank()
                || jtfIdade.getText().isBlank()
                || jtfTelefone.getText().isBlank()
                || bgStatus.getSelection() == null) {
            JOptionPane.showMessageDialog(this,
                    "Todos os campos devem ser preenchidos!",
                    ".: Erro :.", JOptionPane.ERROR_MESSAGE);
            jtfNome.requestFocus();
            return false;
        }
        if (telefone.length() != 10 && telefone.length() != 11) {
            JOptionPane.showMessageDialog(this,
                    "Telefone informado esta incorreto",
                    ".: Erro :.", JOptionPane.ERROR_MESSAGE);
            jtfTelefone.requestFocus();
            return false;
        }
        if (!jtfIdade.getText().isBlank()) {
            int idade = Integer.parseInt(jtfIdade.getText());
            if (idade == 0 || idade > 120) {
                JOptionPane.showMessageDialog(this,
                        "Idade informada esta incorreta!",
                        ".: Erro :.", JOptionPane.ERROR_MESSAGE);
                jtfIdade.requestFocus();
                return false;
            }
        }
        if (btnClick.getText() == "Salvar") {
            if (!ValidaCPF.isCPF(jtfCPF.getText())) {
                JOptionPane.showMessageDialog(this,
                        "CPF informado esta incorreto!!!",
                        ".: Erro :.", JOptionPane.ERROR_MESSAGE);
                jtfCPF.requestFocus();
                return false;
            } else if (cadPessoas.verCPF(jtfCPF.getText())) {
                JOptionPane.showMessageDialog(this,
                        "CPF já cadastrado!!!",
                        ".: Erro :.", JOptionPane.ERROR_MESSAGE);
                jtfCPF.requestFocus();
                return false;
            }
        }
        return true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgStatus = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jtfEndereco = new javax.swing.JTextField();
        jtfCPF = new javax.swing.JTextField();
        jtfNome = new javax.swing.JTextField();
        jtfTelefone = new javax.swing.JTextField();
        jtfIdade = new javax.swing.JTextField();
        jrbAtivo = new javax.swing.JRadioButton();
        jrbInativo = new javax.swing.JRadioButton();
        jbSalvar = new javax.swing.JButton();
        jbLimpar = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtPessoas = new javax.swing.JTable();
        jbSair = new javax.swing.JButton();
        jbDeletar = new javax.swing.JButton();
        jbConfirmar = new javax.swing.JButton();
        jbEditar = new javax.swing.JButton();
        jbPesqCPF = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastro Pessoa");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 204));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Cadastro Pessoa");

        jSeparator1.setForeground(new java.awt.Color(255, 204, 51));

        jLabel1.setText("Nome:");

        jLabel3.setText("CPF:");

        jLabel4.setText("Endereço:");

        jLabel5.setText("Celular:");

        jLabel6.setText("Idade:");

        jLabel7.setText("Status:");

        jtfEndereco.setToolTipText("Endereço completo");

        jtfCPF.setToolTipText("Somente números");
        jtfCPF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfCPFKeyTyped(evt);
            }
        });

        jtfNome.setToolTipText("Nome completo");
        jtfNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfNomeKeyTyped(evt);
            }
        });

        jtfTelefone.setToolTipText("DD998889988");
        jtfTelefone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfTelefoneKeyTyped(evt);
            }
        });

        jtfIdade.setToolTipText("Somente números");
        jtfIdade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfIdadeKeyTyped(evt);
            }
        });

        bgStatus.add(jrbAtivo);
        jrbAtivo.setText("Ativo");

        bgStatus.add(jrbInativo);
        jrbInativo.setText("Inativo");

        jbSalvar.setText("Salvar");
        jbSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalvarActionPerformed(evt);
            }
        });

        jbLimpar.setText("Limpar");
        jbLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLimparActionPerformed(evt);
            }
        });

        jSeparator2.setForeground(new java.awt.Color(255, 204, 0));

        jtPessoas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "CPF", "Telefone", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtPessoas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtPessoasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtPessoas);

        jbSair.setText("Sair");
        jbSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSairActionPerformed(evt);
            }
        });

        jbDeletar.setText("Deletar");
        jbDeletar.setEnabled(false);
        jbDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbDeletarActionPerformed(evt);
            }
        });

        jbConfirmar.setText("Confirmar");
        jbConfirmar.setEnabled(false);
        jbConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbConfirmarActionPerformed(evt);
            }
        });

        jbEditar.setText("Editar");
        jbEditar.setEnabled(false);
        jbEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEditarActionPerformed(evt);
            }
        });

        jbPesqCPF.setForeground(new java.awt.Color(0, 0, 255));
        jbPesqCPF.setText("Pesquisar CPF");
        jbPesqCPF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbPesqCPFActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfEndereco)
                            .addComponent(jtfNome)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jtfTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6)
                                .addGap(12, 12, 12)
                                .addComponent(jtfIdade, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jrbAtivo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jrbInativo)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jtfCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jbPesqCPF)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jbEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbConfirmar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jbSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jbLimpar))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jbDeletar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jbSair)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtfCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbPesqCPF))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jtfEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jtfTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jtfIdade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jrbAtivo)
                    .addComponent(jrbInativo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbSalvar)
                    .addComponent(jbLimpar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbSair)
                    .addComponent(jbDeletar)
                    .addComponent(jbConfirmar)
                    .addComponent(jbEditar))
                .addGap(187, 187, 187))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 10, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 536, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLimparActionPerformed
        // TODO add your handling code here:
        jtfCPF.setText("");
        jtfEndereco.setText("");
        jtfIdade.setText("");
        jtfNome.setText("");
        jtfTelefone.setText("");
        bgStatus.clearSelection();
        jtfNome.requestFocus();

        jtfCPF.setEnabled(true);
        jbSalvar.setEnabled(true);
        jbPesqCPF.setEnabled(true);
        jbEditar.setEnabled(false);
        jbConfirmar.setEnabled(false);
        jbDeletar.setEnabled(false);
        
        jTableFilterClear();
    }//GEN-LAST:event_jbLimparActionPerformed

    private void jtfCPFKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfCPFKeyTyped
        // TODO add your handling code here:
        String caracteres = "0987654321";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_jtfCPFKeyTyped

    private void jtfIdadeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfIdadeKeyTyped
        // TODO add your handling code here:
        String caracteres = "0987654321";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_jtfIdadeKeyTyped

    /**
     * jtfNomeKeyTyped Aceita qualquer tecla diferente da String abaixo
     *
     * @param evt
     */
    private void jtfNomeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfNomeKeyTyped
        // TODO add your handling code here:
        String caracteres = "0987654321/[]{}=+-_)(*&¨%$#@!<>;:?";
        if (caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_jtfNomeKeyTyped

    /**
     * jtfTelefoneKeyTyped Aceita somente números
     *
     * @param evt
     */
    private void jtfTelefoneKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfTelefoneKeyTyped
        // TODO add your handling code here:
        String caracteres = "0987654321";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_jtfTelefoneKeyTyped

    private void jbSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalvarActionPerformed
        // TODO add your handling code here:
        btnClick = (JButton) evt.getSource();
        System.out.println(btnClick.getText());

        if (validaImputs()) {
            int id = cadPessoas.gerarId();
            String nomePessoa = jtfNome.getText();
            String cpf = jtfCPF.getText();
            String endereco = jtfEndereco.getText();
            String telefone = jtfTelefone.getText();
            int idade = Integer.parseInt(jtfIdade.getText());
            boolean status = jrbAtivo.isSelected();

            Pessoa p = new Pessoa(id, nomePessoa, cpf, endereco, telefone, idade, status);
            cadPessoas.add(p);

            JOptionPane.showMessageDialog(this, "Pessoa foi salva com sucesso!");

            jbLimpar.doClick();
            addRowToTable();
        }
    }//GEN-LAST:event_jbSalvarActionPerformed

    private void jbSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSairActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jbSairActionPerformed

    private void jtPessoasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtPessoasMouseClicked
        // TODO add your handling code here:
        jbDeletar.setEnabled(true);
        jbEditar.setEnabled(true);
    }//GEN-LAST:event_jtPessoasMouseClicked

    private void jbDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbDeletarActionPerformed
        // TODO add your handling code here:
        jbEditar.setEnabled(false);
        int linha;
        String cpf;
        linha = jtPessoas.getSelectedRow();
        cpf = (String) jtPessoas.getValueAt(linha, 1);
        Pessoa p = cadPessoas.getByDoc(cpf);
//        int resposta = JOptionPane.showConfirmDialog(this,
//                "Deseja realmente deletar " + p.getNomePessoa() + "?",
//                ".: Deletar :.", JOptionPane.YES_NO_OPTION,
//                JOptionPane.QUESTION_MESSAGE);
        Object[] resp = {"Sim", "Não"};
        int resposta = JOptionPane.showOptionDialog(this,
                "Deseja realmente deletar " + p.getNomePessoa() + "?",
                ".: Deletar :.", JOptionPane.DEFAULT_OPTION,
                JOptionPane.WARNING_MESSAGE, null, resp, resp[0]);
        if (resposta == 0) {
            cadPessoas.deletar(p);
            addRowToTable();
            JOptionPane.showMessageDialog(this, "Pessoa deletada com sucesso!",
                    ".: Deletar :.", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Entendemos sua decisão!",
                    ".: Deletar :.", JOptionPane.INFORMATION_MESSAGE);
        }
        jbDeletar.setEnabled(false);
    }//GEN-LAST:event_jbDeletarActionPerformed

    private void jbEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEditarActionPerformed
        // TODO add your handling code here:
        //ajustando comportamento dos botões
        jbDeletar.setEnabled(false);
        jbSalvar.setEnabled(false);
        jbEditar.setEnabled(false);
        jtfCPF.setEnabled(false);
        jbPesqCPF.setEnabled(false);
        jbConfirmar.setEnabled(true);
        jbLimpar.setText("Cancelar");

        //carregar os dados da pessoa selecionada nos JTextFields
        int linha;
        String cpf;
        linha = jtPessoas.getSelectedRow();
        cpf = (String) jtPessoas.getValueAt(linha, 1);
        Pessoa p = cadPessoas.getByDoc(cpf);

        jtfNome.setText(p.getNomePessoa());
        jtfCPF.setText(p.getCpf());
        jtfEndereco.setText(p.getEndereco());
        jtfTelefone.setText(p.getTelefone());
        jtfIdade.setText(Integer.toString(p.getIdade()));
        if (p.isStatus()) {
            jrbAtivo.setSelected(true);
            jrbInativo.setSelected(false);
        } else {
            jrbAtivo.setSelected(false);
            jrbInativo.setSelected(true);
        }
    }//GEN-LAST:event_jbEditarActionPerformed

    private void jbConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbConfirmarActionPerformed
        // TODO add your handling code here:
        btnClick = (JButton) evt.getSource();
        if (validaImputs()) {
            Pessoa p = cadPessoas.getByDoc(jtfCPF.getText());

            p.setNomePessoa(jtfNome.getText());
            p.setCpf(jtfCPF.getText());
            p.setEndereco(jtfEndereco.getText());
            p.setIdade(Integer.parseInt(jtfIdade.getText()));
            p.setTelefone(jtfTelefone.getText());
            if (jrbAtivo.isSelected()) {
                p.setStatus(true);
            } else {
                p.setStatus(false);
            }
            addRowToTable();

            jbLimpar.doClick();
            jbLimpar.setText("Limpar");

            jTableFilterClear();

            String msg = "Dados atualizados com sucesso!";
            JOptionPane.showMessageDialog(this, msg, ".: Atualizar :.",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            jbLimpar.doClick();
            jtfCPF.setEnabled(true);
        }
    }//GEN-LAST:event_jbConfirmarActionPerformed

    private void jbPesqCPFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbPesqCPFActionPerformed
        // TODO add your handling code here:
        if (!ValidaCPF.isCPF(jtfCPF.getText())) {
            JOptionPane.showMessageDialog(this,
                    "CPF informado esta incorreto!!!",
                    ".: Erro :.", JOptionPane.ERROR_MESSAGE);
            jtfCPF.requestFocus();
        } else if (cadPessoas.verCPF(jtfCPF.getText())) {
            DefaultTableModel model = (DefaultTableModel) jtPessoas.getModel();
            final TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);
            jtPessoas.setRowSorter(sorter);
            String text = jtfCPF.getText();
            if (text.length() == 0) {
                sorter.setRowFilter(null);
            } else {
                try {
                    sorter.setRowFilter(RowFilter.regexFilter(text));
                } catch (PatternSyntaxException pse) {
                    JOptionPane.showMessageDialog(this, "Registro não encontrado!");
                }
            }

//            Pessoa p = cadPessoas.getByDoc(jtfCPF.getText());
//
//            jtfNome.setText(p.getNomePessoa());
//            jtfCPF.setText(p.getCpf());
//            jtfEndereco.setText(p.getEndereco());
//            jtfTelefone.setText(p.getTelefone());
//            jtfIdade.setText(Integer.toString(p.getIdade()));
//            if (p.isStatus()) {
//                jrbAtivo.setSelected(true);
//                jrbInativo.setSelected(false);
//            } else {
//                jrbAtivo.setSelected(false);
//                jrbInativo.setSelected(true);
//            }
//
//            jbConfirmar.setEnabled(true);
//            jbSalvar.setEnabled(false);
        }
    }//GEN-LAST:event_jbPesqCPFActionPerformed

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
            java.util.logging.Logger.getLogger(pessoaCadastro.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(pessoaCadastro.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(pessoaCadastro.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(pessoaCadastro.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new pessoaCadastro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JButton jbConfirmar;
    private javax.swing.JButton jbDeletar;
    private javax.swing.JButton jbEditar;
    private javax.swing.JButton jbLimpar;
    private javax.swing.JButton jbPesqCPF;
    private javax.swing.JButton jbSair;
    private javax.swing.JButton jbSalvar;
    private javax.swing.JRadioButton jrbAtivo;
    private javax.swing.JRadioButton jrbInativo;
    private javax.swing.JTable jtPessoas;
    private javax.swing.JTextField jtfCPF;
    private javax.swing.JTextField jtfEndereco;
    private javax.swing.JTextField jtfIdade;
    private javax.swing.JTextField jtfNome;
    private javax.swing.JTextField jtfTelefone;
    // End of variables declaration//GEN-END:variables

}
