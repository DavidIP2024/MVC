public class Coche {
    private String matricula;
    private String modelo;
    private int velocidad;

    public Coche(String matricula, String modelo) {
        this.matricula = matricula;
        this.modelo = modelo;
        this.velocidad = 0;
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

    @Override
    public String toString() {
        return "Coche{" +
                "matricula='" + matricula + '\'' +
                ", modelo='" + modelo + '\'' +
                ", velocidad=" + velocidad +
                '}';
    }
}