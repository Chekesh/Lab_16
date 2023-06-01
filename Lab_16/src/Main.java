import java.util.Arrays;
import java.util.Scanner;
public class Main{
    interface Logik{
        boolean islogik(int n);
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Введите размерность размер массива");
        int size = input.nextInt();
        int[] array = new int[size];
        System.out.println("Введите эл массива");
        for (int i = 0; i < size; i++){
            array[i] = input.nextInt();
        }
        System.out.println("введённый массив: ");
        System.out.println(Arrays.toString(array));
        System.out.println("Введите: < или >");
        String var = input.next();
        if (var.equals("<")){
            CombSort(array, (n) -> array[n]>array[n+1]);
            System.out.println("отсортированный массив: " + Arrays.toString(array));
        }
        else if (var.equals(">")){
            CombSort(array, (n) -> array[n]<array[n+1]);
            System.out.println("отсортированный массив: " + Arrays.toString(array));
        }
        else{
            System.out.println("Ошибка");
        }
    }
    private static void CombSort(int[] array, Logik log) {
        double factor = 1.247;
        int step = array.length;
        while (step > 1){
            step = (int)(step/factor);
            System.out.println(step);
            System.out.println(Arrays.toString(array));
            for(int i = 0; step + i < array.length; i++){
                if (log.islogik(i)) {
                    swap(array, i, i + step);
                }
            }
        }
    }
    public static void swap(int[] array, int x, int y){
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }
}