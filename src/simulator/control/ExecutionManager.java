package simulator.control;

import simulator.control.interfaces.IExecutionManager;
import simulator.model.ArchitectureDescription;
import simulator.model.SystemProfile;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * 
 */
public class ExecutionManager implements IExecutionManager {

    private SimulatorProxy proxy;
    static int index = 0;

    private ArchitectureDescription ad;
    private SystemProfile profile;
    private ExecutorService executorService;

    /**
     * Default constructor
     * @param si
     */
    public ExecutionManager(SimulatorProxy si) {
    	this.proxy = si;
    }

    public void designSimulationMethod() {
    	System.out.println("Design simulation method!");
    }

    public void executeEventService(ArchitectureDescription ad, SystemProfile profile) {
        setAd(ad);
        setProfile(profile);
        createNewThread();
        runThreadAndExecuteService();
        estimateEventServiceSimulation();


    }

    private void runThreadAndExecuteService() {
        try {
            for (int i =  0; i < 100; i++) {
                Runnable r = new ExecuteRunnable();
                executorService.execute(r);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void shutdownExecutionThreaad() {
        executorService.shutdown();
    }

    private void estimateEventServiceSimulation() {
    	System.out.println("Estimate computing load, memory usage");
    }

    private void createNewThread() {
        ThreadFactory threadFactory = r -> {
            Thread thread = new Thread(r);
            System.out.println("Runnable" + "[" + index++ + "]" + " is created.");
            return thread;
        };

        int numberThreads = getProfile().getCoreNums();

        executorService = Executors.newFixedThreadPool(numberThreads, threadFactory);
    }

    public ArchitectureDescription getAd() {
        return ad;
    }

    public SystemProfile getProfile() {
        return profile;
    }

    public void setAd(ArchitectureDescription ad) {
        this.ad = ad;
    }

    public void setProfile(SystemProfile profile) {
        this.profile = profile;
    }

    class ExecuteRunnable implements Runnable {
        @Override
        public void run() {
            System.out.println("Proceed event from queue");
            executeEventService();
            estimateEventServiceSimulation();
        }
    }
}