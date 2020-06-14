pipeline {
    agent any
    
    stages  {
        stage('Git Pull') {
        steps{
		    git credentialsId: '5e859315-4625-4eee-a48e-ad2f31bae9a1', url: 'https://github.com/mnoumanp/devopsexample.git'
        }
        }
        stage('Maven Build') {
        steps{
	        sh label: '', script: 'mvn -Dmaven.test.skip=true install'
        }
        }
		stage('Docker info') {
        steps{
	        sh label: '', script: 'docker info'
        }
        }
    
    }
        
}
