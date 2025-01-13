#language: pt
@login
Funcionalidade: : Testes de Login

  Cenario: : Login com sucesso
    Dado Eu estou na página de login do BugBank
    E Eu crio uma conta de teste com email "email@teste.com", nome "Teste" e senha "Senha123!"
    Quando Eu faço login com email "email@teste.com" e senha "Senha123!"
    Então Eu vejo a mensagem sucesso "A conta foi criada com sucesso"

  Cenario: Login com credenciais inválidas
    Dado Eu estou na página de login do BugBank
    Quando Eu faço login com email "email@invalido.com" e senha "senhaerrada"
    Entao Eu vejo a mensagem de login com erro "Usuário ou senha inválido."



