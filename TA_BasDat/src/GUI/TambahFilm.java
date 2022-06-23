/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author NandaRahman
 */
public class TambahFilm extends ComponenGui {

    public TambahFilm(int id_operator) {
        initComponent(id_operator);
    }

    void initComponent(int id_operator) {
        setTitle("Tambah Film");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(320, 480);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setVisible(true);

        labelkodefilm.setBounds(35, 40, 40, 25);
        add(labelkodefilm);
        fieldkodefilm.setBounds(130, 40, 130, 25);
        add(fieldkodefilm);

        labeljudul.setBounds(35, 80, 40, 25);
        add(labeljudul);
        fieldjudul.setBounds(130, 80, 130, 25);
        add(fieldjudul);

        labeldurasi.setBounds(35, 120, 80, 25);
        add(labeldurasi);
        fielddurasi.setBounds(130, 120, 130, 25);
        add(fielddurasi);

        labelhargafilm.setBounds(35, 160, 80, 25);
        add(labelhargafilm);
        fieldhargafilm.setBounds(130, 160, 130, 25);
        add(fieldhargafilm);

        btntambahfilm.setBounds(80, 250, 140, 25);
        btntambahfilm.setBorder(null);
        btntambahfilm.setBackground(Color.black);
        btntambahfilm.setForeground(Color.white);
        btntambahfilm.setFocusPainted(false);
        add(btntambahfilm);

        btnback.setBounds(90, 295, 80, 25);
        btnback.setBackground(Color.black);
        btnback.setForeground(Color.white);
        btnback.setBorder(null);
        btnback.setFocusPainted(false);
        add(btnback);

        btntambahfilm.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btntambahfilm.setForeground(Color.black);
                btntambahfilm.setBackground(Color.white);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btntambahfilm.setForeground(Color.white);
                btntambahfilm.setBackground(Color.black);
            }
        });
        btntambahfilm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String kode_film = fieldkodefilm.getText();
                String judul = fieldjudul.getText();
                String durasi = fielddurasi.getText();
                String harga = fieldhargafilm.getText();
                if (kode_film.length() != 0 && judul.length() != 0 && durasi.length() != 0 && harga.length() != 0) {
                    AllObjectController.film.insertFilm2(kode_film, judul, durasi, harga);
                    JOptionPane.showMessageDialog(null, "Data Berhasil ditambah");
                    dispose();
                    new Film(id_operator).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Data Tidak Boleh Kosong");
                    kosong();
                }
            }
        });
        btnback.addActionListener(e -> {
            dispose();
            new Film(id_operator).setVisible(true);
        });
    }

}
