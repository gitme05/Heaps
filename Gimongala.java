public class GimongalaHeap {
    private int[] heap;
    private int size;
    private int maxSize;

    public GimongalaHeap(int capacity) {
        this.maxSize = capacity;
        this.size = 0;
        this.heap = new int[maxSize];
    }

    private int parent(int pos) {
        return (pos - 1) / 2;
    }

    private int leftChild(int pos) {
        return (2 * pos) + 1;
    }

    private int rightChild(int pos) {
        return (2 * pos) + 2;
    }

    private boolean isLeaf(int pos) {
        return pos >= size / 2 && pos < size;
    }

    private void swap(int first, int second) {
        int temp = heap[first];
        heap[first] = heap[second];
        heap[second] = temp;
    }

    public void insert(int element) {
        if (size >= maxSize) {
            throw new IllegalStateException("Heap is full");
        }
        heap[size] = element;
        int current = size;

        while (heap[current] > heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
        size++;
    }

    private void heapify(int pos) {
        if (!isLeaf(pos)) {
            int left = leftChild(pos);
            int right = rightChild(pos);

            if (heap[pos] < heap[left] || heap[pos] < heap[right]) {
                if (heap[left] > heap[right]) {
                    swap(pos, left);
                    heapify(left);
                } else {
                    swap(pos, right);
                    heapify(right);
                }
            }
        }
    }

    public int remove() {
        if (size == 0) {
            throw new IllegalStateException("Heap is empty");
        }
        int popped = heap[0];
        heap[0] = heap[--size];
        heapify(0);
        return popped;
    }

    public void printHeap() {
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        GimongalaHeap heap = new GimongalaHeap(10);
        heap.insert(10);
        heap.insert(20);
        heap.insert(30);
        heap.insert(40);

        System.out.println("Heap elements:");
        heap.printHeap();

        System.out.println("Removed max element: " + heap.remove());
        System.out.println("Heap after removal:");
        heap.printHeap();
    }
             }
