# mutants-challenge-api

Challenge de aplicación que contiene api que consulta si un humano es mutante.

INSTRUCCIONES DE USO DE API

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

INSTRUCCIONES PARA INSTALACION EN LOCAL

1. Instalar base de datos Mariadb: https://downloads.mariadb.org/ En lo personal prefiero instalar el paquete MSI "mariadb-10.5.10-winx64.msi"
2. Este instalador, valga la redundancia, instalará el cliente HeidiSQL, con este al abrir solo entrar como "root" clave "123456" para que sea identica 
a la del proyecto mutants-challenge-mercadolibre-api configurada en el properties
3. Crear base de datos llamada "mutants", el proyecto se encargara de la construccion de la tabla al inciar.
4. clonar ambos repositorios:

git clone https://github.com/juandmercadolopez/mutants-challenge-core.git
git clone https://github.com/juandmercadolopez/mutants-challenge-api.git

5. Abrir en Intellij proyecto mutants-challenge-mercadolibre-core
6. En el panel de gradle en el proyecto mutants-challenge-mercadolibre-core hacer clic en el boton "reload All Gradle Project" (si la construccion no se hizo automaticamente al abrir el proyecto en el IDE).
7. En el panel de gradle aplicar el comando gradle clean build (Prefiero esto antes que usar por la consola del IDE el gradlew)
8. En el panel de gradle ejecutar comando "gradle publishToMavenLocal", para publicar este proyecto como una libreria en un reposiotrio local. Despues de este paso ya se puede cerrar el IDE.

9. Abrir en Intellij proyecto mutants-challenge-mercadolibre-api
10. Si el proyecto no se construye automaticamente, repetir "6" para este proyecto, en este paso el soncroniza tambien con la libreria en el repositorio local.
11. Buscar clase principal de proyecto spring boot mutants-challenge-mercadolibre-api y arrancar la aplicacion.
- Para probar realizar los pasos de INSTRUCCIONES DE USO DE API con las sigientes URL:
 localhost:8080/mutant
 localhost:8080/stats
 




