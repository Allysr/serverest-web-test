# Projeto Serve Rest

Este projeto automatiza o cadastro de usuários, o processo de login e o registro de produtos em uma plataforma de gerenciamento de vendas. A automação segue o padrão Page Objects em conjunto com Fluent Page, garantindo um código mais modular, 

- Site utilizado: https://front.serverest.dev/admin/home

## Estrutura do Projeto

O projeto é organizado da seguinte forma:

- **br.com.serveRest**: Pacote principal contendo os testes e as páginas a serem automatizadas.
    - **pages**: Contém as páginas que representam as telas da aplicação.
    - **util**: Contém utilitários para gerar dados de teste, como e-mails e nomes de produtos.
    - **tests**: Contém os testes automatizados para o cadastro de usuários e produtos.

## Dependências

- **JUnit**: Framework de testes.
- **Selenium**: Ferramenta de automação de navegadores.
- **Allure**: Ferramenta para geração de relatórios de testes.
- **Maven**: Para gerenciamento de dependências e execução dos testes.

### Rodar o projeto

1. Instale as dependências do Maven:
 ```bash
   mvn clean install
 ```

2. Para rodar os testes, utilize o seguinte comando:
 ```bash
  mvn test
 ```

### Rodar o Allure

1. Gerar a evidência:
 ```bash
   allure generate
 ```

2. Abrir a evidência:
 ```bash
   allure open
 ```

