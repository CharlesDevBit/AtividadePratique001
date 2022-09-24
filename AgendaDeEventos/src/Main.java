import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static List<CadastroDeUsuario.Usuario> usuarios = new ArrayList();
    public static List<CadastroDeEvento.Evento> eventos = new ArrayList();

    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Digite U para cadastrar um usuario.");
            System.out.println("Digite E para cadastrar um evento.");
            System.out.println("Digite V para visualizar os eventos cadastrados.");
            System.out.println("Digite S para sair.");

            char escolha = scanner.nextLine().charAt(0);

            switch (escolha)
            {
                case 'U':
                    usuarios.add(CadastroDeUsuario.CadastrarUsuario());
                    System.out.println("Usuario Cadastrado.");
                    break;
                case 'E':
                    eventos.add(CadastroDeEvento.CadastrarEvento());
                    System.out.println("Evento Cadastrado.");
                    break;
                case 'V':
                    for (CadastroDeEvento.Evento evento: eventos) {
                        System.out.println(evento.nome);
                        System.out.println(evento.descrição);
                        System.out.println(evento.endereço);
                        System.out.println(evento.data);
                        System.out.println(evento.horario);
                        System.out.println(evento.categoria);
                    }
            }
        }
        while (scanner.nextLine().charAt(0) != 'S');
    }
}
