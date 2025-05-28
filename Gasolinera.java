public class Gasolinera {
    public void ponerGasolina(Coche coche, double litros) {
        if (coche == null) {
            System.out.println("Coche no encontrado.");
            return;
        }

        coche.setGasolina(coche.getGasolina() + litros);
        System.out.println("Gasolina añadida. Total: " + coche.getGasolina() + " litros.");
    }
}
