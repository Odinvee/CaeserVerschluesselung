import java.util.Scanner;

public class CaesarVerschluesselung {
    static String input, output = "";
    static int key = 0;
    static char operator = ' ';
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        menu();
        eingabe();
    }

    public static void menu() {
        System.out.println("Verschlüsseln: 'V' eingeben!");
        System.out.println("Entschlüsseln: 'E' eingeben!");
    }

    public static void eingabe() {
        operator = scanner.next().charAt(0);
        switch (operator) {
            case 'V':
                verschiebung();
                nachricht();
                verschluesseln();
                break;
            case 'E':
                verschiebung();
                nachricht();
                entschluesseln();
                break;
            default:
                System.out.println("Ungültige Eingabe!");
        }
    }

    public static void verschiebung() {
        System.out.println("Verschiebung 1-25 eingeben: ");
        key = scanner.nextInt();
        scanner.nextLine();
        if (key < 1 || key > 25) {
            System.out.println("Ungültige Zahl!");
        }
    }

    public static void nachricht() {
        System.out.println("Gib deine Nachricht ein: ");
        input = scanner.nextLine().toUpperCase();   //.toUpperCase FEHLER
    }

    public static void verschluesseln() {
        for (char c : input.toCharArray()) {
            if (Character.isAlphabetic(c)) {
                int newPosition = (c - 'A' + key) % 26;
                output += (char) ('A' + newPosition);
            } else {
                output += c;
            }
        }
        ausgabe();
    }

    public static void entschluesseln() {
        for (char c : input.toCharArray()) {
            if (Character.isAlphabetic(c)) {
                int newPosition = (c - 'A' - key + 26) % 26;
                output += (char) ('A' + newPosition);
            } else {
                output += c;
            }
        }
        ausgabe();
    }

    public static void ausgabe() {
        System.out.println("Deine verschlüsselte Nachricht ist: " + output);
    }
}