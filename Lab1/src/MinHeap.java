/**
 * An implementation of a MinHeap.
 * <p>
 * Uses an array to store the keys.
 * @author Kobe Takemura
 *
 */
public class MinHeap {

	 // - - - - Private Variables - - - -
	
	/**
	 * An integer array that will hold the keys.
	 */
    private int[] keys = null;
    
    
    /**
     *A field which will store the size of the heap.
     */
    private int size = 0;

    
    //Continued test comment

    // - - - - Constructors - - - -
    
    /**
     * Initializes an empty heap with the specified capacity. CS380
     * @param capacity Capacity of the heap.
     */
    public MinHeap(int capacity){
        keys = new int[capacity];
    }
    
    /**
     * Initializes a heap with given keys.
     * @param keys Keys to be stored in the heap.
     */
    public MinHeap(int[] keys){
        this.keys = keys;
        size = keys.length;

        for (int i = keys.length / 2 - 1; i >= 0; i--){
            heapify(i);
        }
    }


    // - - - - Getter Functions - - - -
    /**
     * A getter method that returns the capacity of the heap.
     * @return the length of the keys array.
     */
    public int getCapacity(){
        return keys.length;
    }
    
    /**
     * A getter method that returns the size of the heap. 
     * The number of elements stored in the heap.
     * @return the size of the heap.
     */
    public int getSize(){
        return size;
    }


    // - - - - Public Heap-Operations - - - -
    /**
     * A method that adds the keys
     * If heap is full prints error and returns
     * @param key Integer value to be added 
     */
    public void add(int key){
        if (getSize() >= getCapacity()){
            System.out.println("* * * Error: Heap is already full! * * *");
            return;
        }

        keys[size] = key;
        size++;

        moveUp(size - 1);
    }
    
    /**
     * A getter method that retrieves the minimum element from the heap
     * @return the smallest key in the heap
     */
    public int getMin(){
        return keys[0];
    }
    /**
     * A method that removes the minimum element from the heap and returns it
     * Uses heapify to maintain proper heap structure
     * @return the smallest key from the heap
     */
    public int removeMin(){
        int min = keys[0];

        size--;

        keys[0] = keys[size];
        heapify(0);

        return min;
    }
    /**
     * A method that returns a string representation of the heap
     * @return comma separated string of keys in the heap
     */
    public String toString(){
      String str = "";
      
      for(int i : keys){
         str += i+", ";      
      }
      
      return str;
    }
    /**
     * A method that performs an unnecessary calculation 
     * @param value an integer used 
     * @return the result of (capacity-size)*value
     */
    public int complexCalculation(int value) {
    	//Hint: this is a silly method that has no
    	//real purpose.
    	return (this.getCapacity() - size) * value;
    }
    


    // - - - - Private Heap-Operations - - - -

    private void heapify(int index){
        while (true){
            int l = left(index);
            int r = right(index);

            if (l >= getSize()){
                break;
            }

            int smallest = l;
            if (r < getSize() && keys[r] < keys[l]){
                smallest = r;
            }

            if (keys[smallest] >= keys[index]){
                break;
            }

            swapKeys(smallest, index);
            index = smallest;
        }
    }

    private void moveUp(int index){
        while (index > 0){
            int parInd = parent(index);

            if (keys[parInd] <= keys[index]){
                return;
            }

            swapKeys(parInd, index);
            index = parInd;
        }
    }


    // - - - - Helper Functions - - - -

    private int left(int index){
        return 2 * index + 1;
    }

    private int right(int index){
        return 2 * index + 2;
    }

    private int parent(int index){
        return (index - 1) / 2;
    }

    private void swapKeys(int ind1, int ind2){
        int tmp = keys[ind1];
        keys[ind1] = keys[ind2];
        keys[ind2] = tmp;
    }

}
