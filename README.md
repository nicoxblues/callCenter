# Ejercicio AlMundo - Call Center

## Tecnologías usadas
      
   - [JUnit](http://junit.org/junit5/)
   - [Java 1.8](https://www.oracle.com/index.html)
   - [Maven](https://maven.apache.org/)   
   - [Intellij IDEA](https://www.jetbrains.com/idea/) (IDE)
   - [Git](https://git-scm.com/)
   - [Gitkraken](https://www.gitkraken.com/) interfaz para git   
   
    
## Consigna

Existe un call center donde hay 3 tipos de empleados: operador, supervisor
y director. El proceso de la atención de una llamada telefónica en primera
instancia debe ser atendida por un operador, si no hay ninguno libre debe
ser atendida por un supervisor, y de no haber tampoco supervisores libres
debe ser atendida por un director.



## Extras/Plus

1 - Dar alguna solución sobre qué pasa con una llamada cuando no hay
ningún empleado libre.



2 - Dar alguna solución sobre qué pasa con una llamada cuando entran
más de 10 llamadas concurrentes.

## Respuestas

- 1\)  `Cuando esto sucede si no se llego al máximo de llamadas 
       concurrentes procesadas, la llamada entra en una lista de espera`
         
         
 - 2\) `Si se llega al máximo de llamadas concurrentes, se emite un mensaje 
 diciendo que la llamada no puede ser procesada en este momento que intente mas tarde`
 
  En ambas situaciones la clase que lo resuelve es "TurnContextHandler"

## Test Unitarios

Clases de testeo: <br>

**DataRequestConcurrenciaTest**: 
La clase ya esta preparada para auto-ejecutarse concurrente mente la misma efectúa  una serie de llamadas   

**DataRequestTestSimple**:
Clase que se ejecuta en un single Thread, pero que realiza las llamadas mediante algunos fors 


[Log de test](https://github.com/nicoxblues/callCenter/blob/master/main/test/app/log%20test.txt)
    este archivo se genero a mano a partir de la lo que el codigo escribe en consola, 
    TODO: se podria implementar [log4J](https://logging.apache.org/log4j/2.0/) aunque dado el tamaño de al app no era del todo necesario    

## Funcionamiento tecnico
    
Cuando llega una solicitud de comunicación se genera un objeto 'Context' , un objeto Context encapsulara un tipo de comunicación con un empleado (Call, Chat, Personal,Ticket mediante correo etc..) en el código solo 
esta implementado las 'calls'.
Existe un objeto Handler/Manager llamado TurnContextHandler, quien es el encargado de administrar todas las comunicaciones, este objeto 
crea, inicia , y  finaliza todas las comunicaciones que entran, es capaz de procesar 'n' comunicaciones concurrente mente, siendo 'n' una constante dentro del código
aunque podría escalar un poco más y ser un valor dentro de un archivo de configuración, el handler también administra el time out de las llamadas 
Las comunicaciones trabajan con un sistema de estados básico, estas pueden estar en estado activo, en espera, o finalizado
Toda solicitud de comunicación pasa por un objeto que implementa una interfaz CenterRequest, esto es así, para dar versatidad a como iniciar la solicitud,
seria muy sencillo hacer algunas modificaciones para que las solicitudes lleguen por medio de un Java Servlet o jsp , o una llamada ajax      
       
       
![GitHub Logo](https://i.ytimg.com/vi/zFBclVWaK_U/hqdefault.jpg)




