// def call(String dockerHubUser, String project, String imageTag){
//     sh """
//     trivy image ${dockerHubUser}/${project}:latest > scan.txt
//     cat scan.txt
//     """
// }

def call(String aws_account_id, String region, String ecr_repo_name){
   sh """
     trivy image ${aws_account_id}.dkr.ecr.${region}.amazonaws.com/${ecr_repo_name}:latest > scan.txt
     cat scan.txt
   """  
}