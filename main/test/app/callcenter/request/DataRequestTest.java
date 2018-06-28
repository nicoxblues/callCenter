package test.app.callcenter.request;

import callcenter.TurnContextHandler;
import app.callcenter.model.employes.Director;
import app.callcenter.model.employes.Employe;
import app.callcenter.model.employes.Operario;
import com.anarsoft.vmlens.concurrent.junit.ConcurrentTestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(ConcurrentTestRunner.class)
public class DataRequestTest {

    @Test
    public void prosessRequest() {

        // llega un contex que el codigo no tiene implementado
        CenterRequest data = new DataRequest();
        data.prosessRequest("hola");

        // caso de uso normal, entra una llamada, y hay un operario y un director para atenderla
        TurnContextHandler conHanlder = TurnContextHandler.getInstance();
        conHanlder.addEmploye(new Operario("pepe"));
        conHanlder.addEmploye(new Director(" Skinner"));
        data.prosessRequest("call");

        data.prosessRequest("call");
        Employe op1 = new Operario("jaime");
        conHanlder.addEmploye(op1);

        data.prosessRequest("call");
        data.prosessRequest("call");
        op1.finishContext();



    }
}