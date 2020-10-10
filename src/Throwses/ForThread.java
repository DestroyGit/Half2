package Throwses;

public class ForThread extends Thread{
    private float [] arr;
    private int start;
    private int h;

    public ForThread(float[] arr, int start, int h) {
        this.arr = arr;
        this.start = start;
        this.h = h;
    }

    @Override
    public void run() {
        for (int i = 0; i < h; i++) {
//            System.out.println(i); // для теста
            arr[i] = (float) (arr[i] * Math.sin(0.2f + (i + start) / 5) * Math.cos(0.2f + (i + start) / 5) * Math.cos(0.4f + (i + start) / 2));
        }
    }
}
