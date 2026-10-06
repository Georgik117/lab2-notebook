package Lab1;

import java.time.LocalDate;
import java.util.Scanner;

/**
 * Абонент записной книжки.
 * Содержит ТОЛЬКО данные об одном человеке.
 */
public class Notebook {
    private String FIO;          // ФИО
    private String address;      // адрес
    private long number;         // номер телефона
    private String email;        // почта
    private LocalDate birthDate; // дата рождения


    public Notebook(String FIO, String address, long number, String email, LocalDate birthDate) {
        this.FIO = FIO;
        this.address = address;
        this.number = number;
        this.email = email;
        this.birthDate = birthDate;
    }

    public Notebook() {
        Scanner sc = new Scanner(System.in);
        System.out.print("ФИО : ");
        this.setFIO(sc.nextLine());
        System.out.print("\tАдресс : ");
        this.setAddress(sc.nextLine());
        System.out.print("\tНомер телефона : ");
        this.setNumber(sc.nextInt());
        sc.nextLine();
        System.out.print("\tПочта : ");
        this.setEmail(sc.nextLine());
        System.out.print("\tДень рождения : ");
        this.setBirthDate(LocalDate.parse(sc.nextLine()));
    }

    @Override
    public String toString() {
        return String.format("%-35s | Тел: %-12d | ДР: %s", FIO, number, birthDate);
    }

    public static void fillNotebooks() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите количество человек в записной книжке: ");
        int n = sc.nextInt();
        sc.nextLine();
        NotebookService.setNotebooks(new Notebook[n]);
        System.out.println("Введите информацию о людях: ");
        Notebook[] arr = NotebookService.getNotebooks();
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Человек " + (i + 1) + ":");
            arr[i] = new Notebook();
        }
    }

    /** Временная заглушка: работа перенесена в NotebookService. */
    public static void printNotebooks() {
        NotebookService.printNotebooks();
    }

    /** Временная заглушка: работа перенесена в NotebookService. */
    public static void printGroupedByBirthMonth() {
        NotebookService.printGroupedByBirthMonth();
    }

    /** Временная заглушка: работа перенесена в NotebookService. */
    public static void printCurrentMonthBirthdays() {
        NotebookService.printCurrentMonthBirthdays();
    }

    public static void sortBySurname() {
        Notebook[] arr = NotebookService.getNotebooks();
        System.out.println("\nМассив, упорядоченный по фамилиям (по алфавиту) ");
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                String surname1 = arr[j].FIO.trim().split("\\s+")[0];
                String surname2 = arr[j + 1].FIO.trim().split("\\s+")[0];
                if (surname1.compareToIgnoreCase(surname2) > 0) {
                    Notebook temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        for (Notebook n : arr) {
            System.out.println(n.toString());
        }
    }

    public String getFIO() {
        return this.FIO;
    }

    public void setFIO(String FIO) {
        if (FIO.isEmpty())
            System.out.println("Недопустимое значение !");
        else
            this.FIO = FIO;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        if (address.isEmpty())
            System.out.println("Недопустимое значение !");
        else
            this.address = address;
    }

    public long getNumber() {
        return this.number;
    }

    public void setNumber(long number) {
        if (number <= 0)
            System.out.println("Недопустимое значение !");
        else
            this.number = number;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        if (email.isEmpty())
            System.out.println("Недопустимое значение !");
        else
            this.email = email;
    }

    public LocalDate getBirthDate() {
        return this.birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}
