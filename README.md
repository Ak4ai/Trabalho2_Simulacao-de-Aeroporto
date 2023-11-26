# Simulação de Aeroporto

Este projeto consiste em uma simulação do funcionamento de um aeroporto utilizando Java, com ênfase em orientação a objetos, listas e filas.

## Descrição

O programa simula o funcionamento de um aeroporto, considerando diferentes condições climáticas e priorização de aterrissagens, utilizando listas e filas para organizar as aeronaves nas pistas de aterrissagem e decolagem.

## Funcionalidades

- Cadastro manual de aviões com informações como quantidade de passageiros, companhia aérea, nível de combustível e estado de emergência.
- Leitura de aviões a partir de um arquivo de entrada.
- Geração aleatória de aviões para simulação.
- Organização das aeronaves nas filas de aterrissagem e decolagem.
- Verificação do estado do clima (ensolarado ou nublado) e consideração de emergências com base nele.
- Cálculo do tempo médio de espera nas filas de aterrissagem e decolagem.
- Identificação de situações críticas, como aterrissagem de emergência por falta de combustível.

## Estrutura do Projeto

- `MainAviao.java`: Arquivo principal contendo a lógica principal da simulação.
- `Pista.java`: Classe que representa uma pista do aeroporto, com métodos para manipular filas de aviões.

## Como Executar

### Pré-requisitos

- Java JDK instalado na máquina.

### Execução

1. Clone este repositório para o seu ambiente local.
2. Compile o código-fonte usando o comando `javac MainAviao.java Pista.java`.
3. Execute o programa com o comando `java MainAviao`.

## Contribuição

Contribuições são bem-vindas! Sinta-se à vontade para abrir issues relatando problemas ou enviar pull requests com melhorias.

## Autores

- Joao Pedro Rodrigues
- Henrique de Freitas Araújo

## Licença

Este projeto está licenciado sob a [Licença XYZ](link para a licença).
