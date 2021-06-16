# mutants-challenge-api

Challenge de aplicación que contiene api que consulta si un humano es mutante.

Intrucciones de uso de Api

1. Instalar un cliente como postman
2. Si se va a probar el servicio de verificacion de ADN se debe configurar el cliente en metodo POST y poner la URL http://54.152.97.161:8080/mutant
3. En el body enviar json, algunos ejemplos pueden ser:

- Para un ADN mutante:

{"dna":["ATGCGA","CAGTGC","TGATGT","AGTGGC","CCCCTA","TCACTA"]} - Responde con status 200

- Para un ADN de humano comun:

{"dna":["ATGCGA","CAGTGC","TGATGT","AGTGGC","CACCTA","TCACTA"]} Responde con status 403

- Para secuencias de ADN invalidas: Estas secuencias no se guardan en la base de datos, ya que son invalidas

{"dna":["ATGCGA","CAGTGC","TGATGT","AGTGGC","CACCTA","TCACTZ"]} Responde con status 500

{"dna":["ATGCGA","CAGTGC","TGATGT","AGTGGC","CACCTA"]} Responde con status 500

{"dna":["ATGCGA","CAGTGC","TGATGT","AGTGGC","CACCTA","CCCCTA","CCCCTA"]} Responde con status 500

4. Para utilizar el servicio de estadisticas se configura en el cliente un metodo GET y se invoca la URL: http://54.152.97.161:8080/stats



