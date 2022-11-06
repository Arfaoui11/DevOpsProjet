pipeline{
     environment
           {    registry = "chaimayahyaoui/devops_project"
                 registryCredential = 'dockerhub_id'
                dockerImage = ''
               

            }
        agent any
        stages{

			       stage('Building our image') {
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

               stage('Cleaning up') {
                     steps {
                               sh "docker rmi $registry:$BUILD_NUMBER"
                     }
               }

              stage('Docker compose') {

                  steps {
                       sh 'docker-compose up -d'
                  }
              }

        }

}