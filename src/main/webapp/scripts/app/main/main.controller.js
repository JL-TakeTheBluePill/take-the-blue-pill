'use strict';

angular.module('bluepillbingoApp')
    .controller('MainController', function ($scope, Principal, BingoGame) {
        Principal.identity().then(function(account) {
            $scope.account = account;
            $scope.isAuthenticated = Principal.isAuthenticated;
        });

        $scope.game = function() {
             BingoGame.game().then(function (response) {
                console.log("Fetched game: ", response.data);
                $scope.currentGame = response.data;
            });
        }

        $scope.draw = function () {
            BingoGame.draw().then(function (response) {
                console.log("Fetched draw: ", response.data);
                $scope.drawnProduct = response.data;
            });
        };

        $scope.currentGame = $scope.game();
        //$scope.drawnProduct = BingoGame.draw();

        $scope.testVal = "bingo balls";
    });
