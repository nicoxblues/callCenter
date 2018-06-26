package callcenter;

import callcenter.context.model.Context;
import callcenter.context.model.ContextOnHoldState;
import callcenter.model.employes.Employe;

import java.util.Vector;

/**
 * Created by IntelliJ IDEA.
 * User: nico vidal
 * Date: 6/26/18.
 * Time: 3:00 PM.
 */

public class Dispatcher {


    private Context dispatcherContext;
// TODO usar algo mejor que vector

    public static Vector<Context> onHoldQuote;



    public Dispatcher (Context DispatcherCtx ){

        this.dispatcherContext = DispatcherCtx;

    }


    public void dispatcherCall(){
        Employe idleEmploye =  TurnHandler.getInstance().findIdleEmploye();
        if (idleEmploye != null){
            idleEmploye.initCommunicationContext(this.dispatcherContext);
        }else{
            this.dispatcherContext.setState(new ContextOnHoldState());
            this.dispatcherContext.doAction();
            onHoldQuote.add(this.dispatcherContext);
        }



    }

}