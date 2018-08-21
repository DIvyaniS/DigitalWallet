pipeline {
// example pipeline for maven
    agent any
    tools 
    {
    	maven 'Maven-3.5.4'
    	jdk 'JDK8'
    }
    stages 
    {
    	stage ('Initialize')
    		{
    			steps
    			{
    				sh '''
    				echo "PATH = ${PATH}"
    				echo "M2_HOME = ${M2_HOME}"    	
    				echo "JAVA_HOME = ${JAVA_HOME}"
    				'''
    			}
    		}
        stage('Build') 
        { 
        	// if the pom.xml is not in the root path provide the location of the pom (-f) as a relative path
            	steps 
            	{
            		sh 'mvn -f com.wallet/pom.xml compile install package depoly'
             	}
             
        }

    }
}
