# BLUE POINT 🔵
***Recicle nossos oceanos, você ganha, eu ganho, o mar ganha***

Aplicação em desenvolvimento desde 28/03/2024*
### [Link para o GIT](https://github.com/MatheusFelipeCamarinhaDuarte/BluePoints)



# Sumário

[1 - Integrantes](#_Integrantes)

[2 - Instruções de como rodar a aplicação](#_Instruicoes)

[3 - Diagramas](#_Diagramas)

[4 - Nossa proposta em vídeo PITCH](#_Picth)

[5 - Explicações de classes](#_Explicacoes)

[6 - Endpoints](#_Endpoint)


<a id="_Integrantes"></a>

# 1 - Integrantes
    RM: 551401 Turma: 2TDSPF Nome: Ana Luiza Fontes Franco
    RM: 551856 Turma: 2TDSPF Nome: Beatriz Fon Ehnert de Santi
    RM: 552295 Turma: 2TDSPF Nome: Matheus Felipe Camarinha Duarte
    RM: 98672  Turma: 2TDSPF Nome: Mirelly Ribeiro Azevedo
    RM: 99708  Turma: 2TDSPW Nome: Gabriel Francisco Lobo
** Verificar o [txt da equipe](documentacao%2Fequipe.txt) para consultar pontos extras.

<a id="_Instruicoes"></a>

# 2 - Instrucoes de como rodar a aplicação
Enrtar em:

src > main > java > br.com.fiap.bluePoint
e executar o arquivo bluePointApplication.Java
O projeto estará fluindo a partir dai!

[video do funcionamento do projeto](https://www.youtube.com/watch?v=nW9KG-lyNZM)

[video do funcionamento do projeto 2](https://www.youtube.com/watch?v=FpqfzviS82A)

Agora basta entrar na aplicação de mobile e fazer com que rode de forma web
assim que rodar de forma web, a aplicação estará pronta para os demias testes
descritos no repositório de [Mobile]()



<a id="_Diagramas"></a>

# 3 - Diagramas

## Diagrama do projeto Java

![diagrama1.jpg](documentacao%2Fdiagrama%2Fdiagrama-bluepoints.png)
![diagrama2.jpg](documentacao%2Fdiagrama%2Fdiagrama-de-classe.png)

## Diagrama de classe
![diagrama2.jpg](documentacao%2Fdiagrama%2Fdiagrama-de-classe.png)

## Modelo MER
![diagrama3.jpg](documentacao%2Fdiagrama%2Fmodelo-MER.png)

## TOGAF
![diagrama4.jpg](documentacao%2Fdiagrama%2FTOGAF.jpg)


<a id="_Picth"></a>

# 4 - Nossa proposta
[LINK]()

Nosso projeto se trata do uso de um aplicativo para pontuar e premiar pessoas que estão auxiliando na recolha de lixo nas praias.
A identificação é feita com uma IA criada em python por nós para distinguir diferentes tipos de lixo e pontuar de maneiras diferentes cada um deles.
Nosso App é criado em React Native e faz consumo de Java e da IA como API. Quanto a .NET faz um site para controle dos prêmios (nome e custo).
Java é responsável por gerênciar o banco de dados. A princípio, nosso aplicativo não fará o controle de premios via banco de dados nem dos locais onde irão ocorrer os eventos.


<a id="_Explicacoes"></a>

# 5 - Explicações de classes
## 5.1. Foto
Classe responsável por armazenar o camimho src de toda imagem passada a Java.

### src
camimnho onde a imagem desejada se encontra.



## 5.2. Pessoa
Classe responsável por armazenar os aspetos das pessoas que utilizarão nosso aplicativo

### Nome
Aqui são armazenados o primeiro nome da pessoa

### sobrenome
Aqui são armazenados o primeiro nome da pessoa

### Pontos
A quantidade de pontos que a pessoa tem armazenado.



## 5.3. Usuario
### Email
Deve ser unico e composto no formato padrão de emails (desc@dominio.com). Esta classse conta com um UK para evitar de ter um mesmo email para mais de um usuário.

### Senha
Regras de caracterização da senha ainda serão definidas.

### Pessoa
Herdará os atributos cadastrados de uma pessoa. Nesta classe, existe uma UK responsável por tornar o atributo único, desta forma, não podendo se repetir uma mesma pessoa. 



## 5.4. Reciclagem

### Momento
Momento em que a reciclagem foi adicionada ao banco.

### Usuario
O usuário que adicionou ela ao sistema será anexado a ela

### Pontos
Inicialmente valendo nenhum ponto até que a analise por IA defina que valhe algum ponto.

### validado
Define se uma reciclagem já foi ou não avaliada e pontuada pela IA.

### Foto
A Foto que foi enviada da reciclagem e que será analisada posteriormente.



# FUTURAS IMPLEMENTAÇÕES
## Premios
### Nome
O nome ou descrição do premio

### custo
O custo em pontos de quanto será o premio



## Campanha
Aqui ficam os dados de onde será a e quando será a próxima campanha. Furutamente, todas as reciclagens terão como atributo adicional esta classe.

### Endereço
Endeeço aproximado de onde ocorrerá o evento

### Data de início
Data de início do evento

### Data do encerramento
Data do encerramento do evento


<a id="_Endpoint"></a>

# 6 -  Endpoints

[LINK SWAGGER](http://localhost/swagger-ui/index.html)

Para melhor vizualização dos endpoins, recomendamos inicializar o projeto e posteriormente entrar no link acima
