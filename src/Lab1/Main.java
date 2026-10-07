import Lab1.NotebookService;

import java.util.Scanner;

/**
 * Точка входа: только меню и вызовы методов NotebookService.
 */
public class Main {
    /**
     * Единственный Scanner на весь ввод из консоли.
     * Создавать несколько Scanner на одном System.in нельзя: первый забирает
     * входной буфер целиком, и следующий Scanner не находит данных.
     */
    private static final Scanner IN = NotebookService.IN;

    public static void main(String[] args) {
        // Меню программы
        cycle: while (true) {
            System.out.println("1. Заполнить массив");
            System.out.println("2. Распечатать");
            System.out.println("3. Выдать список абонентов, сгруппированный по месяцам их дней рождений");
            System.out.println("4. Найти людей, у которых день рождения в текущем месяце");
            System.out.println("5. Упорядочить массив по фамилиям по алфавиту");
            System.out.println("6. Найти абонента по ФИО (без учёта регистра)");
            System.out.println("7. Удалить абонента по ФИО");
            System.out.println("8. Показать количество абонентов");
            System.out.println("9. Найти абонента по ФИО (точное совпадение)");
            System.out.println("10. ");
            System.out.println("Выберете пункт меню (1..10)");
            int c = IN.nextInt();
            IN.nextLine(); // сброс перевода строки после nextInt
            switch (c) {
                case 1: NotebookService.fillNotebooks(); break;
                case 2: NotebookService.printNotebooks(); break;
                case 3: NotebookService.printGroupedByBirthMonth(); break;
                case 4: NotebookService.printCurrentMonthBirthdays(); break;
                case 5: NotebookService.sortBySurname(); break;
                case 6: NotebookService.findByFio(readLine("Введите ФИО для поиска: ")); break;
                case 7: NotebookService.removeByFio(readLine("Введите ФИО для удаления: ")); break;
                case 8: System.out.println("Количество абонентов: " + NotebookService.count()); break;
                case 9: NotebookService.searchByFio(readLine("Введите ФИО для поиска: ")); break;
                default: break cycle;
            }
        }
    }

    private static String readLine(String prompt) {
        System.out.print(prompt);
        return IN.nextLine();
    }
}