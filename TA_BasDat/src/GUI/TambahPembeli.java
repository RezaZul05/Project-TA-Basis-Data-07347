package GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class TambahPembeli extends ComponenGui {
    

    public TambahPembeli(int id_operator) {
        initComponent(id_operator);
    }

    void initComponent(int id_operator) {
        setTitle("Tambah Data Pembeli");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(320, 480);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setVisible(true);

        labelid.setBounds(35, 40, 40, 25);
        add(labelid);
        fieldidpembeli.setBounds(130, 40, 130, 25);
        add(fieldidpembeli);

        labelnama.setBounds(35, 80, 40, 25);
        add(labelnama);
        fieldnama.setBounds(130, 80, 130, 25);
        add(fieldnama);

        labelnotelp.setBounds(35, 120, 80, 25);
        add(labelnotelp);
        fieldnotelp.setBounds(130, 120, 130, 25);
        add(fieldnotelp);

        btntambahpembeli.setBounds(80, 200, 140, 25);
        btntambahpembeli.setBorder(null);
        btntambahpembeli.setBackground(Color.black);
        btntambahpembeli.setForeground(Color.white);
        btntambahpembeli.setFocusPainted(false);
        add(btntambahpembeli);

        btnback.setBounds(90, 245, 80, 25);
        btnback.setBackground(Color.black);
        btnback.setForeground(Color.white);
        btnback.setBorder(null);
        btnback.setFocusPainted(false);
        add(btnback);

        btntambahpembeli.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btntambahpembeli.setForeground(Color.black);
                btntambahpembeli.setBackground(Color.white);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btntambahpembeli.setForeground(Color.white);
                btntambahpembeli.setBackground(Color.black);
            }
        });

        btntambahpembeli.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id_pembeli = Integer.parseInt(fieldidpembeli.getText());
                String nama_pembeli = fieldnama.getText();
                String no_telp = fieldnotelp.getText();
                if (id_pembeli != 0 && nama_pembeli.length() != 0 && no_telp.length() != 0) {
                    AllObjectController.pembeli.insertDataPembeli(id_pembeli, nama_pembeli, no_telp);
                    JOptionPane.showMessageDialog(null, "Data Berhasil ditambah");
                    dispose();
                    new PilihFilm(id_operator, id_pembeli).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Data Tidak Boleh Kosong");
                    kosong();
                }
            }
        });
        btnback.addActionListener(e -> {
            dispose();
            new PilihanPembeli(id_operator).setVisible(true);
        });
    }
}
