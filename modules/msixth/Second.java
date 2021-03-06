/* 
(M6) Exercici 2
Aquest programa calcula l'edat mitjana d'un número de persones introduït per teclat.
S'ha de crear una funció que s'encarregui de demanar les edats a l'usuari i de calcular l'edat mitjana.
La funció rebrà per paràmetre el nº de persones a qui ha de demanar l'edat.
L'edat de les persones només serà vàlida si està compresa entre 0 i 120 anys.
La mitjana de les edats introduïdes s'ha de retornar per la funció (return).
*/

package modules.msixth;

import java.util.Scanner; // import the Scanner class 

public class Second {

    public static void main(String[] args) {
        Scanner myScan = new Scanner(System.in);
        Double ageAverage = 0.0;
        int arrayLength = 0;

        System.out.println("number of persons");
        arrayLength = myScan.nextInt();
        int[] ages = new int[arrayLength];

        ages = requestAges(ages, myScan);
        ageAverage = averageCalculator(ages);

        System.out.println("Average age is: " + ageAverage);
    }

    private static int[] requestAges(int[] ages, Scanner scanner) {
        for (int i = 0; (i < ages.length); i++) {
            System.out.println("age of person" + " " + (i + 1));
            ages[i] = responseValidator(scanner);
        }

        return ages;
    }

    private static Integer responseValidator(Scanner scanner) {
        Integer response = -1;
        Boolean askAgain = true;

        for (int i = 0; (i < 5) && askAgain; i++) {
            response = scanner.nextInt();

            if (response >= 0 && response <= 120) {
                askAgain = false;
                break;
            } else {
                System.out.println("Invalid response. Age must be between 0 - 120.");
            }
        }

        return response;
    }

    private static Double averageCalculator(int[] ages) {
        int sumArray = 0;

        for (int i = 0; i < ages.length; i++) {
            sumArray = (sumArray + ages[i]);
        }

        return (double) sumArray / ages.length;
    }
}
