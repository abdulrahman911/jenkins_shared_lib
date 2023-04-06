// ## DockerHub Build and Push 
// def call(String dockerHubUser, String project, String imageTag){
//     sh """
//     docker build -t ${dockerHubUser}/${project} .
//     docker image tag ${dockerHubUser}/${project} ${dockerHubUser}/${project}:${imageTag}
//     docker image tag ${dockerHubUser}/${project} ${dockerHubUser}/${project}:latest
//     """
// }

def call(String aws_account_id, String region, String ecr_repo_name){
   sh """
     // docker build -t 200955153941.dkr.ecr.ap-south-1.amazonaws.com/myjava-app:latest .
     docker build -t ${ecr_repo_name} .
     //docker tag myjava-app:latest 200955153941.dkr.ecr.ap-south-1.amazonaws.com/myjava-app:latest
     docker tag ${ecr_repo_name}:latest ${aws_account_id}.dkr.ecr.${region}.amazonaws.com/${ecr_repo_name}:latest .
   """  
}