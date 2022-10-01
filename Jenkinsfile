import java.text.SimpleDateFormat

pipeline {
           environment
           {
               registry ="/var/lib/jenkins/workspace/Devops"
               registryCredential= 'chaima'

              dockerImage=''
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
                     dockerImage= docker.build registry + ":$BUILD_NUMBER"
                  }
                 }
                }
              
        }
        }
       