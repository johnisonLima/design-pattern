# Factory 
## 💬 Intenção
**Factory Method** é um padrão de design criacional que fornece uma interface para criar objetos em uma superclasse, mas permite que as subclasses alterem o tipo de objetos que serão criados.

## 😦 Problema
_Imagine que você está criando um aplicativo de gerenciamento de logística. A primeira versão do seu aplicativo só pode lidar com o transporte por caminhões, portanto, a maior parte do seu código reside dentro da classe. `Truck`

Depois de um tempo, seu aplicativo se torna bastante popular. Todos os dias você recebe dezenas de solicitações de empresas de transporte marítimo para incorporar a logística marítima ao aplicativo._

Ótimas notícias, certo? Mas e o código? No momento, a maior parte do seu código está acoplada à classe. Adicionar ao aplicativo exigiria fazer alterações em toda a base de código. Além disso, se mais tarde você decidir adicionar outro tipo de transporte ao aplicativo, provavelmente precisará fazer todas essas alterações novamente.`Truck` `Ships`

Como resultado, você acabará com um código bastante desagradável, repleto de condicionais que alteram o comportamento do aplicativo dependendo da classe de objetos de transporte.

1. **Certifique-se de que uma classe tenha apenas uma única instância.** Por que alguém iria querer controlar quantas instâncias uma classe tem? O motivo mais comum para isso é controlar o acesso a algum recurso compartilhado, por exemplo, um banco de dados ou um arquivo.

Veja como funciona: imagine que você criou um objeto, mas depois de um tempo decidiu criar um novo. Em vez de receber um novo objeto, você receberá o que já criou.

Observe que esse comportamento é impossível de implementar com um construtor regular, pois uma chamada de construtor deve sempre retornar um novo objeto por design.

2. **Forneça um ponto de acesso global a essa instância.** Lembra daquelas variáveis globais que você (tudo bem, eu) usou para armazenar alguns objetos essenciais? Embora sejam muito úteis, também são muito inseguros, pois qualquer código pode substituir o conteúdo dessas variáveis e travar o aplicativo.

Assim como uma variável global, o padrão Singleton permite acessar algum objeto de qualquer lugar do programa. No entanto, ele também protege essa instância de ser substituída por outro código.

Há outro lado desse problema: você não quer que o código que resolve o problema #1 seja espalhado por todo o seu programa. É muito melhor tê-lo dentro de uma classe, especialmente se o restante do seu código já depender dele.

## 😊 Solução
O padrão Factory Method sugere que você substitua chamadas diretas de construção de objeto (usando o operador) por chamadas para um método de fábrica especial. Não se preocupe: os objetos ainda são criados por meio do operador, mas estão sendo chamados de dentro do método de fábrica. Os objetos retornados por um método de fábrica são frequentemente chamados de produtos `new` `new`.

À primeira vista, essa mudança pode parecer inútil: acabamos de mover a chamada do construtor de uma parte do programa para outra. No entanto, considere o seguinte: agora você pode substituir o método de fábrica em uma subclasse e alterar a classe de produtos que está sendo criada pelo método.

No entanto, há uma pequena limitação: as subclasses podem retornar diferentes tipos de produtos somente se esses produtos tiverem uma classe ou interface base comum. Além disso, o método de fábrica na classe base deve ter seu tipo de retorno declarado como essa interface.

Por exemplo, as classes e devem implementar a interface, que declara um método chamado . Cada classe implementa esse método de maneira diferente: caminhões entregam carga por terra, navios entregam carga por mar. O método de fábrica na classe retorna objetos de caminhão, enquanto o método de fábrica na classe retorna navios. `Truck` `Ship` `Transport` `deliver` `RoadLogistics` `SeaLogistics`

O código que usa o método de fábrica (geralmente chamado de código do cliente) não vê uma diferença entre os produtos reais retornados por várias subclasses. O cliente trata todos os produtos como abstratos. O cliente sabe que todos os objetos de transporte devem ter o método, mas exatamente como ele funciona não é importante para o cliente. `Transport deliver`

## 💡 Aplicabilidade

**🐞 Use o Método Factory quando você não souber de antemão os tipos e dependências exatos dos objetos com os quais seu código deve funcionar.**

⚡ O Método de Fábrica separa o código de construção do produto do código que realmente usa o produto. Portanto, é mais fácil estender o código de construção do produto independentemente do restante do código.

Por exemplo, para adicionar um novo tipo de produto ao aplicativo, você só precisará criar uma nova subclasse de criador e substituir o método de fábrica nela.

**🐞Use o Método de Fábrica quando quiser fornecer aos usuários de sua biblioteca ou estrutura uma maneira de estender seus componentes internos.**

⚡ A herança é provavelmente a maneira mais fácil de estender o comportamento padrão de uma biblioteca ou estrutura. Mas como o framework reconheceria que sua subclasse deveria ser usada em vez de um componente padrão?

A solução é reduzir o código que constrói componentes em toda a estrutura em um único método de fábrica e permitir que qualquer pessoa substitua esse método, além de estender o próprio componente.

Vamos ver como isso funcionaria. Imagine que você escreve um aplicativo usando uma estrutura de interface do usuário de software livre. Seu aplicativo deve ter botões redondos, mas a estrutura fornece apenas botões quadrados. Você estende a classe padrão com uma subclasse gloriosa. Mas agora você precisa dizer à classe principal para usar a nova subclasse de botão em vez de uma padrão. `Button RoundButton UIFramework`

Para conseguir isso, você cria uma subclasse a partir de uma classe de estrutura base e substitui seu método. Embora esse método retorne objetos na classe base, você faz com que sua subclasse retorne objetos. Agora use a classe em vez de . E é isso! `UIWithRoundButtons createButton Button RoundButton UIWithRoundButtons UIFramework`

**🐞 Use o Método Factory quando quiser economizar recursos do sistema reutilizando objetos existentes em vez de reconstruí-los a cada vez.**

⚡ Muitas vezes, você experimenta essa necessidade ao lidar com objetos grandes e com uso intensivo de recursos, como conexões de banco de dados, sistemas de arquivos e recursos de rede.

Vamos pensar sobre o que deve ser feito para reutilizar um objeto existente:

1. Primeiro, você precisa criar algum armazenamento para acompanhar todos os objetos criados.
2. Quando alguém solicita um objeto, o programa deve procurar um objeto livre dentro desse pool.
3. … e, em seguida, retorne-o ao código do cliente.
4. Se não houver objetos livres, o programa deve criar um novo (e adicioná-lo ao pool).

Isso é muito código! E tudo deve ser colocado em um único lugar para que você não polua o programa com código duplicado.

Provavelmente, o lugar mais óbvio e conveniente onde esse código pode ser colocado é o construtor da classe cujos objetos estamos tentando reutilizar. No entanto, um construtor sempre deve retornar **novos objetos** por definição. Ele não pode retornar instâncias existentes.

Portanto, você precisa ter um método regular capaz de criar novos objetos, bem como reutilizar os existentes. Isso soa muito como um método de fábrica.


## 📝 Como implementar
1. Faça com que todos os produtos sigam a mesma interface. Essa interface deve declarar métodos que fazem sentido em todos os produtos.

2. Adicione um método de fábrica vazio dentro da classe creator. O tipo de retorno do método deve corresponder à interface comum do produto.

3. No código do criador, encontre todas as referências a construtores de produtos. Um por um, substitua-os por chamadas para o método de fábrica, enquanto extrai o código de criação do produto para o método de fábrica.

Talvez seja necessário adicionar um parâmetro temporário ao método de fábrica para controlar o tipo de produto devolvido.

Neste ponto, o código do método de fábrica pode parecer muito feio. Ele pode ter uma instrução grande que escolhe qual classe de produto instanciar. Mas não se preocupe, vamos consertar isso em breve. `switch`

4. Agora, crie um conjunto de subclasses de criadores para cada tipo de produto listado no método de fábrica. Substitua o método de fábrica nas subclasses e extraia os bits apropriados do código de construção do método base.

5. Se houver muitos tipos de produtos e não fizer sentido criar subclasses para todos eles, você poderá reutilizar o parâmetro de controle da classe base em subclasses.

Por exemplo, imagine que você tenha a seguinte hierarquia de classes: a classe base com algumas subclasses: e ; As classes são , e . Embora a classe use apenas objetos, pode funcionar com objetos e . Você pode criar uma nova subclasse (digamos) para lidar com os dois casos, mas há outra opção. O código do cliente pode passar um argumento para o método de fábrica da classe para controlar qual produto ele deseja receber. `Mail AirMail GroundMail Transport Plane Truck Train AirMail Plane GroundMail Truck Train TrainMail GroundMail`

6. Se, após todas as extrações, o método base factory ficar vazio, você poderá torná-lo abstrato. Se sobrar algo, você pode torná-lo um comportamento padrão do método.