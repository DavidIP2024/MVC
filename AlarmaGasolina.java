/**
 * Observador que lanza alerta cuando la gasolina baja de 10 litros.
 */
public class AlarmaGasolina implements Observer {
    @Override
    public void update(String mensaje) {
        System.out.println("Alerta: " + mensaje);
    }
}
