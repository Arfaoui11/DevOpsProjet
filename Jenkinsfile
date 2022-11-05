import java.text.SimpleDateFormat
pipeline {
    agent any

     /**environment {
            registry = "omardrissi/devops-project"
            registryCredential = 'dckr_pat_NX_qTIaloGguDSY22Ki8Jk04CJo'
            dockerImage = ''
     }**/

    stages {

        stage('Checkout GIT') {
            steps {
                echo 'Pulling...';
                git branch: 'omarBack',
                url : 'https://github.com/Arfaoui11/DevOpsProjet.git'
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
              steps{
                   sh 'mvn  deploy'
              }
         }

         stage('MVN SONARQUBE'){
               steps{
                  sh  'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=sonar'
               }
         }
         stage("Test JUnit /Mockito"){
                  steps {
                       sh 'mvn test'
                  }
         }

         /*stage('Start Containers with Ansible'){
               steps{
                          sh  'ansible-playbook  ansible-playbook.yml'
               }

         }

         /*stage('Build docker image') {
               steps{

                        sh 'docker build -t omardrissi/projectdevops1  .'
               }
         }


         stage('Docker login') {
               steps {
                         sh 'echo "login Docker ...."'
                         sh 'docker login -u omardrissi -p omardrissi123'
               }
         }


         stage('Docker push') {
               steps {

                        sh 'echo "Docker is pushing ...."'
                        sh 'docker push omardrissi/projectdevops1 '
               }
         }

         stage('Cleaning up') {
               steps {
                         sh "docker rmi $registry:$BUILD_NUMBER"
               }
         }

          stage('DOCKER COMPOSE') {
                steps {
                            sh 'docker-compose up -d '
                }
          }*/



    }

    post{

            success {
                mail to: "projectdevops22@gmail.com",
                body: "${currentBuild.currentResult}: Job ${env.JOB_NAME} build ${env.BUILD_NUMBER}\n, More info at: ${env.BUILD_URL}",
                from: "projectdevops22@gmail.com",
                subject: "Jenkins Build ${currentBuild.currentResult}: Job ${env.JOB_NAME}"
            }

            failure{
                mail to: "projectdevops22@gmail.com",
                subject: "jenkins build:${currentBuild.currentResult}: ${env.JOB_NAME}",
                from: "projectdevops22@gmail.com",
                body: "${currentBuild.currentResult}: Job ${env.JOB_NAME}\nMore Info can be found here: ${env.BUILD_URL}"
            }

            changed{
                mail to: "projectdevops22@gmail.com",
                subject: "jenkins build:${currentBuild.currentResult}: ${env.JOB_NAME}",
                from: "projectdevops22@gmail.com",
                body: "${currentBuild.currentResult}: Job ${env.JOB_NAME}\nMore Info can be found here: ${env.BUILD_URL}"
            }
        }
}



