app.controller('usersController', function($scope){
    $scope.headingTitle = "User List";
});

app.controller('rolesController', function($scope){
   $scope.headingTitle = "Roles List";
});

app.controller('demoController', function($scope, $http, $sce){
    var promise = $http({
        method : 'GET',
        url : "pokemon.json"
    }).then(function successCallback(data){
        $scope.pokemon = data;
    }, function errorCallback(data){
        console.log(data);
    });
});

app.constant("dataUrl", "/person").controller("personController", function($scope, $http, dataUrl){
    $scope.data = {};
    $http.get(dataUrl).then(function successCallback(data){
        $scope.data.person = data;
    }, function errorCallback(data){
        $scope.data.error = error;
        console.log(error);
    });
})