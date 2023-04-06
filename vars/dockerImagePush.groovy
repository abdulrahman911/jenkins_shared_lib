// def call(String dockerHubUser, String project, String imageTag){
//     withCredentials([usernamePassword(
//         credentialsId: 'dockerhub', 
//         passwordVariable: 'PASS', 
//         usernameVariable: 'USER')]) {
//         sh "docker login -u '$USER' -p '$PASS'"
//     }
//     sh "docker image push ${dockerHubUser}/${project}:${imageTag}"
//     sh "docker image push ${dockerHubUser}/${project}:latest"

// }

def call(String aws_account_id, String region, String ecr_repo_name){
   sh """
    aws ecr get-login-password --region ${region} | docker login --username AWS --password-stdin ${aws_account_id}.dkr.ecr.${region}.amazonaws.com
    docker push ${aws_account_id}.dkr.ecr.${region}.amazonaws.com/${ecr_repo_name}:latest
   """  
}