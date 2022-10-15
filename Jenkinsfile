import java.text.SimpleDateFormat

pipeline {
           environment
           {    registry = "chaimayahyaoui/devops_project"
                 registryCredential = 'dockerhub_id'
                dockerImage = ''
                NEXUS_VERSION="nexus3"
                NEXUS_PROTOCOL="http"
                NEXUS_URL="192.168.1.119:8081"
                NEXUS_REPOSITORY="nexu-repo-projet"
                NEXUS_CREDENTIAL_ID="nexus-user-credentials"

            }
       agent any
       
       
        stages{
            stage('Checkout GIT'){
                steps{
                    echo 'Pulling...';
                    git branch: 'chaima_back',
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

         stage("Test,Build"){
           steps {
                    sh 'mvn clean package'
                     sh 'docker-compose up -d --build'
                  }

          }


           stage("nexus deploy"){
                        steps {
                            sh 'mvn deploy'

                               }
                   }


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

        }
        }
       