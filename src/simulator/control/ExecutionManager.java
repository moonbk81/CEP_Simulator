package simulator.control;

import simulator.control.interfaces.IExecutionManager;
import simulator.model.ArchitectureDescription;
import simulator.model.SimulationResult;
import simulator.model.SystemProfile;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

import static simulator.control.SimulationManager.SIMULATION_STATE.SIMULATION_STATE_START;

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
        // call by simulation manager to start execution of event service.
        System.out.println("executeEventService(ad, profile");
        setAd(ad);
        setProfile(profile);
        createNewThread();
        runThreadAndExecuteService();
    }

    private void runThreadAndExecuteService() {
        try {
            //while (proxy.getSimulationManager().getState() == SIMULATION_STATE_START) {
            for (int i = 0; i < 100; i++) {
                Runnable r = new ExecuteRunnable();
                executorService.execute(r);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        shutdownExecutionThreaad();
    }

    private void shutdownExecutionThreaad() {
        executorService.shutdown();
    }

    private void estimateEventServiceSimulation(SimulationResult result) {
    	System.out.println("Estimate computing load, memory usage");
    	// Notify ad and profile to quality manager
        // ExecutionManager be Observer
        proxy.getQualityManager().notifyMonitor(result);
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

    private void executeEventService() {
        System.out.println("Execute event service");
        SimulationResult result = new SimulationResult();
        int complexity = ad.getAdapterProfile().getComplexity() + ad.getComponent().getComplexity();
        int consumption = ad.getAdapterProfile().getMemoryConsumption() + ad.getComponent().getMemoryResource();
        result.setTotalComplexity(complexity);
        result.setTotalMemoryConsumption(consumption);
        result.setSystemProfile(getProfile());
        result.setArchitectDescription(getAd());

        estimateEventServiceSimulation(result);
    }

    class ExecuteRunnable implements Runnable {
        @Override
        public void run() {
            System.out.println("Proceed event from queue");
            executeEventService();
        }
    }


}