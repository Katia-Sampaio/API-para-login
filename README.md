
# Documentação da API de Login

## Visão Geral
A API de Login é um serviço que permite que os usuários façam login em um sistema. Para autenticar com sucesso, o usuário deve fornecer um e-mail válido e uma senha que atenda aos critérios especificados.

### Detalhes da Solução
- **Métodos Suportados**: POST (para autenticação de login)
- **Validação de Senha**: A senha deve atender ao seguinte critério de regex: `^(?=.*[A-Z])(?=.*[a-z])(?=.*\d)(?!.*\s)(?!.*(.).*\1)(?=.*[!@#%^&*()-+]).{9,}$`

(?=.*[A-Z]): Deve conter pelo menos uma letra maiúscula.
(?=.*[a-z]): Deve conter pelo menos uma letra minúscula.
(?=.*\d): Deve conter pelo menos um dígito (número).
(?!.*\s): Não deve conter espaços em branco.
(?!.*(.).*\1): Não deve conter caracteres repetidos. Isso é feito usando um grupo de lookahead negativo para verificar se não há dois caracteres iguais consecutivos.
(?=.*[!@#%^&*()-+]): Deve conter pelo menos um caractere especial da lista !@#%^&*()-+.
.{9,}: Deve ter pelo menos 9 caracteres no total.

## Como Executar o Projeto

### Requisitos de Software
Antes de executar o projeto, certifique-se de ter o seguinte software instalado em sua máquina:
- SpringBoot (versão 3.1.3)
- Java (Linguagem – Versão 17)
- Maven (gerenciador de dependências)
- Banco de Dados MySql (Versão 8.0.21)
- Eclipse IDE (Versão 2019-09)
### Configuração Inicial
1. Clone este repositório para o seu computador:
   ```
   git clone https://github.com/Katia-Sampaio/API-para-login.git
   ```

2. Navegue até o diretório do projeto:
   ```
   cd api-login
   ```

3. Configure o o seu banco de dados com as informações a seguir: 
Servidor: 127.0.0.1
Porta: 3308
Usuário: root
Senha: OYqEq5mAi59J9bq
Banco: API-Login

### Executando o Projeto
Para iniciar o serviço da API, importe o projeto no eclipse, após a importação click no botão “run” ou tecle Ctrl + F11.


A API estará acessível em `http://localhost:3308` por padrão. 

## Endpoints da API

### Login

- **URL**: `http://localhost:8080/usuarios `
- **Método**: POST
- **Requisitos**: Os seguintes dados devem ser fornecidos no corpo da solicitação em formato JSON:
  - `email`: O endereço de e-mail do usuário.
  - `senha`: A senha do usuário.

#### Exemplo de Solicitação:
```json
{
  "email": "usuario@email.com",
  "senha": "Senha@Segura123"
}
```

#### Resposta de Sucesso:
- **Código de Status**: 200 OK
- **Corpo da Resposta**: retornará um json com as informações presentes no banco de dados.
Exemplo:
  ```json
  {
    "id": "1",
    "email": "fulano@detal.com",
    “senha”: “fulano183*”
  }
  ```

#### Resposta de Erro:
- **Código de Status**: 401 Unauthorized.
- **Corpo da Resposta**: Não retorna corpo de resposta.
 

## Considerações Finais
A API de Login oferece um serviço seguro para autenticação de usuários. Certifique-se de seguir os requisitos de senha especificados para uma autenticação bem-sucedida.

Para obter mais informações sobre como usar a API, consulte os endpoints e exemplos fornecidos.

Se você tiver alguma dúvida ou problema, entre em contato com a equipe de suporte em `itau@suporte.com`.

---

