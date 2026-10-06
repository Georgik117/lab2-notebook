import Lab1.Notebook;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Меню программы
        cycle: while (true) {
            System.out.println("1. Заполнить массив");
            System.out.println("2. Распечатать");
            System.out.println("Выберете пункт меню (1..2)");
            int c = (new Scanner(System.in)).nextInt();
            switch (c) {
                case 1: Notebook.fillNotebooks(); break;
                case 2: Notebook.printNotebooks(); break;
                default: break cycle;
            }
        }
    }
}
