package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class Pembeli extends ComponenGui {

    JTable tabelpembeli = new JTable();
    JScrollPane spgame = new JScrollPane(tabelpembeli);
    JTextField textpilih = new JTextField();
    JTextField textpilih2 = new JTextField();
    JTextField textpilih3 = new JTextField();
    int kode;

    public Pembeli(int id_operator) {
        initComponent(id_operator);
    }

    void initComponent(int id_operator) {
        setTitle("View Data Pembeli");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(550, 550);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setVisible(true);

        spgame.setBounds(20, 50, 500, 350);
        tabelpembeli.setModel(AllObjectController.pembeli.dataPembeli());
        add(spgame);

        btnback.setBounds(25, 20, 80, 25);
        btnback.setBackground(Color.white);
        btnback.setFocusPainted(false);
        btnback.setBorder(null);
        add(btnback);

        btnback.addActionListener(e -> {
            dispose();
            new Transaksi(id_operator).setVisible(true);
        });

    }

}
