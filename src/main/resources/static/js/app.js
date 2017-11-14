angular.module("app").config(function($routeProvider){
    $routeProvider.when('/match/:person1/:person2',{
            templateUrl : '/views/matching.html'
        }).when('/',{
            templateUrl:'/views/friendList.html'
        }).otherwise(
            { templateUrl: '/views/friendList.html'}
        );
});

angular.module("app").config(['$qProvider', function ($qProvider) {
    $qProvider.errorOnUnhandledRejections(false);
}]);
