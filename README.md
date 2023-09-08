# [Alura Hotel](https://github.com/Marc0Franc0/Alura-Hotel#Alura-Hotel)
Este proyecto permite la gestión de reservas, permitiendo a los usuarios crear, 
editar y eliminar reservas, buscar información en la base de datos y gestionar los datos de los huéspedes.

## Características
- Sistema de autenticación de usuario
- CRUD para la entidades "Húesped", "Reserva" y "Usuario"

## Tecnologías
- Java
- Swing
- Maven
- Lombok
- MySQL

## Ejecución
1. Clonar repositorio:

```shell
git clone https://github.com/Marc0Franc0/Alura-Hotel
```
2. Ir al directorio del proyecto:

```shell
cd Alura-Hotel
```
3. Seguir pasos para ejecución con Maven

## Requerimientos para ejecutar con Maven

Para construir y ejecutar la aplicación necesita:
- [JDK 20+](https://www.oracle.com/java/technologies/downloads/#java20)
- [Maven 3+](https://maven.apache.org)

4. Debe crear una base de datos local MySQL con el nombre "hotel"

5. Ejecución en maquina local

```shell
mvn clean install package
```

```shell
cd target
```

```shell
 java -jar AluraHotel-1.0.0.jar
```