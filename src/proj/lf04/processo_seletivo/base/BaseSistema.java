package proj.lf04.processo_seletivo.base;

// Importações nescessárias:
import java.util.Scanner;
import java.util.InputMismatchException;
import java.lang.Thread;


// Classe onde os métodos que serão nescessários para o funcionamento do sistema serão implementados.
public class BaseSistema {

    // Intâncias nescessárias para o funcionamento da classe(Foram criadas como 'static' para que fosse possível chamá-las de qualquer lugar da classe):
    static Scanner scanf = new Scanner(System.in);
    static VerificacaoDados verificacao = new VerificacaoDados();
    static FuncionalidadesDoSistema funcionalidade = new FuncionalidadesDoSistema();
    
    // Atributos globais que irão receber valores e serem mostrados na interface do sistema:
    public static String nome_candidato;
    public static int idade_candidato;
    public static double salario_pretendido_candidato;
    public static long numero_de_telefone_do_usuario;
    public static double salario_base = 2000;  

    // Método que vai pedir as informações gerais do candidato, como: nome, salário pretendido e etc. É o métodp introdutório do sistema.
    public static void pegar_informacoes_candidato(){
        // Pedindo as informações pelo teclado:
        // Nome: -> (Não é nescessário fazer tratamento de erros em valores 'String', pois irá ser aceito qualquer tipo de valor).
        System.out.println("Olá candidato, primeiramente nos informe o seu nome.\n* Somente o primeiro nome *\n");
        nome_candidato = scanf.nextLine();
        
        // Limpando console:
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
        
    }

    // Método que recebe o valor de salário pretendido pelo o usuário e faz o redirecionamento com base nesse valor.
    public static void redirecionar_com_base_na_pretencao_de_salario(double salario_pretendido_candidato){

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
    
        // Fazendo o redirecionamento do usuário conforme o valor de salário que ele inseriu:
        // Este fluxo diz respeito a quando o usuário quer um salário maior que o salário base implementado.
        if(salario_pretendido_candidato > salario_base){

            // Chamando método que tenta pegar o numero de telefone:
            funcionalidade.pegar_telefone_do_candidato();
            
            // Ao pegar o numero, informo os seus dados na tela e peço que aguarde um momento:
            // Chamando método que printa as informações:
            funcionalidade.printar_informacoes_candidato();
            
            // Limpando console e informando que o candidato não conseguiu a vaga:
            funcionalidade.limpar_console();
            System.out.println("\n" + nome_candidato + ", Iremos entrar em contato com você, fique atento ao seu telefone!\nObrigado por se candidatar.");
        }
        // Fluxo que é execultado quando o candidato quer um valor de salário igual ao do salário base.
        else if(salario_pretendido_candidato == salario_base){

            // pedindo o numero de telefone:
            funcionalidade.pegar_telefone_do_candidato();

            // Printando suas informações:
            funcionalidade.printar_informacoes_candidato();
            
            // Chamando método que pergunta ao usuário se ele quer aceitar uma contraproposta feita pela empresa:
            funcionalidade.oferecer_contra_proposta();
        }

    }
}

// Classe que vai conter os métodos que irão ser usados para analisar os dados que o candidato inseriu:
class VerificacaoDados {   
    
    // Método que verifica o valor numérico da idade informada. Usado para fins de validação.
    boolean verificar_idade_com_base_no_numero(int idade_informada_pelo_usuario){
        // Verificando:
        if(idade_informada_pelo_usuario > 0 && idade_informada_pelo_usuario <= 100){
            return true;
        }
        else{
            return false;
        }
    }

    // Método que verifica se o valor que o candidato informou para a sua idade é inválido:
    void verificar_idade(int idade_informada_pelo_usuario){

        // Criado variável que irá validar o valor inserido pelo usuário de acordo com as condições.
        boolean entrada_validada = false;

        // Verificando se o valor informado pelo usuário é válido:
        if(verificar_idade_com_base_no_numero(idade_informada_pelo_usuario) == true){
            entrada_validada = true;
        }
        
        // Informando erro para o usuário e pedindo um novo valor:
        while(entrada_validada == false){
            
            // Limpando console a cada entrada inválida:
            BaseSistema.funcionalidade.limpar_console();
            
            // Informando erro e tentando pedir o valor novamente:
            try{
                System.out.println("\nO valor inserido é invalido!!!!\nInsira um valor válido abaixo:");
                idade_informada_pelo_usuario = BaseSistema.scanf.nextInt();

                // Verificando valor novamente:
                if(verificar_idade_com_base_no_numero(idade_informada_pelo_usuario) == true){
                    entrada_validada = true;
                }
            }
            catch(InputMismatchException exception){
                // limpando o 'scanner' para pedir o valor novamente em 'try':
                BaseSistema.scanf.next();   
            }
            
        } 
    }   
        
    // Método que verifica somente o valor numérico do salário pretendido pelo usuário:
    boolean verificar_salario_pretendido_com_base_no_numero(double salario_pretendido_candidato){
        if(salario_pretendido_candidato > 0){
            return true;
        }
        else{
            return false;
        }
    }

    // Método que verifica se o valor inserido pelo usuário é valido. Tanto para valores numéricos, quanto para valores que podem gerar a excessão 'InputMismatchException':
    void verificar_salario_pretendido(double salario_pretendido_candidato){

        // Variável que irá validar o valor informado pelo usuário.
        boolean entrada_validada = false;

        // Se o usuário digitou um valor numérico, esta condicional irá validar o valor:
        if(verificar_salario_pretendido_com_base_no_numero(salario_pretendido_candidato) == true){
            entrada_validada = true;
        }

        // Loop que pede um novo valor para valores inválidos informados:
        while(entrada_validada == false){

            // Limpando console:
            BaseSistema.funcionalidade.limpar_console();

            // Tentando pegar um novo valor e autorizar a entrada de dados:
            try{
                // Pedindo valor:
                System.out.println("\nO valor que você inseriu é inválido!\nInsira um valor novamente abaixo:");
                salario_pretendido_candidato = BaseSistema.scanf.nextDouble();
                
                // Verificando novamente:
                if(verificar_salario_pretendido_com_base_no_numero(salario_pretendido_candidato) == true){
                    entrada_validada = true;
                }
            }
            catch(InputMismatchException exception){
                // Limpando 'scanner'.
                BaseSistema.scanf.next();
            }

        } 
    }

    // Método auxiliar de 'verificar_numero_de_telefone()' que verifica somente se o valor inserido pelo usuário for um valor numérico.
    boolean verificar_valor_numerico_do_telefone(long numero_de_telefone_do_usuario){
        // Tranformando o valor em uma string e contando os caracteres:
        String numero_de_telefone_do_usuario_em_string = Long.toString(numero_de_telefone_do_usuario);
        int quantidade_de_caracteres_do_telefone = numero_de_telefone_do_usuario_em_string.length(); 

        // Fazendo a verificação:
        if(quantidade_de_caracteres_do_telefone == 11){
            return true;
        }
        else{
            return false;
        }
    }

    // Método que verifica o valor de telefone que o usuário inseriu:
    void verificar_numero_de_telefone(long numero_de_telefone_do_usuario){

        // Criando variável booleana de validação:
        boolean entrada_validada = false;

        // Verificando primeiramente o valor numérico inserido, se não for numérico, a execução não cai aqui.
        if(verificar_valor_numerico_do_telefone(numero_de_telefone_do_usuario) == true){
            entrada_validada = true;
        }

        // Loop que pede um valor novo para o usuário sempre que ele digitar um valor inválido:
        while(entrada_validada == false){

            // Limpando console:
            BaseSistema.funcionalidade.limpar_console(); 

            // Tentando pegar um valor novo:
            try{
                System.out.println("\nVocê digitou um valor de telefone inválido! Verifique as regras e insira novamente.\nDigite abaixo um novo valor:");
                numero_de_telefone_do_usuario = BaseSistema.scanf.nextLong();

                // Verificando o valor inserido novamente:
                if(verificar_valor_numerico_do_telefone(numero_de_telefone_do_usuario) == true){
                    entrada_validada = true;
                }
            }
            catch(InputMismatchException exception){
                // Se o usuário digitou um valor diferente do tipo numérico, é limpado o scanner e é pedido um novo valor:
                BaseSistema.scanf.next();
            }
        
        }
    }   

    // Método auxiliar que somente faz a verificação do valor que o usuário inseriu em relação a sua escolha de contraproposta:
    boolean verificar_valor_do_caractere_da_escolha_do_usuario(String escolha_do_usuario){
        
        // Variável de validação da condicional:
        boolean entrada_validada = false;

        // Fazendo verificação do parâmetro:
        if((escolha_do_usuario.length() == 1 && escolha_do_usuario == "1") || 
        (escolha_do_usuario.length() == 1 && escolha_do_usuario == "2")){
            entrada_validada = true;
        }

        // Retornando valor:
        return entrada_validada;
    }


    // Método que recebe a string que o usuário inseriu como escolha para a contraproposta no método 'oferecer_contra_proposta()'. 
    void verificar_caractere_da_escolha_do_usuario(String escolha_do_usuario){
        
        // Variável de validação:
        boolean entrada_validada = false;

        // Fazendo verificação do valor:
        if(verificar_valor_do_caractere_da_escolha_do_usuario(escolha_do_usuario) == true){
            entrada_validada = true;
        }

        // Se a condição não for validada, peço um novo valor até que seja validado:
        while (entrada_validada == false){

            // Limpando console a cada iteração:
            BaseSistema.funcionalidade.limpar_console();

            // Informando erro e pedindo um novo valor:
            System.out.println("\nVocê digitou um valor de escolha inválido!\nAs escolhas são:\n(1) = Para aceitar\n(2) - Para recusar\nInsira sua escolha abaixo:");
            escolha_do_usuario = BaseSistema.scanf.next();
            
            // Verificando novamente:
            if(verificar_valor_do_caractere_da_escolha_do_usuario(escolha_do_usuario) == true){
                entrada_validada = true;
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

    // Método que printa as infos relacionadas ao candidato:
    void printar_informacoes_candidato(){
         /**
          * Funcionalidade do método -> Basicamente, informo os dados do usuário e peço que ele tecle enter usando o método 'nextLine()' da classe 'Scanner'.
          Com isso, após o usuário clicar, a informação sobre sua candidatura no processo seletivo é informada. 
          */   

        // Printando infos e pedindo que tecle 'enter':
        System.out.println("\n* SUAS INFORMAÇÔES *\n\nNome -> " + BaseSistema.nome_candidato + "\nIdade -> " + BaseSistema.idade_candidato + " anos\nSalario pretendido -> R$" + BaseSistema.salario_pretendido_candidato + "\nNumero de telefone -> " + BaseSistema.numero_de_telefone_do_usuario + "\n\nTecle ENTER para receber o seu resultado...");
        BaseSistema.scanf.nextLine();
    }

    // Método que obtém o telefone do candidato, para fins de reutilização do código:
    void pegar_telefone_do_candidato(){
        
        // Limpando terminal:
        limpar_console();

        // Texto descritivo:
        System.out.println("\nTudo certo " + BaseSistema.nome_candidato + ". Nos informe agora, o seu número para contato.\n*Somente valores com 11 dígitos são válidos *\nInsira abaixo:");

        // Tentando pegar o número de telefone:
        try{
            BaseSistema.numero_de_telefone_do_usuario = BaseSistema.scanf.nextLong();
            // Fazendo verificação:
            BaseSistema.verificacao.verificar_numero_de_telefone(BaseSistema.numero_de_telefone_do_usuario); 
        }    
        catch(InputMismatchException exception){
            // Se gerar excessão, chamo a verificação também:
            BaseSistema.verificacao.verificar_numero_de_telefone(BaseSistema.numero_de_telefone_do_usuario);
        }           
        
    }

    void oferecer_contra_proposta(){
        // Limpando terminal:
        limpar_console();

        // Oferecendo contraproposta e dando poder de escolha para o usuário:
        System.out.println("\nInfelizmente não podemos pagar o salário que você está pedindo. Mas temos uma proposta para você!\n\nAceita o salário de R$1900?\n(1) - Para aceitar\n(2) - Para recusar\nDigite sua escolha abaixo:");
        String escolha_do_usuario = BaseSistema.scanf.next();
        
        // Fazendo verificação do valor que o usuário inseriu:
        BaseSistema.verificacao.verificar_caractere_da_escolha_do_usuario(escolha_do_usuario);

    }

}