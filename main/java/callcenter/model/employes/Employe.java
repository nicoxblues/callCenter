package callcenter.model.employes;

import callcenter.context.model.Context;

/**
 * Created by IntelliJ IDEA.
 * User: nico vidal
 * Date: 6/26/18.
 * Time: 3:23 PM.
 */
public abstract class Employe {


    private int priorityHierarchy;



    public int getPriorityHierarchy() {
        return priorityHierarchy;
    }

    public void setPriorityHierarchy(int priorityHierarchy) {
        this.priorityHierarchy = priorityHierarchy;
    }





    public void initCommunicationContext(Context dispatcherContext){


    }
}
