package com.suaestacao.dao; // Define o pacote responsável pela camada de acesso aos dados (DAO) na aplicação Web.

// Importa a classe modelo DadoClimatico que representa a entidade mapeada do banco.
import com.suaestacao.modelo.DadoClimatico;

// Importa a interface Session do Hibernate para gerenciar transações e operações com o banco de dados.
import org.hibernate.Session;

// Importa a interface SessionFactory responsável por gerenciar o pool de conexões e criar sessões do Hibernate.
import org.hibernate.SessionFactory;

// Importa a classe Configuration para ler as configurações do arquivo hibernate.cfg.xml.
import org.hibernate.cfg.Configuration;

// Importa a interface List da linguagem Java para armazenar e retornar os registros consultados.
import java.util.List;

// Declaração da classe DAO responsável pelas consultas na tabela DadosClimaticos no SQL Server.
public class DadoClimaticoDAO {

    // Declara a fábrica de sessões (private restringe o acesso, final garante imutabilidade da referência).
    private final SessionFactory sessionFactory;

    // Construtor padrão da classe DadoClimaticoDAO.
    public DadoClimaticoDAO() {

        // Lê o arquivo hibernate.cfg.xml e constrói a fábrica de sessões para conectar ao SQL Server.
        this.sessionFactory = new Configuration().configure().buildSessionFactory();

    } // Finaliza o construtor.

    // Método responsável por buscar no banco os últimos registros gravados em ordem decrescente.
    // Recebe como parâmetro 'limite' a quantidade máxima de linhas retornadas (ex: 20 registros).
    public List<DadoClimatico> listarUltimos(int limite) {

        // Abre uma nova sessão com o banco de dados usando try-with-resources (garante o fechamento automático da conexão ao terminar).
        try (Session session = sessionFactory.openSession()) {

            // Cria a consulta HQL para buscar os registros ordenados do ID mais recente (maior) para o mais antigo (menor).
            return session.createQuery("FROM DadoClimatico ORDER BY id DESC", DadoClimatico.class)

                          // Define o limite máximo de registros trazidos pelo banco (equivalente ao TOP N do SQL Server).
                          .setMaxResults(limite)

                          // Executa a consulta e converte os resultados em uma List<DadoClimatico>.
                          .list();

        } // Fecha a sessão do Hibernate automaticamente ao sair do bloco try.

    } // Finaliza o método listarUltimos().

    // Método responsável por encerrar a fábrica de sessões e liberar conexões ativas.
    public void fechar() {

        // Verifica se a fábrica de sessões foi instanciada e se permanece aberta.
        if (sessionFactory != null && !sessionFactory.isClosed()) {

            // Encerra a fábrica de sessões do Hibernate e libera os recursos do pool de conexões.
            sessionFactory.close();

        } // Finaliza a verificação.

    } // Finaliza o método fechar().

} // Finaliza a classe DadoClimaticoDAO.