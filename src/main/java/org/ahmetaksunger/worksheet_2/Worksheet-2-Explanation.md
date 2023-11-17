# CMPE 261: Large Scale Programming
## Worksheet 5C - Istanbul Bilgi University - Fall 2023

### Task
Count the elements in N separate arrays, with different threads assigned to each one. You
will be using a class called HashMap, which is a data structure consisting of key-value pairs,
to store element counts. In this case the keys will be the unique elements in the array and
values will be the count of the occurences. A simple example for this will be shown in the
class.

- Implement a Counter class which extends Thread.
  - Constructor should take 3 arguments: an array, a HashMap and a ReentrantLock.
  - In the run method, traverse the given array and increment the count of the
  element in the HashMap on every occurence of the element.
  - Create a main method and test your Counter. When the arrays are large (eg.
  two arrays containing the value ”a” 400 times) what kind of problems do you
  encounter?
  - Solve the problem using ReentrantLock.
  - Test your Counter class again, proving that you have solved the problem.

Note: Do not compress your files, submit only java files.<br>
Note: Do not forget to justify your answers with comments