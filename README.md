# gestaotarefasbackend

Teste sobre cadastro de tarefas

Parte 4 – Experiência com Flex (teórica) Responda no README.md ou em arquivo separado: Possuo sim um pouco de conhecimento teórico sobre Flex e action Script.


1. Já trabalhou com Adobe Flex/ActionScript? Quando e em que contexto? 
2. Quais tipos de aplicações você desenvolveu? 

- Trabalhei com Flex na empresa Silcom – Programador 12/2006 – 03/2008.                     - Desenvolvi projetos do zero, com várias funcionalidades. Projeto para o setor 
de Logística, controle de estoque.

- Trabalhei com Flex na empresa Mirante Tecnologia - Analista Desenvolvedor Java FullStack SR - 03/2023 – 10/2024. 
- Atuando na sustentação do cliente Sicoob, efetuando várias correções e também mudanças como criação de páginas e tabelas paginadas. Por conta de vários erros do plugin do Flex de conversão e deserialização. 
- Alteração desenvolvendo do zero telas com várias abas. E algumas outras funcionalidades envolvendo correções.

3. Você se considera apto a dar manutenção em sistemas legados em Flex? 
 - Sim me considero apto a dar manutenção em sistemas em Flex.


SOBRE O PROJETO - TAREFAS

O projeto criado com SpringBoot 3.5.5, possui algumas dependências como H2, Lombook, SpringData, SpringWeb.



Foi criado no spring initializr - https://start.spring.io/

Java 17, SpringBoot 3.5.5, com as dependências listadas abaixo:

- O projeto é Maven já está com todas as dependências no projeto, somente importar e rodar o comando maven install para baixá-las.

- A classe principal de execução do SpringBoot é a GestaotarefasApplication.

- Somente clicar com o botão direito e ir em Run AS – SpringBoot Application.

- A base de dados H2 sobe em memória pela própria dependência do H2 no POM.xml.

- O sistema carrega alguns registros iniciais toda vez que a aplicação sobe.

- Para acesso na base de dados verificar as informações de conexão no arquivo application.yml.

- Acesso na base URL e porta, pode ser acessado pelo browser.


SELECT 
    t.id,
    t.titulo,
    t.status,
    t.data_criacao,
    p.nome AS nome_projeto
FROM 
    tarefa t
INNER JOIN 
    projeto p ON t.id_projeto = p.id_projeto
ORDER BY 
    t.data_criacao DESC;

SELECT 
    * 
FROM 
    tarefa 
ORDER BY 
    data_criacao DESC 
LIMIT 3 OFFSET 3;

SELECT 
    t.id,
    t.titulo,
    t.status,
    t.data_criacao,
    p.nome AS nome_projeto
FROM 
    tarefa t
JOIN 
    projeto p ON t.id_projeto = p.id_projeto
ORDER BY 
    t.data_criacao DESC
LIMIT 2 OFFSET 0;




