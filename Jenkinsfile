import java.text.SimpleDateFormat

pipeline {
           environment
           {    registry = "chaimayahyaoui/devops_project"
                 registryCredential = 'dockerhub_id'
                dockerImage = ''
                NEXUS_VERSION="nexus3"
                NEXUS_PROTOCOL="http"
                NEXUS_URL="192.168.1.120:8081"
                NEXUS_REPOSITORY="maven-snapshots"
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

          stage('MVN CLEAN'){
                      steps{
                          sh  'mvn clean'
                      }
                  }
                   stage('MVN COMPILE'){
                              steps{
                                  sh  'mvn compile'
                              }
                          }
          stage('MVN PACKAGE'){
              steps{
                  sh  'mvn package'
              }
                }
             stage("nexus deploy"){
                       steps {
                           sh 'mvn deploy'

                              }
                 }

           stage("Tests JUnit / Mockito"){
                         steps {
                            sh 'mvn test'
                            }
                    }


             stage("SONAR"){
              steps {
             sh 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=chaimayahyaoui123 '

                                           }
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
               stage("docker compose"){
                                                     steps {
                                                         sh 'mvn clean package'
                                                        // sh 'sudo chmod 666 /var/run/docker.sock'
                                                         sh 'docker-compose up -d --build'


                                                     }

                           }

 post {
    always {
       mail to: 'yahyaoui.chaima@esprit.tn',
          subject: "Status of pipeline: ${currentBuild.fullDisplayName}",
          body: "${env.BUILD_URL} has result ${currentBuild.result}"
    }
  }


        }

       