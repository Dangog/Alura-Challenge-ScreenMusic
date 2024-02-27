package com.alura.desafio.screenmusic.screenmusic.Principal;

import com.alura.desafio.screenmusic.screenmusic.Model.Artist;
import com.alura.desafio.screenmusic.screenmusic.Model.Style;
import com.alura.desafio.screenmusic.screenmusic.Repository.ArtistRepository;

import java.util.List;
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
    }

    private void listarMusicas() {
    }

    private void buscarMusicasPorArtista() {
    }
    private void pesquisarDadosDoArtista() {
    }

}
