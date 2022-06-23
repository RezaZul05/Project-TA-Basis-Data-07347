package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class Transaksi extends JFrame {

    JButton btnback = new JButton("<< BACK");
    JButton btntambahTransaksi = new JButton("TAMBAH TRX");
    JButton btnfilm = new JButton("FILM");
    JButton btnpembeli = new JButton("PEMBELI");
    JButton btntiket = new JButton("TIKET");
    JButton btndetailtrx = new JButton(" DETAIL TRX");

    JTable tabeltransaksi = new JTable();
    JScrollPane spgame = new JScrollPane(tabeltransaksi);
    JTextField textpilih = new JTextField();

    int kode;

    public Transaksi(int id_operator) {
        initComponent(id_operator);
        setVisible(true);
    }

    void initComponent(int id_operator) {
        setTitle("View Transaksi");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1300, 550);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setVisible(true);

        spgame.setBounds(20, 50, 1000, 350);
        tabeltransaksi.setModel(AllObjectController.transaksi.dataTransaksi());
        add(spgame);

        btntambahTransaksi.setBounds(1100, 50, 130, 25);
        btntambahTransaksi.setFocusPainted(false);
        btntambahTransaksi.setBorder(null);
        btntambahTransaksi.setBackground(Color.black);
        btntambahTransaksi.setForeground(Color.white);
        add(btntambahTransaksi);

        btnfilm.setBounds(1100, 95, 130, 25);
        btnfilm.setFocusPainted(false);
        btnfilm.setBorder(null);
        btnfilm.setBackground(Color.black);
        btnfilm.setForeground(Color.white);
        add(btnfilm);

        btnpembeli.setBounds(1100, 140, 130, 25);
        btnpembeli.setFocusPainted(false);
        btnpembeli.setBorder(null);
        btnpembeli.setBackground(Color.black);
        btnpembeli.setForeground(Color.white);
        add(btnpembeli);

        btntiket.setBounds(1100, 185, 130, 25);
        btntiket.setFocusPainted(false);
        btntiket.setBorder(null);
        btntiket.setBackground(Color.black);
        btntiket.setForeground(Color.white);
        add(btntiket);

        btndetailtrx.setBounds(1100, 230, 130, 25);
        btndetailtrx.setFocusPainted(false);
        btndetailtrx.setBorder(null);
        btndetailtrx.setBackground(Color.black);
        btndetailtrx.setForeground(Color.white);
        add(btndetailtrx);

        btnback.setBounds(25, 20, 80, 25);
        btnback.setBackground(Color.white);
        btnback.setFocusPainted(false);
        btnback.setBorder(null);
        add(btnback);

        tabeltransaksi.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int i = tabeltransaksi.getSelectedRow();
                textpilih.setText(AllObjectController.transaksi.dataTransaksi().getValueAt(i, 0).toString());
            }
        });
        btnback.addActionListener(e -> {
            dispose();
            new LoginOperator().setVisible(true);
        });

        btntambahTransaksi.addActionListener(e -> {
            dispose();
            new PilihanPembeli(id_operator).setVisible(true);
        });

        btnfilm.addActionListener(e -> {
            dispose();
            new Film(id_operator).setVisible(true);
        });

        btnpembeli.addActionListener(e -> {
            dispose();
            new Pembeli(id_operator).setVisible(true);
        });
        btntiket.addActionListener(e -> {
            dispose();
            new Tiket(id_operator).setVisible(true);
        });
        btndetailtrx.addActionListener(e -> {
            dispose();
            new Detail_Trx(id_operator).setVisible(true);
        });
    }
    
}
