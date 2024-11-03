# Tarefa de Sala - Pesquisar Cliente

Utilizando as classes do package cms no GITHUB, implementar na GUI ClienteGUI2 uma opção de Pesquisa de Cliente.

A Pesquisa do cliente deve obter um nome de cliente e procurar em todo arquivo. Como na GUI ClienteGUI2 apenas uma parte do arquivo está carregado, a pesquisa deve usar  o Buffer para realizar a pesquisa independente do que está sendo mostrado na GUI. 

O processo deve iniciar do início do arquivo e ir carregando blocos de tamanho 10000 registros. Realizar a pesquisa em cada bloco lido até encontrar o cliente pesquisado.  Após o cliente ser encontrado. Apresentar os dados do mesmo no jframe utilizado na pesquisa.

Lembre de utilizar a classe GeradorDeArquivosDeClientes para gerar arqvuivos de teste grandes (acima de 1 milhão de registros).