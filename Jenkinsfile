pipeline {
// example pipeline for maven
    agent any
    tools 
    {
    	 jdk 'java 8'
        maven 'Maven3'
    }
triggers 
    {
    	pollSCM('H */4 * * 1-5')
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
            		sh 'mvn -f com.wallet/pom.xml compile install package deploy'
             	}
             
        }

    }
}
