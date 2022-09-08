import java.io.IOException;
import java.util.Scanner;

public class CadastroDeUsuario {
    private static String nomeDoUsuario;
    private static int idadeDoUsuario;
    private static char sexoDoUsuario;

    public static void CadastrarUsuario() {
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.print("Digite seu nome: ");
            nomeDoUsuario = scanner.nextLine();
        }while (nomeDoUsuario.length() < 2 || nomeDoUsuario.length() > 100);

        do{
            System.out.print("Digite sua idade: ");
            idadeDoUsuario = scanner.nextInt();
        }while (idadeDoUsuario < 1 || idadeDoUsuario > 130);

        do{
            System.out.print("Digite seu sexo (M ou F): ");
            try {
                sexoDoUsuario = (char) System.in. read();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }while (sexoDoUsuario != 'M' && sexoDoUsuario != 'F');
    }
}
