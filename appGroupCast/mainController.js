
    // include ngRoute for all our routing needs
    var main = angular.module('main', ['ngRoute','ja.qr']);

    // configure our routes
    main.config(function($routeProvider) {
    
        $routeProvider

            // route for the home page
            .when('/', {
                templateUrl : 'pages/home.html',
                controller  : 'mainController'
            })

            // route for the about page
            .when('/ferias', {
                templateUrl : 'pages/ferias.html',
                controller  : 'feriasController'
            })

            // route for the contact page
            .when('/equipe', {
                templateUrl : 'pages/equipe.html',
                controller  : 'equipeController'
            });
    });

    
    
    main.run(['$rootScope', '$location','$window', function ($rootScope, $scope, $window) {
        $rootScope.$on('$routeChangeStart', function (event) {

        var usuario = localStorage.getItem('access_usuario');

        if (usuario==null) {
          console.log('DENY : Redirecting to Login');
          event.preventDefault();
          $window.location.href = '/appGroupCast/index';
        }
        else {
          console.log('ALLOW');
          console.log($scope.usuario);  
        }
  });
}])

        // create the controller and inject Angular's $scope
        main.controller('mainController', function($scope,$window) {
            // create a message to display in our view
            $scope.message = 'Hello world, this is the home page!';
            
            $scope.usuario = JSON.parse(localStorage.getItem('access_usuario'));

            $scope.logout = function(){
                console.log('LOGOUT');
                localStorage.clear();
                $window.location.href = '/appGroupCast/index';
                //console.log('DEPOIS');
            };
        });

        main.controller('feriasController', function($scope,$http) {
            $scope.message = 'Hi! This is the about page.';
            $scope.lstEquipe = [];
            $scope.lstFuncionario = [];
            
            $scope.selectEquipe = "";

            $scope.selectFuncionario = "";

            $scope.dtInicio="";
            $scope.dtFin="";
            
            $scope.response = null;
            $scope.valorQR="";

            var usuario = JSON.parse(localStorage.getItem('access_usuario'));
            //console.log("vcToken = "+ usuario);
            
            $http.get("http://localhost:8080/security/equipe",{
                headers: {'Authorization': usuario.vcToken}
            })
            .then(function successCallback(response){
                console.log(response.data);
                $scope.lstEquipe=response.data.lstEquipe;
            },
    
            function errorCallback(response){
                console.log("ERROR : "+response);
            });

            $scope.selectedItemChangedEquipe = function(){
                console.log($scope.selectEquipe);


                $http.get("http://localhost:8080/security/funcionario-equipe/"+$scope.selectEquipe.nuIdEquipe,{
                headers: {'Authorization': usuario.vcToken}
                })
                .then(function successCallback(response){
                    console.log(response.data);
                    $scope.lstFuncionario=response.data.lstFuncionario;
                },
        
                function errorCallback(response){
                    console.log("ERROR : "+response);
                });

            };


            $scope.cadastrarFerias= function(){
                console.log("cadastrarFerias");
                console.log($scope.selectFuncionario+" .... "+$scope.dtInicio);
                var objData = new Object();
                objData.objFuncionario=new Object();
                objData.objPeriodo=new Object();
                
                objData.objFuncionario = $scope.selectFuncionario;
                
                objData.objPeriodo.dtInicio =$scope.dtInicio;
                objData.objPeriodo.dtFin =$scope.dtFin;
                
                console.log(objData);
        
                $http.post("http://localhost:8080/security/ferias", objData, {
                    headers: {'Authorization': usuario.vcToken}
                })
                .then(function successCallback(response){
                    console.log(response.data);
                    if(response.data.nuError == 0){
                        $scope.response = response.data;
                        $scope.valorQR = JSON.stringify($scope.response);
                    }
                },
        
                function errorCallback(response){
                    console.log("ERROR : "+response);
                })
        
                ; 
            };

        });


        main.controller('equipeController', function($scope, $http) {
            $scope.lstEquipe = [];
            $scope.vcNomeEquipe="";
             usuario = JSON.parse(localStorage.getItem('access_usuario'));
            console.log("vcToken = "+ usuario);
            
            $http.get("http://localhost:8080/security/equipe",{
                headers: {'Authorization': usuario.vcToken}
            })
            .then(function successCallback(response){
                console.log(response.data.lstEquipe);
                $scope.lstEquipe=response.data.lstEquipe;
            },
    
            function errorCallback(response){
                console.log("ERROR : "+response);
            });




            
            $scope.cadastrarEquipe= function(){
                console.log("cadastrarEquipe");
                var objData = new Object();
                objData.nuIdEquipe=-1;
                objData.vcName=$scope.vcNomeEquipe;
                
                
                console.log(objData);
        
                $http.post("http://localhost:8080/security/equipe", objData, {
                    headers: {'Authorization': usuario.vcToken}
                })
                .then(function successCallback(response){
                    console.log(response.data);
                    if(response.data.nuError == 0){
                        $scope.lstEquipe.push(objData);
                    }
                },
        
                function errorCallback(response){
                    console.log("ERROR : "+response);
                })
        
                ; 
            };



        });

