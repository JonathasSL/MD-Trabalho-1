package gui;

import proposicao.Argumento;
import util.Solver;

import javax.swing.*;
import java.util.ArrayList;

public class GUI_Argumento extends JFrame{

    private javax.swing.JButton abreParentese_btn;
    private javax.swing.JButton apagar_btn;
    private javax.swing.JLabel arg_label;
    private javax.swing.JTextField arg_textfield;
    private javax.swing.JButton conj_btn;
    private javax.swing.JButton disjXclusive_btn;
    private javax.swing.JButton disj_btn;
    private javax.swing.JButton equiv_btn;
    private javax.swing.JButton exec_btn;
    private javax.swing.JButton fechaParentese_btn;
    private javax.swing.JButton imp_btn;
    private javax.swing.JButton not_btn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JButton p_btn;
    private javax.swing.JLabel prop_label;
    private javax.swing.JButton q_btn;
    private javax.swing.JButton r_btn;
    private javax.swing.JButton t_btn;
    private int num_parenteses=0;
    public static String argumento = "(";

    public static ArrayList<Character> PROPOSICOES;
    public static ArrayList<Boolean> CONECTIVOS;

    public GUI_Argumento(){
        initComponents();
    }

    private void initComponents() {

        arg_textfield = new javax.swing.JTextField();
        p_btn = new javax.swing.JButton();
        q_btn = new javax.swing.JButton();
        r_btn = new javax.swing.JButton();
        t_btn = new javax.swing.JButton();
        disj_btn = new javax.swing.JButton();
        not_btn = new javax.swing.JButton();
        imp_btn = new javax.swing.JButton();
        conj_btn = new javax.swing.JButton();
        disjXclusive_btn = new javax.swing.JButton();
        equiv_btn = new javax.swing.JButton();
        exec_btn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        arg_label = new javax.swing.JLabel();
        prop_label = new javax.swing.JLabel();
        apagar_btn = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        abreParentese_btn = new javax.swing.JButton();
        fechaParentese_btn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        arg_textfield.setEditable(false);
        arg_textfield.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        arg_textfield.setText("");
        arg_textfield.setToolTipText("");
        arg_textfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                arg_textfieldActionPerformed(evt);
            }
        });

        p_btn.setText("p");
        p_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p_btnActionPerformed(evt);
            }
        });

        q_btn.setText("q");
        q_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                q_btnActionPerformed(evt);
            }
        });

        r_btn.setText("r");
        r_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r_btnActionPerformed(evt);
            }
        });


        t_btn.setText("t");
        t_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_btnActionPerformed(evt);
            }
        });


        disj_btn.setText("or");
        disj_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                disj_btnActionPerformed(evt);
            }
        });


        not_btn.setText("~");
        not_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                not_btnActionPerformed(evt);
            }
        });

        imp_btn.setText("if_then");
        imp_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imp_btnActionPerformed(evt);
            }
        });


        conj_btn.setText("and");
        conj_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                conj_btnActionPerformed(evt);
            }
        });


        disjXclusive_btn.setText("xor");
        disjXclusive_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                disjXclusive_btnActionPerformed(evt);
            }
        });

        equiv_btn.setText("only_if");
        equiv_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                equiv_btnActionPerformed(evt);
            }
        });


        exec_btn.setText("Executar");
        exec_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exec_btnActionPerformed(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Conectivos");

        arg_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        arg_label.setText("Argumento");

        prop_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        prop_label.setText("Proposições");

        apagar_btn.setText("<");
        apagar_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                apagar_btnActionPerformed(evt);
            }
        });

        abreParentese_btn.setText("(");
        abreParentese_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abreParentese_btnActionPerformed(evt);
            }
        });

        fechaParentese_btn.setText(")");
        fechaParentese_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fechaParentese_btnActionPerformed(evt);
            }
        });
        fechaParentese_btn.setEnabled(false);
        disableConectivos();
        apagar_btn.setEnabled(false);
        exec_btn.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(arg_label, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(35, 35, 35)
                                                                .addComponent(abreParentese_btn)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(p_btn)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(q_btn)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(r_btn)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(t_btn)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(fechaParentese_btn))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(94, 94, 94)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                        .addComponent(disj_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(not_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(imp_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                        .addComponent(disjXclusive_btn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(conj_btn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(equiv_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(prop_label, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(exec_btn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                .addComponent(arg_textfield)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(apagar_btn))
                                                        .addComponent(jSeparator1)
                                                        .addComponent(jSeparator2)
                                                        .addComponent(jSeparator3)
                                                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(arg_label)
                                .addGap(1, 1, 1)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(arg_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(apagar_btn))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(prop_label)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(p_btn)
                                        .addComponent(q_btn)
                                        .addComponent(r_btn)
                                        .addComponent(t_btn)
                                        .addComponent(abreParentese_btn)
                                        .addComponent(fechaParentese_btn))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(disj_btn)
                                        .addComponent(conj_btn))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(disjXclusive_btn)
                                        .addComponent(not_btn))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(imp_btn)
                                        .addComponent(equiv_btn))
                                .addGap(9, 9, 9)
                                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(exec_btn)
                                .addGap(23, 23, 23))
        );

        pack();
    }

    private void arg_textfieldActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void abreParentese_btnActionPerformed(java.awt.event.ActionEvent evt){
        ++num_parenteses;
        apagar_btn.setEnabled(true);
        fechaParentese_btn.setEnabled(true);

        String text = arg_textfield.getText();
        arg_textfield.setText(text+" (");

    }

    private void fechaParentese_btnActionPerformed(java.awt.event.ActionEvent evt){
        --num_parenteses;
        if(num_parenteses==0)
            fechaParentese_btn.setEnabled(false);

        String text = arg_textfield.getText();
        arg_textfield.setText(text+" )");

        if(num_parenteses == 0) exec_btn.setEnabled(true);

    }

    private void p_btnActionPerformed(java.awt.event.ActionEvent evt) {
        disableProposicoes();
        enableConectivos();
        not_btn.setEnabled(false);
        apagar_btn.setEnabled(true);
        abreParentese_btn.setEnabled(false);

        String text = arg_textfield.getText();
        arg_textfield.setText(text+" p");
    }

    private void q_btnActionPerformed(java.awt.event.ActionEvent evt) {
        disableProposicoes();
        enableConectivos();
        not_btn.setEnabled(false);
        apagar_btn.setEnabled(true);
        abreParentese_btn.setEnabled(false);

        String text = arg_textfield.getText();
        arg_textfield.setText(text+" q");
    }

    private void r_btnActionPerformed(java.awt.event.ActionEvent evt) {
        disableProposicoes();
        enableConectivos();
        not_btn.setEnabled(false);
        apagar_btn.setEnabled(true);
        abreParentese_btn.setEnabled(false);

        String text = arg_textfield.getText();
        arg_textfield.setText(text+" r");
    }

    private void t_btnActionPerformed(java.awt.event.ActionEvent evt) {
        disableProposicoes();
        enableConectivos();
        not_btn.setEnabled(false);
        apagar_btn.setEnabled(true);
        abreParentese_btn.setEnabled(false);

        String text = arg_textfield.getText();
        arg_textfield.setText(text+" t");
    }

    //Conectivos
    private void not_btnActionPerformed(java.awt.event.ActionEvent evt) {
        not_btn.setEnabled(false);
        apagar_btn.setEnabled(true);

        String text = arg_textfield.getText();
        arg_textfield.setText(text+" ~");
    }

    private void disj_btnActionPerformed(java.awt.event.ActionEvent evt) {
        disableConectivos();
        enableProposicoes();
        not_btn.setEnabled(true);
        apagar_btn.setEnabled(true);

        String text = arg_textfield.getText();
        arg_textfield.setText(text+" or");
    }
    private void conj_btnActionPerformed(java.awt.event.ActionEvent evt) {
        disableConectivos();
        enableProposicoes();
        not_btn.setEnabled(true);
        apagar_btn.setEnabled(true);

        String text = arg_textfield.getText();
        arg_textfield.setText(text+" and");
    }

    private void disjXclusive_btnActionPerformed(java.awt.event.ActionEvent evt) {
        disableConectivos();
        enableProposicoes();
        not_btn.setEnabled(true);
        apagar_btn.setEnabled(true);

        String text = arg_textfield.getText();
        arg_textfield.setText(text+" xor");
    }

    private void imp_btnActionPerformed(java.awt.event.ActionEvent evt) {
        disableConectivos();
        enableProposicoes();
        not_btn.setEnabled(true);
        apagar_btn.setEnabled(true);

        String text = arg_textfield.getText();
        arg_textfield.setText(text+" if_then");
    }

    private void equiv_btnActionPerformed(java.awt.event.ActionEvent evt) {
        disableConectivos();
        enableProposicoes();
        not_btn.setEnabled(true);
        apagar_btn.setEnabled(true);

        String text = arg_textfield.getText();
        arg_textfield.setText(text+" only_if");
    }

    //Diversos
    private void apagar_btnActionPerformed(java.awt.event.ActionEvent evt) {
        String text = arg_textfield.getText();
        char last;

        if (text.length() > 0) {
            last = text.toCharArray()[text.length() - 1];
            switch (last) {
                case 'p':
                case 'q':
                case 'r':
                case 't':
                    enableProposicoes();
                    disableConectivos();
                    if(text.length()>2 && text.toCharArray()[text.length()-3] == '~') {
                        not_btn.setEnabled(false);
                    }else{
                        not_btn.setEnabled(true);
                    }
                    break;

                case '~':
                    not_btn.setEnabled(true);
                    break;
                case')':
                    ++num_parenteses;
                    fechaParentese_btn.setEnabled(true);
                    break;
                case '(':
                    --num_parenteses;
                    break;
                default:
                    enableConectivos();
                    disableProposicoes();
                    not_btn.setEnabled(false);

            }
        }

        if (text.length() > 2) {
            char[] new_text = new char[text.length() - 2];
            for (int i = 0; i < new_text.length; i++) {
                new_text[i] = text.toCharArray()[i];
            }
            text = "";
            for (char c : new_text) {
                text += c;
            }
        } else {
            text = "";
        }
        arg_textfield.setText(text);

        if (text.length() == 0) {
            apagar_btn.setEnabled(false);
        }


        argumento = "(" + arg_textfield.getText();
    }

    private void exec_btnActionPerformed(java.awt.event.ActionEvent evt) {
        argumento = "(" + arg_textfield.getText() + " )";
        Solver s = new Solver();
        s.solve(argumento);
        arg_textfield.setText("");
        Solver.clear();

        enableProposicoes();
        disableConectivos();
        not_btn.setEnabled(true);

        System.out.println();
        System.out.println();

        for(Argumento arg : s.argumentos){
            System.out.print(arg + ": ");
            for(boolean b : s.respostas.get(arg)){
                System.out.print(b + ", ");
            }
            System.out.println();
            System.out.println();
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_Tabela().setVisible(true);
            }
        });
    }

    private void enableConectivos(){
        conj_btn.setEnabled(true);
        disj_btn.setEnabled(true);
        disjXclusive_btn.setEnabled(true);
        equiv_btn.setEnabled(true);
        imp_btn.setEnabled(true);

        if(num_parenteses != 0)
            fechaParentese_btn.setEnabled(true);
        else
            fechaParentese_btn.setEnabled(false);

    }

    private void disableConectivos(){
        conj_btn.setEnabled(false);
        disj_btn.setEnabled(false);
        disjXclusive_btn.setEnabled(false);
        equiv_btn.setEnabled(false);
        imp_btn.setEnabled(false);
        fechaParentese_btn.setEnabled(false);
        abreParentese_btn.setEnabled(true);
    }

    private void enableProposicoes(){
        p_btn.setEnabled(true);
        q_btn.setEnabled(true);
        r_btn.setEnabled(true);
        t_btn.setEnabled(true);
        exec_btn.setEnabled(false);
        abreParentese_btn.setEnabled(true);
    }

    private void disableProposicoes(){
        p_btn.setEnabled(false);
        q_btn.setEnabled(false);
        r_btn.setEnabled(false);
        t_btn.setEnabled(false);
        if(num_parenteses==0){
            exec_btn.setEnabled(true);
        }else{
            exec_btn.setEnabled(false);
        }
        abreParentese_btn.setEnabled(false);
    }
}
