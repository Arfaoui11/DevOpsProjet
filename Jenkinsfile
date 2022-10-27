import java.text.SimpleDateFormat
pipeline {
    agent any

     environment {
            registry = "omardrissi/devops-project"
            registryCredential = 'dckr_pat_NX_qTIaloGguDSY22Ki8Jk04CJo'
            dockerImage = ''
     }

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

        /* stage('Ansible'){
               steps{
                          sh  'ansible-playbook -i hosts.yml ansible-playbook.yml'
               }

         }*/

        /*stage('Building our image') {
               steps{
                        script {
                            dockerImage = docker.build registry + ":$BUILD_NUMBER"
                        }
               }
        }

        stage('Docker images'){
               steps{
                        sh 'docker images'
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
         }*/

          stage('DOCKER COMPOSE') {
                steps {
                            sh 'docker-compose up -d --build'
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












    }
}

/*node {
    def WORKSPACE = "/var/lib/jenkins/workspace/SpringIOC"
    def dockerImageTag = "springproject${env.BUILD_NUMBER}"

    try{
//          notifyBuild('STARTED')
         stage('Clone Repo') {
            // for display purposes
            // Get some code from a GitHub repository
            git url: 'https://github.com/Arfaoui11/DevOpsProjet.git',
                branch: 'master'
         }
          stage('Build docker') {
                 dockerImage = docker.build("springproject:${env.BUILD_NUMBER}")
          }

          stage('Deploy docker'){
                  echo "Docker Image Tag Name: ${dockerImageTag}"
                  sh "docker stop springproject || true && docker rm springproject || true"
                  sh "docker run --name springproject -d -p 8089:8089 springproject:${env.BUILD_NUMBER}"
          }
    }catch(e){
         currentBuild.result = "FAILED"
        throw e
    }finally{
         notifyBuild(currentBuild.result)
    }
}

def notifyBuild(String buildStatus = 'STARTED'){

// build status of null means successful
  buildStatus =  buildStatus ?: 'SUCCESSFUL'
  // Default values
  def colorName = 'RED'
  def colorCode = '#FF0000'
  def now = new Date()
  // message
  def subject = "${buildStatus}, Job: ${env.JOB_NAME} FRONTEND - Deployment Sequence: [${env.BUILD_NUMBER}] "
  def summary = "${subject} - Check On: (${env.BUILD_URL}) - Time: ${now}"
  def subject_email = "Spring boot Deployment"
  def details = """<p>${buildStatus} JOB </p>
    <p>Job: ${env.JOB_NAME} - Deployment Sequence: [${env.BUILD_NUMBER}] - Time: ${now}</p>
    <p>Check console output at "<a href="${env.BUILD_URL}">${env.JOB_NAME}</a>"</p>"""


  // Email notification
    emailext (
         to: "mahdijr2015@gmail.com",
         subject: subject_email,
         body: details,
         recipientProviders: [[$class: 'DevelopersRecipientProvider']]
       )
}*/

