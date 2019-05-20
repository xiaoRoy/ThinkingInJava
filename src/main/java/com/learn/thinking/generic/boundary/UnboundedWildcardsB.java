package com.learn.thinking.generic.boundary;

import java.util.HashMap;
import java.util.Map;

public class UnboundedWildcardsB {

    private Map rawMap;
    private Map<?, ?> unboundedMap;
    private Map <String, ?> unboundedOnlyOneMap;

    public void setRawMap(Map rawMap) {
        this.rawMap = rawMap;
    }

    public void setUnboundedMap(Map<?, ?> unboundedMap) {
        this.unboundedMap = unboundedMap;
    }

    public void setUnboundedOnlyOneMap(Map<String, ?> unboundedOnlyOneMap) {
        this.unboundedOnlyOneMap = unboundedOnlyOneMap;
    }

    private void doAssign() {
        Map rawMap = new HashMap();
        setRawMap(rawMap);
        setUnboundedMap(rawMap);
        setUnboundedOnlyOneMap(rawMap);//warning, unchecked assignment

        Map<String, Integer> map = new HashMap<>();
        setRawMap(map);
        setUnboundedMap(map);
        setUnboundedOnlyOneMap(map);
    }
}
