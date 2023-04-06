def call(String dockerHubUser, String project, String imageTag){
    withCredentials([usernamePassword(
        credentialsId: 'dockerhub', 
        passwordVariable: 'PASS', 
        usernameVariable: 'USER')]) {
        sh "docker login -u '$USER' -p '$PASS'"
    }
    sh "docker image push ${dockerHubUser}/${project}:${imageTag}"
    sh "docker image push ${dockerHubUser}/${project}:latest"

}