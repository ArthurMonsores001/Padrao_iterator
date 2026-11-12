package iterador;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Playlist implements Colecao<Musica> {

    private final List<Musica> musicas = new ArrayList<>();

    public void adicionar(Musica musica) {
        musicas.add(musica);
    }

    @Override
    public Iterador<Musica> criarIterador() {
        return new IteradorPlaylist(false);
    }

    @Override
    public Iterador<Musica> criarIteradorReverso() {
        return new IteradorPlaylist(true);
    }

    private class IteradorPlaylist implements Iterador<Musica> {
        private final boolean reverso;
        private int posicao;

        IteradorPlaylist(boolean reverso) {
            this.reverso = reverso;
            this.posicao = reverso ? musicas.size() - 1 : 0;
        }

        @Override
        public boolean temProximo() {
            return posicao >= 0 && posicao < musicas.size();
        }

        @Override
        public Musica proximo() {
            if (!temProximo()) {
                throw new NoSuchElementException("Fim da playlist");
            }
            Musica m = musicas.get(posicao);
            posicao += reverso ? -1 : 1;
            return m;
        }
    }
}
