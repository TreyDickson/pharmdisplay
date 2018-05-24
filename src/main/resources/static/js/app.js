angular.module("pharmDisplay",[]).controller("MainController", ['$interval', '$http', '$scope', function($interval, $http, $scope) {
    $scope.ready = [];
    $scope.received = [];

    $interval(function() {
        find();
    }, 5000);

    function find() {
        $http.get("/find/ready").then(function(result) {
            $scope.ready = result.data;
        });

        $http.get("/find/received").then(function(result) {
            $scope.received = result.data;
        });
    }

    find();

}]).controller("AdminController", ['$interval', '$http', '$scope', function($interval, $http, $scope) {
    $scope.users = [];

    $scope.newUser = {name : "", status: ""};

    $scope.add = function() {
        if($scope.newUser.name) {
            $scope.newUser.status = "received";
            $http.post("/save", $scope.newUser).then(function() {
               $scope.newUser.name = "";
            });

        }
    };

    $scope.ready = function(user) {
        user.status = "ready";
        $http.post("/save", user);
    };

    $scope.remove = function(user) {
        $http.get("/delete/" + user.id);
    };

    $interval(function() {
        findAll();
    }, 1000);

    function findAll() {
        $http.get("/find/all").then(function(result) {
            $scope.users = result.data;
        });
    }

    findAll();
}]);