import java.util.Scanner;

public class View {
    private Controller controller = new Controller();
    private Scanner scanner = new Scanner(System.in);
    private Avanzar avanzar = new Avanzar();
    private Gasolinera gasolinera = new Gasolinera();

    public void muestraVelocidad(String matricula, int velocidad) {
        System.out.println("Velocidad del coche con matrícula " + matricula + ": " + velocidad + " km/h");
    }

    public void menu() {
        int opcion;
        do {
            System.out.println("\n--- MENÚ ---");
            System.out.println("1. Crear coche");
            System.out.println("2. Aumentar velocidad");
            System.out.println("3. Disminuir velocidad");
            System.out.println("4. Mostrar todos los coches");
            System.out.println("5. Avanzar coche");
            System.out.println("6. Poner gasolina");
            System.out.println("7. Salir");
            System.out.print("Opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // limpia el buffer

            String matricula;
            switch (opcion) {
                case 1:
                    System.out.print("Introduce matrícula: ");
                    matricula = scanner.nextLine();
                    System.out.print("Introduce modelo: ");
                    String modelo = scanner.nextLine();
                    controller.crearCoche(matricula, modelo);
                    break;
                case 2:
                    System.out.print("Introduce matrícula: ");
                    matricula = scanner.nextLine();
                    controller.aumentarVelocidad(matricula);
                    muestraVelocidad(matricula, controller.obtenerVelocidad(matricula));
                    break;
                case 3:
                    System.out.print("Introduce matrícula: ");
                    matricula = scanner.nextLine();
                    controller.disminuirVelocidad(matricula);
                    muestraVelocidad(matricula, controller.obtenerVelocidad(matricula));
                    break;
                case 4:
                    controller.mostrarTodosLosCoches();
                    break;
                case 5:
                    System.out.print("Introduce matrícula: ");
                    matricula = scanner.nextLine();
                    System.out.print("¿Cuántos metros quieres avanzar?: ");
                    int metros = scanner.nextInt();
                    scanner.nextLine();
                    avanzar.avanzar(controller.getCoche(matricula), metros);
                    break;
                case 6:
                    System.out.print("Introduce matrícula: ");
                    matricula = scanner.nextLine();
                    System.out.print("¿Cuántos litros de gasolina quieres añadir?: ");
                    double litros = scanner.nextDouble();
                    scanner.nextLine();
                    gasolinera.ponerGasolina(controller.getCoche(matricula), litros);
                    break;
                case 7:
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 7);
    }
}
