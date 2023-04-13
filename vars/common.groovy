def compile() {
    if(app_lang == "nodejs") {
        sh 'npm install'
    }
    if(app_lang == "maven") {
        sh 'mvn package'
    }
}

def testcases() {
    // npm test
    // mvn test
    // python -m unittest
    // go test
    sh 'echo OK'
}

def codequality() {
    sh 'sonar-scanner -Dsonar.host.url=http://172.31.15.129:9000 -Dsonar.login=${SONARQUBE_USER} -Dsonar.password=${SONARQUBE_PASS} -Dsonar.projectKey=${component} ${sonar_extra_opts} -Dsonar.qualitygate.wait=true'
}

