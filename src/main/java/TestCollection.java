/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import Test.EDS.BusinessUnit.TestUnit;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author KH
 */
public class TestCollection {
    
    public static void main(String[] abc){
        
        List<TestUnit> list = new ArrayList<TestUnit>();
        TestUnit ee = new TestUnit();
        ee.randInit();
        
        String before = ee.getSHORT_NAME();
        System.out.println("Before: "+before);
        list.add(ee);
        
        Iterator<TestUnit> i = list.iterator();
        TestUnit e = i.next();
        e.setSHORT_NAME("Now");
        
        System.out.println("Now: "+ee.getSHORT_NAME());
        
    }
}
