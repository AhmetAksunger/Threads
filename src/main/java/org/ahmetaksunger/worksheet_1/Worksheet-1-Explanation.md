# CMPE 261: Large Scale Programming
## Worksheet 4C - Istanbul Bilgi University - Fall 2023

### Task
You are provided with three classes OperationThread, Operator and SumThread. You are
expected to implement array operations with threads, using these classes and the ones which
you will implement. An example will be shown in the lab.

- OperationThread is an abstract class which you do not need to modify. It is meant to
be extended by other classes such as SumThread by overriding the operation method.
- SumThread class, again, does not need any modifications. It is meant to be used in
Operator class to perform summation of elements of an array.
- Implement the following, 
  - Operator.sum method must get an array and a number of threads, calculate the
  sum of the elements in the array with specified number of threads.
  - Operator.average method. The method should use the SumThread class or the
  Operator.sum method and calculate the average of elements in a given array
  with given number of threads.
  - Similarly, implement Operator.multiply and MultiplyThread in order to find
  the multiplication of the elements in an array, given the number of threads.

Note: Do not compress your files, submit only java files.<br>
Note: Do not forget to justify your answers with comments