package Lab1;

import java.time.LocalDate;
import java.util.Scanner;

/**
 * Сервис работы с коллекцией абонентов записной книжки.
 * Отвечает только за статический массив и операции над ним.
 */
public class NotebookService {
    private static Notebook[] notebooks = {
            new Notebook("Иванов Иван Иванович", "ул. Ленина д.1", 890011223, "ivanov@mail.com", LocalDate.of(2000, 5, 15)),
            new Notebook("Петров Петр Петрович", "ул. Мира д.2", 890044455, "petrov@mail.com", LocalDate.of(1995, 5, 20)),
            new Notebook("Сидоров Сидор Сидорович", "ул. Гагарина д.3", 890077788, "sidorov@mail.com", LocalDate.of(2007, 11, 11)),
            new Notebook("Алексеев Алексей Алексеевич", "ул. Пушкина д.4", 890012345, "alex@mail.com", LocalDate.of(1990, 9, 5)),
            new Notebook("Борисов Борис Борисович", "ул. Лермонтова д.5", 890098765, "boris@mail.com", LocalDate.of(2001, 1, 25))
    };

    public static void printNotebooks() {
        System.out.println("\nИнформация о людях:");
        for (int i = 0; i < notebooks.length; i++) {
            System.out.println(notebooks[i]);
        }
    }

    public static void printGroupedByBirthMonth() {
        System.out.println("Абоненты, сгруппированные по месяцам рождения ");
        for (int month = 1; month <= 12; month++) {
            boolean foundInThisMonth = false;
            for (Notebook n : notebooks) {
                if (n.getBirthDate().getMonthValue() == month) {
                    if (!foundInThisMonth) {
                        System.out.println("Месяц: " + month);
                        foundInThisMonth = true;
                    }
                    System.out.println("  - " + n.getFIO() + " (" + n.getBirthDate() + ")");
                }
            }
        }
    }

    public static void printCurrentMonthBirthdays() {
        System.out.println("\n Люди с днем рождения в текущем месяце");
        int currentMonth = LocalDate.now().getMonthValue();
        boolean found = false;
        for (Notebook n : notebooks) {
            if (n.getBirthDate().getMonthValue() == currentMonth) {
                System.out.println(n.toString());
                found = true;
            }
        }
        if (!found) {
            System.out.println("В текущем месяце (" + currentMonth + ") дней рождения нет.");
        }
    }

    public static void sortBySurname() {
        System.out.println("\nМассив, упорядоченный по фамилиям (по алфавиту) ");
        for (int i = 0; i < notebooks.length - 1; i++) {
            for (int j = 0; j < notebooks.length - 1 - i; j++) {
                String surname1 = notebooks[j].getFIO().trim().split("\\s+")[0];
                String surname2 = notebooks[j + 1].getFIO().trim().split("\\s+")[0];
                if (surname1.compareToIgnoreCase(surname2) > 0) {
                    Notebook temp = notebooks[j];
                    notebooks[j] = notebooks[j + 1];
                    notebooks[j + 1] = temp;
                }
            }
        }
        for (Notebook n : notebooks) {
            System.out.println(n.toString());
        }
    }

    // --- новый функционал, добавленный в ветке feature/find-by-fio ---

    public static Notebook findByFio(String fio) {
        System.out.println("Поиск абонента: " + fio);
        for (Notebook n : notebooks) {
            if (n.getFIO().equalsIgnoreCase(fio)) {
                System.out.println("  Найден: " + n);
                return n;
            }
        }
        System.out.println("  Абонент не найден");
        return null;
    }


    // --- новый функционал, добавленный в ветке feature/remove-by-fio ---

    public static boolean removeByFio(String fio) {
        for (int i = 0; i < notebooks.length; i++) {
            if (notebooks[i].getFIO().equalsIgnoreCase(fio)) {
                Notebook[] newNotebooks = new Notebook[notebooks.length - 1];
                for (int j = 0, k = 0; j < notebooks.length; j++) {
                    if (j != i)
                        newNotebooks[k++] = notebooks[j];
                }
                notebooks = newNotebooks;
                System.out.println("Абонент \"" + fio + "\" удалён");
                return true;
            }
        }
        System.out.println("Абонент \"" + fio + "\" не найден");
        return false;
    }

    // --- новый функционал, добавленный в ветке feature/count ---

    public static int count() {
        return notebooks.length;
    }
    public static void fillNotebooks() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите количество человек в записной книжке: ");
        int n = sc.nextInt();
        sc.nextLine();
        notebooks = new Notebook[n];
        System.out.println("Введите информацию о людях: ");
        for (int i = 0; i < notebooks.length; i++) {
            System.out.println("Человек " + (i + 1) + ":");
            notebooks[i] = new Notebook();
        }
    }
}
