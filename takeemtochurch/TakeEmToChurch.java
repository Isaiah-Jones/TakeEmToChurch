/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package takeemtochurch;

/**
 * CSC 255
 * Mr.Osborne
 * @author Isaiah J Jones 
 * 12-5-2017
 */

/*
This program is designed to utilize Stacks and Queues to read several strings of integers from a file,
rearrange said intgers and then print them out according to a specific permutation
 */
import java.io.*;
import java.util.*;

public class TakeEmToChurch {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        //import file with integer values
        String fileName = args[0];

        //Declare variables and Data Structures
        File file = new File(fileName);
        Scanner input = new Scanner(file);
        Stack<Integer> list = new Stack<Integer>();
        MyQueue<Integer> numQueue = new MyQueue<>();
        MyQueue<Integer> numQ2 = new MyQueue<>();
        MyQueue<Integer> queue = new MyQueue<>();
        MyQueue<Integer> tempSet = new MyQueue<Integer>();

        for (int i = 0; i < 5; i++) {
            weirdSort(input, list, numQueue, numQ2, queue, tempSet, 10);
        }
    }

    private static void weirdSort(Scanner input, Stack<Integer> list, MyQueue<Integer> numQueue, MyQueue<Integer> numQ2, MyQueue<Integer> queue, MyQueue<Integer> tempSet, int set) {
        //read integers 10 integers from the .txt file
        for (int i = 0; i < 10; i++) {
            tempSet.enqueue(input.nextInt());
        }

        //Print out the original sequence
        System.out.print("Orignal Sequence:  ");
        for (int i = 0; i < tempSet.getSize(); i++) {
            if (i == 9) {
                System.out.println(tempSet.select(i));
            } else {
                System.out.print(tempSet.select(i));
            }
        }

        //Split numbers into even and odd
        for (int i = 0; i < tempSet.getSize(); i++) {
            if (tempSet.select(i) % 2 == 0) {
                list.add(tempSet.select(i));
            } else {
                numQueue.enqueue(tempSet.select(i));
            }
        }

        //load the odd numbers into a Queue according to a specifc permutation
        if (numQueue.getSize() % 2 == 1) {
            for (int i = 0, j = numQueue.getSize() - 1; i <= (numQueue.getSize() / 2); i++, j--) {
                numQ2.enqueue(numQueue.select(j));
                queue.enqueue(numQueue.select(i));
                queue.enqueue(numQ2.select(i));
            }
        } else {
            for (int i = 0, j = numQueue.getSize() - 1; i < (numQueue.getSize() / 2); i++, j--) {
                numQ2.enqueue(numQueue.select(j));
                queue.enqueue(numQueue.select(i));
                queue.enqueue(numQ2.select(i));
            }
        }

        //Print out the modified sequence;
        System.out.print("Modified Sequence: ");

        //Ensure the same key in the queue is not printed twice
        if (set % 2 == 0) {

            for (int i = 0; i < 5; i++) {
                System.out.print(list.pop());
            }
            for (int i = 0; i < queue.getSize() - 1; i++) {
                if (i == queue.getSize() - 2) {
                    System.out.println(queue.select(i));
                    System.out.println();
                } else {
                    System.out.print(queue.select(i));
                }
            }
        } else {
            for (int i = 0; i < 5; i++) {
                System.out.print(list.pop());
            }
            for (int i = 0; i < queue.getSize(); i++) {
                if (i == queue.getSize() - 1) {
                    System.out.println(queue.select(i));
                    System.out.println();
                } else {
                    System.out.print(queue.select(i));
                }
            }
        }

        //Empty all of the Queues
        for (int i = 0; i <= numQueue.getSize() + 3; i++) {
            numQueue.dequeue(i);
        }
        for (int i = 0; i <= numQ2.getSize() + 1; i++) {
            numQ2.dequeue(i);
        }
        for (int i = 0; i < 10; i++) {
            tempSet.dequeue(i);
        }
        for (int i = 0; i < queue.getSize() + 6; i++) {
            queue.dequeue(i);
        }

    }

}
