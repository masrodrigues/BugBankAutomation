#language: pt

Funcionalidade: Realizar cadastro no BugBank

  Cenario: Cadastro com sucesso
    Dado Eu estou na página inicial do BugBank
    Quando Eu clico no botão Registrar
    E Eu preencho o formulário com "email@test.com", "marco", "123"
    E Clico no botão cadastrar
    Então Eu vejo a mensagem de registro "A conta foi criada com sucesso"
  @Registro
  Cenario: Cadastro com erro no campo nome
    Dado Eu estou na página inicial do BugBank
    Quando Eu clico no botão Registrar
    E Eu preencho o formulário com campo nome vazio
    E Clico no botão cadastrar
    Então Eu vejo a mensagem de erro "Nome não pode ser vazio"