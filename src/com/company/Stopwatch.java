package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Stopwatch extends JFrame
{
    JButton startButton;
    JButton exitButton;
    JButton stopButton;
    JLabel startLabel;
    JLabel stopLabel;
    JLabel elapsedLabel;
    JTextField startTextField;
    JTextField stopTextField;
    JTextField elapsedTextField;
    long startTime;
    long stopTime;
    double elapsedTime;

    public Stopwatch()
    {
        setTitle("Stopwatch");
        setSize(300, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        startButton = new JButton("Start");
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        add(startButton, gridBagConstraints);

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startButtonAction(e);
            }
        });

        stopButton = new JButton("Stop");
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        add(stopButton, gridBagConstraints);

        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stopButtonAction(e);
            }
        });

        exitButton = new JButton("Exit");
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        add(exitButton, gridBagConstraints);

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exitButtonAction(e);
            }
        });

        startLabel = new JLabel("Start Time");
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        add(startLabel, gridBagConstraints);

        stopLabel = new JLabel("Stop Time");
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        add(stopLabel, gridBagConstraints);

        elapsedLabel = new JLabel("Elapsed Time");
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        add(elapsedLabel, gridBagConstraints);

        startTextField = new JTextField("");
        startTextField.setColumns(15);
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        add(startTextField, gridBagConstraints);

        stopTextField = new JTextField("");
        stopTextField.setColumns(15);
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        add(stopTextField, gridBagConstraints);

        elapsedTextField = new JTextField("");
        elapsedTextField.setColumns(15);
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        add(elapsedTextField, gridBagConstraints);

        pack();
    }


    private void startButtonAction(ActionEvent actionEvent)
    {
        startTime = System.currentTimeMillis();
        startTextField.setText(String.valueOf(startTime));
        stopTextField.setText("");
        elapsedTextField.setText("");
    }

    private void stopButtonAction(ActionEvent actionEvent)
    {
        stopTime = System.currentTimeMillis();
        stopTextField.setText(String.valueOf(stopTime));
        elapsedTime = stopTime - startTime / 1000.0;
        elapsedTextField.setText(String.valueOf(elapsedTime));
    }

    private void exitButtonAction(ActionEvent actionEvent)
    {
        System.exit(0);
    }
}
