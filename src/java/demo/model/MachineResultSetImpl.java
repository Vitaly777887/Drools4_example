package demo.model;

import java.util.Arrays;

import java.util.List;

public class MachineResultSetImpl implements MachineResultSet {

    List<Machine> machines;

    public MachineResultSetImpl() {
        super();
        Machine m1 = new Machine();
        m1.setSerialNumber("1234A");
        m1.setType("Type1");
        m1.setFunctions(Arrays.asList("DDNS Server", "DNS Server"));
        Machine m2 = new Machine();
        m2.setSerialNumber("1234B");
        m2.setType("Type2");
        m2.setFunctions(Arrays.asList("DDNS Server", "DNS Server"));
        Machine m3 = new Machine();
        m3.setSerialNumber("1234C");
        m3.setType("Type2");
        m3
                .setFunctions(Arrays.asList("Gateway", "Router"));
        Machine m4 = new Machine();
        m4.setSerialNumber("1234D");
        m4.setType("Type2");
        m4.setFunctions(Arrays.asList("Gateway"));
        Machine m5 = new Machine();
        m5.setSerialNumber("1234E");
        m5.setType("Type2");
        m5.setFunctions(Arrays.asList("DNS Server"));
        machines = Arrays.asList(m1, m2, m3, m4, m5);
    }


    public List<Machine> getMachines() {
        return machines;
    }
}
