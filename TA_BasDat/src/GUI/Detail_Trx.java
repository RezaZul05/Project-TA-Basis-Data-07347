package GUI;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;


public class Detail_Trx extends JFrame {

    JButton btnback = new JButton("<< BACK");
    JButton btnTambah = new JButton("ADD DETAIL");
    JButton btndelete = new JButton("DELETE DETAIL");
    JTable tabeldetailTrx = new JTable();
    JScrollPane spgame = new JScrollPane(tabeldetailTrx);
    JTextField textpilih = new JTextField();

    int kode;

    public Detail_Trx(int id_operator) {
        initComponent(id_operator);
    }

    void initComponent(int id_operator) {
        setTitle("View Detail Transaksi");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1050, 550);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setVisible(true);

        spgame.setBounds(20, 50, 1000, 350);
        tabeldetailTrx.setModel(AllObjectController.detail_Trx.dataDetail_Trx());
        add(spgame);

        btnback.setBounds(25, 20, 80, 25);
        btnback.setBackground(Color.white);
        btnback.setFocusPainted(false);
        btnback.setBorder(null);
        add(btnback);

        btnTambah.setBounds(880, 20, 140, 25);
        btnTambah.setBorder(null);
        btnTambah.setBackground(Color.black);
        btnTambah.setForeground(Color.white);
        btnTambah.setFocusPainted(false);
        add(btnTambah);

        btndelete.setBounds(20, 400, 130, 25);
        btndelete.setFocusPainted(false);
        btndelete.setBorder(null);
        btndelete.setBackground(Color.black);
        btndelete.setForeground(Color.white);
        add(btndelete);

        btnback.addActionListener(e -> {
            dispose();
            new Transaksi(id_operator).setVisible(true);
        });
        btnTambah.addActionListener(e -> {
            dispose();
            new Tambah_Detail_Trx(id_operator).setVisible(true);
        });
        
        tabeldetailTrx.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int i = tabeldetailTrx.getSelectedRow();
                textpilih.setText(AllObjectController.detail_Trx.dataDetail_Trx().getValueAt(i, 0).toString());
                setVisible(true);
            }
        });
        btndelete.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int transaksi_id = Integer.parseInt(textpilih.getText());
                AllObjectController.detail_Trx.deleteDetailTrx(transaksi_id);
                tabeldetailTrx.setModel(AllObjectController.detail_Trx.dataDetail_Trx());
                JOptionPane.showMessageDialog(null, "Berhasil HAPUS DATA");
            }
        }
        );
    }

}
