import java.text.SimpleDateFormat

pipeline {
           environment
           {
                 def WORKSPACE = "var/lib/jenkins/workspace/Devops"
                 def dockerImageTag = "Devops${env.BUILD_NUMBER}"

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
                  }
          }
           stage('Build docker') {
            steps {
                  script {
                    dockerImage = docker.build WORKSPACE + ":$BUILD_NUMBER"
                   }
                 }
                }
              
        }
        }
       