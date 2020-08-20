node {
    //notify ('Started')

    try{
        stage('checkout')
        checkout scm
        //git 'https://github.com/OscarIsmaelZuniga/nutritionist.git'

        stage 'compiling, test, packaging'
        bat 'mvn clean package'

        stage 'archival'

        publishHTML(target: [allowMissing: true,
            alwaysLinkToLastBuild: false,
            keepAll: true,
            reportDir: 'target/site/jacoco/',
            reportFiles: 'index.html',
            reportName: 'Code Coverage'
        ])

        step([$class: 'JUnitResultArchiver',
            testResults: 'target/surefire-reports/TEST-*.xml'
        ])

        step([$class: 'ArtifactArchiver',
            artifacts: "target/*.?ar",
            excludes: null
        ])

        stash name: 'everything',
          excludes: 'test-results/**',
          includes: '**'
    }catch (err){
        //notify("Error ${err}")
        currentBuild.result = 'FAILURE'
    }

}

node('windows') {
    bat 'dir'
    bat 'del /S /Q *'
    unstash 'everything'
    bat 'dir'

}

stage name: 'Deploy to staging', concurrency: 1

node{
    //bat "echo '<h1>${env.BUILD_DISPLAY_NAME}</h1>' >> app/index.html"

    bat 'docker-compose up -d --build'

}