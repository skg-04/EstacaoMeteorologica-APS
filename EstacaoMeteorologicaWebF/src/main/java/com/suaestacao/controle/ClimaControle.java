package com.suaestacao.controle; // Define o pacote responsável pela camada de controle (Controllers) da aplicação Web.

// Importa a classe DAO utilizada para consultar os registros no banco de dados SQL Server.
import com.suaestacao.dao.DadoClimaticoDAO;

// Importa a classe modelo (entidade) que representa a tabela de dados climáticos.
import com.suaestacao.modelo.DadoClimatico;

// Importa a classe do Spring utilizada para configurar cabeçalhos de controle de cache HTTP.
import org.springframework.http.CacheControl;

// Importa a classe que representa toda a resposta HTTP (código de status, cabeçalhos e o corpo JSON).
import org.springframework.http.ResponseEntity;

// Importa a anotação que mapeia requisições HTTP do tipo GET.
import org.springframework.web.bind.annotation.GetMapping;

// Importa a anotação que define o caminho de URL base para todas as rotas deste controller.
import org.springframework.web.bind.annotation.RequestMapping;

// Importa a anotação que torna a classe um controlador REST que retorna objetos serializados em JSON.
import org.springframework.web.bind.annotation.RestController;

// Importa a interface List da linguagem Java para manipular a coleção de dados climáticos.
import java.util.List;

// Indica ao Spring Boot que esta classe é um Controller REST (retorna dados em JSON em vez de páginas HTML).
@RestController

// Define a rota de URL base para acessar os recursos desta classe: http://localhost:8080/api/dados
@RequestMapping("/api/dados")

// Declaração da classe responsável por responder às requisições da API do dashboard.
public class ClimaControle {

    // Instancia o DAO responsável por realizar a ponte de leitura com o Hibernate e o SQL Server.
    // private restringe o acesso, final impede a troca da referência da variável.
    private final DadoClimaticoDAO dao = new DadoClimaticoDAO();

    // Mapeia o método para responder quando o navegador/JavaScript fizer uma requisição GET para "/api/dados".
    @GetMapping

    // Declara o método público que retorna uma ResponseEntity contendo uma lista de objetos DadoClimatico.
    public ResponseEntity<List<DadoClimatico>> obterUltimosDados() {

        // Executa a consulta no banco via Hibernate solicitando apenas os últimos 20 registros inseridos.
        List<DadoClimatico> dados = dao.listarUltimos(20);

        // Prepara e retorna a resposta HTTP 200 (OK):
        return ResponseEntity.ok()

                // Adiciona a instrução nos cabeçalhos HTTP para impedir que o navegador guarde a resposta em cache.
                .cacheControl(CacheControl.noCache().mustRevalidate())

                // Insere a lista de dados no corpo da resposta (que o Spring Boot converte automaticamente para JSON) e envia ao cliente.
                .body(dados);

    } // Finaliza o método obterUltimosDados().

} // Finaliza a classe ClimaControle.