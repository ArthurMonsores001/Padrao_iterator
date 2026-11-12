package iterador;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class PlaylistTest {

    private final Musica a = new Musica("A", "X");
    private final Musica b = new Musica("B", "Y");
    private final Musica c = new Musica("C", "Z");

    private Playlist playlist() {
        Playlist p = new Playlist();
        p.adicionar(a);
        p.adicionar(b);
        p.adicionar(c);
        return p;
    }

    @Test
    void percorreEmOrdem() {
        Iterador<Musica> it = playlist().criarIterador();
        assertEquals(a, it.proximo());
        assertEquals(b, it.proximo());
        assertEquals(c, it.proximo());
        assertFalse(it.temProximo());
    }

    @Test
    void percorreEmOrdemReversa() {
        Iterador<Musica> it = playlist().criarIteradorReverso();
        assertEquals(c, it.proximo());
        assertEquals(b, it.proximo());
        assertEquals(a, it.proximo());
        assertFalse(it.temProximo());
    }

    @Test
    void iteradoresSaoIndependentes() {
        Playlist p = playlist();
        Iterador<Musica> i1 = p.criarIterador();
        Iterador<Musica> i2 = p.criarIterador();
        i1.proximo();
        assertEquals(a, i2.proximo());
    }

    @Test
    void playlistVaziaNaoTemProximo() {
        Iterador<Musica> it = new Playlist().criarIteradorReverso();
        assertFalse(it.temProximo());
        assertThrows(NoSuchElementException.class, it::proximo);
    }
}
