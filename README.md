# PRODUCT (CRUD TEST)
Este proyecto esta hecho con la intencion de demostrar el comportamiento basico de una aplicacion con comportamiento CRUDs (Create Read Update Delete).

# Tecnologias
- MVC
- JAVA 17
- Springboot 3.3.2
- Maven
- MySQL
- Bootstrap
- Thymeleaf 

# Detalles de implementacion
## SQL TABLE: products
|   Attribute	   |     Type	   |   NULLABLE	|  PK	|	Options |
|------|---------------|--------|-------|-------------------------|
|id	   |     bigint	   |   NO	|  YES	|	auto_increment |
|name |      varchar(255) |	NO			
|price |   	int | NO			
|sku |  	bigint | NO			
|is_seasonal |	tinyint(1) | YES			
|image |   varchar(255) | YES			
|quantity |  varchar(255) | YES			
|category |  varchar(255) | YES		

> csv migrado a sql, is_seasonal cambiado de true/false a 1/0