public class Controller {
    private Model model = new Model();

    public void crearCoche(String matricula, String modelo) {
        model.crearCoche(matricula, modelo);
    }

    public void aumentarVelocidad(String matricula) {
        model.cambiarVelocidad(matricula, 10); // aumenta en 10
    }

    public void disminuirVelocidad(String matricula) {
        model.cambiarVelocidad(matricula, -10); // disminuye en 10
    }

    public int obtenerVelocidad(String matricula) {
        return model.getVelocidad(matricula);
    }

    public void mostrarTodosLosCoches() {
        for (Coche coche : model.getTodosLosCoches()) {
            System.out.println(coche);
        }
    }
}