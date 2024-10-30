public class ArmaCorta extends Arma {
    private boolean esAutomatica;

    public ArmaCorta(Policia policia, int cantidadMuniciones, double alcance, String marca, String calibre, String estado, boolean esAutomatica) {
        super(policia, cantidadMuniciones, alcance, marca, calibre, estado);
        this.esAutomatica = esAutomatica;
    }

    public boolean puedeDispararMasDe200m() {
        return alcance > 200;
    }

    @Override
    public String toString() {
        return super.toString() + "\nArmaCorta{" +
                "esAutomatica=" + esAutomatica +
                '}';
    }
}
