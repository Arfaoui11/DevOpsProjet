import java.text.SimpleDateFormat
pipeline {
    agent any

    stages {

        stage('Checkout GIT') {
            steps {
                echo 'Pulling...';
                git branch: 'siwarbrahmi',
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
                sh  'mvn clean install'
            }
        }

        stage('MVN COMPILE'){
            steps{
                sh  'mvn compile'
            }
        }
 stage('MVN SONARQUBE'){

                steps{
                          sh  'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=sonar'
                }
          }
	 stage('MVN BUILD'){
              steps{
                  sh  'mvn package'
                  //sh 'java -jar target/gs-spring-boot-docker-0.1.0.jar'
              }
        }


        stage('Building docker image') {
               steps{
                        script {
                     sh 'ls target/'
		     sh 'docker build -t gs-spring-boot-docker-0.1.0.jar .'      
                        }
               }
        }

      
         


         /* stage("Test JUnit /Mockito"){
                steps {
                            sh 'mvn test'
                }
          }*/


          stage('push') {
        steps{
            
                sh 'echo docker hub'
                    sh 'docker login -u sywarbr -p siwarsiwar'
                sh 'docker images'
                sh 'docker push docker.io/sywarbr/devopsproject_app'
                
        }
        
        
        
        }
stage('docker compose'){
    steps {
        sh 'docker-compose up -d'
    }
}
          stage("nexus deploy"){
               steps{
                       sh 'mvn  deploy'
               }
          }

    }

}



