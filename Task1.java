/*Реализовать алгоритм сортировки слиянием.*/

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        int size = getNumberByUser("Введите размер списка: ");
        int start = getNumberByUser("Минимальное значение: ");
        int end = getNumberByUser("Максимальное значение: ");
        System.out.println("ОТСОРТИРОВАННЫЙ СПИСОК: " + mergeSort(fillNumListRandom(size, start, end)));
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
        System.out.println("НАЧАЛЬНЫЙ СПИСОК:       " + listNum);
        return listNum;
    }
    static ArrayList<Integer> mergeList(ArrayList<Integer> left, ArrayList<Integer> right, ArrayList<Integer> merged){
        int leftCursor = 0;
        int rightCursor = 0;
        while ((leftCursor<left.size()) && (rightCursor <right.size())){
            if(left.get(leftCursor) <= right.get(rightCursor)){ //Сравнение левого с правым
                merged.set(leftCursor+rightCursor, left.get(leftCursor)); //отправка в сортированный список левого
                leftCursor++;
            }
            else {
                merged.set(leftCursor+rightCursor, right.get(rightCursor)); //отправка в сортированный список правого
                rightCursor++;
            }
        }
        for (int i = leftCursor; i < left.size(); i++) { //запись остатка сортированного списка в результирующий,
            merged.set(i+rightCursor, left.get(i));      //когда закончились элементы во втором подсписке
        }
        for (int i = rightCursor; i < right.size(); i++) {
            merged.set(leftCursor+i, right.get(i));
        }
        return merged;
    }
    static ArrayList<Integer> mergeSort(ArrayList<Integer> numList){
        if(numList.size()<2) return numList; // Последнее разделение массива - точка выхода из рекурсии
        ArrayList<Integer> left = mergeSort(new ArrayList<>(numList.subList(0, numList.size() / 2))); // Выполняем mergeSort рекурсивно с двух сторон
        ArrayList<Integer> right = mergeSort(new ArrayList<>(numList.subList(numList.size() / 2, numList.size())));
        return mergeList(left, right, numList); // Слияние левой и правой сторон
    }
}
