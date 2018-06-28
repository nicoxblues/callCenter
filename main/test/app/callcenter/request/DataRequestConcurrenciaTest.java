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


    @Before
    public void initialCount() {

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
      /*  conHanlder.addEmploye(new Director(" Skinner 5"));
        conHanlder.addEmploye(new Director(" Skinner 6"));
        conHanlder.addEmploye(new Director(" Skinner 7"));
        conHanlder.addEmploye(new Director(" Skinner 8"));
        conHanlder.addEmploye(new Director(" Skinner 9"));
*/


    }

    @Test
    @ThreadCount(10)
    public void prosessRequest() throws InterruptedException {

        // llega un contex que el codigo no tiene implementado
        CenterRequest data = new DataRequest();
    //    data.prosessRequest("hola");


        data.prosessRequest("call");



       Thread.sleep(20000);


    }

    @After
    public void testCount() {
        //assertEquals("Value should be 7", 7, counter.getCount());
    }



}