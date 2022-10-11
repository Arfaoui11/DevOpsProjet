import java.text.SimpleDateFormat

pipeline { 
       agent any
       
       
        stages{
            stage('Checkout GIT'){
                steps{
                    echo 'Pulling...';
                    git branch: 'YassouraBack',
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
              
        }
        }
       