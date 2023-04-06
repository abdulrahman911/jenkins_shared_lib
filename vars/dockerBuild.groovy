def call(String dockerHubUser, String project, String imageTag){
    sh """
    docker build -t ${dockerHubUser}/${project} .
    docker image tag ${dockerHubUser}/${project} ${dockerHubUser}/${project}:${imageTag}
    docker image tag ${dockerHubUser}/${project} ${dockerHubUser}/${project}:latest
    """
}