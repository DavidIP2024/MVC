import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa un coche y permite observar cambios en la gasolina.
 */
public class Coche {
    private String matricula;
    private String modelo;
    private int velocidad;
    private double gasolina;
    private int posicion;

    private List<Observer> gasolinaObservers = new ArrayList<>();

    public Coche(String matricula, String modelo) {
        this.matricula = matricula;
        this.modelo = modelo;
        this.velocidad = 0;
        this.gasolina = 50.0;
        this.posicion = 0;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getModelo() {
        return modelo;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public double getGasolina() {
        return gasolina;
    }

    public void setGasolina(double gasolina) {
        this.gasolina = gasolina;
        if (this.gasolina < 10) {
            notifyGasolinaObservers("Repostar");
        }
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public void addGasolinaObserver(Observer o) {
        gasolinaObservers.add(o);
    }

    public void removeGasolinaObserver(Observer o) {
        gasolinaObservers.remove(o);
    }

    private void notifyGasolinaObservers(String mensaje) {
        for (Observer o : gasolinaObservers) {
            o.update(mensaje);
        }
    }

    @Override
    public String toString() {
        return "Coche{" +
                "matricula='" + matricula + '\'' +
                ", modelo='" + modelo + '\'' +
                ", velocidad=" + velocidad +
                ", gasolina=" + gasolina +
                ", posicion=" + posicion +
                '}';
    }
}


