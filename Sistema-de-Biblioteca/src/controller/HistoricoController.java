package controller;

import model.Cliente;
import model.Historico;
import service.ClienteService;
import service.HistoricoService;

import java.util.Scanner;

public class HistoricoController {
    Scanner sc = new Scanner(System.in);
    private final HistoricoService historicoService;
    private final ClienteService clienteService;

    public HistoricoController(HistoricoService historicoService, ClienteService clienteService){
        this.historicoService = historicoService;
        this.clienteService = clienteService;
    }

    public void listar_historico_cliente(){
        System.out.println("============================");
        System.out.print("Nome do cliente: ");
        String nome = sc.nextLine();
        Cliente cliente = clienteService.buscar_cliente_nome(nome);
        if(cliente == null){
            System.out.println("Cliente não cadastrado.\n");
            return;
        }
        int count = 0;
        for(Historico historico : historicoService.lista_historicos()){
            if(historico.getCliente().getNome().equals(nome)){
                historicoService.listar_historico_cliente(historico.getCliente());
                count++;
            }
        }
        if(count == 0){
            System.out.println("\nCliente sem historico de emprestimos.\n");
        }
        System.out.println("============================");
    }

}
