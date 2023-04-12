import java.util.Scanner;

public class CentigradosAFahrenheit {
    public static void main(String[] args) {
        double gradosC=0.0;
        double gradosF=0.0;

        System.out.println("Introduzca los grados Fahrenheit: ");
        
        try (Scanner scanner = new Scanner(System.in)) {
            gradosF = scanner.nextDouble();
        }

        gradosC = (5.0/9.0)*(gradosF-32);

        System.out.println(gradosF + " grados Fahrenheit equivalen a " + gradosC + " grados centígrados");
    }
}