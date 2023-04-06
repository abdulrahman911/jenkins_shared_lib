def call(){
    sh 'mvn test'
    sh 'sudo ls -lrta'
}