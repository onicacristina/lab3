package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    private static JTextField firstNameInput;
    private static JTextField lastNameInput;
    private static JTextField ageInput;
    private static JCheckBox marriedCheckBox;
    private static JButton saveButton;
    private static ButtonGroup buttonGroup;
    private static JRadioButton maleRadioBotton;
    private static JRadioButton femaleRadioBotton;
    private static JTextArea addressInput;

    public static void main(String[] args) {

        JPanel jPanel = buildPanel();
        addActionToButon(jPanel);

    }

    private static void addActionToButon(JPanel panel) {
        saveButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String firstName = firstNameInput.getText();
                        String lastName = lastNameInput.getText();
                        Integer age = Integer.parseInt(ageInput.getText());
                        String gender = " ";
                        Boolean isMarried = false;
                        String married = "No";
                        String adress = addressInput.getText();

                        if(maleRadioBotton.isSelected())
                            gender = "Male";
                        else
                            if(femaleRadioBotton.isSelected())
                                gender = "Female";
                            else
                                gender = "No button selected!";

                        if(marriedCheckBox.isSelected())
                        {
                            marriedCheckBox.setSelected(true);
                            isMarried = true;
                            married = "Yes";
                        }

                        Person person = new Person(firstName,lastName,age,gender,isMarried,adress);

                        panel.removeAll();
                        panel.updateUI();

                        JLabel firstNameLabel = new JLabel("First Name: "+person.getFirstName());
                        firstNameLabel.setBounds(10,20,200,25);
                        panel.add(firstNameLabel);

                        JLabel lastNameLabel = new JLabel("Last Name: "+person.getLastName());
                        lastNameLabel.setBounds(10,50,200,25);
                        panel.add(lastNameLabel);

                        JLabel ageLabel = new JLabel("Age: "+person.getAge());
                        ageLabel.setBounds(10,80,200,25);
                        panel.add(ageLabel);

                        JLabel genderLabel = new JLabel("Gender: "+person.getGender());
                        genderLabel.setBounds(10,110,200,25);
                        panel.add(genderLabel);

                        JLabel marriedLabel = new JLabel("Married: "+married);
                        marriedLabel.setBounds(10,140,200,25);
                        panel.add(marriedLabel);

                        JLabel addressLabel = new JLabel("Address: "+person.getAddress());
                        addressLabel.setBounds(10,170,400,40);
                        panel.add(addressLabel);

                    }
                }
        );
    }

    private static JPanel buildPanel() {
        JFrame frame = new JFrame("Insert data");
        frame.setSize(400, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);

        placeComponents(panel);

        frame.setVisible(true);

        return panel;
    }


    private static void placeComponents(JPanel panel)
    {
        panel.setLayout(null);

        JLabel firstNameLabel = new JLabel("First Name: ");
        firstNameLabel.setBounds(10, 20, 80, 25);
        panel.add(firstNameLabel);

        firstNameInput = new JTextField(20);
        firstNameInput.setBounds(100, 20, 165, 25);
        panel.add(firstNameInput);

        JLabel lastNameLabel = new JLabel("Last Name: ");
        lastNameLabel.setBounds(10, 50, 80, 25);
        panel.add(lastNameLabel);

        lastNameInput = new JTextField(20);
        lastNameInput.setBounds(100, 50, 165, 25);
        panel.add(lastNameInput);

        JLabel ageLabel = new JLabel("Age: ");
        ageLabel.setBounds(10, 80, 80, 25);
        panel.add(ageLabel);

        ageInput = new JTextField(20);
        ageInput.setBounds(100, 80, 165, 25);
        panel.add(ageInput);

        JLabel genderLabel = new JLabel("Gender: ");
        genderLabel.setBounds(10, 110, 80, 25);
        panel.add(genderLabel);

        buttonGroup = new ButtonGroup();

        maleRadioBotton = new JRadioButton("Male");
        maleRadioBotton.setBounds(80,110,80,25);
        panel.add(maleRadioBotton);

        femaleRadioBotton = new JRadioButton("Female");
        femaleRadioBotton.setBounds(160,110,80,25);
        panel.add(femaleRadioBotton);

        buttonGroup.add(maleRadioBotton);
        buttonGroup.add(femaleRadioBotton);

        marriedCheckBox = new JCheckBox(" Married ?",false);
        marriedCheckBox.setBounds(10, 140, 110, 25);
        panel.add(marriedCheckBox);

        JLabel adressLabel = new JLabel("Adress: ");
        adressLabel.setBounds(10,170,80,25);
        panel.add(adressLabel);

        addressInput = new JTextArea();
        addressInput.setBounds(100,170,250,100);
        panel.add(addressInput);

        saveButton = new JButton("Save");
        saveButton.setBounds(10,300,100,20);
        panel.add(saveButton);

    }
}
