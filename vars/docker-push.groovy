def call(string project, string imagetag, string dockeruser){
    withCredentials([usernamePassword('credentialsId':"dockerhubcreds",passwordVariable:"dockerhubpass", usernameVariable:"dockerhubuser")]){
      sh "docker login -u ${dockeruser} -p ${dockerpass}"
    }
  sh "docker push  ${dockeruser}/${project}:$(imagetag)"
}
