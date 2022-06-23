/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Tambah_Detail_Trx extends JFrame {

    JButton btnback = new JButton("<< BACK");
    JButton btntambahDetailtrx = new JButton("TAMBAH");

    JLabel labelidtrx = new JLabel("ID Transaksi");
    JLabel labelkodetiket = new JLabel("Kode Tiket");

    JTextField fieldidtrx = new JTextField();
    JTextField fieldkodetiket = new JTextField();
    int kode;

    public Tambah_Detail_Trx(int id_operator) {
        initComponent(id_operator);
        setVisible(true);
    }

    void initComponent(int id_operator) {
        setTitle("Tambah Detail Trx");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(350, 350);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setVisible(true);

        labelidtrx.setBounds(35, 85, 120, 25);
        add(labelidtrx);
        fieldidtrx.setBounds(170, 85, 130, 25);
        add(fieldidtrx);

        labelkodetiket.setBounds(35, 130, 120, 25);
        add(labelkodetiket);
        fieldkodetiket.setBounds(170, 130, 130, 25);
        add(fieldkodetiket);

        btntambahDetailtrx.setBounds(85, 200, 140, 25);
        btntambahDetailtrx.setBorder(null);
        btntambahDetailtrx.setBackground(Color.black);
        btntambahDetailtrx.setForeground(Color.white);
        btntambahDetailtrx.setFocusPainted(false);
        add(btntambahDetailtrx);

        btnback.setBounds(25, 20, 80, 25);
        btnback.setBackground(Color.white);
        btnback.setFocusPainted(false);
        btnback.setBorder(null);
        add(btnback);

        btnback.addActionListener(e -> {
            dispose();
            new Detail_Trx(id_operator).setVisible(true);
        });
        btntambahDetailtrx.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int transaksi_id = Integer.parseInt(fieldidtrx.getText());
                int tiket_kode = Integer.parseInt(fieldkodetiket.getText());
                if (transaksi_id != 0 && tiket_kode != 0 ) {
                    AllObjectController.detail_Trx.insertData(transaksi_id, tiket_kode);
                    JOptionPane.showMessageDialog(null, "Data Berhasil ditambah");
                    dispose();
                    new Detail_Trx(id_operator).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Data Tidak Boleh Kosong");
                }
            }
        });
    }
}
