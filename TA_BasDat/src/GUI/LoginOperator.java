
package GUI;

import java.awt.Color;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class LoginOperator extends ComponenGui {
    
    public LoginOperator() {
        initComponent();
    }
    
    void initComponent()
    {
        setTitle("Login Operator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(320, 220);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setVisible(true);
        
        labelidoperator.setBounds(35, 25, 60, 25);
        add(labelidoperator);
        fieldidoperator.setBounds(130, 25, 130, 25);
        add(fieldidoperator);
        
        labelnama_operator.setBounds(35, 75, 100, 25);
        add(labelnama_operator);
        fieldnama_operator.setBounds(130, 75, 130, 25);
        add(fieldnama_operator);
        
        btnmasuk.setBounds(130,125 , 60, 25);
        btnmasuk.setForeground(Color.white);
        btnmasuk.setBackground(Color.black);
        btnmasuk.setFocusPainted(false);
        btnmasuk.setBorder(null);
        add(btnmasuk);
        
        btnmasuk.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                int id_operator = Integer.parseInt(fieldidoperator.getText());
                String nama_operator = fieldnama_operator.getText();
                int cek = AllObjectController.operator.login(id_operator, nama_operator);
                if(cek > 0){
                    dispose();
                    Transaksi viewtrx = new Transaksi(cek);
                    viewtrx.setVisible(true);
                    
                } else {
                    JOptionPane.showMessageDialog(null, "GAGAL LOGIN");
                    kosong();
                }
            }
        });
        
           btnmasuk.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                btnmasuk.setForeground(Color.black);
                btnmasuk.setBackground(Color.red);
            }
            
            @Override
            public void mouseExited(MouseEvent e){
                btnmasuk.setForeground(Color.white);
                btnmasuk.setBackground(Color.black);
            }
        });
    }

        
}
