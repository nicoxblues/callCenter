package app.callcenter;

import app.callcenter.context.model.Context;
import app.callcenter.context.model.state.ContextFinishState;
import app.callcenter.context.model.state.ContextOnHoldState;
import app.callcenter.context.model.state.ContextStartState;
import app.callcenter.model.employes.Employe;
import app.callcenter.model.employes.constantes.EmployeCTE;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * Created by IntelliJ IDEA.
 * User: nico vidal
 * Date: 6/26/18.
 * Time: 3:34 PM.
 */


/**
*
*
 * Clase encargada de administrar las calls entrantes, le asigna un empleado inactivo segun prioridad y jerarquia,
 * de no encontrar un empleado disponible coloca la call en una lista de espera, ni bien finalice un call se le asignara el puesto
*
* **/

public class TurnContextHandler {


    private static TurnContextHandler turnContextHandler;

    private Queue<Context> onHoldQueue = new LinkedList<>();


    private HashMap<Integer,Queue<Employe>> idleEmployes;

    public static TurnContextHandler getInstance(){
        if (turnContextHandler == null){
            createInstance();
        }

        return turnContextHandler;

    }

    public void addEmploye(Employe employe){


        this.idleEmployes.get(employe.getPriorityHierarchy()).add(employe);
        this.assignContextFromWaitingRoom();

    }

    private static void createInstance (){
        turnContextHandler = new TurnContextHandler();
        turnContextHandler.idleEmployes = new HashMap<>();

        turnContextHandler.idleEmployes.put(EmployeCTE.EMPLOYE_JOB_TITLE_OPERADOR,new LinkedList<>());
        turnContextHandler.idleEmployes.put(EmployeCTE.EMPLOYE_JOB_TITLE_SUPRVISOR,new LinkedList<>());
        turnContextHandler.idleEmployes.put(EmployeCTE.EMPLOYE_JOB_TITLE_DIRECTOR,new LinkedList<>());


    }

    public void onHoldContext(Context context){

        context.setState(new ContextOnHoldState());
        context.doAction();

    }

    private void setTimeout(Context ctx, int delay){
        new Thread(() -> {
            try {
                Thread.sleep(delay * 1000);
                ctx.finish();
            }
            catch (Exception e){
                System.err.println("error en time out" +  e.getStackTrace());
            }
        }).start();
    }

    private int getContextDuration(){
        Random r = new Random();
        int Low = 5;
        int High = 10;
        return  r.nextInt(High-Low) + Low;
    }

    public void initContext(Context context){
        if (context.hasEmploye()){
            this.startContext(context);
            this.setTimeout(context,this.getContextDuration());

        }else
            this.onHoldContext(context);

    }

    public void startContext(Context context){

        context.setState(new ContextStartState());
        context.doAction();

    }

    private void assignContextFromWaitingRoom(){
        if (!this.onHoldQueue.isEmpty()) {
            Context ctx = this.onHoldQueue.poll();
            this.assignContext(ctx);
            assert ctx != null;
            //if (ctx.hasEmploye())
            ctx.init();
        }

    }

    /**
     *
     * finaliza un contexto y libera al empleado para que pueda atender otra solicitud
     *
     * */
    public void finishContext(Context context){

        System.out.println("********************\nInicio de la comunicacion " + context.getTimeStampInitContext());
        System.out.println("Fin de la comunicacion " + context.getTimeStampFinishContext() + "\n*********************");

        context.setState(new ContextFinishState());
        context.doAction();

        Employe freeEmploye = context.getContextOwnerEmploye();
        freeEmploye.freeTask();
        this.idleEmployes.get(freeEmploye.getPriorityHierarchy()).add(freeEmploye);

        this.assignContextFromWaitingRoom();



    }

    public void assignContext(Context context){


        Employe employe = findIdleEmploye();
        //context.setHandler(this);
        if (employe != null) {
            context.setEmploye(employe);
            employe.setCommunicationContext(context);

        }else
            this.onHoldQueue.add(context);




    }


    private Employe findIdleEmploye() {


            Employe employe = null;
        synchronized (this) {
            if (!this.idleEmployes.isEmpty()) {
                if (this.idleEmployes.get(EmployeCTE.EMPLOYE_JOB_TITLE_OPERADOR).peek() != null) {
                    employe = this.idleEmployes.get(EmployeCTE.EMPLOYE_JOB_TITLE_OPERADOR).poll();

                } else if (this.idleEmployes.get(EmployeCTE.EMPLOYE_JOB_TITLE_SUPRVISOR).peek() != null) {
                    employe = this.idleEmployes.get(EmployeCTE.EMPLOYE_JOB_TITLE_SUPRVISOR).poll();

                } else if (this.idleEmployes.get(EmployeCTE.EMPLOYE_JOB_TITLE_DIRECTOR).peek() != null) {
                    employe = this.idleEmployes.get(EmployeCTE.EMPLOYE_JOB_TITLE_DIRECTOR).poll();

                }

            }
        }
        return employe;
    }
}

