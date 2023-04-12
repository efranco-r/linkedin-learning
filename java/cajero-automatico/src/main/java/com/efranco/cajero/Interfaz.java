package main.java.com.efranco.cajero;
import java.util.Scanner;

public class Interfaz {
	public static void main(String[] args) {
		StringBuilder menuSB = new StringBuilder();
		menuSB.append("Elija una de las siguientes opciones\n");
		menuSB.append("	Escriba 1 para consultar su saldo\n");
		menuSB.append("	Escriba 2 para ingresar dinero\n");
		menuSB.append("	Escriba 3 para sacar dinero\n");
		menuSB.append("	Escriba 4 para consultar sus ultimos movimientos\n");
		menuSB.append("	Escriba 5 para consultar las condiciones legales\n");
		menuSB.append("	Para salir digite cualquier otro número\n");
		menuSB.append("Una vez escrita la opción, presione la tecla enter\n");

		try (Scanner scanner = new Scanner(System.in)) {
			int opcion;

			do {
				System.out.println("Por favor ingrese su usuario: ");
				String usuario = scanner.nextLine();
				System.out.println("Por favor ingrese su contraseña: ");
				String contrasena = scanner.nextLine();

				CajeroAutomatico cajeroAutomatico = new CajeroAutomatico(usuario, contrasena);

				System.out.println(menuSB);
				opcion = scanner.nextInt();

				switch (opcion) {
					case 1:
						//System.out.println(String.format("La opción que usted ha elegido es %d", opcion));
						cajeroAutomatico.mostrarSaldo();
						break;
					case 2:
						//System.out.println(String.format("La opción que usted ha elegido es %d", opcion));
						cajeroAutomatico.ingresarDinero();
						break;
					case 3:
						//System.out.println(String.format("La opción que usted ha elegido es %d", opcion));
						cajeroAutomatico.sacarDinero();
						break;
					case 4:
						//System.out.println(String.format("La opción que usted ha elegido es %d", opcion));
						cajeroAutomatico.consultarUltimoMovimientos();
						break;
					case 5:
						//System.out.println(String.format("La opción que usted ha elegido es %d", opcion));
						cajeroAutomatico.mostrarCondicionesLegales();;
						break;
					default:
						//System.out.println("Muchas gracias por utilizar nuestros servicios");
						cajeroAutomatico.salir();
				}
			} while (opcion == 1 || opcion == 2 || opcion == 3 || opcion == 4 || opcion == 5);
		}
	}
}
