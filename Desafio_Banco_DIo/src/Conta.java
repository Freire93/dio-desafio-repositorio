import java.util.Scanner;

public abstract class Conta implements ContaInterface {

    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;


    public Conta(Cliente cliente) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
    }

    @Override
    public void sacar(double valor) {
       if (saldo > valor){
           saldo -= valor;
       }else{
           System.out.println("Saldo inferior ao valor desejado.");
       }


    }
    @Override
    public void depositar(double valor) {
        saldo += valor;
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        this.sacar(valor);
        contaDestino.depositar(valor);
    }

    public void doacao(double valor, Conta contaInstituicao) {
        int continuar;
        Scanner in = new Scanner(System.in);
        do {
            if (saldo > valor) {
                saldo -= valor;
                System.out.println("Deseja realizar outra transação ?(1 = Sim, 2 = Não");

            } else {
                System.out.println("Saldo inferior ao valor desejado.");
            }

            System.out.println("Deseja realizar outra transação ?(1 = Sim, 2 = Não");
            continuar = in.nextInt();
        } while (continuar != 2);
    }



    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    protected void imprimirInformacoesComuns() {

            int nota;

        System.out.println(String.format("Titular: %s ", this.cliente.getNome()));
        System.out.println(String.format("Agência: %d", this.agencia));
        System.out.println(String.format("Número: %d",  this.numero));
        System.out.println(String.format("Saldo: %.2f", this.saldo));

        Scanner in = new Scanner(System.in);
        System.out.println("Por favor, avalie nosso atendimento, a sua satisfação e importante.(1 a 10)");
        nota = in.nextInt();

        if (nota == 1 && nota < 7){
            System.out.println("Lamentamos muito, nos mande sua sugestao para melhorarmos.");
        }else if(nota > 8){
            System.out.println("Agradecemos muitos sua avaliacao, continuaremos a melhorar");
        }else{
            System.out.println("Nao e uma nota valida");
        }
        }



}
