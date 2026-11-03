package com.suaestacao.web; // Define o pacote onde esta classe de inicialização está localizada no projeto.

// Importa a classe responsável por inicializar e rodar o servidor Spring Boot.
import org.springframework.boot.SpringApplication;

// Importa a anotação principal que ativa a autoconfiguração e os recursos do Spring Boot.
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Importa a anotação que define em quais pacotes o Spring deve procurar componentes, controllers e serviços.
import org.springframework.context.annotation.ComponentScan;

// Indica ao Spring Boot que esta é a classe principal de configuração da aplicação.
@SpringBootApplication

// Instrução para o Spring escanear o pacote raiz "com.suaestacao" e todos os seus subpacotes (como o com.suaestacao.controle do ClimaControle).
@ComponentScan(basePackages = "com.suaestacao")

// Declaração da classe principal da Aplicação Web da Estação Meteorológica.
public class EstacaoMeteorologicaWebApplication {

    // Método principal (ponto de entrada para a execução do programa em Java).
    public static void main(String[] args) {

        // Inicializa o contexto do Spring Boot, sobe o servidor web Tomcat embutido e ativa os endpoints da API REST.
        SpringApplication.run(EstacaoMeteorologicaWebApplication.class, args);

    } // Finaliza o método main().

} // Finaliza a classe EstacaoMeteorologicaWebApplication.