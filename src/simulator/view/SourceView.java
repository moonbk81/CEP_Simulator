package simulator.view;

import simulator.control.SimulatorProxy;
import simulator.model.SourceProfile;

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
        List<SourceProfile> sourceProfiles = getProxy().getSourceManager().getSourceProfiles();

        for (SourceProfile sourceProfile : sourceProfiles) {
            sb.append(
                    "SourceProfile value type: " + sourceProfile.getValueType() +
                            "\tvalue range: " + sourceProfile.getValueRange() +
                            "\tvalue average frequency: " + sourceProfile.getValueAvgFreq() +
                            "\tpriority: " + sourceProfile.getPriority() +
                            "\tregularity of frequency: " + sourceProfile.getRegularityOfFrequency() +
                            "\trange frequency: " + sourceProfile.getRangeFrequency() +
                            "\r\n"
            );
        }

        return sb.toString();
    }
}
