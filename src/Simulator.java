import simulator.control.SimulatorProxy;
import simulator.model.*;
import simulator.view.SimulatorCmdUI;

import static simulator.model.Source.*;

public class Simulator {
	public static void main(String[] args) {

		SimulatorProxy proxy = new SimulatorProxy();
        SimulatorCmdUI ui = new SimulatorCmdUI(proxy);
        ui.start();
	}
}
