package simulator.view;

import simulator.control.SimulatorProxy;
import simulator.model.Source;

import java.util.List;

import static simulator.view.SimulatorCmdUI.scanner;

public class SourceView extends ProfileView {
    public SourceView(SimulatorProxy proxy) {
        this.proxy = proxy;
    }

    @Override
    public void registerCommand() {
        System.out.println("Enter event source range frequency");
        int rangeFreq = scanner.nextInt();

        System.out.println("Enter event source regularity");
        int regularity = scanner.nextInt();

        System.out.println("Enter event source priority");
        int priority = scanner.nextInt();

        System.out.println("Enter event source value range");
        int valueRange = scanner.nextInt();

        System.out.println("Enter event source value average frequency");
        int valueAvgFreq = scanner.nextInt();

        System.out.println("Enter event source value type");
        int valueType = scanner.nextInt();

        proxy.registerSourceProfile(rangeFreq, regularity, priority, valueRange, valueAvgFreq, valueType);
    }

    @Override
    public String retrieveCommand() {
        StringBuilder sb = new StringBuilder();
        List<Source> sources = getProxy().getSourceManager().getSourceProfiles();

        for (Source source : sources) {
            sb.append(
                    "Source value type: " + source.getValueType() +
                            "\tvalue range: " + source.getValueRange() +
                            "\tvalue average frequency: " + source.getValueAvgFreq() +
                            "\tpriority: " + source.getPriority() +
                            "\tregularity of frequency: " + source.getRegularityOfFrequency() +
                            "\trange frequency: " + source.getRangeFrequency() +
                            "\r\n"
            );
        }

        return sb.toString();
    }
}
