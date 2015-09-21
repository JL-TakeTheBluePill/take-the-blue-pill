'use strict';

angular.module('bluepillbingoApp')
    .controller('MainController', function ($scope, Principal, BingoGame) {
        Principal.identity().then(function(account) {
            $scope.account = account;
            $scope.isAuthenticated = Principal.isAuthenticated;
        });

        $scope.game = function() {
            $scope.currentGame = BingoGame.game();
        }

        $scope.draw = function () {
            $scope.drawnProduct = BingoGame.draw();
        };

        $scope.currentGame = BingoGame.game();
        $scope.drawnProduct = BingoGame.draw();

        $scope.testVal = "bingo balls";
    });
