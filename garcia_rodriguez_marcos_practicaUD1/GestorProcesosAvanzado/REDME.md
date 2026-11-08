# Gestión de Procesos

Aplicación Java para la ejecución y gestión de procesos de Windows.

## Compilación

Para compilarlo, he utilizado una herramienta que ofrece Netbeans, haciendo click derecho sobre el proyecto, en la opción "Clean and Build", que compila la clase EcoDatos a la que posteriormente accedo en build/classes.

## Ejecución

Mediante el botón visible en la parte superior, o haciendo uso de la tecla F6 que abrirá la salida de Netbeans.

**IMPORTANTE**
En mi caso, hay una tercera clase llamada "Entrada" que uso para pedir las entradas de teclado en lugar de utilizar el System.in, en primero nos la proporcionó José María y se me hace mucho más cómodo utilizarla.

## Posibilidades

Ejecutar tres utilidades diferentes de Windows, utilizando algún argumento que modifique su comportamiento, en mi caso:

- **whoami** - (Ver el usuario actual)
- **cmd** - (Abrir una web)
- **control** -  (Ejecutar un programa)

Ejecutar dos procesos ping -n 4, uno contra "www.microsoft.com" y otro contra "www.apple.com".

Mostrar las primeras líneas de la salida de cada ping y continuar consumiendo el resto de la salida para permitir que los procesos finalicen correctamente y no bloqueen la ejecución.

Consideraciones

El programa utiliza Process y Runtime.exec() para crear y controlar distintos procesos.

Los procesos que generan salida por la salida estándar deben ser leídos para evitar que el búfer se llene y provoque que el proceso quede bloqueado.
