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

        $scope.toggleBingoCardProduct = function(product) {
            if (!product.checked && !$scope.drawnProduct) {
                alert("Calm down idiot, wait for the tombola!");
                return;
            }

            product.checked = !product.checked;
        }

        $scope.checkForFullHouse = function() {
            var products = $scope.currentGame.cards[0].products;
            var checkedProductIds = [];

            for (var i=0; i<products.length; i++) {
                if (products[i].checked)
                    checkedProductIds.push(products[i].id);
            }

            BingoGame.checkForFullHouse(checkedProductIds).then(function (response) {
                console.log("checkForFullHouse response: ", response.data);
                $scope.fullHouseCheckOutcome = response.data;

                if(response.data) {
                    alert("We have a winner!");
                } else {
                    alert("Hold your horses!");
                }
            });
        };

        $scope.currentGame = $scope.game();
    });
