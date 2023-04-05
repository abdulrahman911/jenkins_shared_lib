def call(){
    sh 'mvn test'
    sh 'ls -la'
}