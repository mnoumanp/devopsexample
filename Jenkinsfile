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
		stage('Docker login') {
        steps {
				//withEnv(['PATH+EXTRA=/usr/sbin:/usr/bin:/sbin:/bin'])
				sh 'docker login -u 9741223883 -p 9342994028'
			}
        }
	stage ("Docker-Build-Services") {
			steps {
				//withEnv(['PATH+EXTRA=/usr/sbin:/usr/bin:/sbin:/bin'])
				sh "docker build -t microserviceapi ."
				
			}
		} 
	    stage ("Tagging-docker-images") {
			steps {
				//withEnv(['PATH+EXTRA=/usr/sbin:/usr/bin:/sbin:/bin'])
				sh "docker tag microserviceapi 9741223883/microserviceapi"
				
			}
		}
	    stage ("Pushing-Images-to-Registry"){
			steps {
				//withEnv(['PATH+EXTRA=/usr/sbin:/usr/bin:/sbin:/bin'])
				sh "docker push 9741223883/microserviceapi"
				
			}
		}
	    stage('DeployToProduction') {
            		steps {
                			withKubeConfig(credentialsId: 'confignew') {
    
                sh 'kubectl apply -f  deploy.yaml'
}
            		}
        	}
    
    }
        
}
