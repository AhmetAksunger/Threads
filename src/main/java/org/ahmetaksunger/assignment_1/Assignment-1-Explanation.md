# CMPE 261: Large Scale Programming
## Assignment 1 - Istanbul Bilgi University - Fall 2023

### Task
You are expected to reimplement the animation in Worksheet 3 with threads and multiple
moving objects. Number of objects in the animation should be dynamic.
- Get an input from user to determine the number of objects in the animation. (10 pts)
- Initialize all objects on random locations, with random speeds, and random colors
inside the frame. (10 pts)
- Add buttons to start and stop the animation. (10pts)
- Update the locations of each object based on their speeds, using separate threads for
the calculation. You can follow the steps below to implement this or implement in a
different way as long as you comment your code, (50 pts)
  - Create a class called Shape which extends Thread.
  - Update the movement of the object in the overriden run method. You can do
  the update inside an infinite loop.
  - Create a class called Animation which again extends Thread or implements
  Runnable. Use repaint in the run method to paint the shapes on the frame
  continuously. (If you want to slow down the objects, you can use Thread.sleep,
  but make sure the delay of animation thread matches the delay of shape threads.)
  - Hint: Interrupted methods can not be started again, so you need to create new
  shapes with same properties in order to click start-stop-start in sequence and
  make it work.
- Make sure that if the shapes hit the edge of the animation frame, they bounce back.
(20 pts)

Note: Do not compress your files, submit only java files.<br>
Note: Do not forget to justify your answers with comments.