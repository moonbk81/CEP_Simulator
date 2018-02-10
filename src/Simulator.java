import simulator.control.SimulatorProxy;
import simulator.view.SimulatorCmdUI;

public class Simulator {
	public static void main(String[] args) {

		SimulatorProxy proxy = new SimulatorProxy();
        SimulatorCmdUI ui = new SimulatorCmdUI(proxy);
        ui.start();
	}
}
