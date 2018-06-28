package app.callcenter.model.employes;

import app.callcenter.context.model.Context;

/**
 * Created by IntelliJ IDEA.
 * User: nico vidal
 * Date: 6/26/18.
 * Time: 3:23 PM.
 */
public abstract class Employe {


    private int priorityHierarchy;

    private String name;

    private Context communicationContext;

    public Context getCommunicationContext() {
        return communicationContext;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCommunicationContext(Context communicationContext) {
        this.communicationContext = communicationContext;

    }

    public int getPriorityHierarchy() {
        return priorityHierarchy;
    }

    void setPriorityHierarchy(int priorityHierarchy) {
        this.priorityHierarchy = priorityHierarchy;
    }




    /**
     * To Override
     *
     * para agregar validaciones al momento de finlizar la comunicacion
     *
     *
     * */
    private boolean canFinish() {
        return true;
    }


    public void freeTask(){
        setCommunicationContext(null);
    }

    public void finishContext(){
        if (canFinish())
            this.communicationContext.finish();
    }

    public void initCommunicationContext(){
        this.communicationContext.init();



    }
}
