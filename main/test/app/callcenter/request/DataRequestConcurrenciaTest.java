package app.callcenter.request;

import app.callcenter.TurnContextHandler;
import app.callcenter.model.employes.Director;
import app.callcenter.model.employes.Employe;
import app.callcenter.model.employes.Operario;
import app.callcenter.model.employes.Supervisor;
import com.anarsoft.vmlens.concurrent.junit.ConcurrentTestRunner;
import com.anarsoft.vmlens.concurrent.junit.ThreadCount;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;


@RunWith(ConcurrentTestRunner.class)
public class DataRequestConcurrenciaTest {

    private int count = 0;

    @Before
    public void initialCount() throws Exception {

        TurnContextHandler conHanlder = TurnContextHandler.getInstance();
        Employe op1 = new Operario("jaime");
        conHanlder.addEmploye(op1);
        conHanlder.addEmploye(new Operario(" Skinner 1"));
        conHanlder.addEmploye(new Operario(" Skinner 2"));
        conHanlder.addEmploye(new Operario(" Skinner 3"));
        conHanlder.addEmploye(new Operario(" Skinner 4"));
        conHanlder.addEmploye(new Operario(" Skinner 5"));
        conHanlder.addEmploye(new Operario(" Skinner 6"));

        conHanlder.addEmploye(new Supervisor(" Supervisor Commodore 64"));
        conHanlder.addEmploye(new Supervisor(" Supervisor Atlonx2 "));




        conHanlder.addEmploye(new Director(" archundia  "));
        conHanlder.addEmploye(new Director(" archundia 2 "));


        // llega un contex sin implementar

        CenterRequest data = new DataRequest();
        data.prosessRequest("Hola");


    }

    @Test
    @ThreadCount(10)
    public void prosessRequest() throws InterruptedException {


        CenterRequest data = new DataRequest();



       // llegan las primeras 5 llamadas (concurrentes)
        data.prosessRequest("call");


        Thread.sleep(10000);


        // Despues de dos segundos llegan las siguientes 10, no deberia haber problemas ni errores
        data.prosessRequest("call");




        Thread.sleep(6500);
        // a apartir de aca empieza a lanzar la excepcion java.util.concurrent.RejectedExecutionException: Todos Nuestros Operadores estan ocupados, por favor intente nuevamente mas tarde
        // a menos que se libere un empleado, ahi se le asignara la llamada
        data.prosessRequest("call");

        Thread.sleep(6500);
        
        data.prosessRequest("call");


        // nos quedamos esperando a que terminen las demas llamadas
        Thread.sleep(31000);




    }

    @After
    public void testCount() {
        //assertEquals("Value should be 7", 7, counter.getCount());
    }



}