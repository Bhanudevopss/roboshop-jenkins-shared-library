def call() {
    if (!env.sonar_extra_opts) {
        env.sonar_extra_opts=""
    }
    pipeline {
        agent any

        stages {

            stage('Compile/Build') {
                steps {
                    script {
                        common.compile()
                    }
                }
            }

            stage('Test Cases') {
                steps {
                    script {
                        common.testcases()
                    }
                }
            }

            stage('Code Quality') {
                steps {
                    script {
                        common.codequality()
                    }
                }
            }
        }

        post {
            failure {
                mail body: "${component} - Pipeline Failed \n ${BUILD_URL}", from: 'bhanu.devopss@gmail.com', subject: "${component} - Pipeline Failed", to: 'bhanu.devopss@gmail.com', mimeType: 'text/html'
            }
        }

    }
}

