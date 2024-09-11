
package dominio;

import java.io.Serializable;
import java.util.Objects;

public class Snack implements Serializable{
    
    private static int contadorSnack;
    private int idSnack;
    private String nombre;
    private double precio;
    
    public Snack(){
        this.idSnack = ++Snack.contadorSnack;
    }
    
    public Snack(String nombre, double precio){
        this();
        this.nombre = nombre;
        this.precio = precio;
    }

    public static int getContadorSnack() {
        return contadorSnack;
    }

    public int getIdSnack() {
        return idSnack;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Snack{" + "idSnack=" + idSnack + ", nombre=" + nombre + ", precio=" + precio + '}';
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Snack other = (Snack) obj;
        if (this.idSnack != other.idSnack) {
            return false;
        }
        if (Double.doubleToLongBits(this.precio) != Double.doubleToLongBits(other.precio)) {
            return false;
        }
        return Objects.equals(this.nombre, other.nombre);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.idSnack;
        hash = 37 * hash + Objects.hashCode(this.nombre);
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.precio) ^ (Double.doubleToLongBits(this.precio) >>> 32));
        return hash;
    }

}
