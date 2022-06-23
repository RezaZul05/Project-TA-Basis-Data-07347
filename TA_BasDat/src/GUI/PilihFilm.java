/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class PilihFilm extends JFrame {

    JButton btnaddfilm = new JButton("TAMBAH FILM");
    JButton btndeletefilm = new JButton("DELETE FILM");
    JButton btnback = new JButton("<< BACK");
    JButton btnpilih = new JButton("PILIH");
    JLabel labeljumlahfilmpesan = new JLabel("Jumlah Pesan");
    JTextField fieldjumlahfilmpesan = new JTextField();
    
    JTable tabelfilm = new JTable();
    JScrollPane spgame = new JScrollPane(tabelfilm);
    JTextField textpilih = new JTextField();
    
    JTextField textHarga = new JTextField();
    int kode;

    public PilihFilm(int id_operator, int id_pembeli) {
        initComponent(id_operator, id_pembeli);
    }

    void initComponent(int id_operator, int id_pembeli){
        setTitle("View Pilih Film");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 550);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setVisible(true);

        spgame.setBounds(20, 50, 500, 350);
        tabelfilm.setModel(AllObjectController.film.viewFilm());
        add(spgame);

        btnback.setBounds(25, 20, 80, 25);
        btnback.setBackground(Color.white);
        btnback.setFocusPainted(false);
        btnback.setBorder(null);
        add(btnback);
        
        btnpilih.setBounds(390, 420, 130, 25);
        btnpilih.setFocusPainted(false);
        btnpilih.setBorder(null);
        btnpilih.setBackground(Color.black);
        btnpilih.setForeground(Color.white);
        add(btnpilih);
        
        labeljumlahfilmpesan.setBounds(50, 430, 130, 25);
        add(labeljumlahfilmpesan);
        fieldjumlahfilmpesan.setBounds(150, 430, 130, 25);
        add(fieldjumlahfilmpesan);
        setVisible(true);
        
        

        tabelfilm.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int i = tabelfilm.getSelectedRow();
                textpilih.setText(AllObjectController.film.viewFilm().getValueAt(i, 0).toString());
                textHarga.setText(AllObjectController.film.viewFilm().getValueAt(i, 3).toString());
            }
        });

        btnback.addActionListener(e -> {
            dispose();
            new PembeliLama(id_operator).setVisible(true);
        });
        btnpilih.addActionListener(e -> {
            dispose();
//            int i = Integer.valueOf(textpilih.getText());
            String id_film = String.valueOf(textpilih.getText());
            int banyak = Integer.valueOf(fieldjumlahfilmpesan.getText());
            int harga = Integer.valueOf(fieldjumlahfilmpesan.getText()) * Integer.valueOf(textHarga.getText());
            AllObjectController.operator.insertTransaksi(id_pembeli,id_operator,banyak,harga,id_film);
            new Transaksi(id_operator).setVisible(true);
        });
        
    }
}
