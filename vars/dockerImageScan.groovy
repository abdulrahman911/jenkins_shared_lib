def call(String dockerHubUser, String project, String imageTag){
    sh """
    trivy image ${dockerHubUser}/${project} ${dockerHubUser}/${project}:latest > scan.txt
    cat scan.txt
    """
}