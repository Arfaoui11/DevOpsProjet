import java.text.SimpleDateFormat

pipeline { 
       agent any
       
       
        stages{
            stage('Checkout GIT'){
                steps{
                    echo 'Pulling...';
                    git branch: 'YassouraBackend',
                    url : 'https://github.com/Arfaoui11/DevOpsProjet.git',
                   credentialsId:"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";
                             }
                             } 
           
               stage('MVN Package'){
            steps {
                sh """mvn -version  """
                sh """java -version """
               sh """mvn package -e """
            }
        }
               stage("MVN Compile"){
            steps {
                sh """mvn compile -e """
                
            }
        }
      stage("SONARQUBE"){
            steps {
                sh """mvn sonar:sonar """
                
            }
        }
               stage("Junit/Mockito"){
            steps {
                sh """mvn test """
                
            }
        }
        stage('Nexus'){
            steps{
                sh """mvn deploy """
            }
        }
               stage("MVN Install"){
            steps {
                sh """mvn install """
                
            }
        }
        stage("MVN Clean"){
            steps {
                sh """mvn clean -e """
                
            }
        }
        stage("Build the package"){
                     steps {
                       sh 'docker-compose up -d --build'
                     }
                }
        }
        }