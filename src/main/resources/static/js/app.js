var app = angular.module('app', ['ngRoute', 'ngResource']);
app.config(function($routeProvider){
    $routeProvider
        .when('/users',{
            templateUrl : '/views/users.html',
            controller: 'usersController'
        })
        .when('/roles',{
            templateUrl:'/views/roles.html',
            controller: 'rolesController'
        })
        .otherwise(
            { redirectTo: '/'}
        );
});

app.config(['$sceDelegateProvider', function($sceDelegateProvider) {
    $sceDelegateProvider.resourceUrlWhitelist([
        'self',
        'https://remote.s3.amazonaws.com/**',
        'http://pokeapi.co/**'
    ]);
}]);

app.config(['$qProvider', function ($qProvider) {
    $qProvider.errorOnUnhandledRejections(false);
}]);

var model = {
    user : "Adam",
    items : [{action : "BuyFlowers", done : false},
        {action : "Get Shoes", done : false}
    ]
};


app.controller("ToDoCtrl", function($scope) {
    $scope.todo = model;
    $scope.incompleteCount = function () {
        var count = 0;
        angular.forEach($scope.todo.items, function (item) {
            if (!item.done) {
                count++;
            }
        });
        return count;
    }
});