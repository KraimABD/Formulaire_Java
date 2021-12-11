package TP;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Formulaire extends JFrame {
    String[] months;
    String restext;
    JPanel panel;
    JButton submit,reset;
    JLabel nom,title,date,genre,address,tel;
    JTextField nom1,address1,tel1;
    JRadioButton male,female;
    ButtonGroup G;
    JComboBox jour,mois,annee;
    JCheckBox terms;
    JTextArea result;
    Formulaire(){
        months = new String[]{"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

        panel = new JPanel();
        panel= (JPanel) getContentPane();
        panel.setLayout(null);

        submit = new JButton("Submit");
        submit.setBounds(150,500,100,40);
        panel.add(submit);

        reset = new JButton("Reset");
        reset.setBounds(320,500,100,40);
        panel.add(reset);

        nom = new JLabel("Name");
        nom.setBounds(100,100,50,30);
        panel.add(nom);

        tel = new JLabel("Mobile");
        tel.setBounds(100,160,50,30);
        panel.add(tel);

        date = new JLabel("Birth Date");
        date.setBounds(100,280,70,30);
        panel.add(date);

        genre = new JLabel("Gender");
        genre.setBounds(100,220,50,30);
        panel.add(genre);

        address = new JLabel("Address");
        address.setBounds(100,340,50,30);
        panel.add(address);

        title = new JLabel("Registration From");
        title.setBounds(450,2,200,70);
        panel.add(title);

        nom1 = new JTextField();
        nom1.setBounds(180,100,300,30);
        panel.add(nom1);


        address1 = new JTextField();
        address1.setBounds(180,350,300,80);
        panel.add(address1);

        tel1 = new JTextField();
        tel1.setBounds(180,160,300,30);
        panel.add(tel1);

        male = new JRadioButton("Male");
        male.setActionCommand("Male");
        male.setBounds(180,220,100,30);
        panel.add(male);

        female = new JRadioButton("Female");
        female.setActionCommand("Female");
        female.setBounds(280,220,100,30);
        panel.add(female);

        G = new ButtonGroup();
        G.add(male);
        G.add(female);

        jour = new JComboBox();
        jour.setBounds(180,280,50,30);
        panel.add(jour);

        mois = new JComboBox(months);
        mois.setBounds(255,280,110,30);
        panel.add(mois);

        annee = new JComboBox();
        annee.setBounds(390,280,70,30);
        panel.add(annee);

        for(int k=1;k<=31;k++)
        {
            jour.addItem(k);
        }
        for(int k=1970;k<=2021;k++)
        {
            annee.addItem(k);
        }

        terms = new JCheckBox("Accept Terms and Conditions");
        terms.setBounds(200,450,250,30);
        panel.add(terms);

        result = new JTextArea();
        result.setBounds(550,70,400,420);
        result.setEditable(false);
        panel.add(result);

        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (terms.isSelected()){
                    restext = "Name : "+nom1.getText()+"\nTelephone : "+tel1.getText()+"\nGender : "+G.getSelection().getActionCommand()+"\nBirth Day : "+jour.getSelectedItem()+" / "+mois.getSelectedItem()+" / "+annee.getSelectedItem()+"\nAddress : "+address1.getText()+"\n";
                    result.append(restext);
                }else{
                    JOptionPane.showMessageDialog(Formulaire.this, "Accept Terms !");
                }
            }
        });

        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                address1.setText("");
                nom1.setText("");
                tel1.setText("");
                result.setText("");
                G.clearSelection();
                annee.setSelectedIndex(0);
                jour.setSelectedIndex(0);
                mois.setSelectedIndex(0);
                terms.setSelected(false);
            }
        });

    }
    public static void main(String[] args) {
        JFrame frame=new Formulaire();
        frame.setTitle("Formulaire");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000,600);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}
