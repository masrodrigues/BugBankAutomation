#language: pt
  @Registro
  Funcionalidade: Realizar cadastro no BugBank
 #concluido
    Cenario: Cadastro com sucesso
      Dado Eu estou na página inicial do BugBank
      Quando Eu clico no botão Registrar
      E Eu preencho o formulário com "email@test.com", "marco", "123"
      E Clico no botão cadastrar
      Então Eu vejo a mensagem de registro "A conta foi criada com sucesso"

  #concluido
    Cenário: Cadastro com erro no campo email
      Dado Eu estou na página inicial do BugBank
      Quando Eu clico no botão Registrar
      E Eu preencho o formulário com campo email vazio
      | email | nome | senha |
      |       | marco| senha |
      |sss.sss| marco| senha |
      |sss@ssssssssssssssssssssssssssss| marco| senha |
      E Clico no botão cadastrar
      Então Eu vejo a mensagem de campo obrigatorio "É campo obrigatório"


      #Falta implementar
    Cenário: Cadastro com erro no campo email
      Dado Eu estou na página inicial do BugBank
      Quando Eu clico no botão Registrar
      E Eu preencho o formulário com campo email com formato inválido
      E Clico no botão cadastrar
      Então Eu vejo a mensagem de erro "Formato inválido"


    Cenário: Cadastro com erro no campo nome
        Dado Eu estou na página inicial do BugBank
        Quando Eu clico no botão Registrar
        E Eu preencho o formulário com campo nome vazio
        E Clico no botão cadastrar
        Então Eu vejo a mensagem de erro "Nome não pode ser vazio."

         #Falta implementar
      Cenario: Cadastro com erro no campo senha
        Dado Eu estou na página inicial do BugBank
        Quando Eu clico no botão Registrar
        E Eu preencho o formulário com campo senha
        E preencho o campo confirmação de senha diferente do campo senha
        E Clico no botão cadastrar
        Então Eu vejo a mensagem de erro "O campo senha é obrigatório"