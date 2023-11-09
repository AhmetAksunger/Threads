package org.ahmetaksunger.assignment_1;

import java.awt.*;
import java.util.Random;

public class Shape extends Thread implements Prototype<Shape> {

    /**
     * Fields for the Shape class.
     * Used the Point class to represent both x and y in one class.
     * Used the Dimension class to represent both width and height in one class.
     */
    private int speedX;
    private int speedY;
    private Point location;
    private int radius;
    private Color color;

    private final Random random = new Random();

    /**
     * Generates shapes with random values.
     * This method is used in the Animation class to generate requested amount of random shapes.
     *
     * @param number number of shapes to generate
     * @return array of shapes
     */
    public static Shape[] generateShapes(int number) {

        Shape[] shapes = new Shape[number];
        for (int i = 0; i < number; i++) {
            shapes[i] = new Shape();
        }
        return shapes;
    }

    /**
     * Default constructor to generate a shape with random values.
     * Generating the random values with the helper methods.
     */
    public Shape() {
        this.speedX = randomSpeed(10);
        this.speedY = randomSpeed(10);
        this.location = randomLocation(600, 400);
        this.radius = randomRadius(100);
        this.color = randomColor();
    }

    /**
     * Private Shape constructor to clone the shape object.
     *
     * @param shape shape object to clone
     */
    private Shape(Shape shape) {
        this.speedX = shape.speedX;
        this.speedY = shape.speedY;
        this.location = shape.location;
        this.radius = shape.radius;
        this.color = shape.color;
    }

    /**
     * Clones the shape object
     * The reason why I need this method is that once a thread is interrupted, it cannot be started again.
     * So in order to start the thread again, I need to clone the shape object. And start the cloned shape object.
     *
     * @return a cloned shape class
     */
    @Override
    public Shape clone() {
        return new Shape(this);
    }

    /**
     * Moves the shape object.
     * If the shape intersects with the frame, it changes the direction.
     */
    public void move() {
        if (intersectsX()) {
            speedX *= -1;
        }
        if (intersectsY()) {
            speedY *= -1;
        }
        location.x += speedX;
        location.y += speedY;
    }

    /**
     * Run method to move the object in a thread.
     * Interrupt logic here works as follows:
     * Once the shape thread is interrupted by the Animation class, the thread
     * throws InterruptedException. Once the thread is interrupted and threw an InterruptedException,
     * it's isInterrupted method is false again.
     * So to actually interrupt the thread, we need to call the interrupt method again in the catch block.
     * And now isInterrupted method returns true.
     */
    @Override
    public void run() {
        while (true) {
            move();
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                this.interrupt();
                return;
            }
        }
    }


    // Helper methods to check if the shape intersects with the frame
    private boolean intersectsX() {
        return location.x + radius >= 800 || location.x <= 0;
    }

    private boolean intersectsY() {
        return location.y + radius >= 600 || location.y - radius / 2 <= 0;
    }


    // Helper methods to set random values
    private int randomSpeed(int max) {
        return random.nextInt(max - 1) + 1;
    }

    private Point randomLocation(int xMax, int yMax) {
        return new Point(random.nextInt(xMax), random.nextInt(yMax) + 100);
    }

    private int randomRadius(int max) {
        return random.nextInt(max - 50) + 50;
    }

    private Color randomColor() {
        return new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
    }


    // Getters & Setters
    public int getSpeedX() {
        return speedX;
    }

    public void setSpeedX(int speedX) {
        this.speedX = speedX;
    }

    public int getSpeedY() {
        return speedY;
    }

    public void setSpeedY(int speedY) {
        this.speedY = speedY;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public Point getLocation() {
        return location;
    }

    public void setLocation(Point location) {
        this.location = location;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Random getRandom() {
        return random;
    }

}
