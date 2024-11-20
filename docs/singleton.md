# Singleton
## 💬 Intenção
Singleton é um padrão de design de criação que permite garantir que uma classe tenha apenas uma instância, ao mesmo tempo em que fornece um ponto de acesso global a essa instância.

## 😦 Problema
_O padrão Singleton resolve dois problemas ao mesmo tempo, violando o Princípio de Responsabilidade Única:_

1. **Certifique-se de que uma classe tenha apenas uma única instância.** Por que alguém iria querer controlar quantas instâncias uma classe tem? O motivo mais comum para isso é controlar o acesso a algum recurso compartilhado, por exemplo, um banco de dados ou um arquivo.

Veja como funciona: imagine que você criou um objeto, mas depois de um tempo decidiu criar um novo. Em vez de receber um novo objeto, você receberá o que já criou.

Observe que esse comportamento é impossível de implementar com um construtor regular, pois uma chamada de construtor deve sempre retornar um novo objeto por design.

2. **Forneça um ponto de acesso global a essa instância.** Lembra daquelas variáveis globais que você (tudo bem, eu) usou para armazenar alguns objetos essenciais? Embora sejam muito úteis, também são muito inseguros, pois qualquer código pode substituir o conteúdo dessas variáveis e travar o aplicativo.

Assim como uma variável global, o padrão Singleton permite acessar algum objeto de qualquer lugar do programa. No entanto, ele também protege essa instância de ser substituída por outro código.

Há outro lado desse problema: você não quer que o código que resolve o problema #1 seja espalhado por todo o seu programa. É muito melhor tê-lo dentro de uma classe, especialmente se o restante do seu código já depender dele.

## 😊 Solução
Todas as implementações do Singleton têm estas duas etapas em comum:

* Torne o construtor padrão privado, para impedir que outros objetos usem o operador com a classe Singleton. ` new `
* Crie um método de criação estático que atue como um construtor. Nos bastidores, esse método chama o construtor privado para criar um objeto e o salva em um campo estático. Todas as chamadas a seguir para esse método retornam o objeto armazenado em cache.
Se o código tiver acesso à classe Singleton, ele poderá chamar o método estático do Singleton. Portanto, sempre que esse método é chamado, o mesmo objeto é sempre retornado.

## 💡 Aplicabilidade

**🐞 Use o padrão Singleton quando uma classe em seu programa deve ter apenas uma única instância disponível para todos os clientes; por exemplo, um único objeto de banco de dados compartilhado por diferentes partes do programa.**

⚡O padrão Singleton desativa todos os outros meios de criação de objetos de uma classe, exceto o método de criação especial. Esse método cria um novo objeto ou retorna um existente se ele já tiver sido criado.

**🐞Use o padrão Singleton quando precisar de um controle mais rigoroso sobre variáveis globais.**

⚡Ao contrário das variáveis globais, o padrão Singleton garante que haja apenas uma instância de uma classe. Nada, exceto a própria classe Singleton, pode substituir a instância armazenada em cache.

Observe que você sempre pode ajustar essa limitação e permitir a criação de qualquer número de instâncias Singleton. A única parte do código que precisa ser alterada é o corpo do método. `getInstance`.

## 📝 Como implementar
1. Adicione um campo estático privado à classe para armazenar a instância singleton.

2. Declare um método de criação estático público para obter a instância singleton.

3. Implemente a "inicialização lenta" dentro do método estático. Ele deve criar um novo objeto em sua primeira chamada e colocá-lo no campo estático. O método sempre deve retornar essa instância em todas as chamadas subsequentes.

4. Torne o construtor da classe privado. O método estático da classe ainda será capaz de chamar o construtor, mas não os outros objetos.

5. Examine o código do cliente e substitua todas as chamadas diretas para o construtor do singleton por chamadas para seu método de criação estática.