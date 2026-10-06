import Lab1.NotebookService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Меню программы
        cycle: while (true) {
            System.out.println("1. Заполнить массив");
            System.out.println("2. Распечатать");
            System.out.println("3. Выдать список абонентов, сгруппированный по месяцам их дней рождений");
            System.out.println("4. Найти людей, у которых день рождения в текущем месяце");
            System.out.println("5. Упорядочить массив по фамилиям по алфавиту");
            System.out.println("Выберете пункт меню (1..5)");
            int c = (new Scanner(System.in)).nextInt();
            switch (c) {
                case 1: NotebookService.fillNotebooks(); break;
                case 2: NotebookService.printNotebooks(); break;
                case 3: NotebookService.printGroupedByBirthMonth(); break;
                case 4: NotebookService.printCurrentMonthBirthdays(); break;
                case 5: NotebookService.sortBySurname(); break;
                default: break cycle;
            }
        }
    }
}
