package view;

import controller.Controller;

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
    private JRadioButton d100;
    private JRadioButton d200;
    private JRadioButton d400;
    private Controller controller;

    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public UserInterface() {
        setController(new Controller());
        textPane1.setEditable(false);
        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ((top5.isSelected() || personalBest.isSelected() || recordHolder.isSelected()) &&
                        (mixed.isSelected() || women.isSelected() || men.isSelected()) &&
                        (d100.isSelected() || d200.isSelected() || d400.isSelected())) {
                    getController().execute();
                    textPane1.setText(getController().concat());
                    textPane1.setCaretPosition(0);
                }
                else {
                    textPane1.setText("Please choose three of the radio buttons, one in each triplet");

                }
            }
        });
        top5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                recordHolder.setSelected(false);
                personalBest.setSelected(false);
                getController().setQueryType("top5");
            }
        });
        recordHolder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                top5.setSelected(false);
                personalBest.setSelected(false);
                getController().setQueryType("record");
            }
        });
        personalBest.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                top5.setSelected(false);
                recordHolder.setSelected(false);
                getController().setQueryType("pb");
            }
        });
        mixed.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                women.setSelected(false);
                men.setSelected(false);
                getController().setGender(" ");
            }
        });
        women.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mixed.setSelected(false);
                men.setSelected(false);
                getController().setGender("female");
            }
        });
        men.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mixed.setSelected(false);
                women.setSelected(false);
                getController().setGender("male");
            }
        });
        d100.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                d200.setSelected(false);
                d400.setSelected(false);
                getController().setSport("100");
            }
        });
        d200.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                d400.setSelected(false);
                d100.setSelected(false);
                getController().setSport("200");
            }
        });
        d400.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                d100.setSelected(false);
                d200.setSelected(false);
                getController().setSport("400");
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
