# myburger
Sample app to create your burger!

## Version1.1 - Tag: v1.1
Nesta versão queremos implementar as principais funções com persistências de dados:
* Cadastro de ingredientes utilizando tipages:
** Saldas
** Carnes
** Molhos
** Comuns : Pode ser utilizado para ovos.
** Queijos
** Especiais : Itens que anulam o desconto para lanches com salada.

## Implantação do sistema
Para este projeto utilizando VRaptor 4 - Framework MVC com injeção de dependência em CDI baseado em Spring com Banco de dados MySQL.
O início do projeto foi pensado em TDD para as principais features como cálculos dos requisitos.
Utilizamos os padrões MVC, Generics, Daos, EJB, Builders.
* MVC : Model View Controll - Separação de camadas.
* Generics : Reaproveitamento de funções para códigos repetitivos.
* Dao : Intefaces únicas de conexão com banco de dados.
* EJB : Entidades representativas do banco de dados.
* Builders : Classes que geram Entidades.

## Regras de Negócio

* Light : Se o lanche tem alface e não tem bacon, ganha 10% de desconto. Ou seja, caso tenha salada e não tenha nenhum item especial ganha 10% de desconto, somente se não participa de outras promoções.
* Muita carne : Se o lanche tem o triplo de carne então recebe um desconto progressivo!
* Muito queijo: Se o lanche tem o triplo de queijo recebe um desconto progressivo!
 
# Executing / Installing

## Setup de Conexão com banco de dados
Abra o arquivo src/main/resources/persistence.xml e configure a conexão production com os dados de seu banco de dados.
Caso seja necessário criar seu banco de dados, execute o /database.sql


## Compilando o arquivo
Para executar, enpacote o sistema e publique em um container web com o comando:
* mvn clean package


## Demais informações
* Cobertura de testes: $ mvn pmd:check
