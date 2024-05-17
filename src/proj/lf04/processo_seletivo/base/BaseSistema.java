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

        // Salário pretendido: -> Em todos os casos tem verificação do valor.
        try{
            // Limpando console
            funcionalidade.limpar_console();

            // Pendindo o valor para o usuário:
            System.out.println("Qual o seu valor de salário pretendido?\nDigite abaixo:");
            salario_pretendido_candidato = scanf.nextDouble();

            // Fazendo verificação. Esta verificação está relacionada ao valor numérico informado.
            verificacao.verificar_salario_pretendido(salario_pretendido_candidato);
        }   
        catch(InputMismatchException exception){
            verificacao.verificar_salario_pretendido(salario_pretendido_candidato);
        }

        // Redirecionando o usuário com base no valor de salário que ele inseriu:
        redirecionar_com_base_na_pretencao_de_salario(salario_pretendido_candidato);

        // Fechando instância de 'Scanner':
        scanf.close();
        
    }

    // Método que recebe o valor de salário pretendido pelo o usuário e faz o redirecionamento com base nesse valor.
    public static void redirecionar_com_base_na_pretencao_de_salario(double salario_pretendido_candidato){

        // Intâncias nescessárias para funcionamento do método:
        FuncionalidadesDoSistema funcionalidade = new FuncionalidadesDoSistema();
        VerificacaoDados verificacao = new VerificacaoDados();
        Scanner scanf = new Scanner(System.in);

        // Pedindo que o usuario digite um novo valor, caso ele tenha pretendido um salário menor que 1000:
        while(salario_pretendido_candidato <= 1000){
            
            // Limpando terminal:
            funcionalidade.limpar_console();

            // Tentando pedir um novo valor:
            try{
                System.out.println("O valor salarial que você informou é muito baixo. Tente inserir um valor acima de R$1000\nInsira abaixo");
                salario_pretendido_candidato = scanf.nextDouble();

                // Verificando o valor que ele inseriu:
                verificacao.verificar_salario_pretendido(salario_pretendido_candidato);
            }
            catch(InputMismatchException exception){
                // Se gerar excessão, tento tratar também: 
                verificacao.verificar_salario_pretendido(salario_pretendido_candidato);
            }   

        }
    
        // Definindo o valor do salário base:
        double salario_base = 2000;

        // Criando variável que irá armazenar um número de telefone que irá se pedido para o usuário:
        int numero_de_telefone_do_usuario;

        // Fazendo o redirecionamento do usuário conforme o valor de salário que ele inseriu:
        if(salario_pretendido_candidato > salario_base){
            // Nesse caso, é informado para que o candidato aguarde um tempo, e depois é imprimido que ele não foi selecionado para a entrevista.
            System.out.println("Tudo certo " + nome_candidato +". Nos informe agora, o seu número para contato.\n*Somente valores com 11 dígitos são válidos *\nInsira abaixo:");
            
            // Tentando pegar o número de telefone:
            
            
            
        }

        // Fechando instância de 'scanner':
        scanf.close();

    }

}

// Classe que vai conter os métodos que irão ser usados para analisar os dados que o candidato inseriu:
class VerificacaoDados {   
    
    // Instâncias nescessárias para o funcionamento da classe:
    Scanner scanf = new Scanner(System.in);
    FuncionalidadesDoSistema funcionalidade = new FuncionalidadesDoSistema();
    
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
        /**
         * Este método recebe um valor do tipo inteiro e faz sua verificação tanto em relação a entrada numérica de dados,
         * quanto para casos em que o usuário digite um valor de outro tipo, como uma string, por exemplo.
         * @author @luisfl04_
         * @return Não retorna nenhum tipo de valor, apenas recebe o valor da idade por parâmetro e faz a sua verificação.
         */

        // Criado variável que irá validar o valor inserido pelo usuário de acordo com as condições.
        boolean entrada_validada = false;

        // Verificando se o valor informado pelo usuário é válido:
        if(verificar_idade_com_base_no_numero(idade_informada_pelo_usuario) == 1){
            entrada_validada = true;
        }
        
        // Informando erro para o usuário e pedindo um novo valor:
        while(entrada_validada == false){
            
            // Limpando console a cada entrada inválida:
            funcionalidade.limpar_console();
            
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
        
    // Método que verifica somente o valor numérico do salário pretendido pelo usuário:
    int verificar_salario_pretendido_com_base_no_numero(double salario_pretendido_candidato){
        if(salario_pretendido_candidato > 0){
            return 1;
        }
        else{
            return 0;
        }
    }

    // Método que verifica se o valor inserido pelo usuário é valido. Tanto para valores numéricos, quanto para valores que podem gerar a excessão 'InputMismatchException':
    void verificar_salario_pretendido(double salario_pretendido_candidato){

        // Variável que irá validar o valor informado pelo usuário.
        boolean entrada_validada = false;

        // Se o usuário digitou um valor numérico, esta condicional irá validar o valor:
        if(verificar_salario_pretendido_com_base_no_numero(salario_pretendido_candidato) == 1){
            entrada_validada = true;
        }

        // Loop que pede um novo valor para valores inválidos informados:
        while(entrada_validada == false){

            // Limpando console:
            funcionalidade.limpar_console();

            // Tentando pegar um novo valor e autorizar a entrada de dados:
            try{
                // Pedindo valor:
                System.out.println("\nO valor que você inseriu é inválido!\nInsira um valor novamente abaixo:");
                salario_pretendido_candidato = scanf.nextDouble();
                
                // Verificando novamente:
                if(verificar_salario_pretendido_com_base_no_numero(salario_pretendido_candidato) == 1){
                    entrada_validada = true;
                }
            }
            catch(InputMismatchException exception){
                // Limpando 'scanner'.
                scanf.next();
            }

        } 
    }

    // Método auxiliar de 'verificar_numero_de_telefone()' que verifica somente se o valor inserido pelo usuário for um valor numérico.
    int verificar_valor_numerico_do_telefone(int numero_de_telefone_do_usuario){
        // Tranformando o valor em uma string e contando os caracteres:
        String numero_de_telefone_do_usuario_em_string = Integer.toString(numero_de_telefone_do_usuario);
        int quantidade_de_caracteres_do_telefone = numero_de_telefone_do_usuario_em_string.length(); 

        // Fazendo a verificação:
        if(quantidade_de_caracteres_do_telefone == 11){
            return 1;
        }
        else{
            return 0;
        }
    }

    // Método que verifica o valor de telefone que o usuário inseriu:
    void verificar_numero_de_telefone(int numero_de_telefone_do_usuario){

        // Criando variável booleana de validação:
        boolean entrada_validada = false;

        // Verificando primeiramente o valor numérico inserido, se não for numérico, a execução não cai aqui.
        if(verificar_valor_numerico_do_telefone(numero_de_telefone_do_usuario) == 1){
            entrada_validada = true;
        }

        // Loop que pede um valor novo para o usuário sempre que ele digitar um valor inválido:
        while(entrada_validada == false){

            // Limpando console:
            funcionalidade.limpar_console(); 

            // Tentando pegar um valor novo:
            try{
                System.out.println("\nVocê digitou um valor de telefone inválido! Verifique as regras e insira novamente.\nDigite abaixo um novo valor:");
                numero_de_telefone_do_usuario = scanf.nextInt();

                // Verificando o valor inserido novamente:
                if(verificar_valor_numerico_do_telefone(numero_de_telefone_do_usuario) == 1){
                    entrada_validada = true;
                }
            }
            catch(InputMismatchException exception){
                // Se o usuário digitou um valor diferente do tipo numérico, é limpado o scanner e é pedido um novo valor:
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