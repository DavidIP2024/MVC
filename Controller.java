public class Controller {
    private Model model = new Model();

    public void crearCoche(String matricula, String modelo) {
        model.crearCoche(matricula, modelo);
    }

    public void aumentarVelocidad(String matricula) {
        model.cambiarVelocidad(matricula, 10);
    }

    public void disminuirVelocidad(String matricula) {
        model.cambiarVelocidad(matricula, -10);
    }

    public int obtenerVelocidad(String matricula) {
        return model.getVelocidad(matricula);
    }

    public Coche getCoche(String matricula) {
        return model.getCoche(matricula);
    }

    public void mostrarTodosLosCoches() {
        for (Coche coche : model.getTodosLosCoches()) {
            System.out.println(coche);
        }
    }

    /**
     * Registra una alarma para un coche con matrícula dada.
     * @param matricula matrícula del coche
     */
    public void registrarAlarma(String matricula) {
        Coche coche = model.getCoche(matricula);
        if (coche != null) {
            coche.addGasolinaObserver(new AlarmaGasolina());
        }
    }
}
