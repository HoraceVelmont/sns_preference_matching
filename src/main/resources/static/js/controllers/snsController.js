angular.module("app").constant("dataUrl", "/persons").config(function($httpProvider){
    $httpProvider.defaults.withCredentials = true;
}).controller("snsController", function ($scope, $http, dataUrl) {
    $scope.data = {};
    $scope.data.persons = [];
    $http.get(dataUrl).then(function successCallback(data) {
        $scope.data.persons = data;
    }, function errorCallback(data) {
        $scope.data.error = error;
        console.log(error);
    });

    $scope.slot = [];
    var nullPerson = {"name": "친구를 선택해 주세요", "id": 0, "imageUrl": "slot.jpg"};
    $scope.slot[0] = {};
    $scope.slot[1] = {};
    $scope.slot[0] = nullPerson;
    $scope.slot[1] = nullPerson;


    $scope.matchUnClickable =function(){
        return ($scope.slot[0].id===0 || $scope.slot[1].id===0)
    }


    $scope.addSlot = function (person) {
        if ($scope.slot[0].id === 0) {
            if ($scope.slot[1].id !== person.id)
                $scope.slot[0] = person;
        } else {
            if($scope.slot[0].id !== person.id)
                $scope.slot[1] = person;
        }
    }

    $scope.removeSlot = function (index) {
        $scope.slot[index] = nullPerson;
    }

    $scope.resetSlot = function () {
        $scope.slot[0] = nullPerson;
        $scope.slot[1] = nullPerson;
    }

    $scope.setFirstSlot = function (person) {
        $scope.slot[0] = person;
    }
});
