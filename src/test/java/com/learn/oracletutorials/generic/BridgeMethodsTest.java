package com.learn.oracletutorials.generic;


import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class BridgeMethodsTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void test_rawType_classCastException() {
        BridgeMethods.IntegerNode integerNode = new BridgeMethods.IntegerNode(44);
        BridgeMethods.Node node = integerNode;
        node.setData("a string");
        thrown.expect(ClassCastException.class);
        Integer number = integerNode.getData();
    }

    private void test_rawType_erased() {
        BridgeMethods.IntegerNode integerNode = new BridgeMethods.IntegerNode(44);
        BridgeMethods.Node node = (BridgeMethods.IntegerNode)integerNode;
        node.setData("a string");
//        Integer number = (String)integerNode.getData();// cause a exception to be thrown
    }
}
