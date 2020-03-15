import java.util.concurrent.TimeUnit;

public class MaxHeapPerformanceTest {
	private static int factor = 110;
    private static int testSize = 500000 * factor;

    public static void main(String[] args) {

    	// set up array
    	Integer[] data = new Integer[testSize];
        for (int i=0; i<testSize; i++) {
        	data[i] = i;
        }
        
        System.out.println("Test Size: " + testSize);
        
        MaxHeap heapLN = new MaxHeap(testSize);
        MaxHeap heapN = new MaxHeap(testSize);
        testnLogN(data, heapLN);
        testN(data, heapN);
    }
    
    // timing method based on https://howtodoinjava.com/java/date-time/execution-elapsed-time/
    public static void testnLogN(Integer[] data, MaxHeap heapLN) {
    	long startTime = System.nanoTime();
        heapLN.MaxHeapLogN(data);
        long endTime = System.nanoTime();
        long durationInMillis = TimeUnit.NANOSECONDS.toMillis(endTime - startTime);
        System.out.println("nLogN : " + durationInMillis);
    }
    
    public static void testN(Integer[] data, MaxHeap heapN) {
    	long startTime = System.nanoTime();
        heapN.MaxHeapN(data);
        long endTime = System.nanoTime();
        long durationInMillis = TimeUnit.NANOSECONDS.toMillis(endTime - startTime);
        System.out.println("N : " + durationInMillis);
    }
}
