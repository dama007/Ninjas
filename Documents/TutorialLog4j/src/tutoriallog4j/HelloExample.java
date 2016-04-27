/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tutoriallog4j;
 import org.apache.log4j.Logger;

/**
 *
 * @author usu21
 */
public class HelloExample {
   
    


	
	final static Logger logger = Logger.getLogger(HelloExample.class);
	
	public static void main(String[] args) {
	
		HelloExample obj = new HelloExample();
		obj.runMe("mkyong");
                obj.metodo2();
		
	}
	
	private void runMe(String parameter){
		
		if(logger.isDebugEnabled()){
			logger.debug("This is debug : " + parameter);
		}
		
		if(logger.isInfoEnabled()){
			logger.info("This is info : " + parameter);
		}
		
		logger.warn("This is warn : " + parameter);
		logger.error("This is error : " + parameter);
		logger.fatal("This is fatal : " + parameter);
		
	}
        
        private void metodo2() {
            if(logger.isInfoEnabled()){
			logger.info("Este es un debug desde metodo 2");
        }
        }
	
}
    

