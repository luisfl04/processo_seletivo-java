package proj.lf04.processo_seletivo.base;

// Importações nescessárias:
import java.util.Scanner;
import java.util.InputMismatchException;
import java.lang.Thread;


// Classe onde os métodos que serão nescessários para o funcionamento do sistema serão implementados.
public class BaseSistema {

    // Atributos globais que irão receber valores e serem mostrados na interface do sistema:
    public static String nome_candidato;
    public static int idade_candidato;
    public static double salario_pretendido_candidato;

    // Método que vai pedir as informações gerais do candidato, como: nome, salário pretendido e etc. É o métodp introdutório do sistema.
    public static void pegar_informacoes_candidato(){
        
        // Intâncias nescessárias para o funcionamento:
        Scanner scanf = new Scanner(System.in);
        VerificacaoDados verificacao = new VerificacaoDados();
        FuncionalidadesDoSistema funcionalidade = new FuncionalidadesDoSistema();
        
        // Pedindo as informações pelo teclado:
        // Nome: -> (Não é nescessário fazer tratamento de erros em valores 'String', pois irá ser aceito qualquer tipo de valor).
        System.out.println("Olá candidato, primeiramente nos informe o seu nome.\n* Somente o primeiro nome *\n");
        nome_candidato = scanf.nextLine();
        funcionalidade.limpar_console();

        // idade: -> Em todos os casos eu faço a verificação do valor. Tanto para valores numéricos inválidos, quanto para valores que não são do tipo inteiro.
        try{
            System.out.println("\nCerto " + nome_candidato + ", nos informe a sua idade abaixo:");
            idade_candidato = scanf.nextInt();
            verificacao.verificar_idade(idade_candidato);
        }
        catch(InputMismatchException exception){
            verificacao.verificar_idade(idade_candidato);
        }

        


        // Fechando instância de 'Scanner':
        scanf.close();
        
    }
    
    // Método que compara e analisa o salário pretendido pelo canditado com relação ao salário base:
    public static void analisar_salario_candidato(double salario_pretendido_candidato){
        
    } 
    

}

// Classe que vai conter os métodos que irão ser usados para analisar os dados que o candidato inseriu:
class VerificacaoDados {   
    
    // Instâncias nescessárias para o funcionamento da classe:
    Scanner scanf = new Scanner(System.in);
    FuncionalidadesDoSistema funcionalidades = new FuncionalidadesDoSistema();
    
    // Método que verifica o valor numérico da idade informada. Usado para fins de validação.
    int verificar_idade_com_base_no_numero(int idade_informada_pelo_usuario){
        // Verificando:
        if(idade_informada_pelo_usuario > 0 && idade_informada_pelo_usuario <= 100){
            return 1;
        }
        else{
            return 0;
        }
    }

    // Método que verifica se o valor que o candidato informou para a sua idade é inválido:
    void verificar_idade(int idade_informada_pelo_usuario){
        
        // Criado variável que irá validar o valor inserido pelo usuário de acordo com as condições.
        boolean entrada_validada = false;

        // Verificando se o valor informado pelo usuário é válido:
        if(verificar_idade_com_base_no_numero(idade_informada_pelo_usuario) == 1){
            entrada_validada = true;
        }
        
        // Informando erro para o usuário e pedindo um novo valor:
        while(entrada_validada == false){
            
            // Limpando console a cada entrada inválida:
            funcionalidades.limpar_console();

            // Informando erro e tentando pedir o valor novamente:
            try{
                System.out.println("\nO valor inserido é invalido!!!!\nInsira um valor válido abaixo:");
                idade_informada_pelo_usuario = scanf.nextInt();

                // Verificando valor novamente:
                if(verificar_idade_com_base_no_numero(idade_informada_pelo_usuario) == 1){
                    entrada_validada = true;
                }
            }
            catch(InputMismatchException exception){
                // limpando o 'scanner' para pedir o valor novamente em 'try':
                scanf.next();   
            }

        } 
    }   

    // Método que verifica o valor informado pelo usuário em relação ao seu salário pretendido:
    void verificar_salario_pretendido(double salario_pretendido_candidato){

        // Variável de validação:
        boolean entrada_validada = false;

        while(entrada_validada == false || salario_pretendido_candidato <= 0){

            // Limpando console:
            funcionalidades.limpar_console();

            // Pedindo valor enquanto for inválido:
            try{
                System.out.println("\nO valor inserido é invalido!\nInsira um valor válido abaixo:");
                salario_pretendido_candidato = scanf.nextDouble();
                entrada_validada = true;
            }
            catch(InputMismatchException exception){
                // Limpando scanner:
                scanf.next();
            }

        }
    }


}

class FuncionalidadesDoSistema{

    // Função que limpa o terminal:
    void limpar_console(){
        try{
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    // função que pausa a execução em 2 segundos:
    void pausar_dois_segundos(){
        try{
            Thread.sleep(2000);
        }
        catch(InterruptedException exception){
            exception.getMessage();
        }
    }



}