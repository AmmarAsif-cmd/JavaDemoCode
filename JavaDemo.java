import java.util.*;

// Shape class with polymorphism
abstract class Shape {
    public abstract double area();
}

class Circle extends Shape {
    double radius;
    
    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
}

class Rectangle extends Shape {
    double width, height;
    
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double area() {
        return width * height;
    }
}

// Sorting algorithms
class Sorter {
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivot = partition(arr, low, high);
            quickSort(arr, low, pivot - 1);
            quickSort(arr, pivot + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1; // Target not found
    }
}

// Demonstrating multi-threading
class MyThread extends Thread {
    private int num;
    
    public MyThread(int num) {
        this.num = num;
    }
    
    @Override
    public void run() {
        System.out.println("Thread " + num + " is running.");
    }
}

// Main class
public class JavaDemo {
    public static void main(String[] args) {
        // Data structure: HashMap and LinkedList
        Map<String, Integer> map = new HashMap<>();
        map.put("Apple", 3);
        map.put("Banana", 2);
        map.put("Cherry", 5);
        
        System.out.println("Map contents: " + map);
        
        List<String> list = new LinkedList<>(Arrays.asList("A", "B", "C"));
        list.add("D");
        System.out.println("List contents: " + list);

        // Sorting: QuickSort example
        int[] arr = {3, 6, 8, 10, 1, 2, 1};
        System.out.println("Original array: " + Arrays.toString(arr));
        Sorter.quickSort(arr, 0, arr.length - 1);
        System.out.println("Sorted array: " + Arrays.toString(arr));

        // Binary Search example
        int target = 6;
        int result = Sorter.binarySearch(arr, target);
        System.out.println("Index of " + target + ": " + result);
        
        // OOP: Shape example
        Shape circle = new Circle(5);
        Shape rectangle = new Rectangle(4, 6);
        System.out.println("Circle area: " + circle.area());
        System.out.println("Rectangle area: " + rectangle.area());

        // Multi-threading: Thread example
        MyThread thread1 = new MyThread(1);
        MyThread thread2 = new MyThread(2);
        thread1.start();
        thread2.start();

        // Exception handling
        try {
            int result2 = divide(10, 0);
            System.out.println("Result: " + result2);
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero.");
        }
        return a / b;
    }
}
