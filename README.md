csv migrado a sql, is_seasonal cambiado de true/false a 1/0


SQL TABLE: products
id	        bigint	      NO	  PRI		auto_increment
name	      varchar(255)	NO			
price      	int          	NO			
sku        	bigint      	NO			
is_seasonal	tinyint(1)  	YES			
image	      varchar(255)	YES			
quantity	  varchar(255)	YES			
category	  varchar(255)	YES			
