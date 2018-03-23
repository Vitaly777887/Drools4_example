package demo.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class TestDAOImpl implements TestDAO {

    private static Map<Integer, Test> tests = new HashMap<>();

    static {
        int ids[] = {1, 2, 3, 4, 5};
        String names[] = {"Test1", "Test2", "Test3", "Test4", "Test5"};
        String descriptions[] = {"Description for Test1",
                "Description for Test2", "Description for Test3",
                "Description for Test4", "Description for Test5"};
        for (int i = 0; i < ids.length; i++) {
            Test test = new Test();
            Integer id = ids[i];
            test.setId(id);
            test.setName(names[i]);
            test.setDescription(descriptions[i]);
            tests.put(id, test);
        }
    }

    @Override
    public Collection findAll() {
        return tests.values();
    }

    @Override
    public Test findByKey(Integer id) {
        return tests.get(id);
    }

}
