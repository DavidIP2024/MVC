public class Avanzar {
    public void avanzar(Coche coche, int metros) {
        if (coche == null) {
            System.out.println("Coche no encontrado.");
            return;
        }

        int velocidad = coche.getVelocidad();
        double consumo = (metros / 1000.0) * (velocidad * 0.05);

        if (coche.getGasolina() < consumo) {
            System.out.println("No hay suficiente gasolina para avanzar " + metros + " metros.");
            return;
        }

        coche.setGasolina(coche.getGasolina() - consumo);
        coche.setPosicion(coche.getPosicion() + metros);

        System.out.println("Coche avanzó " + metros + " metros. Gasolina restante: " + coche.getGasolina());
    }
}

