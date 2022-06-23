package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class PilihanPembeli extends JFrame {

    protected JButton btnback = new JButton("<< BACK");
    protected JButton btnlama = new JButton("PEMBELI LAMA");
    protected JButton btnbaru = new JButton("PEMBELI BARU");

    public PilihanPembeli(int id_operator) {
        initComponent(id_operator);
    }

    void initComponent(int id_operator) {
        setTitle("View Pilihan Pembeli");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setVisible(true);

        btnback.setBounds(25, 20, 80, 25);
        btnback.setBackground(Color.white);
        btnback.setFocusPainted(false);
        btnback.setBorder(null);
        add(btnback);

        btnlama.setBounds(40, 125, 130, 25);
        btnlama.setFocusPainted(false);
        btnlama.setBorder(null);
        btnlama.setBackground(Color.black);
        btnlama.setForeground(Color.white);
        add(btnlama);

        btnbaru.setBounds(220, 125, 130, 25);
        btnbaru.setFocusPainted(false);
        btnbaru.setBorder(null);
        btnbaru.setBackground(Color.black);
        btnbaru.setForeground(Color.white);
        add(btnbaru);

        btnback.addActionListener(e -> {
            dispose();
            new Transaksi(id_operator).setVisible(true);
        });
        btnlama.addActionListener(e -> {
            dispose();
            new PembeliLama(id_operator).setVisible(true);
        });
        btnbaru.addActionListener(e -> {
            dispose();
            new TambahPembeli(id_operator).setVisible(true);
        });
    }

}
