package sos;

public class Vagas {
    int vaga;
    String tamanho;
    boolean disponivel;
    Veiculo veiculoAtual;

    public Vagas(int vaga, String tamanho, boolean disponivel) {
        this.vaga = vaga;
        this.tamanho = tamanho;
        this.disponivel = disponivel;
        this.veiculoAtual = null;
    }

    public Veiculo getVeiculoAtual() {
        return veiculoAtual;
    }

    public void setVeiculoAtual(Veiculo veiculo) {
        this.veiculoAtual = veiculo;
    }

    public int getVaga() {
        return vaga;
    }

    public void setVaga(int vaga) {
        this.vaga = vaga;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    @Override
    public String toString() {
        if (disponivel) {
            return "Vaga número: " + vaga + ", Tamanho: " + tamanho + " (Disponível)";
        } else {
            return "Vaga número: " + vaga + ", Tamanho: " + tamanho + ", Ocupada por veículo de placa: " + veiculoAtual.getPlaca();
        }
    }
}

