package demo;

import demo.engine.TestsRulesEngine;
import demo.model.*;

import java.util.*;

public class Main {


    private static MachineResultSet machineResultSet;

    private static TestsRulesEngine testsRulesEngine;

    private static TestDAO testDAO;


    public Main() {

        // Set drools.schema.validating property to false
        // Ideally, this would be set only once as a JVM property for your program
        // Setting this property to false, gets rid of the following message:
        // cvc-elt.1: Cannot find the declaration of element 'rule-set'
        System.setProperty("drools.schema.validating", "false");
        machineResultSet = new MachineResultSetImpl();
        testDAO = new TestDAOImpl();
        testsRulesEngine = new TestsRulesEngine(testDAO);

    }


    static void print(Machine machine) {
        String tests = "";
        for (Object o : machine.getTests()) {
            Test test = (Test) o;
            tests += "{" +
                    "id=" + test.getId() +
                    ", name='" + test.getName() + '\'' +
                    ", description='" + test.getDescription() + '\'' +
                    '}';
        }
        System.out.println("Machine{" +
                "type='" + machine.getType() + '\'' +
                ", functions=" + machine.getFunctions() +
                ", serialNumber='" + machine.getSerialNumber() + '\'' +
                ", tests=" + tests +
                ", creationTs=" + machine.getCreationTs() +
                ", testsDueTime=" + machine.getTestsDueTime() +
                '}');
    }

    //Разработка ЭС с помощью Drools для конфигурации ИТ-инфраструктуры Компании
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String loop;
        do {
            //подкачка новых правил
            //после изменения правил сохранить
            new Main();
            for (Machine machine : machineResultSet.getMachines()) {

                testsRulesEngine.assignTests(machine);
                print(machine);

            }
            loop = scanner.nextLine();
            System.out.println("");


        } while (loop.equals(""));
        System.out.println("End");

    }

}
