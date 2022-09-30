/*
node {
    def WORKSPACE = "/var/lib/jenkins/workspace/DevOps-IOC"
    def dockerImageTag = "springproject${env.BUILD_NUMBER}"

    try{
          notifyBuild('STARTED')
         stage('Clone Repo') {
            // for display purposes
            // Get some code from a GitHub repository
            git url: 'https://github.com/Arfaoui11/DevOpsProjet.git',
                branch: 'MahdiBack'
         }
          stage('Build docker') {
                          dockerImage = docker.build("devops-jdbc:${env.BUILD_NUMBER}")
                   }


          stage('Build & Deploy docker'){
                 // sh "docker network create dataa-mysql"
                  sh "docker container run --name mysqldbb --network dataa-mysql -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=devopsDB -d mysql:8"
                 // sh "docker image build -t devops-jdbcc ."
                  sh "docker container run --network dataa-mysql --name devops-jdbcc-container -p 8089:8089 -d devops-jdbc:${env.BUILD_NUMBER}"
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
}


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


pipeline {



    environment {

        registry = "mahdijr/devops-projet"

        registryCredential = 'mahdijr'

        dockerImage = ''

    }

    agent any

    stages {

        stage('Checkout GIT'){
                      steps{
                          echo 'Pulling...';
                          git branch: 'MahdiBack',
                          url : 'https://github.com/Arfaoui11/DevOpsProjet.git';
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
*/
pipeline {
    agent any

    environment {
        dockerImage=''

    }
    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "maven3"

    }

    stages {
        stage('Clone') {
            steps {
                // Get some code from a GitHub repository
                git branch: 'MahdiBack', poll: false, url: 'https://github.com/Arfaoui11/DevOpsProjet.git'
            }

        }

        stage('Build jar') {
            steps {
                sh "mvn -f scheduler/pom.xml package -DskipTests -X"
                echo 'Build jar Completed'
            }
        }

       stage('Build image') {
             steps {
                   echo 'Starting to build docker image'
                     dir('Birthday-Scheduling-App/scheduler') {
                       script {
                           def  dockerImage=docker.build("mahdijr/demo")
                           echo 'Build Image Completed'
                       }
                   }
               }
       }

    }


}