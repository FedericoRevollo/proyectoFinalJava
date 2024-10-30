public abstract class Arma {
    protected Policia policia;
    protected int cantidadMuniciones;
    protected double alcance;
    protected String marca;
    protected String calibre;
    protected String estado;

    public Arma(Policia policia, int cantidadMuniciones, double alcance, String marca, String calibre, String estado) {
        this.policia = policia;
        this.cantidadMuniciones = cantidadMuniciones;
        this.alcance = alcance;
        this.marca = marca;
        this.calibre = calibre;
        this.estado = estado;
    }

    public boolean estaEnCondiciones() {
        return estado.equals("EN USO") && Integer.parseInt(calibre) >= 9;
    }

    @Override
    public String toString() {
        return "\nArma{" +
                "\npolicia=" + policia +
                ", \ncantidadMuniciones=" + cantidadMuniciones +
                ", \nalcance=" + alcance +
                ", \nmarca='" + marca + '\'' +
                ", \ncalibre='" + calibre + '\'' +
                ", \nestado='" + estado + '\'' +
                '}';
    }
}
