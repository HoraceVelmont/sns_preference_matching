// alternate - https://github.com/michaelbromley/angularUtils/tree/master/src/directives/pagination
// alternate - https://fdietz.github.io/recipes-with-angular-js/common-user-interface-patterns/paginating-through-client-side-data.html

angular.module("app").controller('pagingController', ['$scope', '$filter', function ($scope, $filter) {
    $scope.currentPage = 0;
    $scope.pageSize = 4;
    $scope.q = '';
    $scope.datum = [];
    $scope.getData = function () {
        var arr = [];
        if ($scope.q === '') {
            arr = $scope.data.persons.data;
        } else {
            for (var ea in $scope.data.persons.data) {
                if ($scope.data.persons.data[ea].indexOf($scope.q) > -1) {
                    arr.push($scope.data.persons.data[ea]);
                }
            }
        }
        return arr;
    }

    $scope.numberOfPages = function () {
        if(angular.isUndefined($scope.getData()))
            return 0;
        return Math.ceil($scope.getData().length / $scope.pageSize);
    }

}]);

angular.module("app").filter('startFrom', function () {
    return function (input, start) {
        if (!input || !input.length) {
            return;
        }
        start = +start; //parse to int
        return input.slice(start);
    }
});
