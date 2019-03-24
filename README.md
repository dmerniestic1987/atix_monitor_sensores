# Monitor de sensores para ATIX LABS
Este proyecto corresponde al ejercicio 2 de la evaluación técnica para ATIX LABS. 
Este proyecto utiliza Maven y Spring Boot. Por favor instalelos antes de intentar
ejecutar la aplicación.

## Instalación
Debe descargarse el código fuente de este repositorio
```
https://github.com/dmerniestic1987/atix_monitor_sensores.git
```
Luego debe generar el ejecutable de la aplicación
```
mvn install
```

Se creará la carpeta target con el ejecutable

## Ejecución del proyecto con JAR
Puede pasar los argumentos S (Diferencia entre valores Máximos o Mínimos) y M (Valor medio) de la siguiente forma: 
```
cd target
java -jar Monitor-0.0.1-SNAPSHOT.jar --S=875.50 --M=50
```

## Ingreso a la aplicación
Puede ingresar a la aplicación ingresando a [http://localhost:8080](http://localhost:8080)