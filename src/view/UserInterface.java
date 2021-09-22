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
    private Controller controller;

    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public UserInterface() {
        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ((top5.isSelected() || personalBest.isSelected() || recordHolder.isSelected()) &&
                        (mixed.isSelected() || women.isSelected() || men.isSelected())) {
                    if (top5.isSelected()){
                        if (women.isSelected()){
                            getController().setGender("female");
                            getController().setQueryType("top5");
                            // TODO add code and btns for the sports
                        }
                        else if (men.isSelected()){
                            getController().setGender("male");
                            getController().setQueryType("top5");
                            // TODO add code and btns for the sports
                        }
                        else {
                            getController().setGender(" ");
                            getController().setQueryType("top5");
                            // TODO add code and btns for the sports
                        }
                    }
                    else if (personalBest.isSelected()){
                        if (women.isSelected()){
                            getController().setGender("female");
                            getController().setQueryType("pb");
                            // TODO add code and btns for the sports
                        }
                        else if (men.isSelected()){
                            getController().setGender("male");
                            getController().setQueryType("pb");
                            // TODO add code and btns for the sports
                        }
                        else {
                            getController().setGender(" ");
                            getController().setQueryType("pb");
                            // TODO add code and btns for the sports
                        }
                    }
                    else {
                        if (women.isSelected()){
                            getController().setGender("female");
                            getController().setQueryType("record");
                            // TODO add code and btns for the sports
                        }
                        else if (men.isSelected()){
                            getController().setGender("male");
                            getController().setQueryType("record");
                            // TODO add code and btns for the sports
                        }
                        else {
                            getController().setGender(" ");
                            getController().setQueryType("record");
                            // TODO add code and btns for the sports
                        }
                    }
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
        UserInterface userInterface = new UserInterface();
        JFrame frame = new JFrame("UserInterface");
        frame.setContentPane(new UserInterface().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        userInterface.setController(new Controller());
    }
}
