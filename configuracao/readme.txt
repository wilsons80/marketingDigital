Tomcat
	1 - Configurar o arquivo webapp/META-INF/context.xml
		1.1 - Esse arquivo cont�m as configura��es de conex�o com o banco de dados (DATA-SOURCE) 

Wildfly
	1 - Fazer o deploy do arquivo mdigital-ds.xml na pasta standalone
		1.1 - Esse arquivo cont�m as configura��es de conex�o com o banco de dados (DATA-SOURCE) 
		1.2 - Excluir o arquivo webapp/META-INF/context.xml, pois esse arquivo � usado apenas pelo Tomcat
		
