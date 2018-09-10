# advertAPI
En esta pieza, me he decidido a realizarla usando los siguientes componentes: 
	* Maven. Es la herramienta de construcción de proyecto que mejor conozco.
	* Spring Boot 2.0.3. Debido al venir con servidor web endebido y la velocidad de ponerse a desarrollar.
	* MongoDB Endebido. He usado esta librería para la persistencia de datos y sinceramente, no lo conocía y me llamó la atención.
	* JSON.simple. Para la gestión del jSon con los datos de los anuncios.
	* Log4j2. Para todo lo relacionado con las trazas.

Al ser una aplicación con Spring Boot, solo hará falta ejecutar la clase com.marce.idealista.advertAPI.Application y se obtendrán estos tres endpoints:
	
	* http://localhost:8080/adverts -> Muestra todos los anuncios con la puntuación calculada.
	* http://localhost:8080/adverts/irrelevant -> Obtiene los anuncios irrelevantes con la fecha rellena.
	* http://localhost:8080/adverts/user -> Devolverá los anuncios que son relevantes para los usuarios ordenados por puntuación de mejor a peor.
