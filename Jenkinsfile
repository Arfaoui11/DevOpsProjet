/*


import java.text.SimpleDateFormat

pipeline {
       agent any


        stages{
            stage('Checkout GIT'){
                steps{
                    echo 'Pulling...';
                    git branch: 'MahdiBack',
                    url : 'https://github.com/Arfaoui11/DevOpsProjet.git';
                             }
                             }
            stage('Date') {
                steps {
                     script{
                     def date = new Date()
                     sdf = new SimpleDateFormat("MM/dd/yyyy")
                     println(sdf.format(date))
                             }
                             }
                             }
            stage('MVN CLEAN')
            {
                steps{
                sh  'mvn clean'
                }
            }
            stage('MCN COMPILE')
            {
                steps{
                sh  'mvn compile'
                }
            }
            stage('MVN SONARQUBE')
            {
                steps{
                sh  'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=sonar'
                }
            }


        }
        }

*/
pipeline {
    environment {
        registry = "mahdijr/devops-tp"
        registryCredential = 'a8e9ee1f-1fa3-47e5-bef7-5d65e3d019f4'
        dockerImage = ''
    }
    agent any
    stages {


        stage('Checkout GIT'){
                      steps{
                          echo 'Pulling...';
                          git branch: 'MahdiBack',
                          url: 'https://github.com/Arfaoui11/DevOpsProjet.git';
                      }
        }
        stage("Run the container with ansible"){
                              steps {
                                  sh 'ansible-playbook ansible-playbook.yml'
                                     }
                         }
         stage("Build the package"){
                            steps {
                                sh 'mvn clean package'
                               // sh 'docker-compose down -v'
                                sh 'docker-compose up -d --build'


                            }
                        }
         stage("nexus deploy"){
              steps {
                  sh 'mvn deploy'
                     }
         }

          /*
        stage('Building our image') {
            steps {
                script {
                    dockerImage = docker.build registry + ":$BUILD_NUMBER"
                }
            }
        }*/
/*
        stage('Deploy our image') {
            steps {
                script {
                    docker.withRegistry( '', registryCredential ) {
                        dockerImage.push()
                    }
                }
            }
        }*/
        stage("Sonar Quality Check"){
		steps{
		    script{
		     withSonarQubeEnv(installationName: 'sonar-9', credentialsId: 'jenkins-sonar-token') {
		     sh 'mvn sonar:sonar'
	    	}
	    	/* timeout(time: 1, unit: 'HOURS') {
              def qg = waitForQualityGate()
              if (qg.status != 'OK') {
                  error "Pipeline aborted due to quality gate failure: ${qg.status}"
                }

		    }*/
		    }
            }
        }



/*

        stage('Cleaning up') {

            steps {

                sh "docker rmi $registry:$BUILD_NUMBER"

            }

        }*/

    }

    post {
            success {
                mail bcc: '', body: 'Pipeline build successfully', cc: '', from: 'mahdi.arfaoui1@esprit.tn', replyTo: '', subject: 'The Pipeline success', to: 'mahdi.arfaoui1@esprit.tn'
            }
            failure {
                mail bcc: '', body: 'Pipeline build not success', cc: '', from: 'mahdi.arfaoui1@esprit.tn', replyTo: '', subject: 'The Pipeline failed', to: 'mahdi.arfaoui1@esprit.tn'
             }
        }

}
