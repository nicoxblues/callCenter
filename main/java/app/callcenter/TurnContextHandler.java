package app.callcenter;

import app.callcenter.context.model.Context;
import app.callcenter.context.model.state.ContextFinishState;
import app.callcenter.context.model.state.ContextOnHoldState;
import app.callcenter.context.model.state.ContextStartState;
import app.callcenter.model.employes.Employe;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by IntelliJ IDEA.
 * User: nico vidal
 * Date: 6/26/18.
 * Time: 3:34 PM.
 */


public class TurnContextHandler {

    //private ArrayList activeEmployesList;
    private static TurnContextHandler turnContextHandler;

    private Queue<Context> onHoldQueue = new LinkedList<>();


    private HashMap<Integer,Queue<Employe>> idleEmployes;

    static TurnContextHandler getInstance(){
        if (turnContextHandler != null){
            createInstance();
        }

        return turnContextHandler;

    }


    private static void createInstance (){
        turnContextHandler = new TurnContextHandler();
        turnContextHandler.idleEmployes = new HashMap<>();


    }

    public void onHoldContext(Context context){

        context.setState(new ContextOnHoldState());
        context.doAction();
        
    }

    public void startContext(Context context){
        context.setState(new ContextStartState());
        context.doAction();

    }

    private void waitingRoom(){
        Context ctx = this.onHoldQueue.poll();
        this.assignContext(ctx);
        assert ctx != null;
        if (ctx.getContextOwnerEmploye() != null)
            ctx.start();

    }


    public void finishContext(Context context){
        context.setState(new ContextFinishState());
        context.doAction();

        Employe freeEmploye = context.getContextOwnerEmploye();
        freeEmploye.freeTask();
        this.idleEmployes.get(freeEmploye.getPriorityHierarchy()).add(freeEmploye);

        waitingRoom();
    }

    public void assignContext(Context context){


        Employe employe = findIdleEmploye();
        if (employe != null) {
            context.setHandler(this);

            employe.setCommunicationContext(context);
        }else
            this.onHoldQueue.add(context);




    }


    private Employe findIdleEmploye() {
        Employe employe = null;
        if (this.idleEmployes.get(1).peek() != null){
            employe = this.idleEmployes.get(1).poll();
        }
        if (this.idleEmployes.get(2).peek() != null){
            employe = this.idleEmployes.get(2).poll();
        }
        if (this.idleEmployes.get(3).peek() != null){
            employe = this.idleEmployes.get(3).poll();
        }


        return employe;
    }
}

