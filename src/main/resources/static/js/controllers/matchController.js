angular.module("app").controller('matchController', function ($scope, $http, $routeParams) {
    var person1 = $routeParams.person1;
    var person2 = $routeParams.person2;
    var url = "/match/restaurants?person1="+person1+"&person2="+person2;
    $scope.match ={};
    $http.get(url).then(function successCallback(data){
        $scope.data.persons = data;
        console.log(data);
    }, function errorCallback(data){
        $scope.data.error = error;
        console.log(error);
    });
});