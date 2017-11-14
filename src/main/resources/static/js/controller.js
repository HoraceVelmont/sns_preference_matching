angular.module("app").controller('usersController', function($scope){
    $scope.headingTitle = "User List";
});

angular.module("app").controller('rolesController', function($scope){
   $scope.headingTitle = "Roles List";
});

angular.module("app").controller('demoController', function($scope, $http, $sce){
    var promise = $http({
        method : 'GET',
        url : "pokemon.json"
    }).then(function successCallback(data){
        $scope.pokemon = data;
    }, function errorCallback(data){
        console.log(data);
    });
});

