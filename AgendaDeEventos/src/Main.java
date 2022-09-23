import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static List<CadastroDeUsuario.Usuario> usuarios = new ArrayList();

    public static void main (String[] args) {
        usuarios.add(CadastroDeUsuario.CadastrarUsuario());
        System.out.println(usuarios.get(0).nome);
    }
}
