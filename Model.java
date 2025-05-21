import java.util.ArrayList;

public class Model {
    private ArrayList<Coche> parking = new ArrayList<>();

    public void crearCoche(String matricula, String modelo) {
        parking.add(new Coche(matricula, modelo));
    }

    public Coche getCoche(String matricula) {
        for (Coche coche : parking) {
            if (coche.getMatricula().equals(matricula)) {
                return coche;
            }
        }
        return null;
    }

    public void cambiarVelocidad(String matricula, int cambio) {
        Coche coche = getCoche(matricula);
        if (coche != null) {
            coche.setVelocidad(coche.getVelocidad() + cambio);
        }
    }

    public int getVelocidad(String matricula) {
        Coche coche = getCoche(matricula);
        return (coche != null) ? coche.getVelocidad() : -1;
    }

    public ArrayList<Coche> getTodosLosCoches() {
        return parking;
    }
}