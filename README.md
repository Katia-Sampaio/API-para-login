
# Documentação da API de Login

## Visão Geral
A API de Login é um serviço que permite que os usuários façam login em um sistema. Para autenticar com sucesso, o usuário deve fornecer um e-mail válido e uma senha que atenda aos critérios especificados.

### Detalhes da Solução
- **Métodos Suportados**: 
    - `POST` (para autenticação de login, diretamente na pag web)
    - `GET` (Para buscar os usuários cadastrados em sistema. Este método estará disponível usando diretamente o endpoint da api no navegador)
    - `PUT` (Para editar usuários existentes no sistema, basta informar um usuário ja existente no JSON da solicitação, atualizando os campos necessários)
    - `DELETE` (Para realizar a deleção de usuários pelo ID)

- **Validação de Senha**: A senha deve atender ao seguinte critério de regex: `^(?=.*[A-Z])(?=.*[a-z])(?=.*\d)(?!.*\s)(?!.*(.).*\1)(?=.*[!@#%^&*()-+]).{9,}$`

- (?=.*[A-Z]): Deve conter pelo menos uma letra maiúscula.
- (?=.*[a-z]): Deve conter pelo menos uma letra minúscula.
- (?=.*\d): Deve conter pelo menos um dígito (número).
- (?!.*\s): Não deve conter espaços em branco.
- (?!.*(.).*\1): Não deve conter caracteres repetidos. Isso é feito usando um grupo de lookahead negativo para verificar se não há dois caracteres iguais consecutivos.
- (?=.*[!@#%^&*()-+]): Deve conter pelo menos um caractere especial da lista !@#%^&*()-+.
- .{9,}: Deve ter pelo menos 9 caracteres no total.

## Como Executar o Projeto

### Requisitos de Software
Antes de executar o projeto, certifique-se de ter o seguinte software instalado em sua máquina:
- SpringBoot (versão 3.1.3)
- Java (Linguagem – Versão 17)
- Maven (gerenciador de dependências)
- Banco de Dados MySql (Versão 8.0.21)
- Eclipse IDE (Versão 2019-09)

### Para solicitações PUT, DELETE
Certifique-se de ter o seguinte software instalado em sua máquina:
- Postman (Versão. 9.16.0)

### Configuração Inicial
1. Clone este repositório para o seu computador:
   ```
   git clone https://github.com/Katia-Sampaio/API-para-login.git
   ```

2. Navegue até o diretório do projeto:
   ```
   cd API-para-login
   ```

3. Configure o seu banco de dados com as informações a seguir: 
```
Servidor: 127.0.0.1
Porta: 3308
Usuário: root
Senha: OYqEq5mAi59J9bq
Banco: API-Login
```

### Executando o Projeto
Para iniciar o serviço da API, importe o projeto no eclipse, após a importação click no botão “run” ou tecle Ctrl + F11.


A API estará acessível em `http://localhost:3308` por padrão. 

## Endpoints da API E MÉTODOS

### GET 

- **URL**: `http://localhost:8080/usuarios `
- **Requisitos**: Basta usar a url no navegador de sua preferência, ou realizar a solicitação usando o software Postman, passando a url e selecionando o método GET.

### POST
- **Requisitos**:  
    - Execute o arquivo index.html;
    - Logo será apresentada uma tela de login;
    - Preencha os campos corretamente;
    - As informações serão enviadas para o sistema;
    - Será apresentado um boolean informando se a solicitação foi bem sucedidA ou não.
  

#### Resposta de Sucesso:
- **Boolean**: true

#### Resposta de Erro:
- **Boolean**: false

 

 #### Exemplo de Solicitação:
```json
[
{
  "email": "usuario@email.com",
  "senha": "Senha@Segura123"
}
]
```
### PUT
- **URL**: `http://localhost:8080/usuarios `
- **Requisitos**:   
    - Usando o Postman, preencha os campos do JSON, informando email e senha de um usuário já existente, alterando os campos que achar necessário;
    - Informe a url e envie a solicitação


     #### Exemplo de Solicitação:
```json
[
{
    "id": 1,
  "email": "usuarioalterado@email.com",
  "senha": "Senha@Segura123"
}
]
```
### DELETE
- **URL**: `http://localhost:8080/usuarios/ID `
- **Requisitos**: 
    - Usando o Postman, informe a url, passando o id do usuário a ser deletado;
    - Click em send para enviar a solicitação;

#### Exemplo de Solicitação:
será deletado o usuário que possui o Id 1.

`http://localhost:8080/usuarios/1 `

## Considerações Finais
A API de Login oferece um serviço seguro para autenticação de usuários. Certifique-se de seguir os requisitos de senha especificados para uma autenticação bem-sucedida.

Se você tiver alguma dúvida ou problema, entre em contato com a equipe de suporte em `itau-suporte@recuperacaovarejo.com`.

---
