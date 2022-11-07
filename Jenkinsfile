pipeline{
        agent any

        stages{

			        stage('Build docker image'){
                    steps{

                           sh 'docker build -t omardrissi/angularproject2 . '
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
                     	sh 'docker push omardrissi/angularproject2'
                 }
              }

              stage('Docker compose') {

                  steps {
                       sh 'docker-compose up -d'
                  }
              }

        }

}
