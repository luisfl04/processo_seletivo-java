package proj.lf04.processo_seletivo.base;

// Importações nescessárias:
import java.util.Scanner;
import java.util.InputMismatchException;


// Classe onde os métodos que serão nescessários para o funcionamento do sistema serão implementados.
public class BaseSistema {
    
    // Atributos globais que irão receber valores e serem mostrados na interface do sistema:
    public static String nome_candidato;
    public static int idade_candidato;
    public static double salario_pretendido_candidato;

    // Método que vai pedir as informações gerais do candidato, como: nome, salário pretendido e etc. É o métodp introdutório do sistema.
    static void pegar_informacoes_candidato(){

        // Criando instância da classe 'VerificacaoDados' para chamar os métodos de verificação:
        VerificacaoDados verificacao = new VerificacaoDados();
        
        // Abrindo instância da classe 'Scanner':
        Scanner scanf = new Scanner(System.in);
        
        // Pedindo as informações pelo teclado:
        // Nome: -> (Não é nescessário fazer tratamento de erros em valores 'String', pois irá ser aceito qualquer tipo de valor).
        System.out.println("Olá candidato, primeiramente nos informe o seu nome.\n* Somente o primeiro nome *\n");
        nome_candidato = scanf.nextLine();

        // idade:
        try{
            System.out.println("Certo " + nome_candidato + ", nos informe a sua idade abaixo:");
            idade_candidato = scanf.nextInt();
            verificacao.verificar_idade(idade_candidato);
        }
        catch(InputMismatchException exception){
            System.out.println("\nERRO -> * O valor inserido é inválido *\nInsira novamente abaixo:");
            idade_candidato = scanf.nextInt();
        }
        // finally{  
        //     // Independentemente do fluxo, irei chamar este método. Para fins de tratamento em relação ao valor que o usuário inserir.
        //     verificacao.verificar_idade(idade_candidato);
        // }   



        // Fechando instância de 'Scanner':
        scanf.close();
        
    }



    // Método que compara e analisa o salário pretendido pelo canditado com relação ao salário base:
    static void analisar_salario_candidato(double salario_pretendido_candidato){
        
    } 

}

// Classe que vai conter os métodos que irão ser usados para analisar os dados que o candidato inseriu:
class VerificacaoDados {   
    
    // Criando instância de 'Scanner' globalmente para ser possível acessá-la de qualquer método.
    Scanner scanf = new Scanner(System.in);

    // Método que verifica se o valor que o candidato informou para a sua idade é inválido:
    void verificar_idade(int idade_informada_pelo_usuario){

        // Fazendo verificação e pedindo um valor válido:
        while(idade_informada_pelo_usuario < 1 || idade_informada_pelo_usuario > 100){
            // Informando erro e pedindo o valor novamente:
            System.out.println("\nO valor que você inseriu é inválido!\nDigite um valor válido abaixo:");
            idade_informada_pelo_usuario = scanf.nextInt();   
        }
    }   
}
