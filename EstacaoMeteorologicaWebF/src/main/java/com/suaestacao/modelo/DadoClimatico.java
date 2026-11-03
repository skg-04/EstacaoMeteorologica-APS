package com.suaestacao.modelo; // Define o pacote onde a classe modelo (entidade JPA) está localizada no projeto.

// Importa todas as anotações do Jakarta Persistence (JPA) para o mapeamento Objeto-Relacional (ORM).
import jakarta.persistence.*;

// Importa a classe do Java utilizada para representar data e hora de alta precisão.
import java.time.LocalDateTime;

// Indica ao Hibernate/JPA que esta classe é uma Entidade e representa uma tabela no banco de dados.
@Entity

// Especifica o nome exato da tabela criada no banco de dados SQL Server ("DadosClimaticos").
@Table(name = "DadosClimaticos")

// Declaração da classe modelo que representa os registros de dados climáticos.
public class DadoClimatico {

    // Marca o campo 'id' como a Chave Primária (Primary Key) da tabela.
    @Id

    // Define que o valor do ID é gerado automaticamente pelo banco de dados (auto-incremento / IDENTITY do SQL Server).
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    // Atributo privado para armazenar o ID único de cada leitura climática.
    private Integer id;

    // Mapeia a coluna 'data_hora' da tabela. Os parâmetros insertable e updatable como false garantem que o próprio SQL Server preencha o valor padrão (DEFAULT/GETDATE()).
    @Column(name = "data_hora", insertable = false, updatable = false)

    // Atributo privado que armazena a data e a hora exatas da coleta.
    private LocalDateTime dataHora;

    // Atributo privado que armazena o valor da temperatura (°C). Por ter o mesmo nome da coluna no banco, não exige a anotação @Column.
    private Double temperatura;

    // Atributo privado que armazena o percentual de umidade relativa do ar (%).
    private Double umidade;

    // Atributo privado booleano que indica a ocorrência de chuva (true = Sim, false = Não).
    private Boolean precipitacao;

    // Mapeia o atributo 'velocidadeVento' para a coluna com o nome em padrão snake_case ('velocidade_vento') no SQL Server.
    @Column(name = "velocidade_vento")

    // Atributo privado que armazena a velocidade do vento em km/h.
    private Double velocidadeVento;

    // Mapeia o atributo 'pressaoAtmosferica' para a coluna 'pressao_atmosferica' no SQL Server.
    @Column(name = "pressao_atmosferica")

    // Atributo privado que armazena a pressão atmosférica em hPa.
    private Double pressaoAtmosferica;


    // =========================================================================
    // MÉTODOS GETTERS E SETTERS (Permitem ler e alterar os atributos privados)
    // =========================================================================

    // Retorna o ID da leitura climática.
    public Integer getId() {
        return id;
    }

    // Define/Altera o ID da leitura climática.
    public void setId(Integer id) {
        this.id = id;
    }

    // Retorna a data e a hora da leitura.
    public LocalDateTime getDataHora() {
        return dataHora;
    }

    // Defines/Altera a data e a hora da leitura.
    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    // Retorna a temperatura cadastrada.
    public Double getTemperatura() {
        return temperatura;
    }

    // Define/Altera a temperatura.
    public void setTemperatura(Double temperatura) {
        this.temperatura = temperatura;
    }

    // Retorna a umidade cadastrada.
    public Double getUmidade() {
        return umidade;
    }

    // Define/Altera a umidade.
    public void setUmidade(Double umidade) {
        this.umidade = umidade;
    }

    // Retorna se houve precipitação (chuva).
    public Boolean getPrecipitacao() {
        return precipitacao;
    }

    // Define/Altera o estado da precipitação.
    public void setPrecipitacao(Boolean precipitacao) {
        this.precipitacao = precipitacao;
    }

    // Retorna a velocidade do vento.
    public Double getVelocidadeVento() {
        return velocidadeVento;
    }

    // Define/Altera a velocidade do vento.
    public void setVelocidadeVento(Double velocidadeVento) {
        this.velocidadeVento = velocidadeVento;
    }

    // Retorna a pressão atmosférica.
    public Double getPressaoAtmosferica() {
        return pressaoAtmosferica;
    }

    // Define/Altera a pressão atmosférica.
    public void setPressaoAtmosferica(Double pressaoAtmosferica) {
        this.pressaoAtmosferica = pressaoAtmosferica;
    }

} // Finaliza a classe DadoClimatico.