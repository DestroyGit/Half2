package Exceptions;

public class Main {
    public static void main(String[] args) {
        int sum = 0;
        String[][] array = {
                {"45", "15", "3", "9"},
                {"10", "21", "1", "0"},
                {"32", "100", "11", "12"},
                {"6", "0w", "1", "2"}
        };
        try{
            sum = except(array);
        }catch (MyArraySizeException | MyArrayDataException e){
            e.printStackTrace();
            System.out.print("\nСумма массива не посчиталась! ");
        }
        System.out.println("Сумма массива: " + sum);
    }

    public static int except(String[][] arr){
        int n = 4;
        for (int i = 0; i < arr.length; i++) {
            if(arr.length != n || arr[i].length != n){
                throw new MyArraySizeException("Строка или столбец не равны " + n, n);
            }
        }
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                try{
                    sum += Integer.parseInt(arr[i][j]);
                }catch (NumberFormatException e){
                    throw new MyArrayDataException("Неверный формат в ячейке [" + i + "]" + "[" + j + "]", i, j);
                }
            }
        }
        return sum;
    }


}
