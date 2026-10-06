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

    /** Временный доступ к массиву (нужен классу Notebook на время рефакторинга). */
    static Notebook[] getNotebooks() {
        return notebooks;
    }

    /** Временная запись массива (нужна классу Notebook на время рефакторинга). */
    static void setNotebooks(Notebook[] value) {
        notebooks = value;
    }

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
}
