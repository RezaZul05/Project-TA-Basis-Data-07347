/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;

public class Tiket extends JFrame {
    
    JButton btnback = new JButton("<< BACK");
    JButton btndelete = new JButton("DELETE");
    JButton btntambahTiket = new JButton("TAMBAH");
    
    JTable tabeltiket = new JTable();
    JScrollPane spgame = new JScrollPane(tabeltiket);
    JTextField textpilih = new JTextField();
    int kode;
    public Tiket(int id_operator) {
        initComponent(id_operator);
        setVisible(true);
    }

    void initComponent(int id_operator) {
        setTitle("View Tiket");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 550);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setVisible(true);

        spgame.setBounds(20, 50, 500, 350);
        tabeltiket.setModel(AllObjectController.tiket.dataTiket());
        add(spgame);
        setVisible(true);
        
        btndelete.setBounds(20, 400, 130, 25);
        btndelete.setFocusPainted(false);
        btndelete.setBorder(null);
        btndelete.setBackground(Color.black);
        btndelete.setForeground(Color.white);
        add(btndelete);
        
        btndelete.setBounds(20, 400, 130, 25);
        btndelete.setFocusPainted(false);
        btndelete.setBorder(null);
        btndelete.setBackground(Color.black);
        btndelete.setForeground(Color.white);
        add(btndelete);
        
        btntambahTiket.setBounds(390, 400, 130, 25);
        btntambahTiket.setFocusPainted(false);
        btntambahTiket.setBorder(null);
        btntambahTiket.setBackground(Color.black);
        btntambahTiket.setForeground(Color.white);
        add(btntambahTiket);
        
        btnback.setBounds(25, 20, 80, 25);
        btnback.setBackground(Color.white);
        btnback.setFocusPainted(false);
        btnback.setBorder(null);
        add(btnback);

        tabeltiket.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int i = tabeltiket.getSelectedRow();
                textpilih.setText(AllObjectController.tiket.dataTiket().getValueAt(i, 0).toString());
                setVisible(true);
            }
        });
        btnback.addActionListener(e -> {
            dispose();
            new Transaksi(id_operator).setVisible(true);
        });
        btntambahTiket.addActionListener(e -> {
            dispose();
            new TambahTiket(id_operator).setVisible(true);
        });
        
        btndelete.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                 int kode_tiket = Integer.parseInt(textpilih.getText());
                AllObjectController.tiket.deleteFilm(kode_tiket);
                tabeltiket.setModel(AllObjectController.tiket.dataTiket());
                JOptionPane.showMessageDialog(null, "Berhasil HAPUS DATA");
            }
        });

    }
}
