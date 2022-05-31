import java.util.*;

public class Main {

    public static void main(String[]args){
        Cliente Jonatas = new Cliente();
        Jonatas.setNome("Jonatas");


        Conta cc = new ContaCorrente(Jonatas);
        Conta poupanca = new ContaPoupanca(Jonatas);

        cc.imprimirExtrato();
        poupanca.imprimirExtrato();

    }
}
