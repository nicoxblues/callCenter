package app.callcenter.context.model;

import app.callcenter.TurnContextHandler;
import app.callcenter.context.model.state.State;
import app.callcenter.model.employes.Employe;
import java.sql.Timestamp;



/**
 * Created by IntelliJ IDEA.
 * User: nico vidal
 * Date: 6/26/18.
 * Time: 3:05 PM.
 */


/**
 *
 *
 * encapsula la comunicacion con un empleado dentro de un contexto, ya sea mediante una call,un chat o hasta en persona;
 * quien implemente la clase abstracta implementara la manera de trabajar con ese tipo de contexto.
 * ejemplo ,una call {@link  app.callcenter.context.model.call.CallContext}
 *
 *
 *
 */

public abstract class Context implements State {

    private State callState;

    private Employe contextOwnerEmploye;

    private Timestamp timeStampInitContext;
    private Timestamp timeStampFinishContext;

    protected abstract void executeAction();

    protected abstract void initCommunication();


    public void setEmploye(Employe employe){
        this.contextOwnerEmploye = employe;
    }

    public Employe getContextOwnerEmploye() {
        return contextOwnerEmploye;
    }

    public boolean hasEmploye(){
        return  this.contextOwnerEmploye != null;
    }

    public void setState(State state) {
        this.callState = state;
    }

    public State getState() {
        return this.callState;
    }

    public Timestamp getTimeStampInitContext() {
        return timeStampInitContext;
    }

    public void setTimeStampInitContext(Timestamp timeStampInitContext) {
        this.timeStampInitContext = timeStampInitContext;
    }

    public Timestamp getTimeStampFinishContext() {
        return timeStampFinishContext;
    }

    public void setTimeStampFinishContext(Timestamp timeStampFinishContext) {
        this.timeStampFinishContext = timeStampFinishContext;
    }

    @Override
    public void doAction() {
        this.executeAction();
        if (hasEmploye())
            System.out.println("Contexto empleado " + this.contextOwnerEmploye.getName()  +  " de jerarquia " + this.contextOwnerEmploye.getPriorityHierarchy());
        else
            System.out.println("Contexto sin empleado asignado " );

        this.callState.doAction();
    }

    public void init(){
        this.timeStampInitContext = new Timestamp(System.currentTimeMillis());
        TurnContextHandler.getInstance().initContext(this);

    }

    public void finish() {
        this.timeStampFinishContext = new Timestamp(System.currentTimeMillis());
        TurnContextHandler.getInstance().finishContext(this);
    }
}
