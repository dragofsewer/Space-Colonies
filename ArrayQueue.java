// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I 
// accept the actions of those who do.
// -- Stephen Ye (stepheny)
package spacecolonies;

import queue.EmptyQueueException;
import queue.QueueInterface;

/**
 * This class represents an array implementation of a queue.
 * @author stephenye
 * @version 2022.11.08
 * @param <T>
 */
public class ArrayQueue<T> implements QueueInterface<T>  {

    private T[] queue;
    /**
     * the default capacity
     */
    public static final int DEFAULT_CAPACITY = 20;
    private int enqueueIndex;
    private int dequeueIndex;
    private int size;
    
    /**
     * Creates an empty queue with the default capacity.
     * @param num the capacity of the queue
     */
    @SuppressWarnings("unchecked")
    public ArrayQueue(int num)
    {
        
        queue = (T[]) new Object[num + 1];
        enqueueIndex = 0;
        dequeueIndex = 1;
        size = 0;
        
        
    }
    
    /**
     * returns the size of the queue
     * @return int the size
     */
    public int getSize()
    {
        return size;
        
        
    }
    
    /**
     * Returns the length of the underlying array which is the
     * length of the queue +1.
     * @return the length of the underlying array
     */
    public int getLengthOfUnderlyingArray()
    {
        return queue.length;
        
        
        
    }
    
    /**
    * makes sure the capacity is valid for use in other methods
    */
    private void ensureCapacity()
    {
        if (isFull())
        {
            T[] tempQueue = (T[]) new Object[(queue.length * 2) - 1];
            for (int i = 0; i < size; i++)
            {
                tempQueue[i] = queue[(dequeueIndex + i) % queue.length];
            }
            dequeueIndex = 0;
            enqueueIndex = size - 1;
            queue = tempQueue;
        }
        
        
    }
    
    /**
     * adjusts the index so that it is helpful in other methods
     * @param index the index what is being adjusted
     * @return int the new value of the index
     */
    private int incrementIndex(int index)
    {
        return ((index + 1) % queue.length);
        
    }
    
    /**
     * removes all entries from this queue.
     */
    public void clear()
    {
        @SuppressWarnings("unchecked")
        T[] tempQueue = (T[]) new Object[getLengthOfUnderlyingArray()];
        queue = tempQueue;
        enqueueIndex = 0;
        dequeueIndex = 1;
        size = 0;
        
        
        
    }
    
    /**
     * returns an array containing all the entries in this queue.
     * @return Object[] an array containing all the entries in this queue
     */
    public Object[] toArray()
    {
        if (isEmpty())
        {
            throw new EmptyQueueException();
        }
        @SuppressWarnings("unchecked")
        T[] tempQueue = (T[]) new Object[size];
        for (int i = 0; i < size; i++)
        {
            tempQueue[i] = queue[(dequeueIndex + i) % queue.length];
        }
        return tempQueue;
        
        
        
    }
    
    /**
     * returns a string representation of this queue.
     * @return String a string representation of this queue
     */
    public String toString()
    {
        String result = "[";
        for (int i = 0; i < size; i++)
        {
            result += queue[i] + ", ";
        }
        result += "]";
        return result;
    }
    
    /**
     * determines whether two queues are equal.
     * @param obj the object to be compared with this queue
     * @return boolean true if the two queues are equal, or false if not
     */
    public boolean equals(Object obj)
    {
        if (this == obj) {
            return true;
        }
        else if ( obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        ArrayQueue<?> other = (ArrayQueue<?>) obj;
        if (getSize() != other.getSize()) {
            return false;
            
        }
        for (int i = 0; i < getSize(); i++) {
            T element = queue[(dequeueIndex + i) % queue.length];
            @SuppressWarnings("unchecked")
            T otherElement = (T)other.queue[(
                other.dequeueIndex + i) % other.queue.length];
            if (!element.equals(otherElement)) {
                return false;
            }
        }

        return true;

        
    }
    
    
    /**
     * dequeues and returns the entry at the front of this queue.
     * @return T the object at the front of the queue
     */
    @Override
    public T dequeue() {
        // TODO Auto-generated method stub
        if (isEmpty())
        {
            throw new EmptyQueueException();
        }
        queue[dequeueIndex] = null;
        T front = queue[dequeueIndex];
        dequeueIndex = incrementIndex(dequeueIndex);
        size--;
        return front;
    }

    /** 
     * enqueues a new entry to the back of this queue.
     * @param input the object to be added as a new entry
     */
    @Override
    public void enqueue(T input) {
        // TODO Auto-generated method stub
        ensureCapacity();
        enqueueIndex = incrementIndex(enqueueIndex);
        queue[enqueueIndex] = input;
        size++;

    }

    /**
     * retrieves the entry at the front of this queue.
     * @return T the object at the front of the queue
     */
    @Override
    public T getFront() {
        // TODO Auto-generated method stub
        if (isEmpty())
        {
            throw new EmptyQueueException();
        }
        return queue[dequeueIndex];
    }

    /**
     * determines whether this queue is empty.
     * @return boolean true if the queue is empty, or false if not
     */
    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return dequeueIndex - enqueueIndex == 1;
    }
    
    /**
     * determines whether this queue is full.
     * @return boolean true if the queue is full, or false if not
     */
    private boolean isFull()
    {
        return ((enqueueIndex + 2) % queue.length) == dequeueIndex;
        
    }
    
    
        
        
    
    
    
}
