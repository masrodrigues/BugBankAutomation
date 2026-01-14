#language: pt

@login
Funcionalidade: Testes de Login
  Cenario: Login com sucesso
    Dado Eu estou na página inicial do BugBank
    E Eu clico no botão Registrar
    E Eu preencho o formulário com "email@test.com", "marco", "123"
    E Clico no botão cadastrar
    Quando Eu faço login com email "email@teste.com" e senha "Senha123"
    Então Eu sou redirecionado para a area logada

  Cenario: Login com credenciais inválidas
    Dado Eu estou na página inicial do BugBank
    Quando Eu faço login com email "email@invalido.com" e senha "SenhaInvalida"
    Entao Eu vejo a mensagem de login com erro "Usuário ou senha inválido."

  @login
  Cenario: Login com email invalido
    Dado Eu estou na página inicial do BugBank
    E Eu clico no botão Registrar
    E Eu preencho o formulário com "email@test.com", "marco", "123"
    E Clico no botão cadastrar
    Quando Eu faço login com email "email@teste2.com" e senha "Senha123"
    Então Eu vejo a mensagem de login com erro "Usuário ou senha inválido."

