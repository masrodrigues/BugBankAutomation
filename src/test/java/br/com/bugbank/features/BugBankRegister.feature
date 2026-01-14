#language: pt

Funcionalidade: Realizar cadastro no BugBank

  Cenario: Cadastro com sucesso
    Dado Eu estou na página inicial do BugBank
    Quando Eu clico no botão Registrar
    E Eu preencho o formulário com "email@test.com", "marco", "123"
    E Clico no botão cadastrar
    Então Eu vejo a mensagem de registro "A conta foi criada com sucesso"

  @Registro
  Cenario: Cadastro com sucesso e saldo
    Dado Eu estou na página inicial do BugBank
    Quando Eu clico no botão Registrar
    E Eu preencho o formulário com "email@test.com", "marco", "123"
    E Adiciono Saldo
    E Clico no botão cadastrar
    E Eu vejo a mensagem de registro "A conta foi criada com sucesso"
    E Clico no fechar modal da conta de sucesso
    Entao Eu faço login com email "email@test.com" e senha "123"
    E Eu sou redirecionado para a area logada


  Cenario: Cadastro com erro no campo nome
    Dado Eu estou na página inicial do BugBank
    Quando Eu clico no botão Registrar
    E Eu preencho o formulário com campo nome vazio
    E Clico no botão cadastrar
    Então Eu vejo a mensagem de erro "Nome não pode ser vazio"