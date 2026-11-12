package iterador;

public interface Colecao<T> {
    Iterador<T> criarIterador();

    Iterador<T> criarIteradorReverso();
}
