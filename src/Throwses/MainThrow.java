package Throwses;

public class MainThrow {
    private final static int SIZE = 10000000;
    private final static int HALF = SIZE / 2;

    public static void main(String[] args) {
        one();
        two();

    }

    private static void one() {
        float[] arr = new float[SIZE];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }
        long a = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
//            System.out.println("One: " + i); // для теста
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("Однопоточно: " + (System.currentTimeMillis() - a));
    }

    private static void two() {
        float[] arr = new float[SIZE];
        float[] arr1 = new float[HALF];
        float[] arr2 = new float[HALF];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }
        long a = System.currentTimeMillis();
        System.arraycopy(arr, 0, arr1, 0, HALF);
        System.arraycopy(arr, HALF, arr2, 0, HALF);

        ForThread t1 = new ForThread(arr1, 0, HALF);
        ForThread t2 = new ForThread(arr2, HALF, HALF);

        t1.start();
        t2.start();


        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(arr1, 0, arr, 0, HALF);
        System.arraycopy(arr2, 0, arr, HALF, HALF);

        System.out.println("Многопоточно: " + (System.currentTimeMillis() - a));
    }


}
