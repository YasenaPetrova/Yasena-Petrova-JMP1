package week1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class LinkedList1 {
    public static void main(String[] args) {
        // създаване на LinkedList
        LinkedList<String> list = new LinkedList<>();

        // добавяне на елементи
        list.add("Element1"); // в края
        list.addFirst("Element0"); // на първа позиция
        list.addLast("Element2"); // на последна позиция
        list.add(1, "Element1.5"); // на определена позиция

        // обхождане на всички елементи
        System.out.println("Обхождане:");
        for (String element : list) {
            System.out.println(element);
        }

        // обхождане от определена позиция
        System.out.println("\nОбхождане от позиция 2:");
        for (int i = 2; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        // обхождане в обратен ред
        System.out.println("\nОбратно обхождане:");
        for (int i = list.size() - 1; i >= 0; i--) {
            System.out.println(list.get(i));
        }

        // намиране на първо и последно срещане
        list.add("Element1");
        System.out.println("\nПърво срещане на 'Element1': " + list.indexOf("Element1"));
        System.out.println("Последно срещане на 'Element1': " + list.lastIndexOf("Element1"));

        // премахване на елемент
        list.remove("Element1.5");
        list.removeFirst(); // Премахва първия
        list.removeLast(); // Премахва последния

        // изпразване на списъка
        list.clear();

        // проверка дали списъкът е празен
        System.out.println("\nСписъкът е празен: " + list.isEmpty());

        // разбъркване, обединяване, копиране и други операции могат да бъдат добавени по сходен начин
        // пример: разбъркване
        list.add("A");
        list.add("B");
        list.add("C");
        Collections.shuffle(list);
        System.out.println("\nРазбъркан списък: " + list);

        // обединяване на два списъка
        LinkedList<String> newList = new LinkedList<>();
        newList.add("1");
        newList.add("2");
        list.addAll(newList);
        System.out.println("\nОбединен списък: " + list);

        // копиране на списък в друг списък
        LinkedList<String> copiedList = new LinkedList<>(list);
        System.out.println("Копиран списък: " + copiedList);

        // преобразуване на linked list в array list
        ArrayList<String> arrayList = new ArrayList<>(list);
        System.out.println("Преобразуван в ArrayList: " + arrayList);

        // сравнение на два списъка
        System.out.println("\nДва списъка са еднакви: " + list.equals(copiedList));
    }
}
