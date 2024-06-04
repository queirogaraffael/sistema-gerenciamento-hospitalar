# Sistema de Gerenciamento Hospitalar
O Sistema de Gerenciamento Hospitalar é uma aplicação Java desenvolvida para auxiliar na gestão de pacientes e médicos em um ambiente hospitalar. Ele oferece funcionalidades para adicionar, pesquisar, excluir e modificar informações de pacientes e médicos, como nome, CPF (para pacientes), CRM (para médicos), idade, endereço e telefone.

## Funcionalidades
* Adicionar novo paciente: Permite adicionar um novo paciente ao sistema informando seu CPF, nome, idade, endereço e telefone.
* Adicionar novo médico: Permite adicionar um novo médico ao sistema informando seu CRM, nome, especialidade e telefone.
* Pesquisar paciente por CPF: Permite buscar um paciente pelo seu CPF e exibir suas informações.
* Pesquisar médico por CRM: Permite buscar um médico pelo seu CRM e exibir suas informações.
* Excluir paciente pelo CPF: Permite excluir um paciente do sistema informando seu CPF.
* Excluir médico pelo CRM: Permite excluir um médico do sistema informando seu CRM.
* Modificar telefone do paciente: Permite alterar o telefone de um paciente informando seu CPF.
* Modificar telefone do médico: Permite alterar o telefone de um médico informando seu CRM.
* Sair do sistema: Encerra a execução do sistema.

## Tecnologias Utilizadas
* Java
* Swing (para a interface gráfica)
* JDBC (para a comunicação com o banco de dados)
* MySQL (banco de dados utilizado)

## Padrões de Projeto
* MVC (Model-View-Controller): O sistema foi desenvolvido seguindo a arquitetura MVC, separando as responsabilidades de modelagem dos dados, apresentação da interface gráfica e controle das ações do usuário.
* Factory: Utilizou-se o padrão de projeto Factory para a criação dos Data Access Objects (DAOs), permitindo uma fácil extensibilidade e manutenção do código.

## Operações CRUD Básicas
O sistema implementa as operações básicas do CRUD (Create, Read, Update, Delete) para as entidades Paciente e Médico, proporcionando uma gestão completa dos registros.

## Execução
Para executar o sistema, basta modificar o arquivo db.properties, rodar a query que está na pasta dbQuery no MySql e depois rodar classe Main localizada no pacote hospitalManagementSystem.application.

## Observações
Certifique-se de configurar corretamente as informações de conexão com o banco de dados no arquivo db.properties antes de executar o sistema.
