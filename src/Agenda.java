import java.util.ArrayList;
import java.util.Scanner;

public class Agenda {
    ArrayList<Contato> listaContatos = new ArrayList<Contato>();
    Scanner scanner = new Scanner(System.in);

    public void exibirMenu() {
        int opcao;
        do {
            System.out.println("\n===== AGENDA TELEFÔNICA =====");
            System.out.println("1. Adicionar contato");
            System.out.println("2. Remover contato");
            System.out.println("3. Listar contatos");
            System.out.println("4. Buscar contato");
            System.out.println("0. Sair");
            System.out.print("\nEscolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    adicionarContato();
                    break;
                case 2:
                    removerContatoPorNome();
                    break;
                case 3:
                    listarContatos();
                    break;
                case 4:
                    buscarContatoPorNome();
                    break;
                case 0:
                    System.out.println("\nSaindo...");
                    break;
                default:
                    System.out.println("\nValor inserido é inválido!");
                    break;
            }
        } while (opcao != 0);
    }
    public void adicionarContato() {
        System.out.println("\nInsira o nome do contato");
        scanner.nextLine();
        String nome = scanner.nextLine().trim();

        System.out.println("Insira o número de telefone");
        String telefone = scanner.nextLine().trim();

        System.out.println("Insira o e-mail (opcional)");
        String email = scanner.nextLine();

        System.out.println("Insira uma tag (opcional)");
        String tag = scanner.nextLine();

        Contato contato = new Contato(nome, telefone, email, tag);


        if (nome.isEmpty() || telefone.isEmpty()) {
            System.err.println("Nome e Telefone são campos obrigatórios\n");
            adicionarContato();
        } else {
            listaContatos.add(contato);
            System.out.println("\nContato adicionado!\n");
        }


            System.out.println("\nO que deseja fazer?\n" +
                    "\n1. Adicionar um novo contato" +
                    "\n2. Voltar ao menu principal" +
                    "\n3. Sair do programa");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    adicionarContato();
                    break;
                case 2:
                    exibirMenu();
                    break;
                case 3:
                    System.out.println("Saindo...");
                    break;
            }


    }
    public void removerContatoPorNome() {
        System.out.println("Qual contato deseja remover?");
        scanner.nextLine();
        String nome = scanner.nextLine();

        for (int i = 0; i < listaContatos.size(); i++) {
            if (listaContatos.get(i).getNome().equals(nome)) {
                listaContatos.remove(i);
                i--; // Revisita a posição caso tenha outro contato com mesmo nome.
                System.out.printf("%s removido com sucesso!", nome);
                break;
            } else {
                System.err.printf("%s não foi encontrado!", nome);
                break;
            }
        }
    }

    public void listarContatos() {
        for (Contato contato : listaContatos) {
            System.out.println("\n" + contato);
        }
    }

    public void buscarContatoPorNome() {
        int qtdEncontrado = 0;
        System.out.println("Qual contato está buscando? ");
        scanner.nextLine();
        String nome = scanner.nextLine();

        boolean contatoEncontrado = false;
        for (int i = 0; i < listaContatos.size(); i++) {
            if (listaContatos.get(i).getNome().equals(nome)) {
                System.out.println(listaContatos.get(i));
                contatoEncontrado = true;
                qtdEncontrado++;
            }
        }
        System.out.printf("\nContatos encontrados: %d\n", qtdEncontrado);

        if (!contatoEncontrado) {
            System.out.printf("'%s' não foi encontrado(a)!", nome);
        }
    }
}

