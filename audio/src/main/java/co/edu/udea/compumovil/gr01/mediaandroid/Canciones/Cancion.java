package co.edu.udea.compumovil.gr01.mediaandroid.Canciones;

/**
 * Created by Manolo on 5/09/13.
 */
public class Cancion {
    private String titulo;
    private int id;
    public Cancion(){

    }
    public Cancion(String titulo, int id){
        this.titulo = titulo;
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
         return this.titulo;
    }
}
