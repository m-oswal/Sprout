package sprout.Teacher;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import sprout.DBConnection;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
//import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class TeacherChangeEmail extends JFrame implements ActionListener{
    JLabel newEmaillbl;
    JTextField newEmail;
    JButton updateEmailbtn;
    public TeacherChangeEmail(){
            newEmaillbl = new JLabel("New Email");
            newEmaillbl.setFont(new Font("Tahoma", Font.PLAIN, 20));
            newEmaillbl.setBounds(10, 10, 150, 30);
            add(newEmaillbl);
            

            newEmail = new JTextField();
            newEmail.setFont(new Font("Tahoma", Font.PLAIN, 22));
            newEmail.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            newEmail.setBounds(150, 10, 150, 40);
            add(newEmail);
            newEmail.setColumns(20);
            
            updateEmailbtn = new JButton("Update");
            updateEmailbtn.setBounds(80, 90, 150, 30);
            updateEmailbtn.addActionListener((ActionListener) this);
            add(updateEmailbtn);
            
//            ChangePassFrame.setResizable(false);
            setLayout(null);
            setSize(320,220);
            setLocation(500,320);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == updateEmailbtn){
            String EmailID = newEmail.getText();
            try{
                DBConnection c1 = new DBConnection();

                String q = "update Teacher SET Email_ID = '"+ EmailID +"'"
                        + "Where teacherID ='" + TeacherLogin.currentTeacherID + "'";

                int x = c1.s.executeUpdate(q);
                if(x == 0){
                    JOptionPane.showMessageDialog(null, "Got some error");
                }else{
                    JOptionPane.showMessageDialog(null, "Your Email Updated Successfully");
                    setVisible(false);
                }
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Error updating email. Please try again later.", "Error", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
                }
        }
    }
    public static void main(String[] args) {
        new TeacherChangeEmail();
    }
}