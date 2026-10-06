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
            System.out.println("6. Найти абонента по ФИО (без учёта регистра)");
            System.out.println("7. Удалить абонента по ФИО");
            System.out.println("8. Показать количество абонентов");
            System.out.println("9. Найти абонента по ФИО (точное совпадение)");
            System.out.println("Выберете пункт меню (1..10)");
            int c = (new Scanner(System.in)).nextInt();
            switch (c) {
                case 1: NotebookService.fillNotebooks(); break;
                case 2: NotebookService.printNotebooks(); break;
                case 3: NotebookService.printGroupedByBirthMonth(); break;
                case 4: NotebookService.printCurrentMonthBirthdays(); break;
                case 5: NotebookService.sortBySurname(); break;
                case 6: readFio("Введите ФИО для поиска: ");
                      NotebookService.findByFio(fio); break;
                case 7: readFio("Введите ФИО для удаления: ");
                      NotebookService.removeByFio(fio); break;
                case 8: System.out.println("Количество абонентов: " + NotebookService.count()); break;
                case 9: readFio("Введите ФИО для поиска: ");
                      NotebookService.searchByFio(fio); break;
                default: break cycle;
            }
        }
    }

    private static String fio;

    private static void readFio(String prompt) {
        Scanner sc = new Scanner(System.in);
        System.out.print(prompt);
        fio = sc.nextLine();
    }
}
