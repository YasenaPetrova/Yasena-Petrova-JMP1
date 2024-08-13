package week1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayList1 {
    public static void main(String[] args) {
        ArrayList<String> colors = new ArrayList<>();// добавяне на цветове
        colors.add("Red");
        colors.add("Green");
        colors.add("Blue");
        System.out.println(colors);

        for (String color : colors) //обхождане на всички елементи
        {
            System.out.println(color);
        }

        colors.add(0, "Yellow");//вмъкване на елемент на първа позиция

        String element = colors.get(2); // получаване на елемента на индекс 2
        System.out.println(element);

        colors.set(1, "Purple"); // заменя елемента на индекс 1 с "Purple"

        colors.remove(2); // премахва елемента на индекс 2 (третият елемент)

        if (colors.contains("Green")) // търсене на елемент
        {
            System.out.println("Found Green");
        } else {
            System.out.println("Green not found");
        }

        Collections.sort(colors);//сортиране

        ArrayList<String> copyOfColors = new ArrayList<>(colors);//копиране на един ArrayList в друг

        Collections.shuffle(colors);//разбъркване на елементите

        Collections.reverse(colors);//обръщане на елементите

        List<String> subList = colors.subList(1, 3); // извлича подсписък от индекс 1 до индекс 2 (без 3)

        ArrayList<String> anotherList = new ArrayList<>();//сравняване
// Добавяне на елементи в anotherList...
        boolean areEqual = colors.equals(anotherList);
        System.out.println("Are both lists equal? " + areEqual);

        Collections.swap(colors, 0, 1); // разменя елементите на индекси 0 и 1

        ArrayList<String> list1 = new ArrayList<>();// обединяване
        ArrayList<String> list2 = new ArrayList<>();
// Добавяне на елементи в list1 и list2...
        list1.addAll(list2);

        ArrayList<String> newList = new ArrayList<>(colors);// копиране на ArrayList в друг ArrayList



        boolean isEmpty = colors.isEmpty();//Проверка дали ArrayList е празен
        System.out.println("Is the list empty? " + isEmpty);

        colors.trimToSize(); // Тази операция не е видима в API на ArrayList в някои версии на Java. Вътрешно, тя може да се извършва автоматично.

        colors.ensureCapacity(100); // Увеличава капацитета на ArrayList, ако е необходимо, до 100

        colors.set(1, "Cyan"); // Заменя втория елемент (индекс 1) с "Cyan"

        for (int i = 0; i < colors.size(); i++) // Отпечатване на всички елементи използвайки позицията им

        {
            System.out.println("Element at index " + i + ": " + colors.get(i));
        }

        colors.clear();//изтриване

    }

}
