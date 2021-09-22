package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserInterface {
    private JPanel panel1;
    private JRadioButton top5;
    private JRadioButton recordHolder;
    private JRadioButton personalBest;
    private JRadioButton mixed;
    private JRadioButton women;
    private JRadioButton men;
    private JTextPane textPane1;
    private JButton search;
    private JLabel title;

    public UserInterface() {
        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ((top5.isSelected() || personalBest.isSelected() || recordHolder.isSelected()) &&
                        (mixed.isSelected() || women.isSelected() || men.isSelected())) {
                    textPane1.setText("hello\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nhello");
                    textPane1.setCaretPosition(0);
                }
                else {
                    textPane1.setText("Please click two of the radio buttons, one in each triplet");

                }
            }
        });
        top5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                recordHolder.setSelected(false);
                personalBest.setSelected(false);
            }
        });
        recordHolder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                top5.setSelected(false);
                personalBest.setSelected(false);
            }
        });
        personalBest.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                top5.setSelected(false);
                recordHolder.setSelected(false);
            }
        });
        mixed.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                women.setSelected(false);
                men.setSelected(false);
            }
        });
        women.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mixed.setSelected(false);
                men.setSelected(false);
            }
        });
        men.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mixed.setSelected(false);
                women.setSelected(false);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("UserInterface");
        frame.setContentPane(new UserInterface().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
