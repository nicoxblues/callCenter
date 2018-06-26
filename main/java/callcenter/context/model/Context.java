package callcenter.context.model;

import callcenter.model.employes.Employe;

/**
 * Created by IntelliJ IDEA.
 * User: nico vidal
 * Date: 6/26/18.
 * Time: 3:05 PM.
 */


/**
 *
 *
 * la idea seria que encapsular la comunicacion con un empleado dentro de un contexto, ya sea mdiante una call
 * , chat o hasta personal quien implemente la clase abstracta se dedicara a
 *
 *
 *
 */

public abstract class Context implements State {

    private State callState;

    private Employe contextOwnerEmploye;

    public void setEmploye(Employe employe){
        this.contextOwnerEmploye = employe;
    }

    public void setState(State state) {
        this.callState = state;
    }

    public State getState() {
        return this.callState;
    }

    protected abstract void executeAction();




    @Override
    public void doAction() {
        this.executeAction();

        this.callState.doAction();
    }

}
