package zadanie02;

import java.util.Optional;
import java.util.Scanner;

public class Runner2 {
    public static void main(String[] args) throws InvalidPeselException {
        Scanner sc = new Scanner(System.in);
        sc = processName(sc);
        processPesel(sc);

    }

    private static Scanner processName(Scanner sc) {
        System.out.println("Enter your name: ");
        String nameValue = sc.nextLine();
        Optional<String> name = Optional.ofNullable(nameValue);
        name.ifPresentOrElse(x -> {
            System.out.println("Length:  " + name.get().length());
        }, () -> System.out.println(0));

        return sc;
    }

    private static void processPesel(Scanner sc) throws InvalidPeselException {
        System.out.println("\n Enter your pesel: ");
        Optional<String> pesel = Optional.ofNullable(sc.nextLine());
        String peselStr;
        peselStr = validatePesel(pesel);
        reformatAndPrintPesel(peselStr);
        sc.close();
    }

    private static void reformatAndPrintPesel(String peselStr) {
        String birthDateStr = peselStr.substring(0, 6);
        System.out.println("Your birth date is: " + birthDateStr);
    }

    private static String validatePesel(Optional<String> pesel) throws InvalidPeselException {
        String peselStr;
        if (pesel.isPresent()) {
            peselStr = pesel.filter(x -> x != null && x.matches("\\d{11}"))
                    .orElseThrow(() -> new InvalidPeselException("Invalid Pesel!"));
        } else {
            throw new InvalidPeselException("Invalid Pesel!");
        }
        return peselStr;
    }
}
