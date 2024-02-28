package com.alura.desafio.screenmusic.screenmusic.Principal;

import com.alura.desafio.screenmusic.screenmusic.Model.Artist;
import com.alura.desafio.screenmusic.screenmusic.Model.Music;
import com.alura.desafio.screenmusic.screenmusic.Model.Style;
import com.alura.desafio.screenmusic.screenmusic.Repository.ArtistRepository;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Principal {
    
    Scanner leitura = new Scanner(System.in);

    private ArtistRepository artistRepository;

    public Principal(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    public void exibeMenu() {
        var opcao = -1;

        while (opcao!= 9) {
            var menu = """
                    *** Screen Sound Músicas ***                    
                                        
                    1- Cadastrar artistas
                    2- Cadastrar músicas
                    3- Listar músicas
                    4- Buscar músicas por artistas
                    5- Pesquisar dados sobre um artista
                                    
                    9 - Sair
                    """;

            System.out.println(menu);
            opcao = leitura.nextInt();
            leitura.nextLine();

            switch (opcao) {
                case 1 -> cadastrarArtistas();
                case 2 -> cadastrarMusicas();
                case 3 -> listarMusicas();
                case 4 -> buscarMusicasPorArtista();
                case 5 -> pesquisarDadosDoArtista();
                case 9 -> System.out.println("Encerrando a aplicação!");
                default -> System.out.println("Opção inválida!");
            }
        }
    }

    private void cadastrarArtistas() {
        String resp = "S";

        while (resp == "S") {

        System.out.println("Informe o nome do artista: ");
        var artistName = leitura.nextLine();

        System.out.println("Informe o tipo do artista (solo, dupla ou banda): ");
        var type = leitura.nextLine().toUpperCase();
        Style artistStyle = Style.valueOf(type);

        Artist artist = new Artist(artistName,artistStyle);
        System.out.println(artist);
        artistRepository.save(artist);

        System.out.println("Deseja cadastrar outro artista? (S/N): ");
        resp = leitura.nextLine().toUpperCase();
        }
    }
    private void cadastrarMusicas() {
        String resp = "S";

        while (resp == "S") {
            System.out.println("Informe o nome do artista compositor: ");
            var artistName = leitura.nextLine().toUpperCase();

            Optional<Artist> artist = artistRepository.findByNameContainingIgnoreCase(artistName);
            if (artist.isPresent()){
                System.out.println("Informe o nome da musica: ");
                var musicName = leitura.nextLine();

                System.out.println("Informe o nome do album: ");
                var albumName = leitura.nextLine();

                Music music = new Music(musicName,albumName);

                music.setArtist(artist.get());
                System.out.println(music);
                artist.get().getMusicList().add(music);
                artistRepository.save(artist.get());
            } else {
                System.out.println("Artista não encontrado!");
            }

            System.out.println("Deseja cadastrar outra musica? (S/N): ");
            resp = leitura.nextLine().toUpperCase();
        }
    }

    private void listarMusicas() {
        System.out.println("As músicas cadastradas no momento são: ");

        List<Artist> artistList = artistRepository.findAll();

        artistList.forEach(a -> a.getMusicList().forEach(System.out::println));
    }

    private void buscarMusicasPorArtista() {
        System.out.println("Digite o nome do artista para realizar a busca: ");
        var artistName = leitura.nextLine();

        List<Music> musicList = artistRepository.findMusicByArtist(artistName);
        musicList.forEach(System.out::println);
    }
    private void pesquisarDadosDoArtista() {
    }

}
