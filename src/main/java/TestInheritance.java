/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KH
 */
public class TestInheritance {
    public static void main(String[] args){
        parent parent1 = new child();
        parent1.talk();
    }
    
    
}
abstract class parent{
        public void talk(){
            System.out.println("This is parent");
        }
    }
    
    class child extends parent{

        @Override
        public void talk() {
            super.talk(); //To change body of generated methods, choose Tools | Templates.
            System.out.println("This is child");
        }
        
    }