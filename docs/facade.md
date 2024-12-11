# Facade
## 💬 Intenção
O **Facade** é um padrão de projeto estrutural que fornece uma interface simplificada para uma biblioteca, um framework, ou qualquer conjunto complexo de classes.

## 😦 Problema
Imagine que você precisa fazer seu código funcionar com um amplo conjunto de objetos que pertencem a uma sofisticada biblioteca ou framework. Normalmente, você precisaria inicializar todos aqueles objetos, rastrear as dependências, executar métodos na ordem correta, e assim por diante.

Como resultado, a lógica de negócio de suas classes vai ficar firmemente acoplada aos detalhes de implementação das classes de terceiros, tornando difícil compreendê-lo e mantê-lo.

## 😊 Solução
Uma fachada é uma classe que fornece uma interface simples para um subsistema complexo que contém muitas partes que se movem. Uma fachada pode fornecer funcionalidades limitadas em comparação com trabalhar com os subsistemas diretamente. Contudo, ela inclui apenas aquelas funcionalidades que o cliente se importa.

Ter uma fachada é útil quando você precisa integrar sua aplicação com uma biblioteca sofisticada que tem dúzias de funcionalidades, mas você precisa de apenas um pouquinho delas.

Por exemplo, uma aplicação que carrega vídeos curtos engraçados com gatos para redes sociais poderia potencialmente usar uma biblioteca de conversão de vídeo profissional. Contudo, tudo que ela realmente precisa é uma classe com um único método `codificar(nomeDoArquivo, formato)`. Após criar tal classe e conectá-la com a biblioteca de conversão de vídeo, você terá sua primeira fachada.

## 💡 Aplicabilidade

**🐞Utilize o padrão Facade quando você precisa ter uma interface limitada mas simples para um subsistema complexo.**

⚡ Com o passar do tempo, subsistemas ficam mais complexos. Até mesmo aplicar padrões de projeto tipicamente leva a criação de mais classes. Um subsistema pode tornar-se mais flexível e mais fácil de se reutilizar em vários contextos, mas a quantidade de códigos padrão e de configuração que ele necessita de um cliente cresce cada vez mais. O Facade tenta consertar esse problema fornecendo um atalho para as funcionalidades mais usadas do subsistema que corresponde aos requerimentos do cliente.

**🐞Utilize o Facade quando você quer estruturar um subsistema em camadas.**

⚡ Crie fachadas para definir pontos de entrada para cada nível de um subsistema. Você pode reduzir o acoplamento entre múltiplos subsistemas fazendo com que eles se comuniquem apenas através de fachadas.

Por exemplo, vamos retornar ao nosso framework de conversão de vídeo. Ele pode ser quebrado em duas camadas: relacionados a vídeo e áudio. Para cada camada, você cria uma fachada e então faz as classes de cada camada se comunicarem entre si através daquelas fachadas. Essa abordagem se parece muito com o padrão Mediator.

## 📝 Como implementar
1. Verifique se é possível providenciar uma interface mais simples que a que o subsistema já fornece. Você está no caminho certo se essa interface faz o código cliente independente de muitas classes do subsistema.

2. Declare e implemente essa interface em uma nova classe fachada. A fachada deve redirecionar as chamadas do código cliente para os objetos apropriados do subsistema. A fachada deve ser responsável por inicializar o subsistema e gerenciar seu ciclo de vida a menos que o código cliente já faça isso.

3. Para obter o benefício pleno do padrão, faça todo o código cliente se comunicar com o subsistema apenas através da fachada. Agora o código cliente fica protegido de qualquer mudança no código do subsistema. Por exemplo, quando um subsistema recebe um upgrade para uma nova versão, você só precisa modificar o código na fachada.

4. Se a fachada ficar **grande demais**, considere extrair parte de seu comportamento para uma nova e refinada classe fachada.
