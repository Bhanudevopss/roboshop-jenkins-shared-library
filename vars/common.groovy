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

