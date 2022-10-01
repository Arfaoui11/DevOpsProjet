import java.text.SimpleDateFormat

pipeline {
           environment
           {
           dockerImage = ''
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
          steps{
          bat """mvn clean package -Dmaven.test.failure.ignore=true"""
          }
          }
              
        }
        }
       