package julia.elementary;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;


@SuppressWarnings("ALL")
public class Main {

    public static void main(String[] args) {
        IntList arrayList = new IntArrayList();
        arrayList.add(4);
        arrayList.add(3);
        arrayList.add(5);
        arrayList.add(89);
        arrayList.add(11);
        arrayList.add(0);
        arrayList.add(126);
        arrayList.add(328);
        arrayList.add(922);
        arrayList.add(92);
        System.out.println("IntArrayList not sorting:");
        System.out.println(arrayList);
        System.out.println("IntArrayList a sorting:");
        sort(arrayList);

        IntList linkedList = new IntLinkedList();
        linkedList.add(2);
        linkedList.add(2287);
        linkedList.add(23);
        linkedList.add(2);
        linkedList.add(122);
        linkedList.add(622);
        linkedList.add(31);
        linkedList.add(22);
        linkedList.add(829);
        linkedList.add(17);
        System.out.println("IntLinkedList not sorting:");
        System.out.println(linkedList);
        System.out.println("IntLinkedList a sorting:");
        sort(linkedList);
        ResizeCount(1000);
        ResizeCount(1000000);
        System.out.println();
        speed();
    }

    private static void sort(IntList list) {
        int[] array = list.makeArrayFromIntList(list);
        int temp, j;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                temp = array[i + 1];
                array[i + 1] = array[i];
                j = i;
                while (j > 0 && temp < array[j - 1]) {
                    array[j] = array[j - 1];
                    j--;
                }
                array[j] = temp;
            }
        }
        System.out.println(list.makeIntListFromArray(array));
    }


    private static void ResizeCount(int size) {
        IntArrayList intArrayList = new IntArrayList();
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            intArrayList.add(random.nextInt(10));
        }
        System.out.printf("The method 'resize()' is called %d times when %d elements are added to the list.\n", intArrayList.getResizeCounter(), size);
    }


    private static void speed() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        IntArrayList intArrayList = new IntArrayList();
        LinkedList<Integer> linkedList = new LinkedList<>();
        IntLinkedList intLinkedList = new IntLinkedList();

        final int COUNT = 100000;
        long timeTo;
        long timeAfter;
        double currentTime;

        Random random = new Random();
        for (int i = 0; i < COUNT; i++) {
            arrayList.add(random.nextInt(100));
            intArrayList.add(random.nextInt(100));
            linkedList.add(random.nextInt(100));
            intLinkedList.add(random.nextInt(100));
        }

        System.out.println("get()' from the middle  (10000 times):");
        timeTo = System.currentTimeMillis();
          for (int i = 0; i < 10000; i++) {
        }
        timeAfter = System.currentTimeMillis();
        currentTime = (timeAfter - timeTo) / 1000.0;
        System.out.printf("ArrayList: %.1f sec.\n", currentTime);

        timeTo = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            intArrayList.get(COUNT / 2);
        }
        timeAfter = System.currentTimeMillis();
        currentTime = (timeAfter - timeTo) / 1000.0;
        System.out.printf("IntArrayList: %.1f sec.\n", currentTime);

        timeTo = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            linkedList.get(COUNT / 2);
        }
        timeAfter = System.currentTimeMillis();
        currentTime = (timeAfter - timeTo) / 1000.0;
        System.out.printf("LinkedList: %.1f sec.\n", currentTime);

        timeTo = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            intLinkedList.get(COUNT / 2);
        }
        timeAfter = System.currentTimeMillis();
        currentTime = (timeAfter - timeTo) / 1000.0;
        System.out.printf("IntLinkedList: %.1f sec.\n", currentTime);
        System.out.println();

        System.out.println("Method 'add' to the end  (2000000 times):");
        timeTo = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            arrayList.add(50);
        }
        timeAfter = System.currentTimeMillis();
        currentTime = (timeAfter - timeTo) / 1000.0;
        System.out.printf("ArrayList: %.1f sec.\n", currentTime);

        timeTo = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            intArrayList.add(50);
        }
        timeAfter = System.currentTimeMillis();
        currentTime = (timeAfter - timeTo) / 1000.0;
        System.out.printf("IntArrayList: %.1f sec.\n", currentTime);

        timeTo = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            linkedList.add(50);
        }
        timeAfter = System.currentTimeMillis();
        currentTime = (timeAfter - timeTo) / 1000.0;
        System.out.printf("LinkedList: %.1f sec.\n", currentTime);

        timeTo = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            intLinkedList.add(50);
        }
        timeAfter = System.currentTimeMillis();
        currentTime = (timeAfter - timeTo) / 1000.0;
        System.out.printf("IntLinkedList: %.1f sec.\n", currentTime);
        System.out.println();

        System.out.println("Method add to the top  (10000 times):");
        timeTo = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            arrayList.add(0, 50);
        }
        timeAfter = System.currentTimeMillis();
        currentTime = (timeAfter - timeTo) / 1000.0;
        System.out.printf("ArrayList: %.1f sec.\n", currentTime);

        timeTo = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            intArrayList.add(0, 50);
        }
        timeAfter = System.currentTimeMillis();
        currentTime = (timeAfter - timeTo) / 1000.0;
        System.out.printf("IntArrayList: %.1f sec.\n", currentTime);

        timeTo = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            linkedList.add(0, 50);
        }
        timeAfter = System.currentTimeMillis();
        currentTime = (timeAfter - timeTo) / 1000.0;
        System.out.printf("LinkedList: %.1f sec.\n", currentTime);

        timeTo = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            intLinkedList.add(0, 50);
        }
        timeAfter = System.currentTimeMillis();
        currentTime = (timeAfter - timeTo) / 1000.0;
        System.out.printf("IntLinkedList: %.1f sec.\n", currentTime);
        System.out.println();

        System.out.println("Method 'add' to the middle  (5000 times):");
        timeTo = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) {
            arrayList.add(arrayList.size() / 2, 50);
        }
        timeAfter = System.currentTimeMillis();
        currentTime = (timeAfter - timeTo) / 1000.0;
        System.out.printf("ArrayList: %.1f sec.\n", currentTime);

        timeTo = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) {
            intArrayList.add(intArrayList.size() / 2, 50);
        }
        timeAfter = System.currentTimeMillis();
        currentTime = (timeAfter - timeTo) / 1000.0;
        System.out.printf("IntArrayList: %.1f sec.\n", currentTime);

        timeTo = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) {
            linkedList.add(linkedList.size() / 2, 50);
        }
        timeAfter = System.currentTimeMillis();
        currentTime = (timeAfter - timeTo) / 1000.0;
        System.out.printf("LinkedList: %.1f sec.\n", currentTime);

        timeTo = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) {
            intLinkedList.add(intLinkedList.size() / 2, 50);
        }
        timeAfter = System.currentTimeMillis();
        currentTime = (timeAfter - timeTo) / 1000.0;
        System.out.printf("IntLinkedList: %.1f sec.\n", currentTime);
        System.out.println();

        System.out.println("Method 'remove' from the top  (10000 times):");
        timeTo = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            arrayList.remove(0);
        }
        timeAfter = System.currentTimeMillis();
        currentTime = (timeAfter - timeTo) / 1000.0;
        System.out.printf("ArrayList<Integer>: %.1f sec.\n", currentTime);

        timeTo = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            intArrayList.remove(0);
        }
        timeAfter = System.currentTimeMillis();
        currentTime = (timeAfter - timeTo) / 1000.0;
        System.out.printf("IntArrayList: %.1f sec.\n", currentTime);

        timeTo = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            linkedList.remove(0);
        }
        timeAfter = System.currentTimeMillis();
        currentTime = (timeAfter - timeTo) / 1000.0;
        System.out.printf("LinkedList<Integer>: %.1f sec.\n", currentTime);

        timeTo = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            intLinkedList.remove(0);
        }
        timeAfter = System.currentTimeMillis();
        currentTime = (timeAfter - timeTo) / 1000.0;
        System.out.printf("IntLinkedList: %.1f sec.\n", currentTime);
        System.out.println();

        System.out.println("Method 'remove()' from the middle (5000 times):");
        timeTo = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) {
            arrayList.remove(arrayList.size() / 2);
        }
        timeAfter = System.currentTimeMillis();
        currentTime = (timeAfter - timeTo) / 1000.0;
        System.out.printf("ArrayList: %.1f sec.\n", currentTime);

        timeTo = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) {
            intArrayList.remove(intArrayList.size() / 2);
        }
        timeAfter = System.currentTimeMillis();
        currentTime = (timeAfter - timeTo) / 1000.0;
        System.out.printf("IntArrayList: %.1f sec.\n", currentTime);

        timeTo = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) {
            linkedList.remove(linkedList.size() / 2);
        }
        timeAfter = System.currentTimeMillis();
        currentTime = (timeAfter - timeTo) / 1000.0;
        System.out.printf("LinkedList<Integer>: %.1f sec.\n", currentTime);

        timeTo = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) {
            intLinkedList.remove(intLinkedList.size() / 2);
        }
        timeAfter = System.currentTimeMillis();
        currentTime = (timeAfter - timeTo) / 1000.0;
        System.out.printf("IntLinkedList: %.1f sec.\n", currentTime);
        System.out.println();
    }
}