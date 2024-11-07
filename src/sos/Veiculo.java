package sos;

public class Veiculo {
    String placa;
    String modelo;
    String tamanho;
    int horaEntrada;
    int minEntrada;
    int horaSaida;
    int minSaida;
    int precoFinal;
    int numeroDaVaga;

    public Veiculo(String placa, String modelo, String tamanho, int horaEntrada, int minEntrada) {
        this.placa = placa;
        this.modelo = modelo;
        this.tamanho = tamanho;
        this.horaEntrada = horaEntrada;
        this.minEntrada = minEntrada;
    }

    public String getPlaca() {
        return placa;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setHoraSaida(int horaSaida) {
        if (horaSaida < 8 || horaSaida > 22) {
            System.out.println("Hora de saída deve estar entre 08:00 e 22:00.");
            return;
        }
        this.horaSaida = horaSaida;
    }

    public void setMinSaida(int minSaida) {
        this.minSaida = minSaida;
    }

    public void setNumeroDaVaga(int numeroDaVaga) {
        this.numeroDaVaga = numeroDaVaga;
    }

    public int calcularTempo() {
        int minutosEntrada = (horaEntrada * 60) + minEntrada;
        int minutosSaida = (horaSaida * 60) + minSaida;
        return minutosSaida - minutosEntrada;
    }

    public void calcularValor() {
        int minutosEntrada = (horaEntrada * 60) + minEntrada;
        int minutosSaida = (horaSaida * 60) + minSaida;
        int minFinal = minutosSaida - minutosEntrada;

        if (minFinal < 0) {
            System.out.println("A hora de saída deve ser após à hora de entrada.");
            return;
        }
        if (minFinal <= 60) {
            precoFinal = 5;
        } else if (minFinal <= 180) {
            precoFinal = 10;
        } else {
            precoFinal = 15;
        }
    }

    public int getPrecoFinal() {
        return precoFinal;
    }

    @Override
    public String toString() {
        return "Placa: " + placa + ", Modelo: " + modelo + ", Tamanho: " + tamanho +
               ", Entrada: " + horaEntrada + ":" + minEntrada +
               ", Saída: " + horaSaida + ":" + minSaida +
               ", Vaga: " + numeroDaVaga +
               ", Valor pago: R$ " + precoFinal;
    }
}

