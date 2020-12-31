/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package takeemtochurch;

/**
 *
 * @author Isaiah
 */
public class MyQueue<E> {

    private java.util.LinkedList<E> list = new java.util.LinkedList<E>();

    public void enqueue(E e) {
        list.addLast(e);
    }

    public E dequeue(E e) {
        return list.removeFirst();
    }

    public int getSize() {
        return list.size();
    }

    public String toString() {
        return "Queue: " + list.toString();
    }

    public E select(int index) {
        return list.get(index);
    }

    public void replace(int index, E value) {
         list.remove(index);
         list.add(index, value);
    }
}
