package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class Film extends JFrame {
    JButton btnaddfilm = new JButton("TAMBAH FILM");
    JButton btndeletefilm = new JButton("DELETE FILM");
    JButton btnback = new JButton("<< BACK");
    JTable tabelfilm = new JTable();
    JScrollPane spgame = new JScrollPane(tabelfilm);
    JTextField textpilih = new JTextField();
    int kode;

    public Film(int id_operator) {
        initComponent(id_operator);
    }

    void initComponent(int id_operator) {
        setTitle("View Film");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1300, 550);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setVisible(true);

        spgame.setBounds(20, 50, 1000, 350);
        tabelfilm.setModel(AllObjectController.film.viewFilm());
        add(spgame);

        btnaddfilm.setBounds(1100, 50, 130, 25);
        btnaddfilm.setFocusPainted(false);
        btnaddfilm.setBorder(null);
        btnaddfilm.setBackground(Color.black);
        btnaddfilm.setForeground(Color.white);
        add(btnaddfilm);

        btndeletefilm.setBounds(1100, 95, 130, 25);
        btndeletefilm.setFocusPainted(false);
        btndeletefilm.setBorder(null);
        btndeletefilm.setBackground(Color.black);
        btndeletefilm.setForeground(Color.white);
        add(btndeletefilm);

        btnback.setBounds(25, 20, 80, 25);
        btnback.setBackground(Color.white);
        btnback.setFocusPainted(false);
        btnback.setBorder(null);
        add(btnback);
        
        tabelfilm.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                int i = tabelfilm.getSelectedRow();
                textpilih.setText(AllObjectController.film.viewFilm().getValueAt(i, 0).toString());
            }
        });
        
        btnback.addActionListener(e -> {
            dispose();
            new Transaksi(id_operator).setVisible(true);
        });
        btnaddfilm.addActionListener(e -> {
            dispose();
            new TambahFilm(id_operator).setVisible(true);
        });
        btndeletefilm.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String kode_film = textpilih.getText();
                AllObjectController.film.deleteFilm(kode_film);
                tabelfilm.setModel(AllObjectController.film.viewFilm());
                JOptionPane.showMessageDialog(null, "Berhasil HAPUS DATA");
            }
        });
    }
    
    
}
