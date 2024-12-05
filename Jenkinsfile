pipeline {
    agent any
     
    stages {

        stage('Verificar Repositório') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/main']],
                          userRemoteConfigs: [[url: 'https://github.com/brenocostac/av2Emissor.git']]]) //colocar repositorio do pratoEmissor
            }
        }

        

        stage('Construir Imagem Docker') {
            steps {
                script {
                    def appName = 'clienteemissor' //editar para o nome do projeto Prato
                    def imageTag = "${appName}:${env.BUILD_ID}"
                    bat "docker build -t ${imageTag} ."
                }
            }
        }

        stage('Fazer Deploy') {
            steps {
                script {
                    def appName = 'clienteemissor' //acertar o nome do projeto pratoEmissor
                    def imageTag = "${appName}:${env.BUILD_ID}"
                    bat "docker stop ${appName} || exit 0"
                    bat "docker rm ${appName} || exit 0"
                    bat "docker-compose up -d --build"
                }
            }
        }
    }

    post {
        success {
            echo 'Deploy realizado com sucesso!'
        }
        failure {
            echo 'Houve um erro durante o deploy.'
        }
    }
}
