# Ejercicio AlMundo - Call Center

## Tecnologias usadas
      
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

Dar alguna solución sobre qué pasa con una llamada cuando no hay
ningún empleado libre.
 `Cuando esto sucede si no se llego al maximo de llamadas 
 concurrentes procesadas, la llamada entra en una lista de espera`


Dar alguna solución sobre qué pasa con una llamada cuando entran
más de 10 llamadas concurrentes.
 `Si se llega al maximo de llamadas concurrentes, se emite un mensaje 
 diciendo que la llamada no puede ser procesada en este momento que intente mas tarde`


## Test Unitarios

clases de testeo: <br>

**DataRequestConcurrenciaTest**: 
La clase ya esta preparada para auto-ejecutarse concurrentemente la misma efectua  una serie de llamadas   

**DataRequestTestSimple**:
Clase que se ejecuta en un single Thread, pero que realiza las llamadas mediante algunos fors 


[Log de test](https://github.com/nicoxblues/callCenter/blob/master/main/test/app/log%20test.txt) 

## Como Funciona 
    
Cuando llega una solicitud de comunicacion se genera un objeto 'Context' , un objeto Context encapsulara un tipo de comunicacion con un empleado (Call, Chat, Personal,ticket mediante correo etc..) en el codigo solo 
esta implementado las 'calls'.
Existe un objeto Handler/Manager llamado TurnContextHandler, quien es el encargado de administrar todas las comunicaciones, este objeto 
crea, inicia , y  finaliza todas las comunicaciones que entran, es capaz de procesar 'n' comunicaciones concurrentemente, siendo 'n' una constante dentro del codigo
aunque podria escalar un poco más y ser un valor dentro de un archivo de configuracion, el handler tambien administra el time out de las llamadas 
Las comunicaciones trabajan con un sistema de estados basico, estas pueden estar en estado activo, en espera, o finalizado
Toda solicutud de comunicacion pasa por un objeto que implementa una interfaz CenterRequest, esto es asi, para dar versatidad a como iniciar la solicitud,
seria muy sencillo hacer algunas modificacoines para que las solicitudes llegan por medio de un Java Servlet o jsp , o una llamada ajax      
       
    



