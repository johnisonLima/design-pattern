# Decorator
## 💬 Intenção
O **Decorator** é um padrão de projeto estrutural que permite que você acople novos comportamentos para objetos ao colocá-los dentro de invólucros de objetos que contém os comportamentos.

## 😦 Problema

Imagine que você está trabalhando em um biblioteca de notificação que permite que outros programas notifiquem seus usuários sobre eventos importantes.

A versão inicial da biblioteca foi baseada na classe `Notificador` que tinha apenas alguns poucos campos, um construtor, e um único método `enviar`. O método podia aceitar um argumento de mensagem de um cliente e enviar a mensagem para uma lista de emails que eram passadas para o notificador através de seu construtor. Uma aplicação de terceiros que agia como cliente deveria criar e configurar o objeto notificador uma vez, e então usá-lo a cada vez que algo importante acontecesse.

Em algum momento você se dá conta que os usuários da biblioteca esperam mais que apenas notificações por email. Muitos deles gostariam de receber um SMS acerca de problemas críticos. Outros gostariam de ser notificados no Facebook, e, é claro, os usuários corporativos adorariam receber notificações do Slack.

Quão difícil isso seria? Você estende a classe `Notificador` e coloca os métodos de notificação adicionais nas novas subclasses. Agora o cliente deve ser instanciado à classe de notificação que deseja e usar ela para todas as futura notificações.

Mas então alguém, com razão, pergunta a você, “Por que você não usa diversos tipos de notificação de uma só vez? Se a sua casa pegar fogo, você provavelmente vai querer ser notificado por todos os canais.”

Você tenta resolver esse problema criando subclasses especiais que combinam diversos tipos de métodos de notificação dentro de uma classe. Contudo, rapidamente você nota que isso irá inflar o código imensamente, e não só da biblioteca, o código cliente também.

Você precisa encontrar outra maneira de estruturar classes de notificação para que o número delas não quebre um recorde do Guinness acidentalmente.

## 😊 Solução

Estender uma classe é a primeira coisa que vem à mente quando você precisa alterar o comportamento de um objeto. Contudo, a herança vem com algumas ressalvas sérias que você precisa estar ciente.

* A herança é estática. Você não pode alterar o comportamento de um objeto existente durante o tempo de execução. Você só pode substituir todo o objeto por outro que foi criado de uma subclasse diferente.

* As subclasses só podem ter uma classe pai. Na maioria das linguagens, a herança não permite que uma classe herde comportamentos de múltiplas classes ao mesmo tempo.

Uma das maneiras de superar essas ressalvas é usando Agregação ou Composição  ao invés de Herança. Ambas alternativas funcionam quase da mesma maneira: um objeto tem uma referência com outro e delega alguma funcionalidade, enquanto que na herança, o próprio objeto é capaz de fazer a função, herdando o comportamento da sua superclasse.

Com essa nova abordagem você pode facilmente substituir o objeto “auxiliador” por outros, mudando o comportamento do contêiner durante o tempo de execução. Um objeto pode usar o comportamento de várias classes, ter referências a múltiplos objetos, e delegar qualquer tipo de trabalho a eles. A agregação/composição é o princípio chave por trás de muitos padrões de projeto, incluindo o Decorator. Falando nisso, vamos voltar à discussão desse padrão.

“Envoltório” (ing. _“wrapper”_) é o apelido alternativo para o padrão Decorator que expressa claramente a ideia principal dele. Um envoltório é um objeto que pode ser ligado com outro objeto alvo. O envoltório contém o mesmo conjunto de métodos que o alvo e delega a ele todos os pedidos que recebe. Contudo, o envoltório pode alterar o resultado fazendo alguma coisa ou antes ou depois de passar o pedido para o alvo.

Quando um simples envoltório se torna um verdadeiro decorador? Como mencionei, o envoltório implementa a mesma interface que o objeto envolvido. É por isso que da perspectiva do cliente esses objetos são idênticos. Faça o campo de referência do envoltório aceitar qualquer objeto que segue aquela interface. Isso lhe permitirá cobrir um objeto em múltiplos envoltórios, adicionando o comportamento combinado de todos os envoltórios a ele.

No nosso exemplo de notificações vamos deixar o simples comportamento de notificação por email dentro da classe `Notificador` base, mas transformar todos os métodos de notificação em decoradores.

O código cliente vai precisar envolver um objeto notificador básico em um conjunto de decoradores que coincidem com as preferências do cliente. Os objetos resultantes serão estruturados como uma pilha.

O último decorador na pilha seria o objeto que o cliente realmente trabalha. Como todos os decoradores implementam a mesma interface que o notificador base, o resto do código cliente não quer saber se ele funciona com o objeto “puro” do notificador ou do decorador.

Podemos utilizar a mesma abordagem para vários comportamentos tais como formatação de mensagens ou compor uma lista de recipientes. O cliente pode decorar o objeto com quaisquer decoradores customizados, desde que sigam a mesma interface que os demais.

## 💡 Aplicabilidade

**🐞 Utilize o padrão Decorator quando você precisa ser capaz de projetar comportamentos adicionais para objetos em tempo de execução sem quebrar o código que usa esses objetos.**

⚡ Decorator lhe permite estruturar sua lógica de negócio em camadas, criar um decorador para cada camada, e compor objetos com várias combinações dessa lógica durante a execução. O código cliente pode tratar de todos esses objetos da mesma forma, como todos seguem a mesma interface comum.

**🐞Utilize o padrão quando é complicado ou impossível estender o comportamento de um objeto usando herança.**

⚡Muitas linguagens de programação tem a palavra chave `final` que pode ser usada para prevenir a extensão de uma classe. Para uma classe final, a única maneira de reutilizar seu comportamento existente seria envolver a classe com seu próprio invólucro usando o padrão Decorator.

## 📝 Como implementar
1. Certifique-se que seu domínio de negócio pode ser representado como um componente primário com múltiplas camadas opcionais sobre ele.

2. Descubra quais métodos são comuns tanto para o componente primário e para as camadas opcionais. Crie uma interface componente e declare aqueles métodos ali.

3. Crie uma classe componente concreta e defina o comportamento base nela.

4. Crie uma classe decorador base. Ela deve ter um campo para armazenar uma referência ao objeto envolvido. O campo deve ser declarado com o tipo da interface componente para permitir uma ligação entre os componentes concretos e decoradores. O decorador base deve delegar todo o trabalho para o objeto envolvido.

5. Certifique-se que todas as classes implementam a interface componente.

6. Crie decoradores concretos estendendo-os a partir do decorador base. Um decorador concreto deve executar seu comportamento antes ou depois da chamada para o método pai (que sempre delega para o objeto envolvido).

7. O código cliente deve ser responsável por criar decoradores e compô-los do jeito que o cliente precisa.