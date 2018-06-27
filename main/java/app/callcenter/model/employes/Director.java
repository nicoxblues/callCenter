package app.callcenter.model.employes;

import app.callcenter.model.employes.constantes.EmployeCTE;

/**
 * Created by IntelliJ IDEA.
 * User: nico vidal
 * Date: 6/26/18.
 * Time: 5:16 PM.
 */
public class Director extends Employe {

    public Director() {
        this.setPriorityHierarchy(EmployeCTE.EMPLOYE_JOB_TITLE_DIRECTOR);
    }
}
