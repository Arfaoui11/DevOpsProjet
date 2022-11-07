pipeline {
    environment {
        registry = "achreef/devops-tpp"
        registryCredential = 'dockerHub'
        dockerImage = ''
    }
    agent any
     stages {


        stage('Checkout GIT'){
                      steps{
                          echo 'Pulling...';
                          git branch: 'achrefback',
                          url: 'https://github.com/Arfaoui11/DevOpsProjet.git';
                      }
        }
        stage('ansible'){
                                      steps {
                                          sh 'ansible-playbook ansible-playbook.yml'
                                             }
                                 }
        stage('clean package'){
                     steps{
                         sh 'mvn clean package'

                     }
                 }
                  /* stage('mvn install'){
                     steps{
                         sh 'mvn install '

                     }
                 } */
       /* stage("Run the container with ansible"){
                              steps {
                                  sh 'ansible-playbook ansible-playbook.yml'
                                     }
                         } */
         /*stage("Clean"){
                            steps {
                                sh 'mvn clean '
                               // sh 'docker-compose down -v'
                                //sh 'docker-compose up -d --build'


                            }
                        }*/
         /*stage("Compile"){
                                     steps {
                                         sh 'mvn compile'
                                        // sh 'docker-compose down -v'
                                         //sh 'docker-compose up -d --build'


                                     }
                                 }*/
          stage('Docker compose') {
                         steps {
                                     sh 'docker-compose up -d --build'
                         }
                   }

         stage("Junit/Mockito"){
         steps {
              sh 'mvn test'
               }
         }
         stage("nexus deploy"){
              steps {
                  sh 'mvn deploy'
                     }
         }
         stage("Sonar Quality Check"){
         		steps{
         		    script{
         		     withSonarQubeEnv(installationName: 'sonar-9', credentialsId: 'jenkins-sonar-token') {
         		     sh 'mvn sonar:sonar'
         	    	       }
         	         }
                }
          }


        /*stage('Building our image') {
            steps {
                script {
                    dockerImage = docker.build registry + ":$BUILD_NUMBER"
                }
            }
        }

        stage('Deploy our image') {
            steps {
                script {
                    docker.withRegistry( '', registryCredential ) {
                        dockerImage.push()
                    }
                }
            }
        }
*/

	    	 /*timeout(time: 1, unit: 'HOURS') {
              def qg = waitForQualityGate()
              if (qg.status != 'OK') {
                  error "Pipeline aborted due to quality gate failure: ${qg.status}"
                }

		    }
		    }*/




        /*stage('Cleaning up') {

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


