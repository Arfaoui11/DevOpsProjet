node {
    def WORKSPACE = "/var/lib/jenkins/workspace/DevOps-IOC"
    def dockerImageTag = "springproject${env.BUILD_NUMBER}"

    try{
//          notifyBuild('STARTED')
         stage('Clone Repo') {
            // for display purposes
            // Get some code from a GitHub repository
            git url: 'https://github.com/Arfaoui11/DevOpsProjet.git',
                branch: 'master'
         }


          stage('Build & Deploy docker'){
               //   sh "docker network create dataa-mysql"
                  sh "docker container run --name mysqldbb --network dataa-mysql -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=devopsDB -d mysql:8"
                  sh "docker image build -t devops-jdbcc ."
                  sh "docker container run --network dataa-mysql --name devops-jdbc-container -p 8089:8089 -d devops-jdbcc"
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

