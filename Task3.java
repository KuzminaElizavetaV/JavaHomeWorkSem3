import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/*Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее арифметичское этого списка.*/
public class Task3 {
    public static void main(String[] args) {
        int size = getNumberByUser("Введите размер списка: ");
        int start = getNumberByUser("Минимальное значение: ");
        int end = getNumberByUser("Максимальное значение: ");
        ArrayList<Integer> listNumber = fillNumListRandom(size, start, end);
        System.out.println("СПИСОК ЦЕЛЫХ ЧИСЕЛ: " + listNumber);
        findMaxNumList(listNumber);
        findMinNumList(listNumber);
        findAverageArithmeticMean(listNumber);

    }
    static int getNumberByUser(String text) { //Получение данных от пользователя
        System.out.print(text);
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }
    static ArrayList<Integer> fillNumListRandom(int size, int min, int max) { //Заполнение числового списка случаными числами,
        ArrayList<Integer> listNum = new ArrayList<>();                       //на основе полученных данных от пользователя
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            listNum.add(random.nextInt(min, max+1));
        }
        return listNum;
    }
    static void findMaxNumList(ArrayList<Integer> numList){ //нахождение максимального числа в списке
        int size = numList.size();
        int numMax = numList.get(0);
        for (int i = 1; i < size; i++) {
            if (numList.get(i) > numMax){
                numMax = numList.get(i);
            }
        }
        System.out.println("МАКСИМАЛЬНОЕ ЧИСЛО СПИСКА: " + numMax);
    }
    static void findMinNumList(ArrayList<Integer> numList){ //нахождение минимального числа в списке
        int size = numList.size();
        int numMin = numList.get(0);
        for (int i = 1; i < size; i++) {
            if (numList.get(i) < numMin){
                numMin = numList.get(i);
            }
        }
        System.out.println("МИНИМАЛЬНОЕ ЧИСЛО СПИСКА: " + numMin);
    }
    static void findAverageArithmeticMean(ArrayList<Integer> numList){ //нахождение среднего-арифметического списка
        int sumNumList = 0;
        for (Integer number : numList) {
            sumNumList = sumNumList + number;
        }
        double averageMean = (double)sumNumList/numList.size();
        System.out.printf("СРЕДНЕЕ-АРИФМЕТИЧКСКОЕ СПИСКА: " + "%.2f",averageMean);
    }
}
