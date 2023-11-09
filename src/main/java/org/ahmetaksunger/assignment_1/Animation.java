package org.ahmetaksunger.assignment_1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * I've done the homework using the IntelliJ IDEA,
 * you might need to launch it using Intellij.
 */
public class Animation extends JFrame implements Runnable, ActionListener {

    private JPanel pnlInput;
    private JLabel lblNumber;
    private JTextField txtNumber;
    private JButton btnAdd, btnStart, btnStop;

    private Shape[] shapes;

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        if (shapes != null)
            for (Shape shape : shapes) {
                g.setColor(shape.getColor());
                g.fillOval(shape.getLocation().x, shape.getLocation().y, shape.getRadius(), shape.getRadius());
            }
    }

    public void initFrame() {
        setSize(800, 600);
        setTitle("Animation");
        setVisible(true);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void initComponents() {

        pnlInput = new JPanel(new GridLayout(2, 2));

        lblNumber = new JLabel("Number of objects");
        txtNumber = new JTextField();
        btnAdd = new JButton("Add Objects");
        btnStart = new JButton("Start");
        btnStop = new JButton("Stop");

        pnlInput.add(lblNumber);
        pnlInput.add(txtNumber);
        pnlInput.add(btnAdd);
        pnlInput.add(btnStart);
        pnlInput.add(btnStop);

        btnAdd.addActionListener(this);

        btnStart.addActionListener(this);
        btnStart.setEnabled(false);
        btnStop.addActionListener(this);
        btnStop.setEnabled(false);

        add(pnlInput);
    }

    public Animation() {
        initFrame();
        initComponents();
    }

    /**
     * A method that works when the add button is clicked.
     * It generates a shape array using the generateShapes method in the Shape class.
     */
    private void onClickAdd() {
        try {
            int number = Integer.parseInt(txtNumber.getText());
            this.shapes = Shape.generateShapes(number);
            btnStart.setEnabled(true);
            btnStop.setEnabled(true);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * A method that works when the start button is clicked.
     * It iterates over the shapes array and checks if the shape thread is interrupted.
     * If the shape thread is interrupted, it clones the shape and starts the thread again.
     * If the shape thread is not interrupted, directly starts the thread.
     */
    private void onClickStart() {
        for (int i = 0; i < shapes.length; i++) {
            if (shapes[i].isInterrupted()) {
                shapes[i] = shapes[i].clone();
                shapes[i].start();
            } else {
                shapes[i].start();
            }
        }
    }

    /**
     * A method that works when the stop button is clicked.
     * It iterates over the shapes array and interrupts the shape thread.
     */
    private void onClickStop() {
        for (Shape shape : shapes) {
            shape.interrupt();
        }
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource().equals(btnAdd)) {
            onClickAdd();
        } else if (actionEvent.getSource().equals(btnStart)) {
            onClickStart();
        } else if (actionEvent.getSource().equals(btnStop)) {
            onClickStop();
        }
    }

    public static void main(String[] args) {
        Animation app = new Animation();
        Thread t = new Thread(app);
        t.start();
    }

    /**
     * A thread run method to repaint.
     */
    @Override
    public void run() {
        while (true) {
            repaint();
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
            }
        }
    }
}
