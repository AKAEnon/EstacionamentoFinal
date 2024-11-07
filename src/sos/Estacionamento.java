package sos;

import java.util.List;
import java.util.ArrayList;

public class Estacionamento {
    public List<Vagas> listaVagas;
    public List<Veiculo> historicoVeiculos;  

    public Estacionamento(List<Vagas> listaVagas) {
        this.listaVagas = listaVagas;
        this.historicoVeiculos = new ArrayList<>();  
    }
    
    public void registrarEntradaVeiculo(Veiculo veiculo) {
        for (Vagas vaga : listaVagas) {
            if (vaga.isDisponivel() && vaga.getTamanho().equals(veiculo.getTamanho())) {
                vaga.setVeiculoAtual(veiculo);
                vaga.setDisponivel(false);
                System.out.println("Veículo com placa " + veiculo.getPlaca() + " entrou na vaga " + vaga.getVaga());
                return;
            }
        }
        System.out.println("Nenhuma vaga disponível para o veículo de placa " + veiculo.getPlaca());
    }

    public void registrarSaidaVeiculo(String placa, int horaSaida, int minSaida) {
        for (Vagas vaga : listaVagas) {
            Veiculo veiculo = vaga.getVeiculoAtual();
            if (veiculo != null && veiculo.getPlaca().equals(placa)) {
                veiculo.setHoraSaida(horaSaida);
                veiculo.setMinSaida(minSaida);
                veiculo.calcularValor();
                System.out.println("Veículo com placa " + placa + " pagou: R$" + veiculo.getPrecoFinal());
                historicoVeiculos.add(veiculo);
                vaga.setVeiculoAtual(null); 
                vaga.setDisponivel(true);   
                return;
            }
        }
        System.out.println("Veículo não encontrado.");
    }
    
    public void gerarRelatorioVagasOcupadas() {
        for (Vagas vaga : listaVagas) {
            if (!vaga.isDisponivel()) {
                System.out.println(vaga);
            }
        }
    }
    
    public void mostrarHistoricoVeiculo(String placa) {
        boolean encontrado = false;
        for (Veiculo veiculo : historicoVeiculos) {
            if (veiculo.getPlaca().equals(placa)) {
                System.out.println(veiculo);  
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Veículo com placa " + placa + " não encontrado no histórico.");
        }
    }
}
