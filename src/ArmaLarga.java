public class ArmaLarga extends Arma {
    private boolean tieneSelloRENAR;
    private String descripcionUso;
    private int nivel; // del 1 al 5

    public ArmaLarga(Policia policia, int cantidadMuniciones, double alcance, String marca, String calibre, String estado, boolean tieneSelloRENAR, String descripcionUso, int nivel) {
        super(policia, cantidadMuniciones, alcance, marca, calibre, estado);
        this.tieneSelloRENAR = tieneSelloRENAR;
        this.descripcionUso = descripcionUso;
        this.nivel = nivel;
    }

    public int comparar(ArmaLarga otraArma) {
        return Integer.compare(this.nivel, otraArma.nivel);
    }

    @Override
    public String toString() {
        return super.toString() + "\nArmaLarga{" +
                "tieneSelloRENAR=" + tieneSelloRENAR +
                ", descripcionUso='" + descripcionUso + '\'' +
                ", nivel=" + nivel +
                '}';
    }
}
