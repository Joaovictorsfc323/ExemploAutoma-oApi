# language: pt 
# enconding:  UTF-8

#LEGENDA
#1 = POST /api/v1/simulacoes
#2 = PUT /api/v1/simulacoes/{cpf}
#3 = GET /api/v1/restricoes/{cpf}
#4 = GET /api/v1/simulacoes
#5 = GET /api/v1/simulacoes/{cpf}
#6 = DELETE /api/v1/simulacoes/{id}



Funcionalidade: Restricao e Simulacao

@Cenario1
Esquema do Cenario: Validacao se api de restricoes retorna '200' - cpf com restricoes
Dado  fornece os cpf "<cpf>"
Quando que executa api"<nomeapi>"
Entao retorna com sucesso "<status>"


Exemplos:
|nomeapi |cpf          |status|
|3       |97093236014  |200   |

@Cenario2
Esquema do Cenario: Validacao se api de restricoes retorna 204 - cpf sem restricoes
Dado  fornece os cpf "<cpf>"
Quando que executa api"<nomeapi>"
Entao retorna com sucesso "<status>"


Exemplos:
|nomeapi |cpf          |status|
|3       |32344026045  |204   |


@Cenario3
Esquema do Cenario: Validar se retorna uma simulacao cadastrada
Dado  fornece os cpf "<cpf>"
Quando que executa api"<nomeapi>"
Entao retorna com sucesso "<status>"


Exemplos:
|nomeapi |cpf          |status|
|5       |17822386034  |200   |


@Cenario4
Esquema do Cenario: Validar se retorna a lista de simulacoes cadastradas e existir uma ou mais
Dado  fornece os cpf "<cpf>"
Quando que executa api"<nomeapi>"
Entao retorna com sucesso "<status>"


Exemplos:
|nomeapi |cpf          |status|
|4       |66414919004  |200   |

#-------------------------------------------------------------------------------------------------------------------

@Cenario5
Esquema do Cenario: Validar uma simulacao cadastrada com sucesso retorna o HTTP Status 201 e os dados inseridos como retorno
Dado  fornece os cpf nome email valor parcela seguro "53728056090" "João Victor" "joao_victor@hotmail.com" <30000> <30> "true"
Quando que executa api"<nomeapi>"
Entao retorna com sucesso "<status>"


Exemplos:
|nomeapi |status|
|1       |201   |

@Cenario6
Esquema do Cenario: Validar uma simulacao com problema em alguma regra retorna o HTTP Status 400 com a lista de erros
Dado  fornece os cpf nome email valor parcela seguro "53728056090" "João Victor" "joao_victor@hotmail.com" <300> <1> "true"
Quando que executa api"<nomeapi>"
Entao retorna com sucesso "<status>"


Exemplos:
|nomeapi |status|
|1       |400   |
#Validar uma simulacao para um mesmo CPF retorna um HTTP Status 409 com a mensagem "CPF ja existente"
@Cenario7
Esquema do Cenario: Validar uma simulacao para um mesmo CPF retorna um HTTP Status 409 com a mensagem "CPF j� existente"
Dado  fornece os cpf nome email valor parcela seguro "17822386034" "João Victor" "joao_victor@hotmail.com" <30000> <30> "true"
Quando que executa api"<nomeapi>"
Entao retorna com sucesso "<status>"


Exemplos:
|nomeapi |status|
|1       |409   |



#PUT <host>/api/v1/simulacoes/{cpf}
#Validar se altera��o � feita no atrbuto nome
@Cenario8
Esquema do Cenario: Validar se alteracao e feita no atributo
Dado  fornece os cpf nome email valor parcela seguro "53728056090" "João Santana" "joao_victor@hotmail.com" <30000> <30> "true"
Quando que executa api"<nomeapi>"
Entao retorna com sucesso "<status>"


Exemplos:
|nomeapi |status|
|2       |200   |

#Validar se o CPF n�o possuir uma simula��o o HTTP Status 404 � retornado com a mensagem "CPF n�o encontrado"
@Cenario9
Esquema do Cenario: Validar se o CPF nao possuir uma simulacao o HTTP Status 404 o retornado com a mensagem CPF nao encontrado
Dado  fornece os cpf nome email valor parcela seguro "00000000" "João Santana" "joao_victor@hotmail.com" <30000> <30> "true"
Quando que executa api"<nomeapi>"
Entao retorna com sucesso "<status>"


Exemplos:
|nomeapi |status|
|2       |404   |

#DELETE <host>/api/v1/simulacoes/{id}
#Validar se retorna o HTTP Status 204 se simula��o for removida com sucesso
@Cenario10
Esquema do Cenario: Validar se retorna o HTTP Status 204 se simulacao for removida com sucesso
Dado fornece o id "<id>"
Quando que executa api"<nomeapi>"
Entao retorna com sucesso "<status>"


Exemplos:
|nomeapi |id  |status|
|6       |11  |204   |

#Validar se retorna o HTTP Status 404 com a mensagem "Simula��o n�o encontrada" se n�o existir a simula��o pelo ID informado
#-------
@Cenario11
Esquema do Cenario:Validar se retorna o HTTP Status 404 com a mensagem  Simulacao nao encontrada  se nao existir a simulacao pelo ID informado
Dado fornece o id "<id>"
Quando que executa api"<nomeapi>"
Entao retorna com sucesso "<status>"


Exemplos:
|nomeapi |id  |status|
|6       |11  |404   |

#-------
#GET <host>/api/v1/simulacoes
#Validar se retorna HTTP Status 204 caso n�o exista simula��es cadastradas
@Cenario12
Esquema do Cenario: Validar se retorna HTTP Status 204 caso nao exista simulacoes cadastradas
Dado  deleto todas as simulacoes
Quando que executa api"<nomeapi>"
Entao retorna com sucesso "<status>"


Exemplos:
|nomeapi |status|
|4       |204   |




#-------
#GET <host>/api/v1/simulacoes/{cpf}
#Validar se o CPF n�o possuir uma simula��o o HTTP Status 404 � retornado
@Cenario13
Esquema do Cenario: Validar se o CPF nao possuir uma simulacao o HTTP Status 404  retornado
Dado  fornece os cpf "<cpf>"
Quando que executa api"<nomeapi>"
Entao retorna com sucesso "<status>"


Exemplos:
|nomeapi |cpf          |status|
|5       |32344026045  |404   |

