package util.sort.impl;

import util.collection.DoubleLinkedLstQueue;
import util.sort.Sort;

/**
 *
 * @author : Pham Tuan Ngoc
 *
 * define the select sort
 */
public abstract class SelectSort<E> implements Sort {

    /**
     * method sort
     *
     * @param doubleLinkedLstQueue list before sort
     * @return result list after sort
     */
    public DoubleLinkedLstQueue sort(DoubleLinkedLstQueue doubleLinkedLstQueue) {

        //buble sort
//        DoubleLinkedLstQueue temp ;
        for (int i = 0; i < doubleLinkedLstQueue.length(); i++) {
            for (int j = 1; j < doubleLinkedLstQueue.length() - i; j++) {
                if (compare(doubleLinkedLstQueue.getAt(j - 1), doubleLinkedLstQueue.getAt(j))) {
//                    temp = (DoubleLinkedLstQueue) doubleLinkedLstQueue.getAt(j - 1);
//                    E e = (E) doubleLinkedLstQueue.getAt(j);
//                    E el = (E) doubleLinkedLstQueue.getAt(j - 1);
//                    temp = (DoubleLinkedLstQueue) el;//bien tam bang object j-1
//                    el = e;//object j=j-1
//                    e = (E) temp;//gan lai temp=j
                    swap(doubleLinkedLstQueue, j-1, j);
                    
                }
            }
        }
        
        return doubleLinkedLstQueue;
        //buble sort
//        for (int i = 0; i < doubleLinkedLstQueue.length() - 1; i++) {
//            for (int j = i; j < doubleLinkedLstQueue.length(); j++) {
//                if (compare(doubleLinkedLstQueue.getAt(i), doubleLinkedLstQueue.getAt(j))) {
//                    swap(doubleLinkedLstQueue, i, j);
//                }
//            }
//        }
//        return doubleLinkedLstQueue;
    }

    /**
     * swap 2 element in list with i and j index
     *
     * @param doubleLinkedLstQueue list before
     * @param i index
     * @param j index
     */
//    private void swap2 (DoubleLinkedLstQueue<E> doubleLinkedLstQueue,int){
//        
//    }
    private void swap(DoubleLinkedLstQueue<E> doubleLinkedLstQueue, int i, int j) {
        E e = doubleLinkedLstQueue.getAt(i);
        E e1 = doubleLinkedLstQueue.getAt(j);
        doubleLinkedLstQueue.delete(i);
        doubleLinkedLstQueue.insertAt(i, e1);
        doubleLinkedLstQueue.delete(j);
        doubleLinkedLstQueue.insertAt(j, e);
    }
}
