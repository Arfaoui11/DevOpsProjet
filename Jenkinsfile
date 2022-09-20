node {
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
                  sh "docker-composer build"
                  sh "docker-compose up -d"
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

