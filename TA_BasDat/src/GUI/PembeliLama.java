package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class PembeliLama extends JFrame {

    protected JButton btnback = new JButton("<< BACK");
    protected JButton btnpilih = new JButton("Pilih");

    JTable tabelpembeli = new JTable();
    JScrollPane spgame = new JScrollPane(tabelpembeli);
    JTextField textpilih = new JTextField();
    JTextField textpilih2 = new JTextField();
    JTextField textpilih3 = new JTextField();
    int kode;

    public PembeliLama(int id_operator) {
        initComponent(id_operator);
    }

    void initComponent(int id_operator) {
        setTitle("View Pembeli Lama");
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

        btnpilih.setBounds(390, 420, 130, 25);
        btnpilih.setFocusPainted(false);
        btnpilih.setBorder(null);
        btnpilih.setBackground(Color.black);
        btnpilih.setForeground(Color.white);
        add(btnpilih);

        btnback.addActionListener(e -> {
            dispose();
            new PilihanPembeli(id_operator).setVisible(true);
        });
        tabelpembeli.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int i = tabelpembeli.getSelectedRow();
                textpilih.setText(AllObjectController.pembeli.dataPembeli().getValueAt(i, 0).toString());
            }
        });
        btnpilih.addActionListener(e -> {
            dispose();
            int id_pembeli = Integer.parseInt(textpilih.getText());
            new PilihFilm(id_operator,id_pembeli).setVisible(true);
        });
        
    }

}
