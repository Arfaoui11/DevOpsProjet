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
         stage("Build the package"){
                            steps {
                                sh 'docker-compose down'
                                sh 'docker-compose up'
                                sh 'docker-compose rm'
                            }
                        }
      /*   stage("nexus deploy"){
              steps {
                  sh 'mvn clean deploy'
                     }
         }*/

       /*  stage('Test - To check MYSQL connect') {
             def dockerfile = 'Dockerfile'
             docker.build("rds-latest", "-f ${dockerfile} .")
             def rds_test_image = docker.image('rds-test:latest')
             docker.image('mysql:5.6').withRun('-e MYSQL_ROOT_PASSWORD=root --name=mysql_server -p 3306:3306') { container ->
                 docker.image('mysql:5.6').inside("--link ${container.id}:mysql") {

                     sh 'while ! mysqladmin ping -hmysql --silent; do sleep 1; done'
                 }

                 rds_test_image.inside("--link ${container.id}:mysql -e MYSQL_HOST=mysql -e MYSQL_PWD=root -e USER=root "){
                     sh 'bash scripts/test_script.sh'
                 }
             }
         }
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
        }
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

		    }
            }
        }



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
