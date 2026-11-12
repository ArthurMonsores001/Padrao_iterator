package iterador;

public record Musica(String titulo, String artista) {
    @Override
    public String toString() {
        return artista + " - " + titulo;
    }
}
