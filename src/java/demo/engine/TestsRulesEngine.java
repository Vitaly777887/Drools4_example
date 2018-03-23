package demo.engine;

import demo.exception.RulesEngineException;
import demo.model.TestDAO;
import demo.model.Machine;

public class TestsRulesEngine {

    private RulesEngine rulesEngine;

    private TestDAO testDAO;

    public TestsRulesEngine(TestDAO testDAO) throws RulesEngineException {
        super();
        rulesEngine = new RulesEngine("testRules1.drl");
        this.testDAO = testDAO;
    }

    public void assignTests(final Machine machine) {
        rulesEngine.executeRules(workingMemory -> {
            // Set globals first before asserting/inserting any knowledge!
            workingMemory.setGlobal("testDAO", testDAO);
            workingMemory.insert(machine);
        });
    }

}
