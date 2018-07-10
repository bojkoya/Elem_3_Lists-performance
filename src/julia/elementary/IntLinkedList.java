package julia.elementary;

public class IntLinkedList implements IntList {

    private Entry first;
    private Entry last;
    private int size = 0;

    public IntLinkedList() {
    }

    private class Entry {
        private int value;
        private Entry next;

        private Entry(Integer value) {
            this.value = value;
        }

        private Entry() {
        }
    }

    @Override
    public void add(int element) {
        Entry entry = new Entry(element);
        if (last == null) {
            first = entry;
            last = entry;
        } else {
            last.next = entry;
            last = entry;
        }
        size++;
    }

    @Override
    public void add(int index, int element) {
        checkIndex(index);
        Entry entry = new Entry(element);
        if (index == 0) {
            entry.next = first;
            first = entry;
        } else if (index == size) {
            last.next = entry;
            last = entry;
        } else {
            Entry tmp = findNodeBeforeByIndex(index);
            entry.next = findByIndex(index);
            tmp.next = entry;
        }
        size++;
    }

    @Override
    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    @Override
    public boolean contains(int value) {
        return find(value) != null;
    }

    @Override
    public int get(int index) {
        checkIndex(index);
        return findByIndex(index).value;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean remove(int index) {
       checkIndex(index);
        if (index == 0) {
            first = first.next;
        } else {
            Entry entry = findNodeBeforeByIndex(index);
            Entry tmp = findByIndex(index);
            entry.next = tmp.next;
        }
        size--;
        return false;
    }

    @Override
    public boolean removeElement(int element) {
        if (size == 0) {
            return false;
        } else if (size == 1) {
            first = null;
            last = null;
            size = 0;
            return true;
        }

        Entry entryPrevious = findNodeBefore(element);

        if (entryPrevious.value == 0) {
            first = first.next;
            size--;
            return true;
        } else if (entryPrevious != null) {
            if (last.value == element) {
                entryPrevious.next = null;
                last = entryPrevious;
            } else {
                entryPrevious.next = entryPrevious.next.next;
            }
            size--;
            return true;
        }
        return false;
    }

    @Override
    public void set(int index, int element) {
        findByIndex(index).value = element;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int[] makeArrayFromIntList(IntList list) {
        int[] resultArray = new int[list.size()];
        Entry entry = first;
        for (int i = 0; i < resultArray.length; i++) {
            resultArray[i] = entry.value;
            entry = entry.next;
        }
        return resultArray;
    }

    @Override
    public IntList makeIntListFromArray(int[] array) {
        IntList resultIntList = new IntLinkedList();
        for (int anArray : array) {
            resultIntList.add(anArray);
        }
        return resultIntList;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        int index = 0;
        if (first != null) {
            Entry entry = first;
            result.append("Element ").append(index).append(" : ").append(first.value).append("\n");
            index++;
            while (entry.next != null) {
                entry = entry.next;
                result.append("Element ").append(index).append(" : ").append(entry.value).append("\n");
                index++;
            }
        }
        return result.toString();
    }

    @Override
    public void checkIndex(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException();
        }
    }

    private Entry find(int value) {
        if (first == null) {
            return null;
        }

        if (first.value == value) {
            return first;
        }

        Entry entry = first;
        while (entry.next != null) {
            entry = entry.next;
            if (entry.value == value) {
                return entry;
            }
        }
        return null;
    }

    private Entry findByIndex(int index) {
        checkIndex(index);
        int tmpIndex = 0;
        if (first == null) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            return first;
        }

        Entry entry = first;
        while (entry.next != null) {
            entry = entry.next;
            tmpIndex++;
            if (tmpIndex == index) {
                return entry;
            }
        }
        throw new IndexOutOfBoundsException();
    }

    private Entry findNodeBefore(int value) {
        if (first.value == value) {
            return new Entry();
        }

        Entry entry = first;
        while (entry.next != null) {
            if (entry.next.value == value) {
                return entry;
            }
            entry = entry.next;
        }
        return null;
    }

    private Entry findNodeBeforeByIndex(int index) {
        if (index <= 0 || index > size - 1) {
            return null;
        }

        int count = 0;
        Entry entry = first;
        while (entry.next != null) {
            if (count == index - 1) {
                return entry;
            }
            count++;
            entry = entry.next;
        }
        return null;
    }
}