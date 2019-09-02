var app =angular.module("login",[]);
app.controller("loginController", function($scope,$http,$window){
    $scope.vcEmail="";
    $scope.vcPassword="";
    $scope.vcResponse="";
    $scope.login= function(){
        console.log("login");

        var data = new Object();
        data.vcEmail = $scope.vcEmail;
        data.vcPassword =$scope.vcPassword;

        $http.post("http://localhost:8080/open/login",data)
        .then(function successCallback(response){
            console.log(response.data.usuario);
            console.log("status = "+response.status);
            if(response.status==200){
                if(response.data.usuario!=null){
                    localStorage.setItem("access_usuario",  JSON.stringify(response.data.usuario));
                    //console.log(JSON.stringify(response.data.usuario));
                    $window.location.href = '/appGroupCast/main.html';
                }
                else{
                $scope.vcResponse="El usuario o constraseña no existe!";
                }
            }    
        }
        ,

        function errorCallback(response){
            console.log("ERROR : "+response);
            $scope.vcResponse="Problemas con el servidor!";
            

        })

        ; 
    }
});