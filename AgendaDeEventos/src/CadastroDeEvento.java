import javax.xml.crypto.Data;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class CadastroDeEvento {
    private static String nomeDoEvento;
    private static String descriçãoDoEvento;
    private static String endereçoDoEvento;
    private static Date dataDoEvento;
    private static Date horarioDoEvento;
    private enum Categoria{
        Festas,
        Esportes,
        Musica,
        Cultura,
    }
    private static Categoria categoriaDoEvento;

    public static class Evento {
        public String nome;
        public String descrição;
        public String endereço;
        public Date data;
        public Date horario;
        public Categoria categoria;

        public Evento (String nome, String descrição, String endereço, Date data, Date horario, Categoria categoria)
        {
            this.nome = nome;
            this.descrição = descrição;
            this.endereço = endereço;
            this.data = data;
            this.horario = horario;
            this.categoria = categoria;
        }
    }

    public static Evento CadastrarEvento() {
        Scanner scanner = new Scanner(System.in);

        do{
            System.out.print("Digite o nome do evento: ");
            nomeDoEvento = scanner.nextLine();
        }while (nomeDoEvento.length() < 1 || nomeDoEvento.length() > 100);

        do{
            System.out.print("Digite a descrição do evento: ");
            descriçãoDoEvento = scanner.nextLine();
        }while (descriçãoDoEvento.length() < 1 || descriçãoDoEvento.length() > 1000);

        do{
            System.out.print("Digite o endereço do evento: ");
            endereçoDoEvento = scanner.nextLine();
        }while (endereçoDoEvento.length() < 1 || endereçoDoEvento.length() > 500);

        String data = "";
        do{
            System.out.print("Digite a data do evento (00/00/0000): ");
            data = scanner.nextLine();
            SimpleDateFormat formatter = new SimpleDateFormat("dd/mm/yyyy");
            try {
                dataDoEvento = formatter.parse(data);
            } catch (ParseException e) {
                System.out.println("Data inválida!");
            }
        }while (data.length() != 10);

        String horario = "";
        do{
            System.out.print("Digite a hora do evento (00:00): ");
            horario = scanner.nextLine();
            SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
            try {
                horarioDoEvento = formatter.parse(horario);
            } catch (ParseException e) {
                System.out.println("Hora inválida!");
            }
        }while (horario.length() != 5);

        int categoria = 0;
        do{
            System.out.print("Digite a categoria do evento (1 = Festas, 2 = Esportes, 3 - Musica, 4 = Cultura): ");
            categoria = scanner.nextInt();
            switch (categoria)
            {
                case 1:
                    categoriaDoEvento = Categoria.Festas;
                    break;
                case 2:
                    categoriaDoEvento = Categoria.Esportes;
                    break;
                case 3:
                    categoriaDoEvento = Categoria.Musica;
                    break;
                case 4:
                    categoriaDoEvento = Categoria.Cultura;
                    break;
            }
        }while (categoria > 6 && categoria < 1);

        return new Evento(nomeDoEvento, descriçãoDoEvento, endereçoDoEvento, dataDoEvento, horarioDoEvento, categoriaDoEvento);
    }
}
