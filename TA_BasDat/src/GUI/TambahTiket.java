package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class TambahTiket extends JFrame {

    JButton btnback = new JButton("<< BACK");
    JButton btntambahtiket = new JButton("TAMBAH");
    
    JLabel labelkodefilm = new JLabel("Kode Film");
    JLabel labelruangan = new JLabel("Ruangan");
    JLabel labelmulaifilm = new JLabel("Mulai Film");

    JTextField fieldkodefilm = new JTextField();
    JTextField fieldruangan = new JTextField();
    JTextField fieldmulaifilm = new JTextField();
    int kode;

    public TambahTiket(int id_operator) {
        initComponent(id_operator);
        setVisible(true);
    }

    void initComponent(int id_operator) {
        setTitle("Tambah Tiket");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(350, 490);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setVisible(true);

        labelkodefilm.setBounds(35, 85, 120, 25);
        add(labelkodefilm);
        fieldkodefilm.setBounds(170, 85, 130, 25);
        add(fieldkodefilm);

        labelruangan.setBounds(35, 130, 120, 25);
        add(labelruangan);
        fieldruangan.setBounds(170, 130, 130, 25);
        add(fieldruangan);

        labelmulaifilm.setBounds(35, 175, 120, 25);
        add(labelmulaifilm);
        fieldmulaifilm.setBounds(170, 175, 130, 25);
        add(fieldmulaifilm);

        btntambahtiket.setBounds(80, 250, 140, 25);
        btntambahtiket.setBorder(null);
        btntambahtiket.setBackground(Color.black);
        btntambahtiket.setForeground(Color.white);
        btntambahtiket.setFocusPainted(false);
        add(btntambahtiket);

        btnback.setBounds(25, 20, 80, 25);
        btnback.setBackground(Color.white);
        btnback.setFocusPainted(false);
        btnback.setBorder(null);
        add(btnback);

        btnback.addActionListener(e -> {
            dispose();
            new PilihFilm(id_operator, id_operator).setVisible(true);
        });
        btntambahtiket.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String film_kode = fieldkodefilm.getText();
                String ruangan = fieldruangan.getText();
                String mulai_film = fieldmulaifilm.getText();
                if (film_kode.length() != 0 && ruangan.length() != 0 && mulai_film.length() != 0) {
                    AllObjectController.tiket.insertData(film_kode, ruangan, mulai_film);
                    JOptionPane.showMessageDialog(null, "Data Berhasil ditambah");
                    dispose();
                    new Transaksi(id_operator).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Data Tidak Boleh Kosong");
                }
            }
        });

    }

}
