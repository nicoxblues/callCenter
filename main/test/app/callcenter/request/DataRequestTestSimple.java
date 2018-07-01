package app.callcenter.request;

import app.callcenter.TurnContextHandler;
import app.callcenter.model.employes.Director;
import app.callcenter.model.employes.Employe;
import app.callcenter.model.employes.Operario;
import app.callcenter.model.employes.Supervisor;
import org.junit.Test;

import static org.junit.Assert.*;

public class DataRequestTestSimple {

    @Test
    public void prosessRequest() throws Exception {




        TurnContextHandler conHanlder = TurnContextHandler.getInstance();

        Employe op1 = new Operario(" Skinner 1");

        conHanlder.addEmploye(op1);
        conHanlder.addEmploye(new Operario(" Skinner 2"));
        conHanlder.addEmploye(new Operario(" Skinner 3"));
        conHanlder.addEmploye(new Operario(" Skinner 4"));
        conHanlder.addEmploye(new Operario(" Skinner 5"));
        conHanlder.addEmploye(new Operario(" Skinner 6"));

        conHanlder.addEmploye(new Supervisor(" Supervisor Commodore 64"));
        conHanlder.addEmploye(new Supervisor(" Supervisor Atlonx2 "));




        conHanlder.addEmploye(new Director(" archundia  "));
        conHanlder.addEmploye(new Director(" archundia 2 "));




        // llega un contex sin implementar, tira un error, diciendo que se desconoce el contexto a implementar

        CenterRequest data = new DataRequest();
        data.prosessRequest("Hola");

        // ***************

        // llega una llamada
        data.prosessRequest("call");

        // llega la siguiente llamada
        data.prosessRequest("call");

        // nos quedamos esperando , (las otras dos llamadas se siguen procesando  )
        Thread.sleep(3500);
        
        
        op1.finishContext(); // finalizo a la fuerza la llamada correspondiente a este empleado

        // llegan 10 llamadas, tienen que ser procesadas de manera concurrente, si aun hay llamadas siendo procesadas solo se procesaran hasta llegar a un
        // maximo de 10 llamadas concurrentes,a las restantes se le enviara una notificacion pidiendo que lo intenten  mas tarde

        System.out.println("*************** Entran 10 llamadas concurrentes ***************************");
        for (int i = 0; i < 10; i++) {
            data.prosessRequest("call");
        }





        // nos quedamos esperando a que terminen las demas llamadas
        Thread.sleep(41000);




    }
}
