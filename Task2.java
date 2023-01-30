/*Пусть дан произвольный список целых чисел. Удалить из него чётные числа.*/

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Task2 {

    public static void main(String[] args) {
        int size = getNumberByUser("Введите размер списка: ");
        int start = getNumberByUser("Минимальное значение: ");
        int end = getNumberByUser("Максимальное значение: ");
        removeEvenNumList(fillNumListRandom(size, start, end));
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
        System.out.println("НАЧАЛЬНЫЙ СПИСОК:     " + listNum);
        return listNum;
    }
    static void removeEvenNumList(ArrayList<Integer> numList){ //удаление четных чисел из списка
        numList.removeIf(integer -> integer % 2 == 0);
        System.out.println("УДАЛЕНЫ ЧЕТНЫЕ ЧИСЛА: " + numList);
    }
}

