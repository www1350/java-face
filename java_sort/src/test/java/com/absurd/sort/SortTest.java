package com.absurd.sort;

import org.junit.Test;

/***
 *
 */
public class SortTest {
    @Test
    public void  bubble_Test(){
        Sort sort = new Sort(new int[]{2,5,8,7,6,9,4,6,3,88,74,15,7,85,4,56,9,46,54,12});
        sort.display();
        sort.bubbleSort();
        sort.display();

    }


    @Test
    public void  bubble_improve_Test(){
        Sort sort = new Sort(new int[]{2,5,8,7,6,9,4,6,3,88,74,15,7,85,4,56,9,46,54,12});
        sort.display();
        sort.bubbleSort_improve();
        sort.display();

    }

    @Test
    public void  quick_Test(){
        Sort sort = new Sort(new int[]{2,5,8,7,6,9,4,6,3,88,74,15,7,85,4,56,9,46,54,12});
        sort.display();
        sort.quickSort();
        sort.display();

    }

    @Test
    public void insertion_Test(){
        Sort sort = new Sort(new int[]{2,5,8,7,6,9,4,6,3,88,74,15,7,85,4,56,9,46,54,12});
        sort.display();
        sort.insertionSort();
        sort.display();
    }
}
